package cn.com.start.AppAPI.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import cn.com.start.AppAPI.controller.ScanChargeController;
import cn.com.start.AppAPI.dto.ChargeInfo;
import cn.com.start.AppAPI.dto.ChargeParamDto;
import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.AppAPI.entity.BillModelInfo_API;
import cn.com.start.AppAPI.util.jpush.PushExample;
import cn.com.start.AppAPI.util.jpush.PushPayload;
import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.CPModel_DPF;
import cn.com.start.DPF.entity.DCYcRunRecord;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.socket.CreateByte;
import cn.com.start.webBack.util.GetMainDCQYCData;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class ScanChargeUtile {
    private static Logger logger = LogManager.getLogger("LOG_API");

    public static final String SCG_KEY = "_SCG";
    private static final String ECG_KEY = "_ECG";
    public static final String SEND_TIME = "sendTime";
    public static final String READ_TIME = "readTime";
    public static final String CHILD_STATUS_KEY = "status";
    public static final String COMMAND_KEY = "command";
    public static final String BIND_USER_DEVICE = "BIND_USER_DEVICE";
    public static final String ECSTATE_KEY = "_ECGResult";
    private static final String SCG_STATE_KEY = "_SCGResult";
    private static final String SUCCESS_KEY = "success";

    // 截去最后2位抢号
    public static String subStringDeviceId(String src) {
        if (src.length() > 2) {
            String type = src.substring(src.length() - 2, src.length());
            src = src.substring(0, src.length() - 2);
        }
        return src;
    }

    public static void setParamToRedis(ChargeParamDto param, int cpType) {
        String gun = param.deviceId.substring(param.deviceId.length() - 1,
                param.deviceId.length());
        String deviceId = subStringDeviceId(param.deviceId);
        logger.info("setParamToRedis,gun:" + gun);

        // 保存设置参数
        HashMap map = new HashMap();
        map.put("deviceId", deviceId);
        map.put("gun", gun);
        map.put("mode", param.payMode);
        map.put("value", param.payValue);
        map.put("userId", param.userId);
        map.put("remainSum", param.remainSum);
        map.put(SEND_TIME, CreateByte.getCurrTime());
        map.put("command", "");

        logger.info("param.chargeMode:" + param.chargeMode);
        if (cpType == 0 && param.chargeMode != null) {
            //直流电压0:12V,1:24V
            map.put("chargeDcMode", param.chargeMode);
        }

        logger.info("mode:" + param.payMode + ",value:" + param.payValue
                + ",remainSum:" + param.remainSum);
        StringBuffer sb = new StringBuffer();
        sb.append(deviceId).append("_").append(gun).append(SCG_KEY);
        RedisHandle.setMap(sb.toString(), map);
        logger.info("setParamToRedis,map:" + map);
    }

    // 开始命令
    public static void setStartCommand(String deviceId, String userId,
                                       String gun) {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(deviceId).append("_").append(gun).append(SCG_KEY);
        RedisHandle.setString(sbuf.toString(), COMMAND_KEY, "start");

        RedisHandle.setKeyTime(sbuf.toString(), 600);
    }

    // 清空命令
    public static void clearCommand(String mainKey) {
        RedisHandle.setString(mainKey, COMMAND_KEY, "overdue");
    }

    // 开始失败
    public static void startFail(HttpServletResponse response, String deviceId,
                                 String gun) {
        JsonReDto ReDto = new JsonReDto();
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(deviceId).append("_").append(gun).append(SCG_KEY);
        clearCommand(sbuf.toString());

        try {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "startCharge failed";
            send(response, ReDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 开始等待
    public static String whileDeal(StringBuffer stateMainKey, String field,
                                   int counts) {
        String status = "";
        int count = 0;
        try {
            while (count++ < counts) {
                Thread.sleep(500);

                status = RedisHandle.getString(stateMainKey.toString(), field);
                // logger.info("status in while:" + status);

                if (status != null && SUCCESS_KEY.equals(status)) {
                    logger.info("whileDeal break:" + status);
                    break;
                }

            }
            RedisHandle.setString(stateMainKey.toString(), READ_TIME,
                    CreateByte.getCurrTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("whileDeal  status:" + status + "count:" + count);
        return status;
    }

    /**
     * 充电桩状态
     *
     * @param cpId
     * @return
     */
    public static final int getCpState(String cpId) {
        int cpType = ScanChargeUtile.getCptype(cpId);
        int state = 0;
        if (cpType == 0) {
            String cpState = RedisHandle.getString(cpId + "_QYX_DATA_0", "SDATA");
            if (cpState != null) {
                cpState = cpState.substring(0, 4);
                logger.info("dc cpState:" + cpState);
                state = GetMainDCQYCData.getTypeIdByString(cpState);
            }
        } else {
            // 3,4充电中，故障情况
            String cpState = RedisHandle.getString(cpId + "_QYC_DATA_21", "DATA");
            if (cpState != null) {
                logger.info("ac cpState:" + cpState);
                Double v = Double.valueOf(cpState);
                state = (new Double(v)).intValue();
            }
        }
        return state;
    }


    /**
     * // 交流定义 0 空闲 3充电 4 完成 5故障 6告警
     *
     * @param cpId
     * @return
     */
    public static final int getDcpileState(String cpId) {
        int state = 5;

        if (cpId == null) {
            return state;
        }

        DCYcRunRecord dcycRecord = DataRelay.sychroDCYCMap.get(cpId);
        if (dcycRecord == null) {
            return state;
        }

        state = GetMainDCQYCData.getTypeIdByString(dcycRecord.getCPSTATE());

        return state;
    }

    public static String handleVoltageByAgun(String cpId, String key) {
        final String DATA_KEY = "DATA";
        // 4号协议
        // A抢A,B,C相电压
        String voltageA = RedisHandle.getString(cpId + key, DATA_KEY);
        // String voltageB = RedisHandle.getString(cpId + "_QYC_DATA_3",
        // DATA_KEY);
        // String voltageC = RedisHandle.getString(cpId + "_QYC_DATA_5",
        // DATA_KEY);

        try {

            if (voltageA != null && Double.valueOf(voltageA) > 0) {
                return voltageA;
            }

            // if (voltageB != null && Double.valueOf(voltageB) > 0) {
            // return voltageB;
            // }
            //
            // if (voltageC != null && Double.valueOf(voltageC) > 0) {
            // return voltageC;
            // }
        } catch (Exception e) {
        }

        return "0";
    }

    public static String handleCurrentByAgun(String cpId, String key) {

        final String DATA_KEY = "DATA";
        // 4号协议
        // A抢A,B,C相电流
        String currentA = RedisHandle.getString(cpId + key, DATA_KEY);
        // String currentB = RedisHandle.getString(cpId + "_QYC_DATA_9",
        // DATA_KEY);
        // String currentC = RedisHandle.getString(cpId + "_QYC_DATA_11",
        // DATA_KEY);

        try {

            if (currentA != null && Double.valueOf(currentA) > 0) {
                return currentA;
            }

            // if (currentB != null && Double.valueOf(currentB) > 0) {
            // return currentB;
            // }
            //
            // if (currentC != null && Double.valueOf(currentC) > 0) {
            // return currentC;
            // }

        } catch (Exception e) {
        }

        return "0";
    }

    // 绑定用户设备
    public static void bindUserAndDevice(String userId, String deviceId) {
        // 绑定userId和device
        RedisHandle.setString(BIND_USER_DEVICE, userId, deviceId);
    }

    public static void pushAlias(String alias) {
        PushPayload payload = PushExample.buildPushObject_all_alias_alert(
                alias, "充电已完成");
        PushExample.testSendPushWithCustomConfig(payload);
    }

    public static String getCpIdByDeviceID(String deviceId) {
        return DataRelay.devicecpMap.get(deviceId);
    }

    public static String getCpIdByUserID(String userid) {
        String deviceId = ScanChargeUtile.getDeviceId(userid);
        return DataRelay.devicecpMap.get(deviceId);
    }

    // 根据userId获取设备号
    public static String getDeviceId(String userId) {
        String deviceId = RedisHandle.getString(BIND_USER_DEVICE, userId);
        if (deviceId == null) {
            logger.info("设备号异常");
            return "";
        }

        deviceId = deviceId.substring(0, deviceId.length() - 2);
        return deviceId;
    }

    // 根据用户获取枪
    public static String getGunById(String userId) {
        String deviceId = RedisHandle.getString(BIND_USER_DEVICE, userId);
        if (deviceId == null) {
            logger.info("getGunById 获取设备异常");
            return "";
        }

        String gun = deviceId.substring(deviceId.length() - 1,
                deviceId.length());
        logger.info("getGunById gun:" + gun);
        return gun;
    }

    // 停止命令
    public static void stopScgCommand(String userId, String deviceId, String gun) {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(deviceId).append("_").append(gun).append(ECG_KEY);

        // tell stop
        RedisHandle.setString(sbuf.toString(), "deviceId", deviceId);
        RedisHandle.setString(sbuf.toString(), "gun", gun);
        RedisHandle.setString(sbuf.toString(), "userId", userId);
        RedisHandle.setString(sbuf.toString(), COMMAND_KEY, "stop");
        RedisHandle.setKeyTime(sbuf.toString(), 600);
    }

    public static void stopFail(HttpServletResponse response, String deviceId,
                                String gun) {
        JsonReDto ReDto = new JsonReDto();
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(deviceId).append("_").append(gun).append(SCG_KEY);
        clearCommand(sbuf.toString());

        try {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "startCharge failed";

            send(response, ReDto);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void sendSms(String mode, String telephone, String content) {
        TaobaoClient client = new DefaultTaobaoClient(Constant.ALIDAYU_URL,
                Constant.ALIDAYU_APPKEY, Constant.ALIDAYU_SECRET);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName(Constant.ALIDAYU_SIGN);
        req.setSmsParamString(content);
        req.setRecNum(telephone);
        req.setSmsTemplateCode(mode);

        AlibabaAliqinFcSmsNumSendResponse rsp;
        try {
            rsp = client.execute(req);
            logger.info(rsp.getBody());
        } catch (ApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 获取区段价格
     *
     * @param bill
     * @param minute
     * @return
     */
    public static int getTag(BillModelInfo_API bill, int minute) {
        int zz[] = new int[10];
        int i = 0, k = Integer.parseInt(bill.getTIMEINTERVALCOUNT());      
    	if(i < k){zz[i++] = bill.getTI_1_START();} 
    	if(i < k){zz[i++] = bill.getTI_2_START();}
    	if(i < k){zz[i++] = bill.getTI_3_START();}
    	if(i < k){zz[i++] = bill.getTI_4_START();}
    	if(i < k){zz[i++] = bill.getTI_5_START();}
    	if(i < k){zz[i++] = bill.getTI_6_START();}
    	if(i < k){zz[i++] = bill.getTI_7_START();}
    	if(i < k){zz[i++] = bill.getTI_8_START();}
    	int tag = 0;
    	int temp = 0;
    	for(i = 0; i < k; i++){
    		//System.out.println("zzzz="+zz[i]);
    		if(zz[i] <= minute && zz[i+1] >= minute){
    			temp = i+1;
    			break;
    		}
    		if(zz[i] >= minute || zz[k-1] <= minute){
    			temp = k;
    			break;
    		}
    	}
    	System.out.println("temp = "+temp);
    	if(temp == 1){tag = bill.getTI_1_ID();}
    	else if(temp == 2){tag = bill.getTI_2_ID();}
    	else if(temp == 3){tag = bill.getTI_3_ID();}
    	else if(temp == 4){tag = bill.getTI_4_ID();}
    	else if(temp == 5){tag = bill.getTI_5_ID();}
    	else if(temp == 6){tag = bill.getTI_6_ID();}
    	else if(temp == 7){tag = bill.getTI_7_ID();}
    	else {tag = bill.getTI_8_ID();};
        return tag;
    }

    public static int getGunState(String key, String deviceId) {
        String cpId = ScanChargeUtile.getCpIdByDeviceID(deviceId);
        String cpState = RedisHandle.getString(cpId + key, "DATA");
        int type = 0;
        if(cpState != null){
            Double v = Double.valueOf(cpState);
            type = (new Double(v)).intValue();
            logger.info("getGunState cpState:" + cpState+",return value:"+type);
        }

        return type;
    }

    /**
     * @param gun
     * @param deviceId
     * @param cpId
     * @return
     */
    public static final int getStartState(String gun, String deviceId,
                                          String cpId) {
        int state = 0;

        int cpType = ScanChargeUtile.getCptype(cpId);
        logger.info("充电桩类型（直交）:"+cpType);

        if (cpType == 0) {
            StringBuffer mainKey = new StringBuffer();
            mainKey.append(deviceId).append("_").append(gun)
                    .append(SCG_STATE_KEY);
            logger.info("mainKey:" + mainKey.toString());
            String dcStatus = whileDeal(mainKey, CHILD_STATUS_KEY, 20);
            if (SUCCESS_KEY.equals(dcStatus)) {
                state = 3;
            } else {
                state = 0;
            }
        } else {
            int counts = 0;
            int authorizationCounts = 0;

            try {
                while (++counts < 20) {
                    if ("0".equals(gun)) {
                        state = ScanChargeUtile.getGunState("_QYC_DATA_21",
                                deviceId);
                        logger.info("A枪状态：" + state);
                    } else if ("1".equals(gun)) {
                        state = ScanChargeUtile.getGunState("_QYC_DATA_22",
                                deviceId);
                        logger.info("B枪状态：" + state);

                    }

                    if (state == 1) {
                        break;
                    } else if (state == 3) {
                        break;
                    }

                    Thread.sleep(500);

                    if (state == 2) {
                        continue;
                    }

                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return state;
    }

    /**
     * 0:直流， 1：交流
     *
     * @param cpId
     * @return
     */
    public static final int getCptype(String cpId) {
        int cpType = 1;
        if (DataRelay.cpMap == null || cpId == null) {
            return cpType;
        }
        CPInfo_DPF cpInfo = DataRelay.cpMap.get(cpId);
        if (cpInfo != null) {
            StringBuffer sb = new StringBuffer();
            sb.append(cpInfo.MFRID).append("_").append(cpInfo.MODEL);
            if (DataRelay.modelMap != null) {
                CPModel_DPF pileTypeInfo = DataRelay.modelMap
                        .get(sb.toString());
                
                if(pileTypeInfo != null){
                	cpType = pileTypeInfo.CPTYPE;
                }
                
            }
        }
        return cpType;
    }

    /**
     * @param dto
     * @param cpId
     * @return
     */
    public static final ChargeInfo getAcChargeInfo(ChargeInfo dto, String cpId) {
        final String DATA_KEY = "DATA";

        dto.voltageA = ScanChargeUtile.handleVoltageByAgun(cpId, "_QYC_DATA_1");
        dto.voltageB = ScanChargeUtile.handleVoltageByAgun(cpId, "_QYC_DATA_3");
        dto.voltageC = ScanChargeUtile.handleVoltageByAgun(cpId, "_QYC_DATA_5");
        dto.currentA = ScanChargeUtile.handleCurrentByAgun(cpId, "_QYC_DATA_7");
        dto.currentB = ScanChargeUtile.handleCurrentByAgun(cpId, "_QYC_DATA_9");
        dto.currentC = ScanChargeUtile
                .handleCurrentByAgun(cpId, "_QYC_DATA_11");

        dto.quantity = RedisHandle.getString(cpId + "_QYC_DATA_13", DATA_KEY);
        if (dto.quantity == null) {
            dto.quantity = "";
        }
        dto.fee = RedisHandle.getString(cpId + "_QYC_DATA_15", DATA_KEY);
        // 充电时长
        String chargeDuration = RedisHandle.getString(cpId + "_QYC_DATA_19",
                DATA_KEY);
        if (chargeDuration != null) {
            double chargeTime = Math.floor(Double.valueOf(chargeDuration));
            int value = (new Double(chargeTime)).intValue();
            dto.chargeDuration = String.valueOf(value);
        }

        return dto;
    }

    /**
     * @param dto
     * @param cpId
     * @return
     */
    public static final ChargeInfo getDcChargeInfo(ChargeInfo dto, String cpId) {
        final String DATA_KEY = "DATA";

        dto.voltageA = ScanChargeUtile.handleVoltageByAgun(cpId, "_QYC_DATA_1");
        dto.currentA = ScanChargeUtile.handleCurrentByAgun(cpId, "_QYC_DATA_2");

        dto.quantity = RedisHandle.getString(cpId + "_QYC_DATA_10", DATA_KEY);
        if (dto.quantity == null) {
            dto.quantity = "";
        }
        dto.soc = RedisHandle.getString(cpId + "_QYC_DATA_3", DATA_KEY);
        dto.fee = RedisHandle.getString(cpId + "_QYC_DATA_12", DATA_KEY);
        // 充电时长
        String chargeDuration = RedisHandle.getString(cpId + "_QYC_DATA_13",
                DATA_KEY);
        if (chargeDuration != null) {
            double chargeTime = Math.floor(Double.valueOf(chargeDuration));
            int value = (new Double(chargeTime)).intValue();
            dto.chargeDuration = String.valueOf(value);
        }

        return dto;
    }

    /**
     * @param response
     * @param cpId
     * @param gun
     * @throws IOException
     */
    public static final boolean getPileState(HttpServletResponse response,
                                          String cpId, String gun) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String stateTime = RedisHandle.getTString(cpId + "_QYC_DATA_TIME");
        if(stateTime != null){
            long time = System.currentTimeMillis() - Long.valueOf(stateTime);
            logger.info("startCharge, cpId:" + cpId + ",time:" + time);
            // 充电桩离线
            if (time > (90 * 1000)) {
                logger.info("充电桩离线");

                ReDto.returnCode = Constant.PILE_OFFLINE_STATE;
                ReDto.errorCode = "";
                ReDto.message = "充电桩离线";
                ScanChargeController.send(response, ReDto);

                return false;
            }
        }


        if (gun.isEmpty()) {
            logger.info("枪异常");

            ReDto.returnCode = Constant.OTHER_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return false;
        }
        
        return true;
    }

    public static <T> void send(HttpServletResponse response, T ReDto)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ReDto);
        logger.info(json);
        // 向页面返回json数据
        out.print(json);
        out.flush();
        out.close();
    }

}

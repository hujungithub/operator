package cn.com.start.AppAPI.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.start.AppAPI.dto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.service.ScanChargeService;
import cn.com.start.AppAPI.util.Constant;
import cn.com.start.AppAPI.util.EmptyUtil;
import cn.com.start.AppAPI.util.ScanChargeUtile;
import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.dto.ChargeOver_DPF;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.carddata.CardShortMessage;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.socket.CreateByte;

/**
 * @author caijie
 */
@Controller
@RequestMapping("/scanCharge")
public class ScanChargeController {
    private static Logger logger = LogManager.getLogger("LOG_API");

    private String SERVICE_ADDRESS = "192.168.8.132";
    private int SERVICE_PORT = 6379;
    private boolean bGunType;
    private final String STATUS_KEY = "_ChargeOver";
    private final String ECSTATE_KEY = "_ECGResult";

    private final String SEND_TIME = "sendTime";
    private final String READ_TIME = "readTime";

    private final String CHILD_STATUS_KEY = "status";
    private final String CHILD_TIME_KEY = "time";
    private final String CHILD_SERIALNO_KEY = "serialNo";
    private final String FAILED_STATUS = "failed";
    private final String SUCCESS_STATUS = "success";
    private final String COMMAND_KEY = "command";
    private final int CHARGE_FINISH_TIMEOUT = 20;
    private final int STOP_CHARGE_TIMEOUT = 10;

    // 返回错误类型
    private final int QR_ERROR = 1;
    private final int CAR_DISCONNECT = 2;

    // 记录充电单价，和deviceId
    private final String BIND_USER_DEVICE = "BIND_USER_DEVICE";
    @Autowired
    private ScanChargeService scanChargeService;

    @RequestMapping("/chargeOver")
    @ResponseBody
    public void testSend(@RequestBody ChargeOver_DPF cOver_DPF)
            throws IOException {
        if (cOver_DPF == null)
            return;

        logger.info(cOver_DPF.toString());
        String serialNo = cOver_DPF.getSerialNo();
        if (serialNo != null) {
            if (cOver_DPF.getChargemethod() == 0) {
                String userId = cOver_DPF.getCpuserid();
                sendAppMessage(userId, serialNo);
            } else {
                sendCardMessage(serialNo);
            }

        } else {
            logger.info("发送短信失败");
        }
    }

    @RequestMapping("/unException")
    @ResponseBody
    public void unException(@RequestBody ChargeOver_DPF cOver_DPF)
            throws IOException {
        logger.info("scanCharge unException");

    }

    @RequestMapping("/notifyUserCard")
    @ResponseBody
    public void notifyUserCard(@RequestBody CardShortMessage cardMessage)
            throws IOException {

        System.out.println("notifyUserCard:" + cardMessage.toString());

        if (cardMessage != null) {
            String content = "{\"cardnum\":\"" + cardMessage.getTELEPHONE()
                    + "\",\"time\":\"" + cardMessage.getTIME()
                    + "\",\"money\":\"" + cardMessage.getMONEY()
                    + "\",\"sum\":\"" + cardMessage.getACCOUNTSUM() + "\"}";
            logger.info(content);
            ScanChargeUtile.sendSms(Constant.ALIDAYU_SMS_CARD,
                    cardMessage.getTELEPHONE(), content);

            JsonReDto ReDto = new JsonReDto();
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "notifyUserCard success";
        } else {
            logger.info("充值卡发送短信失败");
        }
    }

    @RequestMapping("/resetUser")
    public void resetUser(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        JsonReDto ReDto = new JsonReDto();
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }
        logger.info("重置用户充电状态");
        scanChargeService.updateUserStateIdle(userId);

        ReDto.returnCode = 0;
        ReDto.errorCode = "";
        ReDto.message = "resetUser success ";

        send(response, ReDto);
    }

    /**
     * 设置充电模式
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/setChargeMode")
    public void setChargeMode(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        ChargeParamDto chargeParam = new ChargeParamDto();

        chargeParam.deviceId = request.getParameter("deviceId");
        chargeParam.gun = request.getParameter("gun");
        chargeParam.payMode = request.getParameter("payMode");
        chargeParam.payValue = request.getParameter("payValue");
        chargeParam.userId = request.getParameter("userId");
        chargeParam.remainSum = request.getParameter("remainSum");
        //直流mode
        chargeParam.chargeMode = request.getParameter("dcChargeMode");
        logger.info("dcChargeMode:"+chargeParam.chargeMode);


        if (chargeParam.deviceId == null || chargeParam.payMode == null
                || chargeParam.payValue == null || chargeParam.userId == null
                || chargeParam.remainSum == null) {

            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        logger.info("setChargeMode绑定用户userId:" + chargeParam.userId
                + ",deviceId:" + chargeParam.deviceId);
        // 绑定用户设备
        ScanChargeUtile.bindUserAndDevice(chargeParam.userId,
                chargeParam.deviceId);

        String deviceId = ScanChargeUtile
                .subStringDeviceId(chargeParam.deviceId);

        String cpId = ScanChargeUtile.getCpIdByDeviceID(deviceId);
        logger.info("setChargeMode cpId:" + cpId);


        //set param
        if (cpId != null) {
            int cpType = ScanChargeUtile.getCptype(cpId);
            ScanChargeUtile.setParamToRedis(chargeParam, cpType);
        }


        // 若为空 提示信息
        if (EmptyUtil.isStringEmpty(cpId)) {
            ReDto.returnCode = 2;
            ReDto.errorCode = "E0001";
            ReDto.message = "You should set parament[cpid]";
        } else {
            // 查询返回
            CPInfo_DPF cpInfo = DataRelay.cpMap.get(cpId);
            if (cpInfo != null) {
                List<ScanChargeDto> cpList = scanChargeService.findChargeInfo(
                        cpId, String.valueOf(cpInfo.getOPERATORID()));
                if (cpList.isEmpty()) {
                    ReDto.returnCode = 1;
                    ReDto.errorCode = "E0002";
                    ReDto.message = "no data found!";
                } else {
                    ReDto.returnCode = 0;
                    ReDto.errorCode = "E0000";
                    ReDto.message = "get chargePile Info success ";
                    ReDto.detail.put("cp", cpList);
                }
            }

        }
        this.send(response, ReDto);
    }

    /**
     * 基础信息
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getPileBaseInfo")
    public void getPileBaseInfo(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        PileBaseInfoJsonReDto ReDto = new PileBaseInfoJsonReDto();
        String userId = request.getParameter("userId");
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        String cpId = ScanChargeUtile.getCpIdByUserID(userId);
        if (cpId != null) {
            //cptype
            ReDto.cpType = ScanChargeUtile.getCptype(cpId);

            if (DataRelay.cpMap != null) {
                CPInfo_DPF cpInfo = DataRelay.cpMap.get(cpId);
                if (cpInfo != null) {
                    //base pile info
                    List<ScanChargeDto> cpList = scanChargeService.findChargeInfo(cpId,
                            String.valueOf(cpInfo.getOPERATORID()));
                    if (cpList.isEmpty()) {
                        ReDto.returnCode = 1;
                        ReDto.errorCode = "E0002";
                        ReDto.message = "no data found!";
                    } else {
                        ReDto.returnCode = 0;
                        ReDto.errorCode = "E0000";
                        ReDto.message = "getPileBaseInfoo success ";
                        ReDto.detail.put("cp", cpList);
                    }
                }
            }
        }

        ScanChargeController.send(response, ReDto);
    }

    /**
     * 充电订单详情
     */
    @RequestMapping("/chargeRecorder")
    public void chargeRecorder(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String serialNo = request.getParameter("serialNo");
        ChargeRecorderResDto ReDto = new ChargeRecorderResDto();

        if (serialNo == null) {
            logger.info("chargeRecorder serialNo == null");
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        logger.info("chargeRecorder serialNo:" + serialNo);
        List<ChargeRecorder> recorder = scanChargeService
                .chargeRecorder(serialNo);

        if (recorder != null && recorder.size() > 0) {
            logger.info("chargeRecorder success:"+recorder.get(0).toString());
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "chargeRecorder success";
            ReDto.dto = recorder.get(0);
        } else {
            logger.info("chargeRecorder 没有查到本次的充电记录");
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "";
        }

        ScanChargeController.send(response, ReDto);
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("isChargePile")
    public void isChargePile(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        CpinfoFromDeviceDto ReDto = new CpinfoFromDeviceDto();
        String deviceId = request.getParameter("deviceId");
        String gun = deviceId.substring(deviceId.length() - 1,
                deviceId.length());
        deviceId = ScanChargeUtile.subStringDeviceId(deviceId);
        logger.info("deviceId:" + deviceId);

        if (deviceId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        if (DataRelay.devicecpMap == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = "devicecpMap错误";
            ScanChargeController.send(response, ReDto);
        	
            return;
        }

        String cpId = DataRelay.devicecpMap.get(deviceId);
        if (cpId != null) {
            judgePileState(cpId, response, deviceId, gun);
        }else{
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = "二维码错误";
            ScanChargeController.send(response, ReDto);
        }
        
        // 处理充电桩的状态
//		ScanChargeUtile.getCpState(response, cpId);
    }

    /**
     * 点击开始充电，将充电设置发送过来
     *
     * @throws IOException ********
     */
    @RequestMapping("startCharge")
    public void startCharge(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        String deviceId = request.getParameter("deviceId");
        String userId = request.getParameter("userId");

        if (userId == null) {
            JsonReDto ReDto = new JsonReDto();
            logger.info("开始充电失败，userId为空");

            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        String cpId = ScanChargeUtile.getCpIdByUserID(userId);
        // get gun
        String gun = ScanChargeUtile.getGunById(userId);
        boolean okStatus = ScanChargeUtile.getPileState(response, cpId, gun);
        if(!okStatus){
        	return;
        }
        
        
        // start command
        deviceId = ScanChargeUtile.subStringDeviceId(deviceId);
        ScanChargeUtile.setStartCommand(deviceId, userId, gun);

        //返回充电桩状态
        int state = ScanChargeUtile.getStartState(gun, deviceId, cpId);
        responseStartCommand(response, state, userId);
    }


    // 手动结束，获取流水号
    @RequestMapping("getSerialNo")
    public void getSerialNo(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        SerialNo ReDto = new SerialNo();
        String userId = request.getParameter("userId");

        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        String deviceId = ScanChargeUtile.getDeviceId(userId);
        // logger.info("根据userId:" + userId + ",获取deviceId:" + deviceId);
        if (deviceId.isEmpty()) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = "没有找到设备";
            ScanChargeController.send(response, ReDto);
            return;
        }

        String gun = ScanChargeUtile.getGunById(userId);
        if (gun.isEmpty()) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = "没有找到枪";
            ScanChargeController.send(response, ReDto);
            return;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(deviceId).append("_").append(gun).append(STATUS_KEY);
        String status = ScanChargeUtile.whileDeal(sb, CHILD_STATUS_KEY,
                CHARGE_FINISH_TIMEOUT);
        if ("finish".equals(status)) {
            String serialNo = RedisHandle.getString(sb.toString(), "serialNo");

            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "";
            ReDto.serialNo = serialNo;

        } else {
            ReDto.returnCode = 1;
            ReDto.errorCode = "";
            ReDto.message = "流水号获取失败";
        }

        ScanChargeController.send(response, ReDto);
    }
    
    @RequestMapping("testBill")
    public void testBill(){
    	String price = scanChargeService.culatePrice("1", "120");
    	System.out.println("testBill = " + price);
    }
    
    /*
     * 获取充电状态
     */
    @RequestMapping("getChargeStatus")
    public void getChargeStatus(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        // String deviceId = request.getParameter("deviceId");
        String userId = request.getParameter("userId");

        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }
        
        String cpId = ScanChargeUtile.getCpIdByUserID(userId);

        // 若为空 提示信息
        if (EmptyUtil.isStringEmpty(cpId)) {
            ReDto.returnCode = 2;
            ReDto.errorCode = "E0001";
            ReDto.message = "You should set parament[cpId]";
        } else {
            String deviceId = ScanChargeUtile.getDeviceId(userId);
            logger.info("根据userId:" + userId + ",获取deviceId:" + deviceId);
            if (deviceId.isEmpty()) {
                return;
            }

            ChargeInfo dto = getChargeInfo(deviceId, userId, cpId);
            // price
            List<ChargeInfo> chargeDataList = new ArrayList<ChargeInfo>();
            CPInfo_DPF cpInfo = DataRelay.cpMap.get(cpId);
            if (cpInfo != null) {
                String rateId = String.valueOf(cpInfo.getRATEID());
                String operatorId = String.valueOf(cpInfo.getOPERATORID());
                dto.price = scanChargeService.culatePrice(rateId, operatorId);
            }
            chargeDataList.add(dto);
            ReDto.returnCode = 0;
            ReDto.errorCode = "";
            ReDto.message = "";
            ReDto.detail.put("chargeInfo", chargeDataList);
        }

        send(response, ReDto);

    }

    /*
     * 结束充电
     */
    @RequestMapping("stopCharge")
    public void stopCharge(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        JsonReDto ReDto = new JsonReDto();
        String userId = request.getParameter("userId");
        if (userId == null) {
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            ScanChargeController.send(response, ReDto);
            return;
        }

        // deviceId
        String deviceId = ScanChargeUtile.getDeviceId(userId);
        logger.info("根据userId:" + userId + ",获取deviceId:" + deviceId);
        if (deviceId.isEmpty()) {
            return;
        }
        // gun
        String gun = ScanChargeUtile.getGunById(userId);
        if (gun.isEmpty()) {
            return;
        }

        // stop command Ecg
        ScanChargeUtile.stopScgCommand(userId, deviceId, gun);
        // read EcState
        StringBuffer mainKey = new StringBuffer();
        mainKey.append(deviceId).append("_").append(gun).append(ECSTATE_KEY);
        String status = ScanChargeUtile.whileDeal(mainKey, CHILD_STATUS_KEY,
                STOP_CHARGE_TIMEOUT);
        RedisHandle.setString(mainKey.toString(), READ_TIME,
                CreateByte.getCurrTime());

        if (status != null) {
            logger.info("stop status:" + status);
            if (status.equals(SUCCESS_STATUS)) {
                logger.info("stopCharge SUCCESS_STATUS");
                // clear success
                RedisHandle.setString(mainKey.toString(), CHILD_STATUS_KEY,
                        "123");
                RedisHandle.setString(mainKey.toString(), "sendTime",
                        CreateByte.getCurrTime());

                // //流水号
                // StringBuffer sb = new StringBuffer();
                // sb.append(deviceId).append("_").append(gun).append(STATUS_KEY);
                // dto.serialNo = RedisHandle.getString(sb.toString(),
                // "serialNo");

                // pushAlias(userId);

                // 解绑
                // getRedis.getRedis().hdel(BIND_USER_DEVICE, userId);
                scanChargeService.updateUserStateIdle(userId);

                ReDto.returnCode = 0;
                ReDto.errorCode = "";
                ReDto.message = "stopCharge success";
                ScanChargeController.send(response, ReDto);
            } else {
                logger.info("stopCharge FAILED_STATUS");
                ScanChargeUtile.stopFail(response, deviceId, gun);
            }

        } else {
            logger.info("stopCharge NULLLL");
            RedisHandle.setString(mainKey.toString(), CHILD_STATUS_KEY, "123");
            ScanChargeUtile.stopFail(response, deviceId, gun);
        }

    }

    /**
     * @param userId
     */
    private void sendAppMessage(String userId, String serialNo) {
        if (userId != null) {
            logger.info("用户充电结束，设置空闲状态 userId:" + userId);
            scanChargeService.updateUserStateIdle(userId);
        }

        logger.info("充电结束，准备发送短信");
        SmsDto cpUserInfo = scanChargeService.selectUserInfo(serialNo);
        if (cpUserInfo != null) {
            // String content = "{\"name\":\"" + cpUserInfo.telephone +
            // "\",\"time\":\""
            // + cpUserInfo.chargeStartTime + "\",\"money\":\"" +
            // cpUserInfo.totalFee
            // + "\"}";

            String content = "{\"name\":\"" + cpUserInfo.telephone
                    + "\",\"time\":\"" + cpUserInfo.chargeStartTime
                    + "\",\"money\":\"" + cpUserInfo.totalFee
                    + "\",\"remainsum\":\"" + cpUserInfo.accountSum
                    + "\"}";

            logger.info(content + ",phone:" + cpUserInfo.telephone);
            ScanChargeUtile.sendSms(Constant.ALIDAYU_SMS_CHARGEOVER,
                    cpUserInfo.telephone, content);
        }
    }

    /**
     * @param serialNo
     */
    private void sendCardMessage(String serialNo) {
        logger.info("刷卡充电发送消息");
        SmsDto cardUserInfo = scanChargeService.selectCardUserInfo(serialNo);
        if (cardUserInfo != null) {
            Double sum = Double.valueOf(cardUserInfo.accountSum);

            String content = "{\"name\":\"" + cardUserInfo.telephone
                    + "\",\"time\":\"" + cardUserInfo.chargeStartTime
                    + "\",\"money\":\"" + cardUserInfo.totalFee
                    + "\",\"remainsum\":\"" + String.format("%.2f", sum).toString() + "\"}";
            logger.info(content + ",phone:" + cardUserInfo.telephone);
            ScanChargeUtile.sendSms(Constant.ALIDAYU_SMS_CHARGEOVER,
                    cardUserInfo.telephone, content);
        }

    }

    /**
     * @param cpId
     * @param response
     * @param deviceId
     * @param gun
     * @throws IOException
     */
    private void judgePileState(String cpId, HttpServletResponse response, String deviceId, String gun) throws IOException {
        //状态
    	int cpState = ScanChargeUtile.getCpState(cpId);
        logger.info("cpState:"+cpState);
        CpinfoFromDeviceDto ReDto = new CpinfoFromDeviceDto();
        //交流还是直流
        ReDto.cpType = ScanChargeUtile.getCptype(cpId);
        switch (cpState) {
            case 3:
                ReDto.returnCode = Constant.PILE_IS_CHARGING;
                ReDto.errorCode = "";
                ReDto.message = "充电桩已被占用";
                send(response, ReDto);
                break;

            case 5:
            case 6:
                ReDto.returnCode = 4;
                ReDto.errorCode = "";
                ReDto.message = "充电桩故障";
                send(response, ReDto);
                break;


            default:
                DeviceInfoDto_API deviceInfo = scanChargeService
                        .findDeviceInfo(deviceId);
                // System.out.println("deviceInfo:"+deviceInfo.toString());
                if (deviceInfo != null) {
                    // clear finish
                    StringBuffer sb = new StringBuffer();
                    sb.append(deviceId).append("_").append(gun).append(STATUS_KEY);
                    RedisHandle.setString(sb.toString(), CHILD_STATUS_KEY, "123");
                    RedisHandle.setString(sb.toString(), READ_TIME,
                            CreateByte.getCurrTime());
                    ReDto.returnCode = 0;
                    ReDto.errorCode = "";
                    ReDto.message = "isChargePile success";
                    ReDto.cpName = deviceInfo.CPNAME;

                    
                    //返回充电桩信息
                    CPInfo_DPF cpInfo = DataRelay.cpMap.get(cpId); 
                    if (cpInfo != null) {
                        List<ScanChargeDto> cpList = scanChargeService.findChargeInfo(
        				cpId, String.valueOf(cpInfo.getOPERATORID()));
                        if (cpList.isEmpty()) {
                            ReDto.returnCode = 1;
                            ReDto.errorCode = "E0002";
                            ReDto.message = "no data found!";
                        } else {
                            ReDto.returnCode = 0;
                            ReDto.errorCode = "";
                            ReDto.message = "isChargePile success";
                            ReDto.cpName = deviceInfo.CPNAME;
                            ReDto.detail.put("cp", cpList);
                        }
                    }
                    
                    
                } else {
                    ReDto.returnCode = QR_ERROR;
                    ReDto.errorCode = "";
                    ReDto.message = "二维码错误";
                }

                ScanChargeController.send(response, ReDto);

                break;
        }
    }

    /**
     * 实时充电数据
     *
     * @param deviceId
     * @param userId
     * @param cpId
     * @return
     */
    private ChargeInfo getChargeInfo(String deviceId, String userId, String cpId) {
        ChargeInfo dto = new ChargeInfo();

        int cpType = ScanChargeUtile.getCptype(cpId);
        if (cpType == 0) {
            dto = ScanChargeUtile.getDcChargeInfo(dto, cpId);
        } else {
            dto = ScanChargeUtile.getAcChargeInfo(dto, cpId);
        }

        String gun = ScanChargeUtile.getGunById(userId);
        if (gun.isEmpty()) {
            return dto;
        }

        // get chargeover status
        StringBuffer sb = new StringBuffer();
        sb.append(deviceId).append("_").append(gun).append(STATUS_KEY);
        String status = RedisHandle.getString(sb.toString(), "status");
        String time = RedisHandle.getString(sb.toString(), "time");
        RedisHandle.setString(sb.toString(), READ_TIME,
                CreateByte.getCurrTime());
        if (time != null) {
            long t = Long.parseLong(time);
            dto.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date(t));
        }

        // String status = ScanChargeUtile.whileDeal(sb, CHILD_STATUS_KEY);
        // logger.info("getChargeInfo status:"+status);
        // finish
        if (status != null && status.equals("finish")) {
            // 流水号
            dto.serialNo = RedisHandle.getString(sb.toString(), "serialNo");
            logger.info("getChargeStatus  serialNo:" + dto.serialNo);
            // pushAlias(userId);
            scanChargeService.updateUserStateIdle(userId);
            // clear finish
            RedisHandle.setString(sb.toString(), CHILD_STATUS_KEY, "123");
            RedisHandle.setString(sb.toString(), READ_TIME,
                    CreateByte.getCurrTime());
            // 解绑
            // getRedis.getRedis().hdel(BIND_USER_DEVICE, userId);

            // stop charge5
            dto.command = status;

            System.out.println("getChargeStatus finish");
        } else {
            System.out.println("getChargeStatus not finish");
            dto.command = "";
        }

        return dto;
    }

    /**
     *
     * @param response
     * @param state
     * @param userId
     * @throws IOException
     */
    private void responseStartCommand(HttpServletResponse response, int state, String userId) throws IOException{
        JsonReDto ReDto = new JsonReDto();
        switch (state) {
            case 0:
                // 启动失败
                logger.info("启动失败");
                ReDto.returnCode = Constant.START_ERROR_MSG;
                ReDto.errorCode = "";
                ReDto.message = "启动失败";
                ScanChargeController.send(response, ReDto);
                break;
            case 1:
                // 等待插枪
                logger.info("没有插枪");
                ReDto.returnCode = Constant.NO_FOUND_GUN;
                ReDto.errorCode = "";
                ReDto.message = Constant.NO_FOUND_GUN_MESSAGE;
                ScanChargeController.send(response, ReDto);
                break;
            case 2:
                // 等待授权
                logger.info("没有授权");
                ReDto.returnCode = Constant.WAIT_AUTHORIZATION;
                ReDto.errorCode = "";
                ReDto.message = Constant.WAIT_AUTHORIZATION_MESSAGE;
                ScanChargeController.send(response, ReDto);
                break;

            case 5:
                //故障
                logger.info("故障");
                ReDto.returnCode = Constant.CHARGE_PILE_ERROR;
                ReDto.errorCode = "";
                ReDto.message = Constant.CHARGE_PILE_ERROR_MESSAGE;
                ScanChargeController.send(response, ReDto);
                break;


            default:
                logger.info("开始充电");
                scanChargeService.updateUserStateBusy(userId);

                ReDto.returnCode = Constant.RESULT_OK;
                ReDto.errorCode = "";
                ReDto.message = "startCharge success";
                ScanChargeController.send(response, ReDto);
                break;
        }

    }

    public static <T> void send(HttpServletResponse response, T ReDto)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ReDto);
        System.out.println(json);
        // 向页面返回json数据
        out.print(json);
        out.flush();
        out.close();
    }
}

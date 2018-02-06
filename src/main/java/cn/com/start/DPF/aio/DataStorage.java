package cn.com.start.DPF.aio;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.DPF.entity.BillModelInfo_DPF;
import cn.com.start.DPF.entity.BillModelSendRecord;
import cn.com.start.DPF.entity.CPYCRunRecord_104;
import cn.com.start.DPF.entity.CPYXRunRecord_104;
import cn.com.start.DPF.entity.ChargeChangeRecord;
import cn.com.start.DPF.entity.DCYcRunRecord;
import cn.com.start.DPF.entity.DCYxRunRecord;
import cn.com.start.DPF.entity.StartChargeGunRecord;
import cn.com.start.DPF.entity.SwipeCardAutRecord;
import cn.com.start.DPF.entity.YCPointList_DPF;
import cn.com.start.DPF.entity.YXPointList_DPF;
import cn.com.start.DPF.redis.ObjectToMap;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.StringUtil;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class DataStorage {

	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dbOperation = DBOperation.getInstance();
	private static PointData pointData = new PointData(); // 最小点表对象

//	// 充电记录更新入库
//	public static void storageCCRRecord(String cpid, int gun) {
//		ChargeChangeRecord ccRecord = new ChargeChangeRecord();
//		Map<String, String> map = RedisHandle.getMap(DataRelay.cpMap.get(cpid)
//				.getDEVICEID() + "_" + gun + "_CCRecord");
//		if (map == null) {
//			logger.info("找不到那条充电变化state记录");
//			logger.info("");
//		} else {
//			// 拿到对象
//			ccRecord = (ChargeChangeRecord) ObjectToMap.mapToObjectCCR(map);
//			ccRecord.setENDCHARGETIME(CreateByte.getCurrTime());
//			// 更新redis中的endchargetime
//			RedisHandle.setString(DataRelay.cpMap.get(cpid).getDEVICEID() + "_"
//					+ gun + "_CCRecord", "ENDCHARGETIME",
//					ccRecord.getENDCHARGETIME());
//			// 数据入库
//			logger.info("【BEFORE UPDATE ChargeChangeRecord】"
//					+ ccRecord.toString());
//			logger.info("【CPID = " + cpid + "】-【GUN = " + gun + "】");
//			dbOperation.updateChargeChangeRecord(ccRecord);
//			logger.info("【AFTER UPDATE ChargeChangeRecord】-遥测数据state变化入库-UPDATE");
//			logger.info("");
//		}
//	}
//
//	// 充电记录变化入库
//	public static void storageCCRecord(String cpid, int gun, String currTime) {
//		ChargeChangeRecord ccRecord = new ChargeChangeRecord();
//		ccRecord.setBEGINCHARGETIME(currTime);
//		ccRecord.setCPID(cpid);
//		ccRecord.setGUN(gun);
//		ccRecord.setDEVICEID(DataRelay.cpMap.get(cpid).getDEVICEID());
//		// 存储到redis
//		Map<String, String> map = ObjectToMap.getValueMap(ccRecord);
//		RedisHandle.setMap(DataRelay.cpMap.get(cpid).getDEVICEID() + "_" + gun
//				+ "_CCRecord", map);
//		// 数据入库
//		logger.info("【BEFORE INSERT ChargeChangeRecord】" + ccRecord.toString());
//		logger.info("【CPID = " + cpid + "】-【GUN = " + gun + "】");
//		dbOperation.addChargeChangeRecord(ccRecord);
//		logger.info("【AFTER INSERT ChargeChangeRecord】-遥测数据state变化入库-INSERT");
//		logger.info("");
//	}

	// 根据redis中的启动充电参数 生成启动充电记录对象
	public static void storageSCGRecord(Map<String, String> state) {
		// 从map中得到启动充电枪对象
		String Value = StringUtil.getValue(state.get("value"));
		StartChargeGunRecord scgRecord = new StartChargeGunRecord();
		scgRecord.setDEVICEID(state.get("deviceId"));
		scgRecord.setINTERFACEID(Integer.parseInt(state.get("gun")));
		scgRecord.setCHARGEMODEID(Integer.parseInt(state.get("mode")));
		scgRecord.setCHARGEPARA(Float.parseFloat(Value));
		scgRecord.setCPUSERID(state.get("userId"));
		scgRecord.setACCOUNTBALANCE(Float.parseFloat(state.get("remainSum")));
		scgRecord.setSENDSTARTCMDTIME(CreateByte.getCurrTime());
		// 发送到中转站
		DataRelay.sychroStartMap.put(
				scgRecord.getDEVICEID() + "_" + scgRecord.getINTERFACEID(),
				scgRecord);
		// 数据入库 日志记录
		logger.info("【INSERT StartChargeGunRecord SendStart】"
				+ scgRecord.toString());
		dbOperation.addStartChargeGunRecord(scgRecord);
	}

	// 收到启动充电枪回复
	public static void storageSCGRRecord(byte[] buf,String cpId) {
		// 从buf中解析出启动回复内容
		String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, 0, 8));
		int gun = ByteUtil.LbyteToInt(buf[8]);
		int flag = ByteUtil.LbyteToInt(buf[9]);
		int reason = ByteUtil.LbyteToInt(buf[10]);
		Map<String, String> appMap = new HashMap<String, String>();
		// 从中转站拿到对象 更新数据
		//han---这个启动充电枪记录是在什么地方放的？
		StartChargeGunRecord scgRecord = DataRelay.sychroStartMap.get(deviceId
				+ "_" + gun);
		if (scgRecord == null) {
			logger.info("收到启动充电枪回复，但找不到对应的那条启动充电枪记录");
		} else {
			if (flag == 0) {
				// 启动枪成功
				scgRecord.setSTARTCHARGEFLAG(1);
				scgRecord.setSTARTCHARGEFAILDESP("无");
				appMap.put("status", "success");
				appMap.put("sendTime", CreateByte.getCurrTime());
			} else {
				// 启动枪失败+原因
				scgRecord.setSTARTCHARGEFLAG(0);
				appMap.put("status", "failed");
				appMap.put("sendTime", CreateByte.getCurrTime());
				String desp;
				/*han--这个值在什么地方规定的？应该有表RemoteStartAbnormalCause*/
				if (reason == 1) {
					desp = "设备未连接";
				} else if (reason == 2) {
					desp = "设备连接故障";
				} else if (reason == 3) {
					desp = "通信故障";
				} else {
					desp = "其他";
				}
				scgRecord.setSTARTCHARGEFAILDESP(desp);
			}
			// 通知app
			RedisHandle.setMap(deviceId + "_" + gun + "_SCGResult", appMap);
			RedisHandle.setKeyTime(deviceId + "_" + gun + "_SCGResult", 120);
			// 更新中转站
			DataRelay.sychroStartMap.put(deviceId + "_" + gun, scgRecord);
			
			// 记录状态
			ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
			chargeProgressDto.setSTARTCHARGEREPLYSTATUS(String.valueOf(flag));
			chargeProgressDto.setSTARTCHARGETIME(CreateByte.getCurrTime());
			chargeProgressDto.setCPID(cpId);
			chargeProgressDto.setCPUSERID(scgRecord.getCPUSERID());
			String startTime = RedisHandle.getTString(cpId+"_startTime"+scgRecord.getCPUSERID());
			chargeProgressDto.setCHARGESTARTTIME(String.valueOf(startTime));
			dbOperation.updateStartResponse(chargeProgressDto);
			
			
			// 更新数据库
			logger.info("【UPDATE StartChargeGunRecord StartReply】"
					+ scgRecord.toString());
			dbOperation.updateStartChargeGunRecord(scgRecord);
		}
	}

	// 发送停止充电枪命令 更新数据
	public static void storageECGRecord(Map<String, String> state, String cpId) {
		// 从中转站拿到之前的启动记录
		StartChargeGunRecord scgRecord = DataRelay.sychroStartMap.get(state
				.get("deviceId") + "_" + state.get("gun"));
		if (scgRecord == null) {
			logger.error("准备将发送停止充电枪命令入库，但找不到那条启动记录");
			logger.error("");
		} else {
			scgRecord.setSENDENDCMDTIME(CreateByte.getCurrTime());
			// 数据发送到中转站
			DataRelay.sychroStartMap.put(
					state.get("deviceId") + "_" + state.get("gun"), scgRecord);
			// 数据入库 记录日志
			logger.info("【UPDATE StartChargeGunRecord SendStop】"
					+ scgRecord.toString());
			dbOperation.updateStartChargeGunRecord(scgRecord);
		}
	}

	// 收到停止充电枪回复 更新数据
	// han---回复 reply 汉
	public static void storageECGRRecord(byte[] buf,String cpId) {
		String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, 0, 8));
		int gun = ByteUtil.LbyteToInt(buf[8]);
		int flag = ByteUtil.LbyteToInt(buf[9]);
		Map<String, String> appMap = new HashMap<String, String>();
		StartChargeGunRecord scgRecord = DataRelay.sychroStartMap.get(deviceId
				+ "_" + gun);
		if (scgRecord == null) {
			logger.info("准备解析停止充电充电枪回复-但找不到那条启动充电枪命令");
		} else {
			// 程序重启了拿到的为空
			if (flag == 0) {
				// 成功
				scgRecord.setENDCHARGEFLAG(1);
				appMap.put("status", "success");
				appMap.put("sendTime", CreateByte.getCurrTime());
			} else {
				scgRecord.setENDCHARGEFLAG(0);
				appMap.put("status", "failed");
				appMap.put("sendTime", CreateByte.getCurrTime());
				appMap.put("reason", "zz");
			}
			// 改变redis 通知app
			/*han-- 怎么通知APP的？跟启动充电枪与停止充电枪的方法是一样的，APP可以检索到Redis中的map的值*/
			RedisHandle.setMap(deviceId + "_" + gun + "_ECGResult", appMap);
			RedisHandle.setKeyTime(deviceId + "_" + gun + "_ECGResult", 120);
			// 数据更新到中转站
			DataRelay.sychroStartMap.put(deviceId + "_" + gun, scgRecord);
			
			Long stopResponseTime = System.currentTimeMillis();
			RedisHandle.setTString(cpId+"_"+"stopResponse"+scgRecord.getCPUSERID(), String.valueOf(flag));
			RedisHandle.setTString(cpId+"_"+"stopResponseTime"+scgRecord.getCPUSERID(), String.valueOf(stopResponseTime));
			// 接收到停止命令回复,更改状态
			RedisHandle.setTString(cpId+"_"+"endResult"+scgRecord.getCPUSERID(),"over" );
			
			ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
			chargeProgressDto.setCPID(cpId);
			chargeProgressDto.setCPUSERID(scgRecord.getCPUSERID());
			String startTime = RedisHandle.getTString(cpId+"_startTime"+scgRecord.getCPUSERID());
			chargeProgressDto.setCHARGESTARTTIME(String.valueOf(startTime));
			// 设置状态,0为停止成功,1为失败
			chargeProgressDto.setENDSTATUS(String.valueOf(flag));
			chargeProgressDto.setRECEIVEENDREPLYTIME(CreateByte.getCurrTime());
			// 状态入库
			dbOperation.updateStopResponseInfo(chargeProgressDto);
			// 数据入库 更新
			logger.info("【UPDATE EndChargeGunRecord StopReply】"
					+ scgRecord.toString());
			dbOperation.updateStartChargeGunRecord(scgRecord);
		}
	}

	// 计费模型存储操作 已经发送了报文
	public static void storageBMSRecord(String cpId) {
		// 拿到bill对象
		int rateId = DataRelay.cpMap.get(cpId).getRATEID();
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		BillModelInfo_DPF bill_DPF = DataRelay.billMap.get(DataRelay.cpMap.get(
				cpId).getOPERATORID()
				+ "_" + rateId + "_" + month);
		// 设置给billsend对象
		BillModelSendRecord bmsRecord = new BillModelSendRecord();
		bmsRecord.setCPID(cpId);
		bmsRecord.setBILLID(bill_DPF.getRATEID() * 100
				+ bill_DPF.getBILLMODELID());
		bmsRecord.setRECORDTIME(CreateByte.getCurrTime());
		bmsRecord.setVALIDTIME(bill_DPF.getVALIDTIME());
		bmsRecord.setINVALIDTIME(bill_DPF.getINVALIDTIME());
		bmsRecord.setEXECUTIONSTATE(0);
		bmsRecord.setMEASUREMENTTYPE(0);
		bmsRecord.setTIMEINTERVALCOUNT(bill_DPF.getTIMEINTERVALCOUNT());
		StringBuffer sbuff = new StringBuffer();
		int i = 0;
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_1_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_1_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_2_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_2_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_3_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_3_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_4_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_4_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_5_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_5_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_6_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_6_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_7_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_7_ID());
			sbuff.append(";");
			i++;
		}
		if (i < bill_DPF.getTIMEINTERVALCOUNT()) {
			sbuff.append(bill_DPF.getTI_8_START() / 60);
			sbuff.append(",");
			sbuff.append(bill_DPF.getTI_8_ID());
			sbuff.append(";");
			i++;
		}
		bmsRecord.setTISTRING(sbuff.toString());
		bmsRecord.setJPRICE(bill_DPF.getJPRICE());
		bmsRecord.setFPRICE(bill_DPF.getFPRICE());
		bmsRecord.setPPRICE(bill_DPF.getPPRICE());
		bmsRecord.setGPRICE(bill_DPF.getGPRICE());
		bmsRecord.setSERVICETIP(bill_DPF.getSERVICETIP());
		bmsRecord.setSENDFLAG(1);
		bmsRecord.setACTIVEREQUESTFLAG(0);
		// 先存入中转站 收到回复之后要用
		DataRelay.sychroBMSMap.put(DataRelay.cpMap.get(cpId).getDEVICEID(),
				bmsRecord);
		// 入库 日志记录
//		logger.info("【INSERT BillModelSendRecord SendBMSRecord】"
//				+ bmsRecord.toString());
//		dbOperation.addBillModelSendRecord(bmsRecord);
	}

	// 收到计费模型回复 更新
	public static void storageEBMSRecord(byte[] buf, String CPID,
			HashMap<String, Object> map) {
		String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, 0, 8));
		int gun = ByteUtil.LbyteToInt(buf[8]);
		long mode = ByteUtil.LbytestoLong(ByteUtil.subBytes(buf, 9, 8));
		int flag = ByteUtil.LbyteToInt(buf[17]);
		// 从中转站拿到对象
		//han-sychroBMSMap是在什么地方初始化的？
		BillModelSendRecord bmsRecord = DataRelay.sychroBMSMap.get(deviceId);
		if (bmsRecord == null) {
			// 根据deviceId找不到 那么就是报文错误
			logger.error("收到计费模型回复报文-准备解析报文-找不到发送记录对象");
		} else {
			// 已经收到了回复 自己设置返回值 入库
			bmsRecord.setFINISHEDFLAG(1);
			bmsRecord.setBILLIDRETURN((int) mode);
			bmsRecord.setRESULTRETURN(flag);
			// 更新中转站
			DataRelay.sychroBMSMap.put(CPID, bmsRecord);
			if (flag == 0) {
				// 报文返回的结果是0 0成功
				map.put("BILLMODEL", "success");
				map.put("TOTALCALL", "TOTALCALL");
			}
			// 更新数据库
//			logger.info("【UPDATE BillModelSendRecord BMSRecordReply】"
//					+ bmsRecord.toString());
//			dbOperation.updateBillModelSendRecord(bmsRecord);
		}
	}

	// 收到鉴权报文 解析处理入库
	public static void storageACRecord(byte[] buf, String cpId,
			HashMap<String, Object> map) {
		// 解析鉴权报文-得到鉴权数据对象
		SwipeCardAutRecord scaRecord = new SwipeCardAutRecord();
		int start = 0;
		scaRecord.setDEVICEID(CreateByte.bcdToStr(ByteUtil.subBytes(buf, start,
				8)));
		start += 8;
		scaRecord.setINTERFACEID(ByteUtil.LbyteToInt(buf[start]));
		start += 1;
		scaRecord.setPHYSICALCARDNUM(CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8)));
		scaRecord.setCPUSERID(scaRecord.getPHYSICALCARDNUM());
		start += 8;
		scaRecord.setPWD(CreateByte.bcdToStr(ByteUtil.subBytes(buf, start, 8))
				.substring(0, 6));
		start += 8;
		scaRecord.setINPUTPWD((CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8))).substring(0, 6));
		start += 8;
		//han-卡余额
		scaRecord.setCARDBALANCE(ByteUtil.getTTFloat(ByteUtil.subBytes(buf,
				start, 4)));
		start += 4;
		scaRecord.setCARDSTATE(ByteUtil.LbytesToInt(ByteUtil.subBytes(buf,
				start, 2)));
		start += 2;
		scaRecord.setEVUNIQUEID(CreateByte.bcdToStr(
				ByteUtil.subBytes(buf, start, 16)).toString());
		start += 16;
		scaRecord.setBILLMODELID(CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8)));
		start += 8;
		//han-支付卡卡号是银行卡、物理卡号是充电用的？还是一个东西
		scaRecord.setPAYMENTCARDNUM(CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8)));
		start += 8;
		scaRecord.setCERTIFIEDPAYMENTCARDDATA(CreateByte.bcdToStr(ByteUtil
				.subBytes(buf, start, 8)));
		scaRecord.setRECORDTIME(CreateByte.getCurrTime());
		scaRecord.setCPID(cpId);
		// 通知pileObject鉴权的枪
		/* han-判断是0号枪还是1号枪*/
		if (scaRecord.getINTERFACEID() == 0) {
			map.put("AC0", String.valueOf(scaRecord.getINTERFACEID()));
		} else {
			map.put("AC1", String.valueOf(scaRecord.getINTERFACEID()));
		}
		// 将数据放到中转站
		DataRelay.SychroACMap.put(
				scaRecord.getDEVICEID() + "_" + scaRecord.getINTERFACEID(),
				scaRecord);
		// 得到对象 先入库
		scaRecord.setCPUSERID("1");
		logger.info("【INSERT SwipeCardAutRecord ReadACRecord】"
				+ scaRecord.toString());
		dbOperation.addAuthentiCationRecord(scaRecord);
	}

	// 直流全遥测
	/*
	 --han--直流报文与交流报文不同
     //modify by hanmj Begin 20170807  遥测下行报文新增10个字节解析需求
	   首先在改变报文长度后，要进入该方法中，然后再解析
	 datalen = 22;
	 
	 DCYcRunRecord对象要改，增加三个字段，字段的名称，什么类型?先随便搞一个,然后再问一下
	   设备编号deviceId String
	   充电接口chargePort float
	 String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, 2, 8))
					.toString();
	 
	 */
	public static void storageDCQYCRecord(byte[] buf, int datalen,
			int protocolId, String cpId, List<YCPointList_DPF> ycPoint) {
		int temp = 0;
		float data = 0;
		int start = 0;
		
		DCYcRunRecord dcycRecord = new DCYcRunRecord();
		String deviceId = "";
		int interfaceId = 0;
		
		//han-- 前9次截取2位，后面的截取4位，直流与交流的报文是否不同？
		//在外面截取多出的部分
		//记录类型不需要
		for(int i=0; i<2; i++){
			if(i == 1){
				deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, start, 8)).toString();//设备编号
				dcycRecord.setDeviceId(deviceId);
				start += 8;
			}else{
				interfaceId = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 1));//充电接口
				dcycRecord.setInterfaceId(interfaceId);
				start += 1;
			}
		}
		
		datalen -= 9;//han-把多出来的9位减掉再循环
		
		for (int i = 1; i <= datalen; i++) {
			if (i <= 9) {
				temp = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 2));
				start += 2;
			} else {
				temp = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 4));
				start += 4;
			}
			data = (float) temp / ycPoint.get(i - 1).getPC();
			// 输出日志信息
			//logger.info(ycPoint.get(i - 1).getYCPOINTNAME() + "::" + data);
			pointData.setPROTOCOLID(protocolId);
			pointData.setDATA(data);
			pointData.setFLAG(0);
			pointData.setPOINTID(i);
			// 获取数据存储到redis
			Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
			/* --han--
			 * 双枪的情况下，加一个枪ID
			 * 在什么地方取的？也要变一下，应该是APP或者是什么的，需要同步
			 * 60秒不取，map被回收
			RedisHandle.setMap(cpId + "_QYC_DATA_" + pointData.getPOINTID(),
					tempMap);
			RedisHandle.setKeyTime(
					cpId + "_QYC_DATA_" + interfaceId + pointData.getPOINTID(), 60);
					*/
			RedisHandle.setMap(cpId + "_QYC_DATA_" + interfaceId + "_" +pointData.getPOINTID(),
					tempMap);
			RedisHandle.setKeyTime(
					cpId + "_QYC_DATA_" + interfaceId + "_" +pointData.getPOINTID(), 60);
			switch (i) {
			case 1:
				dcycRecord.setChargeVOut(data);
				break;
			case 2:
				dcycRecord.setChargeAOut(data);
				break;
			case 3:
				dcycRecord.setSOC(data);
				break;
			case 4:
				dcycRecord.setBatteryPackMintemp(data);
				break;
			case 5:
				dcycRecord.setBatteryPackMaxtemp(data);
				break;
			case 6:
				dcycRecord.setBatteryMintemp(data);
				break;
			case 7:
				dcycRecord.setBatteryMaxtemp(data);
				break;
			case 8:
				dcycRecord.setChargerTemp(data);
				break;
			case 9:
				dcycRecord.setChargeDirectV(data);
				break;
			case 10:
				dcycRecord.setChargeQuantity(data);
				break;
			case 11:
				dcycRecord.setChargePower(data);
				break;
			case 12:
				dcycRecord.setChargeMoney(data);
				break;
			case 13:
				dcycRecord.setChargeTimeSpan(data);
				break;
			default:
				break;
			}
			
		}
		// 全遥测时间
		RedisHandle.setTString(cpId + "_QYC_DATA_TIME",
				String.valueOf(System.currentTimeMillis()));
		dcycRecord.setCPID(cpId);
		dcycRecord.setRECORDTIME(CreateByte.getCurrTime());
		dcycRecord.setMILLSECONDS(System.currentTimeMillis());
		// 更新中转站
		DataRelay.sychroDCYCMap.put(cpId, dcycRecord);
		// 记录入库
		//logger.info("【INSERT CPDCYCRunRecord】" + dcycRecord.toString());
		//dbOperation.addDCYCRunRecord(dcycRecord);
	}

	// 全遥测
	public static void storageQYCRecord(byte[] buf, int datalen,
			int protocolId, String cpId, List<YCPointList_DPF> ycPoint) {
		/*
		 *CPYCRUNRECORD为了拼一个对象存入数据库
		 * 
		 YCPointList_DPF:PRO104中的init()方法
		 SELECT
				*
		FROM
				YCPOINTLIST
		 * 
		 * */
		int length = 0;
		int temp = 0;
		float data = 0;
		int flag = 0;
		int start = 0;
		//datalen=ProceData_104中获取的length的值
		CPYCRunRecord_104 ycRecord = new CPYCRunRecord_104();
		StringBuffer sbflag = new StringBuffer();

		//当i为1时，获取的是第一个03后面的4位
		for (int i = 1; i <= datalen; i++) {
			length = ByteUtil.LbyteToInt(buf[start++]);
			//han-2位报文
			temp = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start,
					length - 1));
			start += (length - 1);
			// 重点
			data = (float) temp / ycPoint.get(i - 1).getPC();//ycpointlist的数据
			// 输出日志信息
			//logger.info(ycPoint.get(i - 1).getYCPOINTNAME() + "::" + data);
			//是否可信
			flag = ByteUtil.LbyteToInt(buf[start++]);
			
			pointData.setPROTOCOLID(protocolId);
			pointData.setDATA(data);
			pointData.setFLAG(flag);
			pointData.setPOINTID(i);
			
			// 获取数据存储到redis
			/*
			 * han--
			  ObjectToMap.getValueMap(pointData)--对象转化为Map
			      转化后的map，key-对象各字段的字段名称 value-对象各字段的值
			 */
			Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
			RedisHandle.setMap(cpId + "_QYC_DATA_" + pointData.getPOINTID(),
					tempMap);
			if (i <= 12 || i == 21 || i == 22) {
				RedisHandle.setKeyTime(
						cpId + "_QYC_DATA_" + pointData.getPOINTID(), 60);
			}
			sbflag.append(flag);
			switch (i) {
			case 1:
				ycRecord.setUA1(data);
				break;
			case 2:
				ycRecord.setUA2(data);
				break;
			case 3:
				ycRecord.setUB1(data);
				break;
			case 4:
				ycRecord.setUB2(data);
				break;
			case 5:
				ycRecord.setUC1(data);
				break;
			case 6:
				ycRecord.setUC2(data);
				break;
			case 7:
				ycRecord.setIA1(data);
				break;
			case 8:
				ycRecord.setIA2(data);
				break;
			case 9:
				ycRecord.setIB1(data);
				break;
			case 10:
				ycRecord.setIB2(data);
				break;
			case 11:
				ycRecord.setIC1(data);
				break;
			case 12:
				ycRecord.setIC2(data);
				break;
			case 13:
				ycRecord.setGUNA_E(data);
				break;
			case 14:
				ycRecord.setGUNB_E(data);
				break;
			case 15:
				ycRecord.setGUNA_F(data);
				break;
			case 16:
				ycRecord.setGUNB_F(data);
				break;
			case 17:
				ycRecord.setGUNA_P(data);
				break;
			case 18:
				ycRecord.setGUNB_P(data);
				break;
			case 19:
				ycRecord.setGUNA_M(data);
				break;
			case 20:
				ycRecord.setGUNB_M(data);
				break;
			case 21:
				ycRecord.setGUNA_STATE((int) data);
				break;
			case 22:
				ycRecord.setGUNB_STATE((int) data);
				break;
			default:
				break;
			}
		}
		// 全遥测时间
		RedisHandle.setTString(cpId + "_QYC_DATA_TIME",
				String.valueOf(System.currentTimeMillis()));
		ycRecord.setCPID(cpId);
		ycRecord.setRECORDTIME(CreateByte.getCurrTime());
		ycRecord.setCREDIBLE(sbflag.toString());
		ycRecord.setMILLSECONDS(System.currentTimeMillis());
		// 更新中转站
		DataRelay.sychroYCMap.put(cpId, ycRecord);//遥测记录不是要入库么？只放在中转站，不放进内存
		// 记录入库
		//logger.info("【INSERT CPYCRunRecord】" + ycRecord.toString());
	}
	//dbOperation.addYCRunRecord(ycRecord);

	
	/*  
	 	---han---
	 	报文多了10位，要先解析3次，然后再按照以前的解析方式进行解析
	 	表中的数据其实只有6个字段
	 */
	// 直流全遥信
	public static void storageDCQYXRecord(byte[] buf, int datalen, String cpId,
			int protocolId, List<YXPointList_DPF> dcyxPoint) {
		String value;
		StringBuffer sbdata = new StringBuffer();
		DCYxRunRecord dcyxRecord = new DCYxRunRecord();
		//han-在哪放的？
		if (DataRelay.sychroDCYXMap.get(cpId) != null) {
			// 拿到之前的新值 存入旧值里面
			DCYxRunRecord temp = DataRelay.sychroDCYXMap.get(cpId);
			dcyxRecord.setOldValue(temp.getNewValue());
			dcyxRecord.setOldValueRecordTime(temp.getRecordTime());
		} else {
			dcyxRecord.setOldValue("--");
			dcyxRecord.setOldValueRecordTime("1970-00-00 00:00:00");
		}
		//modify by hanmj Begin 20170807  遥测下行报文新增10个字节解析需求
		//先截取2次
		int start = 0;
		int temp = 0;
		float data = 0;
		int interfaceId = 0;
		for(int i = 0; i < 2; i++){
			if(i == 0){
				String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, start, 8)).toString();//设备编号
				dcyxRecord.setDeviceId(deviceId);
				start += 8;
			}else{//i == 1	循环结束
				interfaceId = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 1));//充电接口
				dcyxRecord.setInterfaceId(interfaceId);
				//sbdata.append(data + "");
				start++;
			}
			
		}
		datalen -= 9;//han-把多出来的报文长度减掉
		for (int i = start; i < datalen; i++) {
			value = Integer.toBinaryString((buf[i] & 0xFF) + 0x100)
					.substring(1);
			value = StringUtil.overTurn(value);//han-翻转了字符串的前后顺序，实际调用String.reverse()方法
			sbdata.append(value);
			// 每一个点都打印 方便查看
			//logger.info("每次8个遥信点" + "::" + value);
		}
		pointData.setSDATA(sbdata.toString());
		Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
		RedisHandle.setMap(cpId + "_QYX_DATA_" + interfaceId +"_"+ 0, tempMap);
		// 全遥信时间
		RedisHandle.setTString(cpId + "_QYX_DATA_TIME" + "_" + interfaceId,
				CreateByte.getCurrTime());
		 
		// 更新DataRelay中的数据
		dcyxRecord.setNewValue(sbdata.toString());
		dcyxRecord.setRecordTime(CreateByte.getCurrTime());
		dcyxRecord.setCpid(cpId);
		DataRelay.sychroDCYXMap.put(cpId, dcyxRecord);
		// 记录入库
		//logger.info("【INSERT CPDCYXRunRecord】" + dcyxRecord.toString());
		//dbOperation.addDCYXRunRecord(dcyxRecord);
	}

	// 全遥信
	public static void storageQYXRecord(byte[] buf, int datalen, String cpId,
			int protocolId, List<YXPointList_DPF> yxPoint) {
		int data = 0;
		int flag = 0;
		byte b;
		String value;
		CPYXRunRecord_104 yxRecord = new CPYXRunRecord_104();
		if (DataRelay.sychroYXMap.get(cpId) != null) {
			// 拿到之前的新值 存入旧值里面
			//han-全遥信sychroYXMap不在这部分赋值，所以看不到这个map的结构
			//所以现在就假设不存在这个map，所有的值都是新的
			CPYXRunRecord_104 temp = DataRelay.sychroYXMap.get(cpId);
			yxRecord.setOLDVALUE(temp.getNEWVALUE());
			yxRecord.setOLDVALUERECORDTIME(temp.getNEWVALUERECORDTIME());
			yxRecord.setOLDVALUERELIABILITY(temp.getNEWVALUERELIABILITY());
		} else {
			yxRecord.setOLDVALUE("--");
			yxRecord.setOLDVALUERECORDTIME("1970-00-00 00:00:00");
			yxRecord.setOLDVALUERELIABILITY("--");
		}
		StringBuffer sbflag = new StringBuffer();
		StringBuffer sbdata = new StringBuffer();
		for (int i = 0; i < datalen; i++) {
			b = buf[i];
			value = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);//han-这里的获取值有点疑问，是截取的2位么
			if (value.charAt(0) == 49) {
				flag = 1;
			} else {
				flag = 0;
			}
			data = value.charAt(value.length() - 1) - 48;
			sbflag.append(value.substring(0, 1));
			sbdata.append(value.substring(6, 7));//han-这个是第7位而不是最后一位么？
			pointData.setDATA(data);
			pointData.setPROTOCOLID(protocolId);
			pointData.setFLAG(flag);
			pointData.setPOINTID(i + 1);
			Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
			RedisHandle.setMap(cpId + "_QYX_DATA_" + pointData.getPOINTID(),
					tempMap);
		}
		// 全遥信时间
		RedisHandle.setTString(cpId + "_QYX_DATA_TIME",
				CreateByte.getCurrTime());
		// 更新DataRelay中的数据
		yxRecord.setNEWVALUE(sbdata.toString());
		yxRecord.setNEWVALUERELIABILITY(sbflag.toString());
		yxRecord.setNEWVALUERECORDTIME(CreateByte.getCurrTime());
		yxRecord.setCPID(cpId);
		yxRecord.setRECORDTIME(CreateByte.getCurrTime());
		DataRelay.sychroYXMap.put(cpId, yxRecord);
		// 记录入库
		//logger.info("【INSERT CPYXRunRecord】" + yxRecord.toString());
		//dbOperation.addYXRunRecord(yxRecord);
	}

	// 直流变位遥信
	public static void storageDCBYXRecord(byte[] buf, int datalen, String cpId,
			int protocolId, List<YXPointList_DPF> yxPoint) {
		int point = 0;
		int data = 0;
		int start = 0;
		for (int i = 1; i <= datalen; i++) {
			// 获取数据位置
			point = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start++, 1));
			data = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start++, 1));
			pointData.setPROTOCOLID(protocolId);
			pointData.setDATA(data);
			pointData.setPOINTID(point);
			DCYxRunRecord dcyxRecord = new DCYxRunRecord();
			dcyxRecord.setCpid(cpId);
			dcyxRecord.setRecordTime(CreateByte.getCurrTime());
			dcyxRecord.setYxPointId(point);
			// olddata
			if (DataRelay.sychroDCYXMap.get(cpId) == null) {
				dcyxRecord.setOldValue("0");
				dcyxRecord.setOldValueRecordTime("-");
				dcyxRecord.setOldValueMean(DataRelay.dcyxPointMap.get(
						protocolId + "_" + point).getMean_0());
			} else {
				dcyxRecord.setOldValue(DataRelay.sychroDCYXMap.get(cpId)
						.getNewValue().substring(point - 1, point));
				dcyxRecord.setOldValueRecordTime(DataRelay.sychroDCYXMap.get(
						cpId).getRecordTime());
				// int olddata =
				// Integer.parseInt(DataRelay.sychroYXMap.get(cpId)
				// .getNEWVALUE().substring(point - 1, point));
				dcyxRecord.setOldValueMean(DataRelay.dcyxPointMap.get(
						protocolId + "_" + point).getMean_0());
			}
			// newdata
			dcyxRecord.setNewValue(String.valueOf(data));
			dcyxRecord.setRecordTime(CreateByte.getCurrTime());
			dcyxRecord.setNewValueMean(DataRelay.dcyxPointMap.get(
					protocolId + "_" + point).getMean_0());
			// 变位遥信还是全遥信的点更新redis
			Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
			RedisHandle.setMap(cpId + "_QYX_DATA_" + pointData.getPOINTID(),
					tempMap);
			RedisHandle.setTString(cpId + "_QYX_DATA_TIME",
					CreateByte.getCurrTime());
			// 入库操作
			dcyxRecord.setCheckMode(0);
			dcyxRecord.setCheckState(0);
			logger.info("【INSERT CPDCBYXRunRecord】"
					+ dcyxRecord.toString());
			dbOperation.addDCBYXRunRecord(dcyxRecord);
		}
	}

	// 变位遥信
	public static void storageBYXRecord(byte[] buf, int datalen,
			int protocolId, String cpId) {
		int point = 0;
		int data = 0;
		int flag = 0;
		int start = 0;
		String str;
		for (int i = 1; i <= datalen; i++) {
			// 获取数据位置
			point = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 3));
			str = Integer.toBinaryString((buf[start] & 0xFF) + 0x100)
					.substring(1);
			if (str.charAt(0) == 49) {
				flag = 1;
			} else {
				flag = 0;
			}
			data = str.charAt(str.length() - 1) - 48;
			start += 3;
			pointData.setPROTOCOLID(protocolId);
			pointData.setDATA(data);
			pointData.setFLAG(flag);
			pointData.setPOINTID(point);
			CPYXRunRecord_104 yxRecord = new CPYXRunRecord_104();

			yxRecord.setCPID(cpId);
			yxRecord.setRECORDTIME(CreateByte.getCurrTime());
			yxRecord.setYXPOINTID(point);
			// olddata
			if (DataRelay.sychroYXMap.get(cpId) == null) {
				yxRecord.setOLDVALUE("0");
				yxRecord.setOLDVALUERELIABILITY("0");
				yxRecord.setOLDVALUERECORDTIME("-");
				yxRecord.setOLDVALUEMEAN(DataRelay.yxPointMap.get(
						protocolId + "_" + point).getMean_0());
			} else {
				yxRecord.setOLDVALUE(DataRelay.sychroYXMap.get(cpId)
						.getNEWVALUE().substring(point - 1, point));
				yxRecord.setOLDVALUERELIABILITY(DataRelay.sychroYXMap.get(cpId)
						.getNEWVALUERELIABILITY().substring(point - 1, point));
				yxRecord.setOLDVALUERECORDTIME(DataRelay.sychroYXMap.get(cpId)
						.getNEWVALUERECORDTIME());
				int olddata = Integer.parseInt(DataRelay.sychroYXMap.get(cpId)
						.getNEWVALUE().substring(point - 1, point));
				if (0 == olddata) {
					yxRecord.setOLDVALUEMEAN(DataRelay.yxPointMap.get(
							protocolId + "_" + point).getMean_0());
				} else if (1 == olddata) {
					yxRecord.setOLDVALUEMEAN(DataRelay.yxPointMap.get(
							protocolId + "_" + point).getMean_1());
				} else {
					yxRecord.setOLDVALUEMEAN(DataRelay.yxPointMap.get(
							protocolId + "_" + point).getMean_2());
				}
			}
			// newdata
			yxRecord.setNEWVALUE(String.valueOf(data));
			yxRecord.setNEWVALUERELIABILITY(String.valueOf(flag));
			yxRecord.setNEWVALUERECORDTIME(CreateByte.getCurrTime());
			if (0 == data) {
				yxRecord.setNEWVALUEMEAN(DataRelay.yxPointMap.get(
						protocolId + "_" + point).getMean_0());
			} else if (1 == data) {
				yxRecord.setNEWVALUEMEAN(DataRelay.yxPointMap.get(
						protocolId + "_" + point).getMean_1());
			} else {
				yxRecord.setNEWVALUEMEAN(DataRelay.yxPointMap.get(
						protocolId + "_" + point).getMean_2());
			}
			// 变位遥信还是全遥信的点更新redis
			Map<String, String> tempMap = ObjectToMap.getValueMap(pointData);
			RedisHandle.setMap(cpId + "_QYX_DATA_" + pointData.getPOINTID(),
					tempMap);
			RedisHandle.setTString(cpId + "_QYX_DATA_TIME",
					CreateByte.getCurrTime());
			// 入库操作
			yxRecord.setCHECKSTATE("0");
			yxRecord.setCHECKMODE("0");
			logger.info("【INSERT CPBYXRunRecord】" + yxRecord.toString());
			dbOperation.addBYXRunRecord(yxRecord);
		}
	}
}

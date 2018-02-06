package cn.com.start.DPF.aio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.ChargeRecord_DPF;
import cn.com.start.DPF.entity.YCPointList_DPF;
import cn.com.start.DPF.entity.YXPointList_DPF;
import cn.com.start.DPF.redis.ObjectToMap;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.StringUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class PRO104 {
	// 日志 redis 入库
	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dStorage = DBOperation.getInstance();

	// 对象成员 方便
	private String cpId; // 桩id 软编码
	private String deviceId;// 设备ID 硬编码
	private int protocolId;// 协议id

	// 待删除 改造
	private CPInfo_DPF cpInfo_DPF; // 桩基础信息
	private List<YCPointList_DPF> ycPoint = new ArrayList<YCPointList_DPF>();// 遥测点表
	private List<YXPointList_DPF> yxPoint = new ArrayList<YXPointList_DPF>();// 遥信点表
	private List<YCPointList_DPF> dcycPoint = new ArrayList<YCPointList_DPF>();// 直流遥测点表
	private List<YXPointList_DPF> dcyxPoint = new ArrayList<YXPointList_DPF>();// 直流遥信点表

	// private StringBuffer aGunState = new StringBuffer("0"); //
	// 每次拿到遥测都更新ab枪的状态
	// private StringBuffer bGunState = new StringBuffer("0"); // b枪状态

	// 构造函数
	public PRO104(String cpid) {
		this.cpId = cpid;
		Init();
	}

	// 初始化数据
	public void Init() {
		// 创建104对象时 将104和cpid相关的数据初始化
		cpInfo_DPF = DataRelay.cpMap.get(cpId);
		deviceId = cpInfo_DPF.getDEVICEID();
		protocolId = cpInfo_DPF.getPROTOCOLID();
		logger.info("Init the PRO104--" + "deviceId=" + deviceId
				+ "protocolId=" + protocolId);
		for (int i = 1; i <= 30; i++) {
			//ycPointMap key-ycpointList中的protocolid_ycpointid vlaue-ycpointList数据
			ycPoint.add(DataRelay.ycPointMap.get(protocolId + "_" + i));
		}
		//为什么是8呢？还有上面的为什么是30呢？
		for (int i = 1; i <= 8; i++) {
			yxPoint.add(DataRelay.yxPointMap.get(protocolId + "_" + i));
		}
		for (int i = 1; i <= 13; i++) {
			dcycPoint.add(DataRelay.dcycPointMap.get(protocolId + "_" + i));
		}
		for (int i = 1; i <= 40; i++) {
			dcyxPoint.add(DataRelay.dcyxPointMap.get(protocolId + "_" + i));
		}
		logger.info("桩基本信息对象" + cpInfo_DPF.toString());
		logger.info("遥测点表list" + ycPoint.toString());
		logger.info("遥信点表list" + yxPoint.toString());
		logger.info("直流遥测点表list" + dcycPoint.toString());
		logger.info("直流遥信点表list" + dcyxPoint.toString());

	}

	// 解析 启动桩确认回复
	public void StartUp_104(byte[] buf, HashMap<String, Object> map) {

		logger.info("[Read Six]--[Parse BillModel Success]");
		// 收到启动回复开始计费
		map.put("STARTUP", "success");
		map.put("BILLMODEL", "BILLMODEL");
	}

	// 解析 计费模型确认回复
	public void BillModel_104(byte[] buf, HashMap<String, Object> map) {

		// 数据解析入库等操作
		DataStorage.storageEBMSRecord(buf, cpId, map);
		// 收到计费回复开始总召
	}

	// 解析 开始总召确认回复报文
	public void TCStart_104(byte[] buf, HashMap<String, Object> map) {
		// 收到开始总召回复 总召正在ing
		map.put("TOTALCALL", "ING");
	}

	// 解析 结束总召上报报文
	public void TCEnd_104(byte[] buf, HashMap<String, Object> map) {

		
		// INIT结束
		map.put("TOTALCALL", "success");
		// map.put("INITS", "END");
	}

	// 解析心跳
	public void HB_104(byte[] buf, HashMap<String, Object> map) {

		// 收到了心跳心跳包计数清0
		map.put("HEARTBEAT", "0");
		
	}

	// 解析 校时确认回复报文
	public void CheckTime_104(byte[] buf, HashMap<String, Object> map) {
		logger.info("[Read Six]--[Parse CheckTime Success]");
	}

	// 解析 启动充电枪确认回复报文
	public void SCGR_104(byte[] buf, HashMap<String, Object> map,String cpId) {

		// 收到确认回复 入库
		DataStorage.storageSCGRRecord(buf,cpId);
		/* 通知发送函数 */
	
		// 这个命令不重要 重要的是将启动成功失败告诉app
		map.put("SCG", "success"); // 将启动命令状态设置为成功
		map.put("ECG", "ready"); // 停止充电枪置为ready
		map.put("TOTALCALL", "ready");
	}

	// 解析停止充电枪确认回复报文
	public void ECGR_104(byte[] buf, HashMap<String, Object> map,String cpId) {

		DataStorage.storageECGRRecord(buf,cpId);
		
		map.put("ECG", "success");// 将停止充电枪命令设置为成功（发送然后桩返回了正确的回复）
		map.put("TOTALCALL", "ready");
	}

	// 解析充电记录上传报文
	public void CR_104(byte[] buf, HashMap<String, Object> map,String cpId) {
		ChargeRecord_DPF chRecord_DPF = DataHandle.getChargeRecord(buf, cpId,
				deviceId, protocolId);
		// 充电记录状态入库
		ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
		chargeProgressDto.setCPID(cpId);
		chargeProgressDto.setCPUSERID(chRecord_DPF.getCPUSERID());
		String startTime = RedisHandle.getTString(cpId+"_startTime"+chRecord_DPF.getCPUSERID());
		chargeProgressDto.setCHARGESTARTTIME(startTime);
		chargeProgressDto.setRECEIVECHARGERECORDTIME(CreateByte.getCurrTime());
		chargeProgressDto.setRECEIVECHARGERECORDSTATUS("1");
		dStorage.updateRecordInfo(chargeProgressDto);
		if (chRecord_DPF.getINTERFACEID() == 0) {
			map.put("CR0", String.valueOf(chRecord_DPF.getINTERFACEID()));
			map.put("CR0TIME",
					StringUtil.getTime(chRecord_DPF.getCHARGESTARTTIME()));
		} else {
			map.put("CR1", String.valueOf(chRecord_DPF.getINTERFACEID()));
			map.put("CR1TIME",
					StringUtil.getTime(chRecord_DPF.getCHARGESTARTTIME()));
		}
		// 先看redis如果没有就新增一条
		Map<String, String> testMap = RedisHandle.getMap(chRecord_DPF
				.getDEVICEID()
				+ "_"
				+ chRecord_DPF.getINTERFACEID()
				+ "_"
				+ StringUtil.getTime(chRecord_DPF.getCHARGESTARTTIME()));
		if (testMap == null || testMap.size() < 1) {
			// 第一次收到这条充电记录
			testMap = ObjectToMap.getValueMap(chRecord_DPF);
			RedisHandle.setMap(
					chRecord_DPF.getDEVICEID()
							+ "_"
							+ chRecord_DPF.getINTERFACEID()
							+ "_"
							+ StringUtil.getTime(chRecord_DPF
									.getCHARGESTARTTIME()), testMap);
			// 充电记录入库
			chRecord_DPF.setRECORDTIME(CreateByte.getCurrTime());
			logger.info("【BEFORE INSERT ChargeRecord】"
					+ chRecord_DPF.toString());
			logger.info("@@-【CPID = " + cpId + "】");
			dStorage.saveChargeRecord(chRecord_DPF);
			logger.info("【AFTER INSERT ChargeRecord】-收到充电记录-INSERT");
			// 通知app充电已经结束
			Map<String, String> appMap = new HashMap<String, String>();
			appMap.put("status", "finish");
			appMap.put("sendTime", CreateByte.getCurrTime());
			appMap.put("serialNo", chRecord_DPF.getTRANSATIONID());
			logger.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			logger.info("*******************************");
			RedisHandle.setMap(deviceId + "_" + chRecord_DPF.getINTERFACEID()
					+ "_" + "ChargeOver", appMap);
		} else {
			logger.info("内存已存在本条充电记录可能已经扣款过");
		}
		// 通知send
	
		map.put("RECORD", "success");
		map.put("DEDUCTFEE", "ready");
	}

	// 直流全遥测
	public void DCQYC_104(byte[] buf, int datalen, HashMap<String, Object> map) {
		
		DataStorage.storageDCQYCRecord(buf, datalen, protocolId, cpId,
				dcycPoint);
	
		map.put("DCQYC", "success"); // 全遥测成功
	}

	// 解析遥测数据
	public void QYC_104(byte[] buf, int datalen, HashMap<String, Object> map) {
		/*
		 --han--20170803
		 datalen=22
		 
		 protocolId、cpId、ycPoint为本类PRO104的3个成员变量，在创建对象的时候初始化的
		 	在init()方法中
		 ycPoint是什么？
		 	SELECT
				*
			FROM
				YCPOINTLIST
				查询结果放在YCPointList_DPF，数据库中有22条记录
				key为protocolid_ycpointid	4_1
				value为YCPOINTLIST对象
		 */
		DataStorage.storageQYCRecord(buf, datalen, protocolId, cpId, ycPoint);
	
		map.put("QYC", "success"); // 全遥测成功
	}

	// 直流全遥信
	public void DCQYX_104(byte[] buf, int datalen, HashMap<String, Object> map) {

		DataStorage.storageDCQYXRecord(buf, datalen, cpId, protocolId,
				dcyxPoint);
	
		map.put("DCQYX", "success");
	}

	// 全遥信
	public void QYX_104(byte[] buf, int datalen, HashMap<String, Object> map) {

		DataStorage.storageQYXRecord(buf, datalen, cpId, protocolId, yxPoint);
		// 解析成功
	
		map.put("QYX", "success");

	}

	// 直流变遥信
	public void DCBYX_104(byte[] buf, int datalen, HashMap<String, Object> map) {

		DataStorage.storageDCBYXRecord(buf, datalen, cpId, protocolId, yxPoint);
		// 解析成功
	
		map.put("DCBYX", "success");
	}

	// 变位遥信和变位遥测没做
	public void BYX_104(byte[] buf, int datalen, HashMap<String, Object> map) {

		DataStorage.storageBYXRecord(buf, datalen, protocolId, cpId);
		// 解析成功
		map.put("BYX", "success");
		
	}

	// 解析刷卡充电鉴权
	public void AC_104(byte[] buf, HashMap<String, Object> map) {

		DataStorage.storageACRecord(buf, cpId, map);
		// 准备发送鉴权结果成功或失败
		map.put("ACFLAG", "ready");
	}
}

package cn.com.start.DPF.aio;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.dto.DeductInfoDto;
import cn.com.start.DPF.entity.BillModelInfo_DPF;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChargeRecord_DPF;
import cn.com.start.DPF.entity.SwipeCardAutRecord;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;
import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.DPF.redis.ObjectToMap;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.StringUtil;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class DataHandle {

	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dbOperation = DBOperation.getInstance();
	private static DataUpdate dUpdate = DataUpdate.getInstance();
	private static DataSelect dSelect = DataSelect.getInstance();

	// 鉴权操作
	public static SwipeCardAutRecord ChargeAC(String deviceId, int gun) {
		// 根据设备id和gun直接拿到对象
		SwipeCardAutRecord scaRecord = DataRelay.SychroACMap.get(deviceId + "_"
				+ gun);
		// 只要后台发送鉴权请求，就去鉴权
		//han-去数据库查鉴权对象，也就是用户
		/*
		 --han-- 
	            鉴权：authentication n 鉴定、证明、证实
		swipeCard 刷卡
		scaRecord：
		DataRelay.SychroACMap.put(
				scaRecord.getDEVICEID() + "_" + scaRecord.getINTERFACEID(),
				scaRecord);
		收到鉴权报文后解析后放进map
		
		cardUserInfo：
		SELECT
				CARDNUM,
				PIN,
				ACCOUNTSUM,
				VIN,
				CARDSTATE
		FROM
				CARDUSERINFO
				WHERE
				CARDNUM = #{CARDNUMBER}
		鉴权失败原因：AuthorityFailCause表
		5001：无效卡号
		5004：卡状态被锁住，CARDUSERINFO表中的CARDSTATE为1
		5017：密码不等
		
		这里是卡用户的鉴权操作、那么手机用户的鉴权操作呢？
		
		查询卡用户的使用字段是scaRecord
				.getPHYSICALCARDNUM()，
				说明这个是唯一标识，物理卡号，在carduserinfo表中是主键
		
		WEBALARMRECORD告警记录表
		*/
		CardUserInfo cardUserInfo = dSelect.findCardUserInfo(scaRecord
				.getPHYSICALCARDNUM());
		// 数据库余额account 报文卡内余额CARDBALANCE 默认鉴权成功
		scaRecord.setAUTRESULTFLAG(1);
		scaRecord.setAUTFAILCAUSE("0");
		WebAlarmRecord webRecord = new WebAlarmRecord();
		webRecord.setCARDNUM(scaRecord.getPHYSICALCARDNUM());//han-物理卡号
		webRecord.setCPID(scaRecord.getCPID());
		webRecord.setGUN(scaRecord.getINTERFACEID());
		webRecord.setCHARGETYPE(1);// han-chargetype为1代表刷卡 0代表app
		webRecord.setRECORDTIME(CreateByte.getCurrTime());
		int webFlag = 1;
		if (cardUserInfo == null) {
			// 无效卡号
			/*AuthorityFailCause表中的鉴权失败原因*/
			scaRecord.setAUTRESULTFLAG(0);
			scaRecord.setAUTFAILCAUSE("5001");
			//webFlag = 0;
		} else if (cardUserInfo.getCARDSTATE() == 1) {
			// 卡状态锁住 鉴权失败
			scaRecord.setAUTRESULTFLAG(0);
			scaRecord.setAUTFAILCAUSE("5004");
			webRecord.setALARMTYPE(5004);
			webFlag = 0;
		} else {
			// card是桩发过来的 account是我这边的
			scaRecord.setACCOUNTBALANCE(cardUserInfo.getACCOUNTSUM());
			// 密码不等
			if (!scaRecord.getPWD().equals(cardUserInfo.getPIN())) {
				scaRecord.setAUTRESULTFLAG(0);
				scaRecord.setAUTFAILCAUSE("5017");
				// 也要告警
				
			}
			// 余额
			logger.info("卡内余额" + scaRecord.getCARDBALANCE() + "数据库余额"
					+ scaRecord.getACCOUNTBALANCE());
			if (scaRecord.getACCOUNTBALANCE() > scaRecord.getCARDBALANCE()) {
				// 告警异常 可能离线充电过
				webRecord.setALARMTYPE(2003);
				webFlag = 0;
			} else if (scaRecord.getACCOUNTBALANCE() < scaRecord
					.getCARDBALANCE()) {
				// 数据肯定不对 告警
				webFlag = 0;
				webRecord.setALARMTYPE(2002);
			}
		}
		if (webFlag == 0) {
			logger.info("【BEFORE INSERT Authen WebAlarmRecord】"
					+ webRecord.toString());
			dbOperation.addWebAlarmRecord(webRecord);
			logger.info("【AFTER INSERT Authen WebAlarmRecord】-鉴权操作异常-INSERT");
			logger.info("【DEVICEID】 =" + deviceId + "】");
			logger.info("");
		}
		//han-没用的3个字段，随便填
		scaRecord.setREMAINMILEAGE(1.0f);
		scaRecord.setALLOWQUANTITY(12.34f);
		scaRecord.setREMAINTIMES(3);
		// 已经入库 鉴权然后更新
		//han-收到鉴权报文并解析时入库
		logger.info("【BEFORE UPDATE AuthentiCationRecord】"
				+ scaRecord.toString());
		dbOperation.updateAuthentiCationiRecord(scaRecord);
		logger.info("【AFTER UPDATE AuthentiCationRecord】-鉴权操作完成，更新鉴权数据-UPDATE");
		logger.info("【DEVICEID】 =" + deviceId + "】");
		logger.info("");
		return scaRecord;
	}

	/**
	 * 加工billmodelinfo
	 * @param CPID
	 * @return
	 */
	public static BillModelInfo_DPF handleBillModel(String CPID) {
		// 第一步拿到rateid
		int rateId = DataRelay.cpMap.get(CPID).getRATEID();
		// 根据rateid和当前月份拿到billmodelinfo
		//han-billmodelid为1-12的月份，当前月份拿的是对应当前月份的费率模型
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		//billMap是billModelInfo的对象，key为operatorId_rateId_billModelId,所以取的时候也要这么取
		BillModelInfo_DPF bill_DPF = DataRelay.billMap.get(DataRelay.cpMap.get(
				CPID).getOPERATORID()
				+ "_" + rateId + "_" + month);
		return bill_DPF;
	}

	// 根据bill生成时段和id的byte数组
	public static byte[] getPeriod(BillModelInfo_DPF bill) {
		byte[] period = new byte[24];
		int ipos = 0;
		
		period[ipos++] = (byte) (bill.getTI_1_START() / 60);
		period[ipos++] = (byte) (bill.getTI_1_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_2_START() / 60);
		period[ipos++] = (byte) (bill.getTI_2_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_3_START() / 60);
		period[ipos++] = (byte) (bill.getTI_3_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_4_START() / 60);
		period[ipos++] = (byte) (bill.getTI_4_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_5_START() / 60);
		period[ipos++] = (byte) (bill.getTI_5_ID() + 1);

		////////////////。。。
		period[ipos++] = (byte) (bill.getTI_6_START() / 60);
		period[ipos++] = (byte) (bill.getTI_6_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_7_START() / 60);
		period[ipos++] = (byte) (bill.getTI_7_ID() + 1);

		period[ipos++] = (byte) (bill.getTI_8_START() / 60);
		period[ipos++] = (byte) (bill.getTI_8_ID() + 1);

		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		period[ipos++] = 0x00;
		return period;
	}

	// 拿到充电记录报文 返回充电记录对象
	public static ChargeRecord_DPF getChargeRecord(byte[] buf, String cpid,
			String deviceid, int protocolid) {
		ChargeRecord_DPF chRecord_DPF = new ChargeRecord_DPF(); // 充电记录对象
		int start = 0;
		int data1;
		chRecord_DPF.setCPID(cpid);
		chRecord_DPF.setDEVICEID(deviceid);
		start += 8;
		data1 = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, start, 1));
		chRecord_DPF.setINTERFACEID(data1);
		start += 1;
		// 流水号！！！！！！！！！！！
		chRecord_DPF.setTRANSATIONID(CreateByte.getTransitionId(ByteUtil
				.subBytes(buf, start, 16)));
		start += 16;
		chRecord_DPF.setCPUSERID(CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8)));
		start += 8;
		chRecord_DPF.setCHARGEQUANTITY(ByteUtil.getTTFloat(ByteUtil.subBytes(
				buf, start, 4)));
		start += 4;
		chRecord_DPF.setCHARGEMONEY(ByteUtil.getTTFloat(ByteUtil.subBytes(buf,
				start, 4)));
		start += 4;
		chRecord_DPF.setCHARGESTARTTIME(CreateByte.bytesToTime(
				ByteUtil.subBytes(buf, start, 7)).toString());
		start += 7;
		chRecord_DPF.setCHARGETIMESPAN(ByteUtil.getTTFloat(ByteUtil.subBytes(
				buf, start, 4)));
		start += 4;
		// 充电结束标志和原因 得到的是代号 要转换成字符串
		chRecord_DPF.setCHARGEFINISHEDFLAG(ByteUtil.LbytesToInt(ByteUtil
				.subBytes(buf, start, 1)));
		chRecord_DPF.setCHARGEENDCAUSE(DataRelay.endChargeMap.get(protocolid
				+ "_" + chRecord_DPF.getCHARGEFINISHEDFLAG()));
		start += 1;
		chRecord_DPF.setBILLMODELID(Integer.parseInt(CreateByte
				.bcdToStr(ByteUtil.subBytes(buf, start, 2))));
		start += 8;
		chRecord_DPF
				.setJT(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setFT(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setPT(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setGT(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setJQ(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setFQ(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setPQ(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setGQ(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setJF(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setFF(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setPF(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF
				.setGF(ByteUtil.getTTFloat(ByteUtil.subBytes(buf, start, 4)));
		start += 4;
		chRecord_DPF.setCARDNUM(CreateByte.bcdToStr(ByteUtil.subBytes(buf,
				start, 8)));
		start += 8;
		chRecord_DPF.setCHARGEMETHODID(ByteUtil.LbyteToInt(buf[start]));
		start += 1;
		chRecord_DPF.setCHARGEMODEID(ByteUtil.LbyteToInt(buf[start]));
		start += 1;
		chRecord_DPF.setCHARGEPARA(ByteUtil.getTTFloat(ByteUtil.subBytes(buf,
				start, 4)));
		start += 4;
		chRecord_DPF.setSERVICETIP(ByteUtil.getTTFloat(ByteUtil.subBytes(buf,
				start, 4)));
		chRecord_DPF.setCHARGEMONEY(chRecord_DPF.getCHARGEMONEY()
				- chRecord_DPF.getSERVICETIP());
		start += 4;
		chRecord_DPF.setBEFORECHARGEBALANCE(ByteUtil.getTTFloat(ByteUtil
				.subBytes(buf, start, 4)));
		chRecord_DPF.setOPSTATE("0-PILE"); // 数据状态0刚获取
		return chRecord_DPF;
	}

	// 执行扣款操作 返回扣款操作报文
	public static void getDeductFee(String recordKey) {
		// 拿到充电记录对象
		Map<String, String> crMap = RedisHandle.getMap(recordKey);
		if (crMap == null || crMap.size() < 1) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			logger.info("拿不到充电记录");
			logger.info("recordKey = " + recordKey);
		} else {
			ChargeRecord_DPF cRecord_DPF = (ChargeRecord_DPF) ObjectToMap
					.mapToObject(crMap);
			
			if (cRecord_DPF.getOPSTATE().equals("2-DEDUCT")) {
				logger.info("*******************************");
				logger.info("这条充电记录上次收到已经成功扣款-直接取上次的扣款记录");
			} else if (cRecord_DPF.getOPSTATE().equals("0-PILE")) {
				
				logger.info("#################################");
				// 声明扣款信息对象
				UserDeductMoneyRecord udfRecord = new UserDeductMoneyRecord();
				// 声明告警记录对象
				WebAlarmRecord webRecord = new WebAlarmRecord();
				// 声明错误信息对象
				// 执行扣款操作
				if (cRecord_DPF.getCHARGEMETHODID() == 0) {
					
					float balance = dSelect.findAppUserBalance(String
							.valueOf(cRecord_DPF.getCPUSERID()));
					logger.info("app user chargerecord");
					logger.info("balance = " + balance);
					DeductInfoDto deInfo = new DeductInfoDto();
					deInfo.setCPUSERID(cRecord_DPF.getCPUSERID());
					deInfo.setMONEY(cRecord_DPF.getCHARGEMONEY()
							+ cRecord_DPF.getSERVICETIP());
					int flag = dUpdate.deductAppUserAccount(deInfo);
					if (flag == 1) {
						// 扣款成功
						if (balance < cRecord_DPF.getCHARGEMONEY()
								+ cRecord_DPF.getSERVICETIP()) {
							// 余额不足 扣款异常
							udfRecord.setDEDUCTSUCCESSFLAG(1);
							udfRecord.setDEDUCTFAILREASON("0");
							// 告警记录
							webRecord.setCHARGETYPE(0);
							webRecord.setCPUSERID(cRecord_DPF.getCPUSERID());
							webRecord.setCPID(cRecord_DPF.getCPID());
							webRecord.setGUN(cRecord_DPF.getINTERFACEID());
							webRecord.setRECORDTIME(CreateByte.getCurrTime());
							webRecord.setALARMTYPE(1002);
							logger.info("【BEFORE INSERT Authen WebAlarmRecord】"
									+ webRecord.toString());
							dbOperation.addWebAlarmRecord(webRecord);
							logger.info("【AFTER INSERT Authen WebAlarmRecord】-扣款操作异常-INSERT");
							logger.info("【DEVICEID】 ="
									+ cRecord_DPF.getDEVICEID() + "】");
							logger.info("");
						}
						udfRecord.setDEDUCTSUCCESSFLAG(1);
						udfRecord.setDEDUCTFAILREASON("0");
						udfRecord.setREMAINMONEY(balance - deInfo.getMONEY());
						logger.info("【MODIFY DB DeductAppUserAccount】 执行扣款操作-成功");
						// 扣款成功改变充电记录的状态
						cRecord_DPF.setOPSTATE("2-DEDUCT");
					} else {
						udfRecord.setDEDUCTSUCCESSFLAG(0);
						udfRecord.setDEDUCTFAILREASON("7");
						udfRecord.setREMAINMONEY(balance);
						logger.info("【MODIFY DB DeductAppUserAccount】 执行扣款操作-失败");
					}
				} else if (cRecord_DPF.getCHARGEMETHODID() == 1) {
					float balance = dSelect.findCardUserBalance(Long
							.valueOf(cRecord_DPF.getCARDNUM()));
					logger.info("card user chargerecord");
					logger.info("balance = " + balance);
					DeductInfoDto deInfo = new DeductInfoDto();
					deInfo.setCARDNUM(Long.valueOf(cRecord_DPF.getCARDNUM()));
					deInfo.setMONEY(cRecord_DPF.getCHARGEMONEY()
							+ cRecord_DPF.getSERVICETIP());
					int flag = dUpdate.deductCardUserAccount(deInfo);
					if (flag == 1) {
						// 扣款成功
						if (balance < cRecord_DPF.getCHARGEMONEY()
								+ cRecord_DPF.getSERVICETIP()) {
							// 余额不足 扣款异常
							udfRecord.setDEDUCTSUCCESSFLAG(1);
							udfRecord.setDEDUCTFAILREASON("0");
							// 告警记录
							webRecord.setCHARGETYPE(1);
							webRecord.setCARDNUM(cRecord_DPF.getCARDNUM());
							webRecord.setCPID(cRecord_DPF.getCPID());
							webRecord.setGUN(cRecord_DPF.getINTERFACEID());
							webRecord.setRECORDTIME(CreateByte.getCurrTime());
							webRecord.setALARMTYPE(1002);
							logger.info("【BEFORE INSERT Authen WebAlarmRecord】"
									+ webRecord.toString());
							dbOperation.addWebAlarmRecord(webRecord);
							logger.info("【AFTER INSERT Authen WebAlarmRecord】-鉴权操作异常-INSERT");
							logger.info("【DEVICEID】 ="
									+ cRecord_DPF.getDEVICEID() + "】");
							logger.info("");
						}
						udfRecord.setDEDUCTSUCCESSFLAG(1);
						udfRecord.setDEDUCTFAILREASON("0");
						udfRecord.setREMAINMONEY(balance - deInfo.getMONEY());
						logger.info("【MODIFY DB DeductAppUserAccount】 执行扣款操作-成功");
						// 扣款成功改变充电记录的状态
						cRecord_DPF.setOPSTATE("2-DEDUCT");
					} else {
						udfRecord.setDEDUCTSUCCESSFLAG(0);
						udfRecord.setDEDUCTFAILREASON("7");
						udfRecord.setREMAINMONEY(balance);
						logger.info("【MODIFY DB DeductAppUserAccount】 执行扣款操作-失败");
					}
				}
				udfRecord.setCHARGEMETHOD(cRecord_DPF.getCHARGEMETHODID());
				udfRecord.setCPID(cRecord_DPF.getCPID());
				udfRecord.setDEVICEID(cRecord_DPF.getDEVICEID());
				udfRecord.setRECORDTIME(CreateByte.getCurrTime());
				udfRecord.setINTERFACEID(cRecord_DPF.getINTERFACEID());
				udfRecord.setTRANSATIONID(cRecord_DPF.getTRANSATIONID());
				udfRecord.setPHYSICALCARDNUM(cRecord_DPF.getCARDNUM());
				udfRecord.setCPUSERID(cRecord_DPF.getCPUSERID());
				udfRecord.setCHARGEMONEY(cRecord_DPF.getCHARGEMONEY());
				udfRecord.setSERVICETIP(cRecord_DPF.getSERVICETIP());
				udfRecord.setDEDUCTMONEY(cRecord_DPF.getCHARGEMONEY()
						+ cRecord_DPF.getSERVICETIP());
				udfRecord.setTRANSATIONID(cRecord_DPF.getTRANSATIONID());
				udfRecord.setDEDUCTMILE(3f);
				udfRecord.setREMAINMILE(2f);
				udfRecord.setDEDUCTQUANTITY(3f);
				udfRecord.setREMAINQUANTITY(2f);
				udfRecord.setDEDUCTTIMES(1f); // 扣款次数
				udfRecord.setREMAINTIMES(2f); // 剩余次数
				logger.info("【BEFORE INSERT DeductFeeRecord】"
						+ udfRecord.toString());
				// 扣款记录入库 可能成功或失败
				dbOperation.addDeductFeeRecord(udfRecord);
				logger.info("@@-【RecordKey = " + recordKey);
				logger.info("【INSERT DB UserDeductFee】-执行扣款操作成功或失败-入库");
				logger.info("");
				try {
					logger.info("【Notice APP Success】");
					logger.info("");
					NoticeWeb.noticeChargeOver(udfRecord);
				} catch (IOException e) {
					logger.error("【Notice APP Failed】");
					logger.error("");
				}

				Map<String, String> udfMap = ObjectToMap.getValueMap(udfRecord);
				RedisHandle.setMap(
						udfRecord.getDEVICEID()
								+ "_"
								+ udfRecord.getINTERFACEID()
								+ "_"
								+ StringUtil.getTime(cRecord_DPF
										.getCHARGESTARTTIME()) + "_d", udfMap);
				// 充电记录存到redis
				Map<String, String> crMap2 = ObjectToMap
						.getValueMap(cRecord_DPF);
				RedisHandle.setMap(
						cRecord_DPF.getDEVICEID()
								+ "_"
								+ cRecord_DPF.getINTERFACEID()
								+ "_"
								+ StringUtil.getTime(cRecord_DPF
										.getCHARGESTARTTIME()), crMap2);

			}
		}
	}

	public static void main(String args[]) {
		byte[] a = CreateByte.FloatToBytes(1.0f);
		System.out.println(CreateByte.bytesToHexString(a));
		System.out.println(ByteUtil.getTTFloat(a));
		byte[] c = CreateByte.FloatToBytes(12.34f);
		System.out.println(CreateByte.bytesToHexString(c));
		System.out.println(ByteUtil.getTTFloat(c));
		byte[] b = CreateByte.FloatToBytes(3.0f);
		System.out.println(CreateByte.bytesToHexString(b));
		System.out.println(ByteUtil.getTTFloat(b));

	}
}

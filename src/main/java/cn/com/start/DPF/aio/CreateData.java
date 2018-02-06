package cn.com.start.DPF.aio;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.DPF.entity.BillModelInfo_DPF;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.SwipeCardAutRecord;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;
import cn.com.start.DPF.redis.ObjectToMap;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.socket.ByteMerge;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class CreateData {

	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dbOperation = DBOperation.getInstance();

	// 生成下发初始化报文
	public static byte[] getInitBytes(String CPID) {
		byte[] buf = DataRelay.SychroInitMap.get(CPID);
		return buf;
	}

	// 生成启动帧下发
	public static byte[] getStartUpBytes() {
		byte[] buf = new byte[7];
		int ipos = 0;
		buf[ipos++] = 0x68;
		buf[ipos++] = 0x04;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x07;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		return buf;
	}

	// 生成计费模型下发
	public static byte[] getBillModelBytes(String CPID) {
		//han-获得充电桩对象 
		CPInfo_DPF cpInfo = DataRelay.cpMap.get(CPID);
		//han-获取当前月份的费率模型
		BillModelInfo_DPF bill = DataHandle.handleBillModel(CPID);
		// 报文头 固定部分 4a不是一定的
		byte[] fixed = { 0x68, 0x5E, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x85,
				0x01, 0x06, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x05 };
		// ----2号临时
		String modelKey = cpInfo.getMFRID() + "_" + cpInfo.getMODEL();// 设备byte
		//han-rateid为1位int类型，乘以100变成3位，billmodelid为1-12的月份，两者相加为一个三位数，然后转String
		String rateid = String.valueOf(bill.getRATEID() * 100
				+ bill.getBILLMODELID());
		byte[] deviceId = CreateByte.str2Bcd(cpInfo.getDEVICEID());
		//gun
		byte[] gun = CreateByte.intTo1Bytes(DataRelay.modelMap.get(modelKey)
				.getINTERFACECOUNT());// 枪
		//han-16位0开头，然后是3位，后面跟12位0
		byte[] rate = CreateByte.str2Bcd("0" + rateid + "000000000000");// 费率rateid*100+modelid
		byte[] begin = CreateByte.timeToBytes(bill.getVALIDTIME());// 生效时间
		byte[] end = CreateByte.timeToBytes(bill.getINVALIDTIME());// 失效时间
		byte[] statetype = { 0x00, 0x01, 0x00, 0x01 };// 执行状态// 计量类型
		byte[] temp2 = ByteMerge.byteMerger6(deviceId, gun, rate, begin, end,
				statetype);
		// ----3号临时 固定12个。。。。。
		byte[] count = CreateByte.intTo1Bytes(bill.getTIMEINTERVALCOUNT());// 时段数
		byte[] period = DataHandle.getPeriod(bill);// 时段数组 length*2
		byte[] jian = ByteUtil.getTTBytes(bill.getJPRICE());// 尖峰平谷 4*4
		byte[] feng = ByteUtil.getTTBytes(bill.getFPRICE());
		byte[] ping = ByteUtil.getTTBytes(bill.getPPRICE());
		byte[] gu = ByteUtil.getTTBytes(bill.getGPRICE());
		byte[] temp3 = ByteMerge.byteMerger6(count, period, jian, feng, ping,
				gu);
		byte[] tip = ByteUtil.getTTBytes(bill.getSERVICETIP());
		byte[] buf = ByteMerge.byteMerger4(fixed, temp2, temp3, tip);
		// buf[1] = (byte) (70 + bill.getTIMEINTERVALCOUNT() * 2);
		return buf;
	}

	// 生成心跳报文
	public static byte[] getHBBytes() {
		byte[] buf = new byte[7];
		int ipos = 0;
		buf[ipos++] = 0x68;
		buf[ipos++] = 0x04;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x43;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		return buf;
	}

	// 生成总召报文
	public static byte[] getTotalCall() {
		byte[] buf = new byte[17];
		int ipos = 0;
		buf[ipos++] = 0x68;
		buf[ipos++] = 0x0e;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x64;
		buf[ipos++] = 0x01;
		buf[ipos++] = 0x06;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x01;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x14;
		return buf;
	}

	// 生成校时报文
	public static byte[] getCheckTime() {
		byte[] buf = new byte[23];
		byte[] time = CreateByte.timeToBytes(CreateByte.getCurrTime());
		int ipos = 0;
		int tpos = 0;
		buf[ipos++] = 0x68;
		buf[ipos++] = 0x14;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x67;
		buf[ipos++] = 0x01;
		buf[ipos++] = 0x06;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x01;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = 0x00;
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		buf[ipos++] = time[tpos++];
		return buf;
	}

	// 根据鉴权结果生成鉴权结果报文数据
	public static byte[] getAcBytes(String DeviceId, int gun) {
		// 拿到已经处理过的对象
		SwipeCardAutRecord ac_DPF = DataHandle.ChargeAC(DeviceId, gun);
		// fixhead
		byte[] fixhead = { 0x68, 0x52, 0x00, 0x00, 0x00, 0x00, 0x00,
				(byte) 0x85, 0x01, 0x06, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00,
				0x02 };
		// temp1
		byte[] deviceId = CreateByte.str2Bcd(ac_DPF.getDEVICEID());// 拿到设备idBCD
		byte[] Gun = CreateByte.intTo1Bytes(ac_DPF.getINTERFACEID());// 拿到枪int
		byte[] card = CreateByte.str2Bcd(ac_DPF.getPHYSICALCARDNUM());// 拿到物理卡号
		byte[] userId = CreateByte.str2Bcd(ac_DPF.getCPUSERID());// 拿到用户id long
		byte[] carId = CreateByte.hexStringToBytes(ac_DPF.getEVUNIQUEID());// 拿到汽车唯一标识String
		// 0112000000000000
		byte[] rateId = CreateByte.str2Bcd("0" + ac_DPF.getBILLMODELID()
				+ "000000000000");// 拿到费率信息id
		byte[] buftemp1 = ByteMerge.byteMerger6(deviceId, Gun, card, userId,
				carId, rateId);
		// temp2
		byte[] balance = ByteUtil.getTTBytes(ac_DPF.getCARDBALANCE());// 拿到余额ieee754
		byte[] flag = CreateByte.intTo1Bytes(ac_DPF.getAUTRESULTFLAG());// 拿到鉴权标识
		byte[] reason = CreateByte.str2Bcd(ac_DPF.getAUTFAILCAUSE());// 拿到失败原因转成4位截取2位低位在前
		byte[] mile = ByteUtil.getTTBytes(ac_DPF.getREMAINMILEAGE()); // 拿到剩余里程ieee754
		byte[] quantity = ByteUtil.getTTBytes(ac_DPF.getALLOWQUANTITY());// 拿到可充电量
		byte[] count = ByteUtil.getTTBytes(ac_DPF.getREMAINTIMES());// 拿到剩余次数
		byte[] buftemp2 = ByteMerge.byteMerger6(balance, flag, reason, mile,
				quantity, count);
		byte[] buf = ByteMerge.byteMerger3(fixhead, buftemp1, buftemp2);
		return buf;
	}

	// 根据参数组成启动充电枪报文。
	public static byte[] getSCGBytes(String deviceid, int gun, int mode,
			float value, float balance, String userId) {
		// fixHead
		byte[] fixhead = { 0x68, 0x28, 0x00, 0x00, 0x00, 0x00, 0x00,
				(byte) 0x85, 0x00, 0x06, 0x00, (byte) 0xDB, 0x00, 0x00, 0x00,
				0x00, 0x0D };
		// deviceid gun userid
		byte[] deviceId = CreateByte.str2Bcd(deviceid);// 拿到桩编号的数组
		byte[] Gun = CreateByte.intTo1Bytes(gun);// 拿到枪号
		byte[] UserID = CreateByte.str2Bcd(userId);
		byte[] temp1 = ByteMerge.byteMerger3(deviceId, Gun, UserID);
		// mode value balance
		byte[] Mode = CreateByte.intTo1Bytes(mode);// 拿到充电方式
		byte[] Value = ByteUtil.getTTBytes(value);// 拿到充电设置的值
		byte[] Balance = ByteUtil.getTTBytes(balance);// 拿到余额
		byte[] temp2 = ByteMerge.byteMerger3(Mode, Value, Balance);
		// 最后一步
		byte[] buf = ByteMerge.byteMerger3(fixhead, temp1, temp2);
		return buf;
	}

	public static byte[] getDCSCGBytes(String deviceid, int gun, int mode,
			float value, float balance, String userId, int chargeDcMode) {
		// fixHead
		byte[] fixhead = { 0x68, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00,
				(byte) 0x85, 0x00, 0x06, 0x00, (byte) 0xDB, 0x00, 0x00, 0x00,
				0x00, 0x0D };
		// deviceid gun userid
		byte[] deviceId = CreateByte.str2Bcd(deviceid);// 拿到桩编号的数组
		byte[] Gun = CreateByte.intTo1Bytes(gun);// 拿到枪号
		byte[] UserID = CreateByte.str2Bcd(userId);
		byte[] temp1 = ByteMerge.byteMerger3(deviceId, Gun, UserID);
		// mode value balance
		byte[] Mode = CreateByte.intTo1Bytes(mode);// 拿到充电方式
		byte[] Value = ByteUtil.getTTBytes(value);// 拿到充电设置的值
		byte[] Balance = ByteUtil.getTTBytes(balance);// 拿到余额
		byte[] dcMode = CreateByte.intTo1Bytes(chargeDcMode);
		byte[] temp2 = ByteMerge.byteMerger4(Mode, Value, Balance, dcMode);
		// 最后一步
		byte[] buf = ByteMerge.byteMerger3(fixhead, temp1, temp2);
		return buf;
	}

	// 根据参数组成停止充电枪报文。
	public static byte[] getECGBytes(String deviceid, int gun, String userId) {
		byte[] fixhead = { 0x68, 0x1F, 0x00, 0x00, 0x00, 0x00, 0x00,
				(byte) 0x85, 0x00, 0x06, 0x00, (byte) 0xDB, 0x00, 0x00, 0x00,
				0x00, 0x0E };
		byte[] deviceId = CreateByte.hexStringToBytes(deviceid);// 拿到桩编号数组
		byte[] Gun = CreateByte.intTo1Bytes(gun);// 拿到枪号
		byte[] UserID = CreateByte.str2Bcd(userId);
		byte[] buf = ByteMerge.byteMerger4(fixhead, deviceId, Gun, UserID);
		return buf;
	}

	public static byte[] getDeductFeeBytes(String recordKey) {
		// 执行扣款操作
		byte[] buf = new byte[69];
		// 先去找有没有扣款记录 有就直接用 没有就去扣
		// 从充电记录对象生成扣款记录对象
		DataHandle.getDeductFee(recordKey);
		// 从对象生成报文
		Map<String, String> udfMap = RedisHandle.getMap(recordKey + "_d");
		if (udfMap == null || udfMap.size() < 1) {
			logger.info("找不到扣款记录");
			logger.info("");
		} else {
			UserDeductMoneyRecord udfRecord = (UserDeductMoneyRecord) ObjectToMap
					.mapToObjectD(udfMap);
			byte[] fixhead = { 0x68, 0x42, 0x00, 0x00, 0x00, 0x00, 0x00,
					(byte) 0x85, 0x00, 0x06, 0x00, 0x0B, 0x00, 0x00, 0x00,
					0x00, 0x03 };
			// temp1
			byte[] DeviceId = CreateByte.str2Bcd(udfRecord.getDEVICEID());
			byte[] Gun = CreateByte.intTo1Bytes(udfRecord.getINTERFACEID());
			// /************************////
			byte[] cardnumber = new byte[8];
			if (udfRecord.getCHARGEMETHOD() == 0) {
				cardnumber = CreateByte.str2Bcd(udfRecord.getCPUSERID());
			} else if (udfRecord.getCHARGEMETHOD() == 1) {
				cardnumber = CreateByte.str2Bcd(udfRecord.getPHYSICALCARDNUM());
			}
			byte[] temp1 = ByteMerge.byteMerger3(DeviceId, Gun, cardnumber);
			// temp2
			byte[] fee = ByteUtil.getTTBytes(udfRecord.getDEDUCTMONEY());
			byte[] Balance = ByteUtil.getTTBytes(udfRecord.getREMAINMONEY());
			byte[] Flag = CreateByte.intTo1Bytes(udfRecord
					.getDEDUCTSUCCESSFLAG());
			byte[] Reason = CreateByte.intTo2Bytes(Integer.parseInt(udfRecord
					.getDEDUCTFAILREASON()));
			byte[] temp2 = ByteMerge.byteMerger4(fee, Balance, Flag, Reason);
			// temp3 扣除剩余*里程，电量，次数 暂定
			byte[] demile = ByteUtil.getTTBytes(udfRecord.getDEDUCTMILE());
			byte[] remile = ByteUtil.getTTBytes(udfRecord.getREMAINMILE());
			byte[] dequantity = ByteUtil.getTTBytes(udfRecord
					.getDEDUCTQUANTITY());
			byte[] requantity = ByteUtil.getTTBytes(udfRecord
					.getREMAINQUANTITY());
			byte[] detimes = ByteUtil.getTTBytes(udfRecord.getDEDUCTTIMES());
			byte[] retimes = ByteUtil.getTTBytes(udfRecord.getREMAINTIMES());
			byte[] temp3 = ByteMerge.byteMerger6(demile, remile, dequantity,
					requantity, detimes, retimes);
			byte[] zz = ByteMerge.byteMerger4(fixhead, temp1, temp2, temp3);
			buf = zz;
			
			// 扣费状态入库
			ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
			chargeProgressDto.setCPID(udfRecord.getCPID());
			chargeProgressDto.setCPUSERID(udfRecord.getCPUSERID());
			// 获取redis里面当前用户开始充电时间
			String startTime = RedisHandle.getTString(udfRecord.getCPID()+"_startTime"+udfRecord.getCPUSERID());
			chargeProgressDto.setCHARGESTARTTIME(String.valueOf(startTime));
			// 扣款时间
			chargeProgressDto.setDEDUCTIONTIME(CreateByte.getCurrTime());
			// 扣款成功状态
			chargeProgressDto.setDEDUCTIONSTATUS(String.valueOf(udfRecord.getDEDUCTSUCCESSFLAG()));
			dbOperation.updateDeducuteInfo(chargeProgressDto);
		}
		return buf;
	}
}

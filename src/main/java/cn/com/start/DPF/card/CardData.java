package cn.com.start.DPF.card;

import cn.com.start.DPF.util.socket.ByteMerge;
import cn.com.start.DPF.entity.CardIssueRecord;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChangePINRecord;
import cn.com.start.DPF.entity.ESAMCardData;
import cn.com.start.DPF.entity.ESAMCardIssueRecord;
import cn.com.start.DPF.entity.ISAMCardData;
import cn.com.start.DPF.entity.ISAMCardIssueRecord;
import cn.com.start.DPF.entity.PretreatmentRecord;
import cn.com.start.DPF.entity.ReadBalanceRecord;
import cn.com.start.DPF.entity.ReadCardNumRecord;
import cn.com.start.DPF.entity.RechargeRecord;
import cn.com.start.DPF.entity.ReloadPINRecord;
import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.UnlockGreyRecord;
import cn.com.start.DPF.util.socket.CreateByte;

public class CardData {

	// 生成下发给qt的报文

	// 初始化报文
	public static byte[] getInit(String objectId) {
		byte[] buf = CardRelay.initMap.get(objectId);
		return buf;
	}

	// 生成心跳报文
	public static byte[] getHeartBeat() {
		byte[] buf = { 0x48, 0x68, 0x65, 0x61, 0x72, 0x74 };
		return buf;
	}

	// 发行用户卡
	public static byte[] getSellUserCard(String ipAddress) {
		byte[] head = { 0x00 };
		CardIssueRecord cardIssueRecord = CardRelay.issueUserCardRecordMap.get(ipAddress);
		CardUserInfo cardUserInfo = CardRelay.userCardMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] secretkey = CreateByte.hexStringToBytes("11111111111111111111111111111111");
		byte[] pin = CreateByte.hexStringToBytes(cardUserInfo.getPIN());
		byte[] cardnum = CreateByte.hexStringToBytes(cardUserInfo.getCARDNUM());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(cardIssueRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger7(head, serialPort, baudrate, secretkey, pin, cardnum, userid);
		return buf;
	}

	// 发行ESAM卡
	public static byte[] getSellESAMCard(String ipAddress) {
		byte[] head = { 0x01 };
		ESAMCardIssueRecord esamCardIssueRecord = CardRelay.issueESAMCardRecordMap.get(ipAddress);
		ESAMCardData esamCardData = CardRelay.esamCardMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] secretkey = CreateByte.hexStringToBytes("11111111111111111111111111111111");
		byte[] cardnum = CreateByte.hexStringToBytes(esamCardData.getCARDNUM());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(esamCardIssueRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger6(head, serialPort, baudrate, secretkey, cardnum, userid);
		return buf;
	}

	// 发行ESAM卡
	public static byte[] getSellISAMCard(String ipAddress) {
		byte[] head = { 0x02 };
		ISAMCardIssueRecord isamCardIssueRecord = CardRelay.issueISAMCardRecordMap.get(ipAddress);
		ISAMCardData isamCardData = CardRelay.isamCardMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] secretkey = CreateByte.hexStringToBytes("11111111111111111111111111111111");
		byte[] cardnum = CreateByte.hexStringToBytes(isamCardData.getCARDNUM());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(isamCardIssueRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger6(head, serialPort, baudrate, secretkey, cardnum, userid);
		return buf;
	}

	// 修改用户卡pin
	public static byte[] getUserCardPIN(String ipAddress) {
		byte[] head = { 0x03 };
		ChangePINRecord changePINRecord = CardRelay.changePINRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] oldpin = CreateByte.hexStringToBytes(changePINRecord.getOLDPIN());
		byte[] newpin = CreateByte.hexStringToBytes(changePINRecord.getNEWPIN());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(changePINRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger6(head, serialPort, baudrate, oldpin, newpin, userid);
		return buf;
	}

	// 重载pin
	public static byte[] getReloadPIN(String ipAddress) {
		byte[] head = { 0x04 };
		ReloadPINRecord reloadPINRecord = CardRelay.reloadPINRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] newpin = CreateByte.hexStringToBytes(reloadPINRecord.getNEWPIN());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(reloadPINRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger5(head, serialPort, baudrate, newpin, userid);
		return buf;
	}

	// 读取用户卡号
	public static byte[] getUserCard(String ipAddress) {
		byte[] head = { 0x05 };
		ReadCardNumRecord readCardNumRecord = CardRelay.readCardNumRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(readCardNumRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger4(head, serialPort, baudrate, userid);
		return buf;
	}

	// 读取用户余额
	public static byte[] getUserBalance(String ipAddress) {
		byte[] head = { 0x06 };
		ReadBalanceRecord readBalanceRecord = CardRelay.readBalanceRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] pin = CreateByte.hexStringToBytes(readBalanceRecord.getPIN());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(readBalanceRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger5(head, serialPort, baudrate, pin, userid);
		return buf;
	}

	// 用户卡充值
	public static byte[] getUserCardRecharge(String ipAddress) {
		byte[] head = { 0x07 };
		RechargeRecord rechargeRecord = CardRelay.rechargeRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] money = CreateByte.intToFourBytes(rechargeRecord.getMONEYS());
		byte[] cardNum = CreateByte.hexStringToBytes(rechargeRecord.getCARDNUM());
		byte[] pin = CreateByte.hexStringToBytes(rechargeRecord.getPIN());
		byte[] rechargeTime = CreateByte.hexStringToBytes(rechargeRecord.getRECHARGETIME());
		byte[] rechargeTimes = CreateByte.intTo3Bytes(rechargeRecord.getRECHARGETIMES());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(rechargeRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger9(head, serialPort, baudrate, money, cardNum, pin, rechargeTime, rechargeTimes, userid);
		return buf;
	}

	// 联机解扣
	public static byte[] getUnlockGrey(String ipAddress) {
		byte[] head = { 0x08 };
		UnlockGreyRecord unlockGreyRecord = CardRelay.unlockGreyRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] money = CreateByte.intToFourBytes(unlockGreyRecord.getMONEYS());
		byte[] pin = CreateByte.hexStringToBytes(unlockGreyRecord.getPIN());
		byte[] time = CreateByte.hexStringToBytes(unlockGreyRecord.getTRADETIME());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(unlockGreyRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger7(head, serialPort, baudrate, money, pin, time, userid);
		return buf;
	}

	// 预处理
	public static byte[] getPretreatment(String ipAddress) {
		byte[] head = { 0x09 };
		PretreatmentRecord pretreatmentRecord = CardRelay.pretreatmentRecordMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes("COM0");
		byte[] baudrate = CreateByte.intToTwoBytes(9600);
		byte[] pin = CreateByte.hexStringToBytes(pretreatmentRecord.getPIN());
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt(pretreatmentRecord.getUSERID()));
		byte[] buf = ByteMerge.byteMerger5(head, serialPort, baudrate, pin, userid);
		return buf;
	}

	// 读取终端isam卡号
	public static byte[] getISAMCardNumber(String ipAddress) {
		byte[] head = { 0x0A };
		CardUserInfo cardUserInfo = CardRelay.userCardMap.get(ipAddress);
		byte[] serialPort = {};
		byte[] baudrate = {};
		byte[] pin = {};
		byte[] buf = new byte[10];
		return buf;
	}
	
	//串口配置
	public static byte[] getPortConfig(String ipAddress) {
		byte[] head = { 0x0B };
		SerialPortConfig serialPortConfig = CardRelay.serialPortConfigMap.get(ipAddress);
		byte[] serialPort = CreateByte.stringToASCIIBytes(serialPortConfig.getSERIALPORT());
		byte[] baudrate = CreateByte.intToTwoBytes(serialPortConfig.getBAUDRATE());
		byte[] secretkey = CreateByte.hexStringToBytes(serialPortConfig.getSECRETKEY());
		byte[] buf = ByteMerge.byteMerger4(head, serialPort, baudrate, secretkey);
		return buf;
	}
}

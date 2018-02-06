package cn.com.start.webBack.dto;

public class UserCardChargeDto {
	private String CHARGESTARTTIME; // 开始时间
	private String CHARGEENDTIME; // 结束时间
	private String CPID; // 桩ID
	private String DEDUCTMONEY; // 充电金额
	private String SERVICETIP; // 服务费
	private String CHARGEMONEY; // 充电费
	private String CHARGEQUANTITY; // 充电电量
	private String CARDNUM; // 卡号
	private String CHARGETIMESPAN; // 充电时长
	private String CARDCOUNT;
	private String OPERATORNAME; // 运营商
	private String CSNAME; // 充电站

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}

	public String getCHARGESTARTTIME() {
		return CHARGESTARTTIME;
	}

	public void setCHARGESTARTTIME(String cHARGESTARTTIME) {
		CHARGESTARTTIME = cHARGESTARTTIME;
	}

	public String getCHARGEENDTIME() {
		return CHARGEENDTIME;
	}

	public void setCHARGEENDTIME(String cHARGEENDTIME) {
		CHARGEENDTIME = cHARGEENDTIME;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getDEDUCTMONEY() {
		return DEDUCTMONEY;
	}

	public void setDEDUCTMONEY(String dEDUCTMONEY) {
		DEDUCTMONEY = dEDUCTMONEY;
	}

	public String getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}

	public void setCHARGEQUANTITY(String cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}

	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}

	@Override
	public String toString() {
		return "UserCardChargeDto [CHARGESTARTTIME=" + CHARGESTARTTIME
				+ ", CHARGEENDTIME=" + CHARGEENDTIME + ", CPID=" + CPID
				+ ", DEDUCTMONEY=" + DEDUCTMONEY + ", SERVICETIP=" + SERVICETIP
				+ ", CHARGEMONEY=" + CHARGEMONEY + ", CHARGEQUANTITY="
				+ CHARGEQUANTITY + ", CARDNUM=" + CARDNUM + ", CHARGETIMESPAN="
				+ CHARGETIMESPAN + ", CARDCOUNT=" + CARDCOUNT
				+ ", OPERATORNAME=" + OPERATORNAME + ", CSNAME=" + CSNAME + "]";
	}

	public String getSERVICETIP() {
		return SERVICETIP;
	}

	public void setSERVICETIP(String sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}

	public String getCHARGEMONEY() {
		return CHARGEMONEY;
	}

	public void setCHARGEMONEY(String cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}

	public String getCARDCOUNT() {
		return CARDCOUNT;
	}

	public void setCARDCOUNT(String cARDCOUNT) {
		CARDCOUNT = cARDCOUNT;
	}

}

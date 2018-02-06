package cn.com.start.webBack.dto;

public class UserChargeDto {
	// 用户姓名
	private String CPUSERNAME;
	// 开始时间
	private String CHARGESTARTTIME;
	// 结束时间
	private String CHARGEENDTIME;
	// 车牌号
	private String PLATENUMBER;
	// 充电量
	private float CHARGEQUANTITY;
	// 充电费用
	private float CHARGEMONEY;
	// 信用
	private String CHARGETIMESPAN;
	//充电时长
	private Integer CHARGETIMESPANINT;
	// 电话
	private String TELEPHONE;
	// 枪
	private String INTERFACEID;
	
	private float SERVICETIP;
	
	private String CPUSERCOUNT;
	
	private String CPUSERID;
	
	private String CARDNUM;
	
	private String CPID;
	private String CPNAME;
	private String CSID;
	private String CSNAME;
	private String CPCOUNT;
	private String OPERATORID;
	private String OPERATORNAME;
	public String getCPUSERNAME() {
		return CPUSERNAME;
	}
	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
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
	public String getPLATENUMBER() {
		return PLATENUMBER;
	}
	public void setPLATENUMBER(String pLATENUMBER) {
		PLATENUMBER = pLATENUMBER;
	}
	public float getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}
	public void setCHARGEQUANTITY(float cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}
	public float getCHARGEMONEY() {
		return CHARGEMONEY;
	}
	public void setCHARGEMONEY(float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}
	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}
	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}
	public Integer getCHARGETIMESPANINT() {
		return CHARGETIMESPANINT;
	}
	public void setCHARGETIMESPANINT(Integer cHARGETIMESPANINT) {
		CHARGETIMESPANINT = cHARGETIMESPANINT;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	public String getINTERFACEID() {
		return INTERFACEID;
	}
	public void setINTERFACEID(String iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}
	public float getSERVICETIP() {
		return SERVICETIP;
	}
	public void setSERVICETIP(float sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}
	public String getCPUSERCOUNT() {
		return CPUSERCOUNT;
	}
	public void setCPUSERCOUNT(String cPUSERCOUNT) {
		CPUSERCOUNT = cPUSERCOUNT;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getCPNAME() {
		return CPNAME;
	}
	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}
	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	public String getCSNAME() {
		return CSNAME;
	}
	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}
	public String getCPCOUNT() {
		return CPCOUNT;
	}
	public void setCPCOUNT(String cPCOUNT) {
		CPCOUNT = cPCOUNT;
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
	@Override
	public String toString() {
		return "UserChargeDto [CPUSERNAME=" + CPUSERNAME + ", CHARGESTARTTIME=" + CHARGESTARTTIME + ", CHARGEENDTIME="
				+ CHARGEENDTIME + ", PLATENUMBER=" + PLATENUMBER + ", CHARGEQUANTITY=" + CHARGEQUANTITY
				+ ", CHARGEMONEY=" + CHARGEMONEY + ", CHARGETIMESPAN=" + CHARGETIMESPAN + ", CHARGETIMESPANINT="
				+ CHARGETIMESPANINT + ", TELEPHONE=" + TELEPHONE + ", INTERFACEID=" + INTERFACEID + ", SERVICETIP="
				+ SERVICETIP + ", CPUSERCOUNT=" + CPUSERCOUNT + ", CPUSERID=" + CPUSERID + ", CARDNUM=" + CARDNUM
				+ ", CPID=" + CPID + ", CPNAME=" + CPNAME + ", CSID=" + CSID + ", CSNAME=" + CSNAME + ", CPCOUNT="
				+ CPCOUNT + ", OPERATORID=" + OPERATORID + ", OPERATORNAME=" + OPERATORNAME + "]";
	}
	

}
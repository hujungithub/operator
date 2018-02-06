package cn.com.start.webBack.dto;

public class OperInfoDto {
	
	private String CPID;
	private String CPNAME;
	private String OPERDAYS;
	private String CHARGECOUNT;
	private String CHARGEQUANTITY;
	private String CHARGEMONEY;
	private String SERVICETIP;
	private String DEDUCTMONEY;
	private String CPCOUNT;
	private String CPUSERCOUNT;
	
	public String getCPUSERCOUNT() {
		return CPUSERCOUNT;
	}
	public void setCPUSERCOUNT(String cPUSERCOUNT) {
		CPUSERCOUNT = cPUSERCOUNT;
	}
	public String getCPCOUNT() {
		return CPCOUNT;
	}
	public void setCPCOUNT(String cPCOUNT) {
		CPCOUNT = cPCOUNT;
	}
	public String getDEDUCTMONEY() {
		return DEDUCTMONEY;
	}
	public void setDEDUCTMONEY(String dEDUCTMONEY) {
		DEDUCTMONEY = dEDUCTMONEY;
	}
	public String getSERVICETIP() {
		return SERVICETIP;
	}
	public void setSERVICETIP(String sERVICETIP) {
		SERVICETIP = sERVICETIP;
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
	public String getOPERDAYS() {
		return OPERDAYS;
	}
	public void setOPERDAYS(String oPERDAYS) {
		OPERDAYS = oPERDAYS;
	}
	public String getCHARGECOUNT() {
		return CHARGECOUNT;
	}
	public void setCHARGECOUNT(String cHARGECOUNT) {
		CHARGECOUNT = cHARGECOUNT;
	}
	public String getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}
	public void setCHARGEQUANTITY(String cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}
	public String getCHARGEMONEY() {
		return CHARGEMONEY;
	}
	public void setCHARGEMONEY(String cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}
	@Override
	public String toString() {
		return "OperInfoDto [CPID=" + CPID + ", CPNAME=" + CPNAME
				+ ", OPERDAYS=" + OPERDAYS + ", CHARGECOUNT=" + CHARGECOUNT
				+ ", CHARGEQUANTITY=" + CHARGEQUANTITY + ", CHARGEMONEY="
				+ CHARGEMONEY + ", SERVICETIP=" + SERVICETIP + ", DEDUCTMONEY="
				+ DEDUCTMONEY + ", CPCOUNT=" + CPCOUNT + ", CPUSERCOUNT="
				+ CPUSERCOUNT + "]";
	}
	
	

}

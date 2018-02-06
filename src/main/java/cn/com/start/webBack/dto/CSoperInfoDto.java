package cn.com.start.webBack.dto;

public class CSoperInfoDto {
	
	private String CSID;
	private String CSNAME;
	private String CHARGEQUANTITY;
	private String CHARGEMONEY;
	private String SERVICETIP;
	private String CSCOUNT;
	private String CREATETIME;
	private String CHARGETIMESPAN;
	private String MONEYCOUNT;
	
	
	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}
	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}
	public String getMONEYCOUNT() {
		return MONEYCOUNT;
	}
	public void setMONEYCOUNT(String mONEYCOUNT) {
		MONEYCOUNT = mONEYCOUNT;
	}
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getCSCOUNT() {
		return CSCOUNT;
	}
	public void setCSCOUNT(String cSCOUNT) {
		CSCOUNT = cSCOUNT;
	}
	public String getSERVICETIP() {
		return SERVICETIP;
	}
	public void setSERVICETIP(String sERVICETIP) {
		SERVICETIP = sERVICETIP;
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
		return "CSoperInfoDto [CSID=" + CSID + ", CSNAME=" + CSNAME
				+ ", CHARGEQUANTITY=" + CHARGEQUANTITY + ", CHARGEMONEY="
				+ CHARGEMONEY + ", SERVICETIP=" + SERVICETIP + ", CSCOUNT="
				+ CSCOUNT + ", CREATETIME=" + CREATETIME + ", CHARGETIMESPAN="
				+ CHARGETIMESPAN + ", MONEYCOUNT=" + MONEYCOUNT + "]";
	}
	
	

}

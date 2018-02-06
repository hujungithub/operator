package cn.com.start.webBack.dto;

public class ReportLostDto {
	@Override
	public String toString() {
		return "ReportLostDto [CARDNUM=" + CARDNUM + ", IDENTITYCARDNUM="
				+ IDENTITYCARDNUM + ", OPTIME=" + OPTIME + ", USERID=" + USERID
				+ "]";
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getIDENTITYCARDNUM() {
		return IDENTITYCARDNUM;
	}
	public void setIDENTITYCARDNUM(String iDENTITYCARDNUM) {
		IDENTITYCARDNUM = iDENTITYCARDNUM;
	}
	public String getOPTIME() {
		return OPTIME;
	}
	public void setOPTIME(String oPTIME) {
		OPTIME = oPTIME;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	private String CARDNUM;
	private String IDENTITYCARDNUM;
	private String OPTIME;
	private String USERID;
}

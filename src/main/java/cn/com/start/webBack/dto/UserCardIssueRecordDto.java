package cn.com.start.webBack.dto;

public class UserCardIssueRecordDto {
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getCARDUSERNAME() {
		return CARDUSERNAME;
	}
	public void setCARDUSERNAME(String cARDUSERNAME) {
		CARDUSERNAME = cARDUSERNAME;
	}
	public String getIDENTITY() {
		return IDENTITY;
	}
	public void setIDENTITY(String iDENTITY) {
		IDENTITY = iDENTITY;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getSENDRECORDTIME() {
		return SENDRECORDTIME;
	}
	public void setSENDRECORDTIME(String sENDRECORDTIME) {
		SENDRECORDTIME = sENDRECORDTIME;
	}
	public String getOPENCARDRESULT() {
		return OPENCARDRESULT;
	}
	public void setOPENCARDRESULT(String oPENCARDRESULT) {
		OPENCARDRESULT = oPENCARDRESULT;
	}
	public String getINITIALKEY() {
		return INITIALKEY;
	}
	public void setINITIALKEY(String iNITIALKEY) {
		INITIALKEY = iNITIALKEY;
	}
	public String getLOGINID() {
		return LOGINID;
	}
	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}
	@Override
	public String toString() {
		return "UserCardIssueRecordDto [CARDNUM=" + CARDNUM + ", CARDUSERNAME="
				+ CARDUSERNAME + ", IDENTITY=" + IDENTITY + ", PHONE=" + PHONE
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", OPENCARDRESULT="
				+ OPENCARDRESULT + ", INITIALKEY=" + INITIALKEY + ", LOGINID="
				+ LOGINID + ", OPERATORNAME=" + OPERATORNAME + "]";
	}
	private String CARDNUM;
	private String CARDUSERNAME;
	private String IDENTITY;
	private String PHONE;
	private String SENDRECORDTIME;
	private String OPENCARDRESULT;
	private String INITIALKEY;
	private String LOGINID;
	private String OPERATORNAME;
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
}

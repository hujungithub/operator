package cn.com.start.webBack.dto;

public class ModifyMoneyRecord {
	private String CARDNUM;
	private float ACCOUNTSUM;
	private float MODIFIEDACCOUNTSUM;
	private String OPTIME;
	private String USERID;
	private String OPERATORLOGINID;
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public float getACCOUNTSUM() {
		return ACCOUNTSUM;
	}
	public void setACCOUNTSUM(float aCCOUNTSUM) {
		ACCOUNTSUM = aCCOUNTSUM;
	}
	public float getMODIFIEDACCOUNTSUM() {
		return MODIFIEDACCOUNTSUM;
	}
	public void setMODIFIEDACCOUNTSUM(float mODIFIEDACCOUNTSUM) {
		MODIFIEDACCOUNTSUM = mODIFIEDACCOUNTSUM;
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
	@Override
	public String toString() {
		return "ModifyMoneyRecord [CARDNUM=" + CARDNUM + ", ACCOUNTSUM=" + ACCOUNTSUM + ", MODIFIEDACCOUNTSUM="
				+ MODIFIEDACCOUNTSUM + ", OPTIME=" + OPTIME + ", USERID=" + USERID + ", OPERATORLOGINID="
				+ OPERATORLOGINID + "]";
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}
	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}
}

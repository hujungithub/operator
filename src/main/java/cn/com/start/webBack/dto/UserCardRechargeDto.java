package cn.com.start.webBack.dto;

public class UserCardRechargeDto {
	@Override
	public String toString() {
		return "UserCardRechargeDto [CARDNUM=" + CARDNUM + ", MONEY=" + MONEY
				+ ", RECHARGETIME=" + RECHARGETIME + ", RECHARGERESULT="
				+ RECHARGERESULT + ", LOGINID=" + LOGINID + ", BALANCE="
				+ BALANCE + ", OPERATORNAME=" + OPERATORNAME + "]";
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getMONEY() {
		return MONEY;
	}
	public void setMONEY(String mONEY) {
		MONEY = mONEY;
	}
	public String getRECHARGETIME() {
		return RECHARGETIME;
	}
	public void setRECHARGETIME(String rECHARGETIME) {
		RECHARGETIME = rECHARGETIME;
	}
	public String getRECHARGERESULT() {
		return RECHARGERESULT;
	}
	public void setRECHARGERESULT(String rECHARGERESULT) {
		RECHARGERESULT = rECHARGERESULT;
	}
	public String getLOGINID() {
		return LOGINID;
	}
	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}
	private String CARDNUM;
	private String MONEY;
	private String RECHARGETIME;
	private String RECHARGERESULT;
	private String LOGINID;
	private float BALANCE;
	private String OPERATORNAME;
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
	public float getBALANCE() {
		return BALANCE;
	}
	public void setBALANCE(float bALANCE) {
		BALANCE = bALANCE;
	}
}

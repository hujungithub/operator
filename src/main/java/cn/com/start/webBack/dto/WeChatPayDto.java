package cn.com.start.webBack.dto;

public class WeChatPayDto {

	private String TRANSACTIONNUM;
	
	private String USERID;
	
	private String PAYTIME;
	
	private String REFUNDTIME;
	
	private String PAYMONEY;
	
	private String REFUNDMONEY;
	
	private String DESP;
	
	private String REFUNDSTATUS;
	
	private String CHARGESTATE;
	
	private String OPENID;

	public String getTRANSACTIONNUM() {
		return TRANSACTIONNUM;
	}

	public void setTRANSACTIONNUM(String tRANSACTIONNUM) {
		TRANSACTIONNUM = tRANSACTIONNUM;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPAYTIME() {
		return PAYTIME;
	}

	public void setPAYTIME(String pAYTIME) {
		PAYTIME = pAYTIME;
	}

	public String getREFUNDTIME() {
		return REFUNDTIME;
	}

	public void setREFUNDTIME(String rEFUNDTIME) {
		REFUNDTIME = rEFUNDTIME;
	}

	public String getPAYMONEY() {
		return PAYMONEY;
	}

	public void setPAYMONEY(String pAYMONEY) {
		PAYMONEY = pAYMONEY;
	}

	public String getREFUNDMONEY() {
		return REFUNDMONEY;
	}

	public void setREFUNDMONEY(String rEFUNDMONEY) {
		REFUNDMONEY = rEFUNDMONEY;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

	public String getREFUNDSTATUS() {
		return REFUNDSTATUS;
	}

	public void setREFUNDSTATUS(String rEFUNDSTATUS) {
		REFUNDSTATUS = rEFUNDSTATUS;
	}
	

	public String getCHARGESTATE() {
		return CHARGESTATE;
	}

	public void setCHARGESTATE(String cHARGESTATE) {
		CHARGESTATE = cHARGESTATE;
	}

	@Override
	public String toString() {
		return "WeChatPayDto [TRANSACTIONNUM=" + TRANSACTIONNUM + ", USERID="
				+ USERID + ", PAYTIME=" + PAYTIME + ", REFUNDTIME="
				+ REFUNDTIME + ", PAYMONEY=" + PAYMONEY + ", REFUNDMONEY="
				+ REFUNDMONEY + ", DESP=" + DESP + ", REFUNDSTATUS="
				+ REFUNDSTATUS + ", CHARGESTATE=" + CHARGESTATE + "]";
	}

	public String getOPENID() {
		return OPENID;
	}

	public void setOPENID(String oPENID) {
		OPENID = oPENID;
	}
	
	
	
	

}

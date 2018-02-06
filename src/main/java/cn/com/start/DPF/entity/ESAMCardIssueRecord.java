package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class ESAMCardIssueRecord {
	public BigInteger getID() {
		return ID;
	}
	public void setID(BigInteger iD) {
		ID = iD;
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public int getSERIALNO() {
		return SERIALNO;
	}
	public void setSERIALNO(int sERIALNO) {
		SERIALNO = sERIALNO;
	}
	public String getSENDRECORDTIME() {
		return SENDRECORDTIME;
	}
	public void setSENDRECORDTIME(String sENDRECORDTIME) {
		SENDRECORDTIME = sENDRECORDTIME;
	}
	public String getGETREPLYTIME() {
		return GETREPLYTIME;
	}
	public void setGETREPLYTIME(String gETREPLYTIME) {
		GETREPLYTIME = gETREPLYTIME;
	}
	public int getOPENCARDSTATE() {
		return OPENCARDSTATE;
	}
	public void setOPENCARDSTATE(int oPENCARDSTATE) {
		OPENCARDSTATE = oPENCARDSTATE;
	}
	public int getOPENCARDRESULT() {
		return OPENCARDRESULT;
	}
	public void setOPENCARDRESULT(int oPENCARDRESULT) {
		OPENCARDRESULT = oPENCARDRESULT;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	@Override
	public String toString() {
		return "ESAMCardIssueRecord [ID=" + ID + ", CARDNUM=" + CARDNUM
				+ ", SERIALNO=" + SERIALNO + ", SENDRECORDTIME="
				+ SENDRECORDTIME + ", GETREPLYTIME=" + GETREPLYTIME
				+ ", OPENCARDSTATE=" + OPENCARDSTATE + ", OPENCARDRESULT="
				+ OPENCARDRESULT + ", USERID=" + USERID + "]";
	}
	private BigInteger ID;
	private String CARDNUM;
	private int SERIALNO;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int OPENCARDSTATE;
	private int OPENCARDRESULT;
	private String USERID;
}

package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class PretreatmentRecord {
	public BigInteger getID() {
		return ID;
	}
	public void setID(BigInteger iD) {
		ID = iD;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public int getSERIALNO() {
		return SERIALNO;
	}
	public void setSERIALNO(int sERIALNO) {
		SERIALNO = sERIALNO;
	}
	public String getINITKEY() {
		return INITKEY;
	}
	public void setINITKEY(String iNITKEY) {
		INITKEY = iNITKEY;
	}
	public String getSERIALPORT() {
		return SERIALPORT;
	}
	public void setSERIALPORT(String sERIALPORT) {
		SERIALPORT = sERIALPORT;
	}
	public String getBAUDRATE() {
		return BAUDRATE;
	}
	public void setBAUDRATE(String bAUDRATE) {
		BAUDRATE = bAUDRATE;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
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
	public int getPRETREATMENTSTATE() {
		return PRETREATMENTSTATE;
	}
	public void setPRETREATMENTSTATE(int pRETREATMENTSTATE) {
		PRETREATMENTSTATE = pRETREATMENTSTATE;
	}
	public int getPRETREATMENTRESULT() {
		return PRETREATMENTRESULT;
	}
	public void setPRETREATMENTRESULT(int pRETREATMENTRESULT) {
		PRETREATMENTRESULT = pRETREATMENTRESULT;
	}
	@Override
	public String toString() {
		return "PretreatmentRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", INITKEY=" + INITKEY
				+ ", SERIALPORT=" + SERIALPORT + ", BAUDRATE=" + BAUDRATE
				+ ", PIN=" + PIN + ", SENDRECORDTIME=" + SENDRECORDTIME
				+ ", GETREPLYTIME=" + GETREPLYTIME + ", PRETREATMENTSTATE="
				+ PRETREATMENTSTATE + ", PRETREATMENTRESULT="
				+ PRETREATMENTRESULT + "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String PIN;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int PRETREATMENTSTATE;
	private int PRETREATMENTRESULT;
}

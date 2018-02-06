package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class ReadBalanceRecord {
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
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
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
	public int getREADBALANCESTATE() {
		return READBALANCESTATE;
	}
	public void setREADBALANCESTATE(int rEADBALANCESTATE) {
		READBALANCESTATE = rEADBALANCESTATE;
	}
	public int getREADBALANCERESULT() {
		return READBALANCERESULT;
	}
	public void setREADBALANCERESULT(int rEADBALANCERESULT) {
		READBALANCERESULT = rEADBALANCERESULT;
	}
	@Override
	public String toString() {
		return "ReadBalanceRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", PIN=" + PIN + ", INITKEY="
				+ INITKEY + ", SERIALPORT=" + SERIALPORT + ", BAUDRATE="
				+ BAUDRATE + ", SENDRECORDTIME=" + SENDRECORDTIME
				+ ", GETREPLYTIME=" + GETREPLYTIME + ", READBALANCESTATE="
				+ READBALANCESTATE + ", READBALANCERESULT=" + READBALANCERESULT
				+ "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String PIN;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int READBALANCESTATE;
	private int READBALANCERESULT;
}

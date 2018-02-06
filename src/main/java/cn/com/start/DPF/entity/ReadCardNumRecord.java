package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class ReadCardNumRecord {
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
	public int getREADCARDNUMSTATE() {
		return READCARDNUMSTATE;
	}
	public void setREADCARDNUMSTATE(int rEADCARDNUMSTATE) {
		READCARDNUMSTATE = rEADCARDNUMSTATE;
	}
	public int getREADCARDNUMRESULT() {
		return READCARDNUMRESULT;
	}
	public void setREADCARDNUMRESULT(int rEADCARDNUMRESULT) {
		READCARDNUMRESULT = rEADCARDNUMRESULT;
	}
	@Override
	public String toString() {
		return "ReadCardNumRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", INITKEY=" + INITKEY
				+ ", SERIALPORT=" + SERIALPORT + ", BAUDRATE=" + BAUDRATE
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", GETREPLYTIME="
				+ GETREPLYTIME + ", READCARDNUMSTATE=" + READCARDNUMSTATE
				+ ", READCARDNUMRESULT=" + READCARDNUMRESULT + "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int READCARDNUMSTATE;
	private int READCARDNUMRESULT;
}

package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class ReloadPINRecord {
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
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getNEWPIN() {
		return NEWPIN;
	}
	public void setNEWPIN(String nEWPIN) {
		NEWPIN = nEWPIN;
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
	public int getRELOADPINSTATE() {
		return RELOADPINSTATE;
	}
	public void setRELOADPINSTATE(int rELOADPINSTATE) {
		RELOADPINSTATE = rELOADPINSTATE;
	}
	public int getRELOADPINRESULT() {
		return RELOADPINRESULT;
	}
	public void setRELOADPINRESULT(int rELOADPINRESULT) {
		RELOADPINRESULT = rELOADPINRESULT;
	}
	@Override
	public String toString() {
		return "ReloadPINRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", INITKEY=" + INITKEY
				+ ", SERIALPORT=" + SERIALPORT + ", BAUDRATE=" + BAUDRATE
				+ ", CARDNUM=" + CARDNUM + ", NEWPIN=" + NEWPIN
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", GETREPLYTIME="
				+ GETREPLYTIME + ", RELOADPINSTATE=" + RELOADPINSTATE
				+ ", RELOADPINRESULT=" + RELOADPINRESULT + "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String CARDNUM;
	private String NEWPIN;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int RELOADPINSTATE;
	private int RELOADPINRESULT;
}

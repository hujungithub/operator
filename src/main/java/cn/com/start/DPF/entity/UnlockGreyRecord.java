package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class UnlockGreyRecord {
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
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public double getMONEY() {
		return MONEY;
	}
	public void setMONEY(double mONEY) {
		MONEY = mONEY;
	}
	public int getMONEYS() {
		return MONEYS;
	}
	public void setMONEYS(int mONEYS) {
		MONEYS = mONEYS;
	}
	public String getTRADETIME() {
		return TRADETIME;
	}
	public void setTRADETIME(String tRADETIME) {
		TRADETIME = tRADETIME;
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
	public int getUNLOCKGREYSTATE() {
		return UNLOCKGREYSTATE;
	}
	public void setUNLOCKGREYSTATE(int uNLOCKGREYSTATE) {
		UNLOCKGREYSTATE = uNLOCKGREYSTATE;
	}
	public int getUNLOCKGREYRESULT() {
		return UNLOCKGREYRESULT;
	}
	public void setUNLOCKGREYRESULT(int uNLOCKGREYRESULT) {
		UNLOCKGREYRESULT = uNLOCKGREYRESULT;
	}
	public String getTRADEDATE() {
		return TRADEDATE;
	}
	public void setTRADEDATE(String tRADEDATE) {
		TRADEDATE = tRADEDATE;
	}
	public String getTRADESEC() {
		return TRADESEC;
	}
	public void setTRADESEC(String tRADESEC) {
		TRADESEC = tRADESEC;
	}
	@Override
	public String toString() {
		return "UnlockGreyRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", INITKEY=" + INITKEY
				+ ", SERIALPORT=" + SERIALPORT + ", BAUDRATE=" + BAUDRATE
				+ ", CARDNUM=" + CARDNUM + ", PIN=" + PIN + ", MONEY=" + MONEY
				+ ", MONEYS=" + MONEYS + ", TRADETIME=" + TRADETIME
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", GETREPLYTIME="
				+ GETREPLYTIME + ", UNLOCKGREYSTATE=" + UNLOCKGREYSTATE
				+ ", UNLOCKGREYRESULT=" + UNLOCKGREYRESULT + ", TRADEDATE="
				+ TRADEDATE + ", TRADESEC=" + TRADESEC + "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String CARDNUM;
	private String PIN;
	private double MONEY;
	private int MONEYS;
	private String TRADETIME;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int UNLOCKGREYSTATE;
	private int UNLOCKGREYRESULT;
	private String TRADEDATE;
	private String TRADESEC;
}

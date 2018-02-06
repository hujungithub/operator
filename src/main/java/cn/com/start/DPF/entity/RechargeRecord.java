package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class RechargeRecord {
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
	public int getMONEY() {
		return MONEY;
	}
	public void setMONEY(int mONEY) {
		MONEY = mONEY;
	}
	public String getRECHARGETIME() {
		return RECHARGETIME;
	}
	public void setRECHARGETIME(String rECHARGETIME) {
		RECHARGETIME = rECHARGETIME;
	}
	public int getRECHARGETIMES() {
		return RECHARGETIMES;
	}
	public void setRECHARGETIMES(int rECHARGETIMES) {
		RECHARGETIMES = rECHARGETIMES;
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
	public int getRECHARGESTATE() {
		return RECHARGESTATE;
	}
	public void setRECHARGESTATE(int rECHARGESTATE) {
		RECHARGESTATE = rECHARGESTATE;
	}
	public int getRECHARGERESULT() {
		return RECHARGERESULT;
	}
	public void setRECHARGERESULT(int rECHARGERESULT) {
		RECHARGERESULT = rECHARGERESULT;
	}
	public int getMONEYS() {
		return MONEYS;
	}
	public void setMONEYS(int mONEYS) {
		MONEYS = mONEYS;
	}
	@Override
	public String toString() {
		return "RechargeRecord [ID=" + ID + ", USERID=" + USERID
				+ ", SERIALNO=" + SERIALNO + ", INITKEY=" + INITKEY
				+ ", SERIALPORT=" + SERIALPORT + ", BAUDRATE=" + BAUDRATE
				+ ", CARDNUM=" + CARDNUM + ", PIN=" + PIN + ", MONEYS="
				+ MONEYS + ", MONEY=" + MONEY + ", RECHARGETIME="
				+ RECHARGETIME + ", RECHARGETIMES=" + RECHARGETIMES
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", GETREPLYTIME="
				+ GETREPLYTIME + ", RECHARGESTATE=" + RECHARGESTATE
				+ ", RECHARGERESULT=" + RECHARGERESULT + ", BALANCES="
				+ BALANCES + "]";
	}
	private BigInteger ID;
	private String USERID;
	private int SERIALNO;
	private String INITKEY;
	private String SERIALPORT;
	private String BAUDRATE;
	private String CARDNUM;
	private String PIN;
	private int MONEYS;//发给通信软件的数据，数额为money*100
	private int MONEY;
	private String RECHARGETIME;
	private int RECHARGETIMES;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int RECHARGESTATE;
	private int RECHARGERESULT;
	private float BALANCES;
	public float getBALANCES() {
		return BALANCES;
	}
	public void setBALANCES(float bALANCES) {
		BALANCES = bALANCES;
	}
}

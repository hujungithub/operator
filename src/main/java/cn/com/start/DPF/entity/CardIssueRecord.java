package cn.com.start.DPF.entity;

import java.math.BigInteger;

public class CardIssueRecord {
	public BigInteger getID() {
		return ID;
	}
	public void setID(BigInteger iD) {
		ID = iD;
	}
	public int getSERIALNO() {
		return SERIALNO;
	}
	public void setSERIALNO(int sERIALNO) {
		SERIALNO = sERIALNO;
	}
	public BigInteger getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(BigInteger cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	public String getCARDUSERNAME() {
		return CARDUSERNAME;
	}
	public void setCARDUSERNAME(String cARDUSERNAME) {
		CARDUSERNAME = cARDUSERNAME;
	}
	public String getIDENTITY() {
		return IDENTITY;
	}
	public void setIDENTITY(String iDENTITY) {
		IDENTITY = iDENTITY;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
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
	public String getINITIALKEY() {
		return INITIALKEY;
	}
	public void setINITIALKEY(String iNITIALKEY) {
		INITIALKEY = iNITIALKEY;
	}
	@Override
	public String toString() {
		return "CardIssueRecord [ID=" + ID + ", SERIALNO=" + SERIALNO
				+ ", CARDNUM=" + CARDNUM + ", PIN=" + PIN + ", CARDUSERNAME="
				+ CARDUSERNAME + ", IDENTITY=" + IDENTITY + ", PHONE=" + PHONE
				+ ", SENDRECORDTIME=" + SENDRECORDTIME + ", GETREPLYTIME="
				+ GETREPLYTIME + ", OPENCARDSTATE=" + OPENCARDSTATE
				+ ", OPENCARDRESULT=" + OPENCARDRESULT + ", USERID=" + USERID
				+ ", INITIALKEY=" + INITIALKEY + "]";
	}
	private BigInteger ID;
	private int SERIALNO;
	private BigInteger CARDNUM;
	private String PIN;
	private String CARDUSERNAME;
	private String IDENTITY;
	private String PHONE;
	private String SENDRECORDTIME;
	private String GETREPLYTIME;
	private int OPENCARDSTATE;
	private int OPENCARDRESULT;
	private String USERID;
	private String INITIALKEY;
}

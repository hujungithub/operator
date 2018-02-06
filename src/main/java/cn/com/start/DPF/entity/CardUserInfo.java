package cn.com.start.DPF.entity;

public class CardUserInfo {

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	private String SERIALPORT;// 串口
	private String BAUDRATE;// 波特率
	private String CARDNUM;// 卡号
	private String CARDUSERNAME;// 姓名
	private String IDENTITYCARDNUM;// 身份证
	private int SEX; // 性别
	private String INITKEY;// 初始秘钥
	private String PIN;// pin
	private float ACCOUNTSUM;// 余额
	private String PLATENUM;// 车牌号
	private String VIN;// 汽车唯一识别码
	private String TELEPHONE;// 手机号
	private String EMAIL;// 邮件
	private String ADDRESS; // 地址
	private String REGTIME;// 开卡日期
	private int CARDSTATE;// 卡状态
	private String OPSTATE; // 操作状态 web|db|send|sucess|fail|
	private String USERID;

	@Override
	public String toString() {
		return "CardUserInfo [SERIALPORT=" + SERIALPORT + ", BAUDRATE="
				+ BAUDRATE + ", CARDNUM=" + CARDNUM + ", CARDUSERNAME="
				+ CARDUSERNAME + ", IDENTITYCARDNUM=" + IDENTITYCARDNUM
				+ ", SEX=" + SEX + ", INITKEY=" + INITKEY + ", PIN=" + PIN
				+ ", ACCOUNTSUM=" + ACCOUNTSUM + ", PLATENUM=" + PLATENUM
				+ ", VIN=" + VIN + ", TELEPHONE=" + TELEPHONE + ", EMAIL="
				+ EMAIL + ", ADDRESS=" + ADDRESS + ", REGTIME=" + REGTIME
				+ ", CARDSTATE=" + CARDSTATE + ", OPSTATE=" + OPSTATE
				+ ", USERID=" + USERID + "]";
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

	public String getCARDUSERNAME() {
		return CARDUSERNAME;
	}

	public void setCARDUSERNAME(String cARDUSERNAME) {
		CARDUSERNAME = cARDUSERNAME;
	}

	public String getIDENTITYCARDNUM() {
		return IDENTITYCARDNUM;
	}

	public void setIDENTITYCARDNUM(String iDENTITYCARDNUM) {
		IDENTITYCARDNUM = iDENTITYCARDNUM;
	}

	public int getSEX() {
		return SEX;
	}

	public void setSEX(int sEX) {
		SEX = sEX;
	}

	public String getINITKEY() {
		return INITKEY;
	}

	public void setINITKEY(String iNITKEY) {
		INITKEY = iNITKEY;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public float getACCOUNTSUM() {
		return ACCOUNTSUM;
	}

	public void setACCOUNTSUM(float aCCOUNTSUM) {
		ACCOUNTSUM = aCCOUNTSUM;
	}

	public String getPLATENUM() {
		return PLATENUM;
	}

	public void setPLATENUM(String pLATENUM) {
		PLATENUM = pLATENUM;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getREGTIME() {
		return REGTIME;
	}

	public void setREGTIME(String rEGTIME) {
		REGTIME = rEGTIME;
	}

	public int getCARDSTATE() {
		return CARDSTATE;
	}

	public void setCARDSTATE(int cARDSTATE) {
		CARDSTATE = cARDSTATE;
	}

	public String getOPSTATE() {
		return OPSTATE;
	}

	public void setOPSTATE(String oPSTATE) {
		OPSTATE = oPSTATE;
	}

}

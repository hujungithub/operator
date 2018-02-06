package cn.com.start.webBack.dto;

public class CardUserDto {
	private String CARDNUM;// 卡号
	private String CARDUSERNAME;// 用户名
	private String IDENTITYCARDNUM;// 身份证号
	private Integer SEX;// 性别
	private String INITKEY;// 初始秘钥
	private String PIN;// 密码
	private String ACCOUNTSUM;// 账户余额
	private String PLATENUM;// 车牌号
	private String VIN;// 汽车唯一标识码
	private String TELEPHONE;// 电话
	private String EMAIL;// 邮件
	private String ADDRESS;// 地址
	private String REGTIME;// 注册时间
	private Integer CARDSTATE;// 卡状态
	private String OPERATORNAME;// 运营商
	
	private String OPERATORLOGINID;

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
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

	public String getACCOUNTSUM() {
		return ACCOUNTSUM;
	}

	public void setACCOUNTSUM(String aCCOUNTSUM) {
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

	@Override
	public String toString() {
		return "CardUserDto [CARDNUM=" + CARDNUM + ", CARDUSERNAME=" + CARDUSERNAME + ", IDENTITYCARDNUM="
				+ IDENTITYCARDNUM + ", SEX=" + SEX + ", INITKEY=" + INITKEY + ", PIN=" + PIN + ", ACCOUNTSUM="
				+ ACCOUNTSUM + ", PLATENUM=" + PLATENUM + ", VIN=" + VIN + ", TELEPHONE=" + TELEPHONE + ", EMAIL="
				+ EMAIL + ", ADDRESS=" + ADDRESS + ", REGTIME=" + REGTIME + ", CARDSTATE=" + CARDSTATE
				+ ", OPERATORNAME=" + OPERATORNAME + ", OPERATORLOGINID=" + OPERATORLOGINID + "]";
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public void setSEX(Integer sEX) {
		SEX = sEX;
	}

	public void setCARDSTATE(Integer cARDSTATE) {
		CARDSTATE = cARDSTATE;
	}

}

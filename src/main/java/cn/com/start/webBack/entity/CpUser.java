package cn.com.start.webBack.entity;

public class CpUser {

	private String CPUSERID;// 充电桩用户id
	private String CPUSERNAME;// 用户名
	private String SEX;// 性别
	private String HEADIMGURL;// 头像地址
	private String PASSWORD;// 账号密码
	private float ACCOUNTSUM; // 账户金额
	private String CHARGESTATE;// 充电状态
	private String CREDITLEVEL;// 信用等级
	private String PLATENUMBER;// 车牌号
	private String VIN;// 汽车唯一标识
	private String TELEPHONE;// 电话
	private String EMAIL;// 邮件
	private String ADDRESS;// 地址
	private String REGTIME;// 注册时间
	private String VALIDFLAG;// 是否可用
	
	private String OPERATORLOGINID;

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public String getCPUSERNAME() {
		return CPUSERNAME;
	}

	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getHEADIMGURL() {
		return HEADIMGURL;
	}

	public void setHEADIMGURL(String hEADIMGURL) {
		HEADIMGURL = hEADIMGURL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public float getACCOUNTSUM() {
		return ACCOUNTSUM;
	}

	public void setACCOUNTSUM(float aCCOUNTSUM) {
		ACCOUNTSUM = aCCOUNTSUM;
	}

	public String getCHARGESTATE() {
		return CHARGESTATE;
	}

	public void setCHARGESTATE(String cHARGESTATE) {
		CHARGESTATE = cHARGESTATE;
	}

	public String getCREDITLEVEL() {
		return CREDITLEVEL;
	}

	public void setCREDITLEVEL(String cREDITLEVEL) {
		CREDITLEVEL = cREDITLEVEL;
	}

	public String getPLATENUMBER() {
		return PLATENUMBER;
	}

	public void setPLATENUMBER(String pLATENUMBER) {
		PLATENUMBER = pLATENUMBER;
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

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	@Override
	public String toString() {
		return "CpUser [CPUSERID=" + CPUSERID + ", CPUSERNAME=" + CPUSERNAME + ", SEX=" + SEX + ", HEADIMGURL="
				+ HEADIMGURL + ", PASSWORD=" + PASSWORD + ", ACCOUNTSUM=" + ACCOUNTSUM + ", CHARGESTATE=" + CHARGESTATE
				+ ", CREDITLEVEL=" + CREDITLEVEL + ", PLATENUMBER=" + PLATENUMBER + ", VIN=" + VIN + ", TELEPHONE="
				+ TELEPHONE + ", EMAIL=" + EMAIL + ", ADDRESS=" + ADDRESS + ", REGTIME=" + REGTIME + ", VALIDFLAG="
				+ VALIDFLAG + ", OPERATORLOGINID=" + OPERATORLOGINID + "]";
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

}

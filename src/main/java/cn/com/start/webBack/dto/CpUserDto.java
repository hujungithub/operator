package cn.com.start.webBack.dto;

public class CpUserDto {
	// 充电桩用户id
	private String CPUSERID;
	// 用户名
	private String CPUSERNAME;
	// 性别
	private String SEX;
	// 头像地址
	private String HEADIMGURL;
	// 账号密码
	private String PASSWORD;
	// 账户金额
	private Float ACCOUNTSUM;
	// 充电状态
	private String CHARGESTATE;
	// 信用等级
	private String CREDITLEVEL;
	// 车牌号
	private String PLATENUMBER;
	// 汽车唯一标识
	private String VIN;
	// 电话
	private String TELEPHONE;
	// 邮件
	private String EMAIL;
	// 地址
	private String ADDRESS;
	// 注册时间
	private String REGTIME;
	// 是否可用
	private String VALIDFLAG;
	// 开始日期
	private String FROMDATE;
	// 结束日期
	private String TODATE;

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

	public Float getACCOUNTSUM() {
		return ACCOUNTSUM;
	}

	public void setACCOUNTSUM(Float aCCOUNTSUM) {
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

	public String getFROMDATE() {
		return FROMDATE;
	}

	public void setFROMDATE(String fROMDATE) {
		FROMDATE = fROMDATE;
	}

	public String getTODATE() {
		return TODATE;
	}

	public void setTODATE(String tODATE) {
		TODATE = tODATE;
	}

	@Override
	public String toString() {
		return "CpUserDto [CPUSERID=" + CPUSERID + ", CPUSERNAME=" + CPUSERNAME
				+ ", SEX=" + SEX + ", HEADIMGURL=" + HEADIMGURL + ", PASSWORD="
				+ PASSWORD + ", ACCOUNTSUM=" + ACCOUNTSUM + ", CHARGESTATE="
				+ CHARGESTATE + ", CREDITLEVEL=" + CREDITLEVEL
				+ ", PLATENUMBER=" + PLATENUMBER + ", VIN=" + VIN
				+ ", TELEPHONE=" + TELEPHONE + ", EMAIL=" + EMAIL
				+ ", ADDRESS=" + ADDRESS + ", REGTIME=" + REGTIME
				+ ", VALIDFLAG=" + VALIDFLAG + ", FROMDATE=" + FROMDATE
				+ ", TODATE=" + TODATE + "]";
	}

}

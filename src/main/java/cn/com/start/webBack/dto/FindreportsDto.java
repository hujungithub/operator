package cn.com.start.webBack.dto;

public class FindreportsDto extends BaseFindDto {
	private String CSNAME;// 充电站名
	private String CSID;

	private String CPUSERNAME;// 扫码用户名
	private String CHARGEMETHODID;// 充电类型
	private String CHARGEMETHODNAME; // 充电类型名称

	/**
	 * @return the cHARGEMETHODNAME
	 */
	public String getCHARGEMETHODNAME() {
		return CHARGEMETHODNAME;
	}

	/**
	 * @param cHARGEMETHODNAME the cHARGEMETHODNAME to set
	 */
	public void setCHARGEMETHODNAME(String cHARGEMETHODNAME) {
		CHARGEMETHODNAME = cHARGEMETHODNAME;
	}

	private String TELEPHONE;// 手机号码

	private String IDENTITYCARDNUM; // 身份证号码
	private String StatisticsMethod;

	private String OPERATORLOGINID;
	private String FROMDATE;// 开始日期
	private String TODATE; // 结束日期
	private String DAYFROMDATE;
	private String DAYTODATE;
	private String MONTHFROMDATE;
	private String MONTHTODATE;
	private String YEARFROMDATE;
	private String YEARTODATE;

	private String CPNAME;
	private String CPID;
	private String OPERATORID; // 运营商id
	private String OPERATORNAME;
	private String CPUSERID;

	/**
	 * @return the iDENTITYCARDNUM
	 */
	public String getIDENTITYCARDNUM() {
		return IDENTITYCARDNUM;
	}
	
	/**
	 * @param iDENTITYCARDNUM the iDENTITYCARDNUM to set
	 */
	public void setIDENTITYCARDNUM(String iDENTITYCARDNUM) {
		IDENTITYCARDNUM = iDENTITYCARDNUM;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getCPNAME() {
		return CPNAME;
	}

	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
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

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	public String getCHARGEMETHODID() {
		return CHARGEMETHODID;
	}

	public void setCHARGEMETHODID(String cHARGEMETHODID) {
		CHARGEMETHODID = cHARGEMETHODID;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}

	public String getCPUSERNAME() {
		return CPUSERNAME;
	}

	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	@Override
	public String toString() {
		return "FindreportsDto [CSNAME=" + CSNAME + ", CSID=" + CSID + ", CPUSERNAME=" + CPUSERNAME
				+ ", CHARGEMETHODID=" + CHARGEMETHODID + ", TELEPHONE=" + TELEPHONE + ", IDENTITYCARDNUM="
				+ IDENTITYCARDNUM + ", StatisticsMethod=" + StatisticsMethod + ", OPERATORLOGINID=" + OPERATORLOGINID
				+ ", FROMDATE=" + FROMDATE + ", TODATE=" + TODATE + ", DAYFROMDATE=" + DAYFROMDATE + ", DAYTODATE="
				+ DAYTODATE + ", MONTHFROMDATE=" + MONTHFROMDATE + ", MONTHTODATE=" + MONTHTODATE + ", YEARFROMDATE="
				+ YEARFROMDATE + ", YEARTODATE=" + YEARTODATE + ", CPNAME=" + CPNAME + ", CPID=" + CPID
				+ ", OPERATORID=" + OPERATORID + ", OPERATORNAME=" + OPERATORNAME + ", CPUSERID=" + CPUSERID + "]";
	}

	public String getStatisticsMethod() {
		return StatisticsMethod;
	}

	public void setStatisticsMethod(String statisticsMethod) {
		StatisticsMethod = statisticsMethod;
	}

	public String getDAYFROMDATE() {
		return DAYFROMDATE;
	}

	public void setDAYFROMDATE(String dAYFROMDATE) {
		DAYFROMDATE = dAYFROMDATE;
	}

	public String getDAYTODATE() {
		return DAYTODATE;
	}

	public void setDAYTODATE(String dAYTODATE) {
		DAYTODATE = dAYTODATE;
	}

	public String getMONTHFROMDATE() {
		return MONTHFROMDATE;
	}

	public void setMONTHFROMDATE(String mONTHFROMDATE) {
		MONTHFROMDATE = mONTHFROMDATE;
	}

	public String getMONTHTODATE() {
		return MONTHTODATE;
	}

	public void setMONTHTODATE(String mONTHTODATE) {
		MONTHTODATE = mONTHTODATE;
	}

	public String getYEARFROMDATE() {
		return YEARFROMDATE;
	}

	public void setYEARFROMDATE(String yEARFROMDATE) {
		YEARFROMDATE = yEARFROMDATE;
	}

	public String getYEARTODATE() {
		return YEARTODATE;
	}

	public void setYEARTODATE(String yEARTODATE) {
		YEARTODATE = yEARTODATE;
	}


}

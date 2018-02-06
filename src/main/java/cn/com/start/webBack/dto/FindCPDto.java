package cn.com.start.webBack.dto;

public class FindCPDto extends BaseFindDto {

	private String PROVINCEID; // 省id
	private String CITYID; // 市id
	private String AREAID; // 区域id
	private String CPTYPE; //
	
	private String CPID;// 桩ID
	private String OPERATORID; // 运营商id
	private String OPERATORNAME;
	private String CSID; // 站id
	private String CSNAME;
	private Integer MONTH;
	private String FROMDATE;// 开始日期
	private String TODATE; // 结束日期
	
	private String LOCATION;
	private String OPERATORLOGINID;


	
	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public int getMONTH() {
		return MONTH;
	}

	public void setMONTH(Integer mONTH) {
		MONTH = mONTH;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public String getROLELOGINID() {
		return ROLELOGINID;
	}

	public void setROLELOGINID(String rOLELOGINID) {
		ROLELOGINID = rOLELOGINID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}



	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getPROVINCEID() {
		return PROVINCEID;
	}

	public void setPROVINCEID(String pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}

	public String getCITYID() {
		return CITYID;
	}

	public void setCITYID(String cITYID) {
		CITYID = cITYID;
	}

	public String getAREAID() {
		return AREAID;
	}

	public void setAREAID(String aREAID) {
		AREAID = aREAID;
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

	@Override
	public String toString() {
		return "FindCPDto [PROVINCEID=" + PROVINCEID + ", CITYID=" + CITYID + ", AREAID=" + AREAID + ", CPTYPE="
				+ CPTYPE + ", CPID=" + CPID + ", OPERATORID=" + OPERATORID + ", OPERATORNAME=" + OPERATORNAME
				+ ", CSID=" + CSID + ", CSNAME=" + CSNAME + ", MONTH=" + MONTH + ", FROMDATE=" + FROMDATE + ", TODATE="
				+ TODATE + ", LOCATION=" + LOCATION + ", OPERATORLOGINID=" + OPERATORLOGINID + "]";
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}
	
	
}

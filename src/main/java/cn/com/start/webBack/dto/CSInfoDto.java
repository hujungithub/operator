package cn.com.start.webBack.dto;

public class CSInfoDto {

	private String CSID;// 充电站ID
	private String CSNAME;// 充电站名称
	private String LOCATION; // 完整地址
	private String DCCPCOUNT; // 直流桩个数
	private String ACCPCOUNT; // 交流桩个数
	private String OPERATORNAME;// 运营商名称
	private String CREATETIME;// 建站时间
	private String VALIDFLAG;// 是否可用
	private String OPENTIME; // 开放时间
	
	
	private String CPID;
	private String CPNAME;
	private String ALARMFLAG;
	private String RATEID;
	private String MFRNAME;
	private String MODEL;
	private String PROTOCOLNAME;
	
	private String CHARGEQUANTITY;
	private String CHARGEMONEY;
	private String SERVICETIP;
	
	private String CPCOUNT;
	private String CHARGETIMESPAN;
	private Integer CHARGETIMESPANINT;
	private String MONEYCOUNT;
	
	
	public Integer getCHARGETIMESPANINT() {
		return CHARGETIMESPANINT;
	}



	public void setCHARGETIMESPANINT(Integer cHARGETIMESPANINT) {
		CHARGETIMESPANINT = cHARGETIMESPANINT;
	}



	@Override
	public String toString() {
		return "CSInfoDto [CSID=" + CSID + ", CSNAME=" + CSNAME + ", LOCATION="
				+ LOCATION + ", DCCPCOUNT=" + DCCPCOUNT + ", ACCPCOUNT="
				+ ACCPCOUNT + ", OPERATORNAME=" + OPERATORNAME
				+ ", CREATETIME=" + CREATETIME + ", VALIDFLAG=" + VALIDFLAG
				+ ", OPENTIME=" + OPENTIME + ", CPID=" + CPID + ", CPNAME="
				+ CPNAME + ", ALARMFLAG=" + ALARMFLAG + ", RATEID=" + RATEID
				+ ", MFRNAME=" + MFRNAME + ", MODEL=" + MODEL
				+ ", PROTOCOLNAME=" + PROTOCOLNAME + ", CHARGEQUANTITY="
				+ CHARGEQUANTITY + ", CHARGEMONEY=" + CHARGEMONEY
				+ ", SERVICETIP=" + SERVICETIP + ", CPCOUNT=" + CPCOUNT
				+ ", CHARGETIMESPAN=" + CHARGETIMESPAN + ", CHARGETIMESPANINT="
				+ CHARGETIMESPANINT + ", MONEYCOUNT=" + MONEYCOUNT + "]";
	}



	public String getMONEYCOUNT() {
		return MONEYCOUNT;
	}


	public void setMONEYCOUNT(String mONEYCOUNT) {
		MONEYCOUNT = mONEYCOUNT;
	}



	public String getCPCOUNT() {
		return CPCOUNT;
	}



	public void setCPCOUNT(String cPCOUNT) {
		CPCOUNT = cPCOUNT;
	}



	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}

	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}

	public String getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}

	public void setCHARGEQUANTITY(String cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}

	public String getCHARGEMONEY() {
		return CHARGEMONEY;
	}

	public void setCHARGEMONEY(String cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}

	public String getSERVICETIP() {
		return SERVICETIP;
	}

	public void setSERVICETIP(String sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPNAME() {
		return CPNAME;
	}

	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	public String getALARMFLAG() {
		return ALARMFLAG;
	}

	public void setALARMFLAG(String aLARMFLAG) {
		ALARMFLAG = aLARMFLAG;
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getMFRNAME() {
		return MFRNAME;
	}

	public void setMFRNAME(String mFRNAME) {
		MFRNAME = mFRNAME;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public String getPROTOCOLNAME() {
		return PROTOCOLNAME;
	}

	public void setPROTOCOLNAME(String pROTOCOLNAME) {
		PROTOCOLNAME = pROTOCOLNAME;
	}

	public String getDCCPCOUNT() {
		return DCCPCOUNT;
	}

	public void setDCCPCOUNT(String dCCPCOUNT) {
		DCCPCOUNT = dCCPCOUNT;
	}

	public String getACCPCOUNT() {
		return ACCPCOUNT;
	}

	public void setACCPCOUNT(String aCCPCOUNT) {
		ACCPCOUNT = aCCPCOUNT;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
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

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getOPENTIME() {
		return OPENTIME;
	}

	public void setOPENTIME(String oPENTIME) {
		OPENTIME = oPENTIME;
	}

}

package cn.com.start.webBack.entity;

public class CPInfo {

	private String CPID; // 桩ID（区域编码+4位） XXXX  
	private String CPNAME; // 桩名称（区域地质+桩编号）	
	private String ADDRESSID;// 地址ID XXXX	
	private String OPERATORID;// 运营商ID	
	private String CSID; // 站ID XXXX 
	private String VALIDFLAG;// 是否可用（0:否 1:可用） 
	private String MFRID;// 厂商ID	
	private String MODEL;// 型号	
	private String CREATETIME;// 建桩日期	
	private String RATEID;// 费率id	
	private String PROTOCOLID; // 协议ID	
	private String DEVICEID;	
	
	private String OPERATORLOGINID;
	private String chargePatternId;
	
	private int CPNUM;

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

	public String getADDRESSID() {
		return ADDRESSID;
	}

	public void setADDRESSID(String aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getMFRID() {
		return MFRID;
	}

	public void setMFRID(String mFRID) {
		MFRID = mFRID;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(String pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public String getDEVICEID() {
		return DEVICEID;
	}

	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public int getCPNUM() {
		return CPNUM;
	}

	public void setCPNUM(int cPNUM) {
		CPNUM = cPNUM;
	}

	@Override
	public String toString() {
		return "CPInfo [CPID=" + CPID + ", CPNAME=" + CPNAME + ", ADDRESSID=" + ADDRESSID + ", OPERATORID=" + OPERATORID
				+ ", CSID=" + CSID + ", VALIDFLAG=" + VALIDFLAG + ", MFRID=" + MFRID + ", MODEL=" + MODEL
				+ ", CREATETIME=" + CREATETIME + ", RATEID=" + RATEID + ", PROTOCOLID=" + PROTOCOLID + ", DEVICEID="
				+ DEVICEID + ", OPERATORLOGINID=" + OPERATORLOGINID + ", chargePatternId=" + chargePatternId
				+ ", CPNUM=" + CPNUM + "]";
	}

	public String getChargePatternId() {
		return chargePatternId;
	}

	public void setChargePatternId(String chargePatternId) {
		this.chargePatternId = chargePatternId;
	} 

	
}

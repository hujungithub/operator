package cn.com.start.AppAPI.dto;

public class MapSMDto {

	private String CSID;// 站id
	private String CPMID; // CPM ID
	private String CURRSTATE;// 当前状态
	private String LONGITUDE;// 经度
	private String LATITUDE;// 纬度
	private String DISTANCE; // 距离
	private String NAME;
	private String FIELD;
	private String VALIDFLAG;
	private String OPENTIME;
	private String LOCATION;
	private String DCNUM;
	private String ACNUM;
	private String APPOINTFEE;
	private String SERVICEFEE;
	private String PARKFEE;
	private String RATEID;
	

	
	@Override
	public String toString() {
		return "MapSMDto [CSID=" + CSID + ", CPMID=" + CPMID + ", CURRSTATE="
				+ CURRSTATE + ", LONGITUDE=" + LONGITUDE + ", LATITUDE="
				+ LATITUDE + ", DISTANCE=" + DISTANCE + ", NAME=" + NAME
				+ ", FIELD=" + FIELD + ", VALIDFLAG=" + VALIDFLAG
				+ ", OPENTIME=" + OPENTIME + ", LOCATION=" + LOCATION
				+ ", DCNUM=" + DCNUM + ", ACNUM=" + ACNUM + ", APPOINTFEE="
				+ APPOINTFEE + ", SERVICEFEE=" + SERVICEFEE + ", PARKFEE="
				+ PARKFEE + ", RATEID=" + RATEID + "]";
	}
	

	public String getCPMID() {
		return CPMID;
	}



	public void setCPMID(String cPMID) {
		CPMID = cPMID;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCURRSTATE() {
		return CURRSTATE;
	}

	public void setCURRSTATE(String cURRSTATE) {
		CURRSTATE = cURRSTATE;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}

	public String getDISTANCE() {
		return DISTANCE;
	}

	public void setDISTANCE(String dISTANCE) {
		DISTANCE = dISTANCE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getFIELD() {
		return FIELD;
	}

	public void setFIELD(String fIELD) {
		FIELD = fIELD;
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

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getDCNUM() {
		return DCNUM;
	}

	public void setDCNUM(String dCNUM) {
		DCNUM = dCNUM;
	}

	public String getACNUM() {
		return ACNUM;
	}

	public void setACNUM(String aCNUM) {
		ACNUM = aCNUM;
	}

	public String getAPPOINTFEE() {
		return APPOINTFEE;
	}

	public void setAPPOINTFEE(String aPPOINTFEE) {
		APPOINTFEE = aPPOINTFEE;
	}

	public String getSERVICEFEE() {
		return SERVICEFEE;
	}

	public void setSERVICEFEE(String sERVICEFEE) {
		SERVICEFEE = sERVICEFEE;
	}

	public String getPARKFEE() {
		return PARKFEE;
	}

	public void setPARKFEE(String pARKFEE) {
		PARKFEE = pARKFEE;
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	
	
	
}

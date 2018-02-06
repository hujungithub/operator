package cn.com.start.webBack.dto;

public class FindCSInfoDto extends BaseFindDto {
	private String PROVINCEID; // 省id
	private String CITYID; // 市id
	private String AREAID; // 区域id
	private String OPERATORID;//运营商ID
	private String CSNAME;// 充电站名称
	private String VALIDFLAG;// 可用不可用
	
	private String OPERATORNAME;
	private String LOCATION;
	
	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
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

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}


	@Override
	public String toString() {
		return "FindCSInfoDto [PROVINCEID=" + PROVINCEID + ", CITYID=" + CITYID + ", AREAID=" + AREAID + ", OPERATORID="
				+ OPERATORID + ", CSNAME=" + CSNAME + ", VALIDFLAG=" + VALIDFLAG + ", OPERATORNAME=" + OPERATORNAME
				+ ", LOCATION=" + LOCATION + "]";
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	

}

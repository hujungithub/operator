package cn.com.start.AppAPI.dto;

public class ListSMDto {

	private String CSID;// 站id
	private String LONGITUDE;// 经度
	private String LATITUDE;// 纬度
	private String DISTANCE; // 距离
	private String VALIDFLAG; // 是否可用
	private String FIELD; // 公共私有
	private String OPERATORID;
	private String CPMID; // CPMID
	private String NAME; // 站CPM桩名字
	private String PICURL;// 图片的路径
	private String OPENTIME; // 开放时间
	private String CPRANK; // 评分
	private String CHARGEFEE; // 充电费用
	private String APPOINTFEE;// 预约费用
	private String SERVICEFEE;// 服务费
	private String PARKFEE; // 停车费

	private String RATEID;// 费率ID
	private String DCNUM;// 总个数
	private String DCISNUM;// 空闲个数
	private String ACNUM;// 交流数量
	private String ACISNUM;//
	private String LOCATION;// 地址
	private String SERVICETIP;
	


	@Override
	public String toString() {
		return "ListSMDto [CSID=" + CSID + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + ", DISTANCE=" + DISTANCE
				+ ", VALIDFLAG=" + VALIDFLAG + ", FIELD=" + FIELD
				+ ", OPERATORID=" + OPERATORID + ", CPMID=" + CPMID + ", NAME="
				+ NAME + ", PICURL=" + PICURL + ", OPENTIME=" + OPENTIME
				+ ", CPRANK=" + CPRANK + ", CHARGEFEE=" + CHARGEFEE
				+ ", APPOINTFEE=" + APPOINTFEE + ", SERVICEFEE=" + SERVICEFEE
				+ ", PARKFEE=" + PARKFEE + ", RATEID=" + RATEID + ", DCNUM="
				+ DCNUM + ", DCISNUM=" + DCISNUM + ", ACNUM=" + ACNUM
				+ ", ACISNUM=" + ACISNUM + ", LOCATION=" + LOCATION
				+ ", SERVICETIP=" + SERVICETIP + "]";
	}




	public String getSERVICETIP() {
		return SERVICETIP;
	}



	public void setSERVICETIP(String sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}


	public String getOPERATORID() {
		return OPERATORID;
	}


	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}




	public String getLOCATION() {
		return LOCATION;
	}




	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}




	public String getOPENTIME() {
		return OPENTIME;
	}

	public void setOPENTIME(String oPENTIME) {
		OPENTIME = oPENTIME;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getFIELD() {
		return FIELD;
	}

	public void setFIELD(String fIELD) {
		FIELD = fIELD;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCPMID() {
		return CPMID;
	}

	public void setCPMID(String cPMID) {
		CPMID = cPMID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPICURL() {
		return PICURL;
	}

	public void setPICURL(String pICURL) {
		PICURL = pICURL;
	}

	public String getCPRANK() {
		return CPRANK;
	}

	public void setCPRANK(String cPRANK) {
		CPRANK = cPRANK;
	}

	public String getCHARGEFEE() {
		return CHARGEFEE;
	}

	public void setCHARGEFEE(String cHARGEFEE) {
		CHARGEFEE = cHARGEFEE;
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

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getDCNUM() {
		return DCNUM;
	}

	public void setDCNUM(String dCNUM) {
		DCNUM = dCNUM;
	}

	public String getDCISNUM() {
		return DCISNUM;
	}

	public void setDCISNUM(String dCISNUM) {
		DCISNUM = dCISNUM;
	}

	public String getACNUM() {
		return ACNUM;
	}

	public void setACNUM(String aCNUM) {
		ACNUM = aCNUM;
	}

	public String getACISNUM() {
		return ACISNUM;
	}

	public void setACISNUM(String aCISNUM) {
		ACISNUM = aCISNUM;
	}

}

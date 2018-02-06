package cn.com.start.AppAPI.dto;

public class ChargeStationDto {
	// 站名
	private String CSNM;
	// 站ID
	private String CSID;
	// 地址
	private String LOCATION;
	// 交流数量
	private String ACNUM;
	// 交流正在使用
	private String ACISNUM;
	// 直流数量
	private String DCNUM;
	// 直流正在使用
	private String DCISNUM;
	// 评价等级
	private String RANK;
	// 充电费用ID
	private String PRICEID;
	// 充电费用
	private String CHARGEFEE;
	// 停车费
	private String PARKFEE;
	// 服务费
	private String COVERFEE;
	// 当前位置与站距离
	private String DISTANCE;
	// 开放时间
	private String OPENTIME;
	// 经度
	private String LONGITUDE;
	// 纬度
	private String LATITUDE;

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

	public String getOPENTIME() {
		return OPENTIME;
	}

	@Override
	public String toString() {
		return "ChargeStationDto [CSNM=" + CSNM + ", CSID=" + CSID
				+ ", LOCATION=" + LOCATION + ", ACNUM=" + ACNUM + ", ACISNUM="
				+ ACISNUM + ", DCNUM=" + DCNUM + ", DCISNUM=" + DCISNUM
				+ ", RANK=" + RANK + ", PRICEID=" + PRICEID + ", CHARGEFEE="
				+ CHARGEFEE + ", PARKFEE=" + PARKFEE + ", COVERFEE=" + COVERFEE
				+ ", DISTANCE=" + DISTANCE + ", OPENTIME=" + OPENTIME
				+ ", LONGITUDE=" + LONGITUDE + ", LATITUDE=" + LATITUDE + "]";
	}

	public void setOPENTIME(String oPENTIME) {
		OPENTIME = oPENTIME;
	}

	public String getDISTANCE() {
		return DISTANCE;
	}

	public void setDISTANCE(String dISTANCE) {
		DISTANCE = dISTANCE;
	}

	public String getCSNM() {
		return CSNM;
	}

	public void setCSNM(String cSNM) {
		CSNM = cSNM;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getPRICEID() {
		return PRICEID;
	}

	public void setPRICEID(String pRICEID) {
		PRICEID = pRICEID;
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

	public String getRANK() {
		return RANK;
	}

	public void setRANK(String rANK) {
		RANK = rANK;
	}

	public String getCHARGEFEE() {
		return CHARGEFEE;
	}

	public void setCHARGEFEE(String cHARGEFEE) {
		CHARGEFEE = cHARGEFEE;
	}

	public String getPARKFEE() {
		return PARKFEE;
	}

	public void setPARKFEE(String pARKFEE) {
		PARKFEE = pARKFEE;
	}

	public String getCOVERFEE() {
		return COVERFEE;
	}

	public void setCOVERFEE(String cOVERFEE) {
		COVERFEE = cOVERFEE;
	}

}

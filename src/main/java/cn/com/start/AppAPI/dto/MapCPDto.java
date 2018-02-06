package cn.com.start.AppAPI.dto;

public class MapCPDto {

	private String CPID;// CPId
	private String LOCATION;// 省市区地址拼接
	private String DISTANCE; // 距离
	private String RATEID;// 费率ID
	private String CPTYPE;// 类型
	private String CPSTATETYPE;// 状态 充电空闲
	private String PICURL;// 图片的路径
	private String CPRANK; // 评分
	private String CHARGEFEE; // 充电费用
	private String APPOINTFEE;// 预约费用
	private String SERVICEFEE;// 服务费
	private String PARKFEE; // 停车费
	private String VALIDFLAG;// 当前状态
	private String LONGITUDE;// 经度
	private String LATITUDE;// 纬度

	@Override
	public String toString() {
		return "MapCPDto [CPID=" + CPID + ", LOCATION=" + LOCATION
				+ ", DISTANCE=" + DISTANCE + ", RATEID=" + RATEID + ", CPTYPE="
				+ CPTYPE + ", CPSTATETYPE=" + CPSTATETYPE + ", PICURL="
				+ PICURL + ", CPRANK=" + CPRANK + ", CHARGEFEE=" + CHARGEFEE
				+ ", APPOINTFEE=" + APPOINTFEE + ", SERVICEFEE=" + SERVICEFEE
				+ ", PARKFEE=" + PARKFEE + ", VALIDFLAG=" + VALIDFLAG
				+ ", LONGITUDE=" + LONGITUDE + ", LATITUDE=" + LATITUDE + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
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

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getCPSTATETYPE() {
		return CPSTATETYPE;
	}

	public void setCPSTATETYPE(String cPSTATETYPE) {
		CPSTATETYPE = cPSTATETYPE;
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

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
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

}

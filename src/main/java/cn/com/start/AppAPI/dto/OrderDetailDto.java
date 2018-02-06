package cn.com.start.AppAPI.dto;

public class OrderDetailDto {

	// 充电桩信息 站名+桩名
	private String CHARGEPILE;
	// 地址信息
	private String LOCATION;
	// 订单ID
	private String ORDERID;
	// 开始充电时间
	private String BEGINTIME;
	// 结束充电时间
	private String ENDTIME;
	// 订单类型
	private String ORDERTYPE;
	// 订单金额
	private String MONEY;
	// 支付状态
	private String PAYSTATUS;
	// 支付方式
	private String PAYWAY;
	// 充电站名
	private String CSNM;

	// 充电桩名
	private String CPNM;
	// 省
	private String PROVINCE;
	// 市
	private String CITY;
	// 区
	private String AREA;
	// 地址
	private String ADDRESS;

	public String getCSNM() {
		return CSNM;
	}

	public void setCSNM(String cSNM) {
		CSNM = cSNM;
	}

	public String getCPNM() {
		return CPNM;
	}

	public void setCPNM(String cPNM) {
		CPNM = cPNM;
	}

	public String getPROVINCE() {
		return PROVINCE;
	}

	public void setPROVINCE(String pROVINCE) {
		PROVINCE = pROVINCE;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getAREA() {
		return AREA;
	}

	public void setAREA(String aREA) {
		AREA = aREA;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getCHARGEPILE() {
		return CHARGEPILE;
	}

	public void setCHARGEPILE(String cHARGEPILE) {
		CHARGEPILE = cHARGEPILE;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getBEGINTIME() {
		return BEGINTIME;
	}

	public void setBEGINTIME(String bEGINTIME) {
		BEGINTIME = bEGINTIME;
	}

	public String getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}

	public String getORDERTYPE() {
		return ORDERTYPE;
	}

	public void setORDERTYPE(String oRDERTYPE) {
		ORDERTYPE = oRDERTYPE;
	}

	public String getMONEY() {
		return MONEY;
	}

	public void setMONEY(String mONEY) {
		MONEY = mONEY;
	}

	public String getPAYSTATUS() {
		return PAYSTATUS;
	}

	public void setPAYSTATUS(String pAYSTATUS) {
		PAYSTATUS = pAYSTATUS;
	}

	public String getPAYWAY() {
		return PAYWAY;
	}

	public void setPAYWAY(String pAYWAY) {
		PAYWAY = pAYWAY;
	}

	@Override
	public String toString() {
		return "OrderDetailDto [CHARGEPILE=" + CHARGEPILE + ", LOCATION="
				+ LOCATION + ", ORDERID=" + ORDERID + ", BEGINTIME="
				+ BEGINTIME + ", ENDTIME=" + ENDTIME + ", ORDERTYPE="
				+ ORDERTYPE + ", MONEY=" + MONEY + ", PAYSTATUS=" + PAYSTATUS
				+ ", PAYWAY=" + PAYWAY + ", CSNM=" + CSNM + ", CPNM=" + CPNM
				+ ", PROVINCE=" + PROVINCE + ", CITY=" + CITY + ", AREA="
				+ AREA + ", ADDRESS=" + ADDRESS + "]";
	}
}

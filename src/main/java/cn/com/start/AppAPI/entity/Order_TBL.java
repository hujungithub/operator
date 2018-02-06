package cn.com.start.AppAPI.entity;

public class Order_TBL {
	// 订单ID
	private String ORDERID;
	// 区域ID
	private String AREAID;
	// 桩ID
	private String CPID;
	// 用户ID
	private String CPUSERID;
	// 开始充电时间
	private String BEGINTIME;
	// 结束充电时间
	private String ENDTIME;

	// 订单类型
	private String ORDERTYPE;
	// 订单金额
	private String MONEY;
	// 订单状态
	private String STATE;
	// 支付状态
	private String PAYSTATUS;
	// 支付方式
	private String PAYWAY;
	// 充电时长
	private String CHARGETIMESPAN;

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getAREAID() {
		return AREAID;
	}

	public void setAREAID(String aREAID) {
		AREAID = aREAID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
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

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
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

	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}

	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}

	@Override
	public String toString() {
		return "Order_TBL [ORDERID=" + ORDERID + ", AREAID=" + AREAID
				+ ", CPID=" + CPID + ", CPUSERID=" + CPUSERID + ", BEGINTIME="
				+ BEGINTIME + ", ENDTIME=" + ENDTIME + ", ORDERTYPE="
				+ ORDERTYPE + ", MONEY=" + MONEY + ", STATE=" + STATE
				+ ", PAYSTATUS=" + PAYSTATUS + ", PAYWAY=" + PAYWAY
				+ ", CHARGETIMESPAN=" + CHARGETIMESPAN + "]";
	}
}

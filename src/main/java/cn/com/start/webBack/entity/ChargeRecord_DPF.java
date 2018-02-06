package cn.com.start.webBack.entity;

public class ChargeRecord_DPF {

	/*
	 * 删除部分字段
	 * */
	private String CPID; // 桩id
	private String DEVICEID;// 桩编号设备id
	private int INTERFACEID;// 枪
	private String TRANSATIONID;// 流水号 可以做为账单id
	private String CARDNUM; // 物理卡号
	private String CPUSERID;// 用户ID
	private float CHARGEQUANTITY;// 电量
	private float BEFORECHARGEBALANCE;// 充电前金额
	private float CHARGEMONEY;// 金额
	private float SERVICETIP;// 服务费
	private String RECORDTIME;// 记录时间
	private String CHARGESTARTTIME;// 开始充电时间
	private int CHARGETIMESPAN;// 充电时长
	private int CHARGEFINISHEDFLAG;// 结束充电标志
	private String CHARGEENDCAUSE;// 结束充电原因
	private int BILLMODELID;// 费率id
	
	//新增三个字段 hanmj
	private int CHARGEMETHODID;
	private int CHARGEMODEID;
	private float CHARGEPARA;
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getDEVICEID() {
		return DEVICEID;
	}
	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}
	public int getINTERFACEID() {
		return INTERFACEID;
	}
	public void setINTERFACEID(int iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}
	public String getTRANSATIONID() {
		return TRANSATIONID;
	}
	public void setTRANSATIONID(String tRANSATIONID) {
		TRANSATIONID = tRANSATIONID;
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public float getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}
	public void setCHARGEQUANTITY(float cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}
	public float getBEFORECHARGEBALANCE() {
		return BEFORECHARGEBALANCE;
	}
	public void setBEFORECHARGEBALANCE(float bEFORECHARGEBALANCE) {
		BEFORECHARGEBALANCE = bEFORECHARGEBALANCE;
	}
	public float getCHARGEMONEY() {
		return CHARGEMONEY;
	}
	public void setCHARGEMONEY(float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}
	public float getSERVICETIP() {
		return SERVICETIP;
	}
	public void setSERVICETIP(float sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}
	public String getRECORDTIME() {
		return RECORDTIME;
	}
	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}
	public String getCHARGESTARTTIME() {
		return CHARGESTARTTIME;
	}
	public void setCHARGESTARTTIME(String cHARGESTARTTIME) {
		CHARGESTARTTIME = cHARGESTARTTIME;
	}
	public float getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}
	public void setCHARGETIMESPAN(int cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}
	public int getCHARGEFINISHEDFLAG() {
		return CHARGEFINISHEDFLAG;
	}
	public void setCHARGEFINISHEDFLAG(int cHARGEFINISHEDFLAG) {
		CHARGEFINISHEDFLAG = cHARGEFINISHEDFLAG;
	}
	public String getCHARGEENDCAUSE() {
		return CHARGEENDCAUSE;
	}
	public void setCHARGEENDCAUSE(String cHARGEENDCAUSE) {
		CHARGEENDCAUSE = cHARGEENDCAUSE;
	}
	public int getBILLMODELID() {
		return BILLMODELID;
	}
	public void setBILLMODELID(int bILLMODELID) {
		BILLMODELID = bILLMODELID;
	}
	
	
	
	public int getCHARGEMETHODID() {
		return CHARGEMETHODID;
	}
	public void setCHARGEMETHODID(int cHARGEMETHODID) {
		CHARGEMETHODID = cHARGEMETHODID;
	}
	
	
	public int getCHARGEMODEID() {
		return CHARGEMODEID;
	}
	public void setCHARGEMODEID(int cHARGEMODEID) {
		CHARGEMODEID = cHARGEMODEID;
	}
	public float getCHARGEPARA() {
		return CHARGEPARA;
	}
	public void setCHARGEPARA(float cHARGEPARA) {
		CHARGEPARA = cHARGEPARA;
	}
	@Override
	public String toString() {
		return "ChargeRecord_DPF [CPID=" + CPID + ", DEVICEID=" + DEVICEID
				+ ", INTERFACEID=" + INTERFACEID + ", TRANSATIONID="
				+ TRANSATIONID + ", CARDNUM=" + CARDNUM + ", CPUSERID="
				+ CPUSERID + ", CHARGEQUANTITY=" + CHARGEQUANTITY
				+ ", BEFORECHARGEBALANCE=" + BEFORECHARGEBALANCE
				+ ", CHARGEMONEY=" + CHARGEMONEY + ", SERVICETIP=" + SERVICETIP
				+ ", RECORDTIME=" + RECORDTIME + ", CHARGESTARTTIME="
				+ CHARGESTARTTIME + ", CHARGETIMESPAN=" + CHARGETIMESPAN
				+ ", CHARGEFINISHEDFLAG=" + CHARGEFINISHEDFLAG
				+ ", CHARGEENDCAUSE=" + CHARGEENDCAUSE + ", BILLMODELID="
				+ BILLMODELID + ", CHARGEMETHODID=" + CHARGEMETHODID
				+ ", CHARGEMODEID=" + CHARGEMODEID + ", CHARGEPARA="
				+ CHARGEPARA + "]";
	}

	
}

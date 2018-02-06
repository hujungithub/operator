package cn.com.start.DPF.entity;

public class SwipeCardAutRecord {

	// 鉴权记录
	private String DEVICEID; // 设备id
	private String CPID;// 桩id
	private int INTERFACEID;// 枪
	private String PHYSICALCARDNUM;// 物理卡号
	private String CPUSERID;// 用户id
	private String PWD;// 密码
	private String INPUTPWD;// 输入密码
	private float CARDBALANCE;// 卡余额
	private int CARDSTATE; // 卡状态
	private String EVUNIQUEID;// 汽车设备ID
	private String BILLMODELID;// 计费模型id
	private String PAYMENTCARDNUM;// 支付卡卡号
	private String CERTIFIEDPAYMENTCARDDATA;// 认证支付卡数据
	private float ACCOUNTBALANCE;// 账户余额
	private int AUTRESULTFLAG;// 鉴权标识
	private String AUTFAILCAUSE;// 鉴权失败原因
	private float REMAINMILEAGE;// 剩余里程
	private float ALLOWQUANTITY;// 可充电量
	private int REMAINTIMES;// 剩余次数
	private String RECORDTIME;// 记录时间
	private String OPSTATE;// 操作状态

	@Override
	public String toString() {
		return "SwipeCardAutRecord [DEVICEID=" + DEVICEID + ", CPID=" + CPID
				+ ", INTERFACEID=" + INTERFACEID + ", PHYSICALCARDNUM="
				+ PHYSICALCARDNUM + ", CPUSERID=" + CPUSERID + ", PWD=" + PWD
				+ ", INPUTPWD=" + INPUTPWD + ", CARDBALANCE=" + CARDBALANCE
				+ ", CARDSTATE=" + CARDSTATE + ", EVUNIQUEID=" + EVUNIQUEID
				+ ", BILLMODELID=" + BILLMODELID + ", PAYMENTCARDNUM="
				+ PAYMENTCARDNUM + ", CERTIFIEDPAYMENTCARDDATA="
				+ CERTIFIEDPAYMENTCARDDATA + ", ACCOUNTBALANCE="
				+ ACCOUNTBALANCE + ", AUTRESULTFLAG=" + AUTRESULTFLAG
				+ ", AUTFAILCAUSE=" + AUTFAILCAUSE + ", REMAINMILEAGE="
				+ REMAINMILEAGE + ", ALLOWQUANTITY=" + ALLOWQUANTITY
				+ ", REMAINTIMES=" + REMAINTIMES + ", RECORDTIME=" + RECORDTIME
				+ ", OPSTATE=" + OPSTATE + "]";
	}

	public String getDEVICEID() {
		return DEVICEID;
	}

	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getINTERFACEID() {
		return INTERFACEID;
	}

	public void setINTERFACEID(int iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}

	public String getPHYSICALCARDNUM() {
		return PHYSICALCARDNUM;
	}

	public void setPHYSICALCARDNUM(String pHYSICALCARDNUM) {
		PHYSICALCARDNUM = pHYSICALCARDNUM;
	}

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	public String getINPUTPWD() {
		return INPUTPWD;
	}

	public void setINPUTPWD(String iNPUTPWD) {
		INPUTPWD = iNPUTPWD;
	}

	public float getCARDBALANCE() {
		return CARDBALANCE;
	}

	public void setCARDBALANCE(float cARDBALANCE) {
		CARDBALANCE = cARDBALANCE;
	}

	public int getCARDSTATE() {
		return CARDSTATE;
	}

	public void setCARDSTATE(int cARDSTATE) {
		CARDSTATE = cARDSTATE;
	}

	public String getEVUNIQUEID() {
		return EVUNIQUEID;
	}

	public void setEVUNIQUEID(String eVUNIQUEID) {
		EVUNIQUEID = eVUNIQUEID;
	}

	public String getBILLMODELID() {
		return BILLMODELID;
	}

	public void setBILLMODELID(String bILLMODELID) {
		BILLMODELID = bILLMODELID;
	}

	public String getPAYMENTCARDNUM() {
		return PAYMENTCARDNUM;
	}

	public void setPAYMENTCARDNUM(String pAYMENTCARDNUM) {
		PAYMENTCARDNUM = pAYMENTCARDNUM;
	}

	public String getCERTIFIEDPAYMENTCARDDATA() {
		return CERTIFIEDPAYMENTCARDDATA;
	}

	public void setCERTIFIEDPAYMENTCARDDATA(String cERTIFIEDPAYMENTCARDDATA) {
		CERTIFIEDPAYMENTCARDDATA = cERTIFIEDPAYMENTCARDDATA;
	}

	public float getACCOUNTBALANCE() {
		return ACCOUNTBALANCE;
	}

	public void setACCOUNTBALANCE(float aCCOUNTBALANCE) {
		ACCOUNTBALANCE = aCCOUNTBALANCE;
	}

	public int getAUTRESULTFLAG() {
		return AUTRESULTFLAG;
	}

	public void setAUTRESULTFLAG(int aUTRESULTFLAG) {
		AUTRESULTFLAG = aUTRESULTFLAG;
	}

	public String getAUTFAILCAUSE() {
		return AUTFAILCAUSE;
	}

	public void setAUTFAILCAUSE(String aUTFAILCAUSE) {
		AUTFAILCAUSE = aUTFAILCAUSE;
	}

	public float getREMAINMILEAGE() {
		return REMAINMILEAGE;
	}

	public void setREMAINMILEAGE(float rEMAINMILEAGE) {
		REMAINMILEAGE = rEMAINMILEAGE;
	}

	public float getALLOWQUANTITY() {
		return ALLOWQUANTITY;
	}

	public void setALLOWQUANTITY(float aLLOWQUANTITY) {
		ALLOWQUANTITY = aLLOWQUANTITY;
	}

	public int getREMAINTIMES() {
		return REMAINTIMES;
	}

	public void setREMAINTIMES(int rEMAINTIMES) {
		REMAINTIMES = rEMAINTIMES;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public String getOPSTATE() {
		return OPSTATE;
	}

	public void setOPSTATE(String oPSTATE) {
		OPSTATE = oPSTATE;
	}

}
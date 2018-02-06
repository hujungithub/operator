package cn.com.start.DPF.entity;

public class ChargeRecord_DPF {

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
	private float CHARGETIMESPAN;// 充电时长
	private int CHARGEFINISHEDFLAG;// 结束充电标志
	private String CHARGEENDCAUSE;// 结束充电原因
	private int BILLMODELID;// 费率id
	private float JT;// 尖时间
	private float FT;// 峰时间
	private float PT;// 平时间
	private float GT;// 谷时间
	private float JQ;// 尖电量
	private float FQ;// 峰电量
	private float PQ;// 平电量
	private float GQ;// 谷电量
	private float JF;// 尖费用
	private float FF;// 峰费用
	private float PF;// 平费用
	private float GF;// 谷费用
	private int CHARGEMETHODID;// 充电方式 刷卡app
	private int CHARGEMODEID;// 充电设置
	private float CHARGEPARA;// 充电设置参数
	private String OPSTATE; // 操作状态
	private int OPTIMES; // 扣款次数

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
				+ BILLMODELID + ", JT=" + JT + ", FT=" + FT + ", PT=" + PT
				+ ", GT=" + GT + ", JQ=" + JQ + ", FQ=" + FQ + ", PQ=" + PQ
				+ ", GQ=" + GQ + ", JF=" + JF + ", FF=" + FF + ", PF=" + PF
				+ ", GF=" + GF + ", CHARGEMETHODID=" + CHARGEMETHODID
				+ ", CHARGEMODEID=" + CHARGEMODEID + ", CHARGEPARA="
				+ CHARGEPARA + ", OPSTATE=" + OPSTATE + ", OPTIMES=" + OPTIMES
				+ "]";
	}

	public float getBEFORECHARGEBALANCE() {
		return BEFORECHARGEBALANCE;
	}

	public void setBEFORECHARGEBALANCE(float bEFORECHARGEBALANCE) {
		BEFORECHARGEBALANCE = bEFORECHARGEBALANCE;
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

	public int getOPTIMES() {
		return OPTIMES;
	}

	public void setOPTIMES(int oPTIMES) {
		OPTIMES = oPTIMES;
	}

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

	public float getCHARGEMONEY() {
		return CHARGEMONEY;
	}

	public void setCHARGEMONEY(float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
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

	public void setCHARGETIMESPAN(float cHARGETIMESPAN) {
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

	public float getJT() {
		return JT;
	}

	public void setJT(float jT) {
		JT = jT;
	}

	public float getFT() {
		return FT;
	}

	public void setFT(float fT) {
		FT = fT;
	}

	public float getPT() {
		return PT;
	}

	public void setPT(float pT) {
		PT = pT;
	}

	public float getGT() {
		return GT;
	}

	public void setGT(float gT) {
		GT = gT;
	}

	public float getJQ() {
		return JQ;
	}

	public void setJQ(float jQ) {
		JQ = jQ;
	}

	public float getFQ() {
		return FQ;
	}

	public void setFQ(float fQ) {
		FQ = fQ;
	}

	public float getPQ() {
		return PQ;
	}

	public void setPQ(float pQ) {
		PQ = pQ;
	}

	public float getGQ() {
		return GQ;
	}

	public void setGQ(float gQ) {
		GQ = gQ;
	}

	public float getJF() {
		return JF;
	}

	public void setJF(float jF) {
		JF = jF;
	}

	public float getFF() {
		return FF;
	}

	public void setFF(float fF) {
		FF = fF;
	}

	public float getPF() {
		return PF;
	}

	public void setPF(float pF) {
		PF = pF;
	}

	public float getGF() {
		return GF;
	}

	public void setGF(float gF) {
		GF = gF;
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

	public String getOPSTATE() {
		return OPSTATE;
	}

	public void setOPSTATE(String oPSTATE) {
		OPSTATE = oPSTATE;
	}

}

package cn.com.start.webBack.entity;

public class UserDeductMoneyRecord {
	private String CPID;
	private String DEVICEID;// 设备id
	private int INTERFACEID;// 枪
	private int CHARGEMETHOD;// 充电方式
	private String RECORDTIME;// 记录时间
	private String PHYSICALCARDNUM;// 物理卡号
	private String CPUSERID;// 用户id
	private float CHARGEMONEY;// 充电费
	private float SERVICETIP;// 服务费
	private float DEDUCTMONEY;// 扣款信息
	private float REMAINMONEY;// 剩余金额
	private int DEDUCTSUCCESSFLAG;// 扣款成功标志
	private String DEDUCTFAILREASON;// 扣款失败标志
	private float DEDUCTMILE;// 扣除里程
	private float REMAINMILE;// 剩余里程
	private float DEDUCTQUANTITY;// 扣除里程
	private float REMAINQUANTITY;// 剩余里程
	private float DEDUCTTIMES;// 扣除次数
	private float REMAINTIMES;// 剩余次数
	private String TRANSATIONID;// 流水号
	private String OPSTATE;// 操作状态

	@Override
	public String toString() {
		return "UserDeductMoneyRecord [CPID=" + CPID + ", DEVICEID=" + DEVICEID
				+ ", INTERFACEID=" + INTERFACEID + ", CHARGEMETHOD="
				+ CHARGEMETHOD + ", RECORDTIME=" + RECORDTIME
				+ ", PHYSICALCARDNUM=" + PHYSICALCARDNUM + ", CPUSERID="
				+ CPUSERID + ", CHARGEMONEY=" + CHARGEMONEY + ", SERVICETIP="
				+ SERVICETIP + ", DEDUCTMONEY=" + DEDUCTMONEY
				+ ", REMAINMONEY=" + REMAINMONEY + ", DEDUCTSUCCESSFLAG="
				+ DEDUCTSUCCESSFLAG + ", DEDUCTFAILREASON=" + DEDUCTFAILREASON
				+ ", DEDUCTMILE=" + DEDUCTMILE + ", REMAINMILE=" + REMAINMILE
				+ ", DEDUCTQUANTITY=" + DEDUCTQUANTITY + ", REMAINQUANTITY="
				+ REMAINQUANTITY + ", DEDUCTTIMES=" + DEDUCTTIMES
				+ ", REMAINTIMES=" + REMAINTIMES + ", TRANSATIONID="
				+ TRANSATIONID + ", OPSTATE=" + OPSTATE + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getCHARGEMETHOD() {
		return CHARGEMETHOD;
	}

	public void setCHARGEMETHOD(int cHARGEMETHOD) {
		CHARGEMETHOD = cHARGEMETHOD;
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

	public String getOPSTATE() {
		return OPSTATE;
	}

	public void setOPSTATE(String oPSTATE) {
		OPSTATE = oPSTATE;
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

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
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

	public float getDEDUCTMONEY() {
		return DEDUCTMONEY;
	}

	public void setDEDUCTMONEY(float dEDUCTMONEY) {
		DEDUCTMONEY = dEDUCTMONEY;
	}

	public float getREMAINMONEY() {
		return REMAINMONEY;
	}

	public void setREMAINMONEY(float rEMAINMONEY) {
		REMAINMONEY = rEMAINMONEY;
	}

	public int getDEDUCTSUCCESSFLAG() {
		return DEDUCTSUCCESSFLAG;
	}

	public void setDEDUCTSUCCESSFLAG(int dEDUCTSUCCESSFLAG) {
		DEDUCTSUCCESSFLAG = dEDUCTSUCCESSFLAG;
	}

	public String getDEDUCTFAILREASON() {
		return DEDUCTFAILREASON;
	}

	public void setDEDUCTFAILREASON(String dEDUCTFAILREASON) {
		DEDUCTFAILREASON = dEDUCTFAILREASON;
	}

	public float getDEDUCTMILE() {
		return DEDUCTMILE;
	}

	public void setDEDUCTMILE(float dEDUCTMILE) {
		DEDUCTMILE = dEDUCTMILE;
	}

	public float getREMAINMILE() {
		return REMAINMILE;
	}

	public void setREMAINMILE(float rEMAINMILE) {
		REMAINMILE = rEMAINMILE;
	}

	public float getDEDUCTQUANTITY() {
		return DEDUCTQUANTITY;
	}

	public void setDEDUCTQUANTITY(float dEDUCTQUANTITY) {
		DEDUCTQUANTITY = dEDUCTQUANTITY;
	}

	public float getREMAINQUANTITY() {
		return REMAINQUANTITY;
	}

	public void setREMAINQUANTITY(float rEMAINQUANTITY) {
		REMAINQUANTITY = rEMAINQUANTITY;
	}

	public float getDEDUCTTIMES() {
		return DEDUCTTIMES;
	}

	public void setDEDUCTTIMES(float dEDUCTTIMES) {
		DEDUCTTIMES = dEDUCTTIMES;
	}

	public float getREMAINTIMES() {
		return REMAINTIMES;
	}

	public void setREMAINTIMES(float rEMAINTIMES) {
		REMAINTIMES = rEMAINTIMES;
	}

	public String getTRANSATIONID() {
		return TRANSATIONID;
	}

	public void setTRANSATIONID(String tRANSATIONID) {
		TRANSATIONID = tRANSATIONID;
	}

}

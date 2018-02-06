package cn.com.start.DPF.entity;

public class StartChargeGunRecord {

	private String DEVICEID; // 设备id
	private int INTERFACEID; // 枪id
	private int CHARGEMODEID; // 充电模式id
	private float ACCOUNTBALANCE;// 充电之前的余额
	private float CHARGEPARA; // 充电参数
	private int STARTCHARGEFLAG; // 启动充电成功标志
	private String STARTCHARGEFAILDESP; // 启动失败描述
	private String SENDSTARTCMDTIME; // 发送命令时间
	private String CPUSERID; // 用户id
	private String SENDENDCMDTIME; // 发送停止充电时间
	private int ENDCHARGEFLAG; // 停止充电成功标志

	@Override
	public String toString() {
		return "StartChargeGunRecord [DEVICEID=" + DEVICEID + ", INTERFACEID="
				+ INTERFACEID + ", CHARGEMODEID=" + CHARGEMODEID
				+ ", ACCOUNTBALANCE=" + ACCOUNTBALANCE + ", CHARGEPARA="
				+ CHARGEPARA + ", STARTCHARGEFLAG=" + STARTCHARGEFLAG
				+ ", STARTCHARGEFAILDESP=" + STARTCHARGEFAILDESP
				+ ", SENDSTARTCMDTIME=" + SENDSTARTCMDTIME + ", CPUSERID="
				+ CPUSERID + ", SENDENDCMDTIME=" + SENDENDCMDTIME
				+ ", ENDCHARGEFLAG=" + ENDCHARGEFLAG + "]";
	}

	public float getACCOUNTBALANCE() {
		return ACCOUNTBALANCE;
	}

	public void setACCOUNTBALANCE(float aCCOUNTBALANCE) {
		ACCOUNTBALANCE = aCCOUNTBALANCE;
	}

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
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

	public int getSTARTCHARGEFLAG() {
		return STARTCHARGEFLAG;
	}

	public void setSTARTCHARGEFLAG(int sTARTCHARGEFLAG) {
		STARTCHARGEFLAG = sTARTCHARGEFLAG;
	}

	public String getSTARTCHARGEFAILDESP() {
		return STARTCHARGEFAILDESP;
	}

	public void setSTARTCHARGEFAILDESP(String sTARTCHARGEFAILDESP) {
		STARTCHARGEFAILDESP = sTARTCHARGEFAILDESP;
	}

	public String getSENDSTARTCMDTIME() {
		return SENDSTARTCMDTIME;
	}

	public void setSENDSTARTCMDTIME(String sENDSTARTCMDTIME) {
		SENDSTARTCMDTIME = sENDSTARTCMDTIME;
	}

	public String getSENDENDCMDTIME() {
		return SENDENDCMDTIME;
	}

	public void setSENDENDCMDTIME(String sENDENDCMDTIME) {
		SENDENDCMDTIME = sENDENDCMDTIME;
	}

	public int getENDCHARGEFLAG() {
		return ENDCHARGEFLAG;
	}

	public void setENDCHARGEFLAG(int eNDCHARGEFLAG) {
		ENDCHARGEFLAG = eNDCHARGEFLAG;
	}

}

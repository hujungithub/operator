package cn.com.start.webBack.entity;

public class StartChargeGunRecord {

	private int ID;
	// 地址id 主键
	private int DEVICEID;
	private String INTERFACEID;
	private String SENDSTARTCMDTIME;
	private int CHARGEMODEID;
	private float ACCOUNTBALANCE;
	private float CHARGEPARA;
	private int STARTCHARGEFLAG;
	private String STARTCHARGEFAILDESP;
	private int CPUSERID;
	private String SENDENDCMDTIME;
	private char ENDCHARGEFLAG;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getDEVICEID() {
		return DEVICEID;
	}
	public void setDEVICEID(int dEVICEID) {
		DEVICEID = dEVICEID;
	}
	public String getINTERFACEID() {
		return INTERFACEID;
	}
	public void setINTERFACEID(String iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}
	public int getCHARGEMODEID() {
		return CHARGEMODEID;
	}
	public void setCHARGEMODEID(int cHARGEMODEID) {
		CHARGEMODEID = cHARGEMODEID;
	}
	public float getACCOUNTBALANCE() {
		return ACCOUNTBALANCE;
	}
	public void setACCOUNTBALANCE(float aCCOUNTBALANCE) {
		ACCOUNTBALANCE = aCCOUNTBALANCE;
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
	public int getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(int cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public String getSENDENDCMDTIME() {
		return SENDENDCMDTIME;
	}
	public void setSENDENDCMDTIME(String sENDENDCMDTIME) {
		SENDENDCMDTIME = sENDENDCMDTIME;
	}
	public char getENDCHARGEFLAG() {
		return ENDCHARGEFLAG;
	}
	public void setENDCHARGEFLAG(char eNDCHARGEFLAG) {
		ENDCHARGEFLAG = eNDCHARGEFLAG;
	}
	
	public String getSENDSTARTCMDTIME() {
		return SENDSTARTCMDTIME;
	}
	public void setSENDSTARTCMDTIME(String sENDSTARTCMDTIME) {
		SENDSTARTCMDTIME = sENDSTARTCMDTIME;
	}
	@Override
	public String toString() {
		return "StartChargeGunRecord [ID=" + ID + ", DEVICEID=" + DEVICEID
				+ ", INTERFACEID=" + INTERFACEID + ", SENDSTARTCMDTIME="
				+ SENDSTARTCMDTIME + ", CHARGEMODEID=" + CHARGEMODEID
				+ ", ACCOUNTBALANCE=" + ACCOUNTBALANCE + ", CHARGEPARA="
				+ CHARGEPARA + ", STARTCHARGEFLAG=" + STARTCHARGEFLAG
				+ ", STARTCHARGEFAILDESP=" + STARTCHARGEFAILDESP
				+ ", CPUSERID=" + CPUSERID + ", SENDENDCMDTIME="
				+ SENDENDCMDTIME + ", ENDCHARGEFLAG=" + ENDCHARGEFLAG + "]";
	}
}

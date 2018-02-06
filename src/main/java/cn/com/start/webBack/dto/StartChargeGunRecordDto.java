package cn.com.start.webBack.dto;

/**
 * 
 * @author CREATED BY hanmingjing 20170721
 *
 */
public class StartChargeGunRecordDto {

	private String SN;// ID
	private String DEVICEID;// 设备id
	private String INTERFACEID;// 枪id
	private String SENDSTARTCMDTIME;// 发送启动时间
	private int CHARGEMODEID;// 充电模式id
	
	private String ACCOUNTBALANCE;// 账户余额
	private Float CHARGEPARA;// 充电参数
	private Float STARTCHARGEFLAG;// 启动成功标志
	private String STARTCHARGEFAILDESP;// 启动失败原因
	
	private String CPUSERID;// 发送命令用户ID
	private String SENDENDCMDTIME;// 发送停止充电命令时间
	private Float ENDCHARGEFLAG;// 停止充电标志
	
	
	
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getDEVICEID() {
		return DEVICEID;
	}
	public void setDEVICEID(String dEVICEID) {
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
	public String getACCOUNTBALANCE() {
		return ACCOUNTBALANCE;
	}
	public void setACCOUNTBALANCE(String aCCOUNTBALANCE) {
		ACCOUNTBALANCE = aCCOUNTBALANCE;
	}
	public Float getCHARGEPARA() {
		return CHARGEPARA;
	}
	public void setCHARGEPARA(Float cHARGEPARA) {
		CHARGEPARA = cHARGEPARA;
	}
	public Float getSTARTCHARGEFLAG() {
		return STARTCHARGEFLAG;
	}
	public void setSTARTCHARGEFLAG(Float sTARTCHARGEFLAG) {
		STARTCHARGEFLAG = sTARTCHARGEFLAG;
	}
	public String getSENDENDCMDTIME() {
		return SENDENDCMDTIME;
	}
	
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public void setSENDENDCMDTIME(String sENDENDCMDTIME) {
		SENDENDCMDTIME = sENDENDCMDTIME;
	}
	public Float getENDCHARGEFLAG() {
		return ENDCHARGEFLAG;
	}
	public void setENDCHARGEFLAG(Float eNDCHARGEFLAG) {
		ENDCHARGEFLAG = eNDCHARGEFLAG;
	}
	
	public String getSENDSTARTCMDTIME() {
		return SENDSTARTCMDTIME;
	}
	public void setSENDSTARTCMDTIME(String sENDSTARTCMDTIME) {
		SENDSTARTCMDTIME = sENDSTARTCMDTIME;
	}
	
	
	public String getSTARTCHARGEFAILDESP() {
		return STARTCHARGEFAILDESP;
	}
	public void setSTARTCHARGEFAILDESP(String sTARTCHARGEFAILDESP) {
		STARTCHARGEFAILDESP = sTARTCHARGEFAILDESP;
	}
	@Override
	public String toString() {
		return "StartChargeGunRecordDto [SN=" + SN + ", DEVICEID=" + DEVICEID
				+ ", INTERFACEID=" + INTERFACEID + ", SENDSTARTCMDTIME="
				+ SENDSTARTCMDTIME + ", CHARGEMODEID=" + CHARGEMODEID
				+ ", ACCOUNTBALANCE=" + ACCOUNTBALANCE + ", CHARGEPARA="
				+ CHARGEPARA + ", STARTCHARGEFLAG=" + STARTCHARGEFLAG
				+ ", STARTCHARGEFAILDESP=" + STARTCHARGEFAILDESP
				+ ", CPUSERID=" + CPUSERID + ", SENDENDCMDTIME="
				+ SENDENDCMDTIME + ", ENDCHARGEFLAG=" + ENDCHARGEFLAG + "]";
	}
	
}

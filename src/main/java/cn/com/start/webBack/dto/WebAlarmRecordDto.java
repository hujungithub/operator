package cn.com.start.webBack.dto;

public class WebAlarmRecordDto {

	private int ID;
	private String RECORDTIME; // 记录时间
	private String APPCARDID; // app卡用户id
	private String GUN; // 枪
	private String CHARGETYPENAME; // 充电类型 扫码刷卡
	private String ALARMDESP; // 告警描述
	private int CHECKSTATE; // 确认状态
	private int CHECKMODE; // 确认模式
	private String STATENAME; // 状态名
	private String MODENAME;// 模式名
	
	private String CPID;

	@Override
	public String toString() {
		return "WebAlarmRecordDto [ID=" + ID + ", RECORDTIME=" + RECORDTIME
				+ ", APPCARDID=" + APPCARDID + ", CPID=" + CPID + ", GUN="
				+ GUN + ", CHARGETYPENAME=" + CHARGETYPENAME + ", ALARMDESP="
				+ ALARMDESP + ", CHECKSTATE=" + CHECKSTATE + ", CHECKMODE="
				+ CHECKMODE + ", STATENAME=" + STATENAME + ", MODENAME="
				+ MODENAME + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public String getAPPCARDID() {
		return APPCARDID;
	}

	public void setAPPCARDID(String aPPCARDID) {
		APPCARDID = aPPCARDID;
	}

	public String getGUN() {
		return GUN;
	}

	public void setGUN(String gUN) {
		GUN = gUN;
	}

	public String getCHARGETYPENAME() {
		return CHARGETYPENAME;
	}

	public void setCHARGETYPENAME(String cHARGETYPENAME) {
		CHARGETYPENAME = cHARGETYPENAME;
	}

	public String getALARMDESP() {
		return ALARMDESP;
	}

	public void setALARMDESP(String aLARMDESP) {
		ALARMDESP = aLARMDESP;
	}

	public int getCHECKSTATE() {
		return CHECKSTATE;
	}

	public void setCHECKSTATE(int cHECKSTATE) {
		CHECKSTATE = cHECKSTATE;
	}

	public int getCHECKMODE() {
		return CHECKMODE;
	}

	public void setCHECKMODE(int cHECKMODE) {
		CHECKMODE = cHECKMODE;
	}

	public String getSTATENAME() {
		return STATENAME;
	}

	public void setSTATENAME(String sTATENAME) {
		STATENAME = sTATENAME;
	}

	public String getMODENAME() {
		return MODENAME;
	}

	public void setMODENAME(String mODENAME) {
		MODENAME = mODENAME;
	}

}

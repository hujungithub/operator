package cn.com.start.DPF.entity;

public class WebAlarmRecord {


	private String RECORDTIME;
	private String CARDNUM;
	private String CPUSERID;
	private String CPID;
	private int GUN;
	private int ALARMTYPE;
	private int CHARGETYPE;
	private int CHECKSTATE;
	private int CHECKMODE;
	private String DESC;

	/**
	 * @return the dESC
	 */
	public String getDESC() {
		return DESC;
	}

	/**
	 * @param dESC the dESC to set
	 */
	public void setDESC(String dESC) {
		DESC = dESC;
	}



	@Override
	public String toString() {
		return "WebAlarmRecord [RECORDTIME=" + RECORDTIME + ", CARDNUM="
				+ CARDNUM + ", CPUSERID=" + CPUSERID + ", CPID=" + CPID
				+ ", GUN=" + GUN + ", ALARMTYPE=" + ALARMTYPE + ", CHARGETYPE="
				+ CHARGETYPE + ", CHECKSTATE=" + CHECKSTATE + ", CHECKMODE="
				+ CHECKMODE + "]";
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
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

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getGUN() {
		return GUN;
	}

	public void setGUN(int gUN) {
		GUN = gUN;
	}

	public int getALARMTYPE() {
		return ALARMTYPE;
	}

	public void setALARMTYPE(int aLARMTYPE) {
		ALARMTYPE = aLARMTYPE;
	}

	public int getCHARGETYPE() {
		return CHARGETYPE;
	}

	public void setCHARGETYPE(int cHARGETYPE) {
		CHARGETYPE = cHARGETYPE;
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

}

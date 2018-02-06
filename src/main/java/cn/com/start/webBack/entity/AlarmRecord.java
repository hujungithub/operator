package cn.com.start.webBack.entity;

public class AlarmRecord{
	// 桩id
	private Long CPID;
	// 报警状态 (0 未恢复  1 已恢复)
	private boolean ALARMSTATE;
	// 报警类型 (10种)
	private short ALARMTYPE;
	// 实时值
	private float REALVALUE;
	// 阈值
	private float LIMITVALUE;
	// 报警时间
	private String ALARMTIME;
	// 恢复时间
	private String RECOVERYTIME;
	// 恢复方式 (手动 自动)
	private boolean RECOVERYMODE;
	// 操作员ID
	private int USERID;
	
	public Long getCPID() {
		return CPID;
	}
	public void setCPID(Long cPID) {
		CPID = cPID;
	}
	public boolean isALARMSTATE() {
		return ALARMSTATE;
	}
	public void setALARMSTATE(boolean aLARMSTATE) {
		ALARMSTATE = aLARMSTATE;
	}
	public short getALARMTYPE() {
		return ALARMTYPE;
	}
	public void setALARMTYPE(short aLARMTYPE) {
		ALARMTYPE = aLARMTYPE;
	}
	public float getREALVALUE() {
		return REALVALUE;
	}
	public void setREALVALUE(float rEALVALUE) {
		REALVALUE = rEALVALUE;
	}
	public float getLIMITVALUE() {
		return LIMITVALUE;
	}
	public void setLIMITVALUE(float lIMITVALUE) {
		LIMITVALUE = lIMITVALUE;
	}
	public String getALARMTIME() {
		return ALARMTIME;
	}
	public void setALARMTIME(String aLARMTIME) {
		ALARMTIME = aLARMTIME;
	}
	public String getRECOVERYTIME() {
		return RECOVERYTIME;
	}
	public void setRECOVERYTIME(String rECOVERYTIME) {
		RECOVERYTIME = rECOVERYTIME;
	}
	public boolean isRECOVERYMODE() {
		return RECOVERYMODE;
	}
	public void setRECOVERYMODE(boolean rECOVERYMODE) {
		RECOVERYMODE = rECOVERYMODE;
	}

	public int getUSERID() {
		return USERID;
	}
	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}
	@Override
	public String toString() {
		return "AlarmRecord [CPID=" + CPID + ", ALARMSTATE=" + ALARMSTATE
				+ ", ALARMTYPE=" + ALARMTYPE + ", REALVALUE=" + REALVALUE
				+ ", LIMITVALUE=" + LIMITVALUE + ", ALARMTIME=" + ALARMTIME
				+ ", RECOVERYTIME=" + RECOVERYTIME + ", RECOVERYMODE="
				+ RECOVERYMODE + ", USERID=" + USERID + "]";
	}

}

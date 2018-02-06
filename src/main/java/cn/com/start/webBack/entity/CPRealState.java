package cn.com.start.webBack.entity;

public class CPRealState {
	private String CPID; // 桩id
	private String CPSTATETYPE; // 当前状态类型 0-6
	private String CPSTATETIME; // 状态时间
	private String CPCOMMSTATE; // 通信状态

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPSTATETYPE() {
		return CPSTATETYPE;
	}

	public void setCPSTATETYPE(String cPSTATETYPE) {
		CPSTATETYPE = cPSTATETYPE;
	}

	public String getCPSTATETIME() {
		return CPSTATETIME;
	}

	public void setCPSTATETIME(String cPSTATETIME) {
		CPSTATETIME = cPSTATETIME;
	}

	public String getCPCOMMSTATE() {
		return CPCOMMSTATE;
	}

	public void setCPCOMMSTATE(String cPCOMMSTATE) {
		CPCOMMSTATE = cPCOMMSTATE;
	}

	@Override
	public String toString() {
		return "CPRealState [CPID=" + CPID + ", CPSTATETYPE=" + CPSTATETYPE
				+ ", CPSTATETIME=" + CPSTATETIME + ", CPCOMMSTATE="
				+ CPCOMMSTATE + "]";
	}

}

package cn.com.start.webBack.entity;

public class CPStateType {
	private int STATEID; // 状态id
	private String STATENAME;// 状态名
	private String STATEDESP;// 状态描述

	public int getSTATEID() {
		return STATEID;
	}

	public void setSTATEID(int sTATEID) {
		STATEID = sTATEID;
	}

	public String getSTATENAME() {
		return STATENAME;
	}

	public void setSTATENAME(String sTATENAME) {
		STATENAME = sTATENAME;
	}

	public String getSTATEDESP() {
		return STATEDESP;
	}

	public void setSTATEDESP(String sTATEDESP) {
		STATEDESP = sTATEDESP;
	}

	@Override
	public String toString() {
		return "CPStateType [STATEID=" + STATEID + ", STATENAME=" + STATENAME
				+ ", STATEDESP=" + STATEDESP + "]";
	}

}

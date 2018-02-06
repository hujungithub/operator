package cn.com.start.DPF.entity;

public class CPStateType_DPF {

	private int PROTOCOLID; // 协议id
	private int STATEID;// 状态id
	private String STATENAME; // 状态类型
	private String STATEDESP; // 状态描述

	@Override
	public String toString() {
		return "CPStateType_DPF [PROTOCOLID=" + PROTOCOLID + ", STATEID="
				+ STATEID + ", STATENAME=" + STATENAME + ", STATEDESP="
				+ STATEDESP + "]";
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

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

}

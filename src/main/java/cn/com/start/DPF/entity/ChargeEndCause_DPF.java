package cn.com.start.DPF.entity;

public class ChargeEndCause_DPF {
	private int PROTOCOLID; // 协议ID
	private int CAUSEID; // 原因ID
	private String CAUSENAME;// 原因名称
	private String DESP;// 描述

	@Override
	public String toString() {
		return "ChargeEndCause [PROTOCOLID=" + PROTOCOLID + ", CAUSEID="
				+ CAUSEID + ", CAUSENAME=" + CAUSENAME + ", DESP=" + DESP + "]";
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public int getCAUSEID() {
		return CAUSEID;
	}

	public void setCAUSEID(int cAUSEID) {
		CAUSEID = cAUSEID;
	}

	public String getCAUSENAME() {
		return CAUSENAME;
	}

	public void setCAUSENAME(String cAUSENAME) {
		CAUSENAME = cAUSENAME;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

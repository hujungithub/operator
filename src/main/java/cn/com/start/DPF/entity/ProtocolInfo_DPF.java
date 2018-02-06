package cn.com.start.DPF.entity;

public class ProtocolInfo_DPF {
	private int PROTOCOLID; // 协议id
	private String PROTOCOLNAME; // 协议名
	private String DESP; // 协议描述

	@Override
	public String toString() {
		return "ProtocolInfo [PROTOCOLID=" + PROTOCOLID + ", PROTOCOLNAME="
				+ PROTOCOLNAME + ", DESP=" + DESP + "]";
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public String getPROTOCOLNAME() {
		return PROTOCOLNAME;
	}

	public void setPROTOCOLNAME(String pROTOCOLNAME) {
		PROTOCOLNAME = pROTOCOLNAME;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

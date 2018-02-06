package cn.com.start.DPF.entity;

public class YCPointList_DPF {
	private int PROTOCOLID; // 协议id
	private int YCPOINTID; // 遥测点id
	private String YCPOINTNAME; // 遥测点名
	private int PC; // 倍率
	private String DESP;// 描述

	@Override
	public String toString() {
		return "YCPointList [PROTOCOLID=" + PROTOCOLID + ", YCPOINTID="
				+ YCPOINTID + ", YCPOINTNAME=" + YCPOINTNAME + ", PC=" + PC
				+ ", DESP=" + DESP + "]";
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public int getYCPOINTID() {
		return YCPOINTID;
	}

	public void setYCPOINTID(int yCPOINTID) {
		YCPOINTID = yCPOINTID;
	}

	public String getYCPOINTNAME() {
		return YCPOINTNAME;
	}

	public void setYCPOINTNAME(String yCPOINTNAME) {
		YCPOINTNAME = yCPOINTNAME;
	}

	public int getPC() {
		return PC;
	}

	public void setPC(int pC) {
		PC = pC;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

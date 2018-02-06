package cn.com.start.DPF.entity;

public class YXPointList_DPF {
	private int PROTOCOLID; // 协议id
	private String YXPOINTID;// 遥信点id
	private String YXPOINTNAME;// 遥信点名
	private String OCFLAG;// zz
	private String TYPE;// zz
	private String DESP;// 描述
	private String Mean_0;
	private String Mean_1;
	private String Mean_2;
	private int NeedAlarm;

	@Override
	public String toString() {
		return "YXPointList_DPF [PROTOCOLID=" + PROTOCOLID + ", YXPOINTID="
				+ YXPOINTID + ", YXPOINTNAME=" + YXPOINTNAME + ", OCFLAG="
				+ OCFLAG + ", TYPE=" + TYPE + ", DESP=" + DESP + ", Mean_0="
				+ Mean_0 + ", Mean_1=" + Mean_1 + ", Mean_2=" + Mean_2
				+ ", NeedAlarm=" + NeedAlarm + "]";
	}

	public String getMean_0() {
		return Mean_0;
	}

	public void setMean_0(String mean_0) {
		Mean_0 = mean_0;
	}

	public String getMean_1() {
		return Mean_1;
	}

	public void setMean_1(String mean_1) {
		Mean_1 = mean_1;
	}

	public String getMean_2() {
		return Mean_2;
	}

	public void setMean_2(String mean_2) {
		Mean_2 = mean_2;
	}

	public int getNeedAlarm() {
		return NeedAlarm;
	}

	public void setNeedAlarm(int needAlarm) {
		NeedAlarm = needAlarm;
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public String getYXPOINTID() {
		return YXPOINTID;
	}

	public void setYXPOINTID(String yXPOINTID) {
		YXPOINTID = yXPOINTID;
	}

	public String getYXPOINTNAME() {
		return YXPOINTNAME;
	}

	public void setYXPOINTNAME(String yXPOINTNAME) {
		YXPOINTNAME = yXPOINTNAME;
	}

	public String getOCFLAG() {
		return OCFLAG;
	}

	public void setOCFLAG(String oCFLAG) {
		OCFLAG = oCFLAG;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

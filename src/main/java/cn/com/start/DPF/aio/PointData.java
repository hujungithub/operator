package cn.com.start.DPF.aio;

public class PointData {

	private int PROTOCOLID; // 协议
	private int POINTID; // yc点
	private float DATA; // 值
	private int FLAG;// 可信
	private String SDATA;// 遥信直接存字符串

	@Override
	public String toString() {
		return "PointData [PROTOCOLID=" + PROTOCOLID + ", POINTID=" + POINTID
				+ ", DATA=" + DATA + ", FLAG=" + FLAG + ", SDATA=" + SDATA
				+ "]";
	}

	public String getSDATA() {
		return SDATA;
	}

	public void setSDATA(String sDATA) {
		SDATA = sDATA;
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public int getPOINTID() {
		return POINTID;
	}

	public void setPOINTID(int pOINTID) {
		POINTID = pOINTID;
	}

	public float getDATA() {
		return DATA;
	}

	public void setDATA(float dATA) {
		DATA = dATA;
	}

	public int getFLAG() {
		return FLAG;
	}

	public void setFLAG(int fLAG) {
		FLAG = fLAG;
	}

}

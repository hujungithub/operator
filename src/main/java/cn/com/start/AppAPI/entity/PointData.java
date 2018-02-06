package cn.com.start.AppAPI.entity;

public class PointData {

	private int PROTOCOLID; // 协议
	private int POINTID; // yc点
	private float DATA; // 值
	private int FLAG;// 可信

	@Override
	public String toString() {
		return "PointData [PROTOCOLID=" + PROTOCOLID + ", POINTID=" + POINTID
				+ ", DATA=" + DATA + ", FLAG=" + FLAG + "]";
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

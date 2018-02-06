package cn.com.start.webBack.entity;

public class Area {
	// 城市id
	private int CITYID;
	// 区域id 主键
	private int AREAID;
	// 区域名称
	private String AREANAME;

	public int getCITYID() {
		return CITYID;
	}

	public void setCITYID(int cITYID) {
		CITYID = cITYID;
	}

	public int getAREAID() {
		return AREAID;
	}

	public void setAREAID(int aREAID) {
		AREAID = aREAID;
	}

	public String getAREANAME() {
		return AREANAME;
	}

	public void setAREANAME(String aREANAME) {
		AREANAME = aREANAME;
	}

	@Override
	public String toString() {
		return "Area [CITYID=" + CITYID + ", AREAID=" + AREAID + ", AREANAME="
				+ AREANAME + "]";
	}

}

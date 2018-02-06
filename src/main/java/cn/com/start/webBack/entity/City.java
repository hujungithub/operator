package cn.com.start.webBack.entity;

public class City {
	// 省id
	private int PROVINCEID;
	// 市ID 主键
	private int CITYID;
	// 城市名称
	private String CITYNAME;

	public int getPROVINCEID() {
		return PROVINCEID;
	}

	public void setPROVINCEID(int pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}

	public int getCITYID() {
		return CITYID;
	}

	public void setCITYID(int cITYID) {
		CITYID = cITYID;
	}

	public String getCITYNAME() {
		return CITYNAME;
	}

	public void setCITYNAME(String cITYNAME) {
		CITYNAME = cITYNAME;
	}

	@Override
	public String toString() {
		return "City [PROVINCEID=" + PROVINCEID + ", CITYID=" + CITYID
				+ ", CITYNAME=" + CITYNAME + "]";
	}

}

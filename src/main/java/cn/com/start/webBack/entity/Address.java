package cn.com.start.webBack.entity;

public class Address {
	// 区域id
	private int AREAID;
	// 地址id 主键
	private int ADDRESSID;
	// 地址
	private String ADDRESSNAME;
	// 经度
	private String LONGITUDE;
	// 纬度
	private String LATITUDE;

	public int getAREAID() {
		return AREAID;
	}

	public void setAREAID(int aREAID) {
		AREAID = aREAID;
	}

	public int getADDRESSID() {
		return ADDRESSID;
	}

	public void setADDRESSID(int aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}


	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}

	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}

	@Override
	public String toString() {
		return "Address [AREAID=" + AREAID + ", ADDRESSID=" + ADDRESSID
				+ ", ADDRESSNAME=" + ADDRESSNAME + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + "]";
	}

}
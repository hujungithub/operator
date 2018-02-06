package cn.com.start.webBack.dto;

public class AddressDto {
	// 省份ID
	private Integer PROVINCEID;
	// 市ID
	private Integer CITYID;
	// 区ID
	private Integer AREAID;
	// 地址ID
	private Integer ADDRESSID;
	// 省份名称
	private String PROVINCENAME;
	// 市名称
	private String CITYNAME;
	// 区域名称
	private String AREANAME;
	// 地址名称
	private String ADDRESSNAME;
	// 拼接地址
	private String LOCATION;
	// 经度
	private String LONGITUDE;
	// 纬度
	private String LATITUDE;

	public Integer getPROVINCEID() {
		return PROVINCEID;
	}

	public void setPROVINCEID(Integer pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}

	public Integer getCITYID() {
		return CITYID;
	}

	public void setCITYID(Integer cITYID) {
		CITYID = cITYID;
	}

	public int getAREAID() {
		return AREAID;
	}

	public void setAREAID(Integer aREAID) {
		AREAID = aREAID;
	}

	public Integer getADDRESSID() {
		return ADDRESSID;
	}

	public void setADDRESSID(Integer aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}

	public String getPROVINCENAME() {
		return PROVINCENAME;
	}

	public void setPROVINCENAME(String pROVINCENAME) {
		PROVINCENAME = pROVINCENAME;
	}

	public String getCITYNAME() {
		return CITYNAME;
	}

	public void setCITYNAME(String cITYNAME) {
		CITYNAME = cITYNAME;
	}

	public String getAREANAME() {
		return AREANAME;
	}

	public void setAREANAME(String aREANAME) {
		AREANAME = aREANAME;
	}

	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}

	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
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
		return "AddressDto [PROVINCEID=" + PROVINCEID + ", CITYID=" + CITYID
				+ ", AREAID=" + AREAID + ", ADDRESSID=" + ADDRESSID
				+ ", PROVINCENAME=" + PROVINCENAME + ", CITYNAME=" + CITYNAME
				+ ", AREANAME=" + AREANAME + ", ADDRESSNAME=" + ADDRESSNAME
				+ ", LOCATION=" + LOCATION + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + "]";
	}

}

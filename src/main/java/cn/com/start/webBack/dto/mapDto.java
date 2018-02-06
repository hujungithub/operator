package cn.com.start.webBack.dto;

public class mapDto {
	private String CPNAME;
	
	private String LOCATION;
	private String ADDRESSNAME;
	
	private String CPID;
	private String PROVINCENAME;
	// 经度
	private String LONGITUDE;
	// 纬度
	private String LATITUDE;
	@Override
	public String toString() {
		return "mapDto [CPNAME=" + CPNAME + ", LOCATION=" + LOCATION
				+ ", ADDRESSNAME=" + ADDRESSNAME + ", CPID=" + CPID
				+ ", PROVINCENAME=" + PROVINCENAME + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + "]";
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
	public String getCPNAME() {
		return CPNAME;
	}
	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}
	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
	}
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getPROVINCENAME() {
		return PROVINCENAME;
	}
	public void setPROVINCENAME(String pROVINCENAME) {
		PROVINCENAME = pROVINCENAME;
	}
	
	
}

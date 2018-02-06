package cn.com.start.AppAPI.dto;

public class SelectMapDto {
	private String CSID; // 站id
	private String CPMID; // cpm
	private String CPID; // 桩

	private String LONGITUDE; // 经度
	private String LATITUDE; // 纬度
	private String MONTH;
	


	@Override
	public String toString() {
		return "SelectMapDto [CSID=" + CSID + ", CPMID=" + CPMID + ", CPID="
				+ CPID + ", LONGITUDE=" + LONGITUDE + ", LATITUDE=" + LATITUDE
				+ ", MONTH=" + MONTH + "]";
	}

	public String getMONTH() {
		return MONTH;
	}

	public void setMONTH(String mONTH) {
		MONTH = mONTH;
	}

	public String getCPMID() {
		return CPMID;
	}

	public void setCPMID(String cPMID) {
		CPMID = cPMID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
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

}

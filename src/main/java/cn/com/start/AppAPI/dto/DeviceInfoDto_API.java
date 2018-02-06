package cn.com.start.AppAPI.dto;

public class DeviceInfoDto_API {
	public String DEVICEID; //
	public String CPNAME;
	
	@Override
	public String toString() {
		return "DeviceInfoDto_API [DEVICEID=" + DEVICEID + ", CPNAME=" + CPNAME
				+ "]";
	}
	public String getDEVICEID() {
		return DEVICEID;
	}
	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}
	public String getCPNAME() {
		return CPNAME;
	}
	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}
	
	
	
}

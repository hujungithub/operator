package cn.com.start.webBack.dto;

public class FindChargeProgressDto {

	private String OPERATORLOGINID;
	
	private String CPID;
	
	private String FROMDATA;
	
	private String TODATA;

	@Override
	public String toString() {
		return "FindChargeProgressDto [OPERATORLOGINID=" + OPERATORLOGINID + ", CPID=" + CPID + ", FROMDATA=" + FROMDATA
				+ ", TODATA=" + TODATA + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getFROMDATA() {
		return FROMDATA;
	}

	public void setFROMDATA(String fROMDATA) {
		FROMDATA = fROMDATA;
	}

	public String getTODATA() {
		return TODATA;
	}

	public void setTODATA(String tODATA) {
		TODATA = tODATA;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}
}

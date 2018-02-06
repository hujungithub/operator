package cn.com.start.webBack.dto;

public class AdminDto {

	private String ROLEID;
	private String ROLENM;
	private String ADMINID;
	private String ADMINNM;
	private String LOGINID;
	private String LOGINPWD;
	private String LOGINTIME;
	private String INVALIDFLG;

	public String getADMINID() {
		return ADMINID;
	}

	public void setADMINID(String aDMINID) {
		ADMINID = aDMINID;
	}

	public String getADMINNM() {
		return ADMINNM;
	}

	public void setADMINNM(String aDMINNM) {
		ADMINNM = aDMINNM;
	}

	public String getLOGINID() {
		return LOGINID;
	}

	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}

	public String getLOGINPWD() {
		return LOGINPWD;
	}

	public void setLOGINPWD(String lOGINPWD) {
		LOGINPWD = lOGINPWD;
	}

	public String getLOGINTIME() {
		return LOGINTIME;
	}

	public void setLOGINTIME(String lOGINTIME) {
		LOGINTIME = lOGINTIME;
	}

	public String getINVALIDFLG() {
		return INVALIDFLG;
	}

	public void setINVALIDFLG(String iNVALIDFLG) {
		INVALIDFLG = iNVALIDFLG;
	}

	public String getROLENM() {
		return ROLENM;
	}

	public void setROLENM(String rOLENM) {
		ROLENM = rOLENM;
	}

	public String getROLEID() {
		return ROLEID;
	}

	public void setROLEID(String rOLEID) {
		ROLEID = rOLEID;
	}

}

package cn.com.start.AppAPI.dto;

public class CPDataDto {

	private String CPID;
	private String TODAYFEE;
	private String TODAYQUANTITY;
	private String TOTALFEE;
	private String TOTALQUANTITY;
	private String LASTFEE;
	private String LASTQUANTITY;

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getTODAYFEE() {
		return TODAYFEE;
	}

	public void setTODAYFEE(String tODAYFEE) {
		TODAYFEE = tODAYFEE;
	}

	public String getTODAYQUANTITY() {
		return TODAYQUANTITY;
	}

	public void setTODAYQUANTITY(String tODAYQUANTITY) {
		TODAYQUANTITY = tODAYQUANTITY;
	}

	public String getTOTALFEE() {
		return TOTALFEE;
	}

	public void setTOTALFEE(String tOTALFEE) {
		TOTALFEE = tOTALFEE;
	}

	public String getTOTALQUANTITY() {
		return TOTALQUANTITY;
	}

	public void setTOTALQUANTITY(String tOTALQUANTITY) {
		TOTALQUANTITY = tOTALQUANTITY;
	}

	public String getLASTFEE() {
		return LASTFEE;
	}

	public void setLASTFEE(String lASTFEE) {
		LASTFEE = lASTFEE;
	}

	public String getLASTQUANTITY() {
		return LASTQUANTITY;
	}

	public void setLASTQUANTITY(String lASTQUANTITY) {
		LASTQUANTITY = lASTQUANTITY;
	}

}
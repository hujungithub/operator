package cn.com.start.AppAPI.dto;

public class ScanChargeDto {

	private String CPID; // 充电桩id
	private String LOCATION; // 充电桩地址
	private String CPTYPE; // 充电桩类型
	private String CPPHASE; //单项，三项
	private String CPNAME; // 充电桩名
	private String RATEID; // 当前时间费率ID
	private String CHARGEFEE; // 当前时间段费用

	private String CURRENTAVOL; // 当前电压
	private String CURRENTACUR; // 当前电流
	private String CURRQUANTITY; // 当前电量
	private String CURRFEE; // 当前费用
	private String CURRENTSOC; // 当前充电SOC

	@Override
	public String toString() {
		return "ScanChargeDto [CPID=" + CPID + ", LOCATION=" + LOCATION
				+ ", CPTYPE=" + CPTYPE + ", CPNAME=" + CPNAME + ", RATEID="
				+ RATEID + ", CHARGEFEE=" + CHARGEFEE + ", CURRENTAVOL="
				+ CURRENTAVOL + ", CURRENTACUR=" + CURRENTACUR
				+ ", CURRQUANTITY=" + CURRQUANTITY + ", CURRFEE=" + CURRFEE
				+ ", CURRENTSOC=" + CURRENTSOC + "]";
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getCHARGEFEE() {
		return CHARGEFEE;
	}

	public void setCHARGEFEE(String cHARGEFEE) {
		CHARGEFEE = cHARGEFEE;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getCPNAME() {
		return CPNAME;
	}

	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	public String getCURRENTAVOL() {
		return CURRENTAVOL;
	}

	public void setCURRENTAVOL(String cURRENTAVOL) {
		CURRENTAVOL = cURRENTAVOL;
	}

	public String getCURRENTACUR() {
		return CURRENTACUR;
	}

	public void setCURRENTACUR(String cURRENTACUR) {
		CURRENTACUR = cURRENTACUR;
	}

	public String getCURRQUANTITY() {
		return CURRQUANTITY;
	}

	public void setCURRQUANTITY(String cURRQUANTITY) {
		CURRQUANTITY = cURRQUANTITY;
	}

	public String getCURRFEE() {
		return CURRFEE;
	}

	public void setCURRFEE(String cURRFEE) {
		CURRFEE = cURRFEE;
	}

	public String getCURRENTSOC() {
		return CURRENTSOC;
	}

	public void setCURRENTSOC(String cURRENTSOC) {
		CURRENTSOC = cURRENTSOC;
	}

	public String getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(String cPPHASE) {
		CPPHASE = cPPHASE;
	}

}

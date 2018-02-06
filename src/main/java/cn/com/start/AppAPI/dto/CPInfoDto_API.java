package cn.com.start.AppAPI.dto;

public class CPInfoDto_API {
	private String CPID;
	private String CPNAME;
	private String PARKNO;
	private String CPTYPE;
	private String CURRSTATE;
	private String RATEDPOWER;
	private String INTERFACECOUNT;
	private String MODEL;

	@Override
	public String toString() {
		return "CPInfoDto [CPID=" + CPID + ", CPNAME=" + CPNAME + ", PARKNO="
				+ PARKNO + ", CPTYPE=" + CPTYPE + ", CURRSTATE=" + CURRSTATE
				+ ", RATEDPOWER=" + RATEDPOWER + ", INTERFACECOUNT="
				+ INTERFACECOUNT + ", MODEL=" + MODEL + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPNAME() {
		return CPNAME;
	}

	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	public String getPARKNO() {
		return PARKNO;
	}

	public void setPARKNO(String pARKNO) {
		PARKNO = pARKNO;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getCURRSTATE() {
		return CURRSTATE;
	}

	public void setCURRSTATE(String cURRSTATE) {
		CURRSTATE = cURRSTATE;
	}

	public String getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(String rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public String getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(String iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

}

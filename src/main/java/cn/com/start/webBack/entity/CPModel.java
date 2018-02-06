package cn.com.start.webBack.entity;

public class CPModel {
	private String MFRID;// 厂商id
	private String MODEL;// 型号
	private String RATEDPOWER;// 额定功率
	private String CPTYPE;// 类型
	private String CPPHASE;// 相数
	private String INTERFACECOUNT;// 枪数

	@Override
	public String toString() {
		return "CPModel [MFRID=" + MFRID + ", MODEL=" + MODEL + ", RATEDPOWER="
				+ RATEDPOWER + ", CPTYPE=" + CPTYPE + ", CPPHASE=" + CPPHASE
				+ ", INTERFACECOUNT=" + INTERFACECOUNT + "]";
	}

	public String getMFRID() {
		return MFRID;
	}

	public void setMFRID(String mFRID) {
		MFRID = mFRID;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public String getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(String rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(String cPPHASE) {
		CPPHASE = cPPHASE;
	}

	public String getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(String iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

}

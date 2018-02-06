package cn.com.start.DPF.entity;

public class CPModel_DPF {
	public int MFRID; // 厂商id
	public String MODEL;// 型号
	public float RATEDPOWER;// 额定功率
	public int CPTYPE;// 类型
	public int CPPHASE;// 相数
	public int INTERFACECOUNT;// 枪数

	@Override
	public String toString() {
		return "CPModel_DPF [MFRID=" + MFRID + ", MODEL=" + MODEL
				+ ", RATEDPOWER=" + RATEDPOWER + ", CPTYPE=" + CPTYPE
				+ ", CPPHASE=" + CPPHASE + ", INTERFACECOUNT=" + INTERFACECOUNT
				+ "]";
	}

	public int getMFRID() {
		return MFRID;
	}

	public void setMFRID(int mFRID) {
		MFRID = mFRID;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public float getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(float rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public int getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(int cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public int getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(int cPPHASE) {
		CPPHASE = cPPHASE;
	}

	public int getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(int iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

}

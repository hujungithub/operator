package cn.com.start.webBack.entity;

public class CPMfrInfo {

	// 充电桩厂商id
	private int MFRID;
	// 充电桩厂商名
	private String MFRNAME;
	// 厂商代号
	private String MFRABBR;

	public int getMFRID() {
		return MFRID;
	}

	public void setMFRID(int mFRID) {
		MFRID = mFRID;
	}

	public String getMFRNAME() {
		return MFRNAME;
	}

	public void setMFRNAME(String mFRNAME) {
		MFRNAME = mFRNAME;
	}

	public String getMFRABBR() {
		return MFRABBR;
	}

	public void setMFRABBR(String mFRABBR) {
		MFRABBR = mFRABBR;
	}

	@Override
	public String toString() {
		return "CPMfrInfo [MFRID=" + MFRID + ", MFRNAME=" + MFRNAME
				+ ", MFRABBR=" + MFRABBR + "]";
	}

}

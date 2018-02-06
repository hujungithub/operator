package cn.com.start.webBack.dto;

public class ManufDto {
	
	private String MFRNAME;//厂商
	
	private String MFRID;//厂商id
	
	private String MODEL;//型号
	
	private String CPTYPE;//类型
	
	private String MFRID2;
	
	/**
	 * @return the mFRID2
	 */
	public String getMFRID2() {
		return MFRID2;
	}

	/**
	 * @param mFRID2 the mFRID2 to set
	 */
	public void setMFRID2(String mFRID2) {
		MFRID2 = mFRID2;
	}

	private String MODEL2;
	/**
	 * @return the mODEL2
	 */
	public String getMODEL2() {
		return MODEL2;
	}

	/**
	 * @param mODEL2 the mODEL2 to set
	 */
	public void setMODEL2(String mODEL2) {
		MODEL2 = mODEL2;
	}

	private String INTERFACECOUNT;//枪数
	
	private String CPPHASE;//相数
	
	private String MFRABBR;//厂商代号
	private String RATEDPOWER;//额定功率
	//add by niehy 20170824 begin
	private String oldMODEL;//更新前型号
	/**
	 * @Title: toString
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManufDto [MFRNAME=" + MFRNAME + ", MFRID=" + MFRID + ", MODEL=" + MODEL + ", CPTYPE=" + CPTYPE
				+ ", MODEL2=" + MODEL2 + ", INTERFACECOUNT=" + INTERFACECOUNT + ", CPPHASE=" + CPPHASE + ", MFRABBR="
				+ MFRABBR + ", RATEDPOWER=" + RATEDPOWER + ", oldMODEL=" + oldMODEL + "]";
	}
	
	public String getMFRABBR() {
		return MFRABBR;
	}

	public void setMFRABBR(String mFRABBR) {
		MFRABBR = mFRABBR;
	}

	public String getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(String rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public String getMFRNAME() {
		return MFRNAME;
	}

	public void setMFRNAME(String mFRNAME) {
		MFRNAME = mFRNAME;
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

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(String iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

	public String getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(String cPPHASE) {
		CPPHASE = cPPHASE;
	}

	public String getOldMODEL() {
		return oldMODEL;
	}

	public void setOldMODEL(String oldMODEL) {
		this.oldMODEL = oldMODEL;
	}
	

}

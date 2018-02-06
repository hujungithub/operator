package cn.com.start.webBack.entity;

public class CPAlarmPara {
	private String MFRID; // 厂商id
	private String MODE; // 型号
	private String IVUPLIMIT;// 输入电压上限
	private String IVLOWLIMIT;// 输入电压下限
	private String OVUPLIMIT;// 输出电压上限
	private String OVLOWLIMIT;// 输出电压下限
	private String ICUPLIMIT;// 输入电流上限
	private String ICLOWLIMIT;// 输入电流下限
	private String OCUPLIMIT;// 输出电流上限
	private String OCLOWLIMIT;// 输出电流下限
	private String TEMPUPLIMIT;// 温度过高上限

	@Override
	public String toString() {
		return "CPAlarmPara [MFRID=" + MFRID + ", MODE=" + MODE
				+ ", IVUPLIMIT=" + IVUPLIMIT + ", IVLOWLIMIT=" + IVLOWLIMIT
				+ ", OVUPLIMIT=" + OVUPLIMIT + ", OVLOWLIMIT=" + OVLOWLIMIT
				+ ", ICUPLIMIT=" + ICUPLIMIT + ", ICLOWLIMIT=" + ICLOWLIMIT
				+ ", OCUPLIMIT=" + OCUPLIMIT + ", OCLOWLIMIT=" + OCLOWLIMIT
				+ ", TEMPUPLIMIT=" + TEMPUPLIMIT + "]";
	}

	public String getMFRID() {
		return MFRID;
	}

	public void setMFRID(String mFRID) {
		MFRID = mFRID;
	}

	public String getMODE() {
		return MODE;
	}

	public void setMODE(String mODE) {
		MODE = mODE;
	}

	public String getIVUPLIMIT() {
		return IVUPLIMIT;
	}

	public void setIVUPLIMIT(String iVUPLIMIT) {
		IVUPLIMIT = iVUPLIMIT;
	}

	public String getIVLOWLIMIT() {
		return IVLOWLIMIT;
	}

	public void setIVLOWLIMIT(String iVLOWLIMIT) {
		IVLOWLIMIT = iVLOWLIMIT;
	}

	public String getOVUPLIMIT() {
		return OVUPLIMIT;
	}

	public void setOVUPLIMIT(String oVUPLIMIT) {
		OVUPLIMIT = oVUPLIMIT;
	}

	public String getOVLOWLIMIT() {
		return OVLOWLIMIT;
	}

	public void setOVLOWLIMIT(String oVLOWLIMIT) {
		OVLOWLIMIT = oVLOWLIMIT;
	}

	public String getICUPLIMIT() {
		return ICUPLIMIT;
	}

	public void setICUPLIMIT(String iCUPLIMIT) {
		ICUPLIMIT = iCUPLIMIT;
	}

	public String getICLOWLIMIT() {
		return ICLOWLIMIT;
	}

	public void setICLOWLIMIT(String iCLOWLIMIT) {
		ICLOWLIMIT = iCLOWLIMIT;
	}

	public String getOCUPLIMIT() {
		return OCUPLIMIT;
	}

	public void setOCUPLIMIT(String oCUPLIMIT) {
		OCUPLIMIT = oCUPLIMIT;
	}

	public String getOCLOWLIMIT() {
		return OCLOWLIMIT;
	}

	public void setOCLOWLIMIT(String oCLOWLIMIT) {
		OCLOWLIMIT = oCLOWLIMIT;
	}

	public String getTEMPUPLIMIT() {
		return TEMPUPLIMIT;
	}

	public void setTEMPUPLIMIT(String tEMPUPLIMIT) {
		TEMPUPLIMIT = tEMPUPLIMIT;
	}

}

package cn.com.start.DPF.entity;

public class CPAlarmPara_DPF {
	private int MFRID; // 厂商id
	private String MODE; // 型号
	private float IVUPLIMIT;// 输入电压上限
	private float IVLOWLIMIT;// 输入电压下限
	private float OVUPLIMIT;// 输出电压上限
	private float OVLOWLIMIT;// 输出电压下限
	private float ICUPLIMIT;// 输入电流上限
	private float ICLOWLIMIT;// 输入电流下限
	private float OCUPLIMIT;// 输出电流上限
	private float OCLOWLIMIT;// 输出电流下限
	private float TEMPUPLIMIT;// 温度过高上限

	@Override
	public String toString() {
		return "CPAlarmPara [MFRID=" + MFRID + ", MODE=" + MODE
				+ ", IVUPLIMIT=" + IVUPLIMIT + ", IVLOWLIMIT=" + IVLOWLIMIT
				+ ", OVUPLIMIT=" + OVUPLIMIT + ", OVLOWLIMIT=" + OVLOWLIMIT
				+ ", ICUPLIMIT=" + ICUPLIMIT + ", ICLOWLIMIT=" + ICLOWLIMIT
				+ ", OCUPLIMIT=" + OCUPLIMIT + ", OCLOWLIMIT=" + OCLOWLIMIT
				+ ", TEMPUPLIMIT=" + TEMPUPLIMIT + "]";
	}

	public int getMFRID() {
		return MFRID;
	}

	public void setMFRID(int mFRID) {
		MFRID = mFRID;
	}

	public String getMODE() {
		return MODE;
	}

	public void setMODE(String mODE) {
		MODE = mODE;
	}

	public float getIVUPLIMIT() {
		return IVUPLIMIT;
	}

	public void setIVUPLIMIT(float iVUPLIMIT) {
		IVUPLIMIT = iVUPLIMIT;
	}

	public float getIVLOWLIMIT() {
		return IVLOWLIMIT;
	}

	public void setIVLOWLIMIT(float iVLOWLIMIT) {
		IVLOWLIMIT = iVLOWLIMIT;
	}

	public float getOVUPLIMIT() {
		return OVUPLIMIT;
	}

	public void setOVUPLIMIT(float oVUPLIMIT) {
		OVUPLIMIT = oVUPLIMIT;
	}

	public float getOVLOWLIMIT() {
		return OVLOWLIMIT;
	}

	public void setOVLOWLIMIT(float oVLOWLIMIT) {
		OVLOWLIMIT = oVLOWLIMIT;
	}

	public float getICUPLIMIT() {
		return ICUPLIMIT;
	}

	public void setICUPLIMIT(float iCUPLIMIT) {
		ICUPLIMIT = iCUPLIMIT;
	}

	public float getICLOWLIMIT() {
		return ICLOWLIMIT;
	}

	public void setICLOWLIMIT(float iCLOWLIMIT) {
		ICLOWLIMIT = iCLOWLIMIT;
	}

	public float getOCUPLIMIT() {
		return OCUPLIMIT;
	}

	public void setOCUPLIMIT(float oCUPLIMIT) {
		OCUPLIMIT = oCUPLIMIT;
	}

	public float getOCLOWLIMIT() {
		return OCLOWLIMIT;
	}

	public void setOCLOWLIMIT(float oCLOWLIMIT) {
		OCLOWLIMIT = oCLOWLIMIT;
	}

	public float getTEMPUPLIMIT() {
		return TEMPUPLIMIT;
	}

	public void setTEMPUPLIMIT(float tEMPUPLIMIT) {
		TEMPUPLIMIT = tEMPUPLIMIT;
	}

}

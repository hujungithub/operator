package cn.com.start.webBack.entity;

public class RateInfo {
	// 费率id
	private int RATEID;
	// 尖电价
	private float JPRICE;
	// 峰电价
	private float FPRICE;
	// 平电价
	private float PPRICE;
	// 谷电价
	private float GPRICE;
	// 尖电价开始
	private String JPSTARTTIME;
	// 尖电价结束
	private String JPENDTIME;
	// 峰电价开始
	private String FPSTARTTIME;
	// 峰电价结束
	private String FPENDTIME;
	// 平电价开始
	private String PPSTARTTIME;
	// 平电价结束
	private String PPENDTIME;
	// 谷电价开始
	private String GPSTARTTIME;
	// 谷电价结束
	private String GPENDTIME;

	public int getRATEID() {
		return RATEID;
	}

	public void setRATEID(int rATEID) {
		RATEID = rATEID;
	}

	public float getJPRICE() {
		return JPRICE;
	}

	public void setJPRICE(float jPRICE) {
		JPRICE = jPRICE;
	}

	public float getFPRICE() {
		return FPRICE;
	}

	public void setFPRICE(float fPRICE) {
		FPRICE = fPRICE;
	}

	public float getPPRICE() {
		return PPRICE;
	}

	public void setPPRICE(float pPRICE) {
		PPRICE = pPRICE;
	}

	public float getGPRICE() {
		return GPRICE;
	}

	public void setGPRICE(float gPRICE) {
		GPRICE = gPRICE;
	}

	public String getJPSTARTTIME() {
		return JPSTARTTIME;
	}

	public void setJPSTARTTIME(String jPSTARTTIME) {
		JPSTARTTIME = jPSTARTTIME;
	}

	public String getJPENDTIME() {
		return JPENDTIME;
	}

	public void setJPENDTIME(String jPENDTIME) {
		JPENDTIME = jPENDTIME;
	}

	public String getFPSTARTTIME() {
		return FPSTARTTIME;
	}

	public void setFPSTARTTIME(String fPSTARTTIME) {
		FPSTARTTIME = fPSTARTTIME;
	}

	public String getFPENDTIME() {
		return FPENDTIME;
	}

	public void setFPENDTIME(String fPENDTIME) {
		FPENDTIME = fPENDTIME;
	}

	public String getPPSTARTTIME() {
		return PPSTARTTIME;
	}

	public void setPPSTARTTIME(String pPSTARTTIME) {
		PPSTARTTIME = pPSTARTTIME;
	}

	public String getPPENDTIME() {
		return PPENDTIME;
	}

	public void setPPENDTIME(String pPENDTIME) {
		PPENDTIME = pPENDTIME;
	}

	public String getGPSTARTTIME() {
		return GPSTARTTIME;
	}

	public void setGPSTARTTIME(String gPSTARTTIME) {
		GPSTARTTIME = gPSTARTTIME;
	}

	public String getGPENDTIME() {
		return GPENDTIME;
	}

	public void setGPENDTIME(String gPENDTIME) {
		GPENDTIME = gPENDTIME;
	}

	@Override
	public String toString() {
		return "RateInfo [RATEID=" + RATEID + ", JPRICE=" + JPRICE
				+ ", FPRICE=" + FPRICE + ", PPRICE=" + PPRICE + ", GPRICE="
				+ GPRICE + ", JPSTARTTIME=" + JPSTARTTIME + ", JPENDTIME="
				+ JPENDTIME + ", FPSTARTTIME=" + FPSTARTTIME + ", FPENDTIME="
				+ FPENDTIME + ", PPSTARTTIME=" + PPSTARTTIME + ", PPENDTIME="
				+ PPENDTIME + ", GPSTARTTIME=" + GPSTARTTIME + ", GPENDTIME="
				+ GPENDTIME + "]";
	}

}

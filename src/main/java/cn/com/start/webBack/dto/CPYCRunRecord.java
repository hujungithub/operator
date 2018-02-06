package cn.com.start.webBack.dto;

public class CPYCRunRecord {
	private String CPID;// 桩id
	private String RECORDTIME;// 记录时间
	private float UA1;// 1枪a相电压
	private float UA2;// 2枪a相电压
	private float UB1;// 1枪b相电压
	private float UB2;// 2枪b相电压
	private float UC1;// 1枪c相电压
	private float UC2;// 2枪c相电压
	private float IA1;// 1枪a相电流
	private float IA2;// 1枪a相电流
	private float IB1;// 1枪a相电流
	private float IB2;// 1枪a相电流
	private float IC1;// 1枪a相电流
	private float IC2;// 1枪a相电流
	private float GUNA_E;// 电量
	private float GUNB_E;// 电量
	private float GUNA_F;// 费用
	private float GUNB_F;// 费用
	private float GUNA_P;// 功率
	private float GUNB_P;// 功率
	private float GUNA_M;// 分钟
	private float GUNB_M;// 分钟
	private int GUNA_STATE;// 状态
	private int GUNB_STATE;// 状态
	private String CREDIBLE;// 可信

	@Override
	public String toString() {
		return "CPYCRunRecord [CPID=" + CPID + ", RECORDTIME=" + RECORDTIME
				+ ", UA1=" + UA1 + ", UA2=" + UA2 + ", UB1=" + UB1 + ", UB2="
				+ UB2 + ", UC1=" + UC1 + ", UC2=" + UC2 + ", IA1=" + IA1
				+ ", IA2=" + IA2 + ", IB1=" + IB1 + ", IB2=" + IB2 + ", IC1="
				+ IC1 + ", IC2=" + IC2 + ", GUNA_E=" + GUNA_E + ", GUNB_E="
				+ GUNB_E + ", GUNA_F=" + GUNA_F + ", GUNB_F=" + GUNB_F
				+ ", GUNA_P=" + GUNA_P + ", GUNB_P=" + GUNB_P + ", GUNA_M="
				+ GUNA_M + ", GUNB_M=" + GUNB_M + ", GUNA_STATE=" + GUNA_STATE
				+ ", GUNB_STATE=" + GUNB_STATE + ", CREDIBLE=" + CREDIBLE + "]";
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public float getUA1() {
		return UA1;
	}

	public void setUA1(float uA1) {
		UA1 = uA1;
	}

	public float getUA2() {
		return UA2;
	}

	public void setUA2(float uA2) {
		UA2 = uA2;
	}

	public float getUB1() {
		return UB1;
	}

	public void setUB1(float uB1) {
		UB1 = uB1;
	}

	public float getUB2() {
		return UB2;
	}

	public void setUB2(float uB2) {
		UB2 = uB2;
	}

	public float getUC1() {
		return UC1;
	}

	public void setUC1(float uC1) {
		UC1 = uC1;
	}

	public float getUC2() {
		return UC2;
	}

	public void setUC2(float uC2) {
		UC2 = uC2;
	}

	public float getIA1() {
		return IA1;
	}

	public void setIA1(float iA1) {
		IA1 = iA1;
	}

	public float getIA2() {
		return IA2;
	}

	public void setIA2(float iA2) {
		IA2 = iA2;
	}

	public float getIB1() {
		return IB1;
	}

	public void setIB1(float iB1) {
		IB1 = iB1;
	}

	public float getIB2() {
		return IB2;
	}

	public void setIB2(float iB2) {
		IB2 = iB2;
	}

	public float getIC1() {
		return IC1;
	}

	public void setIC1(float iC1) {
		IC1 = iC1;
	}

	public float getIC2() {
		return IC2;
	}

	public void setIC2(float iC2) {
		IC2 = iC2;
	}

	public float getGUNA_E() {
		return GUNA_E;
	}

	public void setGUNA_E(float gUNA_E) {
		GUNA_E = gUNA_E;
	}

	public float getGUNB_E() {
		return GUNB_E;
	}

	public void setGUNB_E(float gUNB_E) {
		GUNB_E = gUNB_E;
	}

	public float getGUNA_F() {
		return GUNA_F;
	}

	public void setGUNA_F(float gUNA_F) {
		GUNA_F = gUNA_F;
	}

	public float getGUNB_F() {
		return GUNB_F;
	}

	public void setGUNB_F(float gUNB_F) {
		GUNB_F = gUNB_F;
	}

	public float getGUNA_P() {
		return GUNA_P;
	}

	public void setGUNA_P(float gUNA_P) {
		GUNA_P = gUNA_P;
	}

	public float getGUNB_P() {
		return GUNB_P;
	}

	public void setGUNB_P(float gUNB_P) {
		GUNB_P = gUNB_P;
	}

	public float getGUNA_M() {
		return GUNA_M;
	}

	public void setGUNA_M(float gUNA_M) {
		GUNA_M = gUNA_M;
	}

	public float getGUNB_M() {
		return GUNB_M;
	}

	public void setGUNB_M(float gUNB_M) {
		GUNB_M = gUNB_M;
	}

	public int getGUNA_STATE() {
		return GUNA_STATE;
	}

	public void setGUNA_STATE(int gUNA_STATE) {
		GUNA_STATE = gUNA_STATE;
	}

	public int getGUNB_STATE() {
		return GUNB_STATE;
	}

	public void setGUNB_STATE(int gUNB_STATE) {
		GUNB_STATE = gUNB_STATE;
	}

	public String getCREDIBLE() {
		return CREDIBLE;
	}

	public void setCREDIBLE(String cREDIBLE) {
		CREDIBLE = cREDIBLE;
	}

}

package cn.com.start.webBack.entity;

public class AbnormalReports {

	private int ID;// id
	private String CPID;// 桩id
	private String RECORDTIME;// 记录时间
	private float GUNA_E;// 电量
	private float GUNA_F;// 费用
	private float GUNA_M;// 分钟
	private int GUNA_STATE;// 状态
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public float getGUNA_E() {
		return GUNA_E;
	}
	public void setGUNA_E(float gUNA_E) {
		GUNA_E = gUNA_E;
	}
	public float getGUNA_F() {
		return GUNA_F;
	}
	public void setGUNA_F(float gUNA_F) {
		GUNA_F = gUNA_F;
	}
	public float getGUNA_M() {
		return GUNA_M;
	}
	public void setGUNA_M(float gUNA_M) {
		GUNA_M = gUNA_M;
	}
	public int getGUNA_STATE() {
		return GUNA_STATE;
	}
	public void setGUNA_STATE(int gUNA_STATE) {
		GUNA_STATE = gUNA_STATE;
	}
	@Override
	public String toString() {
		return "AbnormalReports [ID=" + ID + ", CPID=" + CPID + ", RECORDTIME="
				+ RECORDTIME + ", GUNA_E=" + GUNA_E + ", GUNA_F=" + GUNA_F
				+ ", GUNA_M=" + GUNA_M + ", GUNA_STATE=" + GUNA_STATE + "]";
	}
	
}

package cn.com.start.webBack.entity;

public class SysRole {
	// 用户ID 主键
	private String ID;
	// 角色名称
	private String NAME;
	// 角色描述
	private String DESP;
	// 用户ID
	private String USERID;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDESP() {
		return DESP;
	}
	public void setDESP(String dESP) {
		DESP = dESP;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	@Override
	public String toString() {
		return "SysRole [ID=" + ID + ", NAME=" + NAME + ", DESP=" + DESP
				+ ", USERID=" + USERID + "]";
	}
	
	
	
}

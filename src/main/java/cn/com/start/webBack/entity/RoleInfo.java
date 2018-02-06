package cn.com.start.webBack.entity;

public class RoleInfo {
	// 角色id
	private int ROLEID;
	// 角色名
	private String ROLENAME;
	// 描述
	private String DESP;

	@Override
	public String toString() {
		return "RoleInfo [ROLEID=" + ROLEID + ", ROLENAME=" + ROLENAME
				+ ", DESP=" + DESP + "]";
	}

	public int getROLEID() {
		return ROLEID;
	}

	public void setROLEID(int rOLEID) {
		ROLEID = rOLEID;
	}

	public String getROLENAME() {
		return ROLENAME;
	}

	public void setROLENAME(String rOLENAME) {
		ROLENAME = rOLENAME;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

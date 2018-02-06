package cn.com.start.webBack.entity;

public class RolePermission {
	// 角色ID 
	private String ROLEID;
	// 权限
	private String PERMISSIONID;
	public String getROLEID() {
		return ROLEID;
	}
	public void setROLEID(String rOLEID) {
		ROLEID = rOLEID;
	}
	
	public String getPERMISSIONID() {
		return PERMISSIONID;
	}
	public void setPERMISSIONID(String pERMISSIONID) {
		PERMISSIONID = pERMISSIONID;
	}
	@Override
	public String toString() {
		return "RolePermission [ROLEID=" + ROLEID + ", PERMISSIONID="
				+ PERMISSIONID + "]";
	}
	
	
	
	
	
}

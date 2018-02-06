package cn.com.start.webBack.entity;

//
public class RoleactionInfo {

	//角色id
	private int ROLEID;
	// 角色动作
	private String ROLEACTION;
	public int getROLEID() {
		return ROLEID;
	}
	public void setROLEID(int rOLEID) {
		ROLEID = rOLEID;
	}
	public String getROLEACTION() {
		return ROLEACTION;
	}
	public void setROLEACTION(String rOLEACTION) {
		ROLEACTION = rOLEACTION;
	}
	@Override
	public String toString() {
		return "RoleactionInfo [ROLEID=" + ROLEID + ", ROLEACTION="
				+ ROLEACTION + "]";
	}


}

package cn.com.start.webBack.dto;

public class UserInfoDto {
	// 用户ID 主键
	private int USERID;
	// 用户名
	private String USERNAME;
	// 登录账号
	private String LOGINID;
	// 登录密码
	private String LOGINPWD;
	// 最近登录时间
	private String LOGINTIME;
	// 是否可用
	private boolean VALIDFLAG;
	// 角色名
	private String ROLENAME;
	// 角色ID
	private int ROLEID;
	//运营商id
	private int OPERATORID;
	
	private String OPERATORNAME;
	
	

	@Override
	public String toString() {
		return "UserInfoDto [USERID=" + USERID + ", USERNAME=" + USERNAME
				+ ", LOGINID=" + LOGINID + ", LOGINPWD=" + LOGINPWD
				+ ", LOGINTIME=" + LOGINTIME + ", VALIDFLAG=" + VALIDFLAG
				+ ", ROLENAME=" + ROLENAME + ", ROLEID=" + ROLEID
				+ ", OPERATORID=" + OPERATORID + ", OPERATORNAME="
				+ OPERATORNAME + "]";
	}

	
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}


	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}


	public int getOPERATORID() {
		return OPERATORID;
	}


	public void setOPERATORID(int oPERATORID) {
		OPERATORID = oPERATORID;
	}


	public int getROLEID() {
		return ROLEID;
	}


	public void setROLEID(int rOLEID) {
		ROLEID = rOLEID;
	}


	public int getUSERID() {
		return USERID;
	}

	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getLOGINID() {
		return LOGINID;
	}

	public void setLOGINID(String lOGINID) {
		LOGINID = lOGINID;
	}

	public String getLOGINPWD() {
		return LOGINPWD;
	}

	public void setLOGINPWD(String lOGINPWD) {
		LOGINPWD = lOGINPWD;
	}

	public String getLOGINTIME() {
		return LOGINTIME;
	}

	public void setLOGINTIME(String lOGINTIME) {
		LOGINTIME = lOGINTIME;
	}

	public boolean isVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(boolean vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getROLENAME() {
		return ROLENAME;
	}

	public void setROLENAME(String rOLENAME) {
		ROLENAME = rOLENAME;
	}

}

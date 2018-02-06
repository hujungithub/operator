package cn.com.start.webBack.entity;

public class SysUser {
	// 用户ID 主键
	private String ID;
	// 用户名
	private String USERNAME;
	// 登录账号
	private String USERCODE;
	// 登录密码
	private String PASSWORD;
	//辅助字符串
	private String SALT;
	// 是否可用
	private String LOCKED;
	// 最近登录时间
	private String LOGINTIME;
	// 运营商id
	private String OPERATORID;
	//运营商名称
	private String OPERATORNAME;
	//权限名称
	private String NAME;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getUSERCODE() {
		return USERCODE;
	}
	public void setUSERCODE(String uSERCODE) {
		USERCODE = uSERCODE;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getSALT() {
		return SALT;
	}
	public void setSALT(String sALT) {
		SALT = sALT;
	}
	public String getLOCKED() {
		return LOCKED;
	}
	public void setLOCKED(String lOCKED) {
		LOCKED = lOCKED;
	}
	public String getLOGINTIME() {
		return LOGINTIME;
	}
	public void setLOGINTIME(String lOGINTIME) {
		LOGINTIME = lOGINTIME;
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@Override
	public String toString() {
		return "SysUser [ID=" + ID + ", USERNAME=" + USERNAME + ", USERCODE="
				+ USERCODE + ", PASSWORD=" + PASSWORD + ", SALT=" + SALT
				+ ", LOCKED=" + LOCKED + ", LOGINTIME=" + LOGINTIME
				+ ", OPERATORID=" + OPERATORID + ", OPERATORNAME="
				+ OPERATORNAME + ", NAME=" + NAME + "]";
	}
	
	
	
	
}

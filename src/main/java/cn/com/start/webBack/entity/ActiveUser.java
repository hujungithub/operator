package cn.com.start.webBack.entity;

import java.util.List;

/**
 * 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 * 
 * @author Thinkpad
 * 
 */
public class ActiveUser implements java.io.Serializable {
	private String USERID;//用户id（主键）
	private String USERCODE;// 用户账号
	private String USERNAME;// 用户名称
	private String PASSWORD;// 用户名称
	private String OPERATORID;// 用户名称
	private String LOGINTIME;//最近一次登录时间
	private List<SysPermission> MENUS;// 菜单
	private List<SysPermission> PERMISSIONS;// 权限
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getUSERCODE() {
		return USERCODE;
	}
	public void setUSERCODE(String uSERCODE) {
		USERCODE = uSERCODE;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getLOGINTIME() {
		return LOGINTIME;
	}
	public void setLOGINTIME(String lOGINTIME) {
		LOGINTIME = lOGINTIME;
	}
	public List<SysPermission> getMENUS() {
		return MENUS;
	}
	public void setMENUS(List<SysPermission> mENUS) {
		MENUS = mENUS;
	}
	public List<SysPermission> getPERMISSIONS() {
		return PERMISSIONS;
	}
	public void setPERMISSIONS(List<SysPermission> pERMISSIONS) {
		PERMISSIONS = pERMISSIONS;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	

	
}

package cn.com.start.webBack.entity;

public class UserInfo {

	// 用户ID 主键
	private int userId;
	// 用户名
	private String userName;
	// 登录账号
	private String loginId;
	// 登录密码
	private String loginPwd;
	// 最近登录时间
	private String loginTime;
	// 是否可用
	private boolean validFlag;
	// 角色ID
	private int roleId;
	// 运营商id
	private String operatorId;
	//辅助字符串
	private String salt;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public boolean isValidFlag() {
		return validFlag;
	}
	public void setValidFlag(boolean validFlag) {
		this.validFlag = validFlag;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", loginId=" + loginId + ", loginPwd=" + loginPwd
				+ ", loginTime=" + loginTime + ", validFlag=" + validFlag
				+ ", roleId=" + roleId + ", operatorId=" + operatorId
				+ ", salt=" + salt + "]";
	}
	

	
}

package cn.com.start.AppAPI.dto;

public class RegisterUserDto {
	public String CPUSERID;
	public String PHONE;
	public String PASSWORD;
	public String REGTIME;
	public int VALIDFLAG;
	public String CPUSERNAME;
	
	
	public String getCpUserid() {
		return CPUSERID;
	}
	public void setCpUserid(String cpUserid) {
		this.CPUSERID = cpUserid;
	}
	public String getPhone() {
		return PHONE;
	}
	public void setPhone(String phone) {
		this.PHONE = phone;
	}
	public String getPassword() {
		return PASSWORD;
	}
	public void setPassword(String password) {
		this.PASSWORD = password;
	}
	public String getRegTime() {
		return REGTIME;
	}
	public void setRegTime(String regTime) {
		this.REGTIME = regTime;
	}
	public int getValidFlag() {
		return VALIDFLAG;
	}
	public void setValidFlag(int validFlag) {
		this.VALIDFLAG = validFlag;
	}
	public String getCpUsername() {
		return CPUSERNAME;
	}
	public void setCpUsername(String cpUsername) {
		this.CPUSERNAME = cpUsername;
	}
	
	

	
}

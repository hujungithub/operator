package cn.com.start.AppAPI.dto;

public class CpuserInfoDto {
	public String cpUserId;
	public String headImgUrl;
	public String cpUserName;
	public String sex;
	public String telephone;
	public String accountSum;
	public String plateNumber;
	public String vin;
	public String chargeState;
	
	
	@Override
	public String toString() {
		return "CpuserInfoDto [cpUserId=" + cpUserId + ", headImgUrl="
				+ headImgUrl + ", cpUserName=" + cpUserName + ", sex=" + sex
				+ ", telephone=" + telephone + ", accountSum=" + accountSum
				+ ", plateNumber=" + plateNumber + ", vin=" + vin
				+ ", chargeState=" + chargeState + "]";
	}
	public String getCpUserId() {
		return cpUserId;
	}
	public void setCpUserId(String cpUserId) {
		this.cpUserId = cpUserId;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getCpUserName() {
		return cpUserName;
	}
	public void setCpUserName(String cpUserName) {
		this.cpUserName = cpUserName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAccountSum() {
		return accountSum;
	}
	public void setAccountSum(String accountSum) {
		this.accountSum = accountSum;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getChargeState() {
		return chargeState;
	}
	public void setChargeState(String chargeState) {
		this.chargeState = chargeState;
	}
	
}

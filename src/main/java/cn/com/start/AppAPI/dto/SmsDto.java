package cn.com.start.AppAPI.dto;

public class SmsDto {
	public String totalFee;
	public String telephone;
	public String chargeStartTime;
	public String accountSum;
	
	
	public String getAccountSum() {
		return accountSum;
	}
	public void setAccountSum(String accountSum) {
		this.accountSum = accountSum;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getChargeStartTime() {
		return chargeStartTime;
	}
	public void setChargeStartTime(String chargeStartTime) {
		this.chargeStartTime = chargeStartTime;
	}
	
	
}

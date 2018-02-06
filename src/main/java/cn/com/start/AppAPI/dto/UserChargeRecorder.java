package cn.com.start.AppAPI.dto;

public class UserChargeRecorder {
	public String cpName;
	public String cpId;
	public String chargeTimeSpan;
	public String chargeStartTime;
	public String chargeMoney;
	public String transationId;
	public String chargeQuantity;
	public String serviceTip;
	public String totalFee;
	
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getChargeTimeSpan() {
		return chargeTimeSpan;
	}
	public void setChargeTimeSpan(String chargeTimeSpan) {
		this.chargeTimeSpan = chargeTimeSpan;
	}
	public String getChargeStartTime() {
		return chargeStartTime;
	}
	public void setChargeStartTime(String chargeStartTime) {
		this.chargeStartTime = chargeStartTime;
	}
	public String getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public String getTransationId() {
		return transationId;
	}
	public void setTransationId(String transationId) {
		this.transationId = transationId;
	}
	public String getServiceTip() {
		return serviceTip;
	}
	public void setServiceTip(String serviceTip) {
		this.serviceTip = serviceTip;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getChargeQuantity() {
		return chargeQuantity;
	}
	public void setChargeQuantity(String chargeQuantity) {
		this.chargeQuantity = chargeQuantity;
	}
	
}

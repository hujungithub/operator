package cn.com.start.AppAPI.dto;

public class ChargeRecorder {
	public String cpId;
	public String chargeStartTime;
	public String chargeTimeSpan;
	public String chargeQuantity;
	public String chargeMoney;
	public String TransationId;
    public String serviceTip;
    public String totalFee;

	@Override
	public String toString() {
		return "ChargeRecorder{" +
				"cpId='" + cpId + '\'' +
				", chargeStartTime='" + chargeStartTime + '\'' +
				", chargeTimeSpan='" + chargeTimeSpan + '\'' +
				", chargeQuantity='" + chargeQuantity + '\'' +
				", chargeMoney='" + chargeMoney + '\'' +
				", TransationId='" + TransationId + '\'' +
				", serviceTip='" + serviceTip + '\'' +
				", totalFee='" + totalFee + '\'' +
				'}';
	}

	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	public String getChargeStartTime() {
		return chargeStartTime;
	}
	public void setChargeStartTime(String chargeStartTime) {
		this.chargeStartTime = chargeStartTime;
	}

	public String getChargeQuantity() {
		return chargeQuantity;
	}
	public void setChargeQuantity(String chargeQuantity) {
		this.chargeQuantity = chargeQuantity;
	}
	public String getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public String getChargeTimeSpan() {
		return chargeTimeSpan;
	}
	public void setChargeTimeSpan(String chargeTimeSpan) {
		this.chargeTimeSpan = chargeTimeSpan;
	}
	public String getTransationId() {
		return TransationId;
	}
	public void setTransationId(String transationId) {
		TransationId = transationId;
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
	
	
}

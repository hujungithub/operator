package cn.com.start.AppAPI.dto;

public class WechatResultDto {
	public String cpUserId;
	public String rechargeMoney;
	public String rechargeTime;
	public String transactionNum;
	public String merchantNum;
	public String paymentModeId;
	public String payResultFlag;
	public String failDesp;
	public String preAccountSum;
	
	
	public String getCpUserId() {
		return cpUserId;
	}

	public void setCpUserId(String cpUserId) {
		this.cpUserId = cpUserId;
	}

	public String getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(String rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public String getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(String rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	public String getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(String transactionNum) {
		this.transactionNum = transactionNum;
	}

	public String getMerchantNum() {
		return merchantNum;
	}

	public void setMerchantNum(String merchantNum) {
		this.merchantNum = merchantNum;
	}

	public String getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(String paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public String getPayResultFlag() {
		return payResultFlag;
	}

	public void setPayResultFlag(String payResultFlag) {
		this.payResultFlag = payResultFlag;
	}

	public String getFailDesp() {
		return failDesp;
	}

	public void setFailDesp(String failDesp) {
		this.failDesp = failDesp;
	}

	public String getPreAccountSum() {
		return preAccountSum;
	}

	public void setPreAccountSum(String preAccountSum) {
		this.preAccountSum = preAccountSum;
	}

}

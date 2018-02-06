package cn.com.start.DPF.dto;

public class ChargeOver_DPF {
	private String deviceId;// 设备id
	private int gun;// 枪
	private String serialNo;// 流水号
	private String status;// 状态
	private String cpuserid;// app用户id
	private String cardNum;// 卡号
	private int chargemethod; // 充电方式 0app 1刷卡

	@Override
	public String toString() {
		return "ChargeOver_DPF [deviceId=" + deviceId + ", gun=" + gun
				+ ", serialNo=" + serialNo + ", status=" + status
				+ ", cpuserid=" + cpuserid + ", cardNum=" + cardNum
				+ ", chargemethod=" + chargemethod + "]";
	}

	public String getCpuserid() {
		return cpuserid;
	}

	public void setCpuserid(String cpuserid) {
		this.cpuserid = cpuserid;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public int getChargemethod() {
		return chargemethod;
	}

	public void setChargemethod(int chargemethod) {
		this.chargemethod = chargemethod;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getGun() {
		return gun;
	}

	public void setGun(int gun) {
		this.gun = gun;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

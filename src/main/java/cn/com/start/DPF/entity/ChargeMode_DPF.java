package cn.com.start.DPF.entity;

public class ChargeMode_DPF {
	private int CHARGEMODEID; // 充电模式ID
	private String CHARGEMODENAME; // 充电模式名称 按电量时间自动刷卡
	private String DESP;// 描述

	@Override
	public String toString() {
		return "ChargeModel [CHARGEMODELID=" + CHARGEMODEID
				+ ", CHARGEMODELNAME=" + CHARGEMODENAME + ", DESP=" + DESP
				+ "]";
	}

	public int getCHARGEMODELID() {
		return CHARGEMODEID;
	}

	public void setCHARGEMODELID(int cHARGEMODELID) {
		CHARGEMODEID = cHARGEMODELID;
	}

	public String getCHARGEMODELNAME() {
		return CHARGEMODENAME;
	}

	public void setCHARGEMODELNAME(String cHARGEMODELNAME) {
		CHARGEMODENAME = cHARGEMODELNAME;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

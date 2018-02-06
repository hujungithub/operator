package cn.com.start.DPF.entity;

public class ChargeMethod {
	private int CHARGEMETHODID; // 充电方法id
	private String CHARGEMETHODNAME;// 充电方法name

	@Override
	public String toString() {
		return "ChargeMethod [CHARGEMETHODID=" + CHARGEMETHODID
				+ ", CHARGEMETHODNAME=" + CHARGEMETHODNAME + "]";
	}

	public int getCHARGEMETHODID() {
		return CHARGEMETHODID;
	}

	public void setCHARGEMETHODID(int cHARGEMETHODID) {
		CHARGEMETHODID = cHARGEMETHODID;
	}

	public String getCHARGEMETHODNAME() {
		return CHARGEMETHODNAME;
	}

	public void setCHARGEMETHODNAME(String cHARGEMETHODNAME) {
		CHARGEMETHODNAME = cHARGEMETHODNAME;
	}

}

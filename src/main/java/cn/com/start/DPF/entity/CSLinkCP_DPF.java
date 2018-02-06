package cn.com.start.DPF.entity;

public class CSLinkCP_DPF {
	private String CSID;// cpmid
	private String CPID;// 桩id

	@Override
	public String toString() {
		return "CSLinkCP_DPF [CSID=" + CSID + ", CPID=" + CPID + "]";
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

}

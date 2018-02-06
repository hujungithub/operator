package cn.com.start.DPF.entity;

public class CPMLinkCP_DPF {

	private int SN;// 索引
	private String CPMID;// cpmid
	private String CPID;// 桩id

	@Override
	public String toString() {
		return "CPMLinkCP_DPF [SN=" + SN + ", CPMID=" + CPMID + ", CPID="
				+ CPID + "]";
	}

	public int getSN() {
		return SN;
	}

	public void setSN(int sN) {
		SN = sN;
	}

	public String getCPMID() {
		return CPMID;
	}

	public void setCPMID(String cPMID) {
		CPMID = cPMID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

}

package cn.com.start.DPF.entity;

public class AuthorityFailCause_DPF {

	// 鉴权失败原因
	private int CAUSEID;
	private String CAUSENAME;
	private String DESP;

	@Override
	public String toString() {
		return "AuthorityFailCause_DPF [CAUSEID=" + CAUSEID + ", CAUSENAME="
				+ CAUSENAME + ", DESP=" + DESP + "]";
	}

	public int getCAUSEID() {
		return CAUSEID;
	}

	public void setCAUSEID(int cAUSEID) {
		CAUSEID = cAUSEID;
	}

	public String getCAUSENAME() {
		return CAUSENAME;
	}

	public void setCAUSENAME(String cAUSENAME) {
		CAUSENAME = cAUSENAME;
	}

	public String getDESP() {
		return DESP;
	}

	public void setDESP(String dESP) {
		DESP = dESP;
	}

}

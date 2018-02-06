package cn.com.start.webBack.dto;

public class FindCarInfoDto extends BaseFindDto{

	 private String APPOINTID;
	 private String CARPLATE;
	 private String CARSTATE;
	 private String CARMODEL;
	public String getAPPOINTID() {
		return APPOINTID;
	}
	public void setAPPOINTID(String aPPOINTID) {
		APPOINTID = aPPOINTID;
	}
	public String getCARPLATE() {
		return CARPLATE;
	}
	public void setCARPLATE(String cARPLATE) {
		CARPLATE = cARPLATE;
	}
	public String getCARSTATE() {
		return CARSTATE;
	}
	public void setCARSTATE(String cARSTATE) {
		CARSTATE = cARSTATE;
	}
	public String getCARMODEL() {
		return CARMODEL;
	}
	public void setCARMODEL(String cARMODEL) {
		CARMODEL = cARMODEL;
	}
	@Override
	public String toString() {
		return "FindCarInfoDto [APPOINTID=" + APPOINTID + ", CARPLATE="
				+ CARPLATE + ", CARSTATE=" + CARSTATE + ", CARMODEL="
				+ CARMODEL + "]";
	} 
}
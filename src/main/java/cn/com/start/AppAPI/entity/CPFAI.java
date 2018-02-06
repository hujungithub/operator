package cn.com.start.AppAPI.entity;

public class CPFAI {

	private String CPID; // 桩id
	private String FAULTTYPE; // 故障类型
	private String ALARMTIME; // 报警时间
	private String CSNM; // 站名
	private String LOCATION; // 地址
	private String CPTYPE; // 桩类型
	private String LONGITUDE; // 经度
	private String LATITUDE; // 纬度
	private String ID; // 订单id
	private String AUDITSTATE; // 审核状态

	@Override
	public String toString() {
		return "CPFAI [CPID=" + CPID + ", FAULTTYPE=" + FAULTTYPE
				+ ", ALARMTIME=" + ALARMTIME + ", CSNM=" + CSNM + ", LOCATION="
				+ LOCATION + ", CPTYPE=" + CPTYPE + ", LONGITUDE=" + LONGITUDE
				+ ", LATITUDE=" + LATITUDE + ", ID=" + ID + ", AUDITSTATE="
				+ AUDITSTATE + "]";
	}

	public String getAUDITSTATE() {
		return AUDITSTATE;
	}

	public void setAUDITSTATE(String aUDITSTATE) {
		AUDITSTATE = aUDITSTATE;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getFAULTTYPE() {
		return FAULTTYPE;
	}

	public void setFAULTTYPE(String fAULTTYPE) {
		FAULTTYPE = fAULTTYPE;
	}

	public String getALARMTIME() {
		return ALARMTIME;
	}

	public void setALARMTIME(String aLARMTIME) {
		ALARMTIME = aLARMTIME;
	}

	public String getCSNM() {
		return CSNM;
	}

	public void setCSNM(String cSNM) {
		CSNM = cSNM;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

}

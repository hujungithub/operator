package cn.com.start.webBack.dto;

public class FindAppointInfoDto extends BaseFindDto{

	private String CARID;// 车ID
	private String STARTTIME;// 开始时间
	private String RECORDTIME; // 结束时间、取车时间
	private String APPOINTSTATE;// 预约订单状态

	private String DESCRIPTION;// 预约订单描述
	private String CPUSERID; // 用户ID
	private String APPOINTPARAMETER; // 预约参数
	private String APPOINTTYPE;// 预约类型
	
	public String getCARID() {
		return CARID;
	}
	public void setCARID(String cARID) {
		CARID = cARID;
	}
	public String getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public String getRECORDTIME() {
		return RECORDTIME;
	}
	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}
	public String getAPPOINTSTATE() {
		return APPOINTSTATE;
	}
	public void setAPPOINTSTATE(String aPPOINTSTATE) {
		APPOINTSTATE = aPPOINTSTATE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public String getAPPOINTPARAMETER() {
		return APPOINTPARAMETER;
	}
	public void setAPPOINTPARAMETER(String aPPOINTPARAMETER) {
		APPOINTPARAMETER = aPPOINTPARAMETER;
	}
	public String getAPPOINTTYPE() {
		return APPOINTTYPE;
	}
	public void setAPPOINTTYPE(String aPPOINTTYPE) {
		APPOINTTYPE = aPPOINTTYPE;
	}
	@Override
	public String toString() {
		return "AppointInfoDto [CARID=" + CARID + ", STARTTIME=" + STARTTIME
				+ ", RECORDTIME=" + RECORDTIME + ", APPOINTSTATE="
				+ APPOINTSTATE + ", DESCRIPTION=" + DESCRIPTION + ", CPUSERID="
				+ CPUSERID + ", APPOINTPARAMETER=" + APPOINTPARAMETER
				+ ", APPOINTTYPE=" + APPOINTTYPE + "]";
	}
}
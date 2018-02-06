package cn.com.start.webBack.dto;

public class ChargeProgressDto {
	
	private String CPID;//桩ID
	
	private String CPUSERID;//用户ID
	
	private String CHARGESTARTTIME;//开始充电时间
	
	private String CHARGESTATUS;//发送状态
	
	private String STARTCHARGETIME;//启动充电枪回复时间
	
	private String STARTCHARGEREPLYSTATUS;//启动状态
	
	private String ENDCHARGETIME;//停止充电时间
	
	private String ENDCHARGESTATUS;//发送停止状态
	
	private String RECEIVEENDREPLYTIME;//收到停止回复时间
	
	private String ENDSTATUS;//停止状态
	
	private String RECEIVECHARGERECORDTIME;//收到充电记录时间
	
	private String RECEIVECHARGERECORDSTATUS;//收到充电记录状态
	
	private String DEDUCTIONTIME;//扣款时间

	private String DEDUCTIONSTATUS;//扣费状态
	
	public String getRECEIVECHARGERECORDSTATUS() {
		return RECEIVECHARGERECORDSTATUS;
	}
	
	public void setRECEIVECHARGERECORDSTATUS(String rECEIVECHARGERECORDSTATUS) {
		RECEIVECHARGERECORDSTATUS = rECEIVECHARGERECORDSTATUS;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public String getCHARGESTARTTIME() {
		return CHARGESTARTTIME;
	}

	public void setCHARGESTARTTIME(String cHARGESTARTTIME) {
		CHARGESTARTTIME = cHARGESTARTTIME;
	}

	public String getCHARGESTATUS() {
		return CHARGESTATUS;
	}

	public void setCHARGESTATUS(String cHARGESTATUS) {
		CHARGESTATUS = cHARGESTATUS;
	}

	public String getSTARTCHARGETIME() {
		return STARTCHARGETIME;
	}

	public void setSTARTCHARGETIME(String sTARTCHARGETIME) {
		STARTCHARGETIME = sTARTCHARGETIME;
	}

	public String getSTARTCHARGEREPLYSTATUS() {
		return STARTCHARGEREPLYSTATUS;
	}

	public void setSTARTCHARGEREPLYSTATUS(String sTARTCHARGEREPLYSTATUS) {
		STARTCHARGEREPLYSTATUS = sTARTCHARGEREPLYSTATUS;
	}

	public String getENDCHARGETIME() {
		return ENDCHARGETIME;
	}

	public void setENDCHARGETIME(String eNDCHARGETIME) {
		ENDCHARGETIME = eNDCHARGETIME;
	}

	public String getENDCHARGESTATUS() {
		return ENDCHARGESTATUS;
	}

	public void setENDCHARGESTATUS(String eNDCHARGESTATUS) {
		ENDCHARGESTATUS = eNDCHARGESTATUS;
	}

	public String getRECEIVEENDREPLYTIME() {
		return RECEIVEENDREPLYTIME;
	}

	public void setRECEIVEENDREPLYTIME(String rECEIVEENDREPLYTIME) {
		RECEIVEENDREPLYTIME = rECEIVEENDREPLYTIME;
	}

	public String getENDSTATUS() {
		return ENDSTATUS;
	}

	public void setENDSTATUS(String eNDSTATUS) {
		ENDSTATUS = eNDSTATUS;
	}

	public String getRECEIVECHARGERECORDTIME() {
		return RECEIVECHARGERECORDTIME;
	}

	public void setRECEIVECHARGERECORDTIME(String rECEIVECHARGERECORDTIME) {
		RECEIVECHARGERECORDTIME = rECEIVECHARGERECORDTIME;
	}

	public String getDEDUCTIONSTATUS() {
		return DEDUCTIONSTATUS;
	}

	public void setDEDUCTIONSTATUS(String dEDUCTIONSTATUS) {
		DEDUCTIONSTATUS = dEDUCTIONSTATUS;
	}

	public String getDEDUCTIONTIME() {
		return DEDUCTIONTIME;
	}

	public void setDEDUCTIONTIME(String dEDUCTIONTIME) {
		DEDUCTIONTIME = dEDUCTIONTIME;
	}

	@Override
	public String toString() {
		return "ChargeProgressDto [CPID=" + CPID + ", CPUSERID=" + CPUSERID + ", CHARGESTARTTIME=" + CHARGESTARTTIME
				+ ", CHARGESTATUS=" + CHARGESTATUS + ", STARTCHARGETIME=" + STARTCHARGETIME
				+ ", STARTCHARGEREPLYSTATUS=" + STARTCHARGEREPLYSTATUS + ", ENDCHARGETIME=" + ENDCHARGETIME
				+ ", ENDCHARGESTATUS=" + ENDCHARGESTATUS + ", RECEIVEENDREPLYTIME=" + RECEIVEENDREPLYTIME
				+ ", ENDSTATUS=" + ENDSTATUS + ", RECEIVECHARGERECORDTIME=" + RECEIVECHARGERECORDTIME
				+ ", RECEIVECHARGERECORDSTATUS=" + RECEIVECHARGERECORDSTATUS + ", DEDUCTIONTIME=" + DEDUCTIONTIME
				+ ", DEDUCTIONSTATUS=" + DEDUCTIONSTATUS + "]";
	}
	
}

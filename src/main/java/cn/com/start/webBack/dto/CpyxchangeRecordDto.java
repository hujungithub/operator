package cn.com.start.webBack.dto;

public class CpyxchangeRecordDto {
	
	private String ID;//遥信变位id
	private String CPID;//桩id
	private String YXPOINTID;//遥信点
	private String RECORDTIME;//记录时间
	private String OLDVALUE;//旧值
	private String OLDVALUEMEAN;//旧值含义
	private String OLDVALUERELIABILITY;//旧值可信度
	private String OLDVALUERECORDTIME;//旧值记录时间
	private String NEWVALUE;//新值
	private String NEWVALUEMEAN;//新值含义
	private String NEWVALUERELIABILITY;//新值可信度
	private String NEWVALUERECORDTIME;//新值记录时间
	private String CHECKSTATE;//确认状态
	private String CHECKMODE;//确认模式
	private String STATENAME;//确认状态名
	private String MODENAME;//确认模式名
	private String CPTYPE;
	
	
	public String getCPTYPE() {
		return CPTYPE;
	}
	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}
	public String getSTATENAME() {
		return STATENAME;
	}
	public void setSTATENAME(String sTATENAME) {
		STATENAME = sTATENAME;
	}
	public String getMODENAME() {
		return MODENAME;
	}
	public void setMODENAME(String mODENAME) {
		MODENAME = mODENAME;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getYXPOINTID() {
		return YXPOINTID;
	}
	public void setYXPOINTID(String yXPOINTID) {
		YXPOINTID = yXPOINTID;
	}
	public String getRECORDTIME() {
		return RECORDTIME;
	}
	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}
	public String getOLDVALUE() {
		return OLDVALUE;
	}
	public void setOLDVALUE(String oLDVALUE) {
		OLDVALUE = oLDVALUE;
	}
	public String getOLDVALUEMEAN() {
		return OLDVALUEMEAN;
	}
	public void setOLDVALUEMEAN(String oLDVALUEMEAN) {
		OLDVALUEMEAN = oLDVALUEMEAN;
	}
	public String getOLDVALUERELIABILITY() {
		return OLDVALUERELIABILITY;
	}
	public void setOLDVALUERELIABILITY(String oLDVALUERELIABILITY) {
		OLDVALUERELIABILITY = oLDVALUERELIABILITY;
	}
	public String getOLDVALUERECORDTIME() {
		return OLDVALUERECORDTIME;
	}
	public void setOLDVALUERECORDTIME(String oLDVALUERECORDTIME) {
		OLDVALUERECORDTIME = oLDVALUERECORDTIME;
	}
	public String getNEWVALUE() {
		return NEWVALUE;
	}
	public void setNEWVALUE(String nEWVALUE) {
		NEWVALUE = nEWVALUE;
	}
	public String getNEWVALUEMEAN() {
		return NEWVALUEMEAN;
	}
	public void setNEWVALUEMEAN(String nEWVALUEMEAN) {
		NEWVALUEMEAN = nEWVALUEMEAN;
	}
	public String getNEWVALUERELIABILITY() {
		return NEWVALUERELIABILITY;
	}
	public void setNEWVALUERELIABILITY(String nEWVALUERELIABILITY) {
		NEWVALUERELIABILITY = nEWVALUERELIABILITY;
	}
	public String getNEWVALUERECORDTIME() {
		return NEWVALUERECORDTIME;
	}
	public void setNEWVALUERECORDTIME(String nEWVALUERECORDTIME) {
		NEWVALUERECORDTIME = nEWVALUERECORDTIME;
	}
	public String getCHECKSTATE() {
		return CHECKSTATE;
	}
	public void setCHECKSTATE(String cHECKSTATE) {
		CHECKSTATE = cHECKSTATE;
	}
	public String getCHECKMODE() {
		return CHECKMODE;
	}
	public void setCHECKMODE(String cHECKMODE) {
		CHECKMODE = cHECKMODE;
	}
	@Override
	public String toString() {
		return "CpyxchangeRecordDto [ID=" + ID + ", CPID=" + CPID
				+ ", YXPOINTID=" + YXPOINTID + ", RECORDTIME=" + RECORDTIME
				+ ", OLDVALUE=" + OLDVALUE + ", OLDVALUEMEAN=" + OLDVALUEMEAN
				+ ", OLDVALUERELIABILITY=" + OLDVALUERELIABILITY
				+ ", OLDVALUERECORDTIME=" + OLDVALUERECORDTIME + ", NEWVALUE="
				+ NEWVALUE + ", NEWVALUEMEAN=" + NEWVALUEMEAN
				+ ", NEWVALUERELIABILITY=" + NEWVALUERELIABILITY
				+ ", NEWVALUERECORDTIME=" + NEWVALUERECORDTIME
				+ ", CHECKSTATE=" + CHECKSTATE + ", CHECKMODE=" + CHECKMODE
				+ ", STATENAME=" + STATENAME + ", MODENAME=" + MODENAME
				+ ", CPTYPE=" + CPTYPE + "]";
	}
	
		
}


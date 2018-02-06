package cn.com.start.webBack.entity;

public class YXChange {
	private String CPID; // 桩id
	private int YXPOINTID; // 遥信点
	private String RECORDTIME; // 记录时间
	private String OLDVALUE;// 旧值
	private String OLDVALUEMEAN;// 旧值名称
	private String OLDVALUEREALIBITITY;// 旧值可信度
	private String OLDVALUERECORDTIME;// 旧值记录时间
	private String NEWVALUE;// 新值
	private String NEWVALUEMEAN;// 新值名称
	private String NEWVALUERELIBITITY;// 新值可信度
	private String NEWVALUERECORDTIME;// 新值记录时间
	private int CHECKSTATE;// 确认状态 已未
	private int CHECKMODE;// 确认方式 手动 自动

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getYXPOINTID() {
		return YXPOINTID;
	}

	public void setYXPOINTID(int yXPOINTID) {
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

	public String getOLDVALUEREALIBITITY() {
		return OLDVALUEREALIBITITY;
	}

	public void setOLDVALUEREALIBITITY(String oLDVALUEREALIBITITY) {
		OLDVALUEREALIBITITY = oLDVALUEREALIBITITY;
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

	public String getNEWVALUERELIBITITY() {
		return NEWVALUERELIBITITY;
	}

	public void setNEWVALUERELIBITITY(String nEWVALUERELIBITITY) {
		NEWVALUERELIBITITY = nEWVALUERELIBITITY;
	}

	public String getNEWVALUERECORDTIME() {
		return NEWVALUERECORDTIME;
	}

	public void setNEWVALUERECORDTIME(String nEWVALUERECORDTIME) {
		NEWVALUERECORDTIME = nEWVALUERECORDTIME;
	}

	public int getCHECKSTATE() {
		return CHECKSTATE;
	}

	public void setCHECKSTATE(int cHECKSTATE) {
		CHECKSTATE = cHECKSTATE;
	}

	public int getCHECKMODE() {
		return CHECKMODE;
	}

	public void setCHECKMODE(int cHECKMODE) {
		CHECKMODE = cHECKMODE;
	}

}

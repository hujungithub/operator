package cn.com.start.webBack.dto;

public class FindARDto extends BaseFindDto {

	private int ID;
	private int CHECKSTATE;
	private int CHECKMODE;
	private String STATE;
	private String CPTYPE;
	private String STARTTIME;
	private String ENDTIME;

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public String getROLELOGINID() {
		return ROLELOGINID;
	}

	public void setROLELOGINID(String rOLELOGINID) {
		ROLELOGINID = rOLELOGINID;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getSTARTTIME() {
		return STARTTIME;
	}

	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}

	public String getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	@Override
	public String toString() {
		return "FindARDto [ID=" + ID + ", CHECKSTATE=" + CHECKSTATE
				+ ", CHECKMODE=" + CHECKMODE + ", STATE=" + STATE + ", CPTYPE="
				+ CPTYPE + ", STARTTIME=" + STARTTIME + ", ENDTIME=" + ENDTIME
				+ ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ ", startPos=" + startPos + ", OPERATORLOGINID="
				+ OPERATORLOGINID + ", ROLELOGINID=" + ROLELOGINID + "]";
	}

}

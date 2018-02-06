package cn.com.start.webBack.dto;

public class FindOperatorDto extends BaseFindDto {

	// 运营商名称
	private String OPERATORNAME;
	// 联系电话
	private String TELEPHONE;
	// 是否可用
	private String VALIDFLAG;

	private String OPERATORID;
	private String FROMDATE;// 开始日期
	private String TODATE; // 结束日期

	public String getFROMDATE() {
		return FROMDATE;
	}

	public void setFROMDATE(String fROMDATE) {
		FROMDATE = fROMDATE;
	}

	public String getTODATE() {
		return TODATE;
	}

	public void setTODATE(String tODATE) {
		TODATE = tODATE;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
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

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	@Override
	public String toString() {
		return "FindOperatorDto [OPERATORNAME=" + OPERATORNAME + ", TELEPHONE="
				+ TELEPHONE + ", VALIDFLAG=" + VALIDFLAG + ", pageSize="
				+ pageSize + ", pageNow=" + pageNow + ", startPos=" + startPos
				+ ", OPERATORLOGINID=" + OPERATORLOGINID + ", ROLELOGINID="
				+ ROLELOGINID + ", OPERATORID=" + OPERATORID + ", FROMDATE="
				+ FROMDATE + ", TODATE=" + TODATE + "]";
	}

}

package cn.com.start.webBack.dto;

public class FindCSDto extends BaseFindDto {
	// 充电站ID
	private String CSID;
	// 运营商ID
	private String OPERATORID;
	// 充电站名称
	private String CSNAME;
	// 开始日期
	private String FROMDATE;
	// 结束日期
	private String TODATE;

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

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}

	@Override
	public String toString() {
		return "FindCSDto [CSID=" + CSID + ", OPERATORID=" + OPERATORID
				+ ", CSNAME=" + CSNAME + ", FROMDATE=" + FROMDATE + ", TODATE="
				+ TODATE + ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ ", startPos=" + startPos + "]";
	}
}

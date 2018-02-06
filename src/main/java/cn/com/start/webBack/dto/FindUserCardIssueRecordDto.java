package cn.com.start.webBack.dto;

public class FindUserCardIssueRecordDto extends BaseFindDto {
	private String CARDNUM;
	private String OPERATORID;
	private String OPENCARDRESULT;
	private String OPERATORLOGINID;
	private String FROMDATE; // 开始日期
	private String TODATE; // 结束日期

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getOPENCARDRESULT() {
		return OPENCARDRESULT;
	}

	public void setOPENCARDRESULT(String oPENCARDRESULT) {
		OPENCARDRESULT = oPENCARDRESULT;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

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

	@Override
	public String toString() {
		return "FindUserCardIssueRecordDto [CARDNUM=" + CARDNUM
				+ ", OPERATORID=" + OPERATORID + ", OPENCARDRESULT="
				+ OPENCARDRESULT + ", OPERATORLOGINID=" + OPERATORLOGINID
				+ ", FROMDATE=" + FROMDATE + ", TODATE=" + TODATE
				+ ", startPos=" + startPos + ", pageSize=" + pageSize
				+ ", pageNow=" + pageNow + ", ROLELOGINID=" + ROLELOGINID + "]";
	}

}

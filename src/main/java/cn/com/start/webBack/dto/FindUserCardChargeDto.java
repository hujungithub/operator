package cn.com.start.webBack.dto;

public class FindUserCardChargeDto extends BaseFindDto {

	private String CARDNUM;
	private String FROMDATE;// 开始日期
	private String TODATE; // 结束日期

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
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
		return "FindUserCardChargeDto [CARDNUM=" + CARDNUM + ", FROMDATE="
				+ FROMDATE + ", TODATE=" + TODATE + ", startPos=" + startPos
				+ ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ ", OPERATORLOGINID=" + OPERATORLOGINID + ", ROLELOGINID="
				+ ROLELOGINID + "]";
	}

}

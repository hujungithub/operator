package cn.com.start.webBack.dto;

public class FindCardUserDto extends BaseFindDto {

	private String OPERATORID;
	private String CARDNUM;
	private String CARDUSERNAME;
	private String TELEPHONE;
	private String OPERATORNAME;

	private String FROMDATE; // 开始日期
	private String TODATE; // 结束日期
	private String OPERATORLOGINID;

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public String getCARDUSERNAME() {
		return CARDUSERNAME;
	}

	public void setCARDUSERNAME(String cARDUSERNAME) {
		CARDUSERNAME = cARDUSERNAME;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
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
		return "FindCardUserDto [OPERATORID=" + OPERATORID + ", CARDNUM=" + CARDNUM + ", CARDUSERNAME=" + CARDUSERNAME
				+ ", TELEPHONE=" + TELEPHONE + ", OPERATORNAME=" + OPERATORNAME + ", FROMDATE=" + FROMDATE + ", TODATE="
				+ TODATE + ", OPERATORLOGINID=" + OPERATORLOGINID + "]";
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

}

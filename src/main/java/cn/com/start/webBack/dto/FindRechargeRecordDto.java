package cn.com.start.webBack.dto;

public class FindRechargeRecordDto extends BaseFindDto {

	private String CARDNUM;
	private String RECHARGERESULT;
	private String OPERATORID;
	private String OPERATORNAME;

	@Override
	public String toString() {
		return "FindRechargeRecordDto [CARDNUM=" + CARDNUM + ", RECHARGERESULT=" + RECHARGERESULT + ", OPERATORID="
				+ OPERATORID + ", OPERATORNAME=" + OPERATORNAME + "]";
	}

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public String getRECHARGERESULT() {
		return RECHARGERESULT;
	}

	public void setRECHARGERESULT(String rECHARGERESULT) {
		RECHARGERESULT = rECHARGERESULT;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

}

package cn.com.start.webBack.dto;

public class FindIndexDto {

	private String OPERATORID; // 运营商id
	private String FROMDATE;// 开始日期
	private String TODATE; // 结束日期
	private int DAY; // 天数
	private Float CHARGEQUANTITY;// 充电电量
	private Float CHARGEMONEY;// 充电费用
	private int CHARGECOUNT;// 充电次数

	@Override
	public String toString() {
		return "FindIndexDto [OPERATORID=" + OPERATORID + ", FROMDATE="
				+ FROMDATE + ", TODATE=" + TODATE + ", DAY=" + DAY
				+ ", CHARGEQUANTITY=" + CHARGEQUANTITY + ", CHARGEMONEY="
				+ CHARGEMONEY + ", CHARGECOUNT=" + CHARGECOUNT + "]";
	}

	public int getDAY() {
		return DAY;
	}

	public void setDAY(int dAY) {
		DAY = dAY;
	}

	public Float getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}

	public void setCHARGEQUANTITY(Float cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}

	public Float getCHARGEMONEY() {
		return CHARGEMONEY;
	}

	public void setCHARGEMONEY(Float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}

	public int getCHARGECOUNT() {
		return CHARGECOUNT;
	}

	public void setCHARGECOUNT(int cHARGECOUNT) {
		CHARGECOUNT = cHARGECOUNT;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
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

}

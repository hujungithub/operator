package cn.com.start.DPF.entity.carddata;

public class CardShortMessage {
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	public String getMONEY() {
		return MONEY;
	}
	public void setMONEY(String mONEY) {
		MONEY = mONEY;
	}
	public String getACCOUNTSUM() {
		return ACCOUNTSUM;
	}
	public void setACCOUNTSUM(String aCCOUNTSUM) {
		ACCOUNTSUM = aCCOUNTSUM;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	@Override
	public String toString() {
		return "CardShortMessage [CARDNUM=" + CARDNUM + ", TIME=" + TIME
				+ ", MONEY=" + MONEY + ", ACCOUNTSUM=" + ACCOUNTSUM
				+ ", TELEPHONE=" + TELEPHONE + "]";
	}
	private String CARDNUM;		//卡号
	private String TIME;		//充值时间
	private String MONEY;		//充值金额
	private String ACCOUNTSUM;	//余额
	private String TELEPHONE;	//手机号

}

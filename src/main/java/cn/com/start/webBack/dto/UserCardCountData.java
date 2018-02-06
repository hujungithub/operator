package cn.com.start.webBack.dto;

public class UserCardCountData {
	public float getSERVICETIPCOUNT() {
		return SERVICETIPCOUNT;
	}
	public void setSERVICETIPCOUNT(float sERVICETIPCOUNT) {
		SERVICETIPCOUNT = sERVICETIPCOUNT;
	}
	public float getCHARGEMONEYCOUNT() {
		return CHARGEMONEYCOUNT;
	}
	public void setCHARGEMONEYCOUNT(float cHARGEMONEYCOUNT) {
		CHARGEMONEYCOUNT = cHARGEMONEYCOUNT;
	}
	public float getMONEYCOUNT() {
		return MONEYCOUNT;
	}
	public void setMONEYCOUNT(float mONEYCOUNT) {
		MONEYCOUNT = mONEYCOUNT;
	}
	public float getCHARGEQUANTITYCOUNT() {
		return CHARGEQUANTITYCOUNT;
	}
	public void setCHARGEQUANTITYCOUNT(float cHARGEQUANTITYCOUNT) {
		CHARGEQUANTITYCOUNT = cHARGEQUANTITYCOUNT;
	}
	public String getCARDCOUNT() {
		return CARDCOUNT;
	}
	public void setCARDCOUNT(String cARDCOUNT) {
		CARDCOUNT = cARDCOUNT;
	}
	@Override
	public String toString() {
		return "UserCardCountData [SERVICETIPCOUNT=" + SERVICETIPCOUNT
				+ ", CHARGEMONEYCOUNT=" + CHARGEMONEYCOUNT + ", MONEYCOUNT="
				+ MONEYCOUNT + ", CHARGEQUANTITYCOUNT=" + CHARGEQUANTITYCOUNT
				+ ", CARDCOUNT=" + CARDCOUNT + "]";
	}
	private float SERVICETIPCOUNT;
	private float CHARGEMONEYCOUNT;
	private float MONEYCOUNT;
	private float CHARGEQUANTITYCOUNT;
	private String CARDCOUNT;
}

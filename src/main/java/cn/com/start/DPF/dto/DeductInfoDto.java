package cn.com.start.DPF.dto;

public class DeductInfoDto {
	private String CPUSERID;
	private long CARDNUM;
	private Float MONEY;

	public long getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(long cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public Float getMONEY() {
		return MONEY;
	}

	public void setMONEY(Float mONEY) {
		MONEY = mONEY;
	}

}

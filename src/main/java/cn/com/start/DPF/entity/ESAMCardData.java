package cn.com.start.DPF.entity;

public class ESAMCardData {
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getINITKEY() {
		return INITKEY;
	}
	public void setINITKEY(String iNITKEY) {
		INITKEY = iNITKEY;
	}
	public String getCARDISSUETIME() {
		return CARDISSUETIME;
	}
	public void setCARDISSUETIME(String cARDISSUETIME) {
		CARDISSUETIME = cARDISSUETIME;
	}
	public String getSERIALPORT() {
		return SERIALPORT;
	}
	public void setSERIALPORT(String sERIALPORT) {
		SERIALPORT = sERIALPORT;
	}
	public String getBAUDRATE() {
		return BAUDRATE;
	}
	public void setBAUDRATE(String bAUDRATE) {
		BAUDRATE = bAUDRATE;
	}

	@Override
	public String toString() {
		return "ESAMCardData [CARDNUM=" + CARDNUM + ", INITKEY=" + INITKEY
				+ ", CARDISSUETIME=" + CARDISSUETIME + ", SERIALPORT="
				+ SERIALPORT + ", BAUDRATE=" + BAUDRATE + "]";
	}

	private String CARDNUM;
	private String INITKEY;
	private String CARDISSUETIME;
	private String SERIALPORT;
	private String BAUDRATE;
}

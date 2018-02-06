package cn.com.start.DPF.entity;

public class SerialPortConfig {

	private int ID; // 模板
	private String SERIALPORT;// 串口号
	private int BAUDRATE;// 波特率
	private String SECRETKEY;// 秘钥
	
	
	@Override
	public String toString() {
		return "SerialPortConfig [ID=" + ID + ", SERIALPORT=" + SERIALPORT
				+ ", BAUDRATE=" + BAUDRATE + ", SECRETKEY=" + SECRETKEY + "]";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSERIALPORT() {
		return SERIALPORT;
	}

	public void setSERIALPORT(String sERIALPORT) {
		SERIALPORT = sERIALPORT;
	}

	public int getBAUDRATE() {
		return BAUDRATE;
	}

	public void setBAUDRATE(int bAUDRATE) {
		BAUDRATE = bAUDRATE;
	}

	public String getSECRETKEY() {
		return SECRETKEY;
	}

	public void setSECRETKEY(String sECRETKEY) {
		SECRETKEY = sECRETKEY;
	}
}

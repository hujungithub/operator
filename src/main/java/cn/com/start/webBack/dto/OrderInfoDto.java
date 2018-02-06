package cn.com.start.webBack.dto;

public class OrderInfoDto {
	
	/*有两个int、两个datetime，后面再改吧，先把基本功能实现*/
	
	private String CARID;
	private String CPUSERID;
	private String STARTTIME;

	private String ENDTIME;
	private String ORDERSTATE;
	private String ORDERRESULT;

	private String ORDERNUMBER;
	private String MONEY;
	private String KILOMETRE;
	public String getCARID() {
		return CARID;
	}
	public void setCARID(String cARID) {
		CARID = cARID;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public String getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public String getENDTIME() {
		return ENDTIME;
	}
	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}
	public String getORDERSTATE() {
		return ORDERSTATE;
	}
	public void setORDERSTATE(String oRDERSTATE) {
		ORDERSTATE = oRDERSTATE;
	}
	public String getORDERRESULT() {
		return ORDERRESULT;
	}
	public void setORDERRESULT(String oRDERRESULT) {
		ORDERRESULT = oRDERRESULT;
	}
	public String getORDERNUMBER() {
		return ORDERNUMBER;
	}
	public void setORDERNUMBER(String oRDERNUMBER) {
		ORDERNUMBER = oRDERNUMBER;
	}
	public String getMONEY() {
		return MONEY;
	}
	public void setMONEY(String mONEY) {
		MONEY = mONEY;
	}
	public String getKILOMETRE() {
		return KILOMETRE;
	}
	public void setKILOMETRE(String kILOMETRE) {
		KILOMETRE = kILOMETRE;
	}
	@Override
	public String toString() {
		return "OrderInfoDto [CARID=" + CARID + ", CPUSERID=" + CPUSERID
				+ ", STARTTIME=" + STARTTIME + ", ENDTIME=" + ENDTIME
				+ ", ORDERSTATE=" + ORDERSTATE + ", ORDERRESULT=" + ORDERRESULT
				+ ", ORDERNUMBER=" + ORDERNUMBER + ", MONEY=" + MONEY
				+ ", KILOMETRE=" + KILOMETRE + "]";
	}
}

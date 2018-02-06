package cn.com.start.webBack.dto;

public class CpRealTimeDto {

	// 桩id
	private String CPID;
	// 接口id
	private Integer INTERFACEID;
	// 发送时间
	private String RECORDTIME;
	// 当前SOC
	private String SOC;
	// 充电时长
	private String CHARGETIMESPAN;
	// 剩余时间
	private String REMAINTIMESPAN;
	// A电压
	private String UA;
	// B电压
	private String UB;
	// C电压
	private String UC;
	// A电流
	private String IA;
	// B电流
	private String IB;
	// C电流
	private String IC;
	// 输出功率
	private String POWER;
	// 输出电量
	private String QUANTITY;
	// 报警码 0正常 1故障
	private String ALARMCODE;
	// 总电量 度
	private String TOTALQUANTITY;
	// 总费用 元
	private String TOTALFEE;
	// 尖电量
	private String JQUANTITY;
	// 尖价格
	private String JPRICE;
	// 尖费用
	private String JFEE;
	// 峰电量
	private String FQUANTITY;
	// 峰电价
	private String FPRICE;
	// 峰费用
	private String FFEE;
	// 平电量
	private String PQUANTITY;
	// 平电价
	private String PPRICE;
	// 平费用
	private String PFEE;
	// 谷电量
	private String GQUANTITY;
	// 谷电价
	private String GPRICE;
	// 谷费用
	private String GFEE;
	// 电池标志
	private String HASBATTERY;

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public Integer getINTERFACEID() {
		return INTERFACEID;
	}

	public void setINTERFACEID(Integer iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public String getSOC() {
		return SOC;
	}

	public void setSOC(String sOC) {
		SOC = sOC;
	}

	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}

	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}

	public String getREMAINTIMESPAN() {
		return REMAINTIMESPAN;
	}

	public void setREMAINTIMESPAN(String rEMAINTIMESPAN) {
		REMAINTIMESPAN = rEMAINTIMESPAN;
	}

	public String getUA() {
		return UA;
	}

	public void setUA(String uA) {
		UA = uA;
	}

	public String getUB() {
		return UB;
	}

	public void setUB(String uB) {
		UB = uB;
	}

	public String getUC() {
		return UC;
	}

	public void setUC(String uC) {
		UC = uC;
	}

	public String getIA() {
		return IA;
	}

	public void setIA(String iA) {
		IA = iA;
	}

	public String getIB() {
		return IB;
	}

	public void setIB(String iB) {
		IB = iB;
	}

	public String getIC() {
		return IC;
	}

	public void setIC(String iC) {
		IC = iC;
	}

	public String getPOWER() {
		return POWER;
	}

	public void setPOWER(String pOWER) {
		POWER = pOWER;
	}

	public String getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(String qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public String getALARMCODE() {
		return ALARMCODE;
	}

	public void setALARMCODE(String aLARMCODE) {
		ALARMCODE = aLARMCODE;
	}

	public String getTOTALQUANTITY() {
		return TOTALQUANTITY;
	}

	public void setTOTALQUANTITY(String tOTALQUANTITY) {
		TOTALQUANTITY = tOTALQUANTITY;
	}

	public String getTOTALFEE() {
		return TOTALFEE;
	}

	public void setTOTALFEE(String tOTALFEE) {
		TOTALFEE = tOTALFEE;
	}

	public String getJQUANTITY() {
		return JQUANTITY;
	}

	public void setJQUANTITY(String jQUANTITY) {
		JQUANTITY = jQUANTITY;
	}

	public String getJPRICE() {
		return JPRICE;
	}

	public void setJPRICE(String jPRICE) {
		JPRICE = jPRICE;
	}

	public String getJFEE() {
		return JFEE;
	}

	public void setJFEE(String jFEE) {
		JFEE = jFEE;
	}

	public String getFQUANTITY() {
		return FQUANTITY;
	}

	public void setFQUANTITY(String fQUANTITY) {
		FQUANTITY = fQUANTITY;
	}

	public String getFPRICE() {
		return FPRICE;
	}

	public void setFPRICE(String fPRICE) {
		FPRICE = fPRICE;
	}

	public String getFFEE() {
		return FFEE;
	}

	public void setFFEE(String fFEE) {
		FFEE = fFEE;
	}

	public String getPQUANTITY() {
		return PQUANTITY;
	}

	public void setPQUANTITY(String pQUANTITY) {
		PQUANTITY = pQUANTITY;
	}

	public String getPPRICE() {
		return PPRICE;
	}

	public void setPPRICE(String pPRICE) {
		PPRICE = pPRICE;
	}

	public String getPFEE() {
		return PFEE;
	}

	public void setPFEE(String pFEE) {
		PFEE = pFEE;
	}

	public String getGQUANTITY() {
		return GQUANTITY;
	}

	public void setGQUANTITY(String gQUANTITY) {
		GQUANTITY = gQUANTITY;
	}

	public String getGPRICE() {
		return GPRICE;
	}

	public void setGPRICE(String gPRICE) {
		GPRICE = gPRICE;
	}

	public String getGFEE() {
		return GFEE;
	}

	public void setGFEE(String gFEE) {
		GFEE = gFEE;
	}

	public String getHASBATTERY() {
		return HASBATTERY;
	}

	public void setHASBATTERY(String hASBATTERY) {
		HASBATTERY = hASBATTERY;
	}

}

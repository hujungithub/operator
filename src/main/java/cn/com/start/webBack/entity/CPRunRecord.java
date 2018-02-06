package cn.com.start.webBack.entity;

public class CPRunRecord {
	// 桩id
	private Long CPID;
	// 接口id
	private short INTERFACEID;
	// 发送时间
	private String RECORDTIME;
	// 当前SOC
	private short SOC;
	// 充电时长
	private int CHARGETIMESPAN;
	// 剩余时间
	private int REMAINTIMESPAN;
	// A电压
	private float UA;
	// B电压
	private float UB;
	// C电压
	private float UC;
	// A电流
	private float IA;
	// B电流
	private float IB;
	// C电流
	private float IC;
	// 输出功率
	private float POWER;
	// 输出电量
	private float QUANTITY;
	// 报警码 0正常 1故障
	private boolean ALARMCODE;
	// 总电量 度
	private float TOTALQUANTITY;
	// 总费用 元
	private float TOTALFEE;
	// 尖电量
	private float JQUANTITY;
	// 尖价格
	private float JPRICE;
	// 尖费用
	private float JFEE;
	// 峰电量
	private float FQUANTITY;
	// 峰电价
	private float FPRICE;
	// 峰费用
	private float FFEE;
	// 平电量
	private float PQUANTITY;
	// 平电价
	private float PPRICE;
	// 平费用
	private float PFEE;
	// 谷电量
	private float GQUANTITY;
	// 谷电价
	private float GPRICE;
	// 谷费用
	private float GFEE;
	// 电池标志
	private boolean HASBATTERY;
	public Long getCPID() {
		return CPID;
	}
	public void setCPID(Long cPID) {
		CPID = cPID;
	}
	public short getINTERFACEID() {
		return INTERFACEID;
	}
	public void setINTERFACEID(short iNTERFACEID) {
		INTERFACEID = iNTERFACEID;
	}
	public String getRECORDTIME() {
		return RECORDTIME;
	}
	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}
	public short getSOC() {
		return SOC;
	}
	public void setSOC(short sOC) {
		SOC = sOC;
	}
	public int getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}
	public void setCHARGETIMESPAN(int cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}
	public int getREMAINTIMESPAN() {
		return REMAINTIMESPAN;
	}
	public void setREMAINTIMESPAN(int rEMAINTIMESPAN) {
		REMAINTIMESPAN = rEMAINTIMESPAN;
	}
	public float getUA() {
		return UA;
	}
	public void setUA(float uA) {
		UA = uA;
	}
	public float getUB() {
		return UB;
	}
	public void setUB(float uB) {
		UB = uB;
	}
	public float getUC() {
		return UC;
	}
	public void setUC(float uC) {
		UC = uC;
	}
	public float getIA() {
		return IA;
	}
	public void setIA(float iA) {
		IA = iA;
	}
	public float getIB() {
		return IB;
	}
	public void setIB(float iB) {
		IB = iB;
	}
	public float getIC() {
		return IC;
	}
	public void setIC(float iC) {
		IC = iC;
	}
	public float getPOWER() {
		return POWER;
	}
	public void setPOWER(float pOWER) {
		POWER = pOWER;
	}
	public float getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(float qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public boolean isALARMCODE() {
		return ALARMCODE;
	}
	public void setALARMCODE(boolean aLARMCODE) {
		ALARMCODE = aLARMCODE;
	}
	public float getTOTALQUANTITY() {
		return TOTALQUANTITY;
	}
	public void setTOTALQUANTITY(float tOTALQUANTITY) {
		TOTALQUANTITY = tOTALQUANTITY;
	}
	public float getTOTALFEE() {
		return TOTALFEE;
	}
	public void setTOTALFEE(float tOTALFEE) {
		TOTALFEE = tOTALFEE;
	}
	public float getJQUANTITY() {
		return JQUANTITY;
	}
	public void setJQUANTITY(float jQUANTITY) {
		JQUANTITY = jQUANTITY;
	}
	public float getJPRICE() {
		return JPRICE;
	}
	public void setJPRICE(float jPRICE) {
		JPRICE = jPRICE;
	}
	public float getJFEE() {
		return JFEE;
	}
	public void setJFEE(float jFEE) {
		JFEE = jFEE;
	}
	public float getFQUANTITY() {
		return FQUANTITY;
	}
	public void setFQUANTITY(float fQUANTITY) {
		FQUANTITY = fQUANTITY;
	}
	public float getFPRICE() {
		return FPRICE;
	}
	public void setFPRICE(float fPRICE) {
		FPRICE = fPRICE;
	}
	public float getFFEE() {
		return FFEE;
	}
	public void setFFEE(float fFEE) {
		FFEE = fFEE;
	}
	public float getPQUANTITY() {
		return PQUANTITY;
	}
	public void setPQUANTITY(float pQUANTITY) {
		PQUANTITY = pQUANTITY;
	}
	public float getPPRICE() {
		return PPRICE;
	}
	public void setPPRICE(float pPRICE) {
		PPRICE = pPRICE;
	}
	public float getPFEE() {
		return PFEE;
	}
	public void setPFEE(float pFEE) {
		PFEE = pFEE;
	}
	public float getGQUANTITY() {
		return GQUANTITY;
	}
	public void setGQUANTITY(float gQUANTITY) {
		GQUANTITY = gQUANTITY;
	}
	public float getGPRICE() {
		return GPRICE;
	}
	public void setGPRICE(float gPRICE) {
		GPRICE = gPRICE;
	}
	public float getGFEE() {
		return GFEE;
	}
	public void setGFEE(float gFEE) {
		GFEE = gFEE;
	}
	public boolean isHASBATTERY() {
		return HASBATTERY;
	}
	public void setHASBATTERY(boolean hASBATTERY) {
		HASBATTERY = hASBATTERY;
	}

	

}

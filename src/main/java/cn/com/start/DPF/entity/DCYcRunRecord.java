package cn.com.start.DPF.entity;

public class DCYcRunRecord {
	private String CPID;// 桩id
	private String RECORDTIME;// 记录时间
	private String CPSTATE; // 桩的状态
	private long MILLSECONDS;// 毫秒
	private float chargeVOut;// 输出电压
	private float chargeAOut;// 输出电流
	private float SOC;// SOC
	private float batteryPackMintemp;// 电池组最低温度
	private float batteryPackMaxtemp;// 电池组最高温度
	private float batteryMintemp;// 单体电池最低温度
	private float batteryMaxtemp;// 单体电池最高温度
	private float chargerTemp;// 充电机环境温度
	private float chargeDirectV;// 充电导引电压
	private float chargeQuantity;// 充电电量
	private float chargePower;// 充电功率
	private float chargeMoney;// 充电金额
	private float chargeTimeSpan;// 充电时长
	
	//modify by hanmj Begin 20170807  遥测下行报文新增10个字节解析需求
	/*
	什么类型？字段名称？字段名称为什么不统一呢？
	记录类型recordType float 这个字段不需要了
	设备编号deviceId String 
	充电接口chargePort float 
	   */
	private String deviceId;//设备编号
	private int interfaceId;//充电接口
	
	
	public String getDeviceId() {return deviceId;}
	
	public void setDeviceId(String deviceId) {this.deviceId = deviceId;	}

	public int getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(int interfaceId) {
		this.interfaceId = interfaceId;
	}
	//modify by hanmj End 20170807  遥测下行报文新增10个字节解析需求

	public String getCPSTATE() {
		return CPSTATE;
	}

	public void setCPSTATE(String cPSTATE) {
		CPSTATE = cPSTATE;
	}

	public long getMILLSECONDS() {
		return MILLSECONDS;
	}

	public void setMILLSECONDS(long mILLSECONDS) {
		MILLSECONDS = mILLSECONDS;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public float getChargeVOut() {
		return chargeVOut;
	}

	public void setChargeVOut(float chargeVOut) {
		this.chargeVOut = chargeVOut;
	}

	public float getChargeAOut() {
		return chargeAOut;
	}

	public void setChargeAOut(float chargeAOut) {
		this.chargeAOut = chargeAOut;
	}

	public float getSOC() {
		return SOC;
	}

	public void setSOC(float sOC) {
		SOC = sOC;
	}

	public float getBatteryPackMintemp() {
		return batteryPackMintemp;
	}

	public void setBatteryPackMintemp(float batteryPackMintemp) {
		this.batteryPackMintemp = batteryPackMintemp;
	}

	public float getBatteryPackMaxtemp() {
		return batteryPackMaxtemp;
	}

	public void setBatteryPackMaxtemp(float batteryPackMaxtemp) {
		this.batteryPackMaxtemp = batteryPackMaxtemp;
	}

	public float getBatteryMintemp() {
		return batteryMintemp;
	}

	public void setBatteryMintemp(float batteryMintemp) {
		this.batteryMintemp = batteryMintemp;
	}

	public float getBatteryMaxtemp() {
		return batteryMaxtemp;
	}

	public void setBatteryMaxtemp(float batteryMaxtemp) {
		this.batteryMaxtemp = batteryMaxtemp;
	}

	public float getChargerTemp() {
		return chargerTemp;
	}

	public void setChargerTemp(float chargerTemp) {
		this.chargerTemp = chargerTemp;
	}

	public float getChargeDirectV() {
		return chargeDirectV;
	}

	public void setChargeDirectV(float chargeDirectV) {
		this.chargeDirectV = chargeDirectV;
	}

	public float getChargeQuantity() {
		return chargeQuantity;
	}

	public void setChargeQuantity(float chargeQuantity) {
		this.chargeQuantity = chargeQuantity;
	}

	public float getChargePower() {
		return chargePower;
	}

	public void setChargePower(float chargePower) {
		this.chargePower = chargePower;
	}

	public float getChargeMoney() {
		return chargeMoney;
	}

	public void setChargeMoney(float chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public float getChargeTimeSpan() {
		return chargeTimeSpan;
	}

	public void setChargeTimeSpan(float chargeTimeSpan) {
		this.chargeTimeSpan = chargeTimeSpan;
	}

	@Override
	public String toString() {
		return "DCYcRunRecord [CPID=" + CPID + ", RECORDTIME=" + RECORDTIME
				+ ", CPSTATE=" + CPSTATE + ", MILLSECONDS=" + MILLSECONDS
				+ ", chargeVOut=" + chargeVOut + ", chargeAOut=" + chargeAOut
				+ ", SOC=" + SOC + ", batteryPackMintemp=" + batteryPackMintemp
				+ ", batteryPackMaxtemp=" + batteryPackMaxtemp
				+ ", batteryMintemp=" + batteryMintemp + ", batteryMaxtemp="
				+ batteryMaxtemp + ", chargerTemp=" + chargerTemp
				+ ", chargeDirectV=" + chargeDirectV + ", chargeQuantity="
				+ chargeQuantity + ", chargePower=" + chargePower
				+ ", chargeMoney=" + chargeMoney + ", chargeTimeSpan="
				+ chargeTimeSpan + "]";
	}
}

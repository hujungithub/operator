package cn.com.start.DPF.entity;

public class dcyxzzz {

	private String CPID;// 桩id
	private String RECORDTIME;// 记录时间
	private long MILLSECONDS;// 毫秒
	private int pileState; // 0待机1工作2充满3警告4故障好
	private int emergencyStop; // 急停动作故障好
	private int smokeAlarm; // 烟雾报警告警
	private int acBreakerFault; // 交流断路器故障
	private int dcBusOutContactorFault; // 直流母线输出接触器故障
	private int dcBusOutFuseFault; // 直流母线输出熔断器故障
	private int chargePortLockFault; // 充电接口电子锁故障
	private int chargerFanFault; // 充电机风扇故障
	private int arresterFault; // 避雷器故障
	private int isoMonitorFault; // 绝缘监测故障
	private int batteryReversalFault; // 电池反接故障
	private int chargingCarGuideAlarm; // 充电中车辆控制导引告警
	private int chargerOTPFault; // 充电桩过温故障
	private int chargeGunOTP; // 充电枪过温
	private int chargeGunNoPlace; // 充电枪未归位
	private int BMSFault; // BMS通信异常
	private int inputVOV; // 输入电压过压
	private int inputVUV; // 输入电压欠压
	private int dcBusOutputOVAlarm; // 直流母线输出过压告警
	private int dcBusOutputUVAlarm; // 直流母线输出欠压告警
	private int dcBusOutputOAAlarm; // 直流母线输出过流告警
	private int CMFault; // 充电模块故障
	private int CMAcInputAlarm; // 充电模块交流输入告警
	private int CMAcInputOVAlarm; // 充电模块交流输入过压告警
	private int CMAcInputUVAlarm; // 充电模块交流输入欠压告警
	private int CMAcInputDPAlarm; // 充电模块交流输入缺相告警
	private int CMDcOutputSCAlarm; // 充电模块直流输出短路故障
	private int CMDcOutputOAAlarm; // 充电模块直流输出过流告警
	private int CMDcOutputOVAlarm; // 充电模块直流输出过压告警
	private int CMDcOutputUVAlarm; // 充电模块直流输出欠压告警
	private int CMOTPAlarm; // 充电模块过温告警
	private int CMCommunicationAlarm; // 充电模块通信告警
	private int CMFanFault; // 充电模块风扇故障
	private int isConnectedCar; // 是否连接车辆
	private int chargeGunButtState; // 充电桩充电枪座状态
	private int chargePortLockState; // 充电接口电子锁状态
	private int dcOutputContactorState; // 直流输出接触器状态
	private int otherFault; // 其他类型故障

	@Override
	public String toString() {
		return "YxDCRunRecord [CPID=" + CPID + ", RECORDTIME=" + RECORDTIME
				+ ", MILLSECONDS=" + MILLSECONDS + ", pileState=" + pileState
				+ ", emergencyStop=" + emergencyStop + ", smokeAlarm="
				+ smokeAlarm + ", acBreakerFault=" + acBreakerFault
				+ ", dcBusOutContactorFault=" + dcBusOutContactorFault
				+ ", dcBusOutFuseFault=" + dcBusOutFuseFault
				+ ", chargePortLockFault=" + chargePortLockFault
				+ ", chargerFanFault=" + chargerFanFault + ", arresterFault="
				+ arresterFault + ", isoMonitorFault=" + isoMonitorFault
				+ ", batteryReversalFault=" + batteryReversalFault
				+ ", chargingCarGuideAlarm=" + chargingCarGuideAlarm
				+ ", chargerOTPFault=" + chargerOTPFault + ", chargeGunOTP="
				+ chargeGunOTP + ", chargeGunNoPlace=" + chargeGunNoPlace
				+ ", BMSFault=" + BMSFault + ", inputVOV=" + inputVOV
				+ ", inputVUV=" + inputVUV + ", dcBusOutputOVAlarm="
				+ dcBusOutputOVAlarm + ", dcBusOutputUVAlarm="
				+ dcBusOutputUVAlarm + ", dcBusOutputOAAlarm="
				+ dcBusOutputOAAlarm + ", CMFault=" + CMFault
				+ ", CMAcInputAlarm=" + CMAcInputAlarm + ", CMAcInputOVAlarm="
				+ CMAcInputOVAlarm + ", CMAcInputUVAlarm=" + CMAcInputUVAlarm
				+ ", CMAcInputDPAlarm=" + CMAcInputDPAlarm
				+ ", CMDcOutputSCAlarm=" + CMDcOutputSCAlarm
				+ ", CMDcOutputOAAlarm=" + CMDcOutputOAAlarm
				+ ", CMDcOutputOVAlarm=" + CMDcOutputOVAlarm
				+ ", CMDcOutputUVAlarm=" + CMDcOutputUVAlarm + ", CMOTPAlarm="
				+ CMOTPAlarm + ", CMCommunicationAlarm=" + CMCommunicationAlarm
				+ ", CMFanFault=" + CMFanFault + ", isConnectedCar="
				+ isConnectedCar + ", chargeGunButtState=" + chargeGunButtState
				+ ", chargePortLockState=" + chargePortLockState
				+ ", dcOutputContactorState=" + dcOutputContactorState
				+ ", otherFault=" + otherFault + "]";
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

	public int getPileState() {
		return pileState;
	}

	public void setPileState(int pileState) {
		this.pileState = pileState;
	}

	public int getEmergencyStop() {
		return emergencyStop;
	}

	public void setEmergencyStop(int emergencyStop) {
		this.emergencyStop = emergencyStop;
	}

	public int getSmokeAlarm() {
		return smokeAlarm;
	}

	public void setSmokeAlarm(int smokeAlarm) {
		this.smokeAlarm = smokeAlarm;
	}

	public int getAcBreakerFault() {
		return acBreakerFault;
	}

	public void setAcBreakerFault(int acBreakerFault) {
		this.acBreakerFault = acBreakerFault;
	}

	public int getDcBusOutContactorFault() {
		return dcBusOutContactorFault;
	}

	public void setDcBusOutContactorFault(int dcBusOutContactorFault) {
		this.dcBusOutContactorFault = dcBusOutContactorFault;
	}

	public int getDcBusOutFuseFault() {
		return dcBusOutFuseFault;
	}

	public void setDcBusOutFuseFault(int dcBusOutFuseFault) {
		this.dcBusOutFuseFault = dcBusOutFuseFault;
	}

	public int getChargePortLockFault() {
		return chargePortLockFault;
	}

	public void setChargePortLockFault(int chargePortLockFault) {
		this.chargePortLockFault = chargePortLockFault;
	}

	public int getChargerFanFault() {
		return chargerFanFault;
	}

	public void setChargerFanFault(int chargerFanFault) {
		this.chargerFanFault = chargerFanFault;
	}

	public int getArresterFault() {
		return arresterFault;
	}

	public void setArresterFault(int arresterFault) {
		this.arresterFault = arresterFault;
	}

	public int getIsoMonitorFault() {
		return isoMonitorFault;
	}

	public void setIsoMonitorFault(int isoMonitorFault) {
		this.isoMonitorFault = isoMonitorFault;
	}

	public int getBatteryReversalFault() {
		return batteryReversalFault;
	}

	public void setBatteryReversalFault(int batteryReversalFault) {
		this.batteryReversalFault = batteryReversalFault;
	}

	public int getChargingCarGuideAlarm() {
		return chargingCarGuideAlarm;
	}

	public void setChargingCarGuideAlarm(int chargingCarGuideAlarm) {
		this.chargingCarGuideAlarm = chargingCarGuideAlarm;
	}

	public int getChargerOTPFault() {
		return chargerOTPFault;
	}

	public void setChargerOTPFault(int chargerOTPFault) {
		this.chargerOTPFault = chargerOTPFault;
	}

	public int getChargeGunOTP() {
		return chargeGunOTP;
	}

	public void setChargeGunOTP(int chargeGunOTP) {
		this.chargeGunOTP = chargeGunOTP;
	}

	public int getChargeGunNoPlace() {
		return chargeGunNoPlace;
	}

	public void setChargeGunNoPlace(int chargeGunNoPlace) {
		this.chargeGunNoPlace = chargeGunNoPlace;
	}

	public int getBMSFault() {
		return BMSFault;
	}

	public void setBMSFault(int bMSFault) {
		BMSFault = bMSFault;
	}

	public int getInputVOV() {
		return inputVOV;
	}

	public void setInputVOV(int inputVOV) {
		this.inputVOV = inputVOV;
	}

	public int getInputVUV() {
		return inputVUV;
	}

	public void setInputVUV(int inputVUV) {
		this.inputVUV = inputVUV;
	}

	public int getDcBusOutputOVAlarm() {
		return dcBusOutputOVAlarm;
	}

	public void setDcBusOutputOVAlarm(int dcBusOutputOVAlarm) {
		this.dcBusOutputOVAlarm = dcBusOutputOVAlarm;
	}

	public int getDcBusOutputUVAlarm() {
		return dcBusOutputUVAlarm;
	}

	public void setDcBusOutputUVAlarm(int dcBusOutputUVAlarm) {
		this.dcBusOutputUVAlarm = dcBusOutputUVAlarm;
	}

	public int getDcBusOutputOAAlarm() {
		return dcBusOutputOAAlarm;
	}

	public void setDcBusOutputOAAlarm(int dcBusOutputOAAlarm) {
		this.dcBusOutputOAAlarm = dcBusOutputOAAlarm;
	}

	public int getCMFault() {
		return CMFault;
	}

	public void setCMFault(int cMFault) {
		CMFault = cMFault;
	}

	public int getCMAcInputAlarm() {
		return CMAcInputAlarm;
	}

	public void setCMAcInputAlarm(int cMAcInputAlarm) {
		CMAcInputAlarm = cMAcInputAlarm;
	}

	public int getCMAcInputOVAlarm() {
		return CMAcInputOVAlarm;
	}

	public void setCMAcInputOVAlarm(int cMAcInputOVAlarm) {
		CMAcInputOVAlarm = cMAcInputOVAlarm;
	}

	public int getCMAcInputUVAlarm() {
		return CMAcInputUVAlarm;
	}

	public void setCMAcInputUVAlarm(int cMAcInputUVAlarm) {
		CMAcInputUVAlarm = cMAcInputUVAlarm;
	}

	public int getCMAcInputDPAlarm() {
		return CMAcInputDPAlarm;
	}

	public void setCMAcInputDPAlarm(int cMAcInputDPAlarm) {
		CMAcInputDPAlarm = cMAcInputDPAlarm;
	}

	public int getCMDcOutputSCAlarm() {
		return CMDcOutputSCAlarm;
	}

	public void setCMDcOutputSCAlarm(int cMDcOutputSCAlarm) {
		CMDcOutputSCAlarm = cMDcOutputSCAlarm;
	}

	public int getCMDcOutputOAAlarm() {
		return CMDcOutputOAAlarm;
	}

	public void setCMDcOutputOAAlarm(int cMDcOutputOAAlarm) {
		CMDcOutputOAAlarm = cMDcOutputOAAlarm;
	}

	public int getCMDcOutputOVAlarm() {
		return CMDcOutputOVAlarm;
	}

	public void setCMDcOutputOVAlarm(int cMDcOutputOVAlarm) {
		CMDcOutputOVAlarm = cMDcOutputOVAlarm;
	}

	public int getCMDcOutputUVAlarm() {
		return CMDcOutputUVAlarm;
	}

	public void setCMDcOutputUVAlarm(int cMDcOutputUVAlarm) {
		CMDcOutputUVAlarm = cMDcOutputUVAlarm;
	}

	public int getCMOTPAlarm() {
		return CMOTPAlarm;
	}

	public void setCMOTPAlarm(int cMOTPAlarm) {
		CMOTPAlarm = cMOTPAlarm;
	}

	public int getCMCommunicationAlarm() {
		return CMCommunicationAlarm;
	}

	public void setCMCommunicationAlarm(int cMCommunicationAlarm) {
		CMCommunicationAlarm = cMCommunicationAlarm;
	}

	public int getCMFanFault() {
		return CMFanFault;
	}

	public void setCMFanFault(int cMFanFault) {
		CMFanFault = cMFanFault;
	}

	public int getIsConnectedCar() {
		return isConnectedCar;
	}

	public void setIsConnectedCar(int isConnectedCar) {
		this.isConnectedCar = isConnectedCar;
	}

	public int getChargeGunButtState() {
		return chargeGunButtState;
	}

	public void setChargeGunButtState(int chargeGunButtState) {
		this.chargeGunButtState = chargeGunButtState;
	}

	public int getChargePortLockState() {
		return chargePortLockState;
	}

	public void setChargePortLockState(int chargePortLockState) {
		this.chargePortLockState = chargePortLockState;
	}

	public int getDcOutputContactorState() {
		return dcOutputContactorState;
	}

	public void setDcOutputContactorState(int dcOutputContactorState) {
		this.dcOutputContactorState = dcOutputContactorState;
	}

	public int getOtherFault() {
		return otherFault;
	}

	public void setOtherFault(int otherFault) {
		this.otherFault = otherFault;
	}

}

package cn.com.start.DPF.entity;

public class DCYxRunRecord {
	private int id; // id
	private int yxPointId;// 遥信点
	private String cpid;// 桩id
	private String oldValue;// 旧值
	private String oldValueMean;// 旧值含义
	private String oldValueRecordTime;// 旧值记录时间
	private String newValue;// 新值
	private String newValueMean;// 新值含义
	private String recordTime;// 新值记录时间
	private int checkState;//
	private int checkMode;//


	//modify by hanmj Begin 20170807  遥测下行报文新增10个字节解析需求
	/*
	什么类型？字段名称？字段名称为什么不统一呢？
	记录类型recordType float 
	设备编号deviceId String 
	充电接口chargePort float 
	   */
	private String deviceId;//设备编号
	private int interfaceId;//充电接口
	
	

	
	public String getDeviceId() {return deviceId;}
	
	public void setDeviceId(String deviceId) {this.deviceId = deviceId;	}
	
	public int getInterfaceId() {return interfaceId;}
	
	public void setInterfaceId(int interfaceId) {this.interfaceId = interfaceId;	}
	//modify by hanmj End 20170807  遥测下行报文新增10个字节解析需求

	@Override
	public String toString() {
		return "DCYxRunRecord [id=" + id + ", yxPointId=" + yxPointId
				+ ", cpid=" + cpid + ", oldValue=" + oldValue
				+ ", oldValueMean=" + oldValueMean + ", oldValueRecordTime="
				+ oldValueRecordTime + ", newValue=" + newValue
				+ ", newValueMean=" + newValueMean + ", recordTime="
				+ recordTime + ", checkState=" + checkState + ", checkMode="
				+ checkMode + "]";
	}

	public int getCheckState() {
		return checkState;
	}

	public void setCheckState(int checkState) {
		this.checkState = checkState;
	}

	public int getCheckMode() {
		return checkMode;
	}

	public void setCheckMode(int checkMode) {
		this.checkMode = checkMode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYxPointId() {
		return yxPointId;
	}

	public void setYxPointId(int yxPointId) {
		this.yxPointId = yxPointId;
	}

	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getOldValueMean() {
		return oldValueMean;
	}

	public void setOldValueMean(String oldValueMean) {
		this.oldValueMean = oldValueMean;
	}

	public String getOldValueRecordTime() {
		return oldValueRecordTime;
	}

	public void setOldValueRecordTime(String oldValueRecordTime) {
		this.oldValueRecordTime = oldValueRecordTime;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getNewValueMean() {
		return newValueMean;
	}

	public void setNewValueMean(String newValueMean) {
		this.newValueMean = newValueMean;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

}

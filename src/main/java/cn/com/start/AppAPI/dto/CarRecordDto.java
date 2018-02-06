package cn.com.start.AppAPI.dto;

public class CarRecordDto {
	public String carId;
	
	public String cpuserId;
	
	public String startTime;
	
	public String endTime;
	
	public int orderState;
	
	public String orderResult;
	
	public String orderNumber;
	
	public int money;
	
	public String kilometre;

	@Override
	public String toString() {
		return "CarRecordDto [carId=" + carId + ", cpuserId=" + cpuserId
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", orderState=" + orderState + ", orderResult=" + orderResult
				+ ", orderNumber=" + orderNumber + ", money=" + money
				+ ", kilometre=" + kilometre + "]";
	}
	
	
}

package cn.com.start.AppAPI.dto;

public class AppointmentCarDto {
	public String sn;
	
	public String carId;
	
	public String startTime;
	
	public String recordTime;
	
	public int appointState;
	
	public String description;
	
	public String cpuserId;
	
	public String appointParameter;
	
	public int appointType;

	@Override
	public String toString() {
		return "AppointmentCarDto [carId=" + carId + ", startTime=" + startTime
				+ ", recordTime=" + recordTime + ", appointState="
				+ appointState + ", description=" + description + ", cpuserId="
				+ cpuserId + ", appointParameter=" + appointParameter
				+ ", appointType=" + appointType + "]";
	}
	
}

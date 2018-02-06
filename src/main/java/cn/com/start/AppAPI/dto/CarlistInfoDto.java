package cn.com.start.AppAPI.dto;

public class CarlistInfoDto {
	public String sn;
	public String carId;
	public String carPlate;
	public String appointId;
	public String carState;
	public String carModel;
	public String carSoc;
	public String hour;
	public String day;
	public String rank;
	public String mileAge;
	public String longitude;
	public String latitude;
	
	
	@Override
	public String toString() {
		return "CarlistInfoDto [sn=" + sn + ", carId=" + carId + ", carPlate="
				+ carPlate + ", appointId=" + appointId + ", carState="
				+ carState + ", carModel=" + carModel + ", carSoc=" + carSoc
				+ ", hour=" + hour + ", day=" + day + ", rank=" + rank
				+ ", mileAge=" + mileAge + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
	
	
}

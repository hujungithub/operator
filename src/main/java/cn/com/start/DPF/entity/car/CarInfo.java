package cn.com.start.DPF.entity.car;

public class CarInfo {
	private String carId;
	private String carPlate;
	private Integer appointId;
	private Integer carState;
	private String carModel;
	private String carSoc;
	private Integer priceId;
	private Float rank;
	private Float mileAge;
	private Double longitude;
	private Double latitude;
	
	
	
	
	
	@Override
	public String toString() {
		return "CarInfo [carId=" + carId + ", carPlate=" + carPlate
				+ ", appointId=" + appointId + ", carState=" + carState
				+ ", carModel=" + carModel + ", carSoc=" + carSoc
				+ ", priceId=" + priceId + ", rank=" + rank + ", mileAge="
				+ mileAge + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}


	public Integer getPriceId() {
		return priceId;
	}


	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}


	public Float getRank() {
		return rank;
	}


	public void setRank(Float rank) {
		this.rank = rank;
	}


	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarPlate() {
		return carPlate;
	}
	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}
	public Integer getAppointId() {
		return appointId;
	}
	public void setAppointId(Integer appointId) {
		this.appointId = appointId;
	}
	public Integer getCarState() {
		return carState;
	}
	public void setCarState(Integer carState) {
		this.carState = carState;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarSoc() {
		return carSoc;
	}
	public void setCarSoc(String carSoc) {
		this.carSoc = carSoc;
	}
	public Float getMileAge() {
		return mileAge;
	}
	public void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}

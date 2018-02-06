package cn.com.start.DPF.car;

public class CarRealState {
	private Integer cardId; 
	private String carPlate;
	private Integer appointId;
	private Integer carState;
	private String carSoc;
	private Float mileAge;
	private Float longitude;
	private Float latitude;
	private String soc;
	private Integer carDoorState;
	
	
	@Override
	public String toString() {
		return "CarRealState [longitude=" + longitude + ", latitude="
				+ latitude + ", soc=" + soc + ", carDoorState=" + carDoorState
				+ "]";
	}
	
	
	
	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
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



	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public String getSoc() {
		return soc;
	}
	public void setSoc(String soc) {
		this.soc = soc;
	}
	public Integer getCarDoorState() {
		return carDoorState;
	}
	public void setCarDoorState(Integer carDoorState) {
		this.carDoorState = carDoorState;
	}
	
	
	
}

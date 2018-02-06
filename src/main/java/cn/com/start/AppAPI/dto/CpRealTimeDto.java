package cn.com.start.AppAPI.dto;

public class CpRealTimeDto {
	private String currentSoc;
	private String remainTime;
	private String chargeTime;
	private String currentAVol;
	private String currentACur;

	public String getCurrentSoc() {
		return currentSoc;
	}

	public void setCurrentSoc(String currentSoc) {
		this.currentSoc = currentSoc;
	}

	public String getRemainTime() {
		return remainTime;
	}

	public void setRemainTime(String remainTime) {
		this.remainTime = remainTime;
	}

	public String getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getCurrentAVol() {
		return currentAVol;
	}

	public void setCurrentAVol(String currentAVol) {
		this.currentAVol = currentAVol;
	}

	public String getCurrentACur() {
		return currentACur;
	}

	public void setCurrentACur(String currentACur) {
		this.currentACur = currentACur;
	}

}

package cn.com.start.webBack.dto;

import cn.com.start.webBack.entity.CPInfo;

public class UpdateCPDto {
	private ReturnCPDto addCPDto;
	private CPInfo chargePile;
	private FullLocDto fullLocDto;

	public ReturnCPDto getAddCPDto() {
		return addCPDto;
	}

	public void setAddCPDto(ReturnCPDto addCPDto) {
		this.addCPDto = addCPDto;
	}

	public CPInfo getChargePile() {
		return chargePile;
	}

	public void setChargePile(CPInfo chargePile) {
		this.chargePile = chargePile;
	}

	public FullLocDto getFullLocDto() {
		return fullLocDto;
	}

	public void setFullLocDto(FullLocDto fullLocDto) {
		this.fullLocDto = fullLocDto;
	}
}

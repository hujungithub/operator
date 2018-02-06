package cn.com.start.webBack.dto;

import cn.com.start.webBack.entity.RateInfo;

public class UpdateFeeDto {
	private ReturnCPDto addCPDto;
	private RateInfo feemst;

	public ReturnCPDto getAddCPDto() {
		return addCPDto;
	}

	public void setAddCPDto(ReturnCPDto addCPDto) {
		this.addCPDto = addCPDto;
	}

	public RateInfo getFeemst() {
		return feemst;
	}

	public void setFeemst(RateInfo feemst) {
		this.feemst = feemst;
	}

}

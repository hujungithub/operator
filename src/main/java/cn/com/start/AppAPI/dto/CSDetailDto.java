package cn.com.start.AppAPI.dto;

import java.util.List;

public class CSDetailDto {
	// 站信息
	private ChargeStationDto csInfo;
	// 桩列表
	private List<ChargePileDto> cpList;

	public ChargeStationDto getCsInfo() {
		return csInfo;
	}

	public void setCsInfo(ChargeStationDto csInfo) {
		this.csInfo = csInfo;
	}

	public List<ChargePileDto> getCpList() {
		return cpList;
	}

	public void setCpList(List<ChargePileDto> cpList) {
		this.cpList = cpList;
	}
}

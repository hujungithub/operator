package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.util.Page;

public interface ChargePileDetailService {

	// 查询充电桩详情
	List<CPInfoDto> findCPDetail(FindCPDto findCPDto);

	// // 充电桩充电记录
	List<OperInfoDto> findUserCharge(FindCPDto findCPDto);

	// // 查出最早充电时间
	String findLastChargeTime(String cpId);

	// // 无条件导出一个桩所有充电信息
	List<UserChargeDto> exportChargeDetailList(FindCPDto findCPDto);

}

package cn.com.start.webBack.service;

import cn.com.start.webBack.dto.FindIndexDto;
import cn.com.start.webBack.dto.IndexDto;

public interface IndexService {

	// 根据运营商id查询统计数据
	IndexDto findIndexDto(String operatorId);

	// 统计电量
	float[] findChargeStatistic(FindIndexDto findIndexDto);

	// 统计充电次数
	int[] findCountStatistic(FindIndexDto findIndexDto);

	// 统计充电收入
	float[] findIncomeStatistic(FindIndexDto findIndexDto);
}

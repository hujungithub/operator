package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindIndexDto;
import cn.com.start.webBack.dto.IndexDto;

public interface IndexMapper {

	// csnum operaid
	IndexDto selectCSStatistic(String operatorId);
	// cpnum
	IndexDto selectCPStatistic(String operatorId);
	// dcpnum
	IndexDto selectDCPStatistic(String operatorId);
	// acpnum
	IndexDto selectACPStatistic(String operatorId);

	// 统计收入信息
	IndexDto selectMoneyStatistic(String operatorid);

	// 统计app用户数据
	IndexDto selectAppStatistic();

	// 统计卡用户
	IndexDto selectCardStatistic();

	// 统计充电电量 画图
	List<FindIndexDto> selectChargeStatistic(FindIndexDto findIndexDto);

	// 统计充电收入 画图
	List<FindIndexDto> selectIncomeStatistic(FindIndexDto findIndexDto);

	// 统计充电次数 画图
	List<FindIndexDto> selectCountStatistic(FindIndexDto findIndexDto);
}

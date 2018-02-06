package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;

public interface StatisticsCpMapper {

	int getCpCount(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpOperinfo(FindreportsDto findreportsDto);


	List<UserChargeDto> selectCpAll(FindreportsDto findreportsDto);

	String selectoper(String operatorid);


}

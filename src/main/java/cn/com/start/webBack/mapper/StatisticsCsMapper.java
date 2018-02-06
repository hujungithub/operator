package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;

public interface StatisticsCsMapper {

	int getCsCount(FindreportsDto findreportsDto);


	List<UserChargeDto> selectCsByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCsAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCsOperinfo(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCsAll(FindreportsDto findreportsDto);


	String selectoper(String operatorid);


}

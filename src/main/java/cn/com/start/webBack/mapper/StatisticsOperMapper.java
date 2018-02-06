package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;

public interface StatisticsOperMapper {

	int getOperCount(FindreportsDto findreportsDto);


	List<UserChargeDto> selectOperByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectOperAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> selectOperOperinfo(FindreportsDto findreportsDto);

	List<UserChargeDto> selectOperAll(FindreportsDto findreportsDto);


}

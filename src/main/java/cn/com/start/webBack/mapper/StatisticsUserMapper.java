package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;

public interface StatisticsUserMapper {

	int getCpCount(FindreportsDto findreportsDto);

	int getCardCount(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCardByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCardAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpOperinfo(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCardOperinfo(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCpAll(FindreportsDto findreportsDto);

	List<UserChargeDto> selectCardAll(FindreportsDto findreportsDto);

	int getCount(FindreportsDto findreportsDto);

	List<UserChargeDto> selectByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> selectOperinfo(FindreportsDto findreportsDto);

	List<UserChargeDto> selectAll(FindreportsDto findreportsDto);

	List<UserChargeDto> selectAllCount(FindreportsDto findreportsDto);

}

package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.util.Page;

public interface StatisticsUserService {

	Page showByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> findCpAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findCardAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findCpAll(FindreportsDto findreportsDto);

	List<UserChargeDto> findCardAll(FindreportsDto findreportsDto);

	List<UserChargeDto> findAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findAll(FindreportsDto findreportsDto);

}

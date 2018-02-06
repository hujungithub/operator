package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.util.Page;

public interface StatisticsOperService {

	Page showByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> findOperAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findOperAll(FindreportsDto findreportsDto);


}

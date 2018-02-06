package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.util.Page;

public interface StatisticsCsService {

	Page showByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> findCsAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findCsAll(FindreportsDto findreportsDto);

	String findoper(String operatorid);


}

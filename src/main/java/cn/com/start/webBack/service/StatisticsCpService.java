package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.util.Page;

public interface StatisticsCpService {

	Page showByPage(FindreportsDto findreportsDto);

	List<UserChargeDto> findCpAllreports(FindreportsDto findreportsDto);

	List<UserChargeDto> findCpAll(FindreportsDto findreportsDto);

	String findoper(String operatorid);


}

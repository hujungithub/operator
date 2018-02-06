package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CpRealTimeDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.util.Page;

public interface CpRealTimeService {

	// 根据条件查询cpid
	Page findCPIdList(FindCPDto findCPDto);

	int findCSCount();

	int findCPCount();

	int findOrderCount(String time);

	int findCPUserCount();

	int findOrderAmount(String time);

	List<CpRealTimeDto> showCPByPage(String coId, String csId);

}

package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.CpRealTimeDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.mapper.CpRealTimeMapper;
import cn.com.start.webBack.service.CpRealTimeService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class CpRealTimeServiceImpl implements CpRealTimeService {
	@Resource
	public CpRealTimeMapper cpRealTimeMapper;

	// 根据条件查询cplist
	@Override
	public Page findCPIdList(FindCPDto findCPDto) {
		int totalCount = cpRealTimeMapper.getCPCount(findCPDto);
		Page page = new Page(totalCount, findCPDto.getPageSize(),
				findCPDto.getPageNow());
		findCPDto.setStartPos(page.getStartPos());
		List<String> cpidList = cpRealTimeMapper.selectCPIdList(findCPDto);
		page.setList(cpidList);
		return page;
	}

	public int findCSCount() {
		int CSCount = cpRealTimeMapper.findCSCount();
		return CSCount;
	}

	@Override
	public int findCPCount() {
		int CPCount = cpRealTimeMapper.findCPCount();
		return CPCount;
	}

	@Override
	public int findOrderCount(String time) {
		int OrderCount = cpRealTimeMapper.findOrderCount(time);
		return OrderCount;
	}

	@Override
	public int findOrderAmount(String time) {
		int OrderAmount = cpRealTimeMapper.findOrderAmount(time);
		return OrderAmount;
	}

	@Override
	public int findCPUserCount() {
		int CPUserCount = cpRealTimeMapper.findCPUserCount();
		return CPUserCount;
	}

	@Override
	public List<CpRealTimeDto> showCPByPage(String coId, String csId) {
		List<CpRealTimeDto> onePageCPList = cpRealTimeMapper.selectCPRTByPage(
				coId, csId);
		return onePageCPList;
	}

}

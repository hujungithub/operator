package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.mapper.StatisticsCpMapper;
import cn.com.start.webBack.service.StatisticsCpService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class StatisticsCpServiceImpl implements StatisticsCpService {

	@Resource
	public StatisticsCpMapper statisticsCpMapper;

	@Override
	public Page showByPage(FindreportsDto findreportsDto) {
		// 查询记录数量
		int pageCount = 0;
		List<UserChargeDto> onePageList = new ArrayList<UserChargeDto>();
		List<UserChargeDto> addPageList = new ArrayList<UserChargeDto>();
		pageCount = statisticsCpMapper.getCpCount(findreportsDto);

		Page page = new Page(pageCount, findreportsDto.getPageSize(),
				findreportsDto.getPageNow());
		findreportsDto.setStartPos(page.getStartPos());
		// 查询记录
		onePageList = statisticsCpMapper.selectCpByPage(findreportsDto);
		// 查询合计
		addPageList = statisticsCpMapper.selectCpOperinfo(findreportsDto);
		page.setList(onePageList);
		page.setAddList(addPageList);
		return page;
	}

	@Override
	public List<UserChargeDto> findCpAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> cp = statisticsCpMapper
				.selectCpAllreports(findreportsDto);
		return cp;
	}

	@Override
	public List<UserChargeDto> findCpAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> cpAll = statisticsCpMapper
				.selectCpAll(findreportsDto);
		return cpAll;
	}

	@Override
	public String findoper(String operatorid) {
		String oper = statisticsCpMapper.selectoper(operatorid);
		return oper;
	}

}

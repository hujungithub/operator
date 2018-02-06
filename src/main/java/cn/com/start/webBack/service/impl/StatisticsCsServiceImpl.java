package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.mapper.StatisticsCsMapper;
import cn.com.start.webBack.service.StatisticsCsService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class StatisticsCsServiceImpl implements StatisticsCsService {

	@Resource
	public StatisticsCsMapper statisticsCsMapper;

	@Override
	public Page showByPage(FindreportsDto findreportsDto) {
		// 查询记录数量
		int pageCount = 0;
		List<UserChargeDto> onePageList = new ArrayList<UserChargeDto>();
		List<UserChargeDto> addPageList = new ArrayList<UserChargeDto>();
		pageCount = statisticsCsMapper.getCsCount(findreportsDto);

		Page page = new Page(pageCount, findreportsDto.getPageSize(),
				findreportsDto.getPageNow());
		findreportsDto.setStartPos(page.getStartPos());
		// 查询记录
		onePageList = statisticsCsMapper.selectCsByPage(findreportsDto);

		addPageList = statisticsCsMapper.selectCsOperinfo(findreportsDto);
		page.setList(onePageList);
		page.setAddList(addPageList);
		return page;
	}

	@Override
	public List<UserChargeDto> findCsAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> cs = statisticsCsMapper
				.selectCsAllreports(findreportsDto);
		return cs;
	}

	@Override
	public List<UserChargeDto> findCsAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> csAll = statisticsCsMapper
				.selectCsAll(findreportsDto);
		return csAll;
	}

	@Override
	public String findoper(String operatorid) {
		String oper = statisticsCsMapper.selectoper(operatorid);
		return oper;
	}

}

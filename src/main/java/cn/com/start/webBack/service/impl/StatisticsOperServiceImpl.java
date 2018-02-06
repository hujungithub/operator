package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.mapper.StatisticsOperMapper;
import cn.com.start.webBack.service.StatisticsOperService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class StatisticsOperServiceImpl implements StatisticsOperService {

	@Resource
	public StatisticsOperMapper statisticsOperMapper;

	@Override
	public Page showByPage(FindreportsDto findreportsDto) {
		// 查询记录数量
		int pageCount = 0;
		List<UserChargeDto> onePageList = new ArrayList<UserChargeDto>();
		List<UserChargeDto> addPageList = new ArrayList<UserChargeDto>();
		pageCount = statisticsOperMapper.getOperCount(findreportsDto);

		Page page = new Page(pageCount, findreportsDto.getPageSize(),
				findreportsDto.getPageNow());
		findreportsDto.setStartPos(page.getStartPos());
		// 查询记录
		onePageList = statisticsOperMapper.selectOperByPage(findreportsDto);

		addPageList = statisticsOperMapper.selectOperOperinfo(findreportsDto);
		page.setList(onePageList);
		page.setAddList(addPageList);
		return page;
	}

	@Override
	public List<UserChargeDto> findOperAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> oper = statisticsOperMapper
				.selectOperAllreports(findreportsDto);
		return oper;
	}

	@Override
	public List<UserChargeDto> findOperAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> operAll = statisticsOperMapper
				.selectOperAll(findreportsDto);
		return operAll;
	}

}

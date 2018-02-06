package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.mapper.StatisticsUserMapper;
import cn.com.start.webBack.service.StatisticsUserService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class StatisticsUserServiceImpl implements StatisticsUserService {

	@Resource
	public StatisticsUserMapper statisticsUserMapper;

	@Override
	public Page showByPage(FindreportsDto findreportsDto) {
		// 查询记录数量
		int pageCount = 0;
		List<UserChargeDto> onePageList = new ArrayList<UserChargeDto>();
		List<UserChargeDto> addPageList = new ArrayList<UserChargeDto>();
		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			pageCount = statisticsUserMapper.getCpCount(findreportsDto);

		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			pageCount = statisticsUserMapper.getCardCount(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			pageCount = statisticsUserMapper.getCount(findreportsDto);
		}
		Page page = new Page(pageCount, findreportsDto.getPageSize(),
				findreportsDto.getPageNow());
		findreportsDto.setStartPos(page.getStartPos());
		// 查询记录
		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			onePageList = statisticsUserMapper.selectCpByPage(findreportsDto);
		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			onePageList = statisticsUserMapper.selectCardByPage(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			onePageList = statisticsUserMapper.selectByPage(findreportsDto);
		}

		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			addPageList = statisticsUserMapper.selectCpOperinfo(findreportsDto);
		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			addPageList = statisticsUserMapper
					.selectCardOperinfo(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			addPageList = statisticsUserMapper.selectOperinfo(findreportsDto);
		}
		page.setList(onePageList);
		page.setAddList(addPageList);
		return page;
	}

	@Override
	public List<UserChargeDto> findCpAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> cpuser = statisticsUserMapper
				.selectCpAllreports(findreportsDto);
		return cpuser;
	}

	@Override
	public List<UserChargeDto> findCardAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> carduser = statisticsUserMapper
				.selectCardAllreports(findreportsDto);
		return carduser;
	}

	@Override
	public List<UserChargeDto> findCpAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> cpuserAll = statisticsUserMapper
				.selectCpAll(findreportsDto);
		return cpuserAll;
	}

	@Override
	public List<UserChargeDto> findCardAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> carduserAll = statisticsUserMapper
				.selectCardAll(findreportsDto);
		return carduserAll;
	}

	@Override
	public List<UserChargeDto> findAllreports(FindreportsDto findreportsDto) {
		List<UserChargeDto> Allreports = statisticsUserMapper
				.selectAll(findreportsDto);
		return Allreports;
	}

	@Override
	public List<UserChargeDto> findAll(FindreportsDto findreportsDto) {
		List<UserChargeDto> All = statisticsUserMapper
				.selectAllCount(findreportsDto);
		return All;
	}

}

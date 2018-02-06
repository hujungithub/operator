package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.CpyxchangeRecordDto;
import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.mapper.CpfaiMapper;
import cn.com.start.webBack.service.CpfaiService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class CpfaiServiceImpl implements CpfaiService {
	@Resource
	private CpfaiMapper cpfaimapper;

	@Override
	public Page findAll(FindARDto findARDto) {
		// TODO Auto-generated method stub
		Page page = null;
		List<CpyxchangeRecordDto> onePageUserList = new ArrayList<CpyxchangeRecordDto>();
		int pageCount = cpfaimapper.findCpfaiCount(findARDto);
		page = new Page(pageCount, findARDto.getPageSize(),
				findARDto.getPageNow());

		findARDto.setStartPos(page.getStartPos());
		onePageUserList = cpfaimapper.findAll(findARDto);
		page.setList(onePageUserList);
		return page;
	}

	@Override
	public int update(FindARDto findARDto) {
		// TODO Auto-generated method stub

		int count = cpfaimapper.update(findARDto);
		return count;
	}

	@Override
	public int updateAll(FindARDto findARDto) {
		// TODO Auto-generated method stub
		int countall = cpfaimapper.updateAll(findARDto);
		return countall;
	}

	@Override
	public int findstate0(FindARDto findARDto) {
		// TODO Auto-generated method stub
		int statecount0 = cpfaimapper.findstate0(findARDto);
		return statecount0;
	}

	@Override
	public int findstate1(FindARDto findARDto) {
		// TODO Auto-generated method stub
		int statecount1 = cpfaimapper.findstate1(findARDto);
		return statecount1;
	}

	@Override
	public int findstate(FindARDto findARDto) {
		// TODO Auto-generated method stub
		int statecount = cpfaimapper.findstate(findARDto);
		return statecount;
	}

	@Override
	public int updatedc(FindARDto findARDto) {
		int countdc = cpfaimapper.updatedc(findARDto);
		return countdc;
	}

	@Override
	public int updateAlldc(FindARDto findARDto) {
		int countalldc = cpfaimapper.updateAlldc(findARDto);
		return countalldc;
	}

}

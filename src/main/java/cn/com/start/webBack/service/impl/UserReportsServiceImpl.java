package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.mapper.UserReportsMapper;
import cn.com.start.webBack.service.UserReportsService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class UserReportsServiceImpl implements UserReportsService {

	@Resource
	public UserReportsMapper userReportsMapper;

	@Override
	public List<userReportsDto> showOuterByPage(FindreportsDto findreportsDto) {
		List<userReportsDto> onePageList = new ArrayList<userReportsDto>();
		onePageList = userReportsMapper.selectOuterCardByPage(findreportsDto);
//		page.setList(onePageList);
		return onePageList;
	}

	@Override
	public List<userReportsDto> showByPage(FindreportsDto findreportsDto) {
		// TODO Auto-generated method stub
		// 查询记录数量
		List<userReportsDto> onePageList = new ArrayList<userReportsDto>();
		// 查询记录
//		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
//			onePageList = userReportsMapper.selectByPage(findreportsDto);
		/*} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			onePageList = userReportsMapper.selectCardByPage(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
		}*/
		onePageList = userReportsMapper.selectAllByPage(findreportsDto);
		System.out.println("--------onePageList-----"+onePageList);
//		page.setList(onePageList);
		return onePageList;
	}

	@Override
	public List<userReportsDto> findAllreports(FindreportsDto findreportsDto) {
		// TODO Auto-generated method stub
		List<userReportsDto> userreports = userReportsMapper
				.selectAllreports(findreportsDto);
		return userreports;
	}

	@Override
	public List<userReportsDto> findCardAllreports(FindreportsDto findreportsDto) {
		// TODO Auto-generated method stub
		List<userReportsDto> carduserreports = userReportsMapper
				.selectCardAllreports(findreportsDto);
		return carduserreports;
	}

	@Override
	public List<userReportsDto> findAll(FindreportsDto findreportsDto) {
		// TODO Auto-generated method stub
		List<userReportsDto> All = userReportsMapper.selectAll(findreportsDto);
		return All;
	}

	@Override
	public List<userReportsDto> findouter(FindreportsDto findreportsDto) {
		// TODO Auto-generated method stub
		List<userReportsDto> findouter = userReportsMapper
				.selectouter(findreportsDto);
		return findouter;
	}

	@Override
	public String findoper(String operatorid) {
		String oper = userReportsMapper.selectoper(operatorid);
		return oper;
	}

}

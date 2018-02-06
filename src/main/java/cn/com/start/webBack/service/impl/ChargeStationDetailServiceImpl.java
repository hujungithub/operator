package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.FindCSDto;
import cn.com.start.webBack.dto.FindCSInfoDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.mapper.ChargeStationMapper;
import cn.com.start.webBack.service.ChargeStationDetailService;
import cn.com.start.webBack.service.ChargeStationService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ChargeStationDetailServiceImpl implements ChargeStationDetailService {
	@Resource
	private ChargeStationMapper chargeStationMapper;



	// 根据站ID查询站详细 导出需要
	@Override
	public List<CSInfoDto> findCSDetailById(String CSID) {
		List<CSInfoDto> csDto = chargeStationMapper.selectCSDetailById(CSID);
		return csDto;
	}

	@Override
	public List<CSInfoDto> findCPCharge(FindCPDto findCPDto) {
//		//查询站内桩数量
//		int totalCount = chargeStationMapper.getCPChargeCount(findCPDto);
//		//分页
//		Page pagedetil = new Page(totalCount, findCPDto.getPageSize(),
//				findCPDto.getPageNow());
//		findCPDto.setStartPos(pagedetil.getStartPos());
		
		
		List<CSInfoDto> chargeList = chargeStationMapper
				.selectCpCharge(findCPDto);

		// 充电站运营总收入，总电量
		List<CSoperInfoDto> csoperList = chargeStationMapper
				.selectCScount(findCPDto);
//		pagedetil.setList(chargeList);
//
//		pagedetil.setAddList(csoperList);

		return chargeList;
	}

	@Override
	public List<CSInfoDto> findCSDetail(FindCPDto findCPDto) {
		// TODO Auto-generated method stub
		List<CSInfoDto> cslist = chargeStationMapper.selectCSDetail(findCPDto);
		return cslist;
	}

}

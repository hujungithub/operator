package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.mapper.ChargePileDetailMapper;
import cn.com.start.webBack.service.ChargePileDetailService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ChargePileDetailServiceImpl implements ChargePileDetailService {

	@Resource
	public ChargePileDetailMapper chargePileDetailMapper;

	/**
	 * 查询充电桩详情
	 */
	@Override
	public List<CPInfoDto> findCPDetail(FindCPDto findCPDto) {
		List<CPInfoDto> cpInfoDto = chargePileDetailMapper
				.selectCPDetail(findCPDto);
		return cpInfoDto;
	}

	@Override
	public List<UserChargeDto> exportChargeDetailList(FindCPDto findCPDto) {
		// TODO Auto-generated method stub
		List<UserChargeDto> userchargelist = chargePileDetailMapper
				.selectexportChargeDetail(findCPDto);
		return userchargelist;
	}

	/**
	 * 充电桩详细
	 */
	@Override
	public List<OperInfoDto> findUserCharge(FindCPDto findCPDto) {
//		int totalCount = chargePileDetailMapper.getUserChargeCount(findCPDto);

//		Page pagedetil = new Page(totalCount, findCPDto.getPageSize(),
//				findCPDto.getPageNow());
//		findCPDto.setStartPos(pagedetil.getStartPos());
//		List<UserChargeDto> userchargeList = chargePileDetailMapper
//				.selectCpCharge(findCPDto);
//		// 查询运营信息 已运行多少天 充电多少次 冲了多少电 收入多少
		List<OperInfoDto> operInfoDto = chargePileDetailMapper
				.selectOperInfo(findCPDto);
//		pagedetil.setList(userchargeList);
//		pagedetil.setAddList(operInfoDto);
		return operInfoDto;
	}
	
	
	
	

	@Override
	public String findLastChargeTime(String cpId) {
		// TODO Auto-generated method stub
		return null;
	}

}

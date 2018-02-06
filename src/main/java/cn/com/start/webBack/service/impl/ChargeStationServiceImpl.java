package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.FindCSInfoDto;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.mapper.ChargeStationMapper;
import cn.com.start.webBack.service.ChargeStationService;
import cn.com.start.webBack.util.Page;
import cn.com.start.webBack.util.TimeUtil;

@Service
@Transactional
public class ChargeStationServiceImpl implements ChargeStationService {
	@Resource
	private ChargeStationMapper chargeStationMapper;

	//*************************************USER*********************************************//
	// 条件查询充电站
	@Override
	public List<CSInfoDto> showChargeStationByPage(FindCSInfoDto findCSInfoDto) {
		Page page = null;
		List<CSInfoDto> onePageChargeStationList = new ArrayList<CSInfoDto>();
		// 查询记录数量
//		int pageCount = chargeStationMapper.getChargeStationCount(findCSInfoDto);
//		page = new Page(pageCount, findCSInfoDto.getPageSize(),
//				findCSInfoDto.getPageNow());         //PageSize和PageNow已经传入findCSInfoDto中
//		findCSInfoDto.setStartPos(page.getStartPos());
		// 查询记录
		onePageChargeStationList = chargeStationMapper
				.selectChargeStationByPage(findCSInfoDto);//xml中查询
//		page.setList(onePageChargeStationList);
		//System.out.println("-----------"+pageCount);
		return onePageChargeStationList;
	}
	
	@Override
	public int selectById(String[] CSIDS) {
		int cpcount = chargeStationMapper.selectById(CSIDS);
		return cpcount;
	}
	
	// 根据CSID删除充电站
	@Override
	public int deleteById(String CSIDS[]) {
		int count = chargeStationMapper.deleteById(CSIDS);
		return count;
	}

	// 根据ID查询充电站
		@Override
		public List<CSInfo> findChargeStationById(String CSID) {
			List<CSInfo> chargeStationDto = chargeStationMapper
					.findChargeStationById(CSID);
			return chargeStationDto;
		}
	
	
		@Override
		public List<AddressDto> findAddressDtoByCSId(String CSID) {
			List<AddressDto> addressDto = chargeStationMapper
					.selectAddressDtoByCSId(CSID);
			return addressDto;
		}

		// 更改充电桩的地址ID
		@Override
		public int updateCPAddressIdByCSId(CSInfo csInfo) {
			int CPcount = chargeStationMapper.updateCPAddressIdByCSId(csInfo);
			return CPcount;
		}

		// 新增充电站
		@Override
		public int insertChargeStation(CSInfo csInfo) {
			int count = chargeStationMapper.insertChargeStation(csInfo);
			return count;
		}
		// 修改充电站
		@Override
		public int updateCSInfo(CSInfo csInfo) {
			int updatecount = chargeStationMapper.updateCSInfo(csInfo);
			return updatecount;
		}
		
		@Override
		public List<CSInfoDto> findcsexport(FindCSInfoDto findCSInfoDto) {
			List<CSInfoDto> csexport = chargeStationMapper
					.selectcsexport(findCSInfoDto);
			return csexport;
		}

	//***********************************************************************************//

	
	// 修改充电桩为不可用
	@Override
	public int updateCPValidFlagByCSId(String CSIDS[]) {
		// TODO Auto-generated method stub
		int CPHEcount = chargeStationMapper.updateCPValidFlagByCSId(CSIDS);
		return CPHEcount;
	}





	
	@Override
	public String findCSAddressId(String csId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CSInfoDto> findCPCharge(FindCPDto findCPDto) {
		
		List<CSInfoDto> chargeList = chargeStationMapper.selectCpCharge(findCPDto);
		TimeUtil.SecToStr1(chargeList);
		
		return chargeList;
	}
	
	// 根据站ID查询站详细 导出需要
	@Override
	public List<CSInfoDto> findCSDetailById(String CSID) {
		List<CSInfoDto> csDto = chargeStationMapper.selectCSDetailById(CSID);
		return csDto;
	}

	@Override
	public List<CSInfoDto> findCSDetail(FindCPDto findCPDto) {
		List<CSInfoDto> cslist = chargeStationMapper.selectCSDetail(findCPDto);
		return cslist;
	}
	
}

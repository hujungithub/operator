package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.TotalDto;
import cn.com.start.webBack.dto.reportsDto;
import cn.com.start.webBack.dto.reportsDtoNew;
import cn.com.start.webBack.mapper.ChargeReportsMapper;
import cn.com.start.webBack.service.ChargeReportsService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ChargeReportsServiceImpl implements ChargeReportsService {
	@Resource
	public ChargeReportsMapper chargeReportsMapper;

	@Override
	public List<reportsDtoNew> showByPage(FindreportsDto findreportsDto){
		List<reportsDtoNew> onePageList = new ArrayList<reportsDtoNew>();
		
		String statisticsMethod = findreportsDto.getStatisticsMethod();
		
		//查询记录
		if("1".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.selectStatisticsByDay(findreportsDto);
		}else if("2".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.selectStatisticsByMonth(findreportsDto);
		}else if("3".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.selectStatisticsByYear(findreportsDto);
		}else if("4".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.selectStatisticsByUser(findreportsDto);
		}else{
			onePageList = chargeReportsMapper.selectStatisticsByDay(findreportsDto);
		}
		return onePageList;
	}
	
	@Override
	public List<TotalDto> findTotalList(FindreportsDto findreportsDto){
		List<TotalDto> totalList = new ArrayList<TotalDto>();
		totalList = chargeReportsMapper.selectTotal(findreportsDto);
		return totalList;
	}
	
	//查询站列表
	@Override
	public List<reportsDtoNew> findcslist(FindreportsDto findreportsDto) {
		List<reportsDtoNew> listcs = chargeReportsMapper.selectcslist(findreportsDto);
		return listcs;
	}

	//查询合计列表
	@Override
	public TotalDto findReportsTotalList(FindreportsDto findreportsDto) {
		String statisticsMethod = findreportsDto.getStatisticsMethod();
		TotalDto totalDto = new TotalDto();
		if(statisticsMethod == "4"){
			totalDto =  chargeReportsMapper.findUserReportsTotal(findreportsDto);
		}else {
			totalDto =  chargeReportsMapper.findReportsTotal(findreportsDto);
		}
		return totalDto;
	}

	//查询记录列表
	@Override
	public List<reportsDtoNew> findReportsList(FindreportsDto findreportsDto) {
		String statisticsMethod = findreportsDto.getStatisticsMethod();
		System.out.println("---------statisticsMethod---------"+statisticsMethod);
		List<reportsDtoNew> onePageList = new ArrayList<reportsDtoNew>();
		if("1".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.findDayReportsList(findreportsDto);
			System.out.println("---------onePageList-----------"+onePageList);
		}else if("2".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.findMonthReportsList(findreportsDto);
		}else if("3".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.findYearReportsList(findreportsDto);
		}else if("4".equals(statisticsMethod)){
			onePageList = chargeReportsMapper.findUserReportsList(findreportsDto);
		}
		return onePageList;
	}

	@Override
	public List<reportsDto> findCSreports(FindreportsDto findreportsDto) {
		List<reportsDto> csList = chargeReportsMapper.findcsList(findreportsDto);
		return csList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public Page showByPage(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		Page page = null;
//		List<reportsDto> onePageList = new ArrayList<reportsDto>();
//		int pageCount = 0;
//		// 查询记录数量
//		if("0".equals(findreportsDto.getCHARGEMETHODID())){
//			pageCount = chargeReportsMapper
//					.getCPCount(findreportsDto);
//		}else if("1".equals(findreportsDto.getCHARGEMETHODID())){
//			pageCount = chargeReportsMapper
//					.getCardCount(findreportsDto);
//			//add by hanmj 20170821 Begin
//		}else if("3".equals(findreportsDto.getCHARGEMETHODID())){
//			pageCount = chargeReportsMapper
//					.getWeChatCount(findreportsDto);
//			//add by hanmj 20170821 End
//		}else if("".equals(findreportsDto.getCHARGEMETHODID())){
//			pageCount = chargeReportsMapper
//					.getAllCount(findreportsDto)
//					+chargeReportsMapper
//					.getWeChatCount(findreportsDto);
//		}
//		//这个也要改 加上微信的记录数
//		/*
//		else if("".equals(findreportsDto.getCHARGEMETHODID())){
//			pageCount = chargeReportsMapper
//					.getAllCount(findreportsDto);
//		}*/
//		
//		
//		page = new Page(pageCount, findreportsDto.getPageSizeInt(),
//				findreportsDto.getPageNowInt());
//		findreportsDto.setStartPos(page.getStartPos());
//		// 查询记录
//		if("0".equals(findreportsDto.getCHARGEMETHODID())){
//			onePageList = chargeReportsMapper
//					.selectByPage(findreportsDto);
//		}else if("1".equals(findreportsDto.getCHARGEMETHODID())){
//			onePageList = chargeReportsMapper
//					.selectcardByPage(findreportsDto);
//		}else if("".equals(findreportsDto.getCHARGEMETHODID())){
//			onePageList = chargeReportsMapper
//					.selectAllByPage(findreportsDto);
//		}
//		page.setList(onePageList);
//		return page;
//	}
//	
//	 /**
//	  * cpuser用户所有的充电站
//	  */
//	@Override
//	public List<reportsDto> findCPUSERCSreports(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> cpusercslist = chargeReportsMapper.selectCPUSERCSreports(findreportsDto);
//		return cpusercslist;
//	}
//	
//	/**
//	 * carduser用户所有充电站
//	 */
//	@Override
//	public List<reportsDto> findCARDUSERCSreports(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> cardusercslist = chargeReportsMapper.selectCARDUSERCSreports(findreportsDto);
//		return cardusercslist;
//	}
//
//	/**
//	 * cpuser查询
//	 */
//	@Override
//	public List<reportsDto> findCPUSERReports(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		
//		List<reportsDto> cpuserList = chargeReportsMapper.selectCPUSERReports(findreportsDto);
//		return cpuserList;
//	}
//
//	/**
//	 * carduser查询
//	 */
//	@Override
//	public List<reportsDto> findCARDUSERReports(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> carduserlist = chargeReportsMapper.selectCARDUSERReports(findreportsDto);
//		return carduserlist;
//	}
//
//
//	@Override
//	public int findusercount(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		int count = chargeReportsMapper.getCount(findreportsDto);
//		return count;
//	}
//
//
//	@Override
//	public List<reportsDto> findCSreports(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> CSList = chargeReportsMapper.selectCSreports(findreportsDto);
//		return CSList;
//	}
//
//	/**
//	 * 查询cpuser总数据
//	 */
//	@Override
//	public List<reportsDto> findCpuserTotalList(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		
//		List<reportsDto> totallist = chargeReportsMapper.selectCpuserTotal(findreportsDto);
//		return totallist;
//	}
//
//	@Override
//	public List<reportsDto> findCarduserTotalList(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> cardtotallist = chargeReportsMapper.selectCarduserTotal(findreportsDto);
//		return cardtotallist;
//	}
//
//	@Override
//	public List<reportsDto> findcslist(FindreportsDto findreportsDto) {
//		// TODO Auto-generated method stub
//		List<reportsDto> listcs = chargeReportsMapper.selectcslist(findreportsDto);
//		return listcs;
//	}
//
//	@Override
//	public List<reportsDto> findAllTotalList(FindreportsDto findreportsDto) {
//		List<reportsDto> Alltotallist = chargeReportsMapper.selectAllTotal(findreportsDto);
//		return Alltotallist;
//	}
//
//	@Override
//	public List<reportsDto> findAllReports(FindreportsDto findreportsDto) {
//		List<reportsDto> Allreports = chargeReportsMapper.selectAllReports(findreportsDto);
//		return Allreports;
//	}
//
//	@Override
//	public List<reportsDto> findAllCSReports(FindreportsDto findreportsDto) {
//		List<reportsDto> Allcs = chargeReportsMapper.selectAllCSReports(findreportsDto);
//		return Allcs;
//	}



}

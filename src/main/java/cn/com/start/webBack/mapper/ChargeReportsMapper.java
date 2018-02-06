package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.TotalDto;
import cn.com.start.webBack.dto.reportsDto;
import cn.com.start.webBack.dto.reportsDtoNew;

public interface ChargeReportsMapper {

	//按日查询记录
	List<reportsDtoNew> selectStatisticsByDay(FindreportsDto findreportsDto);

	//按月查询记录
	List<reportsDtoNew> selectStatisticsByMonth(FindreportsDto findreportsDto);
	
	//按年查询记录
	List<reportsDtoNew> selectStatisticsByYear(FindreportsDto findreportsDto);

	//按用户查询记录
	List<reportsDtoNew> selectStatisticsByUser(FindreportsDto findreportsDto);

	//年月日合计查询
	List<TotalDto> selectTotal(FindreportsDto findreportsDto);

	//用户合计查询
	List<TotalDto> selectUserTotal(FindreportsDto findreportsDto);
	
	//按日查询数量
	int getCountByDay(FindreportsDto findreportsDto);

	//按月查询数量
	int getCountByMonth(FindreportsDto findreportsDto);

	//按年查询数量
	int getCountByYear(FindreportsDto findreportsDto);

	//按用户查询数量
	int getCountByUser(FindreportsDto findreportsDto);

	//查询站列表
	List<reportsDtoNew> selectcslist(FindreportsDto findreportsDto);

	//导出用户合计
	TotalDto findUserReportsTotal(FindreportsDto findreportsDto);

	//导出年月日合计
	TotalDto findReportsTotal(FindreportsDto findreportsDto);

	//导出日记录列表
	List<reportsDtoNew> findDayReportsList(FindreportsDto findreportsDto);

	//导出月记录列表
	List<reportsDtoNew> findMonthReportsList(FindreportsDto findreportsDto);

	//导出年记录列表
	List<reportsDtoNew> findYearReportsList(FindreportsDto findreportsDto);

	//导出用户记录列表
	List<reportsDtoNew> findUserReportsList(FindreportsDto findreportsDto);

	List<reportsDto> findcsList(FindreportsDto findreportsDto);

	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//
//	int getCount(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectByPage(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectCPUSERCSreports(@Param("CPUSERNAME") String CPUSERNAME);
//
//
//	//carduser查询
//	List<reportsDto> selectCARDUSERReports(FindreportsDto findreportsDto);
//	
//	//cpuuser查询
//	List<reportsDto> selectCPUSERReports(FindreportsDto findreportsDto);
//
//	
//	//cpuser用户所有的充电站
//	List<reportsDto> selectCPUSERCSreports(FindreportsDto findreportsDto);
//	
//	//carduser用户所有的充电站
//	List<reportsDto> selectCARDUSERCSreports(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectCSreports(FindreportsDto findreportsDto);
//
//	//查询cpuser用户总数据
//	List<reportsDto> selectCpuserTotal(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectCarduserTotal(FindreportsDto findreportsDto);
//
//	int getCPCount(FindreportsDto findreportsDto);
//
//	int getCardCount(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectcslist(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectcardByPage(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectAllTotal(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectAllReports(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectAllCSReports(FindreportsDto findreportsDto);
//
//	List<reportsDto> selectAllByPage(FindreportsDto findreportsDto);
//
//	int getAllCount(FindreportsDto findreportsDto);
//	
//	
//	int getWeChatCount(FindreportsDto findreportsDto);
//	
//	

}

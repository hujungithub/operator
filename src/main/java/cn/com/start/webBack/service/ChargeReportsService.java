package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.TotalDto;
import cn.com.start.webBack.dto.reportsDto;
import cn.com.start.webBack.dto.reportsDtoNew;
import cn.com.start.webBack.util.Page;

public interface ChargeReportsService {

	List<reportsDtoNew> showByPage(FindreportsDto findreportsDto);
	
	List<reportsDtoNew> findcslist(FindreportsDto findreportsDto);
	
	List<reportsDtoNew> findReportsList(FindreportsDto findreportsDto);
	
	TotalDto findReportsTotalList(FindreportsDto findreportsDto);

	List<TotalDto> findTotalList(FindreportsDto findreportsDto);

	List<reportsDto> findCSreports(FindreportsDto findreportsDto);

}

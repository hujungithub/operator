package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.util.Page;

public interface UserReportsService {
	
	// 查询外部充电记录
	List<userReportsDto> showOuterByPage(FindreportsDto findreportsDto);
	
	List<userReportsDto> showByPage(FindreportsDto findreportsDto);

	List<userReportsDto> findAllreports(FindreportsDto findreportsDto);

	List<userReportsDto> findCardAllreports(FindreportsDto findreportsDto);

	List<userReportsDto> findAll(FindreportsDto findreportsDto);

	List<userReportsDto> findouter(FindreportsDto findreportsDto);

	String findoper(String operatorid);

}

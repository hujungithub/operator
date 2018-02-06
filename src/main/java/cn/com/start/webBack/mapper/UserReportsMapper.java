package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.userReportsDto;

public interface UserReportsMapper {
	
	//查询外部充电记录
	List<userReportsDto> selectOuterCardByPage(FindreportsDto findreportsDto);
	
	int getCount(FindreportsDto findreportsDto);

	List<userReportsDto> selectByPage(FindreportsDto findreportsDto);

	List<userReportsDto> selectAllreports(FindreportsDto findreportsDto);

	int getCardCount(FindreportsDto findreportsDto);

	List<userReportsDto> selectCardByPage(FindreportsDto findreportsDto);

	List<userReportsDto> selectCardAllreports(FindreportsDto findreportsDto);

	int getAllCount(FindreportsDto findreportsDto);

	List<userReportsDto> selectAllByPage(FindreportsDto findreportsDto);

	List<userReportsDto> selectAll(FindreportsDto findreportsDto);

	int getOuterCardCount(FindreportsDto findreportsDto);

	List<userReportsDto> selectouter(FindreportsDto findreportsDto);

	String selectoper(String operatorid);

}

package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.CpyxchangeRecordDto;
import cn.com.start.webBack.dto.FindARDto;

public interface CpfaiMapper {

	// 查询所有
	List<CpyxchangeRecordDto> findAll(FindARDto findARDto);

	// 数量
	int findCpfaiCount(FindARDto findARDto);

	List<CpyxchangeRecordDto> findCpfaiAll(CpyxchangeRecordDto cpfai);

	int update(FindARDto findARDto);

	int updateAll(FindARDto findARDto);

	int findstate0(FindARDto findARDto);
	int findstate1(FindARDto findARDto);

	int findstate(FindARDto findARDto);

	int updatedc(FindARDto findARDto);

	int updateAlldc(FindARDto findARDto);
}

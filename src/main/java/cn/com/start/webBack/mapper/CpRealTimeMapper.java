package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.CpRealTimeDto;
import cn.com.start.webBack.dto.FindCPDto;

public interface CpRealTimeMapper {

	// 根据条件查询cpid
	List<String> selectCPIdList(FindCPDto findCPDto);

	int getCPCount(FindCPDto findCPDto);

	// ////////////
	// 统计充电站
	int findCSCount();

	// 统计充电桩
	int findCPCount();

	// 统计订单
	int findOrderCount(String time);

	// 统计用户
	int findCPUserCount();

	// 统计收入
	int findOrderAmount(String time);

	// 查询 桩
	List<CpRealTimeDto> selectCPRTByPage(@Param("coId") String coId,
			@Param("csId") String csId);

}

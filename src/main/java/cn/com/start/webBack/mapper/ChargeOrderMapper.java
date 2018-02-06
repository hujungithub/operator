package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.FindOrderInfoDto;
import cn.com.start.webBack.dto.OrderInfoDto;

public interface ChargeOrderMapper {

	// 查询充电桩数量
	int getOrderCount(FindOrderInfoDto findOrderInfoDto);

	// 分页查询充电桩
	List<OrderInfoDto> selectOrderByPage(FindOrderInfoDto findOrderInfoDto);
	
	List<String> selectOrderState();
}

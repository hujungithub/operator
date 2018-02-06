package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindOrderInfoDto;
import cn.com.start.webBack.util.Page;

public interface ChargeOrderService {

	Page showOrderByPage(FindOrderInfoDto findOrderInfoDto);
	
	List<String> findOrderState();
}

package cn.com.start.webBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindOrderInfoDto;
import cn.com.start.webBack.dto.OrderInfoDto;
import cn.com.start.webBack.mapper.ChargeOrderMapper;
import cn.com.start.webBack.service.ChargeOrderService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ChargeOrderServiceImpl implements ChargeOrderService{

	@Autowired
	ChargeOrderMapper chargeOrderMapper;
	
	@Override
	public Page showOrderByPage(FindOrderInfoDto findOrderInfoDto) {
		// TODO Auto-generated method stub
		int totalCount = chargeOrderMapper.getOrderCount(findOrderInfoDto);
		List<OrderInfoDto> orderInfoDtoList = chargeOrderMapper.selectOrderByPage(findOrderInfoDto);
		Page page = new Page(totalCount, 10,
				1);
		page.setList(orderInfoDtoList);
		return page;
	}

	@Override
	public List<String> findOrderState() {
		// TODO Auto-generated method stub
		return chargeOrderMapper.selectOrderState();
	}

}

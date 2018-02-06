/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecOrderServiceImpl.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service.impl
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月22日 上午9:16:59
 * @version: V1.0  
 */
package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.mapper.ElecOrderMapper;
import cn.com.start.webBack.service.ElecOrderService;

/**
 * @ClassName: ElecOrderServiceImpl
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月22日 上午9:16:59
 */
@Service
@Transactional
public class ElecOrderServiceImpl implements ElecOrderService{

	@Resource
	private ElecOrderMapper elecOrderMapper;
	/**
	 * @Title: findAllOrders 查找所有订单信息
	 * @Description: TODO
	 * @return
	 * @see cn.com.start.webBack.service.ElecOrderService#findAllOrders()
	 */
	@Override
	public List<ElecOrder> findAllOrders() {
		// TODO 查找所有电工工单信息
		return elecOrderMapper.findAll();
	}

	/**
	 * @Title: deleteOrders
	 * @Description: TODO 根据id删除工单
	 * @param orderId
	 * @return
	 * @see cn.com.start.webBack.service.ElecOrderService#deleteOrders(java.lang.String)
	 */
	@Override
	public int deleteOrders(String[] orderId) {
		// TODO 根据id删除工单
		int flag = elecOrderMapper.deleteOrderById(orderId);
		return flag;
	}

	/**
	 * @Title: findInfoById
	 * @Description: TODO 根据工单id查找工单信息
	 * @param orderid
	 * @return
	 * @see cn.com.start.webBack.service.ElecOrderService#findInfoById(java.lang.String)
	 */
	@Override
	public ElecOrder findInfoById(String orderid) {
		// TODO 根据id查找工单信息
		return elecOrderMapper.findInfoByOrderId(orderid);
	}


	/**
	 * @Title: updateElec
	 * @Description: TODO
	 * @param elecOrder
	 * @return
	 * @see cn.com.start.webBack.service.ElecOrderService#updateElec(cn.com.start.webBack.entity.ElecOrder)
	 */
	@Override
	public int updateElec(ElecOrder elecOrder) {
		// TODO 更改工单电工姓名及号码
		int flag = elecOrderMapper.updateElec(elecOrder);
		return flag;
	}

	/**
	 * @Title: updateOrderInfo
	 * @Description: TODO
	 * @param orderid
	 * @return
	 * @see cn.com.start.webBack.service.ElecOrderService#updateOrderInfo(java.lang.String)
	 */
	@Override
	public int updateOrderInfo(String orderid) {
		// TODO 审核
		int flag = elecOrderMapper.updateOrderInfo(orderid);
		return flag;
	}

}

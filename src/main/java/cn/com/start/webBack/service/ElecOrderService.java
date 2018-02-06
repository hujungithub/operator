/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecOrderService.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月22日 上午9:18:10
 * @version: V1.0  
 */
package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.entity.ElecOrder;

/**
 * @ClassName: ElecOrderService
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月22日 上午9:18:10
 */
public interface ElecOrderService {

	// 查找所有工单信息
	public List<ElecOrder> findAllOrders();

	/** @Title: deleteOrders
	 * @Description: TODO
	 * @param orderId
	 * @return
	 * @return: int
	 */
	public int deleteOrders(String[] orderId);

	/** @Title: findInfoById
	 * @Description: TODO 根据工单id查找工单信息
	 * @param orderid
	 * @return
	 * @return: ElecOrder
	 */
	public ElecOrder findInfoById(String orderid);

	/** @Title: updateOrderInfo
	 * @Description: TODO 更改工单信息
	 * @param orderid
	 * @return
	 * @return: int
	 */
	public int updateOrderInfo(String orderid);

	/** @Title: updateElec
	 * @Description: TODO 
	 * @param elecOrder
	 * @return
	 * @return: int
	 */
	public int updateElec(ElecOrder elecOrder);
}

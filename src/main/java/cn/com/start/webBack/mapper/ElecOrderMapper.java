/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecOrderMapper.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.mapper
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月22日 上午9:18:55
 * @version: V1.0  
 */
package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.entity.ElecOrder;

/**
 * @ClassName: ElecOrderMapper
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月22日 上午9:18:55
 */
public interface ElecOrderMapper {

	/** @Title: findAll
	 * @Description: TODO
	 * @return
	 * @return: List<ElecOrder>
	 */
	List<ElecOrder> findAll();

	/** @Title: deleteOrderById
	 * @Description: TODO 根据id删除工单信息
	 * @param orderId
	 * @return
	 * @return: int
	 */
	int deleteOrderById(String[] orderId);

	/** @Title: findInfoByOrderId
	 * @Description: TODO 根据id查找工单信息
	 * @param orderid
	 * @return
	 * @return: ElecOrder
	 */
	ElecOrder findInfoByOrderId(String orderid);

	/** @Title: updateOrderInfo
	 * @Description: TODO 更改工单信息
	 * @param orderid
	 * @return
	 * @return: int
	 */
	int updateOrderInfo(String orderid);

	/** @Title: updateElec
	 * @Description: TODO
	 * @param elecOrder
	 * @return
	 * @return: int
	 */
	int updateElec(ElecOrder elecOrder);

}

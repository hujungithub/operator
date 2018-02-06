/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecService.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月18日 下午3:15:09
 * @version: V1.0  
 */
package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.entity.Electrician;

/**
 * @ClassName: ElecService
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月18日 下午3:15:09
 */
public interface ElecService {

	// 查找电工信息列表
	public List<Electrician> findAll();
	
	// 根据id查找电工信息
	public Electrician findInfoById(String elecid);
	
	// 修改用户信息
	public int updateElec(Electrician electrician);
	
	// 添加电工信息
	public int addElecInfo(Electrician electrician);
	
	// 根据id删除电工
	public int deleteElec(String elecid[]);

	/** @Title: findInfoByOrderId
	 * @Description: TODO
	 * @param orderid
	 * @return
	 * @return: ElecOrder
	 */
	public ElecOrder findInfoByOrderId(String orderid);

	/** @Title: checkElecInfo
	 * @Description: TODO
	 * @param elecids
	 * @return
	 * @return: int
	 */

	/** @Title: checkElecInfo
	 * @Description: TODO 根据电工id审核信息
	 * @param elecid
	 * @return
	 * @return: int
	 */
	public int checkElecInfo(String elecid);
}

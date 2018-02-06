/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecMapper.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.mapper
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月18日 下午3:16:00
 * @version: V1.0  
 */
package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.entity.Electrician;

/**
 * @ClassName: ElecMapper
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月18日 下午3:16:00
 */
public interface ElecMapper {

	/** @Title: findElecInfo 查询所有电工信息
	 * @Description: TODO
	 * @return
	 * @return: List<Electrician>
	 */
	List<Electrician> findElecInfo();

	/** @Title: findInfoById
	 * @Description: TODO
	 * @return
	 * @return: Electrician
	 */
	Electrician findInfoById(String elecid);

	/** @Title: updateElec 更改电工信息
	 * @Description: TODO
	 * @param electrician
	 * @return
	 * @return: int
	 */
	int updateElec(Electrician electrician);

	/** @Title: insertElecInfo
	 * @Description: TODO 添加电工信息
	 * @param electrician
	 * @return
	 * @return: int
	 */
	int insertElecInfo(Electrician electrician);

	/** @Title: deleteElec
	 * @Description: TODO 根据id删除电工信息
	 * @param elecid
	 * @return
	 * @return: int
	 */
	int deleteElec(String elecid[]);

	/** @Title: findInfoByOrderId
	 * @Description: TODO
	 * @param orderid
	 * @return
	 * @return: ElecOrder
	 */
	ElecOrder findInfoByOrderId(String orderid);

	/** @Title: checkElecInfoById
	 * @Description: TODO 根据电工id审核信息
	 * @param elecid
	 * @return
	 * @return: int
	 */
	int checkElecInfoById(String elecid);

}

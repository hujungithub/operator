/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecServiceImpl.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service.impl
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月18日 下午3:15:27
 * @version: V1.0  
 */
package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.entity.Electrician;
import cn.com.start.webBack.mapper.ElecMapper;
import cn.com.start.webBack.service.ElecService;

/**
 * @ClassName: ElecServiceImpl
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月18日 下午3:15:27
 */
@Service
@Transactional
public class ElecServiceImpl implements ElecService{

	@Resource
	private ElecMapper elecMapper;
	/**
	 * @Title: findAll 查找所有电工信息
	 * @Description: TODO
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#findAll()
	 */
	@Override
	public List<Electrician> findAll() {
		// TODO 查询电工信息
		List<Electrician> list = elecMapper.findElecInfo();
		return list;
	}
	/**
	 * @Title: findInfoById
	 * @Description: TODO 根据id查找电工信息
	 * @param elecid
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#findInfoById(java.lang.String)
	 */
	@Override
	public Electrician findInfoById(String elecid) {
		
		return elecMapper.findInfoById(elecid);
	}
	/**
	 * @Title: updateElec
	 * @Description: TODO
	 * @param electrician
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#updateElec(cn.com.start.webBack.entity.Electrician)
	 */
	@Override
	public int updateElec(Electrician electrician) {
		// TODO 更改电工信息
		int flag = elecMapper.updateElec(electrician);
		return flag;
	}
	/**
	 * @Title: addElecInfo
	 * @Description: TODO
	 * @param electrician
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#addElecInfo(cn.com.start.webBack.entity.Electrician)
	 */
	@Override
	public int addElecInfo(Electrician electrician) {
		// TODO 添加电工信息
		return elecMapper.insertElecInfo(electrician);
	}
	/**
	 * @Title: deleteElec
	 * @Description: TODO
	 * @param elecid
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#deleteElec(java.lang.String[])
	 */
	@Override
	public int deleteElec(String[] elecid) {
		int flag = elecMapper.deleteElec(elecid);
		return flag;
	}
	/**
	 * @Title: findInfoByOrderId
	 * @Description: TODO
	 * @param orderid
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#findInfoByOrderId(java.lang.String)
	 */
	@Override
	public ElecOrder findInfoByOrderId(String orderid) {
		// TODO 根据工单id查找工单信息
		return elecMapper.findInfoByOrderId(orderid);
	}
	/**
	 * @Title: checkElecInfo
	 * @Description: TODO 根据电工id审核信息
	 * @param elecid
	 * @return
	 * @see cn.com.start.webBack.service.ElecService#checkElecInfo(java.lang.String)
	 */
	@Override
	public int checkElecInfo(String elecid) {
		// TODO Auto-generated method stub
		return elecMapper.checkElecInfoById(elecid);
	}

}

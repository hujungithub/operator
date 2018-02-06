/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JsonServiceImpl.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service.impl
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 下午2:58:36
 * @version: V1.0  
 */
package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;

import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.webBack.entity.WebAlarmOperation;
import cn.com.start.webBack.mapper.JsonMapper;
import cn.com.start.webBack.service.JsonService;

/**
 * @ClassName: JsonServiceImpl
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 下午2:58:36
 */
@Service("jsonService")
@Transactional
public class JsonServiceImpl implements JsonService{

	@Resource
	private JsonMapper jsonMapper;
	/**
	 * @Title: addStudents
	 * @Description: TODO
	 * @param webAlarm
	 * @see cn.com.start.webBack.service.JsonService#addStudents(cn.com.start.DPF.entity.WebAlarmRecord)
	 */
	@Override
	public void addWebAlarm(WebAlarmOperation webAlarm) {
		jsonMapper.insertWebAlarm(webAlarm);
	}
	/**
	 * @Title: findAll
	 * @Description: TODO
	 * @return
	 * @see cn.com.start.webBack.service.JsonService#findAll()
	 */
	@Override
	public List<WebAlarmOperation> findAll() {
		// TODO 查找所有的告警记录
		return jsonMapper.findAll();
	}
	/**
	 * @Title: findByRecordTime
	 * @Description: TODO 根据记录时间查找记录
	 * @param recordtime
	 * @return
	 * @see cn.com.start.webBack.service.JsonService#findByRecordTime(java.lang.String)
	 */
	@Override
	public WebAlarmOperation findByRecordTime(String recordtime) {
		// TODO 根据记录时间查找记录
		return jsonMapper.findByRecordTime(recordtime);
	}
	/**
	 * @Title: updatePushStatus
	 * @Description: TODO
	 * @param recordtime
	 * @return
	 * @see cn.com.start.webBack.service.JsonService#updatePushStatus(java.lang.String)
	 */
	@Override
	public int updatePushStatus(String recordtime) {
		// TODO 推送成功更改状态
		return jsonMapper.updatePushStatus(recordtime);
	}

}

/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JsonMapper.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.mapper
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 下午3:12:55
 * @version: V1.0  
 */
package cn.com.start.webBack.mapper;

import java.util.List;

import com.google.gson.JsonElement;

import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.webBack.entity.WebAlarmOperation;

/**
 * @ClassName: JsonMapper
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 下午3:12:55
 */
public interface JsonMapper {

	/** @Title: insertWebAlarm
	 * @Description: TODO
	 * @param webAlarm
	 * @return: void
	 */
	void insertWebAlarm(WebAlarmOperation webAlarm);

	/** @Title: findAll
	 * @Description: TODO
	 * @return
	 * @return: List<WebAlarmRecord>
	 */
	List<WebAlarmOperation> findAll();

	/** @Title: findByRecordTime
	 * @Description: TODO 根据记录时间查找记录
	 * @param recordtime
	 * @return
	 */
	WebAlarmOperation findByRecordTime(String recordtime);

	/** @Title: updatePushStatus
	 * @Description: TODO
	 * @param recordtime
	 * @return
	 * @return: int
	 */
	int updatePushStatus(String recordtime);

}

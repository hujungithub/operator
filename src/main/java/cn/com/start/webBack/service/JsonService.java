/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JsonService.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 下午2:57:35
 * @version: V1.0  
 */
package cn.com.start.webBack.service;

import java.util.List;
import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.webBack.entity.WebAlarmOperation;

/**
 * @ClassName: JsonService
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 下午2:57:35
 */
public interface JsonService {

	/** @Title: addStudents
	 * @Description: TODO
	 * @param webAlarm
	 * @return: void
	 */
	void addWebAlarm(WebAlarmOperation webAlarm);

	/** @Title: findAll
	 * @Description: TODO
	 * @return
	 * @return: List<WebAlarmRecord>
	 */
	List<WebAlarmOperation> findAll();

	/** @Title: findByRecordTime
	 * @Description: TODO 根据记录时间查找数据库中是否有数据
	 * @param string
	 * @return
	 * @return: int
	 */
	WebAlarmOperation findByRecordTime(String recordtime);

	/** @Title: updatePushStatus
	 * @Description: TODO 根据记录时间修改状态信息
	 * @param recordtime
	 * @return
	 * @return: int
	 */
	int updatePushStatus(String recordtime);
	
	
	
	
	
}

/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JpushService.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 上午10:48:27
 * @version: V1.0  
 */
package cn.com.start.webBack.service;

import cn.com.start.webBack.entity.WebAlarmOperation;

/**
 * @ClassName: JpushService
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 上午10:48:27
 */
public interface JpushService {

	/*
	 * @Title: pushSystemMessage
	 * @Description: TODO 采用极光推送,推送活动及系统消息
	 * @return: void
	 */
	public void pushSystemMessage(String orderid);
	
	// 自动推送故障数据
	public void autoPushSystemMessage(WebAlarmOperation webAlarmOperation);

	/** @Title: pushMessageByElecid
	 * @Description: TODO
	 * @param elecid
	 * @return: void
	 */
	public void pushMessageByElecid(String elecid);
}

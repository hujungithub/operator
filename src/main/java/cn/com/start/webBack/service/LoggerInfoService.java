/**  
 * Copyright © 2017上海强辰. All rights reserved.
 *
 * @Title: LoggerInfoService.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.service
 * @Description: TODO
 * @author: niehangyou  
 * @date: 2017-11-8 下午1:55:48
 * @version: V1.0  
 */
package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.util.Page;

/**
 * @ClassName: LoggerInfoService
 * @Description: TODO
 * @author: niehangyou
 * @date: 2017-11-8 下午1:55:48
 */
public interface LoggerInfoService {
	
	public void insertLoggerInfo(LoggerInfoDto loggerInfoDto);


	/* @Title: findLoggerInfoByPage
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @return
	 * @return: Page
	 */
	public List<LoggerInfoDto> findLoggerInfoByPage(LoggerInfoDto loggerInfoDto);
}

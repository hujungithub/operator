/**  
 * Copyright © 2017上海强辰. All rights reserved.
 *
 * @Title: LoggerInfoMapper.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.mapper
 * @Description: TODO
 * @author: niehangyou  
 * @date: 2017-11-8 下午2:03:34
 * @version: V1.0  
 */
package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.LoggerInfoDto;

/**
 * @ClassName: LoggerInfoMapper
 * @Description: TODO
 * @author: niehangyou
 * @date: 2017-11-8 下午2:03:34
 */
public interface LoggerInfoMapper {

	/* @Title: insertInfo
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @return: int
	 */
	int insertInfo(LoggerInfoDto loggerInfoDto);

	/* @Title: findLoggerInfoCount
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @return
	 * @return: int
	 */
	 int findLoggerInfoCount(LoggerInfoDto loggerInfoDto);
		

	/* @Title: findLoggerInfoByPage
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @return
	 * @return: List<LoggerInfoDto>
	 */
	List<LoggerInfoDto> findLoggerInfoByPage(LoggerInfoDto loggerInfoDto);
		

}

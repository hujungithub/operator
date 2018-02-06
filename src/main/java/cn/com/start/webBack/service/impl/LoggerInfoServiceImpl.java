/**  
 * Copyright © 2017上海强辰. All rights reserved.
 *
 * @Title: LoggerInfoServiceImpl.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.service.impl
 * @Description: TODO
 * @author: niehangyou  
 * @date: 2017-11-8 下午2:02:34
 * @version: V1.0  
 */
package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.mapper.LoggerInfoMapper;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.util.Page;

/**
 * @ClassName: LoggerInfoServiceImpl
 * @Description: TODO
 * @author: niehangyou
 * @date: 2017-11-8 下午2:02:34
 */
@Service
@Transactional
public class LoggerInfoServiceImpl implements LoggerInfoService {

	@Resource
	public LoggerInfoMapper loggerInfoMapper;

	/**
	 * @Title: insertLoggerInfo
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @see LoggerInfoDto
	 */
	//@Override
	public void insertLoggerInfo(LoggerInfoDto loggerInfoDto) {
		loggerInfoMapper.insertInfo(loggerInfoDto);
	}

	/**
	 * @Title: findLoggerInfoByPage
	 * @Description: TODO
	 * @param loggerInfoDto
	 * @return
	 * @see LoggerInfoDto
	 */
	@Override
	public List<LoggerInfoDto> findLoggerInfoByPage(LoggerInfoDto loggerInfoDto) {
		/*Page page = null;
		//查询数量
		int totalCount = loggerInfoMapper.findLoggerInfoCount(loggerInfoDto);
		page = new Page(totalCount, loggerInfoDto.getPageSize(),loggerInfoDto.getPageNow());
		loggerInfoDto.setStartPos(page.getStartPos());*/
		//查询记录
		List<LoggerInfoDto> loggerList = loggerInfoMapper.findLoggerInfoByPage(loggerInfoDto);
		//放入page返回controller层
		/*page.setList(loggerList);*/
		return loggerList;
	}
}

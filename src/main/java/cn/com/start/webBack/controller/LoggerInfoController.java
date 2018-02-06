/**  
 * Copyright © 2017上海强辰. All rights reserved.
 *
 * @Title: LogginInfoController.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.controller
 * @Description: TODO
 * @author: niehangyou  
 * @date: 2017-11-9 下午5:43:36
 * @version: V1.0  
 */
package cn.com.start.webBack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

/**
 * @ClassName: LogginInfoController
 * @Description: TODO
 * @author: niehangyou
 * @date: 2017-11-9 下午5:43:36
 */
@Controller
@RequestMapping("/logger")
public class LoggerInfoController {


	@Autowired
	private LoggerInfoService loggerInfoService;
	@Autowired
	private OperatorService operatorService;
	
	@RequestMapping("/findLoggerInfoFirst")	
	public void findLoggerInfoFirst(HttpServletRequest request,HttpServletResponse response,LoggerInfoDto loggerInfoDto) throws IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		// 查询运营商
		/*List<OperatorInfo> operList = operatorService.findNewOperator(operatorid);*/
		//查询日志
		List<LoggerInfoDto> list = loggerInfoService.findLoggerInfoByPage(loggerInfoDto);
		
		if(list.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", list);
		}
		new JsonUtil().send(response, ReDto);
	}
	/**
	 * @Description 查询数据
	 * @param operatorid,fromtime,totime
	 * @return json
	 */
	/*@ResponseBody
	@RequestMapping("/findLoggerSavaData")
	public String findLoggerSavaDate(@RequestParam int pageSize,@RequestParam int pageNow
			,LoggerInfoDto loggerInfoDto,@RequestParam String operatorloginid) throws IOException {
		loggerInfoDto.setOPERATORLOGINID(operatorloginid);
		loggerInfoDto.setPageSize(pageSize);
		loggerInfoDto.setPageNow(pageNow);
		Page page = loggerInfoService.findLoggerInfoByPage(loggerInfoDto);
		String json = JsonUtil.toJson(page);
		return json;
	}*/
	
}

/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecController.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.controller
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月18日 下午2:52:53
 * @version: V1.0  
 */
package cn.com.start.webBack.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HttpServletBean;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.entity.Electrician;
import cn.com.start.webBack.service.ElecService;
import cn.com.start.webBack.service.JpushService;

/**
 * @ClassName: ElecController
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月18日 下午2:52:53
 */
@Controller
@RequestMapping("/elec")
public class ElecController {

	@Resource
	private ElecService elecService;
	
	@Resource
	private JpushService jpushService;
	/**
	 * @Title: findAll 查找所有电工信息
	 * @Description: TODO
	 * @param response
	 * @throws IOException
	 * @return: void
	 */
	@RequestMapping("findAll")
	public void findAll(HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		List<Electrician> list = elecService.findAll();
		ReDto.detail.put("page", list);
		send(response,ReDto);
	}
	
	@RequestMapping("/findInfoById")
	public void findInfoById(HttpServletResponse response,@RequestParam String elecid) throws IOException {
		Electrician electrician = elecService.findInfoById(elecid);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(electrician);
		// 向页面返回json数据
		System.out.println("-----json-----"+json);
		out.print(json);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateInfo")
	public void updateInfo(HttpServletResponse response,Electrician electrician) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		int flag = elecService.updateElec(electrician);
		if(flag == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "更新成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "更新失败！请重试！";
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: toAddElec
	 * @Description: TODO 跳转到添加页面
	 * @return
	 * @return: String
	 */
	@RequestMapping("/toAddElec")
	public String toAddElec() {
		return "//jsp/elec/elecAdd.jsp";
	}
	
	/**
	 * @Title: addElecInfo
	 * @Description: TODO 添加电工信息
	 * @return
	 * @return: int
	 * @throws IOException 
	 */
	@RequestMapping("/addElecInfo")
	public void addElecInfo(HttpServletResponse response,Electrician electrician) throws IOException {
		int flag = elecService.addElecInfo(electrician);
		JsonReDto ReDto = new JsonReDto();
		if(flag == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: deleteElec
	 * @Description: TODO 根据电工id删除电工信息
	 * @param response
	 * @param elecid
	 * @return: void
	 * @throws IOException 
	 */
	@RequestMapping("/deleteElec")
	public void deleteElec(HttpServletResponse response,@RequestParam String elecid) throws IOException {
		String[] elecids = elecid.substring(1).split(",");
		int flag = elecService.deleteElec(elecids);
		JsonReDto ReDto = new JsonReDto();
		if(flag >= 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功！";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！请重试！";
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: checkElecInfo
	 * @Description: TODO 单独审核电工信息
	 * @param response
	 * @param elecid
	 * @throws IOException
	 * @return: void
	 */
	@RequestMapping("/updateElecInfo")
	public void checkElecInfo(HttpServletResponse response,@RequestParam String elecid) throws IOException{
		int flag = elecService.checkElecInfo(elecid);
		JsonReDto ReDto = new JsonReDto();
		if(flag == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "审核成功！";
			jpushService.pushMessageByElecid(elecid);
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "审核失败！请重试！";
		}
		send(response,ReDto);
	}
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}
}

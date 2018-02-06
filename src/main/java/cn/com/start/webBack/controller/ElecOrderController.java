/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecOrderController.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.controller
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月19日 下午5:45:06
 * @version: V1.0  
 */
package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.service.ElecOrderService;
import cn.com.start.webBack.service.JpushService;

/**
 * @ClassName: ElecOrderController
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月19日 下午5:45:06
 */
@Controller
@RequestMapping("/elecOrder")
public class ElecOrderController extends BaseController{
	
	@Resource
	private ElecOrderService elecOrderService;
	
	@Resource
	private JpushService jpushService;
	/**
	 * @Title: findAllOrders
	 * @Description: TODO 查找所有的工单列表信息
	 * @param response
	 * @throws IOException
	 * @return: void
	 */
	@RequestMapping("/findAllOrders")
	public void findAllOrders(HttpServletResponse response) throws IOException{
		JsonReDto ReDto = new JsonReDto();
		List<ElecOrder> list = elecOrderService.findAllOrders();
		if(list.size() >= 0) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", list);
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";	
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: deleteOrders
	 * @Description: TODO 删除工单信息
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/deleteOrders")
	public void deleteOrders(HttpServletResponse response,@RequestParam String orderids) throws Exception {
		JsonReDto ReDto = new JsonReDto();
		String[] orderid = orderids.substring(1).split(",");
		int flag = elecOrderService.deleteOrders(orderid);
		if(flag >=1 ) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";	
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: findInfoById
	 * @Description: TODO 根据工单id查找工单信息
	 * @param response
	 * @param orderid
	 * @return: void
	 * @throws Exception 
	 */
	@RequestMapping("/findInfoById")
	public void findInfoById(HttpServletResponse response,@RequestParam String orderid) throws Exception {
		ElecOrder elecOrder = elecOrderService.findInfoById(orderid);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(elecOrder);
		// 向页面返回json数据
		System.out.println("-----json-----"+json);
		out.print(json);
		out.flush();
		out.close();
		
	}
	
	/**
	 * @Title: updateOrderInfo
	 * @Description: TODO 更改工单信息
	 * @param response
	 * @param elecOrder
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping("/updateOrderInfo")
	public void updateOrderInfo(HttpServletResponse response,@RequestParam String orderid) throws Exception {
		ElecOrder elecOrder = elecOrderService.findInfoById(orderid);
		JsonReDto ReDto = new JsonReDto();
		int flag = 0;
		if("0".equals(elecOrder.getSTATUS()) || "1".equals(elecOrder.getSTATUS())) {
			jpushService.pushSystemMessage(orderid);
			 flag = elecOrderService.updateOrderInfo(orderid);
		}
		if(flag == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "审核成功";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "审核失败！";	
		}
		send(response,ReDto);
	}
	
	/**
	 * @Title: push
	 * @Description: TODO 批量推送审核信息
	 * @param orderids
	 * @return: void
	 * @throws IOException 
	 */
	@RequestMapping("/pushCheck")
	public void push(HttpServletResponse response,@RequestParam String orderids) throws IOException {
		String[] orderid2 = orderids.substring(1).split(",");
		JsonReDto ReDto = new JsonReDto();
		int flag = 0;
		System.out.println(flag);
		for (String orderid : orderid2) {
			// 推送
			flag = elecOrderService.updateOrderInfo(orderid);
			jpushService.pushSystemMessage(orderid);
			// 更改状态,懒得去service改,在这里直接调用,怎么简单怎么来
		}
		if(flag == 1) {
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "审核成功";
		}else {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "审核失败！";	
		}
		send(response,ReDto);
	}
	
	private static <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
}

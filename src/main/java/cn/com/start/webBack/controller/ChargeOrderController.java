package cn.com.start.webBack.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.webBack.dto.AppointInfoDto;
import cn.com.start.webBack.dto.FindOrderInfoDto;
import cn.com.start.webBack.service.ChargeOrderService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

/**
 * 
 * @author hanmj
 *
 */

@Controller
@RequestMapping("/order")
public class ChargeOrderController extends BaseController {

	@Autowired
	ChargeOrderService chargeOrderService;
	@Autowired
	private RoleactionService roleactionService;
	
	// 首次进入页面 查询辅助数据
	@RequestMapping("/findOrderFirst")
	public String findOrderByPage(HttpServletRequest request,
			@RequestParam String operatorid, @RequestParam String roleid,
			FindOrderInfoDto findOrderInfoDto) {
		
		Page page = chargeOrderService.showOrderByPage(findOrderInfoDto);
		
		List<String>orderStateList = chargeOrderService.findOrderState();
		String roleaction = roleactionService.findroleaction(roleid);// 登录用户角色能进行的操作
		
		request.setAttribute("roleaction", roleaction);
		request.setAttribute("orderStateList", orderStateList);
		
		request.setAttribute("page", page);
		return "//jsp/orderManage/chargeOrderManage.jsp";
	}
	
	//findAppointInfoSaveData
		// 保存查询条件 分页查询 切换页码
		@ResponseBody
		@RequestMapping("/findOrderInfoSaveData")
		public String findOrderInfoSaveData(@RequestParam int pageSize,
				@RequestParam int pageNow, FindOrderInfoDto findOrderInfoDto) throws IOException {
			findOrderInfoDto.setPageNow(pageNow);
			findOrderInfoDto.setPageSize(pageSize);
			Page page = chargeOrderService.showOrderByPage(findOrderInfoDto);
			page.setPageNow(pageNow);
			page.setPageSize(pageSize);
			String json = JsonUtil.toJson(page);
			logger.info("findOrderInfoSaveData=" + json);
			return json;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}

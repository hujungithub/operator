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
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.service.ChargeAppointService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/appoint")
public class ChargeAppointController extends BaseController {

	@Autowired
	private ChargeAppointService chargeAppointService;
	
	@Autowired
	private RoleactionService roleactionService;
	// 首次进入页面 查询辅助数据
	@RequestMapping("/findAppointFirst")
	public String findAppointByPage(HttpServletRequest request,
			@RequestParam String operatorid, @RequestParam String roleid,AppointInfoDto appointInfoDto) {
		
		System.out.println(roleid);
		System.out.println(operatorid);
		Page page = chargeAppointService.showAppointByPage(appointInfoDto);
		String roleaction = roleactionService.findroleaction(roleid);// 登录用户角色能进行的操作
		List<String> appointStateList = chargeAppointService.findAppointState();
		request.setAttribute("roleaction", roleaction);
		request.setAttribute("appointStateList", appointStateList);
		request.setAttribute("page", page);
		System.out.println(page);
		logger.info("findAppointFirst=" + page);
		return "//jsp/orderManage/chargeAppointManage.jsp";
	}
	
	// 保存查询条件 分页查询 切换页码
	@ResponseBody
	@RequestMapping("/findAppointInfoSaveData")
	public String findAppointInfoSaveData(@RequestParam int pageSize,
			@RequestParam int pageNow, AppointInfoDto appointInfoDto) throws IOException {
		appointInfoDto.setPageNow(pageNow);
		appointInfoDto.setPageSize(pageSize);
		Page page = chargeAppointService.showAppointByPage(appointInfoDto);
		/****/
		String json = JsonUtil.toJson(page);
		logger.info("findAppointInfoSaveData=" + json);
		return json;
	}
	
	
	
	
	
	
	
	
	
	
	
}

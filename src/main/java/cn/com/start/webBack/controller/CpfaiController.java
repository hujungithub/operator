package cn.com.start.webBack.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.service.CpfaiService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/cpfai")
public class CpfaiController extends BaseController {

	@Autowired
	private CpfaiService cpfaiservice;
	
	/**
	 * 第一次 同步查询
	 * @param operatorid
	 * @param roleid
	 * @param model
	 * @return
	 */
	@RequestMapping("/findBytj")
	public String findBytj(@RequestParam String operatorid,@RequestParam String roleid,Model model) {
		FindARDto findARDto = new FindARDto();
		findARDto.setPageNow(1);
		findARDto.setPageSize(10);
		findARDto.setOPERATORLOGINID(operatorid);
		findARDto.setROLELOGINID(roleid);
		int statecount = cpfaiservice.findstate(findARDto);
		int statecount0 = cpfaiservice.findstate0(findARDto);
		int statecount1 = cpfaiservice.findstate1(findARDto);

		Page page = cpfaiservice.findAll(findARDto);
		model.addAttribute("page", page);
		model.addAttribute("statecount0", statecount0);
		model.addAttribute("statecount1", statecount1);
		model.addAttribute("statecount", statecount);
		return "//jsp/systemMonitor/cpfai.jsp";
	}

	/**
	 * 状态修改
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/findUpdate")
	public String findUpdate(HttpServletRequest request) {
		String checks = request.getParameter("checkstate");
		String checkm = request.getParameter("checkmode");
		String ids = request.getParameter("id");
		String cptype = request.getParameter("cptype");

		int checkstate = Integer.valueOf(checks).intValue();
		int checkmode = Integer.valueOf(checkm).intValue();
		int id = Integer.valueOf(ids).intValue();
		FindARDto findARDto = new FindARDto();
		findARDto.setCHECKMODE(checkmode);
		findARDto.setCHECKSTATE(checkstate);
		findARDto.setID(id);
		// 0为直流，1为交流
		if ("0".equals(cptype)) {
			cpfaiservice.updatedc(findARDto);
		} else if ("1".equals(cptype)) {
			cpfaiservice.update(findARDto);
		}
		return "/cpfai/findBytj";
	}

	/**
	 * 状态修改全部
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAllUpdate")
	public String findAllUpdate(HttpServletRequest request) {
		String checks = request.getParameter("checkstate");
		String checkm = request.getParameter("checkmode");
		String operatorid = request.getParameter("operatorid");
		int checkstate = Integer.valueOf(checks).intValue();
		int checkmode = Integer.valueOf(checkm).intValue();
		FindARDto findARDto = new FindARDto();
		findARDto.setCHECKMODE(checkmode);
		findARDto.setCHECKSTATE(checkstate);
		findARDto.setOPERATORLOGINID(operatorid);
		// 0为直流，1为交流
		cpfaiservice.updateAlldc(findARDto);
		cpfaiservice.updateAll(findARDto);
		return "/cpfai/findBytj";
	}

	/**
	 * 保存查询条件
	 * 
	 * @param request
	 * @param response
	 * @param findARDto
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/findSaveData")
	public String findByPage(FindARDto findARDto)
			throws IOException {
		Page page = cpfaiservice.findAll(findARDto);
		String json = JsonUtil.toJson(page);
		logger.info("findSaveData="+json);
		return json;

	}
}

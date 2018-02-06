package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.DPF.aio.SendBytes;
import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.dto.WebAlarmRecordDto;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.WebAlarmService;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/webAlarm")
public class WebAlarmController {

	@Autowired
	private WebAlarmService webAlarmService;
	@Autowired
	private OperatorService operatorService;

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param cpfai
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findAlarmRecordFirst")
	public void findAlarmRecordFirst(HttpServletResponse response,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindARDto findARDto = new FindARDto();
		findARDto.setOPERATORLOGINID(operatorloginid);

		int noCheckCount = webAlarmService.findNoCheckCount(findARDto);
		int checkedCount = webAlarmService.findCheckedCount(findARDto);
		List<WebAlarmRecordDto> recordList = webAlarmService.findSaveWebData(findARDto);
		
		ReDto.detail.put("page", recordList);
		send(response, ReDto);
	}

	@RequestMapping("/findCountAjax")
	public void findCountAjax(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String operatorid = request.getParameter("OPERATORID");
		int count = webAlarmService.findCountAjax(operatorid);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(count);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
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
		String operatorid = request.getParameter("operatorid");

		int checkstate = Integer.valueOf(checks).intValue();
		int checkmode = Integer.valueOf(checkm).intValue();
		int id = Integer.valueOf(ids).intValue();
		FindARDto findARDto = new FindARDto();
		findARDto.setCHECKMODE(checkmode);
		findARDto.setCHECKSTATE(checkstate);
		findARDto.setID(id);
		findARDto.setOPERATORLOGINID(operatorid);
		int count = webAlarmService.updateAlarmRecord(findARDto);
		return "/webAlarm/findAlarmRecordFirst";
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
		int count = webAlarmService.updateAllAlarmRecord(findARDto);
		return "/webAlarm/findAlarmRecordFirst";
	}

	/**
//	 * 保存查询条件
//	 * 
//	 * @param request
//	 * @param response
//	 * @param findARDto
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findSaveData")
//	public String findByPage(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindARDto findARDto)
//			throws IOException {
//		findARDto.setPageNow(pageNow);
//		findARDto.setPageSize(pageSize);
//		Page page = webAlarmService.findSaveWebData(findARDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}
	
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

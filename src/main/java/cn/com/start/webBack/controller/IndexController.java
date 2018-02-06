package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.webBack.dto.FindIndexDto;
import cn.com.start.webBack.dto.IndexDto;
import cn.com.start.webBack.dto.StatisticDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.IndexService;
import cn.com.start.webBack.service.OperatorService;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private OperatorService operatorService;
	/**
	 * 统计运营总信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/findTotalStatistic")
	public String findTotalStatistic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String operatorloginid = request.getParameter("operatorloginid");// 获取登录用户运营商id
		// String roleloginid = request.getParameter("roleid");// 获取登录用户角色id
		Calendar date= Calendar.getInstance();
		int dateyear = date.get(Calendar.YEAR);
		int datemonth = date.get(Calendar.MONTH)+1;
		
		IndexDto indexDto = indexService.findIndexDto(operatorloginid);
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);// 获取boss及其下属运营商
		request.setAttribute("indexDto", indexDto);
		request.setAttribute("operList", newoperList);
		request.setAttribute("dateyear", dateyear);
		request.setAttribute("datemonth", datemonth);
			
		return "//jsp/SM/dashboard-2.jsp";
	}

	/**
	 * 充电收入统计
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getIncomeStatistic")
	public void getIncomeStatistic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FindIndexDto findIndexDto = new FindIndexDto();
		String operatorid = request.getParameter("operatorid"); // 34
		String year = request.getParameter("year"); // 2017_4
		String month = request.getParameter("month");
		String day = request.getParameter("day"); // 30
		findIndexDto.setOPERATORID(operatorid);
		findIndexDto.setDAY(Integer.parseInt(day));
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(year + "-");
		if (Integer.parseInt(month) < 10) {
			sBuffer.append("0" + month);
		} else {
			sBuffer.append(month);
		}
		findIndexDto.setFROMDATE(sBuffer.append("-01").toString());
		findIndexDto.setTODATE(sBuffer
				.delete(sBuffer.length() - 3, sBuffer.length())
				.append("-" + day).toString());
		int xAxis[] = new int[findIndexDto.getDAY()];
		for (int i = 0; i < findIndexDto.getDAY(); i++) {
			xAxis[i] = i + 1;
		}
		float yAxis[] = indexService.findIncomeStatistic(findIndexDto);
		StatisticDto statisticDto = new StatisticDto();
		statisticDto.setxAxis(xAxis);
		statisticDto.setyAxis(yAxis);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(statisticDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 充电次数统计
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getCountStatistic")
	public void getCountStatistic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FindIndexDto findIndexDto = new FindIndexDto();
		String operatorid = request.getParameter("operatorid"); // 34
		String year = request.getParameter("year"); // 2017_4
		String month = request.getParameter("month");
		String day = request.getParameter("day"); // 30
		findIndexDto.setOPERATORID(operatorid);
		findIndexDto.setDAY(Integer.parseInt(day));
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(year + "-");
		if (Integer.parseInt(month) < 10) {
			sBuffer.append("0" + month);
		} else {
			sBuffer.append(month);
		}
		findIndexDto.setFROMDATE(sBuffer.append("-01").toString());
		findIndexDto.setTODATE(sBuffer
				.delete(sBuffer.length() - 3, sBuffer.length())
				.append("-" + day).toString());
		int xAxis[] = new int[findIndexDto.getDAY()];
		for (int i = 0; i < findIndexDto.getDAY(); i++) {
			xAxis[i] = i + 1;
		}
		int yAxis[] = indexService.findCountStatistic(findIndexDto);
		StatisticDto statisticDto = new StatisticDto();
		statisticDto.setxAxis(xAxis);
		statisticDto.setyAxisc(yAxis);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(statisticDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 充电电量统计
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getChargeStatistic")
	public void getChargeStatistic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FindIndexDto findIndexDto = new FindIndexDto();
		String operatorid = request.getParameter("operatorid"); // 34
		String year = request.getParameter("year"); // 2017_4
		String month = request.getParameter("month");
		String day = request.getParameter("day"); // 30
		findIndexDto.setOPERATORID(operatorid);
		findIndexDto.setDAY(Integer.parseInt(day));
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(year + "-");
		if (Integer.parseInt(month) < 10) {
			sBuffer.append("0" + month);
		} else {
			sBuffer.append(month);
		}
		findIndexDto.setFROMDATE(sBuffer.append("-01").toString());
		findIndexDto.setTODATE(sBuffer
				.delete(sBuffer.length() - 3, sBuffer.length())
				.append("-" + day).toString());
		int xAxis[] = new int[findIndexDto.getDAY()];
		for (int i = 0; i < findIndexDto.getDAY(); i++) {
			xAxis[i] = i + 1;
		}
		float yAxis[] = indexService.findChargeStatistic(findIndexDto);
		StatisticDto statisticDto = new StatisticDto();
		statisticDto.setxAxis(xAxis);
		statisticDto.setyAxis(yAxis);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(statisticDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
}

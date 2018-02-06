package cn.com.start.webBack.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.StatisticsCpService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/statisticscp")
public class StatisticsCpController extends LoggerController {
	@Autowired
	private StatisticsCpService statisticsCpService;
	@Autowired
	private OperatorService operatorService;

	/**
	 * 首次进入页面
	 */
	@RequestMapping("findCpFirst")
	public String findCpFirst(HttpServletRequest request) {
		FindreportsDto findreportsDto = new FindreportsDto();
		String operatorloginid = request.getParameter("operatorid");// 获取登录用户运营商id
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);
		findreportsDto.setPageNow(1);
		findreportsDto.setPageSize(10);
		findreportsDto.setOPERATORLOGINID(operatorloginid);
		Page page = statisticsCpService.showByPage(findreportsDto);
		request.setAttribute("page", page);
		request.setAttribute("operList", newoperList);
		return "//jsp/statistics/statisticscpmanage.jsp";
	}

	/**
	 * 保存查询条件 分页
	 * 
	 * @param request
	 * @param response
	 * @param addressDto
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/findSaveData")
	public String findSavaData(@RequestParam Integer pageNow,
			@RequestParam Integer pageSize, FindreportsDto findreportsDto)
			throws IOException {
		// 截取点击太快产生的5,5 10,10
		findreportsDto.setPageNow(pageNow);
		findreportsDto.setPageSize(pageSize);
		Page page = statisticsCpService.showByPage(findreportsDto);
		String json = JsonUtil.toJson(page);
		logger.info("findSaveData=" + json);
		return json;
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/cpExport")
	@ResponseBody
	public void Export(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		List<UserChargeDto> cpreports = new ArrayList<UserChargeDto>();
		List<UserChargeDto> cpcount = new ArrayList<UserChargeDto>();
		cpreports = statisticsCpService.findCpAllreports(findreportsDto);

		cpcount = statisticsCpService.findCpAll(findreportsDto);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		String opername = statisticsCpService.findoper(findreportsDto
				.getOPERATORID());
		String formdate = findreportsDto.getFROMDATE();
		String todate = findreportsDto.getTODATE();

		usermap.put("opername", opername);
		usermap.put("formdate", formdate);
		usermap.put("todate", todate);
		dataList.add(usermap);
		URL url = this.getClass().getClassLoader().getResource("");
		String templateFileName = "excel/cptemplate.xlsx";
		String resultFileName = "excel/充电桩统计.xlsx";
		new ExcelUtil().createExcel(templateFileName, cpreports, cpcount,
				dataList, resultFileName);

		String destFilePath = url.getPath() + resultFileName;
		download(destFilePath, response); // 浏览器上提示下载s
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}

}

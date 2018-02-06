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
import cn.com.start.webBack.service.StatisticsCsService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/statisticscs")
public class StatisticsCsController extends LoggerController {
	@Autowired
	private StatisticsCsService statisticsCsService;

	@Autowired
	private OperatorService operatorService;

	/**
	 * 首次进入页面
	 */
	@RequestMapping("findCsFirst")
	public String findCsFirst(@RequestParam String operatorid,
			HttpServletRequest request) {
		FindreportsDto findreportsDto = new FindreportsDto();
		findreportsDto.setPageNow(1);
		findreportsDto.setPageSize(10);
		findreportsDto.setOPERATORLOGINID(operatorid);
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorid);
		Page page = statisticsCsService.showByPage(findreportsDto);
		request.setAttribute("page", page);
		request.setAttribute("operList", newoperList);
		return "//jsp/statistics/statisticscsmanage.jsp";
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
	public String findSavaData(@RequestParam Integer pageSize,
			@RequestParam Integer pageNow, FindreportsDto findreportsDto)
			throws IOException {
		findreportsDto.setPageNow(pageNow);
		findreportsDto.setPageSize(pageSize);
		Page page = statisticsCsService.showByPage(findreportsDto);
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
	@RequestMapping("/csExport")
	@ResponseBody
	public void Export(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		List<UserChargeDto> csreports = new ArrayList<UserChargeDto>();
		List<UserChargeDto> cscount = new ArrayList<UserChargeDto>();
		csreports = statisticsCsService.findCsAllreports(findreportsDto);

		cscount = statisticsCsService.findCsAll(findreportsDto);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		String opername = statisticsCsService.findoper(findreportsDto
				.getOPERATORID());
		String formdate = findreportsDto.getFROMDATE();
		String todate = findreportsDto.getTODATE();

		usermap.put("opername", opername);
		usermap.put("formdate", formdate);
		usermap.put("todate", todate);
		dataList.add(usermap);

		URL url = this.getClass().getClassLoader().getResource("");
		String templateFileName = "excel/cstemplate.xlsx";
		String resultFileName = "excel/充电站统计.xlsx";
		new ExcelUtil().createExcel(templateFileName, csreports, cscount,
				dataList, resultFileName);

		String destFilePath = url.getPath() + resultFileName;
		download(destFilePath, response); // 浏览器上提示下载s
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}

}

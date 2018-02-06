package cn.com.start.webBack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
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
import cn.com.start.webBack.service.StatisticsOperService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/statisticsoper")
public class StatisticsOperController extends LoggerController{
	@Autowired
	private StatisticsOperService statisticsOperService;

	/**
	 * 首次进入页面
	 */
	@RequestMapping("findOperFirst")
	public String findOperFirst(HttpServletRequest request,
			@RequestParam String operatorid) {
		FindreportsDto findreportsDto = new FindreportsDto();
		findreportsDto.setPageNow(1);
		findreportsDto.setPageSize(10);
		findreportsDto.setOPERATORLOGINID(operatorid);
		Page page = statisticsOperService.showByPage(findreportsDto);
		request.setAttribute("page", page);
		return "//jsp/statistics/statisticsopermanage.jsp";
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
		// 截取点击太快产生的5,5 10,10
		findreportsDto.setPageNow(pageNow);
		findreportsDto.setPageSize(pageSize);

		Page page = statisticsOperService.showByPage(findreportsDto);
		String json = JsonUtil.toJson(page);
		return json;
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/operExport")
	@ResponseBody
	public void Export(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		List<UserChargeDto> operreports = new ArrayList<UserChargeDto>();
		List<UserChargeDto> opercount = new ArrayList<UserChargeDto>();
		operreports = statisticsOperService.findOperAllreports(findreportsDto);

		opercount = statisticsOperService.findOperAll(findreportsDto);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		String opername = findreportsDto.getOPERATORNAME();
		String operid = findreportsDto.getOPERATORID();
		String formdate = findreportsDto.getFROMDATE();
		String todate = findreportsDto.getTODATE();

		usermap.put("opername", opername);
		usermap.put("operid", operid);
		usermap.put("formdate", formdate);
		usermap.put("todate", todate);

		dataList.add(usermap);

		URL url = this.getClass().getClassLoader().getResource("");
		String templateFileName = "excel/opertemplate.xlsx";

		String resultFileName = "excel/运营商统计.xlsx";
		new ExcelUtil().createExcel(templateFileName, operreports, opercount,
				dataList, resultFileName);

		String destFilePath = url.getPath() + resultFileName;
		download(destFilePath, response); // 浏览器上提示下载s
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}

}

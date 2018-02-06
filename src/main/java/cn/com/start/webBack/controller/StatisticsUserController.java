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
import cn.com.start.webBack.service.StatisticsUserService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/statisticsuser")
public class StatisticsUserController extends LoggerController{
	@Autowired
	private StatisticsUserService statisticsUserService;

	/**
	 * 首次进入页面
	 */
	@RequestMapping("findUserFirst")
	public String findUserFirst(HttpServletRequest request) {
		FindreportsDto findreportsDto = new FindreportsDto();
		findreportsDto.setPageNow(1);
		findreportsDto.setPageSize(10);
		findreportsDto.setCHARGEMETHODID("");
		Page page = statisticsUserService.showByPage(findreportsDto);
		request.setAttribute("page", page);
		return "//jsp/statistics/statisticsusermanage.jsp";
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
			@RequestParam Integer pageNow, @RequestParam String CHARGEMETHODID,
			FindreportsDto findreportsDto) throws IOException {
		// 截取点击太快产生的5,5 10,10

		findreportsDto.setPageNow(pageNow);
		findreportsDto.setPageSize(pageSize);
		findreportsDto.setCHARGEMETHODID(CHARGEMETHODID);

		Page page = statisticsUserService.showByPage(findreportsDto);
		String json = JsonUtil.toJson(page);
		return json;

	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/userExport")
	@ResponseBody
	public void Export(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		List<UserChargeDto> userreports = new ArrayList<UserChargeDto>();
		List<UserChargeDto> usercount = new ArrayList<UserChargeDto>();
		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			userreports = statisticsUserService
					.findCpAllreports(findreportsDto);
		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			userreports = statisticsUserService
					.findCardAllreports(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			userreports = statisticsUserService.findAllreports(findreportsDto);
		}

		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			usercount = statisticsUserService.findCpAll(findreportsDto);
		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			usercount = statisticsUserService.findCardAll(findreportsDto);
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			usercount = statisticsUserService.findAll(findreportsDto);
		}

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		String chargemethodid = "";
		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
			chargemethodid = "扫码";
		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
			chargemethodid = "刷卡";
		} else if ("".equals(findreportsDto.getCHARGEMETHODID())) {
			chargemethodid = "全部";
		}
		String cpuserid = findreportsDto.getCPUSERID();
		String cpusername = findreportsDto.getCPUSERNAME();
		String formdate = findreportsDto.getFROMDATE();
		String todate = findreportsDto.getTODATE();

		usermap.put("chargemethodid", chargemethodid);
		usermap.put("cpuserid", cpuserid);
		usermap.put("cpusername", cpusername);
		usermap.put("formdate", formdate);
		usermap.put("todate", todate);

		dataList.add(usermap);

		System.out.println("查询条件的list------" + dataList);
		URL url = this.getClass().getClassLoader().getResource("");
		String templateFileName = "excel/usertemplate.xlsx";

		String resultFileName = "excel/用户统计.xlsx";
		new ExcelUtil().createExcel(templateFileName, userreports, usercount,
				dataList, resultFileName);

		String destFilePath = url.getPath() + resultFileName;
		download(destFilePath, response); // 浏览器上提示下载s
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}


}

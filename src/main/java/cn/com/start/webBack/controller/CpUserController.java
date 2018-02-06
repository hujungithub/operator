package cn.com.start.webBack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.AppUserChargeRecordDto;
import cn.com.start.webBack.dto.CpUserDto;
import cn.com.start.webBack.dto.FindCpUserDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.service.CpUserService;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/cpUser")
public class CpUserController extends LoggerController{

	@Autowired
	private CpUserService cpUserService;
	@Autowired
	private RoleactionService roleactionService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	/**
	 * 第一次查询app充值记录
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findAPPUCFirst")
	public void findAPPUCFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindCpUserDto findCpUserDto = new FindCpUserDto();
		findCpUserDto.setPageNow(1);
		findCpUserDto.setPageSize(10);
		List<AppUserChargeRecordDto> appUCDtoList = cpUserService.findAppUCRecord(findCpUserDto);
		ReDto.detail.put("page",appUCDtoList);
		send(response, ReDto);
//		request.setAttribute("page", page);
//		return "//jsp/operManage/appUCRecord.jsp";
	}

//	/**
//	 * 条件查询app充值记录
//	 * 
//	 * @param request
//	 * @param response
//	 * @param findCpUserDto
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findAPPUCSaveData")
//	public String findAPPUCSaveData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindCpUserDto findCpUserDto)
//			throws IOException {
//		// 截取点击太快产生的5,5 10,10
//		
//		findCpUserDto.setPageNow(pageNow);
//		findCpUserDto.setPageSize(pageSize);
//		Page page = cpUserService.findAppUCRecord(findCpUserDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}

	/**
	 * 数据导出 app充电记录 导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/appucExport")
	@ResponseBody
	public void appucExport(HttpServletRequest request,
			HttpServletResponse response, FindCpUserDto findCpUserDto)
			throws IOException {
		List<AppUserChargeRecordDto> appList = cpUserService
				.findApplist(findCpUserDto);

		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "用户名");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "手机号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充值金额（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "余额（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "操作时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "支付方式");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充值结果");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < appList.size(); i++) {
			dataItem = new HashMap<String, Object>();
			// CpUser user = (CpUser) cpusers.get(i);
			AppUserChargeRecordDto userDto = appList.get(i);
			dataItem.put("XH1", "" + userDto.getCPUSERNAME());
			dataItem.put("XH2", "" + userDto.getTELEPHONE());
			dataItem.put("XH3", "" + userDto.getRECHARGEMONEY());
			dataItem.put("XH4", "" + userDto.getBALANCE());
			dataItem.put("XH5", "" + userDto.getRECHARGETIME());
			dataItem.put("XH6", "" + userDto.getPAYMENTMODENAME());
			dataItem.put("XH7", "" + userDto.getPAYRESULT());
			dataList.add(dataItem);
		}
		System.out.println("datalist------" + dataList);
		POIUtil.exportExcel2FilePath("app充值记录", "D://app充值记录.xls",
				headInfoList, dataList);
		download("D://app充值记录.xls", response);
		DeleteFileUtil.deleteFile("D://app充值记录.xls");// 删除保存的excel文件
	}

	/**
	 * 分页查询|用户管理
	 * 
	 * @param request
	 * @param model
	 * @param cpuser
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findUserFirst")
	public void findUserFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindCpUserDto findCpUserDto = new FindCpUserDto();
		List<CpUserDto> onePageUserList = cpUserService.showUserByPage(findCpUserDto);
		ReDto.detail.put("page",onePageUserList);
		send(response, ReDto);
	}

//	/**
//	 * 
//	 * 查询保存条件
//	 * 
//	 * @param request
//	 * @param response
//	 * @param cpfai
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findCPUserSaveData")
//	public String findCPUserSaveData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindCpUserDto findCpUserDto)
//			throws IOException {
//		findCpUserDto.setPageNow(pageNow);
//		findCpUserDto.setPageSize(pageSize);
//		Page page = cpUserService.showUserByPage(findCpUserDto);
//		String json = JsonUtil.toJson(page);
//		logger.info("findcpuserdto=="+json);
//		return json;
//	}

	/**
	 * 获取修改页面的信息
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findUpdate")
	public void findUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String CPUSERID = request.getParameter("CPUSERID");
		CpUser cpuser = cpUserService.findUserById(CPUSERID);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cpuser);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 修改用户数据
	 * 
	 * @param cpuser
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/userUpdate")
	public void userUpdate(HttpServletRequest request,HttpServletResponse response, CpUser cpuser) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		cpuser.setVALIDFLAG("1");
		int updatecount = cpUserService.updateById(cpuser);
		if(updatecount > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(cpuser.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改app用户");
			loggerInfoDto.setOPERATIONOBJECT(cpuser.getCPUSERID());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！";
		}
		send(response, ReDto);
	}

	/**
	 * 删除用户数据
	 * 
	 * @param cpuser
	 * @return
	 */
	@RequestMapping("/delUserById")
	public String delUserById(HttpServletRequest request) {
		String userid = request.getParameter("CPUSERID");
		String userids[] = userid.substring(1).split(",");

		int count = cpUserService.deleteById(userids);
		request.setAttribute("delcoun", count);
		return "/cpUser/findUserFirst";
	}

	/**
	 * 详细页面
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findCpuserDetail")
	public void findCpuserDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String cpuserid = request.getParameter("CPUSERID");
		FindCpUserDto findCpUserDto = new FindCpUserDto();
		findCpUserDto.setCPUSERID(cpuserid);

		List<userReportsDto> list = cpUserService.findCpuserCharge(findCpUserDto);

		/*CpUser cpuser = cpUserService.findUserById(cpuserid);*/
		List<CpUser> cpuser = cpUserService.findUserDetail(cpuserid);
		
		if(cpuser.size() == 0 && list.size()==0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", cpuser);
			ReDto.detail.put("list", list);
		}
		send(response, ReDto);
		/*request.setAttribute("page", page);
		request.setAttribute("cpuser", cpuser);
		return "//jsp/userManage/cpUserDetail.jsp";*/
	}

	/**
	 * 获取详细信息
	 * 
	 * @param request
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("/findDetail")
	public String findDetail(@RequestParam Integer pageSize,
			@RequestParam Integer pageNow, FindCpUserDto findCpUserDto)
			throws IOException {
		findCpUserDto.setPageNow(pageNow);
		findCpUserDto.setPageSize(pageSize);

		Page page = cpUserService.findCpuserCharge(findCpUserDto);
		String json = JsonUtil.toJson(page);
		return json;
	}*/

	/**
	 * 数据导出 用户 导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/cpuserMQExport")
	@ResponseBody
	public void cpuserMQExport(HttpServletRequest request,
			HttpServletResponse response, FindCpUserDto findCpUserDto)
			throws IOException {
		List<userReportsDto> cpuserlist = cpUserService
				.findCpuserMQ(findCpUserDto);

		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();

		itemMap.put("title", "运营商");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电站");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "桩编号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "开始时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "结束时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电时长");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电电量（kWh）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "服务费（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "基础电费（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电总费用（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH10");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < cpuserlist.size(); i++) {
			dataItem = new HashMap<String, Object>();
			// CpUser user = (CpUser) cpusers.get(i);
			userReportsDto userDto = cpuserlist.get(i);
			dataItem.put("XH1", "" + userDto.getOPERATORNAME());
			dataItem.put("XH2", "" + userDto.getCSNAME());
			dataItem.put("XH3", "" + userDto.getCPID());
			dataItem.put("XH4", "" + userDto.getCHARGESTARTTIME());
			dataItem.put("XH5", "" + userDto.getCHARGEENDTIME());
			dataItem.put("XH6", "" + userDto.getCHARGETIMESPAN());
			dataItem.put("XH7", "" + userDto.getCHARGEQUANTITY());
			dataItem.put(
					"XH8",
					""
							+ new java.text.DecimalFormat("0.0000")
									.format(userDto.getSERVICETIP()));
			dataItem.put(
					"XH9",
					""
							+ new java.text.DecimalFormat("0.0000")
									.format(userDto.getCHARGEMONEY()));
			dataItem.put(
					"XH10",
					""
							+ new java.text.DecimalFormat("0.0000")
									.format(userDto.getDEDUCTMONEY()));
			dataList.add(dataItem);
		}
		System.out.println("datalist------" + dataList);
		POIUtil.exportExcel2FilePath("用户桩充电记录", "D://用户桩充电记录.xls",
				headInfoList, dataList);
		download("D://用户桩充电记录.xls", response);
		DeleteFileUtil.deleteFile("D://用户桩充电记录.xls");// 删除保存的excel文件
	}

	private <T> void send(HttpServletResponse response, T ReDto)
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

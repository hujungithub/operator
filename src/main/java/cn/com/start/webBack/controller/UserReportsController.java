package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.UserReportsService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.POIUtil;

@Controller
@RequestMapping("/userreports")
public class UserReportsController extends LoggerController{
	@Autowired
	private UserReportsService userReportsService;
	@Autowired
	private OperatorService operatorService;

	// 外部充电记录
	@RequestMapping("/findExternalUCRFirst")
	public void findExternalUCRFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindreportsDto findreportsDto = new FindreportsDto();
		String operatorloginid = request.getParameter("operatorloginid");// 获取登录用户运营商id
		findreportsDto.setCHARGEMETHODID("");
		findreportsDto.setOPERATORLOGINID(operatorloginid);
		List<userReportsDto> onePageList = userReportsService.showOuterByPage(findreportsDto);
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);
		ReDto.detail.put("page",onePageList);
		send(response, ReDto);
//		request.setAttribute("operList", newoperList);
//		request.setAttribute("page", page);
//		return "//jsp/operManage/externalUCRManage.jsp";
	}

	// 外部充电记录 异步
//	@ResponseBody
//	@RequestMapping("/findExternalUCR")
//	public String findExternalUCR(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindreportsDto findreportsDto)
//			throws IOException {
//		// 截取点击太快产生的5,5 10,10
//
//		findreportsDto.setPageNow(pageNow);
//		findreportsDto.setPageSize(pageSize);
//
//		Page page = userReportsService.showOuterByPage(findreportsDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//
//	}

	/**
	 * 充电记录
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findReportsFirst")
	public void findReportsFirst(HttpServletRequest request,HttpServletResponse response
			,String chargeMethodId) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		long a = System.currentTimeMillis();
		FindreportsDto findreportsDto = new FindreportsDto();
		String operatorloginid = request.getParameter("operatorloginid");// 获取登录用户运营商id
		/*findreportsDto.setCHARGEMETHODID(chargeMethodId);*/
		findreportsDto.setOPERATORLOGINID(operatorloginid);
		List<userReportsDto> onePageList = userReportsService.showByPage(findreportsDto);
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);
		ReDto.detail.put("page",onePageList);
		send(response, ReDto);
//		request.setAttribute("operList", newoperList);
//		request.setAttribute("page", page);
//		long b = System.currentTimeMillis();
//		logger.info("用时多久："+ (b-a) +"毫秒");
//		return "//jsp/operManage/userReportsManage.jsp";
	}

//	/**
//	 * 保存查询条件 分页
//	 * 
//	 * @param request
//	 * @param response
//	 * @param addressDto
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findSaveData")
//	public String findSavaData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindreportsDto findreportsDto)
//			throws IOException {
//		// 截取点击太快产生的5,5 10,10
//
//		System.out.println("nimaa a aaaaa");
//
//		findreportsDto.setPageNow(pageNow);
//		findreportsDto.setPageSize(pageSize);
//
//		Page page = userReportsService.showByPage(findreportsDto);
//		String json = JsonUtil.toJson(page);
//		logger.info("findsave==="+json);
//		return json;
//	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/userreportExport")
	@ResponseBody
	public void Export(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		List<userReportsDto> userreports = new ArrayList<userReportsDto>();
//		if ("0".equals(findreportsDto.getCHARGEMETHODID())) {
//			userreports = userReportsService.findAllreports(findreportsDto);
//		} else if ("1".equals(findreportsDto.getCHARGEMETHODID())) {
//			userreports = userReportsService.findCardAllreports(findreportsDto);
//		} else {
		if(findreportsDto.getCHARGEMETHODNAME().equals("扫") || findreportsDto.getCHARGEMETHODNAME().equals("码")
				|| findreportsDto.getCHARGEMETHODNAME().equals("扫码")) {
			findreportsDto.setCHARGEMETHODID("0");
			userreports = userReportsService.findAllreports(findreportsDto);
		}else if(findreportsDto.getCHARGEMETHODNAME().equals("刷") || findreportsDto.getCHARGEMETHODNAME().equals("卡")
				|| findreportsDto.getCHARGEMETHODNAME().equals("刷卡")) {
			findreportsDto.setCHARGEMETHODID("1");
			userreports = userReportsService.findCardAllreports(findreportsDto);
		}else{
			userreports = userReportsService.findAll(findreportsDto);
		}
//		}

		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "运营商名称");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "站点名称");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电桩序列号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电类型");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电模式");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "停机原因");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "交易状态");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电开始时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电结束时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电卡号/用户ID");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH10");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "订单编号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH11");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "用户姓名");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH12");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "手机号码");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH13");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "证件号码");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH14");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "车牌号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH15");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "VIN号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH16");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电电量（kWh）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH17");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电站编号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH18");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电总金额（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH19");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "服务费（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH20");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "基础电费（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH21");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电时长");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH22");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电前金额（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH23");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电后金额（元）");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH24");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < userreports.size(); i++) {
			dataItem = new HashMap<String, Object>();
			userReportsDto user = userreports.get(i);
			dataItem.put("XH1", "" + user.getOPERATORNAME());
			dataItem.put("XH2", "" + user.getCSNAME());

			dataItem.put("XH3", "" + user.getDEVICEID());
			dataItem.put("XH4", "" + user.getCHARGEMETHODNAME());
			dataItem.put("XH5", "" + user.getCHARGEMODENAME());
			dataItem.put("XH6", "" + user.getCHARGEENDCAUSE());
			dataItem.put("XH7", "" + user.getDEDUCTSUCCESSFLAG());
			dataItem.put("XH8", "" + user.getCHARGESTARTTIME());
			dataItem.put("XH9", "" + user.getCHARGEENDTIME());
			dataItem.put("XH10", "" + user.getCPUSERID());
			dataItem.put("XH11", "" + user.getTRANSATIONID());
			dataItem.put("XH12", "" + user.getCPUSERNAME());
			dataItem.put("XH13", "" + user.getTELEPHONE());
			dataItem.put("XH14", "" + user.getIDENTITYCARDNUM());
			dataItem.put("XH15", "" + user.getPLATENUMBER());

			if (user.getVIN() == null) {
				dataItem.put("XH16", "");

			} else {
				dataItem.put("XH16", "" + user.getVIN());

			}

			dataItem.put("XH17", "" + user.getCHARGEQUANTITY());
			dataItem.put("XH18", "" + user.getCSID());
			dataItem.put(
					"XH19",
					""
							+ new java.text.DecimalFormat("0.0000").format(user
									.getDEDUCTMONEY()));
			dataItem.put(
					"XH20",
					""
							+ new java.text.DecimalFormat("0.0000").format(user
									.getSERVICETIP()));
			dataItem.put(
					"XH21",
					""
							+ new java.text.DecimalFormat("0.0000").format(user
									.getCHARGEMONEY()));
			dataItem.put("XH22", "" + user.getCHARGETIMESPAN());
			dataItem.put(
					"XH23",
					""
							+ new java.text.DecimalFormat("0.0000").format(user
									.getACCOUNTSUM()));
			dataItem.put(
					"XH24",
					""
							+ new java.text.DecimalFormat("0.0000").format(user
									.getREMAINMONEY()));
			dataList.add(dataItem);
		}

		System.out.println("headInfoList--------" + headInfoList);
		POIUtil.exportExcel2FilePath("用户充电记录", "D://用户充电记录.xls", headInfoList,
				dataList);// 导出excel保存的路径
		download("D://用户充电记录.xls", response); // 浏览器上提示下载
		DeleteFileUtil.deleteFile("D://用户充电记录.xls");// 删除保存的excel文件
	}

	/**
	 * 外部充电数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/ExternalUCRExport")
	@ResponseBody
	public void ExternalUCRExport(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {

		List<userReportsDto> userreports = userReportsService
				.findouter(findreportsDto);// 我的数据源
		List<userReportsDto> list1 = new ArrayList<>();
		URL url = this.getClass().getClassLoader().getResource("");
		String templateFileName = "excel/userreports.xlsx";
		String resultFileName = "excel/外部充电记录.xlsx";

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		String opername = userReportsService.findoper(findreportsDto
				.getOPERATORID());
		String cpusername = findreportsDto.getCPUSERNAME();
		String telephone = findreportsDto.getTELEPHONE();
		String formdate = findreportsDto.getFROMDATE();
		String todate = findreportsDto.getTODATE();

		usermap.put("opername", opername);
		usermap.put("cpusername", cpusername);
		usermap.put("telephone", telephone);
		usermap.put("formdate", formdate);
		usermap.put("todate", todate);
		dataList.add(usermap);

		new ExcelUtil().createExcel(templateFileName, userreports, list1,
				dataList, resultFileName);

		String destFilePath = url.getPath() + resultFileName;
		download(destFilePath, response); // 浏览器上提示下载s
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}

	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
//		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}
	
}

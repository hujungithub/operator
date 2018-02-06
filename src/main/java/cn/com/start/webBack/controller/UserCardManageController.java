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
import java.text.DateFormat;
import java.text.DecimalFormat;
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
import cn.com.start.webBack.dto.CardUserDto;
import cn.com.start.webBack.dto.FindCardUserDto;
import cn.com.start.webBack.dto.FindRechargeRecordDto;
import cn.com.start.webBack.dto.FindUserCardChargeDto;
import cn.com.start.webBack.dto.FindUserCardIssueRecordDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.ModifyMoneyRecord;
import cn.com.start.webBack.dto.ReportLostDto;
import cn.com.start.webBack.dto.UserCardChargeDto;
import cn.com.start.webBack.dto.UserCardIssueRecordDto;
import cn.com.start.webBack.dto.UserCardRechargeDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.service.UserCardManageService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/userCard")
public class UserCardManageController extends LoggerController{
	@Autowired
	private UserCardManageService userCardManageService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private RoleactionService roleactionService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	/**
	 * 首次进入页面
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findUserCardFirst")
	public void findUserCardByPage(HttpServletRequest request,HttpServletResponse response
			,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<OperatorInfo> operList = operatorService
				.findNewOperator(operatorloginid);
		request.setAttribute("OPERLIST", operList);
		FindCardUserDto findCardUserDto = new FindCardUserDto();
		findCardUserDto.setOPERATORLOGINID(operatorloginid);
		findCardUserDto.setPageNow(1);
		findCardUserDto.setPageSize(10);
		List<CardUserDto> onePageList = userCardManageService.showByPage(findCardUserDto);
		
		ReDto.detail.put("page", onePageList);
		send(response, ReDto);
//		request.setAttribute("page", page);
//		request.setAttribute("roleaction", roleaction);
//		return "//jsp/cardIssue/userCardManage.jsp";
	}

//	/**
//	 * 保存查询条件，分页
//	 * @param pageSize
//	 * @param pageNow
//	 * @param findCardUserDto
//	 * @return
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findUserCardSaveData")
//	public String findUserCardSaveData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindCardUserDto findCardUserDto)
//			throws IOException {
//		findCardUserDto.setPageNow(pageNow);
//		findCardUserDto.setPageSize(pageSize);
//		Page page = userCardManageService.showByPage(findCardUserDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}
	
	
//	/**
//	 * 保存查询条件，分页
//	 * @param pageSize
//	 * @param pageNow
//	 * @param findCardUserDto
//	 * @return
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/findUserCardSaveData_1")
//	public String findUserCardSaveData_1(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindCardUserDto findCardUserDto)
//			throws IOException {
//		findCardUserDto.setPageNow(pageNow);
//		findCardUserDto.setPageSize(pageSize);
//		Page page = userCardManageService.showByPage(findCardUserDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}
	
	/**
	 * 查询修改信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/findupdateUsercard")
	public void findupdateUsercard(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String CARDNUM = request.getParameter("CARDNUM");
		FindCardUserDto findCardUserDto = new FindCardUserDto();
		findCardUserDto.setCARDNUM(CARDNUM);
		CardUserDto cardUserDto = userCardManageService
				.findupdateUsercard(findCardUserDto);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cardUserDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 修改用户
	 * 
	 * @param request
	 * @param cardUserDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateusercard")
	public void updateusercard(HttpServletRequest request,HttpServletResponse response
			,CardUserDto cardUserDto) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		int updatecount = userCardManageService.updateusercard(cardUserDto);
		if(updatecount > 0){
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			loggerInfoDto.setOPERATINGUSER(cardUserDto.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改卡用户");
			loggerInfoDto.setOPERATIONOBJECT(cardUserDto.getCARDNUM());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			send(response, ReDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！请重新操作！";
			send(response, ReDto);
		}
	}

	/**
	 * 查询修改余额信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/findUpdateBalance")
	public void findUpdateBalance(HttpServletRequest request,
			HttpServletResponse response,@RequestParam String CARDNUM) throws IOException {
		FindCardUserDto findCardUserDto = new FindCardUserDto();
		findCardUserDto.setCARDNUM(CARDNUM);
		CardUserDto cardUserDto = userCardManageService
				.findupdateUsercard(findCardUserDto);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cardUserDto);
		// 向页面返回json数据
		System.out.println("before update userinfo" + json);
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 修改用户
	 * 
	 * @param request
	 * @param cardUserDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateBalance")
	public void updateBalance(HttpServletRequest request,HttpServletResponse response,
			ModifyMoneyRecord modifyMoneyRecord) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		modifyMoneyRecord.setOPTIME(dateFormat.format(date));
		int flag = userCardManageService.updateBalance(modifyMoneyRecord);
		if(flag > 0){
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			loggerInfoDto.setOPERATINGUSER(modifyMoneyRecord.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改卡用户余额");
			loggerInfoDto.setOPERATIONOBJECT(modifyMoneyRecord.getCARDNUM());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			send(response, ReDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！请重新操作！";
			send(response, ReDto);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @param cardUserDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/deleteusercard")
	public String deleteusercard(HttpServletRequest request,
			CardUserDto cardUserDto) throws IOException {
		String cardNum = request.getParameter("CARDNUM");
		String cardNums[] = cardNum.substring(1).split(",");
		int count = userCardManageService.deleteByCardNum(cardNums);
		return "/userCard/findUserCardFirst";
	}

	// 开卡记录查询页面
	@RequestMapping("/findUCIRFirst")
	public void findUCIRByPage(HttpServletRequest request,HttpServletResponse response
			,@RequestParam String operatorloginid) throws IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<OperatorInfo> operList = operatorService
				.findNewOperator(operatorloginid);
		request.setAttribute("OPERLIST", operList);
		FindUserCardIssueRecordDto findUserCardIssueRecordDto = new FindUserCardIssueRecordDto();
		findUserCardIssueRecordDto.setOPERATORLOGINID(operatorloginid);
		findUserCardIssueRecordDto.setPageNow(1);
		findUserCardIssueRecordDto.setPageSize(10);
		List<UserCardIssueRecordDto> onePageList = userCardManageService
				.showUserCardIssueRecord(findUserCardIssueRecordDto);
		ReDto.detail.put("page",onePageList );
		send(response, ReDto);
	}

//	// 保存查询条件 分页查询 切换页码
//	@ResponseBody
//	@RequestMapping("/findUCIRBy")
//	public String findUCIRBy(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow,
//			FindUserCardIssueRecordDto findUserCardIssueRecordDto)
//			throws IOException {
//		findUserCardIssueRecordDto.setPageNow(pageNow);
//		findUserCardIssueRecordDto.setPageSize(pageSize);
//		Page page = userCardManageService
//				.showUserCardIssueRecord(findUserCardIssueRecordDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}

	//
	@RequestMapping("/findUserCardDetail")
	public String findUserCardDetail(HttpServletRequest request) {
		String CARDNUM = request.getParameter("CARDNUM");
		CardUserDto cardUserDto = userCardManageService.findUserCard(CARDNUM);
		request.setAttribute("cardUserDto", cardUserDto);
		FindUserCardChargeDto findUserCardChargeDto = new FindUserCardChargeDto();
		findUserCardChargeDto.setPageNow(1);
		findUserCardChargeDto.setPageSize(10);
		findUserCardChargeDto.setCARDNUM(CARDNUM);

		Page page = userCardManageService
				.findCardUserChargeRecord(findUserCardChargeDto);
		request.setAttribute("page", page);
		return "//jsp/cardIssue/userCardDetail.jsp";
	}

	// 保存查询条件 分页查询 切换页码
	@ResponseBody
	@RequestMapping("/findUserCardDetailBy")
	public String findUserCardDetailBy(@RequestParam Integer pageSize,
			@RequestParam Integer pageNow,
			FindUserCardChargeDto findUserCardChargeDto) throws IOException {
		findUserCardChargeDto.setPageNow(pageNow);
		findUserCardChargeDto.setPageSize(pageSize);
		Page page = userCardManageService
				.findCardUserChargeRecord(findUserCardChargeDto);
		String json = JsonUtil.toJson(page);
		return json;
	}

	/*234234*/
	// 充值操作记录查询
	@RequestMapping("/findRechargeRecordFirst")
	public void findRechargeRecordFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String operatorloginid = request.getParameter("operatorloginid");// 获取登录用户运营商id
		List<OperatorInfo> operList = operatorService
				.findNewOperator(operatorloginid);
		request.setAttribute("OPERLIST", operList);
		FindRechargeRecordDto findRechargeRecordDto = new FindRechargeRecordDto();
		findRechargeRecordDto.setOPERATORLOGINID(operatorloginid);
		List<UserCardRechargeDto> onePageList = userCardManageService
				.showRechargeRecord(findRechargeRecordDto);
//		System.out.println("findRechargeRecordFirst-------------page-------------"+page);
		ReDto.detail.put("page",onePageList);
		send(response, ReDto);
//		request.setAttribute("page", page);
//		request.setAttribute("roleaction", roleaction);
//		return "//jsp/operManage/userCardRechargeRecord.jsp";
	}

	
	
	
	// 保存查询条件 分页查询 切换页码
//	@ResponseBody
//	@RequestMapping("/findRechargeRecordBy")
//	public String findRechargeRecordBy(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow,
//			FindRechargeRecordDto findRechargeRecordDto) throws IOException {
//
//		findRechargeRecordDto.setPageNow(pageNow);
//		findRechargeRecordDto.setPageSize(pageSize);
//		Page page = userCardManageService
//				.showRechargeRecord(findRechargeRecordDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}

	@RequestMapping("/userCardExport")
	public void userCardExport(HttpServletRequest request,
			HttpServletResponse response, FindCardUserDto findCardUserDto)
			throws IOException {
		List<CardUserDto> cardUserDto = userCardManageService
				.findUserCardInfo(findCardUserDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "卡号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "姓名");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "性别");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "手机号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "身份证号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "邮箱");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "车牌号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "余额(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "地址");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "开卡日期");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH10");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "用户卡状态");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH11");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "运营商");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH12");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < cardUserDto.size(); i++) {
			dataItem = new HashMap<String, Object>();
			CardUserDto usercard = (CardUserDto) cardUserDto.get(i);
			dataItem.put("XH1", "" + usercard.getCARDNUM());
			dataItem.put("XH2", "" + usercard.getCARDUSERNAME());
			if (usercard.getSEX() == 1) {
				dataItem.put("XH3", "" + "男");
			} else if (usercard.getSEX() == 2) {
				dataItem.put("XH3", "" + "女");
			} else {
				dataItem.put("XH3", "" + "");
			}
			dataItem.put("XH4", "" + usercard.getTELEPHONE());
			dataItem.put("XH5", "" + usercard.getIDENTITYCARDNUM());
			dataItem.put("XH6", "" + usercard.getEMAIL());
			dataItem.put("XH7", "" + usercard.getPLATENUM());
			dataItem.put("XH8", "" + usercard.getACCOUNTSUM());
			dataItem.put("XH9", "" + usercard.getADDRESS());
			dataItem.put("XH10", "" + usercard.getREGTIME());
			if (usercard.getCARDSTATE() == 0) {
				dataItem.put("XH11", "" + "正常");
			} else {
				dataItem.put("XH11", "" + "挂失");
			}
			dataItem.put("XH12", "" + usercard.getOPERATORNAME());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("用户卡信息", "D://用户卡信息.xls", headInfoList,
				dataList);
		download("D://用户卡信息.xls", response);
		DeleteFileUtil.deleteFile("D://用户卡信息.xls");// 删除保存的excel文件
	}

	@RequestMapping("/chargeDetailExport")
	public void chargeDetailExport(HttpServletRequest request,
			HttpServletResponse response,
			FindUserCardChargeDto findUserCardChargeDto) throws IOException {
		List<UserCardChargeDto> userCardChargeDtos = userCardManageService
				.findUserCardRecord(findUserCardChargeDto);
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
		itemMap.put("title", "充电桩ID");
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
		itemMap.put("title", "充电总费用(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电费(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "服务费(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电电量(kWh)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH10");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		DecimalFormat decimalFormat = new java.text.DecimalFormat("0.0000");
		for (int i = 0; i < userCardChargeDtos.size(); i++) {
			dataItem = new HashMap<String, Object>();
			UserCardChargeDto userCardChargeDto = (UserCardChargeDto) userCardChargeDtos
					.get(i);
			dataItem.put("XH1", "" + userCardChargeDto.getOPERATORNAME());
			dataItem.put("XH2", "" + userCardChargeDto.getCSNAME());
			dataItem.put("XH3", "" + userCardChargeDto.getCPID());
			dataItem.put("XH4", "" + userCardChargeDto.getCHARGESTARTTIME());
			dataItem.put("XH5", "" + userCardChargeDto.getCHARGEENDTIME());
			dataItem.put("XH6", "" + userCardChargeDto.getCHARGETIMESPAN());
			dataItem.put(
					"XH7",
					""
							+ decimalFormat.format(Float
									.valueOf(userCardChargeDto.getDEDUCTMONEY())));
			dataItem.put(
					"XH8",
					""
							+ decimalFormat.format(Float
									.valueOf(userCardChargeDto.getCHARGEMONEY())));
			dataItem.put(
					"XH9",
					""
							+ decimalFormat.format(Float
									.valueOf(userCardChargeDto.getSERVICETIP())));
			dataItem.put(
					"XH10",
					""
							+ decimalFormat.format(Float
									.valueOf(userCardChargeDto
											.getCHARGEQUANTITY())));
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("用户卡" + findUserCardChargeDto.getCARDNUM()
				+ "充电记录", "D://用户卡" + findUserCardChargeDto.getCARDNUM()
				+ "充电记录.xls", headInfoList, dataList);
		download("D://用户卡" + findUserCardChargeDto.getCARDNUM() + "充电记录.xls",
				response);
		DeleteFileUtil.deleteFile("D://用户卡"
				+ findUserCardChargeDto.getCARDNUM() + "充电记录.xls");// 删除保存的excel文件
	}

	@RequestMapping("/userCardIssueRecordExport")
	public void userCardIssueRecordExport(HttpServletRequest request,
			HttpServletResponse response,
			FindUserCardIssueRecordDto findUserCardIssueRecordDto)
			throws IOException {
		List<UserCardIssueRecordDto> userCardIssueRecordDtos = userCardManageService
				.userCardIssueRecordExport(findUserCardIssueRecordDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "卡号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "用户姓名");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "身份证号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "手机号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "初始密钥");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "开卡结果");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "操作时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "操作账号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "运营商");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < userCardIssueRecordDtos.size(); i++) {
			dataItem = new HashMap<String, Object>();
			UserCardIssueRecordDto userCardIssueRecordDto = (UserCardIssueRecordDto) userCardIssueRecordDtos
					.get(i);
			dataItem.put("XH1", "" + userCardIssueRecordDto.getCARDNUM());
			dataItem.put("XH2", "" + userCardIssueRecordDto.getCARDUSERNAME());
			dataItem.put("XH3", "" + userCardIssueRecordDto.getIDENTITY());
			dataItem.put("XH4", "" + userCardIssueRecordDto.getPHONE());
			if (userCardIssueRecordDto.getINITIALKEY() == null) {
				dataItem.put("XH5", "");
			} else {
				dataItem.put("XH5", "" + userCardIssueRecordDto.getINITIALKEY());
			}
			if ("0".equals(userCardIssueRecordDto.getOPENCARDRESULT())) {
				dataItem.put("XH6", "" + "成功");
			} else {
				dataItem.put("XH6", "" + "失败");
			}
			dataItem.put("XH7", "" + userCardIssueRecordDto.getSENDRECORDTIME());
			dataItem.put("XH8", "" + userCardIssueRecordDto.getLOGINID());
			dataItem.put("XH9", "" + userCardIssueRecordDto.getOPERATORNAME());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("开卡记录", "D://开卡记录.xls", headInfoList,
				dataList);
		download("D://开卡记录.xls", response);
		DeleteFileUtil.deleteFile("D://开卡记录.xls");// 删除保存的excel文件
	}

	@RequestMapping("/userCardRechargeExport")
	public void userCardRechargeExport(HttpServletRequest request,
			HttpServletResponse response,
			FindRechargeRecordDto findRechargeRecordDto) throws IOException {
		List<UserCardRechargeDto> userCardRechargeDtos = userCardManageService
				.userCardRechargeExport(findRechargeRecordDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "卡号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充值金额(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "卡内余额(元)");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "操作时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充值结果");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "操作账号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "运营商");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < userCardRechargeDtos.size(); i++) {
			dataItem = new HashMap<String, Object>();
			UserCardRechargeDto userCardRechargeDto = (UserCardRechargeDto) userCardRechargeDtos
					.get(i);
			dataItem.put("XH1", "" + userCardRechargeDto.getCARDNUM());
			dataItem.put("XH2", "" + userCardRechargeDto.getMONEY());
			dataItem.put("XH3", "" + userCardRechargeDto.getBALANCE());
			dataItem.put("XH4", "" + userCardRechargeDto.getRECHARGETIME());
			if ("0".equals(userCardRechargeDto.getRECHARGERESULT())) {
				dataItem.put("XH5", "" + "成功");
			} else {
				dataItem.put("XH5", "" + "失败");
			}
			dataItem.put("XH6", "" + userCardRechargeDto.getLOGINID());
			dataItem.put("XH7", "" + userCardRechargeDto.getOPERATORNAME());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("充值记录", "D://充值记录.xls", headInfoList,
				dataList);
		download("D://充值记录.xls", response);
		DeleteFileUtil.deleteFile("D://充值记录.xls");// 删除保存的excel文件
	}


	// 挂失
	@RequestMapping("/reportLost")
	public String reportLost(HttpServletRequest request,
			ReportLostDto reportLostDto) {
		reportLostDto.setUSERID(request.getParameter("userid"));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		reportLostDto.setOPTIME(dateFormat.format(date));
		int result = userCardManageService.reportLost(reportLostDto);
		if (result == 0) {
			request.setAttribute("result", "卡号与身份证号不符！");
		} else {
			request.setAttribute("result", "用户卡挂失成功！");
		}
		return "//jsp/cardIssue/reportLost.jsp";
	}

	// 解除挂失
	@RequestMapping("/removeLost")
	public String removeLost(HttpServletRequest request,
			ReportLostDto reportLostDto) {
		reportLostDto.setUSERID(request.getParameter("userid"));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		reportLostDto.setOPTIME(dateFormat.format(date));
		int result = userCardManageService.removeLost(reportLostDto);
		if (result == 0) {
			request.setAttribute("result", "卡号与身份证号不符！");
		} else {
			request.setAttribute("result", "用户卡解除挂失成功！");
		}
		return "//jsp/cardIssue/reportLost.jsp";
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

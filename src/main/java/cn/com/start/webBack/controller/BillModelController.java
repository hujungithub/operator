package cn.com.start.webBack.controller;


import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.FindBillModelDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.RateInfoDto;
import cn.com.start.webBack.entity.BillModelInfo;
import cn.com.start.webBack.service.BasicDataService;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.EmptyUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;

@Controller
@RequestMapping("/billModel")
public class BillModelController extends LoggerController{

	@Autowired
	private BasicDataService basicDataService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param model
	 * @param findCPDto
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findBillFirst")
	public void findBillFirst(HttpServletRequest request,HttpServletResponse response
				,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindBillModelDto findBillModelDto = new FindBillModelDto();
		// 查询出所有
		String rateId = request.getParameter("RATEID");
		if (EmptyUtil.isStringEmpty(rateId)) {
			// 为空 则为第一次进入 那么默认查询模板1
			rateId = "1";
		}
		if("第".equals(rateId.substring(0,1))){
			//去中英文字符
			String reg = "[\u4e00-\u9fa5]";  
	        Pattern pat = Pattern.compile(reg);   
	        Matcher ratemat = pat.matcher(rateId);   
	        rateId = ratemat.replaceAll("");  //模板id
		}
		findBillModelDto.setOPERATORLOGINID(operatorloginid);
		findBillModelDto.setRATEID(rateId);
		
		List<BillModelDto> billList = basicDataService
				.findBIllByRateId(findBillModelDto);
		List<String> rateList = basicDataService.findRateId();
		ReDto.detail.put("page",billList);
		send(response, ReDto);
//		request.setAttribute("rateList", rateList);
//		request.setAttribute("billList", billList);
//		request.setAttribute("roleaction", roleaction);
//		return "//jsp/priceSection/billModelManage.jsp";
	}

//	@RequestMapping("/findBillSaveData")
//	public void findBillSaveData(HttpServletRequest request,
//			HttpServletResponse response) throws IOException {
//		FindBillModelDto findBillModelDto = new FindBillModelDto();
//		// 查询出所有
//		String operatorid = request.getParameter("OPERATORID");
//		String rateId = request.getParameter("RATEID");
//		if (EmptyUtil.isStringEmpty(rateId)) {
//			// 为空 则为第一次进入 那么默认查询模板1
//			rateId = "1";
//		}
//		findBillModelDto.setOPERATORID(operatorid);
//		findBillModelDto.setRATEID(rateId);
//		List<BillModelDto> billList = basicDataService
//				.findBIllByRateId(findBillModelDto);
//		PrintWriter out = response.getWriter();
//		response.setContentType("application/json; charset=utf-8");
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(billList);
//		System.out.println("this is the yibu data" + json);
//		// 向页面返回json数据
//		out.print(json);
//		out.flush();
//		out.close();
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
	public void findUpdate(HttpServletResponse response,@RequestParam String operatorid,@RequestParam String billmodelid
			,@RequestParam String rateid,@RequestParam String csid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		FindBillModelDto findBillModelDto = new FindBillModelDto();
		findBillModelDto.setBILLMODELID(billmodelid);
		findBillModelDto.setOPERATORID(operatorid);
		findBillModelDto.setCSID(csid);
		findBillModelDto.setRATEID(rateid);
		List<BillModelDto> billModelDto = basicDataService
				.findUpdate(findBillModelDto);
		List<BillModelInfo> rateList = basicDataService.findRate();
		List<BillModelInfo> billList = basicDataService.findBillModel();
		
		ReDto.detail.put("billModelDto", billModelDto);
		ReDto.detail.put("rateList", rateList);
		ReDto.detail.put("billList", billList);
		send(response, ReDto);
	}
	
	/**
	 * 修改用户数据
	 * 
	 * @param cpuser
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/billUpdate")
	public void billUpdate(HttpServletResponse response,HttpServletRequest request
				, BillModelDto billModelDto) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		BillModelInfo billModelInfo = new BillModelInfo();
		System.out.println("billModelDto---------"+billModelDto);
		
		//去中英文字符
		String reg = "[\u4e00-\u9fa5]";  
        Pattern pat = Pattern.compile(reg);    
        
		String operatorid = billModelDto.getOPERATORID();
		String csid = billModelDto.getCSID();
		
		Matcher ratemat = pat.matcher(billModelDto.getRATEID());   
        String rateid = ratemat.replaceAll("");  //模板id
        
        Matcher billmodelmat = pat.matcher(billModelDto.getBILLMODELID());
		String billmodelid = billmodelmat.replaceAll("");//方案
		
		String timeintervalcount = billModelDto.getTIMEINTERVALCOUNT();//有效时段
		float servicetip = billModelDto.getSERVICETIP();//尖
		float jprice = billModelDto.getJPRICE();//尖
		float fprice = billModelDto.getFPRICE();//峰
		float pprice = billModelDto.getPPRICE();//平
		float gprice = billModelDto.getGPRICE();//谷
		
		int ti_1_id = Integer.parseInt(billModelDto.getTI_1_ID());//时段1类型
		int ti_2_id = Integer.parseInt(billModelDto.getTI_2_ID());//时段2类型
		int ti_3_id = Integer.parseInt(billModelDto.getTI_3_ID());//时段3类型
		int ti_4_id = Integer.parseInt(billModelDto.getTI_4_ID());//时段4类型
		int ti_5_id = Integer.parseInt(billModelDto.getTI_5_ID());//时段5类型
		int ti_6_id = Integer.parseInt(billModelDto.getTI_6_ID());//时段6类型
		int ti_7_id = Integer.parseInt(billModelDto.getTI_7_ID());//时段7类型
		int ti_8_id = Integer.parseInt(billModelDto.getTI_8_ID());//时段8类型
		
		
		String vtime = billModelDto.getVALIDTIME();//生效时间
		String invtime = billModelDto.getINVALIDTIME();//失效时间
		String validmin = " 00:00:00";
		String invalidmin = " 23:59:59";
		
		String ti_1 = billModelDto.getTI_1_START();
		String ti_2 = billModelDto.getTI_2_START();
		String ti_3 = billModelDto.getTI_3_START();
		String ti_4 = billModelDto.getTI_4_START();
		String ti_5 = billModelDto.getTI_5_START();
		String ti_6 = billModelDto.getTI_6_START();
		String ti_7 = billModelDto.getTI_7_START();
		String ti_8 = billModelDto.getTI_8_START();
		
		//截取时间 ,如: 6:00, ti1=6,ti11=00
		String ti1 = StringUtils.substringBefore(ti_1, ":");
		String ti11 = StringUtils.substringAfter(ti_1, ":");
		String ti2 = StringUtils.substringBefore(ti_2, ":");
		String ti21 = StringUtils.substringAfter(ti_2, ":");
		String ti3 = StringUtils.substringBefore(ti_3, ":");
		String ti31 = StringUtils.substringAfter(ti_3, ":");
		String ti4 = StringUtils.substringBefore(ti_4, ":");
		String ti41 = StringUtils.substringAfter(ti_4, ":");
		String ti5 = StringUtils.substringBefore(ti_5, ":");
		String ti51 = StringUtils.substringAfter(ti_5, ":");
		String ti6 = StringUtils.substringBefore(ti_6, ":");
		String ti61 = StringUtils.substringAfter(ti_6, ":");
		String ti7 = StringUtils.substringBefore(ti_7, ":");
		String ti71 = StringUtils.substringAfter(ti_7, ":");
		String ti8 = StringUtils.substringBefore(ti_8, ":");
		String ti81 = StringUtils.substringAfter(ti_8, ":");
		
		String validtime = vtime + validmin;//生效时间
		String invalidtime = invtime + invalidmin;//失效时间
		
		int ti_1_start = Integer.parseInt(ti1)*60+Integer.parseInt(ti11);//时段1起始时刻
		int ti_2_start = Integer.parseInt(ti2)*60+Integer.parseInt(ti21);//时段2起始时刻
		int ti_3_start = Integer.parseInt(ti3)*60+Integer.parseInt(ti31);//时段3起始时刻
		int ti_4_start = Integer.parseInt(ti4)*60+Integer.parseInt(ti41);//时段4起始时刻
		int ti_5_start = Integer.parseInt(ti5)*60+Integer.parseInt(ti51);//时段5起始时刻
		int ti_6_start = Integer.parseInt(ti6)*60+Integer.parseInt(ti61);//时段6起始时刻
		int ti_7_start = Integer.parseInt(ti7)*60+Integer.parseInt(ti71);//时段7起始时刻
		int ti_8_start = Integer.parseInt(ti8)*60+Integer.parseInt(ti81);//时段8起始时刻
		
		//重新赋值
		billModelInfo.setOPERATORID(operatorid);
		billModelInfo.setCSID(csid);
		billModelInfo.setRATEID(rateid);
		billModelInfo.setBILLMODELID(billmodelid);
		billModelInfo.setTIMEINTERVALCOUNT(timeintervalcount);
		billModelInfo.setSERVICETIP(servicetip);
		billModelInfo.setJPRICE(jprice);
		billModelInfo.setFPRICE(fprice);
		billModelInfo.setPPRICE(pprice);
		billModelInfo.setGPRICE(gprice);
		
		billModelInfo.setVALIDTIME(validtime);
		billModelInfo.setINVALIDTIME(invalidtime);
		billModelInfo.setTI_1_ID(ti_1_id);
		billModelInfo.setTI_2_ID(ti_2_id);
		billModelInfo.setTI_3_ID(ti_3_id);
		billModelInfo.setTI_4_ID(ti_4_id);
		billModelInfo.setTI_5_ID(ti_5_id);
		billModelInfo.setTI_6_ID(ti_6_id);
		billModelInfo.setTI_7_ID(ti_7_id);
		billModelInfo.setTI_8_ID(ti_8_id);
		billModelInfo.setTI_1_START(ti_1_start);
		billModelInfo.setTI_2_START(ti_2_start);
		billModelInfo.setTI_3_START(ti_3_start);
		billModelInfo.setTI_4_START(ti_4_start);
		billModelInfo.setTI_5_START(ti_5_start);
		billModelInfo.setTI_6_START(ti_6_start);
		billModelInfo.setTI_7_START(ti_7_start);
		billModelInfo.setTI_8_START(ti_8_start);
		
		int updateBill = basicDataService.updateBill(billModelInfo);
		if(updateBill > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(billModelDto.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改费率");
			loggerInfoDto.setOPERATIONOBJECT(billModelInfo.getOPERATORID()+"_"+billModelInfo.getCSID()
									+ "_" + billModelInfo.getRATEID() + "_" + billModelInfo.getBILLMODELID());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！";
		}
		send(response, ReDto);
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/billExport")
	public void billExport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FindBillModelDto findBillModelDto = new FindBillModelDto();
		String operatorid = request.getParameter("operatorid");
		String rateId = request.getParameter("RATEID");
		findBillModelDto.setOPERATORID(operatorid);
		findBillModelDto.setRATEID(rateId);
		List<BillModelDto> billList = basicDataService
				.findBIllByRateId(findBillModelDto);

		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "费率模板");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "计费方案");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "生效时间");
		itemMap.put("columnWidth", 40);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "失效时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "有效时段");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "服务费(元/度)");
		itemMap.put("columnWidth", 40);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);
		
		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "尖电价(元/度)");
		itemMap.put("columnWidth", 40);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "峰电价(元/度)");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "平电价(元/度)");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "谷电价(元/度)");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH10");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段1起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH11");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段1类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH12");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段2起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH13");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段2类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH14");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段3起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH15");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段3类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH16");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段4起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH17");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段4类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH18");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段5起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH19");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段5类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH20");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段6起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH21");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段6类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH22");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段7起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH23");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段7类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH24");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段8起始时刻");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH25");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "时段8类型");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH26");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < billList.size(); i++) {
			dataItem = new HashMap<String, Object>();
			BillModelDto billInfo = billList.get(i);
			dataItem.put("XH1", "" + "第"+billInfo.getRATEID()+"套");
			dataItem.put("XH2", "" + "方案"+billInfo.getBILLMODELID());
			dataItem.put("XH3", "" + billInfo.getVALIDTIME());
			dataItem.put("XH4", "" + billInfo.getINVALIDTIME());
			dataItem.put("XH5", "" + billInfo.getTIMEINTERVALCOUNT());
			dataItem.put("XH6", "" + billInfo.getSERVICETIP());
			dataItem.put("XH7", "" + billInfo.getJPRICE());
			dataItem.put("XH8", "" + billInfo.getFPRICE());
			dataItem.put("XH9", "" + billInfo.getPPRICE());
			dataItem.put("XH10", "" + billInfo.getGPRICE());
			dataItem.put("XH11", "" + billInfo.getTI_1_START());
			dataItem.put("XH12", "" + billInfo.getTI_1_ID());
			dataItem.put("XH13", "" + billInfo.getTI_2_START());
			dataItem.put("XH14", "" + billInfo.getTI_2_ID());
			dataItem.put("XH15", "" + billInfo.getTI_3_START());
			dataItem.put("XH16", "" + billInfo.getTI_3_ID());
			dataItem.put("XH17", "" + billInfo.getTI_4_START());
			dataItem.put("XH18", "" + billInfo.getTI_4_ID());
			dataItem.put("XH19", "" + billInfo.getTI_5_START());
			dataItem.put("XH20", "" + billInfo.getTI_5_ID());
			dataItem.put("XH21", "" + billInfo.getTI_6_START());
			dataItem.put("XH22", "" + billInfo.getTI_6_ID());
			dataItem.put("XH23", "" + billInfo.getTI_7_START());
			dataItem.put("XH24", "" + billInfo.getTI_7_ID());
			dataItem.put("XH25", "" + billInfo.getTI_8_START());
			dataItem.put("XH26", "" + billInfo.getTI_8_ID());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("费用配置", "D://费率模板.xls", headInfoList,
				dataList);
		download("D://费率模板.xls", response);
		DeleteFileUtil.deleteFile("D://费率模板.xls");// 删除保存的excel文件
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

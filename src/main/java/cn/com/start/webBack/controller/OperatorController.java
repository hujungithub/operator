package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindOperatorDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.OperatorInfoDto;
import cn.com.start.webBack.dto.ReturnCPDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.util.ControllerUtil;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/operator")
public class OperatorController extends LoggerController{

	@Autowired
	private OperatorService operatorService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	// 第一次进入查询所有运营商
	@RequestMapping("/findOperatorFirst")
	public void findOperatorByPage(HttpServletResponse response
				,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<OperatorInfoDto> onePageOperatorList = operatorService.showOperatorByPage(operatorloginid);
		ReDto.detail.put("page", onePageOperatorList);
		send(response, ReDto);
	}

//	// 保存查询条件 分页查询 切换页码
//	@ResponseBody
//	@RequestMapping("/findCPSaveData")
//	public String findCPByPage(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindOperatorDto findOperatorDto)
//			throws IOException {
//		// 截取点击太快产生的5,5 10,10
//		findOperatorDto.setPageNow(pageNow);
//		findOperatorDto.setPageSize(pageSize);
//		Page page = operatorService.showOperatorByPage(findOperatorDto);
//		String json = JsonUtil.toJson(page);
//		return json;
//	}

	
	/**
	 * 根据运营商找充电站
	 */
	@ResponseBody
	@RequestMapping("/findCSByOper")
	public String findCSByOper(HttpServletResponse response,@RequestParam Integer OPERATORID) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		// 根据运营商查找CPM
		List<CSInfo> findCSList = operatorService.findCSByOper(OPERATORID);
		String json = JsonUtil.toJson(findCSList);
		logger.info("findCSByOper="+json);
		return json;
	}

	// 根据充电站查找充电桩
	@ResponseBody
	@RequestMapping("/findCPHEByCS")
	public String findCPHEByCS(@RequestParam Integer CSID) throws IOException {
		List<CPInfo> findCPHEList = operatorService.findCPHEByCS(CSID);
		String json = JsonUtil.toJson(findCPHEList);
		logger.info("findCPHEByCS="+json);
		return json;
	}

	/**
	 * 详细页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/findOperatorDetail")
	public String findOperatorDetail(@RequestParam String OPERATORID,Model model) {
		FindOperatorDto findOperatorDto = new FindOperatorDto();
		findOperatorDto.setOPERATORID(OPERATORID);
		findOperatorDto.setPageNow(1);
		findOperatorDto.setPageSize(10);
		Page page = operatorService.findOperator(findOperatorDto);
		OperatorInfo operatorinfo = operatorService
				.findOperatorById(OPERATORID);
		model.addAttribute("page", page);
		model.addAttribute("operatorinfo", operatorinfo);
		return "//jsp/userManage/OperatorDetail.jsp";
	}

	/**
	 * 获取详细信息
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findDetail")
	public String findDetail(@RequestParam Integer pageSize,
			@RequestParam Integer pageNow, FindOperatorDto findOperatorDto)
			throws IOException {
		findOperatorDto.setPageNow(pageNow);
		findOperatorDto.setPageSize(pageSize);
		Page page = operatorService.findOperator(findOperatorDto);
		String json = JsonUtil.toJson(page);
		logger.info("findDetail="+json);
		return json;
	}

	// 按id删除运营商
	@ResponseBody
	@RequestMapping("/deleteById")
	public void deleteById(HttpServletResponse response,@RequestParam String OPERATORID
			,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String OPERATORIDS[] = OPERATORID.substring(1).split(",");
		// 判断运营商下是否有站
		int check = operatorService.findcheck(OPERATORIDS);
		LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
		if(check > 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "您要删除的运营商下面有站，请先删除所有充电站后再删除运营商！";
			send(response, ReDto);
		}else{
			int flag = operatorService.deleteById(OPERATORIDS);
			if(flag > 0){
				SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				String OPERATINGTIME = Format.format(new Date());
				loggerInfoDto.setOPERATINGUSER(operatorloginid);
				loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
				loggerInfoDto.setOPERATING("删除");
				loggerInfoDto.setOPERATIONCONTENT("删除运营商");
				for (int i = 0; i < OPERATORIDS.length; i++) {
					loggerInfoDto.setOPERATIONOBJECT(OPERATORIDS[i]);
					loggerInfoService.insertLoggerInfo(loggerInfoDto);
				}
				ReDto.returnCode = 0;
				ReDto.errorCode = "0";
				ReDto.message = "删除成功！";
				send(response, ReDto);
			}
		}
	}

	// 增加运营商
	@RequestMapping("/addOperator")
	public void addOperator(HttpServletResponse response,
			OperatorInfo operatorInfo) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		operatorInfo.setBOSSID(operatorInfo.getOPERATORLOGINID());
		int count = operatorService.insertOperator(operatorInfo);
		if(count > 0){
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
		    LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			loggerInfoDto.setOPERATINGUSER(operatorInfo.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("增加");
			loggerInfoDto.setOPERATIONCONTENT("增加运营商");
			loggerInfoDto.setOPERATIONOBJECT(operatorInfo.getOPERATORNAME());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
			send(response, ReDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重新添加！";
			send(response, ReDto);
		}
	}

	

	// // 获取运营商修改信息
	@ResponseBody
	@RequestMapping("/findUpdateOperData")
	public String updateOperatorById(@RequestParam Integer OPERATORID) throws IOException {
		OperatorInfo operatorInfo = operatorService
				.findOperatorById(OPERATORID);
		String json = JsonUtil.toJson(operatorInfo);
		logger.info("findUpdateOperData="+json);
		return json;
	}

	// 修改运营商信息
	@RequestMapping("/updateOperator")
	public void updateOperator(HttpServletRequest request,HttpServletResponse response,
			OperatorInfo operatorInfo) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		int updatecount = operatorService.updateById(operatorInfo);
		if(updatecount > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
		    LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			loggerInfoDto.setOPERATINGUSER(operatorInfo.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改运营商");
			loggerInfoDto.setOPERATIONOBJECT(operatorInfo.getOPERATORNAME());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！";
		}
		send(response, ReDto);
	}

	/**
	 * 数据详细导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/operatorDetailExport")
	@ResponseBody
	public void operatorDetailExport(HttpServletRequest request,
			HttpServletResponse response, FindOperatorDto findOperatorDto)
			throws IOException {
		List<CSoperInfoDto> operators = operatorService
				.findOperatorExport(findOperatorDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "站名");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "站编号");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电次数");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电时长");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电电量（kWh）");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "服务费（元）");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "基础电费（元）");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH7");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "充电总费用（元）");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH8");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "建站日期");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH9");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < operators.size(); i++) {
			dataItem = new HashMap<String, Object>();
			CSoperInfoDto operator1 = operators.get(i);
			dataItem.put("XH1", "" + operator1.getCSNAME());
			dataItem.put("XH2", "" + operator1.getCSID());
			if (operator1.getCSCOUNT() == null) {
				dataItem.put("XH3", "");
			} else {
				dataItem.put("XH3", "" + operator1.getCSCOUNT());
			}
			if (operator1.getCHARGETIMESPAN() == null) {
				dataItem.put("XH4", "");
			} else {
				dataItem.put("XH4", "" + operator1.getCHARGETIMESPAN());
			}
			if (operator1.getCHARGEQUANTITY() == null) {
				dataItem.put("XH5", "");
			} else {
				dataItem.put("XH5", "" + operator1.getCHARGEQUANTITY());
			}

			if (operator1.getSERVICETIP() == null) {
				dataItem.put("XH6", "");
			} else {
				dataItem.put("XH6", "" + operator1.getSERVICETIP());
			}

			if (operator1.getCHARGEMONEY() == null) {
				dataItem.put("XH7", "");
			} else {
				dataItem.put("XH7", "" + operator1.getCHARGEMONEY());
			}

			if (operator1.getMONEYCOUNT() == null) {
				dataItem.put("XH8", "");
			} else {
				dataItem.put("XH8", "" + operator1.getMONEYCOUNT());
			}

			dataItem.put("XH9", "" + operator1.getCREATETIME());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("运营商详细信息", "D://运营商详细信息.xls",
				headInfoList, dataList);
		download("D://运营商详细信息.xls", response);
		DeleteFileUtil.deleteFile("D://运营商详细信息.xls");// 删除保存的excel文件
	}

	/**
	 * 数据导出 / *
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/operatorExport")
	@ResponseBody
	public void Export(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// OperatorInfo operator = new OperatorInfo();
		FindOperatorDto findOperatorDto = new FindOperatorDto();
		List<OperatorInfoDto> operators = operatorService
				.findOperatorBy(findOperatorDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "运营商");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "联系人");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "联系电话");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "联系邮箱");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "联系地址");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "是否可用");
		itemMap.put("columnWidth", 70);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < operators.size(); i++) {
			dataItem = new HashMap<String, Object>();
			OperatorInfoDto operator1 = operators.get(i);
			dataItem.put("XH1", "" + operator1.getOPERATORNAME());
			dataItem.put("XH2", "" + operator1.getCONTACTNAME());
			dataItem.put("XH3", "" + operator1.getTELEPHONE());
			dataItem.put("XH4", "" + operator1.getEMAIL());
			dataItem.put("XH5", "" + operator1.getADDRESS());
			dataItem.put("XH6", "" + operator1.getVALIDFLAG());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("运营商信息", "D://运营商信息.xls", headInfoList,
				dataList);
		download("D://运营商信息.xls", response);
		DeleteFileUtil.deleteFile("D://运营商信息.xls");// 删除保存的excel文件
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

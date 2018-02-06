package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.service.ChargePileDetailService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.POIUtil;

@Controller
@RequestMapping("/chargePileDetail")
public class ChargePileDetailController extends BaseController {

	@Autowired
	private ChargePileDetailService chargePileDetailService;

	// 第一次进入充电桩详细页面
	@RequestMapping("/findCPDetailFirst")
	public void findCPDetail(HttpServletResponse response,@RequestParam String CPID,
			HttpServletRequest request) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		FindCPDto findCPDto = new FindCPDto();
		findCPDto.setCPID(CPID);
		List<CPInfoDto> cpInfoDto = chargePileDetailService
				.findCPDetail(findCPDto);
		
		
		List<OperInfoDto> operInfoDto = chargePileDetailService.findUserCharge(findCPDto);
		
		ReDto.returnCode = 0;
		ReDto.errorCode = "0";
		ReDto.message = "";
		ReDto.detail.put("cpInfoDto", cpInfoDto);
		ReDto.detail.put("operInfoDto", operInfoDto);
		send(response, ReDto);
	}

//	/**
//	 * 充电桩用户使用详细 分页
//	 * 
//	 * @param request
//	 * @param response
//	 * @param findCPDto
//	 * @throws IOException
//	 */
//	@ResponseBody
//	@RequestMapping("/AjaxChargeDetail")
//	public void AjaxChargeDetail(HttpServletResponse response,@RequestParam int pageSize,
//			@RequestParam int pageNow, FindCPDto findCPDto) throws IOException {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		JsonReDto ReDto = new JsonReDto();
//		
//		List<OperInfoDto> operInfoDto = chargePileDetailService.findUserCharge(findCPDto);
//		if(operInfoDto.size() == 0){
//			ReDto.returnCode = 1;
//			ReDto.errorCode = "1";
//			ReDto.message = "查询失败！";
//		}else{
//			ReDto.returnCode = 0;
//			ReDto.errorCode = "0";
//			ReDto.message = "查询成功！";
//			ReDto.detail.put("operInfoDto", operInfoDto);
//		}
//		send(response, ReDto);
//	}

	/**
	 * 数据导出 充电记录 导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/chargeDetailExport")
	@ResponseBody
	public void chargeDetailExport(HttpServletRequest request,
			HttpServletResponse response, FindCPDto findCPDto)
			throws IOException {
		// 获取Id 查询该桩的充电记录
		List<UserChargeDto> userchargeList = chargePileDetailService
				.exportChargeDetailList(findCPDto);

		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "用户名");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "车牌号");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "联系方式");
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
		for (int i = 0; i < userchargeList.size(); i++) {
			dataItem = new HashMap<String, Object>();
			// CpUser user = (CpUser) cpusers.get(i);
			UserChargeDto userDto = userchargeList.get(i);
			dataItem.put("XH1", "" + userDto.getCPUSERNAME());
			dataItem.put("XH2", "" + userDto.getPLATENUMBER());
			dataItem.put("XH3", "" + userDto.getTELEPHONE());
			dataItem.put("XH4", "" + userDto.getCHARGESTARTTIME());
			dataItem.put("XH5", "" + userDto.getCHARGEENDTIME());
			dataItem.put("XH6", "" + userDto.getCHARGETIMESPAN());
			dataItem.put(
					"XH7",
					""
							+ new java.text.DecimalFormat("0.0000")
									.format(userDto.getCHARGEQUANTITY()));
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
									.format(userDto.getCHARGEMONEY()
											+ userDto.getSERVICETIP()));
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("桩充电记录", "D://桩充电记录.xls", headInfoList,
				dataList);
		download("D://桩充电记录.xls", response);
		DeleteFileUtil.deleteFile("D://桩充电记录.xls");// 删除保存的excel文件
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

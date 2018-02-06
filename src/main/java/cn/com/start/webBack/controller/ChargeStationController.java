package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.FindCSInfoDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.ReturnCPDto;
import cn.com.start.webBack.dto.UpdateCSDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.ProtocolInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.service.ChargeStationService;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.util.ControllerUtil;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;
import okhttp3.Request;

@Controller
@RequestMapping("/chargeStation")
public class ChargeStationController extends BaseController {

	@Autowired
	private ChargeStationService chargeStationService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	// 第一次进入查询充电站
	// 从页面进入后台
	@ResponseBody
	@RequestMapping("/findCSFirst")
	public void findChargeStationByPage(HttpServletRequest request,HttpServletResponse response,
			String operatorloginid) throws IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		FindCSInfoDto findCSInfoDto = new FindCSInfoDto();
		JsonReDto ReDto = new JsonReDto();
		findCSInfoDto.setOPERATORLOGINID(operatorloginid);
		List<CSInfoDto> onePageChargeStationList = chargeStationService.showChargeStationByPage(findCSInfoDto);
		if(onePageChargeStationList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
		}
		ReDto.detail.put("page", onePageChargeStationList);
		send(response, ReDto);
	}


	// 按id删除充电站
	@ResponseBody
	@RequestMapping("/deleteChargeStationById")
	public void deleteChargeStationById(HttpServletResponse response,HttpServletRequest request
					,@RequestParam String CSID,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String CSIDS[] = CSID.substring(1).split(",");
		// 删除之前查询有没有所有要删除的站内有没有桩
		int cpcount = chargeStationService.selectById(CSIDS);
		LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
		if(cpcount > 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "您要删除的充电站内有正在使用的充电桩，请先删除所有充电桩后再删除充电站！";
			send(response, ReDto);
		}else{
			int flag = chargeStationService.deleteById(CSIDS);
			if(flag > 0){
				SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				String OPERATINGTIME = Format.format(new Date());
				loggerInfoDto.setOPERATINGUSER(operatorloginid);
				loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
				loggerInfoDto.setOPERATING("删除");
				loggerInfoDto.setOPERATIONCONTENT("删除充电站");
				for (int i = 0; i < CSIDS.length; i++) {
					loggerInfoDto.setOPERATIONOBJECT(CSIDS[i]);
					loggerInfoService.insertLoggerInfo(loggerInfoDto);
				}
				ReDto.returnCode = 0;
				ReDto.errorCode = "0";
				ReDto.message = "删除成功！";
				send(response, ReDto);
			}
		}
	}

	/**
	 * 进入增加充电站页面，加载数据
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/chargeStationAddFindData")
	public String chargeStationAddFindData(HttpServletResponse response,@RequestParam String operatorloginid,Model model) throws JsonGenerationException, JsonMappingException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		//查询省列表
		List<Province> proList = locationService.findProvince();
		// 获取boss及其下属运营商
		List<OperatorInfo> newoperList = operatorService.findNewOperator(operatorloginid);
		
		model.addAttribute("proList",proList);
		model.addAttribute("operList",newoperList);
		return "//jsp/DM/chargeStationAdd.jsp";
	}
	
	// 新增充电站
	@ResponseBody
	@RequestMapping("/addChargeStation")
	public void addChargeStation(HttpServletRequest request,HttpServletResponse response,
			CSInfo csInfo) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		int addressId = 0;
		String PROVINCEID = csInfo.getPROVINCEID();
		String CITYID = csInfo.getCITYID();
		String AREAID = csInfo.getAREAID();
		String ADDRESSNAME = csInfo.getADDRESSNAME();
		String addId = csInfo.getADDRESSID();
		String timestart = csInfo.getTIMESTART();
		String timeend = csInfo.getTIMEEND();
		String opentime = timestart + "-" + timeend;
		if (addId.isEmpty() || "0".equals(addId)) {
			// 地址id为空 则为新地址 新增一条地址记录
			addressId = this.addAddress(PROVINCEID,CITYID,AREAID,ADDRESSNAME);
		} else {
			addressId = Integer.parseInt(addId);
		}
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		csInfo.setCREATETIME(format.format(new Date())); // 创建时间
		csInfo.setADDRESSID(String.valueOf(addressId)); // 地址id
		csInfo.setVALIDFLAG("1"); // 可用
		csInfo.setOPENTIME(opentime);
		//新增充电站
		int flag = chargeStationService.insertChargeStation(csInfo);
		LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
		if(flag > 0){
			//新建站时新建费率模板
			this.addBill(csInfo.getOPERATORID(),csInfo.getCSID());
			//入库
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(csInfo.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("增加");
			loggerInfoDto.setOPERATIONCONTENT("增加充电站");
			loggerInfoDto.setOPERATIONOBJECT(csInfo.getCSID()+"_"+csInfo.getCSNAME());
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
		//MODIFIED BY HANMJ 20170719 BEGIN
		//return "/chargeStation/findChargeStationFirst";//findCSFirst
//		return "/chargeStation/findCSFirst";
		//MODIFIED BY HANMJ 20170719 END
	}



	// 修改之前查询数据                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	@ResponseBody
	@RequestMapping("/findUpdateData")
	public void updateChargeStationById(HttpServletResponse response,@RequestParam String CSID,
			@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		// csDTO
		List<CSInfo> csInfo = chargeStationService.findChargeStationById(CSID);
		// 单独的地址
		List<AddressDto> addressDto = chargeStationService
				.findAddressDtoByCSId(csInfo.get(0).getCSID());
		// 省市区详细地址
		List<Province> proList = locationService.findProvince();
		List<City> cityList = locationService.findCityByPro(addressDto.get(0)
				.getPROVINCEID());
		List<Area> areaList = locationService.findAreaByCity(addressDto.get(0)
				.getCITYID());
		List<Address> addressList = locationService
				.findAddressByArea(addressDto.get(0).getAREAID());
		// 运营商
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);// 获取boss及其下属运营商
//		UpdateCSDto updateCSDto = new UpdateCSDto();
//		updateCSDto.setOperList(newoperList);
//		updateCSDto.setProList(proList);
//		updateCSDto.setCityList(cityList);
//		updateCSDto.setAreaList(areaList);
//		updateCSDto.setAddressList(addressList);
//		updateCSDto.setAddressDto(addressDto);
//		
		ReDto.detail.put("csInfo", csInfo);
		ReDto.detail.put("operList", newoperList);
		ReDto.detail.put("proList", proList);
		ReDto.detail.put("cityList", cityList);
		ReDto.detail.put("areaList", areaList);
		ReDto.detail.put("addressList", addressList);
		ReDto.detail.put("addressDto", addressDto);
		send(response, ReDto);
//		String json = JsonUtil.toJson(updateCSDto);
//		return json;
	}

	// 修改充电站
	@ResponseBody
	@RequestMapping("/updateChargeStation")
	public void updateChargeStation(HttpServletRequest request, HttpServletResponse response
					,CSInfo csInfo)throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		int addressId = 0;
		String opentime = csInfo.getTIMESTART() + "-" + csInfo.getTIMEEND();
		System.out.println(csInfo.getOPERATORID());
		if ("0".equals(csInfo.getADDRESSID())) {
			// 地址id为空 则为新地址 新增一条地址记录
			addressId = this.addAddress(csInfo.getPROVINCEID(), csInfo.getCITYID()
					, csInfo.getAREAID(), csInfo.getADDRESSNAME());
			// 修改站内桩的地址ID为新ID
			chargeStationService.updateCPAddressIdByCSId(csInfo);
		} else {
			//解析字符串，返回十进制数字形式
			addressId = Integer.parseInt(csInfo.getADDRESSID());
		}
		csInfo.setADDRESSID(String.valueOf(addressId));
		csInfo.setOPENTIME(opentime);
		//修改充电站
		System.out.println("asdfasdfsaf"+ csInfo.toString());
		int flag = chargeStationService.updateCSInfo(csInfo);
		LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
		if(flag > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		    String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(csInfo.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改充电站");
			loggerInfoDto.setOPERATIONOBJECT(csInfo.getCSNAME());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！";
		}
		send(response, ReDto);
		//MODIFIED BY HANMJ 20170717 BEGIN
		//return "/chargeStation/findChargeStationFirst";
//		return "/chargeStation/findCSFirst";
		//MODIFIED BY HANMJ 20170717 END 
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/csExport")
	public void csExport(HttpServletRequest request,
			HttpServletResponse response, FindCSInfoDto findCSInfoDto)
			throws IOException {
		//查找出充电站信息列表
		List<CSInfoDto> csList = chargeStationService
				.findcsexport(findCSInfoDto);
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		//程序路径
		URL url = this.getClass().getClassLoader().getResource("");
		
		String FROMDATE = findCSInfoDto.getFROMDATE();
		String TODATE = findCSInfoDto.getTODATE();
		String LOCATION = findCSInfoDto.getLOCATION();
		String CSNAME = findCSInfoDto.getCSNAME();
		String OPERATORNAME = findCSInfoDto.getOPERATORNAME();
		//获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		usermap.put("FROMDATE", FROMDATE);
		usermap.put("TODATE", TODATE);
		usermap.put("LOCATION", LOCATION);
		usermap.put("CSNAME", CSNAME);
		usermap.put("OPERATORNAME", OPERATORNAME);
		//模板路径
		String templateFileName = null;
		//保存路径
		String resultFileName = null;
		
		templateFileName = "excel/chargeStationReports.xlsx";
		resultFileName = "excel/充电站信息.xlsx";
		
		dataList.add(usermap);
		
		new ExcelUtil().createExcel(templateFileName, csList , dataList,
				csList, resultFileName);
		
		String destFilePath = url.getPath() + resultFileName;
		//下载文件
		download(destFilePath, response);
		//删除文件
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
	}
	
	// 增加运营商的同时，增加费率模板
		public int addBill(String operatorid, String csid) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);// 获取当前年
			float SERVICETIP = (float) 0.8;
			float JPRICE = (float) 1.4;//
			float FPRICE = (float) 1.6;//
			float PPRICE = (float) 1.8;//
			float GPRICE = (float) 2;//

			List<BillModelDto> list = new ArrayList<BillModelDto>();
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 12; i++) {
					BillModelDto billModelDto = new BillModelDto();
					billModelDto.setOPERATORID(operatorid);
					billModelDto.setCSID(csid);
					billModelDto.setRATEID(String.valueOf(j + 1));
					billModelDto.setBILLMODELID(String.valueOf((i + 1)));
					billModelDto.setVALIDTIME(ControllerUtil.getFirstDayOfMonth(year, i)
							+ " 00:00:00");
					billModelDto.setINVALIDTIME(ControllerUtil.getLastDayOfMonth(year, i)
							+ " 23:59:59");
					billModelDto.setTIMEINTERVALCOUNT("4");
					billModelDto.setSERVICETIP(SERVICETIP);
					billModelDto.setJPRICE(JPRICE);
					billModelDto.setFPRICE(FPRICE);
					billModelDto.setPPRICE(PPRICE);
					billModelDto.setGPRICE(GPRICE);
					billModelDto.setTI_1_ID("1");
					billModelDto.setTI_1_START("360");
					billModelDto.setTI_2_ID("2");
					billModelDto.setTI_2_START("900");
					billModelDto.setTI_3_ID("0");
					billModelDto.setTI_3_START("1080");
					billModelDto.setTI_4_ID("3");
					billModelDto.setTI_4_START("1320");

					billModelDto.setTI_5_ID("0");
					billModelDto.setTI_5_START("0");
					billModelDto.setTI_6_ID("0");
					billModelDto.setTI_6_START("0");
					billModelDto.setTI_7_ID("0");
					billModelDto.setTI_7_START("0");
					billModelDto.setTI_8_ID("0");
					billModelDto.setTI_8_START("0");
					list.add(billModelDto);
				}
			}
			int billcount = operatorService.addBill(list);
			return billcount;
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
	
	
	// 获取充电站详细信息 用于详情页面和导出记录
		@RequestMapping("/findChargeStationById")
		public void findChargeStationByIdajax(HttpServletRequest request,HttpServletResponse response) throws IOException {
			response.addHeader("Access-Control-Allow-Origin", "*");
			JsonReDto ReDto = new JsonReDto();
			String CSID = request.getParameter("CSID");
			FindCPDto findCPDto = new FindCPDto();
			findCPDto.setCSID(CSID);
			List<CSInfoDto> csDto = chargeStationService.findCSDetailById(CSID);
			List<CSInfoDto> list = chargeStationService.findCPCharge(findCPDto);

			if(csDto.size() == 0 && list.size()==0){
				ReDto.returnCode = 1;
				ReDto.errorCode = "1";
				ReDto.message = "查找失败！";			
			}else{
				ReDto.returnCode = 0;
				ReDto.errorCode = "0";
				ReDto.message = "查找成功！";
				ReDto.detail.put("page", csDto);
				ReDto.detail.put("list", list);
			}
			send(response, ReDto);
		}
		
		
		/**
		 * 数据导出
		 * 
		 * @param request
		 * @throws IOException
		 */
		@RequestMapping("/csDetailExport")
		public void csDetailExport(HttpServletRequest request,
				HttpServletResponse response, FindCPDto findCPDto)
				throws IOException {

			List<CSInfoDto> chargeList = chargeStationService
					.findCPCharge(findCPDto);

			List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
			Map<String, Object> itemMap = new HashMap<String, Object>();
			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩名");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH1");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电站");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH2");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "费率模板");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH3");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电次数");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH4");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电时长");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH5");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电电量(kWh)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH6");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "服务费(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH7");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "基础电费(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH8");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电总费用(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH9");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩厂商");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH10");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩型号");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH11");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "建桩日期");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH12");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "详细地址");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH13");
			headInfoList.add(itemMap);

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			Map<String, Object> dataItem = null;
			for (int i = 0; i < chargeList.size(); i++) {
				dataItem = new HashMap<String, Object>();
				CSInfoDto csInfoDto = chargeList.get(i);
				dataItem.put("XH1", "" + csInfoDto.getCSNAME());
				dataItem.put("XH2", "" + csInfoDto.getCPNAME());
				dataItem.put("XH3", "" + csInfoDto.getRATEID());

				if (csInfoDto.getCPCOUNT() == null) {
					dataItem.put("XH4", "");
				} else {
					dataItem.put("XH4", "" + csInfoDto.getCPCOUNT());
				}

				if (csInfoDto.getCHARGETIMESPAN() == null) {
					dataItem.put("XH5", "");
				} else {
					dataItem.put("XH5", "" + csInfoDto.getCHARGETIMESPAN());
				}
				if (csInfoDto.getCHARGEQUANTITY() == null) {
					dataItem.put("XH6", "");
				} else {
					dataItem.put("XH6", "" + csInfoDto.getCHARGEQUANTITY());
				}

				if (csInfoDto.getSERVICETIP() == null) {
					dataItem.put("XH7", "");
				} else {
					dataItem.put("XH7", "" + csInfoDto.getSERVICETIP());
				}

				if (csInfoDto.getCHARGEMONEY() == null) {
					dataItem.put("XH8", "");
				} else {
					dataItem.put("XH8", "" + csInfoDto.getCHARGEMONEY());
				}

				if (csInfoDto.getMONEYCOUNT() == null) {
					dataItem.put("XH9", "");
				} else {
					dataItem.put("XH9", "" + csInfoDto.getMONEYCOUNT());
				}
				dataItem.put("XH10", "" + csInfoDto.getMFRNAME());
				dataItem.put("XH11", "" + csInfoDto.getMODEL());
				dataItem.put("XH12", "" + csInfoDto.getCREATETIME());
				dataItem.put("XH13", "" + csInfoDto.getLOCATION());
				dataList.add(dataItem);
			}
			POIUtil.exportExcel2FilePath("充电站桩信息", "D://充电站桩信息.xls", headInfoList,
					dataList);
			download("D://充电站桩信息.xls", response);
			DeleteFileUtil.deleteFile("D://充电站桩信息.xls");// 删除保存的excel文件
		}
}

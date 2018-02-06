package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.ProtocolInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.service.BasicDataService;
import cn.com.start.webBack.service.ChargePileService;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.service.ManufacturersService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ExcelUtil;
import cn.com.start.webBack.util.POIUtil;

@Controller
@RequestMapping("/chargePile")
public class ChargePileController extends BaseController {

	@Autowired
	private ChargePileService chargePileService;
	@Autowired
	private ManufacturersService manufacturersService;
	@Autowired
	private BasicDataService basicDataService;
	@Autowired
	private LoggerInfoService loggerInfoService;

	// 首次进入页面 查询辅助数据
	@RequestMapping("/findCPFirst")
	public void findCPByPage(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String operatorloginid) throws IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		FindCPDto findCPDto = new FindCPDto();
		findCPDto.setOPERATORLOGINID(operatorloginid);
		List<CPInfoDto> cpInfoList = chargePileService.showCPByPage(findCPDto);
		if(cpInfoList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", cpInfoList);
		}
		send(response, ReDto);
	}

//	// 保存查询条件 分页查询 切换页码
//	@ResponseBody
//	@RequestMapping("/findCPSaveData")
//	public void findCPSaveData(HttpServletResponse response,FindCPDto findCPDto) throws IOException {
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		JsonReDto ReDto = new JsonReDto();
//		List<CPInfoDto> cpInfoList = chargePileService.showCPByPage(findCPDto);
//		if (cpInfoList.size() == 0) {
//			ReDto.returnCode = 1;
//			ReDto.errorCode = "1";
//			ReDto.message = "查找失败！";
//		} else {
//			ReDto.returnCode = 0;
//			ReDto.errorCode = "0";
//			ReDto.message = "查找成功！";
//			ReDto.detail.put("cpInfoList", cpInfoList);
//		}
//		send(response, ReDto);;
//	}

	/**
	 * 进入增加充电桩页面，加载数据
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@RequestMapping("/chargePileAddFindData")
	public String chargePileAddFindData(HttpServletResponse response,@RequestParam String operatorloginid,Model model) throws JsonGenerationException, JsonMappingException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		//查询省列表
		List<Province> proList = locationService.findProvince();
		// 获取boss及其下属运营商
		List<OperatorInfo> newoperList = operatorService.findNewOperator(operatorloginid);
		//厂商列表
		List<CPMfrInfo> mfrList = manufacturersService.findCPMfr();
		//查询协议列表
		List<ProtocolInfo> infoList = chargePileService.findProtocol();
		//查询费率模板
		List<String> billList = basicDataService.findBill(operatorloginid);
		
		model.addAttribute("proList",proList);
		model.addAttribute("operList",newoperList);
		model.addAttribute("mfrList",mfrList);
		model.addAttribute("infoList",infoList);
		model.addAttribute("billList",billList);
		return "//jsp/DM/chargePileAdd.jsp";
	}
	
	
	/**
	 * 新增充电桩
	 * 
	 * @param request
	 * @param chargePile
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/addChargePile")
	public void addChargePile(HttpServletRequest request,HttpServletResponse response,
			CPInfo cpInfo)throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		int areaId = 0;
		String cpname = cpInfo.getCPNAME();// 获取桩名
		String operatorid = cpInfo.getOPERATORID();// 获取运营商id
		String csid = cpInfo.getCSID();// 获取站id
		String mfrid = cpInfo.getMFRID();// 获取桩厂商id
		String model = cpInfo.getMODEL();// 获取桩型号
		String rateid = cpInfo.getRATEID();// 获取费率id
		String deviceid = cpInfo.getDEVICEID();//获取设备号
		String protocolid = cpInfo.getPROTOCOLID();// 获取通信规约
		Address address = null;
		// 站内桩 找到地址id
		address = addressService.findAddressByCSId(Integer.parseInt(cpInfo.getCSID()));
		areaId = address.getAREAID();
		Format format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		// 区ID加上ID
		long temp = chargePileService.findCPIdBeforeAdd(areaId);
		if (temp == 0) {
			// 如果没找到 则为该区域第一个桩 区号+0001
			temp = 1;
		} else {
			// 否则直接+1 如 612222+0002
			temp += 1;
		}
		// 是否存在设备id
		int count = chargePileService
				.findDeviceid(cpInfo.getDEVICEID());
		
			CPInfo cpin = new CPInfo();
			if (count == 0) {
				// 如果设备id不存在
				cpin.setDEVICEID(deviceid);
				//组桩ID、name
				cpin.setCPID(String.valueOf(areaId)+"0000"+deviceid);
				cpin.setCPNAME(cpname);
				cpin.setOPERATORID(operatorid);
				cpin.setCSID(csid);
				cpin.setMFRID(mfrid);
				cpin.setMODEL(model);
				cpin.setRATEID(rateid);
				cpin.setPROTOCOLID(protocolid);
				cpin.setVALIDFLAG("1");
				cpin.setADDRESSID(String.valueOf(address.getADDRESSID()));
				cpin.setCREATETIME(format.format(new Date()));
				int flag = chargePileService.addlist(cpin);
				if(flag > 0){
					ReDto.returnCode = 0;
					ReDto.errorCode = "0";
					ReDto.message = "增加成功！";
					ReDto.detail.put("address", null);
					
					LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
					SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
					String OPERATINGTIME = Format.format(new Date());
					loggerInfoDto.setOPERATINGUSER(cpInfo.getOPERATORLOGINID());
					loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
					loggerInfoDto.setOPERATING("增加");
					loggerInfoDto.setOPERATIONCONTENT("增加充电桩");
					loggerInfoDto.setOPERATIONOBJECT(cpin.getCPID());
					loggerInfoService.insertLoggerInfo(loggerInfoDto);
				}else{
					ReDto.returnCode = 1;
					ReDto.errorCode = "1";
					ReDto.message = "增加失败！请重试！";
				}
				send(response, ReDto);
			} else {
				ReDto.returnCode = 1;
				ReDto.errorCode = "2";
				ReDto.message = "设备ID已存在！";
				send(response, ReDto);
			}
	}

	/**
	 * 根据id删除充电桩 删除后调用异步查询 刷新页面
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/deleteCPById")
	public void deleteCPById(HttpServletResponse response,@RequestParam String CPID
			,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String cpids[] = CPID.substring(1).split(",");
		
		int flag = chargePileService.deleteCPById(cpids);
		if(flag > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功!";
			//操作入库
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(operatorloginid);
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("删除");
			loggerInfoDto.setOPERATIONCONTENT("删除充电桩");
			for (int i = 0; i < cpids.length; i++) {
				loggerInfoDto.setOPERATIONOBJECT(cpids[i]);
				loggerInfoService.insertLoggerInfo(loggerInfoDto);
			}
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！";
		}
		send(response, ReDto);
	}

	/**
	 * 查询数据,进入充电桩修改页面
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/findUpdateData")
	public void findUpdateData(HttpServletResponse response,@RequestParam String CPID,
			@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		List<CPInfo> cpInfoList = chargePileService.findCPById(CPID);
		//根据cpId查询桩基本信息 用于update
//		AddressDto addressDto = addressService.findAddressDtoByCPId(CPID);
//		List<Province> proList = locationService.findProvince();
//		List<City> cityList = locationService.findCityByPro(addressDto
//				.getPROVINCEID());
//		List<Area> areaList = locationService.findAreaByCity(addressDto
//				.getCITYID());
//		List<Address> addressList = locationService
//				.findAddressByArea(addressDto.getAREAID());
//		cpDto.setProList(proList); //省市区地址当前地址桩信息
//		cpDto.setCityList(cityList);
//		cpDto.setAreaList(areaList);
//		cpDto.setAddressList(addressList);
//		cpDto.setAddressDto(addressDto);
//		cpDto.setCpInfo(cpInfo);
		// 查询运营商、CPM、充电站
//		List<OperatorInfo> newoperList = operatorService
//				.findNewOperator(operatorloginid);// 获取boss及其下属运营商
		List<CSInfo> csList = operatorService.findCSByOper(Integer
				.parseInt(cpInfoList.get(0).getOPERATORID()));
		// 查询厂商
		List<CPMfrInfo> mfrList = manufacturersService.findCPMfr();
		List<String> modelList = manufacturersService.findModelByMfr(cpInfoList.get(0)
				.getMFRID());
		List<String> billList = basicDataService.findBillByCPID(CPID);
		List<CPInfoDto> chargePatternList = basicDataService.findchargePattern();
		if(cpInfoList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查询失败！";
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查询成功！";
			ReDto.detail.put("cpInfoList", cpInfoList);
			ReDto.detail.put("csList", csList);
			ReDto.detail.put("mfrList", mfrList);
			ReDto.detail.put("modelList", modelList);
			ReDto.detail.put("billList", billList);
			ReDto.detail.put("chargePatternList", chargePatternList);
		}
		send(response, ReDto);
	}

	/**
	 * 修改充电桩
	 * 
	 * @param request
	 * @param chargePile
	 * @param fullLocDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateChargePile")
	public void updateChargePile(HttpServletResponse response,HttpServletRequest request
						,CPInfo cpInfo) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		Address address;
		address = addressService.findAddressByCSId(Integer.parseInt(cpInfo
				.getCSID()));
		cpInfo.setADDRESSID(String.valueOf(address.getADDRESSID()));
		logger.info(" before updateChargePile="+cpInfo.toString());
		int flag = chargePileService.updateChargePile(cpInfo);
		if(flag > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			//操作入库
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(cpInfo.getOPERATORLOGINID());
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改充电桩");
			loggerInfoDto.setOPERATIONOBJECT(cpInfo.getCPID() + "_" + cpInfo.getCPNAME());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！";
		}
		send(response, ReDto);
	}

	/**
	 * 数据导出 充电桩 导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/chargePileExport")
	@ResponseBody
	public void chargePileExport(HttpServletRequest request,
			HttpServletResponse response, FindCPDto findCPDto)
			throws IOException {
		List<CPInfoDto> chargePileList = chargePileService
				.findCPDetailexport(findCPDto);
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> usermap = new HashMap<String, Object>();
		//程序路径
		URL url = this.getClass().getClassLoader().getResource("");
		
		String FROMDATE = findCPDto.getFROMDATE();
		String TODATE = findCPDto.getTODATE();
		String LOCATION = findCPDto.getLOCATION();
		String CSNAME = findCPDto.getCSID();
		String OPERATORNAME = findCPDto.getOPERATORNAME();
		String CPID = findCPDto.getCPID();
		//获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(new Date());
		
		usermap.put("FROMDATE", FROMDATE);
		usermap.put("TODATE", TODATE);
		usermap.put("LOCATION", LOCATION);
		usermap.put("CSNAME", CSNAME);
		usermap.put("OPERATORNAME", OPERATORNAME);
		usermap.put("CPID", CPID);
		usermap.put("now", now);
		//模板路径
		String templateFileName = null;
		//保存路径
		String resultFileName = null;
		
		templateFileName = "excel/chargePileReports.xlsx";
		resultFileName = "excel/充电桩信息.xlsx";
		
		dataList.add(usermap);
		
		new ExcelUtil().createExcel(templateFileName, chargePileList , dataList,
				chargePileList, resultFileName);
		
		String destFilePath = url.getPath() + resultFileName;
		//下载文件
		download(destFilePath, response);
		//删除文件
		DeleteFileUtil.deleteFile(destFilePath);// 删除保存的excel文件
		
	}
	
	@ResponseBody
	@RequestMapping("/findBill")
	public List<String> findbill(@RequestParam String CSID){
		List<String> billList = basicDataService.findBill(CSID);
		System.out.println("------------------"+billList);
		return billList;
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
	
	@RequestMapping("/findCPDetail")
	public void findCPDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String cpId = request.getParameter("CPID");
		FindCPDto findCPDto = new FindCPDto();
		findCPDto.setCPID(cpId);
		List<CPInfoDto> cpInfoDto = chargePileService.findCPDetail(findCPDto);
		List<UserChargeDto> list = chargePileService.findUserCharge(findCPDto);
		
		if(cpInfoDto.size() == 0 && list.size()==0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", cpInfoDto);
			ReDto.detail.put("list", list);
		}
		send(response, ReDto);
	}
	
	@RequestMapping("/chargeDetailExport")
	@ResponseBody
	public void chargeDetailExport(HttpServletRequest request,
			HttpServletResponse response, FindCPDto findCPDto)
			throws IOException {
		// 获取Id 查询该桩的充电记录
		List<UserChargeDto> userchargeList = chargePileService
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
	
	@RequestMapping("/deleteInfo")
	public void deleteInfo() {
		chargePileService.deleteInfo();
	}
	
}

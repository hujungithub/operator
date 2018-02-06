package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.FindAddressDto;
import cn.com.start.webBack.dto.LoggerInfoDto;
import cn.com.start.webBack.dto.UpdateCSDto;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.ProtocolInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.service.LoggerInfoService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.ControllerUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.ObjectListToJSON;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {

	@Autowired
	private LoggerInfoService loggerInfoService;
	/**
	 * 第一次进入查询
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/findAddressFirst")
	public void findAddressByPage(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindAddressDto findAddressDto = new FindAddressDto();
		List<AddressDto> list = addressService.showAddressByPage(findAddressDto);
		if(list.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", list);
		}
		new JsonUtil().send(response, ReDto);
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
	@RequestMapping("/findAddressSaveData")
	public void findAddressSavaData(HttpServletResponse response,FindAddressDto findAddressDto)
			throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<AddressDto> onePageAddressList = addressService.showAddressByPage(findAddressDto);
		if(onePageAddressList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("onePageAddressList", onePageAddressList);
		}
		send(response, ReDto);
	}

	/*
	 * 根据id删除
	 */
	@ResponseBody
	@RequestMapping("/deleteById")
	public void deleteById(HttpServletResponse response,@RequestParam String ADDRESSID
			,@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String ADDRESSIDS[] = ADDRESSID.substring(1).split(",");
		try {
			addressService.deleteById(ADDRESSIDS);
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功！";
			//操作入库
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(operatorloginid);
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("删除");
			loggerInfoDto.setOPERATIONCONTENT("删除地址");
			for (int i = 0; i < ADDRESSIDS.length; i++) {
				loggerInfoDto.setOPERATIONOBJECT(ADDRESSIDS[i]);
				loggerInfoService.insertLoggerInfo(loggerInfoDto);
			}
		} catch (Exception e) {
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除异常！";
		}finally {
			send(response, ReDto);
		}
	}
	
	
	@RequestMapping("/addressManageAddFindData")
	public String addressManageAddFindData(HttpServletResponse response,@RequestParam String operatorloginid,Model model) throws JsonGenerationException, JsonMappingException, IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		//查询省列表
		List<Province> proList = locationService.findProvince();
		
		model.addAttribute("proList",proList);
		return "//jsp/DM/addressAdd.jsp";
	}

	/**
	 * 新增地址
	 * @param addressDto
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/addAddress")
	public void addAddress(HttpServletResponse response,AddressDto addressDto,@RequestParam String OPERATORLOGINID) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String location = addressService.findPCAById(addressDto);
		location += addressDto.getADDRESSNAME();
		// 查出经纬度
		String lonlat[] = ControllerUtil.getCoordinate(location);
		// 不为空 则查到经纬度 插入数据库
		if (lonlat != null && lonlat.length != 0) {
			addressDto.setLONGITUDE(lonlat[0]);
			addressDto.setLATITUDE(lonlat[1]);
		}
		addressDto.setAREAID(addressDto.getAREAID());
		int flag =addressService.insertAddress(addressDto);
		if(flag > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "增加成功！";
			ReDto.detail.put("address", null);
			
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(OPERATORLOGINID);
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("增加");
			loggerInfoDto.setOPERATIONCONTENT("增加地址");
			loggerInfoDto.setOPERATIONOBJECT(addressDto.getADDRESSID().toString());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "增加失败！请重试！";
		}
		send(response, ReDto);
	}

	/**
	 * 修改之前查询数据
	 * @param ADDRESSID
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/findUpdateAddressData")
	public void updateAdminById(HttpServletResponse response,@RequestParam Integer ADDRESSID)
			throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		//根据ID查询地址信息
		List<AddressDto> addressDto = addressService.findAddressDtoById(ADDRESSID);
		List<Province> provinceList = locationService.findProvince();
		List<City> cityList = locationService.findCityByPro(addressDto.get(0)
				.getPROVINCEID());
		List<Area> areaList = locationService.findAreaByCity(addressDto.get(0)
				.getCITYID());
		ReDto.detail.put("addressDto", addressDto);
		ReDto.detail.put("proList", provinceList);
		ReDto.detail.put("cityList", cityList);
		ReDto.detail.put("areaList", areaList);
		send(response, ReDto);
	}

	/**
	 * 修改地址
	 * @param addressDto
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/updateAddress")
	public void updateAddress(HttpServletResponse response,AddressDto addressDto
			,@RequestParam String OPERATORLOGINID) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		
		int flag = addressService.updateById(addressDto);
		if(flag == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "修改失败！请检查地址是否有改动";
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "修改成功！";
			//操作入库
			LoggerInfoDto loggerInfoDto = new LoggerInfoDto();
			SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String OPERATINGTIME = Format.format(new Date());
			loggerInfoDto.setOPERATINGUSER(OPERATORLOGINID);
			loggerInfoDto.setOPERATINGTIME(OPERATINGTIME);
			loggerInfoDto.setOPERATING("修改");
			loggerInfoDto.setOPERATIONCONTENT("修改地址");
			loggerInfoDto.setOPERATIONOBJECT(addressDto.getADDRESSID().toString());
			loggerInfoService.insertLoggerInfo(loggerInfoDto);
		}
		send(response, ReDto);
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/addressExport")
	@ResponseBody
	public void Export(HttpServletRequest request, HttpServletResponse response,FindAddressDto findAddressDto)
			throws IOException {
		List<AddressDto> addressDtos = addressService
				.showAddressByPage(findAddressDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();
		itemMap.put("title", "省");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "市");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "区");
		itemMap.put("columnWidth", 40);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "地址");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "经度");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "纬度");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH6");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < addressDtos.size(); i++) {
			dataItem = new HashMap<String, Object>();
			AddressDto addressDto1 = addressDtos.get(i);
			dataItem.put("XH1", "" + addressDto1.getPROVINCENAME());
			dataItem.put("XH2", "" + addressDto1.getCITYNAME());
			dataItem.put("XH3", "" + addressDto1.getAREANAME());
			dataItem.put("XH4", "" + addressDto1.getADDRESSNAME());
			dataItem.put("XH5", "" + addressDto1.getLONGITUDE());
			dataItem.put("XH6", "" + addressDto1.getLATITUDE());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("充电桩地址管理", "D://充电桩地址管理.xls",
				headInfoList, dataList);
		download("D://充电桩地址管理.xls", response);
		DeleteFileUtil.deleteFile("D://充电桩地址管理.xls");// 删除保存的excel文件
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
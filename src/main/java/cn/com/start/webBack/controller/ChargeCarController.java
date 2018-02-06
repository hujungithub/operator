package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.CarInfoDto;
import cn.com.start.webBack.dto.FindCarInfoDto;
import cn.com.start.webBack.dto.ReturnCARDto;
import cn.com.start.webBack.dto.ReturnCPDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.service.AddressService;
import cn.com.start.webBack.service.ChargeCarService;
import cn.com.start.webBack.util.ControllerUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.Page;


@Controller
@RequestMapping("/chargeCar")
public class ChargeCarController extends BaseController{
	
	@Autowired
	public ChargeCarService chargeCarService;
	@Autowired
	public AddressService addressService;

	//findCarFirst
	// 保存查询条件 分页查询 切换页码
	@RequestMapping("/findCarFirst")
	public void findChargeCarByPage(HttpServletResponse response,HttpServletRequest request, @RequestParam String operatorloginid)
			throws IOException {
		/*response.addHeader("Access-Control-Allow-Origin", "*");*/
		JsonReDto ReDto = new JsonReDto();
		List<CarInfoDto> carList = chargeCarService.findCarInfo();
		ReDto.detail.put("page", carList);
		/*Page page = chargeCarService.showChargeCarByPage();
		List<String> modelList = chargeCarService.findCarModel();
		List<String> priceList = chargeCarService.findCarPrice();
		List<String> stateList = chargeCarService.findCarState();
		List<Province> provinceList = locationService.findProvince();
		System.out.println(modelList);
		System.out.println(priceList);
		System.out.println(page);
		ReDto.detail.put("page", modelList);
		ReDto.detail.put("page", priceList);
		ReDto.detail.put("page", stateList);
		ReDto.detail.put("page", provinceList);*/
		send(response,ReDto);
		
	}
	
	@ResponseBody
	@RequestMapping("/findCarInfoSaveData")
	public String findCarInfoSaveData(@RequestParam int pageSize,
			@RequestParam int pageNow, FindCarInfoDto findCarInfoDto)
			throws IOException {
		Page page = chargeCarService.showCarInfoByPage(findCarInfoDto);
		String json = JsonUtil.toJson(page);
		System.out.println(page);
		System.out.println(json);
		logger.info("findCarInfoSaveData=" + json);
		return json;
	}
	
	/*
	@RequestMapping("/addChargeCar")
	public String addChargeCar(@RequestParam int pageSize,
			@RequestParam int pageNow, CarInfoDto carInfoDto)
			throws IOException {
		carInfoDto.setPageNow(pageNow);
		carInfoDto.setPageSize(pageSize);
		System.out.println("------------carInfoDto------------"+carInfoDto);
		return null;
	}*/
	
	
	@RequestMapping("/deleteChargeCarById")
	public String deleteChargeCarById(@RequestParam String CARID) throws IOException {
		String carids[] = CARID.substring(1).split(",");
		for(int i = 0; i< carids.length;i++){
			System.out.println(carids[i]);
		}
		System.out.println("----------------删除车----------------");
		chargeCarService.deleteCarById(carids);
		return "/chargeCar/findCarFirst";
	}
	
	/**/
	@ResponseBody
	@RequestMapping("/findUpdateData")
	public String findUpdateData(@RequestParam String CARID, 
			@RequestParam String operatorloginid) throws IOException {
		
		CarInfoDto carInfoDto = chargeCarService.findCarById(CARID);
		System.out.println(carInfoDto);
		ReturnCARDto carDto = new ReturnCARDto();
		
//		List<String> carModelList = chargeCarService.findCarModel();
//		
//		List<String> carPriceList = chargeCarService.findCarPrice();
		
		carDto.setCarInfoDto(carInfoDto);
//		carDto.setCarModelList(carModelList);
//		carDto.setCarPriceList(carPriceList);
		
		
		String json = JsonUtil.toJson(carDto);
		logger.info("findUpdateData="+json);
		return json;
	}
	
	@RequestMapping("/updateChargeCar")
	public String updateChargeCar(HttpServletRequest request, CarInfoDto carInfoDto) throws IOException {
		String carId = request.getParameter("carid");
		carInfoDto.setCARID(carId);
		System.out.println("-------------carInfoDto--------------"+carInfoDto);
		System.out.println(carInfoDto.getCARID());
		int result = chargeCarService.updateChargeCar(carInfoDto);
		System.out.println(result);
		return "/chargeCar/findCarFirst";
	}
	
	@ResponseBody
	@RequestMapping("/findAddData")
	public String findAddData(@RequestParam String roleid, 
			@RequestParam String operatorloginid) throws IOException {
		
		ReturnCARDto carDto = new ReturnCARDto();
		
		List<String> carModelList = chargeCarService.findCarModel();
		
		List<String> carPriceList = chargeCarService.findCarPrice();
		
		carDto.setCarModelList(carModelList);
		carDto.setCarPriceList(carPriceList);
		
		String json = JsonUtil.toJson(carDto);
		logger.info("findAddData="+json);
		return json;
	}
	
	@RequestMapping("/addChargeCar")
	public String addChargeCar(HttpServletRequest request, @RequestParam String roleid, 
			@RequestParam String operatorid,CarInfoDto carInfoDto) throws IOException {
		
		AddressDto addressDto = new AddressDto();
		
		String PROVINCEID = request.getParameter("PROVINCEID");
		String CITYID = request.getParameter("CITYID");
		String AREAID = request.getParameter("AREAID");
		
		String ADDRESSNAME = request.getParameter("ADDRESSNAME");
		String addId = request.getParameter("ADDRESSID");
		
		String maxCarId = chargeCarService.findMaxCarId();
		
		//获取CarId
		String begin = maxCarId.substring(0, 3);
		String end = maxCarId.substring(3);
		String result = Integer.parseInt(end) + 1 + "";
		String carId = begin+ result;
		carInfoDto.setCARID(carId);
		
		carInfoDto.setAPPOINTID(0);
		carInfoDto.setCARSTATE("0");
		carInfoDto.setCARMODEL("0");
		carInfoDto.setRANK(5);
		carInfoDto.setMILEAGE(0);
		carInfoDto.setCARID(carId);
		carInfoDto.setCARSOC(100);
		
		//获取经纬度
		if(PROVINCEID != "" && PROVINCEID != null){
			addressDto.setPROVINCEID(Integer.parseInt(PROVINCEID));
		}
		if(CITYID != "" && CITYID != null){
			addressDto.setCITYID(Integer.parseInt(CITYID));
		}
		if(AREAID != "" && AREAID != null){
			addressDto.setAREAID(Integer.parseInt(AREAID));
		}
		if(ADDRESSNAME != "" && ADDRESSNAME != null){
			addressDto.setADDRESSNAME(ADDRESSNAME);
		}
		if(addId != "" && addId != null){
			addressDto.setAREAID(Integer.parseInt(addId));
		}
		if (addId.isEmpty()||"0".equals(addId) ) {
			// 地址id为空 则为新地址 新增一条地址记录
				addAddress(PROVINCEID,CITYID,AREAID,ADDRESSNAME,carInfoDto);
		}else{
			Address addr =  addressService.findAddressById(Integer.parseInt(addId));
			carInfoDto.setLATITUDE(addr.getLATITUDE());
			carInfoDto.setLONGITUDE(addr.getLONGITUDE());
		} 
		
		chargeCarService.addCarInfo(carInfoDto);
		
		return "/chargeCar/findCarFirst";
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
	//获取经纬度 
	public void addAddress(String provinceId, String cityId, String areaId,
			String addressname,CarInfoDto carInfoDto) throws IOException {
		// 先根据ID查出完整地址
		AddressDto addressDto = new AddressDto();
		addressDto.setPROVINCEID(Integer.parseInt(provinceId));
		addressDto.setCITYID(Integer.parseInt(cityId));
		addressDto.setAREAID(Integer.parseInt(areaId));
		addressDto.setADDRESSNAME(addressname);
		String location = addressService.findPCAById(addressDto);
		location += addressname;
		
		// 查出经纬度
		String lonlat[] = ControllerUtil.getCoordinate(location);
		// 不为空 则查到经纬度 插入数据库
		if (lonlat != null && lonlat.length != 0) {
			carInfoDto.setLONGITUDE(lonlat[0]);
			carInfoDto.setLATITUDE(lonlat[1]);
		}
	}
	
	
}

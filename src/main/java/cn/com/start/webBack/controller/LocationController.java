package cn.com.start.webBack.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.util.JsonUtil;

@Controller
@RequestMapping("/location")
public class LocationController extends BaseController {

	/**
	 * 根据省份查市
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findCityByPro")
	public String findCityByPro(@RequestParam Integer PROVINCEID)
			throws IOException {
		List<City> findCityList = locationService.findCityByPro(PROVINCEID);
		logger.info("======="+findCityList);
		String json = JsonUtil.toJson(findCityList);
		logger.info("findCityByPro=" + json);
		return json;
	}

	/**
	 * 根据市区查询区域
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/findAreaByCity")
	@ResponseBody
	public String findAreaByCity(@RequestParam Integer CITYID)
			throws IOException {
		List<Area> findAreaList = locationService.findAreaByCity(CITYID);
		String json = JsonUtil.toJson(findAreaList);
		logger.info("findAreaByCity=" + json);
		return json;
	}

	/**
	 * 根据区查询详细地址
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/findAddressByArea")
	@ResponseBody
	public String findAddressByArea(@RequestParam Integer AREAID)
			throws IOException {
		List<Address> findAddressList = locationService
				.findAddressByArea(AREAID);
		String json = JsonUtil.toJson(findAddressList);
		System.out.println("----------------json----------------:"+json);
		logger.info("findAddressByArea=" + json);
		return json;
	}

}

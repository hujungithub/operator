package cn.com.start.webBack.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.service.AddressService;
import cn.com.start.webBack.service.LocationService;
import cn.com.start.webBack.util.ControllerUtil;

public class BaseController extends LoggerController {

	@Autowired
	public LocationService locationService;

	@Autowired
	public AddressService addressService;
	
	
	/**
	 * 新增的地址 返回地址id
	 * 
	 * @param provinceId
	 * @param cityId
	 * @param areaId
	 * @param addressname
	 * @return
	 * @throws IOException
	 */
	public int addAddress(String provinceId, String cityId, String areaId,
			String addressname) throws IOException {
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
			addressDto.setLONGITUDE(lonlat[0]);
			addressDto.setLATITUDE(lonlat[1]);
		}
		// 新增地址 返回id
		String temp = addressService.findAddressIdBeforeAdd();
		if (temp == null) {
			temp = "0";
		}
		addressDto.setADDRESSID(Integer.parseInt(temp) + 1);
		int flag = addressService.addAddress(addressDto);
		if (flag == 1) {
			return Integer.parseInt(temp) + 1;
		} else {
			return 0;
		}
	}

}

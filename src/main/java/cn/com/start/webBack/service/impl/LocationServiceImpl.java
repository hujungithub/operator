package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FullLocDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.mapper.LocationMapper;
import cn.com.start.webBack.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Resource
	public LocationMapper locationMapper;

	/**
	 * 返回省份信息list
	 */
	@Override
	public List<Province> findProvince() {
		List<Province> findProvinceList = locationMapper.selectProvince();
		return findProvinceList;
	}

	/**
	 * 根据省份id 返回市区信息list
	 */
	@Override
	public List<City> findCityByPro(int provinceId) {
		List<City> findCityList = locationMapper.selectCityByPro(provinceId);
		return findCityList ;
	}

	/**
	 * 根据市区id 返回区域信息list
	 */
	@Override
	public List<Area> findAreaByCity(int cityId) {
		List<Area> findAreaList = locationMapper.selectAreaByCity(cityId);
		return findAreaList;
	}

	/**
	 * 根据区域查询地址
	 */
	@Override
	public List<Address> findAddressByArea(int areaId) {
		List<Address> findAddressList = locationMapper
				.selectAddressByArea(areaId);
		return findAddressList;
	}

	/**
	* 新增一条address记录
	*/
	@Override
	public int addAddress(int addressId, String address, int father) {
		int flag = locationMapper.insertAddress(addressId, address, father);
		return flag;
	}

	/**
	 * 新增address前查询nextval
	 */
	@Override
	public int findAddressIdBeforeAdd() {
		int addressId = locationMapper.selectAddressIdBeforeAdd();
		return addressId;
	}

	/**
	 * 查找桩或站的完整记录 拼接字符串
	 */
	@Override
	public FullLocDto findFullLocByCPID(int cpId) {
		FullLocDto fullLocDto = locationMapper.selectFullLocByCPID(cpId);
		return fullLocDto;
	}

	/**
	 * 经纬度数据 需要地址
	 */
	@Override
	public String findLocationByCPID(int addressId) {
		FullLocDto fullLocDto = locationMapper.selectLocById(addressId);
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append(fullLocDto.getPROVINCENAME())
				.append(fullLocDto.getCITYNAME())
				.append(fullLocDto.getAREANAME())
				.append(fullLocDto.getADDRESSNAME());
		return sbBuffer.toString();
	}
}

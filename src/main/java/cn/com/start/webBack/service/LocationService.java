package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FullLocDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.Province;

public interface LocationService {

	// 查询省
	List<Province> findProvince();

	// 根据省查市
	List<City> findCityByPro(int provinceId);

	// 根据市查区
	List<Area> findAreaByCity(int cityId);

	// 根据区查详细地址
	List<Address> findAddressByArea(int areaId);

	/**********************************************************/
	/**********************************************************/
	/**********************************************************/
	/**********************************************************/
	/**********************************************************/

	// 给hat_address表添加一条数据
	int addAddress(int addressId, String address, int father);

	// 新增address前查询nextval
	int findAddressIdBeforeAdd();

	// 查出桩的所有地址信息
	FullLocDto findFullLocByCPID(int cpId);

	// 经纬度查询桩的地址 拼接字符串
	String findLocationByCPID(int addressId);

}

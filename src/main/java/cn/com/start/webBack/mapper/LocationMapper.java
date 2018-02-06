package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.FullLocDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.Province;

public interface LocationMapper {
	// **********************************************
	// 查询省份
	List<Province> selectProvince();

	// 根据省查询市
	List<City> selectCityByPro(int provinceId);

	// 根据市查询地区
	List<Area> selectAreaByCity(int cityId);

	// 根据区查地址
	List<Address> selectAddressByArea(int areaId);

	// // ***************************************************
	//
	// // 新增Address前查询nextval
	int selectAddressIdBeforeAdd();

	// 新增address
	int insertAddress(@Param("addressId") int addressId,
			@Param("address") String address, @Param("father") int father);

	// 根据桩id查询桩的详细地址
	FullLocDto selectFullLocByCPID(int cpId);

	// 根据地址的ID查出地址信息 经纬度需要
	FullLocDto selectLocById(int addressId);
}

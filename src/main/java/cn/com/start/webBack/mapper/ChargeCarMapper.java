package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.CarInfoDto;
import cn.com.start.webBack.dto.FindCarInfoDto;

public interface ChargeCarMapper {

	// 分页查询地址
	//CarInfoDto
	
	List<CarInfoDto> selectCarInfoByPage();
	
	//方法重载
	List<CarInfoDto> selectCarInfoByPage_1(FindCarInfoDto findCarInfoDto);
	
	String selectCarInfoCount();
	
	List<String> selectCarStateInfo();
	
	List<String> selectCarModelInfo();
	
	List<String> selectCarRankInfo();
	
	List<String> selectCarPriceInfo();
	
	int deleteCarById(String [] carId);
	
	CarInfoDto selectCarInfoById(String carId);
	
	int updateChargeCarInfo(CarInfoDto carInfoDto);
	
	String selectMaxCarId();
	
	int insertCarInfo(CarInfoDto carInfoDto);
	
	String selectCarInfoCount_1(FindCarInfoDto findCarInfoDto);
	
	public List<CarInfoDto> selectCarInfo();
	
}

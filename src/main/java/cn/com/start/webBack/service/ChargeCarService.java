package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CarInfoDto;
import cn.com.start.webBack.dto.FindCarInfoDto;
import cn.com.start.webBack.util.Page;

public interface ChargeCarService {
	
	Page showChargeCarByPage();

	Page showChargeCarByPage_1(FindCarInfoDto findCarInfoDto);
	//查询车状态
	List<String> findCarState();
	
	//查询车型号
	List<String> findCarModel();
	
	//查询车价格
	List<String> findCarPrice();
	
	//查询车评级
	List<String> findCarRank();
	
	Page showCarInfoByPage(FindCarInfoDto findCarInfoDto);
	
	//根据id删除车信息
	int deleteCarById(String [] carId);
	
	CarInfoDto findCarById(String carId);
	
	int updateChargeCar(CarInfoDto carInfoDto);
	
	String findMaxCarId();
	
	void addCarInfo(CarInfoDto carInfoDto);
	
	public List<CarInfoDto> findCarInfo();
	
}

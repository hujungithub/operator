package cn.com.start.webBack.dto;

import java.util.List;

import cn.com.start.webBack.entity.Province;

public class ReturnCARDto {

	//查询中要返回的车信息，包括各种list
	// 车信息
	private CarInfoDto carInfoDto;
	
	//需要添加的list列表
	//车状态、车型号、评价等级
	private List<String> carModelList;
	//评级 		！！！！不能用的原因是Integer的问题么？
	private List<String> carRankList;
	//车状态
	private List<String> carStateList;
	
	//车状态
	private List<String> carPriceList;
	
	private List<Province> provinceList;


	public List<Province> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Province> provinceList) {
		this.provinceList = provinceList;
	}

	public List<String> getCarPriceList() {
		return carPriceList;
	}

	public void setCarPriceList(List<String> carPriceList) {
		this.carPriceList = carPriceList;
	}

	public CarInfoDto getCarInfoDto() {
		return carInfoDto;
	}

	public void setCarInfoDto(CarInfoDto carInfoDto) {
		this.carInfoDto = carInfoDto;
	}

	public List<String> getCarModelList() {
		return carModelList;
	}

	public void setCarModelList(List<String> carModelList) {
		this.carModelList = carModelList;
	}

	public List<String> getCarRankList() {
		return carRankList;
	}

	public void setCarRankList(List<String> carRankList) {
		this.carRankList = carRankList;
	}

	public List<String> getCarStateList() {
		return carStateList;
	}

	public void setCarStateList(List<String> carStateList) {
		this.carStateList = carStateList;
	}
	
	
	
}

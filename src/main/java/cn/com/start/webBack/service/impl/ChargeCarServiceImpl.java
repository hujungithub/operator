package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.CarInfoDto;
import cn.com.start.webBack.dto.FindCarInfoDto;
import cn.com.start.webBack.mapper.ChargeCarMapper;
import cn.com.start.webBack.service.ChargeCarService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ChargeCarServiceImpl implements ChargeCarService{

	@Resource
	public ChargeCarMapper chargeCarMapper;
	@Override
	public Page showChargeCarByPage() {
		// TODO Auto-generated method stub
		List<CarInfoDto> carInfolist = chargeCarMapper.selectCarInfoByPage();
//		int count = chargeCarMapper.selectCarInfoCount();
		
		String count = chargeCarMapper.selectCarInfoCount();
		//要有一个查询总数的sql
		System.out.println("----count----"+count);
		Page page = new Page(Integer.parseInt(count), 10,
				1);
		page.setList(carInfolist);
		System.out.println(carInfolist);
		return page;
	}
	
	@Override
	public List<String> findCarState() {
		// TODO Auto-generated method stub
		List<String> carStateInfoList = chargeCarMapper.selectCarStateInfo();
		return carStateInfoList;
	}
	
	@Override
	public List<String> findCarModel() {
		// TODO Auto-generated method stub
		List<String> carModelInfoList = chargeCarMapper.selectCarModelInfo();
		return carModelInfoList;
	}
	
	@Override
	public Page showCarInfoByPage(FindCarInfoDto findCarInfoDto) {
		// TODO Auto-generated method stub
		
		List<CarInfoDto>carInfoDtoList = chargeCarMapper.selectCarInfoByPage_1(findCarInfoDto);
		String count = chargeCarMapper.selectCarInfoCount();
		
		/*这个方法备用，用于修改分页中的数字显示错误的bug*/
		String cou = chargeCarMapper.selectCarInfoCount_1(findCarInfoDto);
		System.out.println("---------------cou------------------"+cou);
		
		Page page = new Page(Integer.parseInt(count), findCarInfoDto.getPageSize(),
				findCarInfoDto.getPageNow());
		page.setList(carInfoDtoList);
		return page;
	}

	@Override
	public int deleteCarById(String[] carId) {
		// TODO Auto-generated method stub
		int flag = chargeCarMapper.deleteCarById(carId);
		return flag;
	}

	@Override
	public CarInfoDto findCarById(String carId) {
		// TODO Auto-generated method stub
		
		return chargeCarMapper.selectCarInfoById(carId);
	}

	@Override
	public List<String> findCarRank() {
		// TODO Auto-generated method stub
		return chargeCarMapper.selectCarRankInfo();
	}

	@Override
	public List<String> findCarPrice() {
		return chargeCarMapper.selectCarPriceInfo();
	}

	@Override
	public int updateChargeCar(CarInfoDto carInfoDto) {
		// TODO Auto-generated method stub
		
		return chargeCarMapper.updateChargeCarInfo(carInfoDto);
	}

	@Override
	public String findMaxCarId() {
		return chargeCarMapper.selectMaxCarId();
	}

	@Override
	public void addCarInfo(CarInfoDto carInfoDto) {
		// TODO Auto-generated method stub
		chargeCarMapper.insertCarInfo(carInfoDto);
	}

	@Override
	public Page showChargeCarByPage_1(FindCarInfoDto findCarInfoDto) {
		List<CarInfoDto> carInfolist = chargeCarMapper.selectCarInfoByPage();
//		int count = chargeCarMapper.selectCarInfoCount();
		
		String count = chargeCarMapper.selectCarInfoCount_1(findCarInfoDto);
		//要有一个查询总数的sql
		System.out.println("----count----"+count);
		Page page = new Page(Integer.parseInt(count), 10,
				1);
		page.setList(carInfolist);
		System.out.println(carInfolist);
		return page;
	}

	/**
	 * @Title: findCarInfo
	 * @Description: TODO 查找车辆信息
	 * @return
	 * @see cn.com.start.webBack.service.ChargeCarService#findCarInfo()
	 */
	@Override
	public List<CarInfoDto> findCarInfo() {
		List<CarInfoDto> list = chargeCarMapper.selectCarInfo();
		return list;
	}
}

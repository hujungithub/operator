package cn.com.start.DPF.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.com.start.DPF.entity.car.CarInfo;
import cn.com.start.DPF.entity.car.CarStateType;
import cn.com.start.DPF.mapper.CarOperationMapper;


@Service
@Transactional
public class CarOperationServiceImpl implements CarOperationService {

	@Resource
	private CarOperationMapper carOperationMapper;

	@Override
	public List<CarInfo> findCarInfo() {
		List<CarInfo> carList = carOperationMapper.getCarInfo(); 
		return carList;
	}

	@Override
	public List<CarStateType> findCarStateType() {
		List<CarStateType> stateTypeList = carOperationMapper.getCarStateType();
		return stateTypeList;
	}

	
}

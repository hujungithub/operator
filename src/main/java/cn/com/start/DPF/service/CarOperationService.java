package cn.com.start.DPF.service;

import java.util.List;

import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.car.CarInfo;
import cn.com.start.DPF.entity.car.CarStateType;
import cn.com.start.DPF.entity.carddata.CardShortMessage;

public interface CarOperationService {
	// 查询汽车信息
	List<CarInfo> findCarInfo();
	
	// 查询汽车状态类型
	List<CarStateType> findCarStateType();
	
}

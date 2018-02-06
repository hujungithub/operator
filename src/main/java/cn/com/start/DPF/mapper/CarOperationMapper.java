package cn.com.start.DPF.mapper;

import java.util.List;



import cn.com.start.DPF.entity.car.CarInfo;
import cn.com.start.DPF.entity.car.CarStateType;

public interface CarOperationMapper {
	
	List<CarInfo> getCarInfo();
	
	List<CarStateType> getCarStateType();
		
	
}

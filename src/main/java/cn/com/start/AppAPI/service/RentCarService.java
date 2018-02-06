package cn.com.start.AppAPI.service;


import java.util.List;

import cn.com.start.AppAPI.dto.AppointmentCarDto;
import cn.com.start.AppAPI.dto.CarRecordDto;
import cn.com.start.AppAPI.dto.CarlistInfoDto;

public interface RentCarService {
	/*预约*/
	void addAppointmentInfo(AppointmentCarDto appointment);
	/*更新预约状态*/
	void updateAppointment(AppointmentCarDto appointment);
	/*	租车列表*/
	List<CarlistInfoDto> getCarlistInfo();
	/*增加还车记录*/
	void addCarRecord(CarRecordDto resultDto);
	/*获取行程记录*/
	List<CarRecordDto> getCarRecord(String userId);
	/*通过SN查找汽车信息*/
	List<CarlistInfoDto> findCarInfoBySN(String sN);
	
}

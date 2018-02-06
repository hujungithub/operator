package cn.com.start.AppAPI.mapper;


import java.util.List;

import cn.com.start.AppAPI.dto.AppointmentCarDto;
import cn.com.start.AppAPI.dto.CarRecordDto;
import cn.com.start.AppAPI.dto.CarlistInfoDto;

public interface RentCarMapper {
	void insertAppointRecorder(AppointmentCarDto appointment);
	
	void updateAppointment(AppointmentCarDto appointment);
	
	List<CarlistInfoDto> getCarlistInfo();
	
	void addCarRecord(CarRecordDto resultDto);
	
	List<CarRecordDto> getCarRecord(String userId);

	/* @Title: findCarInfoBySN
	 * @Description: TODO
	 * @param sN
	 * @return
	 * @return: List<CarlistInfoDto>
	 */
	List<CarlistInfoDto> findCarInfoBySN(String SN);
}

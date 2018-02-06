package cn.com.start.AppAPI.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.com.start.AppAPI.dto.AppointmentCarDto;
import cn.com.start.AppAPI.dto.CarRecordDto;
import cn.com.start.AppAPI.dto.CarlistInfoDto;
import cn.com.start.AppAPI.mapper.RentCarMapper;
@Service
@Transactional
public class RentCarServiceImpl implements RentCarService {

	@Resource
	private RentCarMapper rentCarMapper;

	@Override
	public void addAppointmentInfo(AppointmentCarDto appointment) {
		rentCarMapper.insertAppointRecorder(appointment);
		
	}

	@Override
	public void updateAppointment(AppointmentCarDto appointment) {
		// TODO Auto-generated method stub
		rentCarMapper.updateAppointment(appointment);
	}

	@Override
	public List<CarlistInfoDto> getCarlistInfo() {
		return rentCarMapper.getCarlistInfo();
	}

	@Override
	public void addCarRecord(CarRecordDto resultDto) {
		// TODO Auto-generated method stub
		rentCarMapper.addCarRecord(resultDto);
	}

	@Override
	public List<CarRecordDto> getCarRecord(String userId) {
		// TODO Auto-generated method stub
		return rentCarMapper.getCarRecord(userId);
	}

	@Override
	public List<CarlistInfoDto> findCarInfoBySN(String SN) {
		List<CarlistInfoDto> carlistInfoDto = rentCarMapper.findCarInfoBySN(SN);
		return carlistInfoDto;
	}
	
	
}

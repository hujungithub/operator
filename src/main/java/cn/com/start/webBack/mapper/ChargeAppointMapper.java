package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.AppointInfoDto;

public interface ChargeAppointMapper {

	// 查询充电桩数量
	int getAppointCount();

	// 分页查询充电桩
	List<AppointInfoDto> selectAppointByPage(AppointInfoDto appointInfoDto);
	
	List<String> selectAppointState();

}

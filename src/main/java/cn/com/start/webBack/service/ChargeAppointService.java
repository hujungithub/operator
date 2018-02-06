package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.AppointInfoDto;
import cn.com.start.webBack.util.Page;

public interface ChargeAppointService {

	// 分页查询所有充电桩
	Page showAppointByPage(AppointInfoDto appointInfoDto);
	
	List<String> findAppointState();
}

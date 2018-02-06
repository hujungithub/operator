package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.AppointInfoDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.mapper.ChargeAppointMapper;
import cn.com.start.webBack.service.ChargeAppointService;
import cn.com.start.webBack.util.Page;


@Service
@Transactional
public class ChargeAppointServiceImpl implements ChargeAppointService {

	@Resource
	public ChargeAppointMapper chargeAppointMapper;

	@Override
	public Page showAppointByPage(AppointInfoDto appointInfoDto) {
		// TODO Auto-generated method stub
		int totalCount = chargeAppointMapper.getAppointCount();
		List<AppointInfoDto> appointInfoDtoList = chargeAppointMapper.selectAppointByPage(appointInfoDto);
		Page page = new Page(totalCount, 10,
				1);
		page.setList(appointInfoDtoList);
		return page;
	}

	@Override
	public List<String> findAppointState() {
		// TODO Auto-generated method stub
		return chargeAppointMapper.selectAppointState();
	}
}
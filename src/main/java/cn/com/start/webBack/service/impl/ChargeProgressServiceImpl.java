package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.webBack.dto.FindChargeProgressDto;
import cn.com.start.webBack.mapper.ChargeProgressMapper;
import cn.com.start.webBack.service.ChargeProgressService;

@Service
@Transactional
public class ChargeProgressServiceImpl implements ChargeProgressService{
	

	@Resource
	public ChargeProgressMapper chargeProgressMapper;

	@Override
	public List<ChargeProgressDto> findChargeProgressList(FindChargeProgressDto findChargeProgressDto) {
		List<ChargeProgressDto> chargeProgressList = chargeProgressMapper
								.findChargeProgressList(findChargeProgressDto);
		return chargeProgressList;
	}

	
}

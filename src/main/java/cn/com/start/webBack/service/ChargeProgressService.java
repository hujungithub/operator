package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.webBack.dto.FindChargeProgressDto;

public interface ChargeProgressService {

	List<ChargeProgressDto> findChargeProgressList(FindChargeProgressDto findChargeProgressDto);
}

package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.webBack.dto.FindChargeProgressDto;

public interface ChargeProgressMapper {

	List<ChargeProgressDto> findChargeProgressList(FindChargeProgressDto findChargeProgressDto);
}

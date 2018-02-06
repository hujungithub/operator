package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.util.Page;

public interface ChargeStationDetailService {

	List<CSInfoDto> findCSDetailById(String cSID);

	List<CSInfoDto> findCPCharge(FindCPDto findCPDto);

	List<CSInfoDto> findCSDetail(FindCPDto findCPDto);

}

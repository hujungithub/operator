package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;

public interface ChargePileDetailMapper {
	// 查询充电桩充电记录
	List<UserChargeDto> selectCpCharge(FindCPDto findCPDto);

	List<UserChargeDto> selectexportChargeDetail(FindCPDto findCPDto);

	// 查询充电桩详情 (导出桩列表)
	List<CPInfoDto> selectCPDetail(FindCPDto findCPDto);

	// 查询充电记录条数
	int getUserChargeCount(FindCPDto findCPDto);

	// // 查询充电桩运营信息
	List<OperInfoDto> selectOperInfo(FindCPDto findCPDto);
}

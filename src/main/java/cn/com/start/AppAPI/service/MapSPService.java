package cn.com.start.AppAPI.service;

import java.util.List;

import cn.com.start.AppAPI.dto.CPInfoDto_API;
import cn.com.start.AppAPI.dto.CscpIdDto;
import cn.com.start.AppAPI.dto.ListSMDto;
import cn.com.start.AppAPI.dto.MapSMDto;
import cn.com.start.AppAPI.dto.SelectMapDto;

public interface MapSPService {
	// 通过经纬度查找附近站
	List<MapSMDto> findNearCS(SelectMapDto selectMapDto);

	// 通过经纬度找站
	List<MapSMDto> findNearCPM(SelectMapDto selectMapDto);

	// 通过经纬度找桩
	// List<MapSMDto> findNearCP(SelectMapDto selectMapDto);

	// 列表找站 根据ID找csinfo
	List<ListSMDto> findCSList(SelectMapDto selectMapDto);

	// 列表找cpm 根据ID找cpminfo
	List<ListSMDto> findCPMList(SelectMapDto selectMapDto);

	// 根据站ID查询站内桩
	List<CPInfoDto_API> findCPInfoByCSId(String CSID);

	// 根据cpmid查询桩列表
	List<CPInfoDto_API> findCPInfoByCPMId(String CPMID);

	List<String> getCpId(String csId);
	
	List<CscpIdDto> selectCpId(String[] csId);
}

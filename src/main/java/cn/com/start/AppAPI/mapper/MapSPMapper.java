package cn.com.start.AppAPI.mapper;

import java.util.List;

import cn.com.start.AppAPI.dto.CPInfoDto_API;
import cn.com.start.AppAPI.dto.CscpIdDto;
import cn.com.start.AppAPI.dto.ListSMDto;
import cn.com.start.AppAPI.dto.MapSMDto;
import cn.com.start.AppAPI.dto.SelectMapDto;

public interface MapSPMapper {
	// 根据经纬度查询附近站
	List<MapSMDto> selectNearCS(SelectMapDto selectMapDto);

	// 根据经纬度查询附近CPM
	List<MapSMDto> selectNearCPM(SelectMapDto selectMapDto);

	// 根据经纬度查询附近CP
	// List<MapSMDto> selectNearCP(SelectMapDto selectMapDto);

	// 列表找站
	List<ListSMDto> selectCSList(SelectMapDto selectMapDto);

	// 列表找cpm
	List<ListSMDto> selectCPMList(SelectMapDto selectMapDto);

	// 根据站ID查询桩列表
	List<CPInfoDto_API> selectCPInfoByCSId(String CSID);

	// 根据cpmid查询cpm列表
	List<CPInfoDto_API> selectCPInfoByCPMId(String CPMID);
	// 列表找cp
	// List<MapCPDto> selectCPList(SelectMapDto selectMapDto);

	List<String> selectCpId(String csId);
	
	List<CscpIdDto> selectCpIdList(String[] csId);
}

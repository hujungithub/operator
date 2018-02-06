package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.FindCSInfoDto;
import cn.com.start.webBack.entity.CSInfo;

public interface ChargeStationService {
	//***************************************USED************************************************//
	
	List<CSInfoDto> showChargeStationByPage(FindCSInfoDto findCSInfoDto);
	
	int selectById(String[] cSIDS);
	
	int deleteById(String[] cSIDS);
	
	List<CSInfo> findChargeStationById(String cSID);
	
	List<AddressDto> findAddressDtoByCSId(String csid);
	
	int updateCPAddressIdByCSId(CSInfo csInfo);
	
	int insertChargeStation(CSInfo chargeStation);
	
	int updateCSInfo(CSInfo csInfo);
	
	//***************************************************************************************//
	

	
	
	
	
	
	



	int updateCPValidFlagByCSId(String[] cSIDS);


	List<CSInfoDto> findcsexport(FindCSInfoDto findCSInfoDto);

	// // 根据充电站id查找充电站地址id
	String findCSAddressId(String csId);

	// 根据站ID查询站详细信息 导出也需要
	List<CSInfoDto> findCSDetailById(String CSID);
	
	//查询充电站中桩详细
	List<CSInfoDto> findCPCharge(FindCPDto findCPDto);
	
	List<CSInfoDto> findCSDetail(FindCPDto findCPDto);

}

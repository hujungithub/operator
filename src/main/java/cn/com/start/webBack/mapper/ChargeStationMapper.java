package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.FindCSDto;
import cn.com.start.webBack.dto.FindCSInfoDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;

public interface ChargeStationMapper {

	//*************************************USER************************************************//
	
	// 条件查询充电站数量
	int getChargeStationCount(FindCSInfoDto findCSInfoDto);
		
	// 条件查询充电站
	List<CSInfoDto> selectChargeStationByPage(FindCSInfoDto findCSInfoDto);
		
	// 按id删除站
	int deleteById(String CSIDS[]);
	
	// 查询充电站内桩数量
	int selectById(String CSIDS[]);
	
	// 修改充电桩的地址ID
	int updateCPAddressIdByCSId(CSInfo csInfo);

	//*************************************************************************************//

	// 根据地址ID查询充电站地址
	List<AddressDto> selectAddressDtoByCSId(String CSID);

	// 通过ID查询充电站
	List<CSInfo> findChargeStationById(String CSID);

	

	// 根据充电站ID修改充电站下的充电桩为不可用
	int updateCPValidFlagByCSId(String CSIDS[]);

	// 修改充电站
	int updateCSInfo(CSInfo csInfo);

	
	// 根据站ID查询站详细 导出
	List<CSInfoDto> selectCSDetailById(String CSID);

	// 查询充电站中桩详细总数
	int getCPChargeCount(FindCPDto findCPDto);

	// 查询充电站中桩详细
	List<CSInfoDto> selectCpCharge(FindCPDto findCPDto);

	// 充电站运营总收入，总电量
	List<CSoperInfoDto> selectCScount(FindCPDto findCPDto);

	List<CSInfoDto> selectCSDetail(FindCPDto findCPDto);

	// //////////////////////////////////////////***********************/////////////////
	// //////////////////////////////////////////***********************/////////////////
	// //////////////////////////////////////////***********************/////////////////
	// //////////////////////////////////////////***********************/////////////////

	List<CPInfoDto> findChargePileByChargeStation(String CSID);

	// 根据省市区ID查询拼接地址
	String selectPCAById(CSInfoDto chargeStationDto);

	// 按id查询站
	CSInfo findById(String CSID);

	// 查询充电站
	List<CSInfo> selectChargeStation();

	// 新增充电站
	int insertChargeStation(CSInfo chargeStation);

	// 查询充电站
	List<CSInfoDto> findChargeStationBy(CSInfo chargeStation);

	// 根据ID更改地址ID
	void updateAddressId(String ADDRESSID, String CSID);

	// 查询充电站下的充电桩
	List<CPInfo> findChargePileByChargeStation(FindCSDto findCSDto);

	// 查询充电站下的充电桩数量
	int getChargePileCount(FindCSDto findCSDto);

	// 查询所有充电站
	List<CSInfoDto> selectAllchargeStationDto(CSInfoDto chargeStationDto);

	//
	

	List<CSInfoDto> selectcsexport(FindCSInfoDto findCSInfoDto);
	
	List<CSInfoDto> findCSDetail(FindCPDto findCPDto);
}

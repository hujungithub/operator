package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.FindManufDto;
import cn.com.start.webBack.dto.ManufDto;
import cn.com.start.webBack.entity.CPMfrInfo;

public interface ManufacturersMapper {

	// 查询充电桩厂商id
	List<CPMfrInfo> selectCPMfr();

	// 根据厂商ID查询型号
	List<String> selectModelByMfr(String mfrId);

	// 获取厂商数量
	int getManufCount(FindManufDto findManufDto);

	// 获取厂商信息
	List<ManufDto> selectManufByPage(FindManufDto findManufDto);

	// add厂商
	int insertManuf(ManufDto manufDto);

	// add型号
	int insertModel(ManufDto manuf);

	// 获取递增id
	String selectMaxid();

	ManufDto selectManuf(@Param("mfrid") String mfrid,
			@Param("model") String model);

	int updateManuf(ManufDto manufDto);

	int updateModel(ManufDto manufDto);

	int deleteManuf(String mfrids[]);

	int deleteModel(String mids[]);

	int addMfrModel(ManufDto manufDto);
	
	int deleteMfr(@Param("model") String model,@Param("id") String id);
	
	public List<CPMfrInfo> findMfrname();
}

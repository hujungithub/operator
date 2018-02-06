package cn.com.start.webBack.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.FindManufDto;
import cn.com.start.webBack.dto.ManufDto;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.util.Page;

public interface ManufacturersService {

	// 查出所有充电桩厂商
	List<CPMfrInfo> findCPMfr();

	// 根据厂商ID查询型号
	List<String> findModelByMfr(String mfrId);

	List<ManufDto> showManufByPage(FindManufDto findManufDto);

	int insertManuf(ManufDto manufDto);

	int insertModel(ManufDto manuf);

	String findMaxid();

	ManufDto findManuf(@Param("mfrid") String mfrid, @Param("model") String model);

	int updateManuf(ManufDto manufDto);

	int updateModel(ManufDto manufDto);

	int deletemanuf(String mfrids[]);

	int deletemodel(String mids[]);

	int addMfrModel(ManufDto manufDto);
	
	int deleteMfr(@Param("model") String model,@Param("id") String id);
	
	public List<CPMfrInfo> findMfrname();

}

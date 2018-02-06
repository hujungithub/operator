package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindManufDto;
import cn.com.start.webBack.dto.ManufDto;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.mapper.ManufacturersMapper;
import cn.com.start.webBack.service.ManufacturersService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class ManufacturersServiceImpl implements ManufacturersService {
//************************************************************************************//
//************************************************************************************//
	@Resource
	private ManufacturersMapper manufacturersMapper;
	
	/**
	 * 查询所有充电桩生产厂商
	 */
	@Override
	public List<CPMfrInfo> findCPMfr() {
		List<CPMfrInfo> mfrList = manufacturersMapper.selectCPMfr();
		return mfrList;
	}
	
	/** 
	 * 分页查询厂商
	 */
	@Override
	public List<ManufDto> showManufByPage(FindManufDto findManufDto) {
		// TODO Auto-generated method stub
		List<ManufDto> ManufList = manufacturersMapper
				.selectManufByPage(findManufDto);
		return ManufList;
	}
	
	//查询桩厂商
	@Override
	public ManufDto findManuf(@Param("mfrid") String mfrid,@Param("model") String model) {
		// TODO Auto-generated method stub
		ManufDto manuf = manufacturersMapper.selectManuf(mfrid, model);
		return manuf;
	}
	
	//增加厂商
	@Override
	public int insertManuf(ManufDto manufDto) {
		// TODO Auto-generated method stub
		
		int intsertcount = manufacturersMapper.insertManuf(manufDto);
		return intsertcount;
	}
	
	@Override
	public String findMaxid() {
		// TODO Auto-generated method stub
		String maxid = manufacturersMapper.selectMaxid();
		return maxid;
	}
	
	@Override
	public int updateManuf(ManufDto manufDto) {
		// TODO Auto-generated method stub
		int manufcout = manufacturersMapper.updateManuf(manufDto);
		return manufcout;
	}
	
	@Override
	public int updateModel(ManufDto manufDto) {
		// TODO Auto-generated method stub
		int modelcout = manufacturersMapper.updateModel(manufDto);
		return modelcout;
	}
	
	@Override
	public int insertModel(ManufDto manuf) {
		// TODO Auto-generated method stub
		int insertmodel = manufacturersMapper.insertModel(manuf);
		return insertmodel;
	}
	
	@Override
	public int deletemanuf(String mfrids[]) {
		// TODO Auto-generated method stub
		int manufcount = manufacturersMapper.deleteManuf(mfrids);
		return manufcount;
	}
	
	@Override
	public int deletemodel(String mids[]) {
		// TODO Auto-generated method stub
		int modelcount = manufacturersMapper.deleteModel(mids);
		return modelcount;
	}
//************************************************************************************//
//************************************************************************************//








	/**
	 * 根据厂商ID查找型号
	 */
	@Override
	public List<String> findModelByMfr(String mfrId) {
		List<String> modelList = manufacturersMapper.selectModelByMfr(mfrId);
		return modelList;
	}

	@Override
	public int addMfrModel(ManufDto manufDto) {
		int flag = manufacturersMapper.addMfrModel(manufDto);
		return flag;
	}

	/**
	 * @Title: deleteMfr
	 * @Description: TODO
	 * @return
	 * @see cn.com.start.webBack.service.ManufacturersService#deleteMfr()
	 */
	@Override
	public int deleteMfr(@Param("model") String model,@Param("id") String id) {
		int flag = manufacturersMapper.deleteMfr(model,id);
		return flag;
	}

	/**
	 * @Title: findMfrname
	 * @Description: TODO
	 * @return
	 * @see cn.com.start.webBack.service.ManufacturersService#findMfrname()
	 */
	@Override
	public List<CPMfrInfo> findMfrname() {
		List<CPMfrInfo> list = manufacturersMapper.findMfrname();
		return list;
	}

}

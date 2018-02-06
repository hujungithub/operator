package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.ProtocolInfo;
import cn.com.start.webBack.mapper.ChargePileMapper;
import cn.com.start.webBack.service.ChargePileService;

;

@Service
@Transactional
public class ChargePileServiceImpl implements ChargePileService {

	@Resource
	public ChargePileMapper chargePileMapper;
//****************************************************************************************//
//****************************************************************************************//
	/**
	 * 查询协议列表
	 * */
	@Override
	public List<ProtocolInfo> findProtocol() {
		List<ProtocolInfo> infoList = chargePileMapper.selectProtocol();
		return infoList;
	}

	/**
	 * 按组合条件 分页查询充电桩
	 */
	@Override
	public List<CPInfoDto> showCPByPage(FindCPDto findCPDto) {
//		int totalCount = chargePileMapper.getCPCount(findCPDto);
//		Page page = new Page(totalCount, findCPDto.getPageSize(),
//				findCPDto.getPageNow());
//		findCPDto.setStartPos(page.getStartPos());
//		System.out.println(page.getStartPos());
		List<CPInfoDto> cpInfoList = chargePileMapper.selectCPByPage(findCPDto);
//		page.setList(cpInfoList);
		return cpInfoList;
	}
	/**
	 * 根据区域ID查找cpId
	 */
	@Override
	public long findCPIdBeforeAdd(int areaId) {
		String cpId = chargePileMapper.selectCPIdBeforeAdd(String
				.valueOf(areaId));
		System.out.println(cpId);
		if (cpId == null || cpId.isEmpty()) {
			return 0;
		} else {
			return Long.parseLong(cpId);
		}
	}
	/**
	 * 查询设备ID
	 */
	@Override
	public int findDeviceid(String deviceid) {
		// TODO Auto-generated method stub
		int flag = chargePileMapper.selectDeviceid(deviceid);
		return flag;
	}
	/**
	 * 根据站ID查询桩名
	 */
	@Override
	public String findCpname(String csid) {
		// TODO Auto-generated method stub
		String cpname = chargePileMapper.selectCpname(csid);
		return cpname;
	}
	
	/**
	 * 根据cpId查询桩基本信息 用于update
	 */
	@Override
	public List<CPInfo> findCPById(String cpId) {
		List<CPInfo> cpInfo = chargePileMapper.selectCPById(cpId);
		return cpInfo;
	}
	
	/**
	 * 按id删除充电桩
	 */
	@Override
	public int deleteCPById(String cpId[]) {
		int flag = chargePileMapper.deleteCPById(cpId);
		return flag;
	}
//****************************************************************************************//
//****************************************************************************************//

	/**
	 * 查询充电桩所有状态
	 */
	// @Override
	// public List<CPStateType> findStateType() {
	// List<CPStateType> stateList = chargePileMapper.selectState();
	// return stateList;
	// }
	

	/**
	 * 新增充电桩状态数据
	 */
	// @Override
	// public int addCPRealState(CPRealState state) {
	// int flag = chargePileMapper.insertCPRealState(state);
	// return flag;
	// }

	/**
	 * 新增充电桩
	 */
	@Override
	public int addChargePile(CPInfo cpInfo) {

		int flag = chargePileMapper.insertChargePile(cpInfo);
		return flag;
	}

	



	/**
	 * 更新充电桩
	 */
	@Override
	public int updateChargePile(CPInfo cpInfo) {
		int flag = chargePileMapper.updateChargePile(cpInfo);
		return flag;
	}


	@Override
	public String findLastRegTime() {
		// TODO Auto-generated method stub
		return null;
	}

	// 导出充电桩信息
	@Override
	public List<CPInfoDto> findCPDetailexport(FindCPDto findCPDto) {
		List<CPInfoDto> cpInfoDto = chargePileMapper
				.selectCPDetailexport(findCPDto);
		return cpInfoDto;
	}

	@Override
	public int addlist(CPInfo cpin) {
		int listcount = chargePileMapper.addlist(cpin);
		return listcount;
	}

	@Override
	public List<CPInfoDto> findCPDetail(FindCPDto findCPDto) {
		List<CPInfoDto> cpInfoDto = chargePileMapper.selectCPDetail(findCPDto);
		return cpInfoDto;
	}

	@Override
	public List<UserChargeDto> findUserCharge(FindCPDto findCPDto) {
		List<UserChargeDto> userchargeList = chargePileMapper.selectCpCharge(findCPDto);
		return userchargeList;
	}

	@Override
	public List<UserChargeDto> exportChargeDetailList(FindCPDto findCPDto) {
		// TODO Auto-generated method stub
		List<UserChargeDto> userchargelist = chargePileMapper.selectexportChargeDetail(findCPDto);
		return userchargelist;
	}

	/**
	 * @Title: deleteInfo
	 * @Description: TODO
	 * @see cn.com.start.webBack.service.ChargePileService#deleteInfo()
	 */
	@Override
	public void deleteInfo() {
		// TODO 删除正常信息,保留异常信息
		chargePileMapper.deleteInfo();
	}

	

}
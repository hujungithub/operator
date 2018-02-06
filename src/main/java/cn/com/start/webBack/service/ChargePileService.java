package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.ProtocolInfo;

public interface ChargePileService {

	// 分页查询所有充电桩
	List<CPInfoDto> showCPByPage(FindCPDto findCPDto);

	// 查询充电桩所有状态
	// List<CPStateType> findStateType();
	/////////////////////////////////////////////////////////////////////////////////////
	// 根据区域ID模糊查询最大的cpId
	long findCPIdBeforeAdd(int areaId);

	// 新增充电桩
	int addChargePile(CPInfo cpInfo);

	// 跟据id删除充电桩
	int deleteCPById(String cpId[]);

	// 根据费率ID查询当前时间费率

	// 新增充电桩状态数据
	// int addCPRealState(CPRealState state);

	// 根据桩ID查询地址dto

	// 根据ID返回充电桩
	List<CPInfo> findCPById(String cpId);

	// 修改充电桩
	int updateChargePile(CPInfo cpInfo);

	// 查询协议列表
	List<ProtocolInfo> findProtocol();

	// 查出最早建桩时间
	String findLastRegTime();

	// 导出充电桩信息
	List<CPInfoDto> findCPDetailexport(FindCPDto findCPDto);

	// 增加
	int addlist(CPInfo cpin);

	int findDeviceid(String deviceid);

	String findCpname(String csid);
	
	// 查询充电桩详情
	List<CPInfoDto> findCPDetail(FindCPDto findCPDto);
	
	// 充电桩充电记录
	List<UserChargeDto> findUserCharge(FindCPDto findCPDto);
	
	// 按条件导出一个桩所有充电信息
	List<UserChargeDto> exportChargeDetailList(FindCPDto findCPDto);

	// 删除所有正常进程的信息
	public void deleteInfo();
}

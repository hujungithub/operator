package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.UserChargeDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CPRealState;
import cn.com.start.webBack.entity.CPStateType;
import cn.com.start.webBack.entity.ProtocolInfo;

public interface ChargePileMapper {

	// 查询充电桩数量
	int getCPCount(FindCPDto findCPDto);

	// 分页查询充电桩
	List<CPInfoDto> selectCPByPage(FindCPDto findCPDto);

	// 查询充电桩所有状态
	List<CPStateType> selectState();

	// 根据区域ID模糊查询cpId
	String selectCPIdBeforeAdd(@Param("areaId") String areaId);

	// 根据CPMid查询地址
	Address selectAddressByCPMId(int cpmId);

	// 新增充电桩
	int insertChargePile(CPInfo cpinfo);

	// 删除充电站
	int deleteCPById(String cpId[]);

	// 新增充电桩状态详情
	int insertCPRealState(CPRealState state);

	// 根据cpid查出充电桩的信息
	List<CPInfo> selectCPById(String cpId);

	// 修改充电桩
	int updateChargePile(CPInfo cpInfo);

	// 查询协议列表
	List<ProtocolInfo> selectProtocol();

	// 导出充电桩信息
	List<CPInfoDto> selectCPDetailexport(FindCPDto findCPDto);

	// 增加
	int addlist(CPInfo cpin);

	int selectDeviceid(String deviceid);

	String selectCpname(String csid);
	
	// 查询充电桩详情
	List<CPInfoDto> selectCPDetail(FindCPDto findCPDto);
	
	// 充电桩充电记录
	List<UserChargeDto> selectCpCharge(FindCPDto findCPDto);
	
	List<UserChargeDto> selectexportChargeDetail(FindCPDto findCPDto);
	
	// 删除正常信息
	public void deleteInfo();
}

package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindOperatorDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.OperatorInfoDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.OperatorInfo;

public interface OperatorMapper {

	// 分页查找运营商
	List<OperatorInfoDto> selectOperatorByPage(String operatorloginid);

	// 获取运营商总数
	int getOperatorCount(FindOperatorDto findOperatorDto);
	
	// 查询boss及其下属运营商
	List<OperatorInfo> selectNewOperator(String operatorloginid);

	// ////////////////////////////////////////************************////////////////////////
	// ////////////////////////////////////////************************////////////////////////
	// ////////////////////////////////////////************************////////////////////////
	// ////////////////////////////////////////************************////////////////////////
	// ////////////////////////////////////////************************////////////////////////
	// 条件查询运营商
	List<OperatorInfoDto> findOperatorBy(FindOperatorDto findOperatorDto);

	// 根据id删除运营商
	int deleteById(String COID[]);

	// 增加运营商
	int insertOperator(OperatorInfo operator);

	// 根据id获取运营商信息
	OperatorInfo findOperatorById(int OPERATORID);

	// 查询运营商
	List<OperatorInfo> selectOperator();

	// 修改运营商信息
	int updateById(OperatorInfo operator);

	// 修改充电桩是否可用（INVALIDFLG）
	int updateCPHE_VALIDFLAG(String COID[]);

	// 修改充电站是否可用
	int updateCS_INVALIDFLG(String COID[]);

	// 修改CPM是否可用
	int updateCPM_INVALIDFLG(String COID[]);

	// 根据运营商找充电站
	List<CSInfo> selectCSByOper(int OPERATORID);

	// 根据CPM查找充电桩
	List<CPInfo> selectCPByCPM(int CPMID);

	// 根据充电站查询充电桩
	List<CPInfo> selectCPHEByCS(int CSID);

	// 根据cpid查coid
	String selectCoIdByCP(int cpId);

	// 根据cpid查cpmid
	String selectCpmIdByCP(int cpId);



	String selectMaxid();

	int addBill(List<BillModelDto> list);

	int selectcheck(String[] OPERATORIDS);

	int getCount(FindOperatorDto findOperatorDto);

	List<OperInfoDto> findMQCount(FindOperatorDto findOperatorDto);

	List<userReportsDto> selectOperatorDetail(FindOperatorDto findOperatorDto);

	OperatorInfo selectOperatorById(String operatorid);

	List<CSoperInfoDto> selectOperatorExport(FindOperatorDto findOperatorDto);
}

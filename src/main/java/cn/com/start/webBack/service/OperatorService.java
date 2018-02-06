package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindOperatorDto;
import cn.com.start.webBack.dto.OperatorInfoDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.util.Page;

public interface OperatorService {

	// 分页显示运营商
	List<OperatorInfoDto> showOperatorByPage(String operatorloginid);

	// 根据id查找运营商
	OperatorInfo findOperatorById(int COID);
	
	// 根据运营商查充电站
	List<CSInfo> findCSByOper(int COID);
	
	// 获取boss及其下属运营商
	List<OperatorInfo> findNewOperator(String operatorloginid);
	
	
	// ////////////////////**********************************************//////////////////
	// ////////////////////**********************************************//////////////////
	// ////////////////////**********************************************//////////////////
	// ////////////////////**********************************************//////////////////
	// ////////////////////**********************************************//////////////////

	List<OperatorInfoDto> findOperatorBy(FindOperatorDto findOperatorDto);

	// 根据id删除
	int deleteById(String COID[]);

	// 新增运营商
	int insertOperator(OperatorInfo operator);

	

	// 修改运营商信息
	int updateById(OperatorInfo operator);

	// 根据COID修改充电桩是否可用（INVALIDFLG）
	int updateCPHE_INVALIDFLG(String COID[]);

	// 根据COID修改充电站是否可用
	int updateCS_INVALIDFLG(String COID[]);

	// 修改CPM是否可用
	int updateCPM_INVALIDFLG(String COID[]);

	

	// 根据充电站查询充电桩
	List<CPInfo> findCPHEByCS(int CSID);

	// 根据CPM查找充电桩
	List<CPInfo> findCPByCPM(int CPMID);

	// 根据充电桩id查找coid
	String findCoIdByCP(int cpId);

	// 根据充电桩id查找cpmid
	String findCpmIdByCP(int cpId);
	
	// 查询所有运营商
	List<OperatorInfo> findOperator();



	String findMaxid();

	int addBill(List<BillModelDto> list);

	int findcheck(String[] OPERATORIDS);

	Page findOperator(FindOperatorDto findOperatorDto);

	OperatorInfo findOperatorById(String operatorid);

	List<CSoperInfoDto> findOperatorExport(FindOperatorDto findOperatorDto);

}

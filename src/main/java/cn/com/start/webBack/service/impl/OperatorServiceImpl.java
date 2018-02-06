package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.FindOperatorDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.OperatorInfoDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.mapper.OperatorMapper;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class OperatorServiceImpl implements OperatorService {
	@Resource
	public OperatorMapper operatorMapper;
	//***************************************USED********************************************//
	/**
	 * 查询boss及其下属运营商
	 */
	@Override
	public List<OperatorInfo> findNewOperator(String operatorloginid) {
		// TODO Auto-generated method stub
		List<OperatorInfo> OperatorList = operatorMapper
				.selectNewOperator(operatorloginid);
		return OperatorList;
	}
	// 运营商找充电站
		@Override
		public List<CSInfo> findCSByOper(int coId) {
			List<CSInfo> findCSList = operatorMapper.selectCSByOper(coId);
			return findCSList;
		}
	//*************************************USER**********************************************//
	// 按条件分页查询运营商
	@Override
	public List<OperatorInfoDto> showOperatorByPage(String operatorloginid) {
		List<OperatorInfoDto> onePageOperatorList = new ArrayList<OperatorInfoDto>();
		// 设置起始位置
		onePageOperatorList = operatorMapper
				.selectOperatorByPage(operatorloginid);
		return onePageOperatorList;
	}
	
	// 通过ID查找运营商
	@Override
	public OperatorInfo findOperatorById(int OPERATORID) {
		OperatorInfo operator = operatorMapper.findOperatorById(OPERATORID);
		return operator;
	}
	
	// buyao-11111--------//
	/**
	 * 返回所有运营商
	 */
	@Override
	public List<OperatorInfo> findOperator() {
		List<OperatorInfo> findOperatorList = operatorMapper.selectOperator();
		return findOperatorList;
	}



	// 按id删除
	@Override
	public int deleteById(String COID[]) {
		int count = operatorMapper.deleteById(COID);
		return count;
	}

	// 新增运营商
	@Override
	public int insertOperator(OperatorInfo operator) {
		int count = operatorMapper.insertOperator(operator);
		return count;
	}

	// 导出用查找运营商信息
	@Override
	public List<OperatorInfoDto> findOperatorBy(FindOperatorDto findOperatorDto) {
		List<OperatorInfoDto> findOperatorBylist = operatorMapper
				.findOperatorBy(findOperatorDto);
		return findOperatorBylist;
	}

	// 修改运营商信息
	@Override
	public int updateById(OperatorInfo operator) {
		// TODO Auto-generated method stub
		int updatecount = operatorMapper.updateById(operator);
		return updatecount;
	}

	// 根据CPID查找运营商ID
	@Override
	public String findCoIdByCP(int cpId) {
		String coId = operatorMapper.selectCoIdByCP(cpId);
		return coId;
	}

	// 根据CPID查找CPMID
	@Override
	public String findCpmIdByCP(int cpId) {
		String cpmId = operatorMapper.selectCpmIdByCP(cpId);
		return cpmId;
	}

	// 修改充电桩是否可用
	@Override
	public int updateCPHE_INVALIDFLG(String COID[]) {
		// TODO Auto-generated method stub
		int number = operatorMapper.updateCPHE_VALIDFLAG(COID);
		return number;
	}

	// 修改充电站是否可用
	@Override
	public int updateCS_INVALIDFLG(String COID[]) {
		// TODO Auto-generated method stub
		int con = operatorMapper.updateCS_INVALIDFLG(COID);
		return con;
	}

	// 修改CPM是否可用
	@Override
	public int updateCPM_INVALIDFLG(String COID[]) {
		// TODO Auto-generated method stub
		int cou = operatorMapper.updateCPM_INVALIDFLG(COID);
		return cou;
	}

	// 根据充电站查找充电桩
	@Override
	public List<CPInfo> findCPHEByCS(int CSID) {
		// TODO Auto-generated method stub
		List<CPInfo> findCPHEList = operatorMapper.selectCPHEByCS(CSID);
		return findCPHEList;
	}

	

	// 根据CPM查找充电桩
	@Override
	public List<CPInfo> findCPByCPM(int CPMID) {
		// TODO Auto-generated method stub
		List<CPInfo> findCPList = operatorMapper.selectCPByCPM(CPMID);
		return findCPList;
	}

	@Override
	public String findMaxid() {
		// TODO Auto-generated method stub
		String maxid = operatorMapper.selectMaxid();
		return maxid;
	}

	@Override
	public int addBill(List<BillModelDto> list) {
		// TODO Auto-generated method stub
		int billcount = operatorMapper.addBill(list);
		return billcount;
	}

	@Override
	public int findcheck(String[] OPERATORIDS) {
		// TODO Auto-generated method stub
		int check = operatorMapper.selectcheck(OPERATORIDS);
		return check;
	}

	@Override
	public Page findOperator(FindOperatorDto findOperatorDto) {
		Page pagedetail = null;
		// 条件查询数量
		int pageCount = operatorMapper.getCount(findOperatorDto);
		pagedetail = new Page(pageCount, findOperatorDto.getPageSize(),
				findOperatorDto.getPageNow());
		findOperatorDto.setStartPos(pagedetail.getStartPos());
		List<userReportsDto> onePageList = operatorMapper
				.selectOperatorDetail(findOperatorDto);
		List<OperInfoDto> mqcountList = operatorMapper
				.findMQCount(findOperatorDto);

		pagedetail.setList(onePageList);
		pagedetail.setAddList(mqcountList);
		return pagedetail;
	}

	@Override
	public OperatorInfo findOperatorById(String operatorid) {
		// TODO Auto-generated method stub
		OperatorInfo operator = operatorMapper.selectOperatorById(operatorid);
		return operator;
	}

	@Override
	public List<CSoperInfoDto> findOperatorExport(
			FindOperatorDto findOperatorDto) {
		// TODO Auto-generated method stub
		List<CSoperInfoDto> exportlist = operatorMapper
				.selectOperatorExport(findOperatorDto);
		return exportlist;
	}

}

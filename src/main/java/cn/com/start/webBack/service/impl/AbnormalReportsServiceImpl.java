package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.com.start.webBack.dto.CPYCRunRecordDto;
import cn.com.start.webBack.dto.StartChargeGunRecordDto;
import cn.com.start.webBack.entity.ChargeRecord_DPF;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.entity.UserDeductMoneyRecord;
import cn.com.start.webBack.mapper.AbnormalReportsMapper;
import cn.com.start.webBack.service.AbnormalReportsService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class AbnormalReportsServiceImpl implements AbnormalReportsService{

	@Resource
	public AbnormalReportsMapper abnormalReportsMapper;
	
	@RequestMapping("/findCPDetailFirst")
	public Page findCPYCRunRecord() {
		List<CPYCRunRecordDto> cpycRunRecordDtoList = abnormalReportsMapper
				.selectCPYCRunRecord();
		//总记录数
		int count = abnormalReportsMapper.selectReportsCount();
		
		//public Page(int totalCount, int PageSize, int PageNow) 
		Page page = new Page(count, 10,1);
		page.setList(cpycRunRecordDtoList);
		return page;
	}
	
	
	@Override
	@RequestMapping("/findCPYCRunRecordDetailFirst")
	public Page findCPYCRunRecordDetailFirst(String cpId) {
		List<StartChargeGunRecordDto> list = abnormalReportsMapper.selectStartChargeGunRecord(cpId);
		System.out.println("serviceimpl中的findCPYCRunRecordDetailFirst--------------list-------------"+list);
		Page page = new Page(10, 10,1);
		page.setList(list);
		page.setPageSize(10);
		return page;
	}


	@Override
	public CPYCRunRecordDto findCPYCRunRecordBySN(String SN) {
		return abnormalReportsMapper.selectCPYCRunRecordByID(SN);
	}


	@Override
	public StartChargeGunRecordDto findStartCGRecordById(String ID) {
		return abnormalReportsMapper.selectStartChargeGunRecordBySN(ID);
	}


	@Override
	public CpUser selectCpUserInfoByCpUserId(String cpUserId) {
		return abnormalReportsMapper.selectCpUserInfoByCpUserId(cpUserId);
	}


	@Override
	public void updateAccountSumByCpUserId(CpUser cpUser) {
		abnormalReportsMapper.updateAccountSumByCpUserId(cpUser);
	}


	@Override
	public void insertUserChargeRecord(ChargeRecord_DPF chargeRecord_DPF) {
		abnormalReportsMapper.insertUserChargeRecord(chargeRecord_DPF);
	}


	@Override
	public void insertUserDeductMoneyRecord(
			UserDeductMoneyRecord userDeductMoneyRecord) {
		abnormalReportsMapper.insertUserDeductMoneyRecord(userDeductMoneyRecord);
	}
}

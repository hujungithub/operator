package cn.com.start.webBack.service;

import cn.com.start.webBack.dto.CPYCRunRecordDto;
import cn.com.start.webBack.dto.StartChargeGunRecordDto;
import cn.com.start.webBack.entity.ChargeRecord_DPF;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.entity.UserDeductMoneyRecord;
import cn.com.start.webBack.util.Page;

public interface AbnormalReportsService {

	
	Page findCPYCRunRecord();
	
	CPYCRunRecordDto findCPYCRunRecordBySN(String SN);
	
	Page findCPYCRunRecordDetailFirst(String CPId);
	
	StartChargeGunRecordDto findStartCGRecordById(String ID);
	
	CpUser selectCpUserInfoByCpUserId(String cpUserId);
	
	void updateAccountSumByCpUserId(CpUser cpUser);
	
	void insertUserChargeRecord(ChargeRecord_DPF chargeRecord_DPF);
	
	void insertUserDeductMoneyRecord(UserDeductMoneyRecord userDeductMoneyRecord);
}

package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.CPYCRunRecordDto;
import cn.com.start.webBack.dto.StartChargeGunRecordDto;
import cn.com.start.webBack.entity.ChargeRecord_DPF;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.entity.UserDeductMoneyRecord;

public interface AbnormalReportsMapper {
	
	List<CPYCRunRecordDto> selectCPYCRunRecord();
	
	int selectReportsCount();
	
	List<StartChargeGunRecordDto> selectStartChargeGunRecord(String cpId);
	
	CPYCRunRecordDto selectCPYCRunRecordByID(String ID);
	
	StartChargeGunRecordDto selectStartChargeGunRecordBySN(String SN);
	
	CpUser selectCpUserInfoByCpUserId(String cpUserId);
	
	void updateAccountSumByCpUserId(CpUser cpUser);
	
	void insertUserChargeRecord(ChargeRecord_DPF chargeRecord_DPF);
	
	void insertUserDeductMoneyRecord(UserDeductMoneyRecord userDeductMoneyRecord);
}	

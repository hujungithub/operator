package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.CardUserDto;
import cn.com.start.webBack.dto.FindCardUserDto;
import cn.com.start.webBack.dto.FindRechargeRecordDto;
import cn.com.start.webBack.dto.FindUserCardChargeDto;
import cn.com.start.webBack.dto.FindUserCardIssueRecordDto;
import cn.com.start.webBack.dto.ModifyMoneyRecord;
import cn.com.start.webBack.dto.ReportLostDto;
import cn.com.start.webBack.dto.UserCardChargeDto;
import cn.com.start.webBack.dto.UserCardIssueRecordDto;
import cn.com.start.webBack.dto.UserCardRechargeDto;
import cn.com.start.webBack.util.Page;

public interface UserCardManageService {
	//分页查询用户卡
	List<CardUserDto> showByPage(FindCardUserDto findCardUserDto);

	CardUserDto findupdateUsercard(FindCardUserDto findCardUserDto);

	int updateusercard(CardUserDto cardUserDto);

	int deleteByCardNum(String[] cardNums);
	
	int updateBalance(ModifyMoneyRecord modifyMoneyRecord);
	
	//分页查询用户卡开卡记录
	List<UserCardIssueRecordDto> showUserCardIssueRecord(FindUserCardIssueRecordDto findUserCardIssueRecordDto);
	
	CardUserDto findUserCard(String CARDNUM);
	
	Page findCardUserChargeRecord(FindUserCardChargeDto findUserCardChargeDto);

	List<CardUserDto> findUserCardInfo(FindCardUserDto findCardUserDto);

	String findChargeMoneyCount(String CARDNUM);

	String findChargeQuantityCount(String CARDNUM);

	List<UserCardChargeDto> findUserCardRecord(FindUserCardChargeDto findUserCardChargeDto);
	
	List<UserCardRechargeDto> showRechargeRecord(FindRechargeRecordDto findRechargeRecordDto);

	List<UserCardIssueRecordDto> userCardIssueRecordExport(
			FindUserCardIssueRecordDto findUserCardIssueRecordDto);

	List<UserCardRechargeDto> userCardRechargeExport(
			FindRechargeRecordDto findRechargeRecordDto);

	int reportLost(ReportLostDto reportLostDto);

	int removeLost(ReportLostDto reportLostDto);
}

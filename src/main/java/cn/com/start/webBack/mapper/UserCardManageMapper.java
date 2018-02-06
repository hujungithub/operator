package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.CardUserDto;
import cn.com.start.webBack.dto.FindCardUserDto;
import cn.com.start.webBack.dto.FindRechargeRecordDto;
import cn.com.start.webBack.dto.FindUserCardChargeDto;
import cn.com.start.webBack.dto.FindUserCardIssueRecordDto;
import cn.com.start.webBack.dto.ModifyMoneyRecord;
import cn.com.start.webBack.dto.ReportLostDto;
import cn.com.start.webBack.dto.UserCardChargeDto;
import cn.com.start.webBack.dto.UserCardCountData;
import cn.com.start.webBack.dto.UserCardIssueRecordDto;
import cn.com.start.webBack.dto.UserCardRechargeDto;

public interface UserCardManageMapper {
	//查找满足条件的用户卡总数
	int getCount(FindCardUserDto findUserCardDto);

	List<CardUserDto> selectByPage(FindCardUserDto findCardUserDto);

	CardUserDto findupdateUsercard(FindCardUserDto findCardUserDto);

	int updateusercard(CardUserDto cardUserDto);

	int deleteByCardNum(String[] cardNums);
	
	int insertModifyMoneyRecord(ModifyMoneyRecord modifyMoneyRecord);
	
	int updateBalance(ModifyMoneyRecord modifyMoneyRecord);
	
	//查找满足条件的开卡记录总数
	int getUCIRCount(FindUserCardIssueRecordDto findUserCardIssueRecordDto);

	List<UserCardIssueRecordDto> selectUCIRByPage(FindUserCardIssueRecordDto findUserCardIssueRecordDto);
	
	CardUserDto findUserCard(String CARDNUM);
	
	int getChargeRecordCount(FindUserCardChargeDto findUserCardChargeDto);
	
	List<UserCardChargeDto> findCardUserChargeRecord(FindUserCardChargeDto findUserCardChargeDto);

	List<CardUserDto> findUserCardInfo(FindCardUserDto findCardUserDto);

	String findChargeMoneyCount(String CARDNUM);

	String findChargeQuantityCount(String CARDNUM);

	List<UserCardChargeDto> findUserCardRecord(FindUserCardChargeDto findUserCardChargeDto);

	List<UserCardCountData> findCountData(FindUserCardChargeDto findUserCardChargeDto);

	int getRechargeRecordCount(FindRechargeRecordDto findRechargeRecordDto);

	List<UserCardRechargeDto> findRechargeRecord(FindRechargeRecordDto findRechargeRecordDto);

	List<UserCardIssueRecordDto> userCardIssueRecordExport(
			FindUserCardIssueRecordDto findUserCardIssueRecordDto);

	List<UserCardRechargeDto> userCardRechargeExport(
			FindRechargeRecordDto findRechargeRecordDto);

	void insertReportLost(ReportLostDto reportLostDto);

	void insertRemoveLost(ReportLostDto reportLostDto);

	int checkInfo(ReportLostDto reportLostDto);

	void reportLost(ReportLostDto reportLostDto);

	void removeLost(ReportLostDto reportLostDto);
}

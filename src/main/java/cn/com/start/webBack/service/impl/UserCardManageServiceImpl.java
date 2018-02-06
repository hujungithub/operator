package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import cn.com.start.webBack.mapper.UserCardManageMapper;
import cn.com.start.webBack.service.UserCardManageService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class UserCardManageServiceImpl implements UserCardManageService {

	@Resource
	public UserCardManageMapper userCardManageMapper;

	@Override
	public List<CardUserDto> showByPage(FindCardUserDto findCardUserDto) {
		// TODO Auto-generated method stub
//		int pageCount = userCardManageMapper.getCount(findCardUserDto);
//		Page page = new Page(pageCount, findCardUserDto.getPageSize(),
//				findCardUserDto.getPageNow());
//		findCardUserDto.setStartPos(page.getStartPos());
		// 查询记录
		List<CardUserDto> onePageList = userCardManageMapper
				.selectByPage(findCardUserDto);
//		page.setList(onePageList);
		return onePageList;
	}

	@Override
	public CardUserDto findupdateUsercard(FindCardUserDto findCardUserDto) {
		// TODO Auto-generated method stub
		CardUserDto cardUserDto = userCardManageMapper
				.findupdateUsercard(findCardUserDto);
		return cardUserDto;
	}

	@Override
	public int updateusercard(CardUserDto cardUserDto) {
		// TODO Auto-generated method stub
		int count = userCardManageMapper.updateusercard(cardUserDto);
		return count;
	}

	@Override
	public int deleteByCardNum(String[] cardNums) {
		// TODO Auto-generated method stub
		int count = userCardManageMapper.deleteByCardNum(cardNums);
		return count;
	}

	@Override
	public int updateBalance(ModifyMoneyRecord modifyMoneyRecord) {
		userCardManageMapper.insertModifyMoneyRecord(modifyMoneyRecord);
		int flag = userCardManageMapper.updateBalance(modifyMoneyRecord);
		return flag;
	}

	@Override
	public List<UserCardIssueRecordDto> showUserCardIssueRecord(
			FindUserCardIssueRecordDto findUserCardIssueRecordDto) {
		int pageCount = userCardManageMapper
				.getUCIRCount(findUserCardIssueRecordDto);
		Page page = new Page(pageCount,
				findUserCardIssueRecordDto.getPageSize(),
				findUserCardIssueRecordDto.getPageNow());
		findUserCardIssueRecordDto.setStartPos(page.getStartPos());
		// 查询记录
		List<UserCardIssueRecordDto> onePageList = userCardManageMapper
				.selectUCIRByPage(findUserCardIssueRecordDto);
//		page.setList(onePageList);
		return onePageList;
	}

	@Override
	public CardUserDto findUserCard(String CARDNUM) {
		CardUserDto cardUserDto = userCardManageMapper.findUserCard(CARDNUM);
		return cardUserDto;
	}

	@Override
	public Page findCardUserChargeRecord(
			FindUserCardChargeDto findUserCardChargeDto) {
		int pageCount = userCardManageMapper
				.getChargeRecordCount(findUserCardChargeDto);
		Page page = new Page(pageCount, findUserCardChargeDto.getPageSize(),
				findUserCardChargeDto.getPageNow());
		findUserCardChargeDto.setStartPos(page.getStartPos());
		// 查询记录
		List<UserCardChargeDto> onePageList = userCardManageMapper
				.findCardUserChargeRecord(findUserCardChargeDto);
		List<UserCardCountData> countList = userCardManageMapper
				.findCountData(findUserCardChargeDto);
		page.setList(onePageList);
		page.setAddList(countList);
		return page;
	}

	@Override
	public List<CardUserDto> findUserCardInfo(FindCardUserDto findCardUserDto) {
		List<CardUserDto> cardUserDtos = userCardManageMapper
				.findUserCardInfo(findCardUserDto);
		return cardUserDtos;
	}

	@Override
	public String findChargeMoneyCount(String CARDNUM) {
		String cmc = userCardManageMapper.findChargeMoneyCount(CARDNUM);
		return cmc;
	}

	@Override
	public String findChargeQuantityCount(String CARDNUM) {
		String cqc = userCardManageMapper.findChargeQuantityCount(CARDNUM);
		return cqc;
	}

	@Override
	public List<UserCardChargeDto> findUserCardRecord(
			FindUserCardChargeDto findUserCardChargeDto) {
		List<UserCardChargeDto> userCardChargeDtos = userCardManageMapper
				.findUserCardRecord(findUserCardChargeDto);
		return userCardChargeDtos;
	}

	@Override
	public List<UserCardRechargeDto> showRechargeRecord(FindRechargeRecordDto findRechargeRecordDto) {
		// 查询记录
		List<UserCardRechargeDto> onePageList = userCardManageMapper
				.findRechargeRecord(findRechargeRecordDto);
		return onePageList;
	}

	@Override
	public List<UserCardIssueRecordDto> userCardIssueRecordExport(
			FindUserCardIssueRecordDto findUserCardIssueRecordDto) {
		List<UserCardIssueRecordDto> userCardIssueRecordDtos = userCardManageMapper
				.userCardIssueRecordExport(findUserCardIssueRecordDto);
		return userCardIssueRecordDtos;
	}

	@Override
	public List<UserCardRechargeDto> userCardRechargeExport(
			FindRechargeRecordDto findRechargeRecordDto) {
		List<UserCardRechargeDto> userCardRechargeDtos = userCardManageMapper
				.userCardRechargeExport(findRechargeRecordDto);
		return userCardRechargeDtos;
	}

	@Override
	public int reportLost(ReportLostDto reportLostDto) {
		int result = userCardManageMapper.checkInfo(reportLostDto);
		if (result == 1) {
			userCardManageMapper.reportLost(reportLostDto);
			userCardManageMapper.insertReportLost(reportLostDto);
		}
		return result;
	}

	@Override
	public int removeLost(ReportLostDto reportLostDto) {
		int result = userCardManageMapper.checkInfo(reportLostDto);
		if (result == 1) {
			userCardManageMapper.removeLost(reportLostDto);
			userCardManageMapper.insertRemoveLost(reportLostDto);
		}
		return result;
	}
}

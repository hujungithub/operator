package cn.com.start.DPF.service;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.card.CardRelay;
import cn.com.start.DPF.entity.CardIssueRecord;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChangePINRecord;
import cn.com.start.DPF.entity.ESAMCardData;
import cn.com.start.DPF.entity.ESAMCardIssueRecord;
import cn.com.start.DPF.entity.ISAMCardData;
import cn.com.start.DPF.entity.ISAMCardIssueRecord;
import cn.com.start.DPF.entity.PretreatmentRecord;
import cn.com.start.DPF.entity.ReadBalanceRecord;
import cn.com.start.DPF.entity.ReadCardNumRecord;
import cn.com.start.DPF.entity.RechargeRecord;
import cn.com.start.DPF.entity.ReloadPINRecord;
import cn.com.start.DPF.entity.UnlockGreyRecord;
import cn.com.start.DPF.mapper.SaveCardDataMapper;

@Service
@Transactional
public class SaveCardDataServiceImpl implements SaveCardDataService {

	@Resource
	private SaveCardDataMapper saveCardMapper;

	// 开卡成功记录入库
	@Override
	public void addCardUserInfo(CardUserInfo cardUserInfo) {
		saveCardMapper.insertCardUserInfo(cardUserInfo);
	}
	//记录发用户卡操作状态
	@Override
	public void insertIssueUserCard(String ip) {
		CardIssueRecord cardIssueRecord = CardRelay.issueUserCardRecordMap.get(ip);
		saveCardMapper.insertIssueUserCard(cardIssueRecord);
		BigInteger id = saveCardMapper.getUserCardIssueRecordId();
		cardIssueRecord.setID(id);
		CardRelay.issueUserCardRecordMap.put(ip, cardIssueRecord);
	}
	//更新发用户卡操作状态
	@Override
	public void updateIssueUserCard(CardIssueRecord cardIssueRecord) {
		saveCardMapper.updateIssueUserCard(cardIssueRecord);
	}
	
	//发ESAM卡操作入库
	@Override
	public void insertIssueESAMCard(String ip){
		ESAMCardIssueRecord esamCardIssueRecord = CardRelay.issueESAMCardRecordMap.get(ip);
		saveCardMapper.insertIssueESAMCard(esamCardIssueRecord);
		BigInteger id = saveCardMapper.getESAMCardIssueRecordId();
		esamCardIssueRecord.setID(id);
		CardRelay.issueESAMCardRecordMap.put(ip, esamCardIssueRecord);
	}
	//更新发ESAM卡操作状态
	@Override
	public void updateIssueESAMCard(ESAMCardIssueRecord esamCardIssueRecord) {
		saveCardMapper.updateIssueESAMCard(esamCardIssueRecord);
	}
	//发ESAM卡成功的数据入库
	@Override
	public void insertESAMCardData(ESAMCardData esamCardData){
		saveCardMapper.insertESAMCardData(esamCardData);
	}

	//发ISAM卡操作入库
	@Override
	public void insertIssueISAMCard(String ip){
		ISAMCardIssueRecord isamCardIssueRecord = CardRelay.issueISAMCardRecordMap.get(ip);
		saveCardMapper.insertIssueISAMCard(isamCardIssueRecord);
		BigInteger id = saveCardMapper.getISAMCardIssueRecordId();
		isamCardIssueRecord.setID(id);
		CardRelay.issueISAMCardRecordMap.put(ip, isamCardIssueRecord);
	}
	//更新发ESAM卡操作状态
	@Override
	public void updateIssueISAMCard(ISAMCardIssueRecord isamCardIssueRecord) {
		saveCardMapper.updateIssueISAMCard(isamCardIssueRecord);
	}
	//发ESAM卡成功的数据入库
	@Override
	public void insertISAMCardData(ISAMCardData isamCardData){
		saveCardMapper.insertISAMCardData(isamCardData);
	}

	//读取卡号操作入库
	@Override
	public void insertReadCardNumRecord(String ip){
		ReadCardNumRecord readCardNumRecord = CardRelay.readCardNumRecordMap.get(ip);
		saveCardMapper.insertReadCardNumRecord(readCardNumRecord);
		BigInteger id = saveCardMapper.getReadCardNumRecordId();
		readCardNumRecord.setID(id);
		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
	}
	//更新读取卡号操作状态
	@Override
	public void updateReadCardNumRecord(ReadCardNumRecord readCardNumRecord){
		saveCardMapper.updateReadCardNumRecord(readCardNumRecord);
	}
	
	//读取余额操作入库
	@Override
	public void insertReadBalanceRecord(String ip){
		ReadBalanceRecord readBalanceRecord = CardRelay.readBalanceRecordMap.get(ip);
		saveCardMapper.insertReadBalanceRecord(readBalanceRecord);
		BigInteger id = saveCardMapper.getReadBalanceRecordId();
		readBalanceRecord.setID(id);
		CardRelay.readBalanceRecordMap.put(ip, readBalanceRecord);
	}
	//更新读取余额操作状态
	@Override
	public void updateReadBalanceRecord(ReadBalanceRecord readBalanceRecord){
		saveCardMapper.updateReadBalanceRecord(readBalanceRecord);
	}
	
	//充值操作入库
	@Override
	public void insertRechargeCard(String ip){
		RechargeRecord rechargeRecord = CardRelay.rechargeRecordMap.get(ip);
		saveCardMapper.insertRechargeCard(rechargeRecord);
		BigInteger id = saveCardMapper.getRechargeRecordId();
		rechargeRecord.setID(id);
		CardRelay.rechargeRecordMap.put(ip, rechargeRecord);
	}
	//更新充值操作状态
	@Override
	public void updateRechargeCard(RechargeRecord rechargeRecord){
		float balance = saveCardMapper.getBalance(rechargeRecord.getCARDNUM());
		rechargeRecord.setBALANCES(balance);
		saveCardMapper.updateRechargeRecord(rechargeRecord);
	}
	//更新用户卡表的余额数据
	@Override
	public void updateUserCardBalance(RechargeRecord rechargeRecord){
		saveCardMapper.updateUserCardBalance(rechargeRecord);
	}
	
	//重置PIN操作入库
	@Override
	public void insertReloadPINRecord(String ip){
		ReloadPINRecord reloadPINRecord = CardRelay.reloadPINRecordMap.get(ip);
		saveCardMapper.insertReloadPinRecord(reloadPINRecord);
		BigInteger id = saveCardMapper.getReloadPINRecordId();
		reloadPINRecord.setID(id);
		CardRelay.reloadPINRecordMap.put(ip, reloadPINRecord);
	}
	//更新充值PIN操作状态
	@Override
	public void updateReloadPINRecord(ReloadPINRecord reloadPINRecord){
		saveCardMapper.updateReloadPINRecord(reloadPINRecord);
	}
	//更新用户卡表的PIN
	@Override
	public void updateUserCardPIN(String cardNum, String newPIN) {
		saveCardMapper.updateUserCardPIN(cardNum, newPIN);
	}
	//修改PIN操作入库
	@Override
	public void insertChangePINRecord(String ip){
		ChangePINRecord changePINRecord = CardRelay.changePINRecordMap.get(ip);
		saveCardMapper.insertChangePINRecord(changePINRecord);
		BigInteger id = saveCardMapper.getChangePINRecordId();
		changePINRecord.setID(id);
		CardRelay.changePINRecordMap.put(ip, changePINRecord);
	}
	//更新修改PIN操作
	@Override
	public void updateChangePINRecord(ChangePINRecord changePINRecord){
		saveCardMapper.updateChangePINRecord(changePINRecord);
	}

	//预处理操作入库
	@Override
	public void inserPretreatmentRecord(String ip){
		PretreatmentRecord pretreatmentRecord = CardRelay.pretreatmentRecordMap.get(ip);
		saveCardMapper.inserPretreatmentRecord(pretreatmentRecord);
		BigInteger id = saveCardMapper.getPretreatmentRecordId();
		pretreatmentRecord.setID(id);
		CardRelay.pretreatmentRecordMap.put(ip, pretreatmentRecord);
	}
	//更新预处理操作状态
	@Override
	public void updatePretreatmentRecord(PretreatmentRecord pretreatmentRecord){
		saveCardMapper.updatePretreatmentRecord(pretreatmentRecord);
	}
	
	//联机解扣操作入库
	@Override
	public void inserUnlockGreyRecord(String ip){
		UnlockGreyRecord unlockGreyRecord = CardRelay.unlockGreyRecordMap.get(ip);
		saveCardMapper.insertUnlockGreyRecord(unlockGreyRecord);
		BigInteger id = saveCardMapper.getUnlockGreyRecordId();
		unlockGreyRecord.setID(id);
		CardRelay.unlockGreyRecordMap.put(ip, unlockGreyRecord);
	}
	//联机解扣处理操作状态
	@Override
	public void updateUnlockGreyRecord(UnlockGreyRecord unlockGreyRecord){
		saveCardMapper.updateUnlockGreyRecord(unlockGreyRecord);
	}
}

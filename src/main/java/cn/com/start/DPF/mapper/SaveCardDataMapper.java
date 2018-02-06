package cn.com.start.DPF.mapper;

import java.math.BigInteger;

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

public interface SaveCardDataMapper {

	// 开用户卡成功数据入库
	int insertCardUserInfo(CardUserInfo cardUserInfo);
	//记录发用户卡操作状态
	void insertIssueUserCard(CardIssueRecord cardIssueRecord);
	//获取刚刚插入的发用户卡操作记录id
	BigInteger getUserCardIssueRecordId();
	// 更新发用户卡操作状态
	void updateIssueUserCard(CardIssueRecord cardIssueRecord);

	//发ESAM卡操作入库
	void insertIssueESAMCard(ESAMCardIssueRecord esamCardIssueRecord);
	//获取刚刚插入的发ESAM卡操作记录id
	BigInteger getESAMCardIssueRecordId();
	//更新发ESAM卡操作状态
	void updateIssueESAMCard(ESAMCardIssueRecord esamCardIssueRecord);
	//开ESAM卡成功数据入库
	void insertESAMCardData(ESAMCardData esamCardData);

	//发ISAM卡操作入库
	void insertIssueISAMCard(ISAMCardIssueRecord isamCardIssueRecord);
	//获取刚刚插入的发ISAM卡操作记录id
	BigInteger getISAMCardIssueRecordId();
	//更新发ISAM卡操作状态
	void updateIssueISAMCard(ISAMCardIssueRecord isamCardIssueRecord);
	//开ISAM卡成功数据入库
	void insertISAMCardData(ISAMCardData isamCardData);
	
	//读取卡号操作入库
	void insertReadCardNumRecord(ReadCardNumRecord readCardNumRecord);
	//获取刚刚插入的读卡号操作记录id
	BigInteger getReadCardNumRecordId();
	//更新读取卡号操作状态
	void updateReadCardNumRecord(ReadCardNumRecord readCardNumRecord);
	
	//读取卡号操作入库
	void insertReadBalanceRecord(ReadBalanceRecord readBalanceRecord);
	//获取刚刚插入的读卡号操作记录id
	BigInteger getReadBalanceRecordId();
	//更新读取卡号操作状态
	void updateReadBalanceRecord(ReadBalanceRecord readBalanceRecord);
	
	//充值操作入库
	void insertRechargeCard(RechargeRecord rechargeRecord);
	//获取刚刚插入的充值操作记录id
	BigInteger getRechargeRecordId();
	//更新充值操作状态
	void updateRechargeRecord(RechargeRecord rechargeRecord);
	//更新用户卡表的余额数据
	void updateUserCardBalance(RechargeRecord rechargeRecord);
	float getBalance(String CARDNUM);
	
	//重置PIN操作入库
	void insertReloadPinRecord(ReloadPINRecord reloadPINRecord);
	//获取刚刚插入的充值pin操作记录id
	BigInteger getReloadPINRecordId();
	//更新充值PIN操作状态
	void updateReloadPINRecord(ReloadPINRecord reloadPINRecord);
	//更新用户卡表的PIN
	void updateUserCardPIN(String CARDNUM, String NEWPIN);
	//修改PIN操作入库
	void insertChangePINRecord(ChangePINRecord changePINRecord);
	//获取刚刚插入的修改pin操作记录id
	BigInteger getChangePINRecordId();
	//更新修改PIN操作
	void updateChangePINRecord(ChangePINRecord changePINRecord);
	
	//预处理操作入库
	void inserPretreatmentRecord(PretreatmentRecord pretreatmentRecord);
	//获取刚刚插入的预处理操作id
	BigInteger getPretreatmentRecordId();
	//更新预处理操作状态
	void updatePretreatmentRecord(PretreatmentRecord pretreatmentRecord);
	
	//联机解扣操作入库
	void insertUnlockGreyRecord(UnlockGreyRecord unlockGreyRecord);
	//获取刚刚插入的联机解扣操作id
	BigInteger getUnlockGreyRecordId();
	//联机解扣处理操作状态
	void updateUnlockGreyRecord(UnlockGreyRecord unlockGreyRecord);
}

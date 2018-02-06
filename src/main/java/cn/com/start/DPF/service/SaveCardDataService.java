package cn.com.start.DPF.service;

//import org.apache.poi.hssf.record.RecalcIdRecord;

import cn.com.start.DPF.entity.UnlockGreyRecord;
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

public interface SaveCardDataService {
	// 卡操作service

	// 开用户卡成功，用户卡数据入库
	void addCardUserInfo(CardUserInfo cardUserInfo);
	// 开用户卡操作入库
	void insertIssueUserCard(String ip);
	// 更新开用户卡操作状态
	void updateIssueUserCard(CardIssueRecord cardIssueRecord);
	
	//发ESAM卡成功的数据入库
	void insertESAMCardData(ESAMCardData esamCardData);
	//开ESAM卡操作入库
	void insertIssueESAMCard(String ip);
	//更新开ESAM卡操作状态
	void updateIssueESAMCard(ESAMCardIssueRecord esamCardIssueRecord);
	
	//发ISAM卡成功的数据入库
	void insertISAMCardData(ISAMCardData isamCardData);
	//开ISAM卡操作入库
	void insertIssueISAMCard(String ip);
	//更新开ISAM卡操作状态
	void updateIssueISAMCard(ISAMCardIssueRecord isamCardIssueRecord);

	//读取卡号操作入库
	void insertReadCardNumRecord(String ip);
	//更新读取卡号操作状态
	void updateReadCardNumRecord(ReadCardNumRecord readCardNumRecord);
	
	//读取余额操作入库
	void insertReadBalanceRecord(String ip);
	//更新读取余额操作状态
	void updateReadBalanceRecord(ReadBalanceRecord readBalanceRecord);

	//充值操作入库
	void insertRechargeCard(String ip);
	//更新充值操作状态
	void updateRechargeCard(RechargeRecord rechargeRecord);
	//更新用户卡表的余额数据
	void updateUserCardBalance(RechargeRecord rechargeRecord);
	
	//重置PIN操作入库
	void insertReloadPINRecord(String ip);
	//更新充值PIN操作状态
	void updateReloadPINRecord(ReloadPINRecord reloadPINRecord);
	//更新用户卡表的PIN
	void updateUserCardPIN(String cardNum, String newPIN);
	//修改PIN操作入库
	void insertChangePINRecord(String ip);
	//更新修改PIN操作
	void updateChangePINRecord(ChangePINRecord changePINRecord);
	
	//预处理操作入库
	void inserPretreatmentRecord(String ip);
	//更新预处理操作状态
	void updatePretreatmentRecord(PretreatmentRecord pretreatmentRecord);
	
	//联机解扣操作入库
	void inserUnlockGreyRecord(String ip);
	//联机解扣处理操作状态
	void updateUnlockGreyRecord(UnlockGreyRecord unlockGreyRecord);
}

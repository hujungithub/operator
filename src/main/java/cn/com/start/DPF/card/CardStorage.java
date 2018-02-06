package cn.com.start.DPF.card;

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
import cn.com.start.DPF.service.SaveCardDataService;
import cn.com.start.DPF.util.ServiceUtil;

public class CardStorage {

	// 提供单例对象
	// 定义一个私有构造方法
	private CardStorage() {

	}
	// 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile CardStorage instance;

	// 定义一个共有的静态方法，返回该类型实例
	public static CardStorage getIstance() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (instance == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (CardStorage.class) {
				// 未初始化，则初始instance变量
				if (instance == null) {
					instance = new CardStorage();
				}
			}
		}
		return instance;
	}

	// 成员变量
	private SaveCardDataService saveCardDataService = (SaveCardDataService) ServiceUtil
			.getBean("saveCardDataServiceImpl");

	//发用户卡操作成功的记录入库
	public void insertUserCard(CardUserInfo cardUserInfo){
		saveCardDataService.addCardUserInfo(cardUserInfo);
	}
	// 开用户卡操作入库
	public void addIssueUserCardRecord(String ip) {
		saveCardDataService.insertIssueUserCard(ip);
	}
	// 更新发用户卡操作状态
	public void updateIssueUserCard(CardIssueRecord cardIssueRecord) {
		saveCardDataService.updateIssueUserCard(cardIssueRecord);
	}
	
	//开ESAM卡操作入库
	public void addIssueESAMCardRecord(String ip) {
		saveCardDataService.insertIssueESAMCard(ip);
	}
	//更新发ESAM卡操作状态
	public void updateIssueESAMCard(ESAMCardIssueRecord esamCardIssueRecord){
		saveCardDataService.updateIssueESAMCard(esamCardIssueRecord);
	}
	//发ESAM卡成功的数据入库
	public void insertESAMCard(ESAMCardData esamCardData){
		saveCardDataService.insertESAMCardData(esamCardData);
	}
	
	//开ISAM卡操作入库
	public void addIssueISAMCardRecord(String ip) {
		saveCardDataService.insertIssueISAMCard(ip);
	}
	//更新发ISAM卡操作状态
	public void updateIssueISAMCard(ISAMCardIssueRecord isamCardIssueRecord){
		saveCardDataService.updateIssueISAMCard(isamCardIssueRecord);
	}
	//发ISAM卡成功的数据入库
	public void insertISAMCard(ISAMCardData isamCardData){
		saveCardDataService.insertISAMCardData(isamCardData);
	}
	
	//读取卡号操作入库
	public void addReadCardNumRecord(String ip) {
		saveCardDataService.insertReadCardNumRecord(ip);
	}
	//更新读取卡号操作状态
	public void updateReadCardNumRecord(ReadCardNumRecord readCardNumRecord) {
		saveCardDataService.updateReadCardNumRecord(readCardNumRecord);
	}

	//读取余额操作入库
	public void addReadBalanceRecord(String ip) {
		saveCardDataService.insertReadBalanceRecord(ip);
	}
	//更新读取余额操作状态
	public void updateReadBalanceRecord(ReadBalanceRecord readBalanceRecord) {
		saveCardDataService.updateReadBalanceRecord(readBalanceRecord);
	}

	//充值操作入库
	public void addRechargeRecord(String ip) {
		saveCardDataService.insertRechargeCard(ip);
	}
	//更新充值操作状态
	public void updateRechargeCard(RechargeRecord rechargeRecord){
		saveCardDataService.updateRechargeCard(rechargeRecord);
	}
	//更新用户卡表的余额数据
	public void updateUserCardMoney(RechargeRecord rechargeRecord){
		saveCardDataService.updateUserCardBalance(rechargeRecord);
	}
	
	//重置PIN操作入库
	public void addReloadPINRecord(String ip) {
		saveCardDataService.insertReloadPINRecord(ip);
	}
	//更新充值PIN操作状态
	public void updateReloadPINRecord(ReloadPINRecord reloadPINRecord){
		saveCardDataService.updateReloadPINRecord(reloadPINRecord);
	}
	//更新用户卡表的PIN
	public void updateUserCardPIN(String cardNum, String newPIN){
		saveCardDataService.updateUserCardPIN(cardNum, newPIN);
	}
	//修改PIN操作入库
	public void addChangePINRecord(String ip){
		saveCardDataService.insertChangePINRecord(ip);
	}
	//更新修改PIN操作
	public void updateChangePINRecord(ChangePINRecord changePINRecord){
		saveCardDataService.updateChangePINRecord(changePINRecord);
	}
	
	//预处理操作入库
	public void addPretreatmentRecord(String ip) {
		saveCardDataService.inserPretreatmentRecord(ip);
	}
	//更新预处理操作状态
	public void updatePretreatmentRecord(PretreatmentRecord pretreatmentRecord) {
		saveCardDataService.updatePretreatmentRecord(pretreatmentRecord);
	}
	
	//联机解扣操作入库
	public void addUnlockGreyRecord(String ip) {
		saveCardDataService.inserUnlockGreyRecord(ip);
	}
	//联机解扣处理操作状态
	public void updateUnlockGreyRecord(UnlockGreyRecord unlockGreyRecord) {
		saveCardDataService.updateUnlockGreyRecord(unlockGreyRecord);
	}
}

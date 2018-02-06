package cn.com.start.DPF.service;

import java.util.List;

import cn.com.start.DPF.entity.carddata.*;

public interface GetCardDataService {
	//获取修改PIN的结果信息
	List<ModifyPINResult> findModifyPINResult();
	
	//获取预处理的卡号类型信息
	List<PretreatmentCardType> findPretreatmentCardType();
	
	//获取预处理的结果信息
	List<PretreatmentResult> findPretreatmentResult();
	
	//获取读取余额的结果信息
	List<ReadBalanceResult> findReadBalanceResult();
	
	//获取读取用户卡号的结果信息
	List<ReadUserCardNumResult> findReadUserCardNumResult();
	
	//获取充值的结果信息
	List<RechargeResult> findRechargeResult();
	
	//获取重载PIN的结果信息
	List<ReloadPINResult> findReloadPINResult();
	
	//获取联机解扣的结果信息
	List<RemoveGreyResult> findRemoveGreyResult();
}

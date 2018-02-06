package cn.com.start.DPF.mapper;

import java.util.List;

import cn.com.start.DPF.entity.carddata.*;

public interface GetCardDataMapper {
	//查询修改PIN的结果信息
	List<ModifyPINResult> selectModifyPINResult();
	
	//查询预处理的卡号类型信息
	List<PretreatmentCardType> selectPretreatmentCardType();
	
	//查询预处理的结果信息
	List<PretreatmentResult> selectPretreatmentResult();
	
	//查询读取余额的结果信息
	List<ReadBalanceResult> selectReadBalanceResult();
	
	//查询读取用户卡号的结果信息
	List<ReadUserCardNumResult> selectReadUserCardNumResult();
	
	//查询充值的结果信息
	List<RechargeResult> selectRechargeResult();
	
	//查询重载PIN的结果信息
	List<ReloadPINResult> selectReloadPINResult();
	
	//查询联机解扣的结果信息
	List<RemoveGreyResult> selectRemoveGreyResult();
}

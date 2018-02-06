package cn.com.start.DPF.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.entity.carddata.*;
import cn.com.start.DPF.mapper.GetCardDataMapper;

@Service
@Transactional
public class GetCardDataServiceImpl implements GetCardDataService {
	
	@Resource
	private GetCardDataMapper getCardDataMapper;

	@Override
	public List<ModifyPINResult> findModifyPINResult() {
		List<ModifyPINResult> modifyPINResult = getCardDataMapper.selectModifyPINResult();
		return modifyPINResult;
	}

	@Override
	public List<PretreatmentCardType> findPretreatmentCardType() {
		List<PretreatmentCardType> pretreatmentCardType = getCardDataMapper.selectPretreatmentCardType();
		return pretreatmentCardType;
	}

	@Override
	public List<PretreatmentResult> findPretreatmentResult() {
		List<PretreatmentResult> pretreatmentResult = getCardDataMapper.selectPretreatmentResult();
		return pretreatmentResult;
	}

	@Override
	public List<ReadBalanceResult> findReadBalanceResult() {
		List<ReadBalanceResult> readBalanceResult = getCardDataMapper.selectReadBalanceResult();
		return readBalanceResult;
	}

	@Override
	public List<ReadUserCardNumResult> findReadUserCardNumResult() {
		List<ReadUserCardNumResult> readUserCardNumResult = getCardDataMapper.selectReadUserCardNumResult();
		return readUserCardNumResult;
	}

	@Override
	public List<RechargeResult> findRechargeResult() {
		List<RechargeResult> rechargeResult = getCardDataMapper.selectRechargeResult();
		return rechargeResult;
	}

	@Override
	public List<ReloadPINResult> findReloadPINResult() {
		List<ReloadPINResult> reloadPINResult = getCardDataMapper.selectReloadPINResult();
		return reloadPINResult;
	}

	@Override
	public List<RemoveGreyResult> findRemoveGreyResult() {
		List<RemoveGreyResult> removeGreyResult = getCardDataMapper.selectRemoveGreyResult();
		return removeGreyResult;
	}
}

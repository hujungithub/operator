package cn.com.start.DPF.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.mapper.SelectDataMapper;

@Service
@Transactional
public class SelectDataServiceImpl implements SelectDataService {

	@Resource
	private SelectDataMapper selectDataMapper;

	// 根据物理卡号查询卡相关信息 进行鉴权
	@Override
	public CardUserInfo findCardUserInfo(String cardNumber) {
		CardUserInfo cardUserInfo = selectDataMapper
				.selectCardUserInfo(cardNumber);
		return cardUserInfo;
	}

	// 根据app用户id查询用户余额
	@Override
	public Float findAppUserBalance(String cpuserId) {
		Float balance = selectDataMapper.selectAppUserBalance(cpuserId);
		return balance;
	}

	@Override
	public Float findCardUserBalance(long cardNum) {
		Float balance = selectDataMapper.selectCardUserBalance(cardNum);
		return balance;
	}
}

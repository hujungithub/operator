package cn.com.start.DPF.service;

import cn.com.start.DPF.entity.CardUserInfo;

public interface SelectDataService {

	// 1.0 鉴权根据卡号查询数据
	CardUserInfo findCardUserInfo(String cardNumber);

	// 2.0根据app用户id查询余额
	Float findAppUserBalance(String cpuserId);

	Float findCardUserBalance(long cardNum);
}

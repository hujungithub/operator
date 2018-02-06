package cn.com.start.DPF.mapper;

import cn.com.start.DPF.entity.CardUserInfo;

public interface SelectDataMapper {

	// 1.0 鉴权-根据用户卡号查询用户卡信息
	CardUserInfo selectCardUserInfo(String CARDNUMBER);

	// 2.0扣款 根据app用户id查询app账户信息
	Float selectAppUserBalance(String CPUSERID);

	Float selectCardUserBalance(long CARDNUM);
}

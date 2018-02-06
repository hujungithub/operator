package cn.com.start.DPF.service;

import cn.com.start.DPF.dto.DeductInfoDto;

public interface UpdateDataService {

	// 1.0扣除app用户余额
	int updateAPPUserAccount(DeductInfoDto deInfoDto);

	int updateCardUserAccount(DeductInfoDto deInfoDto);
}

package cn.com.start.DPF.mapper;

import cn.com.start.DPF.dto.DeductInfoDto;

public interface UpdateDataMapper {

	// 1.0扣除app用户余额
	int deductAPPUserAccount(DeductInfoDto deductInfoDto);

	int deductCardUserAccount(DeductInfoDto deductInfoDto);
}

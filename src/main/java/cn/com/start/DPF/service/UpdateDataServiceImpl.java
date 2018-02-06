package cn.com.start.DPF.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.dto.DeductInfoDto;
import cn.com.start.DPF.mapper.UpdateDataMapper;

@Service
@Transactional
public class UpdateDataServiceImpl implements UpdateDataService {

	@Resource
	private UpdateDataMapper updateDataMapper;

	// 1.0收到充电记录 扣app用户款
	@Override
	public int updateAPPUserAccount(DeductInfoDto deductInfoDto) {
		int flag = updateDataMapper.deductAPPUserAccount(deductInfoDto);
		return flag;
	}

	@Override
	public int updateCardUserAccount(DeductInfoDto deInfoDto) {
		int flag = updateDataMapper.deductCardUserAccount(deInfoDto);
		return flag;
	}
}

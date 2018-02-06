package cn.com.start.webBack.service;

import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.util.Page;

public interface CpfaiService {

	// 查询所有
	Page findAll(FindARDto findARDto);

	int update(FindARDto findARDto);

	int updateAll(FindARDto findARDto);

	int findstate0(FindARDto findARDto);

	int findstate1(FindARDto findARDto);

	int findstate(FindARDto findARDto);

	int updatedc(FindARDto findARDto);

	int updateAlldc(FindARDto findARDto);

}

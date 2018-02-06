package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.mapDto;
import cn.com.start.webBack.mapper.mapMapper;
import cn.com.start.webBack.service.mapService;

@Service
@Transactional
public class mapServiceImpl implements mapService{

	@Resource
	private mapMapper mapMapper;

	@Override
	public List<mapDto> findmap(String ADDRESSNAME) {
		List<mapDto> list = mapMapper.findmap(ADDRESSNAME);
		return list;
	}

}

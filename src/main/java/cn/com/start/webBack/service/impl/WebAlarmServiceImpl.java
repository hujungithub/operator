package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.dto.WebAlarmRecordDto;
import cn.com.start.webBack.mapper.WebAlarmMapper;
import cn.com.start.webBack.service.WebAlarmService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class WebAlarmServiceImpl implements WebAlarmService {

	@Resource
	public WebAlarmMapper webAlarmMapper;

	@Override
	public int findTotalCount(FindARDto findARDto) {
		int count = webAlarmMapper.selectTotalCount(findARDto);
		return count;
	}

	@Override
	public int findNoCheckCount(FindARDto findARDto) {
		int count = webAlarmMapper.selectNoCheckCount(findARDto);
		return count;
	}

	@Override
	public int findCheckedCount(FindARDto findARDto) {
		int count = webAlarmMapper.selectCheckedCount(findARDto);
		return count;
	}

	@Override
	public List<WebAlarmRecordDto> findSaveWebData(FindARDto findARDto) {
		Page page = null;
		List<WebAlarmRecordDto> recordList = webAlarmMapper.selectSaveWebData(findARDto);
		return recordList;
	}

	// 条件查询数量
	@Override
	public int findAlramCount(FindARDto findARDto) {
		int count = webAlarmMapper.selectAlramCount(findARDto);
		return count;
	}

	// 确认单条
	@Override
	public int updateAlarmRecord(FindARDto findARDto) {
		int flag = webAlarmMapper.updateAlarmRecord(findARDto);
		return flag;
	}

	// 确认全部
	@Override
	public int updateAllAlarmRecord(FindARDto findARDto) {
		int flag = webAlarmMapper.updateAllAlarmRecord(findARDto);
		return flag;
	}

	// ajax查询所有
	@Override
	public int findCountAjax(String operatorid) {
		int count = webAlarmMapper.selectCountAjax(operatorid);
		return count;
	}

}

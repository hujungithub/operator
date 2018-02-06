package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.dto.WebAlarmRecordDto;
import cn.com.start.webBack.util.Page;

public interface WebAlarmService {
	// 查询记录总数
	public int findTotalCount(FindARDto findARDto);

	// 查询未确认总数
	public int findNoCheckCount(FindARDto findARDto);

	// 查询已确认总是
	public int findCheckedCount(FindARDto findARDto);

	// 分页查询告警记录
	List<WebAlarmRecordDto> findSaveWebData(FindARDto findARDto);

	// 条件查询数量
	int findAlramCount(FindARDto findARDto);

	// 修改单条记录
	int updateAlarmRecord(FindARDto findARDto);

	// 全部修改
	int updateAllAlarmRecord(FindARDto findARDto);

	int findCountAjax(String operatorid);
}

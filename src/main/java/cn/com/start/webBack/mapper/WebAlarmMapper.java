package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.FindARDto;
import cn.com.start.webBack.dto.WebAlarmRecordDto;

public interface WebAlarmMapper {
	// 查询总数量 不带条件
	int selectTotalCount(FindARDto findARDto);

	// 查询未确认条数
	int selectNoCheckCount(FindARDto findARDto);

	// 查询已确认条数
	int selectCheckedCount(FindARDto findARDto);

	// 分页查询告警记录
	List<WebAlarmRecordDto> selectSaveWebData(FindARDto findARDto);

	// 条件查询数量
	int selectAlramCount(FindARDto findARDto);

	// 修改单条记录
	int updateAlarmRecord(FindARDto findARDto);

	// 全部修改
	int updateAllAlarmRecord(FindARDto findARDto);

	int selectCountAjax(@Param("OPERATORID") String OPERATORID);
}

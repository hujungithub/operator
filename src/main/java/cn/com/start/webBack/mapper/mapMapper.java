package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.mapDto;

public interface mapMapper {

	List<mapDto> findmap(@Param("ADDRESSNAME") String ADDRESSNAME);

}

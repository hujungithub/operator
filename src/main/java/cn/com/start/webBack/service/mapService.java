package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.mapDto;

public interface mapService {

	List<mapDto> findmap(String ADDRESSNAME);

}

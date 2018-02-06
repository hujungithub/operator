package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.WeChatDto;
import cn.com.start.webBack.dto.WeChatPayDto;
import cn.com.start.webBack.mapper.WeChatMapper;
import cn.com.start.webBack.service.WeChatService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class WeChatServiceImpl implements WeChatService{

	@Resource
	public WeChatMapper weChatMapper;
	
	@Override
	public List<WeChatPayDto> findWeChatPayRecord(WeChatDto weChatDto) {
		List<WeChatPayDto> onePageList = weChatMapper.findWeChatPayRecord(weChatDto);
		return onePageList;
	}
	
}

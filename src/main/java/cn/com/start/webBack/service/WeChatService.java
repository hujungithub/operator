package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.WeChatDto;
import cn.com.start.webBack.dto.WeChatPayDto;

public interface WeChatService {

	List<WeChatPayDto> findWeChatPayRecord(WeChatDto weChatDto);
}

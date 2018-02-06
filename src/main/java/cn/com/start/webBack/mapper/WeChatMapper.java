package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.WeChatDto;
import cn.com.start.webBack.dto.WeChatPayDto;

public interface WeChatMapper {

	List<WeChatPayDto> findWeChatPayRecord(WeChatDto weChatDto);

	int getWeChatRecordCount(WeChatDto weChatDto);
}

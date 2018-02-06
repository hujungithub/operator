package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.WeChatDto;
import cn.com.start.webBack.dto.WeChatPayDto;
import cn.com.start.webBack.service.WeChatService;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/wechat")
public class weChatController {

	@Autowired
	private WeChatService weChatService;
	
	@RequestMapping("/findWeChatPayFirst")
	public void findWeChatPayFirst(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		JsonReDto ReDto = new JsonReDto();
		WeChatDto weChatDto = new WeChatDto();
		/*weChatDto.setREFUNDSTATUS("0");*/
		List<WeChatPayDto> onePageList = weChatService.findWeChatPayRecord(weChatDto);
		ReDto.detail.put("page",onePageList);
		send(response,ReDto);
	}
	
	@RequestMapping("/findWeChatPayRecordSaveData")
	public void findWeChatPayRecordSaveData(HttpServletRequest request,
		HttpServletResponse response,WeChatDto weChatDto) throws IOException{
		System.out.println("-----------jinru----------");
		String temp[] = weChatDto.getPageNow().substring(0).split(",");
		weChatDto.setPageNowInt(Integer.parseInt(temp[0]));
		String temp1[] = weChatDto.getPageSize().substring(0).split(",");
		weChatDto.setPageSizeInt(Integer.parseInt(temp1[0]));
		System.out.println("------1-------"+weChatDto);
		List<WeChatPayDto> onePageList = weChatService.findWeChatPayRecord(weChatDto);
		System.out.println("---------2---------"+onePageList);
		request.setAttribute("page", onePageList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(onePageList);
		System.out.println("---------json----------"+json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/text; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}

}

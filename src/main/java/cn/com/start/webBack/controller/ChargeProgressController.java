package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.webBack.dto.FindChargeProgressDto;
import cn.com.start.webBack.service.ChargeProgressService;

@Controller
public class ChargeProgressController {
	@Autowired
	private ChargeProgressService chargeProgerssService;
	
	@ResponseBody
	@RequestMapping("/findChargeProgress")
	public void findChargeProgress(HttpServletResponse response,@RequestParam String operatorloginid) throws IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindChargeProgressDto findChargeProgressDto = new FindChargeProgressDto();
		findChargeProgressDto.setOPERATORLOGINID(operatorloginid);
		List<ChargeProgressDto> chargeProgressList = chargeProgerssService
				.findChargeProgressList(findChargeProgressDto);
		System.out.println(chargeProgressList.get(0).getCHARGEMETHODID());
		if(chargeProgressList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查询失败!";
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查询成功!";
			ReDto.detail.put("page", chargeProgressList);
		}
		send(response, ReDto);
	}
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
}

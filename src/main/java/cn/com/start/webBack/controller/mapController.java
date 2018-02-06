package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.webBack.dto.mapDto;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.service.mapService;
import cn.com.start.webBack.util.ObjectListToJSON;

@Controller
@RequestMapping("/map")
public class mapController {
	
	@Autowired
	public mapService mapService;
	/**
	 * 输入关键字查询桩所有信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/findmap")
	public void findmap(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String ADDRESSNAME = request.getParameter("ADDRESS");
//		String OPERATORLOGINID = request.getParameter("OPERATORLOGINID");
		List<mapDto> list = mapService.findmap(ADDRESSNAME);
		ObjectListToJSON objectjson = new ObjectListToJSON();
		String json = objectjson.ObjectToJson(list);
		System.out.println("youmeiyou-------"+json);
		out.print(json);
		out.flush();
		out.close();
	}

}

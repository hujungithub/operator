package cn.com.start.DPF.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.DPF.aio.PileServer;
import cn.com.start.DPF.aio.StaticData;
import cn.com.start.DPF.car.CarServer;
import cn.com.start.DPF.card.CardServer;
import cn.com.start.DPF.dto.ChargeOver_DPF;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.CPStateType_DPF;
import cn.com.start.DPF.service.GetBasicDataService;

@Controller
@RequestMapping("/test")
public class GetRealUAController {

	@Resource
	private GetBasicDataService getBasicDataService;

	@RequestMapping("/testSend")
	@ResponseBody
	public void testSend(@RequestBody ChargeOver_DPF cOver_DPF)
			throws IOException {
		System.out.println("xixi");
		System.out.println(cOver_DPF.toString());
		// ObjectMapper mapper = new ObjectMapper();
		// JavaType javaType = mapper.getTypeFactory().constructParametricType(
		// List.class, ChargeOver_DPF.class);
		// List<ChargeOver_DPF> list = mapper.readValue(result, javaType);
		// System.out.println(list.toString());
	}

	@RequestMapping("/staticData")
	public void staticData(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StaticData.main(null);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		String json = "查询基础数据";
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/carServer")
	public void carServer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CarServer.main(null);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		String json = "调用服务器类";
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	@RequestMapping("/pileServer")
	public void pileServer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PileServer.main(null);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		String json = "调用服务器类";
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	@RequestMapping("/cardServer")
	public void cardServer(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		CardServer.main(null);
		System.out.println("调用服务器类");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = "xixi";
		System.out.println("测试：" + json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	@RequestMapping("/getCPStateType")
	public void getCPState(HttpServletResponse response) throws IOException {
		List<CPStateType_DPF> cpStateType = getBasicDataService
				.findCPStateType();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cpStateType);
		System.out.println("桩状态类型" + json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	@RequestMapping("/getCPInfo")
	public void getCPInfo(HttpServletResponse response) throws IOException {
		List<CPInfo_DPF> cpInfo = getBasicDataService.findCPInfo();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cpInfo);
		System.out.println("桩列表" + json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
}

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

import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.CPYCRunRecord_104;
import cn.com.start.DPF.entity.DCYcRunRecord;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.dto.ReturnCPDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.service.CpRealTimeService;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.util.GetMainDCQYCData;
import cn.com.start.webBack.util.GetMainQYCData;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/cpRealTime")
public class CpRealTimeController {

	@Autowired
	private CpRealTimeService cpRealTimeService;
	@Autowired
	private OperatorService operatorService;

	// 首次进入充电桩 查询运营商和页码
	@RequestMapping("/findCPRTByPage")
	public String findCPRTByPage(HttpServletRequest request, FindCPDto findCPDto) {
		List<OperatorInfo> operList = operatorService.findOperator();
		ReturnCPDto cpDto = new ReturnCPDto();
		cpDto.setOperList(operList);
		request.setAttribute("cpDto", cpDto);
		return "//jsp/systemMonitor/main.jsp";
	}

	// 分页查询充电桩实时充电统计
	@RequestMapping("/findCPRTAjax")
	public void findCPRTAjax(HttpServletRequest request,
			HttpServletResponse response, FindCPDto findCPDto)
			throws IOException {
		// 查询条件 为运营商和充电站 按站查看没有分页。
		// 截取点击太快产生的5,5 10,10
		if ("1".equals(findCPDto.getPageNow())
				&& "10".equals(findCPDto.getPageNow())) {
			findCPDto.setPageNow(1);
			findCPDto.setPageSize(10);
		} else {
			findCPDto.setPageNow(1);
			findCPDto.setPageSize(10);
		}
		System.out.println("条件：" + findCPDto.toString());
		Page page = cpRealTimeService.findCPIdList(findCPDto);
		System.out.println("结果：" + page.getList().toString());
		StringBuffer sBuffer = new StringBuffer();
		if ("1".equals(findCPDto.getCPTYPE())) {
			// 交流
			sBuffer.append(GetMainQYCData.getYCThead());
			for (int i = 0; i < page.getList().size(); i++) {
				String cpId = (String) page.getList().get(i);
				CPYCRunRecord_104 ycRecord = DataRelay.sychroYCMap.get(cpId);
				if (ycRecord == null) {
					// 补一个离线和0
					GetMainQYCData.getEmptyYCRecord(cpId);
				}
				sBuffer.append(GetMainQYCData.getQYCRealData(cpId, i));
			}
		} else {
			// 直流
			sBuffer.append(GetMainDCQYCData.getDCYCThead());
			for (int i = 0; i < page.getList().size(); i++) {
				String cpId = (String) page.getList().get(i);
				DCYcRunRecord dcycRecord = DataRelay.sychroDCYCMap.get(cpId);
				if (dcycRecord == null) {
					// 补一个离线和0
					GetMainDCQYCData.getEmptyDCYCRecord(cpId);
				}
				sBuffer.append(GetMainDCQYCData.getDCQYCRealData(cpId, i));
			}
		}
		page.setJson(sBuffer.toString());
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(page);
		out.print(json);
		out.flush();
		out.close();
	}
	
	
}

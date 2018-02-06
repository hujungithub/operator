package cn.com.start.webBack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.TotalDto;
import cn.com.start.webBack.dto.reportsDto;
import cn.com.start.webBack.dto.reportsDtoNew;
import cn.com.start.webBack.service.ChargeReportsService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.GetReportsData;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;
import cn.com.start.webBack.util.SortList;

@Controller
@RequestMapping("/chargereports")
public class ChargeReportsController extends LoggerController{
	@Autowired
	private ChargeReportsService chargeReportsService;

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */

	@RequestMapping("/findReportsFirst")
	public void findReportsFirst(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String operatorloginid) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindreportsDto findreportsDto = new FindreportsDto();
		findreportsDto.setOPERATORLOGINID(operatorloginid);
//		List<reportsDto> listcs = chargeReportsService
//				.findcslist(findreportsDto);
//
		List<reportsDto> csList = chargeReportsService
				.findCSreports(findreportsDto);
		List<reportsDtoNew> onePageList = chargeReportsService.showByPage(findreportsDto);
		List<TotalDto> TotalList = chargeReportsService.findTotalList(findreportsDto);
		ReDto.detail.put("page", onePageList);
		ReDto.detail.put("csList", csList);
		ReDto.detail.put("TotalList", TotalList);
		send(response, ReDto);
	}
	
	/**
	 * 分页查询
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/findReportsSaveData")
	public void findReportsSaveData(HttpServletRequest request,HttpServletResponse response,
			FindreportsDto findreportsDto) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<reportsDtoNew> onePageList = chargeReportsService.showByPage(findreportsDto);
		List<TotalDto> TotalList = chargeReportsService.findTotalList(findreportsDto);
		ReDto.detail.put("page", onePageList);
		ReDto.detail.put("TotalList", TotalList);
		send(response, ReDto);
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/reportsExport")
	public void csExport(HttpServletRequest request,
			HttpServletResponse response, FindreportsDto findreportsDto)
			throws IOException {
		String statisticsMethod = request.getParameter("statisticsMethod");
		List<reportsDtoNew> reportsList = chargeReportsService
				.findReportsList(findreportsDto);
		TotalDto totalDto = chargeReportsService
				.findReportsTotalList(findreportsDto);
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		
		String a[] = {"序号","时间","用户卡号","用户姓名","用户账号","充电次数","充电电量（度）","刷卡充电金额（元）","扫码充电金额（元）","公众号充电金额（元）","基础费用（元）","服务费（元）"
				,"总电费（元）","波阶段充电电量（度）","波阶段充电金额（元）","峰阶段充电电量（度）","峰阶段充电金额（元）","平阶段充电电量（度）","平阶段充电金额（元）"
				,"谷阶段充电电量（度）","谷阶段充电金额（元）"};
		
		if("4".equals(statisticsMethod)){
			int j = 0;
			for(int i = 0; i < a.length; i++ ){
				if(i==1 || i==10 || i==11){
					continue;
				}
				j++;
				Map<String, Object> itemMap = new HashMap<String, Object>();
				itemMap.put("title", a[i]);
				if(i>5){
					itemMap.put("columnWidth", 40);
				}else{
					itemMap.put("columnWidth", 25);
				}
				itemMap.put("dataKey", "XH"+j);
				headInfoList.add(itemMap);
		}
		}else{
			int j = 0;
			for(int i = 0; i < a.length; i++ ){
				if(i==2 || i==3 || i==4 ){
					continue;
				}
				j++;
				Map<String, Object> itemMap = new HashMap<String, Object>();
				itemMap.put("title", a[i]);
				if(i>5){
					itemMap.put("columnWidth", 40);
				}else{
					itemMap.put("columnWidth", 25);
				}
				itemMap.put("dataKey", "XH"+j);
				headInfoList.add(itemMap);
			}
		}
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem1 = null;
		Map<String, Object> dataItem2 = null;
		Map<String, Object> dataItem3 = null;
		Map<String, Object> dataItem4 = null;
		if("4".equals(statisticsMethod)){
			for (int i = 0; i < reportsList.size(); i++) {
				dataItem1 = new HashMap<String, Object>();
				reportsDtoNew reportsDto = reportsList.get(i);
				dataItem1.put("XH1", "" + (i+1));
				dataItem1.put("XH2", "" + reportsDto.getUSERCARDID());
				dataItem1.put("XH3", "" + reportsDto.getUSERNAME());
				dataItem1.put("XH4", "" + reportsDto.getUSERID());
				dataItem1.put("XH5", "" + reportsDto.getCHARGECOUNT());
				dataItem1.put("XH6", "" + reportsDto.getCHARGEQUANTITY());
				dataItem1.put("XH7", "" + reportsDto.getCARDCHARGEMONEY());
				dataItem1.put("XH8", "" + reportsDto.getAPPCHARGEMONEY());
				dataItem1.put("XH9", "" + reportsDto.getWCCHARGEMONEY());
				dataItem1.put("XH10", "" + reportsDto.getSUMCHARGEMONEY());
				dataItem1.put("XH11", "" + reportsDto.getJQ());
				dataItem1.put("XH12", "" + reportsDto.getJF());
				dataItem1.put("XH13", "" + reportsDto.getFQ());
				dataItem1.put("XH14", "" + reportsDto.getFF());
				dataItem1.put("XH15", "" + reportsDto.getPQ());
				dataItem1.put("XH16", "" + reportsDto.getPF());
				dataItem1.put("XH17", "" + reportsDto.getGQ());
				dataItem1.put("XH18", "" + reportsDto.getGF());
				dataList.add(dataItem1);
				}
			dataItem2 = new HashMap<String, Object>();
			dataItem2.put("XH1", "" + "合计");
			dataItem2.put("XH2", " " );
			dataItem2.put("XH3", " " );
			dataItem2.put("XH4", " " );
			dataItem2.put("XH5", "" + totalDto.getTOTALCOUNT());
			dataItem2.put("XH6", "" + totalDto.getTOTALQUANTITY());
			dataItem2.put("XH7", "" + totalDto.getTOTALCARDCHARGEMONEY());
			dataItem2.put("XH8", "" + totalDto.getTOTALAPPCHARGEMONEY());
			dataItem2.put("XH9", "" + totalDto.getTOTALWCCHARGEMONEY());
			dataItem2.put("XH10", "" + totalDto.getTOTALSUMCHARGEMONEY());
			dataItem2.put("XH11", "" + totalDto.getTOTALJQ());
			dataItem2.put("XH12", "" + totalDto.getTOTALJF());
			dataItem2.put("XH13", "" + totalDto.getTOTALFQ());
			dataItem2.put("XH14", "" + totalDto.getTOTALFF());
			dataItem2.put("XH15", "" + totalDto.getTOTALPQ());
			dataItem2.put("XH16", "" + totalDto.getTOTALPF());
			dataItem2.put("XH17", "" + totalDto.getTOTALGQ());
			dataItem2.put("XH18", "" + totalDto.getTOTALGF());
			dataList.add(dataItem2);
		}else{
			for (int i = 0; i < reportsList.size(); i++) {
				dataItem3 = new HashMap<String, Object>();
				reportsDtoNew reportsDto = reportsList.get(i);
				dataItem3.put("XH1", "" + (i+1));
				dataItem3.put("XH2", "" + reportsDto.getSTATISTICSTIME());
				dataItem3.put("XH3", "" + reportsDto.getCHARGECOUNT());
				dataItem3.put("XH4", "" + reportsDto.getCHARGEQUANTITY());
				dataItem3.put("XH5", "" + reportsDto.getCARDCHARGEMONEY());
				dataItem3.put("XH6", "" + reportsDto.getAPPCHARGEMONEY());
				dataItem3.put("XH7", "" + reportsDto.getWCCHARGEMONEY());
				dataItem3.put("XH8", "" + reportsDto.getCHARGEMONEY());
				dataItem3.put("XH9", "" + reportsDto.getSERVICETIP());
				dataItem3.put("XH10", "" + reportsDto.getSUMCHARGEMONEY());
				dataItem3.put("XH11", "" + reportsDto.getJQ());
				dataItem3.put("XH12", "" + reportsDto.getJF());
				dataItem3.put("XH13", "" + reportsDto.getFQ());
				dataItem3.put("XH14", "" + reportsDto.getFF());
				dataItem3.put("XH15", "" + reportsDto.getPQ());
				dataItem3.put("XH16", "" + reportsDto.getPF());
				dataItem3.put("XH17", "" + reportsDto.getGQ());
				dataItem3.put("XH18", "" + reportsDto.getGF());
				dataList.add(dataItem3);
				}
			dataItem4 = new HashMap<String, Object>();
			dataItem4.put("XH1",""+"合计");
			dataItem4.put("XH2"," " );
			dataItem4.put("XH3", "" + totalDto.getTOTALCOUNT());
			dataItem4.put("XH4", "" + totalDto.getTOTALQUANTITY());
			dataItem4.put("XH5", "" + totalDto.getTOTALCARDCHARGEMONEY());
			dataItem4.put("XH6", "" + totalDto.getTOTALAPPCHARGEMONEY());
			dataItem4.put("XH7", "" + totalDto.getTOTALWCCHARGEMONEY());
			dataItem4.put("XH8", "" + totalDto.getTOTALCHARGEMONEY());
			dataItem4.put("XH9", "" + totalDto.getTOTALSERVICETIP());
			dataItem4.put("XH10", "" + totalDto.getTOTALSUMCHARGEMONEY());
			dataItem4.put("XH11", "" + totalDto.getTOTALJQ());
			dataItem4.put("XH12", "" + totalDto.getTOTALJF());
			dataItem4.put("XH13", "" + totalDto.getTOTALFQ());
			dataItem4.put("XH14", "" + totalDto.getTOTALFF());
			dataItem4.put("XH15", "" + totalDto.getTOTALPQ());
			dataItem4.put("XH16", "" + totalDto.getTOTALPF());
			dataItem4.put("XH17", "" + totalDto.getTOTALGQ());
			dataItem4.put("XH18", "" + totalDto.getTOTALGF());
			dataList.add(dataItem4);
		}
		POIUtil.exportExcel2FilePath("充电报表", "D://充电报表.xls", headInfoList,dataList);
		download("D://充电报表.xls", response);
		}
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}
	

}

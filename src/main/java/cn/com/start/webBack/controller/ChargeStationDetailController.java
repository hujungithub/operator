package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.FindCPDto;
import cn.com.start.webBack.service.ChargeStationDetailService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.EmptyUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/chargeStationDetail")
public class ChargeStationDetailController extends BaseController{
	
	@Autowired
	private ChargeStationDetailService chargeStationDetailService;
	// 获取充电站详细信息 用于详情页面和导出记录
		@RequestMapping("/findChargeStationByIdAjax")
		public void findChargeStationByIdajax(HttpServletResponse response,HttpServletRequest request) throws IOException {
			response.addHeader("Access-Control-Allow-Origin", "*");
			JsonReDto ReDto = new JsonReDto();
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			String CSID = request.getParameter("CSID");
			//判断是否为空
			if (EmptyUtil.isStringEmpty(CSID)) {
				CSID = "1";
			}
			List<CSInfoDto> csDto = chargeStationDetailService.findCSDetailById(CSID);
//			request.setAttribute("csDto", csDto.get(0));

			FindCPDto findCPDto = new FindCPDto();
			findCPDto.setCSID(CSID);
//			findCPDto.setPageNow(1);
//			findCPDto.setPageSize(10);
			findCPDto.setMONTH(month);
			List<CSInfoDto> chargeList = chargeStationDetailService.findCPCharge(findCPDto);
			if(chargeList.size() == 0){
				ReDto.returnCode = 1;
				ReDto.errorCode = "1";
				ReDto.message = "查找失败！";
			}else{
				ReDto.returnCode = 0;
				ReDto.errorCode = "0";
				ReDto.message = "查找成功！";
				ReDto.detail.put("csDto", csDto);
				ReDto.detail.put("chargeList", chargeList);
			}
			send(response, ReDto);
//			request.setAttribute("page", page);
//			return "//jsp/device/chargeStationDetail.jsp";
		}
		
		// 保存查询条件 分页查询 切换页码
//		@ResponseBody
//		@RequestMapping("/findChargeDetail")
//		public void findChargeDetail(HttpServletResponse response,@RequestParam int pageSize,
//				@RequestParam int pageNow, FindCPDto findCPDto) throws IOException {
//			response.addHeader("Access-Control-Allow-Origin", "*");
//			JsonReDto ReDto = new JsonReDto();
////			findCPDto.setPageNow(pageNow);
////			findCPDto.setPageSize(pageSize);
//			List<CSInfoDto> chargeList = chargeStationDetailService.findCPCharge(findCPDto);
//			ReDto.detail.put("chargeList", chargeList);
//			send(response, ReDto);
////			String json = JsonUtil.toJson(page);
////			logger.info("findChargeDetail==" + json);
////			return json;
//		}
		
		/**
		 * 数据导出
		 * 
		 * @param request
		 * @throws IOException
		 */
		@RequestMapping("/csDetailExport")
		public void csDetailExport(HttpServletRequest request,
				HttpServletResponse response, FindCPDto findCPDto)
				throws IOException {
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			findCPDto.setMONTH(month);

			List<CSInfoDto> chargeList = chargeStationDetailService
					.findCSDetail(findCPDto);

			List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
			Map<String, Object> itemMap = new HashMap<String, Object>();
			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩名");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH1");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电站");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH2");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "费率模板");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH3");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电次数");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH4");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电时长");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH5");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电电量(kWh)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH6");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "服务费(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH7");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "基础电费(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH8");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "充电总费用(元)");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH9");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩厂商");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH10");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "桩型号");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH11");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "建桩日期");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH12");
			headInfoList.add(itemMap);

			itemMap = new HashMap<String, Object>();
			itemMap.put("title", "详细地址");
			itemMap.put("columnWidth", 50);
			itemMap.put("dataKey", "XH13");
			headInfoList.add(itemMap);

			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			Map<String, Object> dataItem = null;
			for (int i = 0; i < chargeList.size(); i++) {
				dataItem = new HashMap<String, Object>();
				CSInfoDto csInfoDto = chargeList.get(i);
				dataItem.put("XH1", "" + csInfoDto.getCSNAME());
				dataItem.put("XH2", "" + csInfoDto.getCPNAME());
				dataItem.put("XH3", "" + csInfoDto.getRATEID());

				if (csInfoDto.getCPCOUNT() == null) {
					dataItem.put("XH4", "");
				} else {
					dataItem.put("XH4", "" + csInfoDto.getCPCOUNT());
				}

				if (csInfoDto.getCHARGETIMESPAN() == null) {
					dataItem.put("XH5", "");
				} else {
					dataItem.put("XH5", "" + csInfoDto.getCHARGETIMESPAN());
				}
				if (csInfoDto.getCHARGEQUANTITY() == null) {
					dataItem.put("XH6", "");
				} else {
					dataItem.put("XH6", "" + csInfoDto.getCHARGEQUANTITY());
				}

				if (csInfoDto.getSERVICETIP() == null) {
					dataItem.put("XH7", "");
				} else {
					dataItem.put("XH7", "" + csInfoDto.getSERVICETIP());
				}

				if (csInfoDto.getCHARGEMONEY() == null) {
					dataItem.put("XH8", "");
				} else {
					dataItem.put("XH8", "" + csInfoDto.getCHARGEMONEY());
				}

				if (csInfoDto.getMONEYCOUNT() == null) {
					dataItem.put("XH9", "");
				} else {
					dataItem.put("XH9", "" + csInfoDto.getMONEYCOUNT());
				}
				dataItem.put("XH10", "" + csInfoDto.getMFRNAME());
				dataItem.put("XH11", "" + csInfoDto.getMODEL());
				dataItem.put("XH12", "" + csInfoDto.getCREATETIME());
				dataItem.put("XH13", "" + csInfoDto.getLOCATION());
				dataList.add(dataItem);
			}
			POIUtil.exportExcel2FilePath("充电站桩信息", "D://充电站桩信息.xls", headInfoList,
					dataList);
			download("D://充电站桩信息.xls", response);
			DeleteFileUtil.deleteFile("D://充电站桩信息.xls");// 删除保存的excel文件
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

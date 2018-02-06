package cn.com.start.AppAPI.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.AppAPI.dto.CPInfoDto_API;
import cn.com.start.AppAPI.dto.CSDetailDto;
import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.AppAPI.dto.ListSMDto;
import cn.com.start.AppAPI.dto.MapSMDto;
import cn.com.start.AppAPI.dto.SelectMapDto;
import cn.com.start.AppAPI.service.MapSPService;
import cn.com.start.AppAPI.util.EmptyUtil;
import cn.com.start.AppAPI.util.GetLLByLoc;
import cn.com.start.AppAPI.util.ScanChargeUtile;
import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.redis.RedisHandle;

/**
 * @author caijie
 * 
 */
@Controller
@RequestMapping("/mapSearchPile")
public class MapSearchPileController {
	private static Logger logger = LogManager.getLogger("LOG_API");
	@Autowired
	private MapSPService mapSPservice;

	/**
	 * 市名或经纬度 返回附近站、CPM、散桩 通过地图找
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/findSMPByMap")
	public void findSMPByMap(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String city = request.getParameter("city");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		// 通过经纬度处理
		if (EmptyUtil.isStringEmpty(city)
				&& (EmptyUtil.isStringEmpty(longitude) && EmptyUtil
						.isStringEmpty(latitude))) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0000";
			ReDto.message = "You should set parament[city]or[longitude]or[latitude]";
		} else {
			if (!EmptyUtil.isStringEmpty(city)) {
				// 通过市名求经纬度
				String lonlat[] = GetLLByLoc.getCoordinate(city);
				longitude = lonlat[0];
				latitude = lonlat[1];
			}
			System.out.println("city:" + city);
			System.out.println("经度:" + longitude + "纬度:" + latitude);
			SelectMapDto selectMapDto = new SelectMapDto();
			selectMapDto.setLATITUDE(latitude);
			selectMapDto.setLONGITUDE(longitude);

			printLog("findSMPByMap:", selectMapDto.toString());
			// 站
			List<MapSMDto> csList = mapSPservice.findNearCS(selectMapDto);
			printLog("findSMPByMap:", csList.toString());
			// cpm
			// List<MapSMDto> cpmList = mapSPservice.findNearCPM(selectMapDto);
			// 桩 桩在站内有散桩
			// List<MapSMDto> cpList = mapSPservice.findNearCP(selectMapDto);

			// System.out.println("csList" + csList.toString());
			// System.out.println("cpmList" + cpmList.toString());
			// System.out.println("cpList" + cpList.toString());

			if (csList.isEmpty()) {
				// if (csList.isEmpty() && cpmList.isEmpty()) {
				// 全为空 则找不到数据
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0001";
				ReDto.message = "no data found!";
			} else {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0002";
				ReDto.message = "get near station success ";
				ReDto.detail.put("csList", csList);

				// ReDto.detail.put("cpmList", cpmList);
				// ReDto.detail1.put("cpList", cpList);
			}
		}
		MapSearchPileController.send(response, ReDto);
	}

	/**
	 * @param csList
	 */
	private void setIdleCounts(List<ListSMDto> csList) {
		// ++modify by caijie
		if (csList != null && csList.size() > 0) {
			int size = csList.size();
			for (int i = 0; i < size; i++) {
				int dcIdleState = 0;
				int acIdleState = 0;
				String csId = csList.get(i).getCSID();
				List<String> cpidList = DataRelay.cscplinkMap.get(csId);
				System.out.println("csList size:"+size+",csId:"+csId);
				if (cpidList != null && cpidList.size() > 0) {
					
					int cplistSize = cpidList.size();
					System.out.println("cplistSize:"+cplistSize+",#########################!!!!!!");
					for (int j = 0; j < cplistSize; j++) {
						String cpId = cpidList.get(j);

						int state = DataRelay.cpMap.get(cpId).getCPTYPE();
						System.out.println("state:"+state);
						if (state == 1) {
							// 交流
							String cpStateA = RedisHandle.getString(cpId
									+ "_QYC_DATA_21", "DATA");
							String cpStateB = RedisHandle.getString(cpId
									+ "_QYC_DATA_22", "DATA");
							System.out.println("dc, cpStateA:"+cpStateA+",cpStateB"+cpStateB);
							if ("0.0".equals(cpStateA)
									|| "0.0".equals(cpStateB)) {
								acIdleState++;
							}

						} else if (state == 0) {
							// 直流
							String cpStateA = RedisHandle.getString(cpId
									+ "_QYC_DATA_21", "DATA");
							String cpStateB = RedisHandle.getString(cpId
									+ "_QYC_DATA_22", "DATA");
							System.out.println("ac, cpStateA:"+cpStateA+",cpStateB"+cpStateB);
							if ("0.0".equals(cpStateA)
									|| "0.0".equals(cpStateB)) {
								dcIdleState++;
							}
						}

					}
				}

				System.out.println("end####################end");
				
				csList.get(i).setDCISNUM(String.valueOf(dcIdleState));
				csList.get(i).setACISNUM(String.valueOf(acIdleState));
			}

		}
		// --modify by caijie
	}

	/***
	 * 通过列表 找 站 cpm 桩
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/findSMPByList")
	public void findSMPByList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		System.out.println("A" + longitude + "B" + latitude);
		if (EmptyUtil.isStringEmpty(latitude)
				|| EmptyUtil.isStringEmpty(longitude)) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[longitude]or[latitude]";
		} else {
			SelectMapDto selectMapDto = new SelectMapDto();
			selectMapDto.setLATITUDE(latitude);
			selectMapDto.setLONGITUDE(longitude);

			printLog("findSMPByList", selectMapDto.toString());

			//根据月份查找
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH) + 1;
			selectMapDto.setMONTH(String.valueOf(month));
			List<ListSMDto> csList = mapSPservice.findCSList(selectMapDto);

			List<ListSMDto> cpmList = mapSPservice.findCPMList(selectMapDto);
			// List<MapCPDto> cpList = mapSPservice.findCPList(selectMapDto);

			printLog("findSMPByList,csList:", csList.toString());
			printLog("findSMPByList,cpmList:", cpmList.toString());

			// System.out.println("csList" + csList.toString());
			// System.out.println("cpmList" + cpmList.toString());
			// System.out.println("cpList" + cpList.toString());

			// if (csList.isEmpty() && cpmList.isEmpty()) {
			// // 全为空 则找不到数据
			// ReDto.returnCode = 1;
			// ReDto.errorCode = "E0001";
			// ReDto.message = "no data found!";
			// } else {
			// 设置充电桩总个数与空闲个数
			// setIdlePileCounts(csList);

			// int size = csList.size();
			// List<String> tempList = new ArrayList<String>();
			// for(int i=0;i<size;i++){
			// tempList.add(csList.get(i).getCSID());
			// }
			// String[] arr = (String[])tempList.toArray(new String[size]);
			// List<CscpIdDto> cscpList = mapSPservice.selectCpId(arr);
			// System.out.println("##############################");
			// System.out.println(cscpList.toString());

			setIdleCounts(csList);

			ReDto.returnCode = 0;
			ReDto.errorCode = "E0002";
			ReDto.message = "get near station success ";
			System.out.println("csList" + csList.toString());
			System.out.println("cpmList" + cpmList.toString());
			// System.out.println("cpList" + cpList.toString());
			ReDto.detail.put("csList", csList);
			ReDto.detail.put("cpmList", cpmList);
			// ReDto.detail1.put("cpList", cpList);
			// }
		}
		MapSearchPileController.send(response, ReDto);
	}

	private List<String> getCpIdByCsid(String csId) {

		return mapSPservice.getCpId(csId);

	}

//	// 设置空闲桩个数
//	private void setIdlePileCounts(List<ListSMDto> zzList) {
//		if (!zzList.isEmpty()) {
//			int listSize = zzList.size();
//			for (int j = 0; j < listSize; j++) {
//				int counts = Integer.valueOf(zzList.get(j).getDCNUM())
//						+ Integer.valueOf(zzList.get(j).getACNUM());
//				int idleCounts = 0;
//
//				List<String> cpIdList = getCpIdByCsid(zzList.get(j).getCSID());
//				if (!cpIdList.isEmpty()) {
//					int size = cpIdList.size();
//					for (int i = 0; i < size; i++) {
//						String stateA = RedisHandle.getString(cpIdList.get(i)
//								+ "_QYC_DATA_21", "DATA");
//						String stateB = RedisHandle.getString(cpIdList.get(i)
//								+ "_QYC_DATA_22", "DATA");
//
//						System.out.println("cpIdList:" + cpIdList.get(i));
//						System.out.println("stateA:" + stateA + "stateB:"
//								+ stateB);
//
//						if (stateA == null && stateB == null) {
//							idleCounts++;
//						} else if ("0.0".equals(stateA) || "0.0".equals(stateB)) {
//							idleCounts++;
//						}
//					}
//
//					zzList.get(j).setDCISNUM(String.valueOf(idleCounts));
//					zzList.get(j).setDCNUM(String.valueOf(counts));
//
//					System.out.println("list[" + j + "]" + ",idleCounts:"
//							+ idleCounts);
//					System.out.println("list[" + j + "]" + ",counts:" + counts);
//
//				} else {
//					System.out.println("cpIdList.isEmpty()");
//
//				}
//
//			}
//
//		} else {
//			System.out.println("zzList.isEmpty()");
//
//		}
//
//	}

	/**
	 * 获取充电站 CPM CP基础信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/findSMPInfoById")
	public void findSMPInfoById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		if (EmptyUtil.isStringEmpty(id) || EmptyUtil.isStringEmpty(type)
				|| EmptyUtil.isStringEmpty(latitude)
				|| EmptyUtil.isStringEmpty(longitude)) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[longitude]or[latitude]";
		} else {
			SelectMapDto selectMapDto = new SelectMapDto();
			selectMapDto.setLATITUDE(latitude);
			selectMapDto.setLONGITUDE(longitude);
			List<ListSMDto> zzList = new ArrayList<ListSMDto>();

			System.out.println("findSMPInfoById type:" + type);

			// List<MapCPDto> zzList2 = new ArrayList<MapCPDto>();
			// 通过站id查询站信息
			if ("cs".equals(type)) {
				// 通过站ID找
				selectMapDto.setCSID(id);
				
				//根据月份查找
				Calendar cal = Calendar.getInstance();
				int month = cal.get(Calendar.MONTH) + 1;
				selectMapDto.setMONTH(String.valueOf(month));
				zzList = mapSPservice.findCSList(selectMapDto);

//				setIdlePileCounts(zzList);
				setIdleCounts(zzList);
				System.out.println("csList" + zzList.toString());
				ReDto.detail.put("cs", zzList);
			} else {
				selectMapDto.setCPMID(id);
				zzList = mapSPservice.findCPMList(selectMapDto);
				System.out.println("zzList" + zzList.toString());
				ReDto.detail.put("cpm", zzList);
			}

			printLog("findSMPInfoById,selectMapDto:", selectMapDto.toString());
			printLog("findSMPInfoById,zzList:", zzList.toString());

			if (zzList.isEmpty()) {
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0002";
				ReDto.message = "no data found!";
			} else {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0000";
				ReDto.message = "get cs info success ";
			}
		}
		MapSearchPileController.send(response, ReDto);
	}

	
	/**
	 * @param cpList
	 */
	private void setCpState(List<CPInfoDto_API> cpList){
		if(cpList != null && cpList.size() > 0){
			int size = cpList.size();
			for(int i=0;i<size;i++){
				String cpId = cpList.get(i).getCPID();
				System.out.println("findSMPDetailById cpId:"+cpId);
				
				
		    	int cpState = ScanChargeUtile.getCpState(cpId);
		        if(cpState == 3){
					cpList.get(i).setCURRSTATE("繁忙");
					System.out.println("cpId:"+cpId+",繁忙");
		        }else{
					cpList.get(i).setCURRSTATE("空闲");
					System.out.println("cpId:"+cpId+",空闲");
		        }
		    	
		    	
		    	
				
//				String cpStateA = RedisHandle.getString(cpId
//						+ "_QYC_DATA_21", "DATA");
//				String cpStateB = RedisHandle.getString(cpId
//						+ "_QYC_DATA_22", "DATA");
//				System.out.println("cpStateA:"+cpStateA+",cpStateB"+cpStateB);
//				
//				if ("3.0".equals(cpStateA)
//						|| "3.0".equals(cpStateB)) {
//					cpList.get(i).setCURRSTATE("繁忙");
//					System.out.println("cpId:"+cpId+",繁忙");
//				}else{
//					cpList.get(i).setCURRSTATE("空闲");
//					System.out.println("cpId:"+cpId+",空闲");
//				}
				
				
				
				
				
				
//				//在线
//				String stateTime = RedisHandle.getTString(cpId + "_QYC_DATA_TIME");
//				long time = System.currentTimeMillis() - Long.valueOf(stateTime);
//				if(time > (90*1000)){
//					
//				}
				
			}
			
		}
		
	}
	
	
	/**
	 * 返回站cpm的各种信息
	 * 
	 * @param response
	 * @param ReDto
	 * @throws IOException
	 */
	@RequestMapping("/findSMPDetailById")
	public void findSMPDetailById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		if (EmptyUtil.isStringEmpty(id) || EmptyUtil.isStringEmpty(type)
				|| EmptyUtil.isStringEmpty(latitude)
				|| EmptyUtil.isStringEmpty(longitude)) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[csId]or[longitude]or[latitude]";
		} else {
			SelectMapDto selectMapDto = new SelectMapDto();
			selectMapDto.setLATITUDE(latitude);
			selectMapDto.setLONGITUDE(longitude);
			List<ListSMDto> smDto = new ArrayList<ListSMDto>();
			List<CPInfoDto_API> cpList = new ArrayList<CPInfoDto_API>();

			if ("cs".equals(type)) {
				selectMapDto.setCSID(id);
				
				//根据月份查找
				Calendar cal = Calendar.getInstance();
				int month = cal.get(Calendar.MONTH) + 1;
				selectMapDto.setMONTH(String.valueOf(month));
				smDto = mapSPservice.findCSList(selectMapDto);
				
				System.out.println("!!!!!!!!!!!!!"+smDto.toString());
				// url = zzz；
				cpList = mapSPservice.findCPInfoByCSId(id);

				//单个充电桩状态
				setCpState(cpList);				
				//站中空闲桩个数
				setIdleCounts(smDto);

				printLog("findSMPDetailById,cpList:", cpList.toString());
				printLog("findSMPDetailById,smDto:", smDto.toString());
				// 评论
			} else {
				selectMapDto.setCPMID(id);
				smDto = mapSPservice.findCPMList(selectMapDto);
				cpList = mapSPservice.findCPInfoByCPMId(id);
			}

			CSDetailDto csDetail = new CSDetailDto();
			if (smDto.isEmpty() && cpList.isEmpty()) {
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0002";
				ReDto.message = "no data found!";
			} else {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0000";
				ReDto.message = "get cs info success ";
				ReDto.detail.put("smDto", smDto);
				ReDto.detail.put("cpList", cpList);
			}
		}
		MapSearchPileController.send(response, ReDto);
	}

	// 将json数据返回页面
	public static void send(HttpServletResponse response, JsonReDto ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		System.out.println("经纬度" + json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	private void printLog(String methodName, String content) {
		logger.info("##################################################");
		logger.info("##############" + methodName + "######################");
		logger.info(content);
		logger.info("####################################################");
		logger.info("####################################################");
	}

}

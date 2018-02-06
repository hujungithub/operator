package cn.com.start.AppAPI.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.com.start.AppAPI.dto.AppointmentCarDto;
import cn.com.start.AppAPI.dto.CarRecordDto;
import cn.com.start.AppAPI.dto.CarlistInfoDto;
import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.AppAPI.service.RentCarService;
import cn.com.start.AppAPI.util.Constant;


@Controller
@RequestMapping("/rentCar")
public class RentCarController {
	private static Logger logger = LogManager.getLogger("LOG_API");
	@Autowired
	private RentCarService rentCarService;

	
	/*
	 * 获取行程记录
	 */
	@RequestMapping("/getRouteRecord")
	public void getRouteRecord(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String userId = request.getParameter("userId");
	
		if(userId == null){
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            send(response, ReDto);
            return;
		}
		
		List<CarRecordDto> carRecordList = rentCarService.getCarRecord(userId);
	
        ReDto.returnCode = Constant.RESULT_OK;
        ReDto.errorCode = "";
        ReDto.message = "成功";
        ReDto.detail.put("recordlist", carRecordList);
        send(response, ReDto);
		
	}
	
	
	/*
	 * 生成行程记录（以后将不使用）
	 */
	@RequestMapping("/returnCar")
	public void returnCar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String carId = request.getParameter("carId");
		String userId = request.getParameter("userId");
		
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		
		if(carId == null || userId == null){
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            send(response, ReDto);
            return;
		}
		
		
		CarRecordDto dto = new CarRecordDto();
		dto.carId = carId;
		dto.cpuserId = userId;
		dto.startTime = startTime;
		dto.endTime = endTime;
		dto.orderState = 0;
		dto.orderResult = "还车成功";
		dto.orderNumber = userId+String.valueOf(System.currentTimeMillis());
		dto.money = 33;
		dto.kilometre = "15";
		rentCarService.addCarRecord(dto);
		
        ReDto.returnCode = Constant.RESULT_OK;
        ReDto.errorCode = "";
        ReDto.message = "成功";
        
        List<CarRecordDto> dtoList = new ArrayList<>();
        dtoList.add(dto);
        
        ReDto.detail.put("carRoute", dtoList);
        send(response, ReDto);
	}
	
	
	/*
	 * 租车列表
	 */
	@RequestMapping("/carlistInfo")
	public void carlistInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        
		JsonReDto ReDto = new JsonReDto();
		List<CarlistInfoDto> dtolist = rentCarService.getCarlistInfo();
		
		if(dtolist != null){
			ReDto.detail.put("carlist", dtolist);
	        ReDto.returnCode = Constant.RESULT_OK;
	        ReDto.errorCode = "";
	        ReDto.message = "成功";
			
		}else{
	        ReDto.returnCode = Constant.OTHER_ERROR;
	        ReDto.errorCode = "";
	        ReDto.message = "没有车辆";
		}
		

        send(response, ReDto);
	}
	
	
	
	/*
	 * 预约租车
	 */
	@RequestMapping("/appointment")
	public void appointment(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String carId = request.getParameter("carId");
		String userId = request.getParameter("userId");
		String status = request.getParameter("status");
		
		if(carId == null || userId == null || status == null){
            ReDto.returnCode = Constant.PARAM_ERROR;
            ReDto.errorCode = "";
            ReDto.message = Constant.PARAM_ERROR_STRING;
            send(response, ReDto);
            return;
		}
		
		
		AppointmentCarDto appointmentInfo = new AppointmentCarDto();
		appointmentInfo.carId = carId;
		appointmentInfo.cpuserId = userId;
		
		if("0".equals(status)){
			//预约
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			appointmentInfo.startTime = sf.format(new Date(System.currentTimeMillis()));
			appointmentInfo.appointState = 0;
			appointmentInfo.description = "预约";
			
			rentCarService.addAppointmentInfo(appointmentInfo);
			
//			rentCarService.updateCarState(carId);
		}else if("1".equals(status)){
			//取车
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			appointmentInfo.recordTime = sf.format(new Date(System.currentTimeMillis()));
			appointmentInfo.appointState = 1;
			appointmentInfo.description = "取车";
			
			rentCarService.updateAppointment(appointmentInfo);
			
//			rentCarService.updateCarState(appointmentInfo.sn);
		}else{
			//取消
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			appointmentInfo.recordTime = sf.format(new Date(System.currentTimeMillis()));
			appointmentInfo.appointState = 2;
			appointmentInfo.description = "取消";
			
			rentCarService.updateAppointment(appointmentInfo);
			
//			rentCarService.updateCarState(appointmentInfo.sn);
		}
		
        ReDto.returnCode = Constant.RESULT_OK;
        ReDto.errorCode = "";
        ReDto.message = "成功";
        send(response, ReDto);
	}
	
	/*
	 * @Title: send
	 * @Description: TODO
	 * @param response
	 * @param ReDto
	 * @throws IOException
	 * @return: void
	 */
	@ResponseBody
	@RequestMapping("/findCarInfoBySN")
	public void findCarInfoBySN(HttpServletResponse response,@RequestParam String SN) throws IOException{
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		List<CarlistInfoDto> carlistInfoDto = rentCarService.findCarInfoBySN(SN);
		
		ReDto.detail.put("carlistInfoDto", carlistInfoDto);
		ReDto.returnCode = Constant.RESULT_OK;
        ReDto.errorCode = "";
        ReDto.message = "成功";
		send(response, ReDto);
	}
	
    public static <T> void send(HttpServletResponse response, T ReDto)
            throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ReDto);
        System.out.println(json);
        // 向页面返回json数据
        out.print(json);
        out.flush();
        out.close();
    }
	
}

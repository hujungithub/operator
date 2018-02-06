/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JsonController.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.controller
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 下午2:33:54
 * @version: V1.0  
 */
package cn.com.start.webBack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.jsf.el.WebApplicationContextFacesELResolver;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.webBack.entity.WebAlarmOperation;
import cn.com.start.webBack.service.JpushService;
import cn.com.start.webBack.service.JsonService;
import net.sf.json.JSONObject;

/**
 * @ClassName: JsonController
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 下午2:33:54
 */
@Controller
@RequestMapping("/json")
public class JsonController extends HttpServlet {

	@Resource
	private JsonService jsonService;
	@Resource
	private JpushService jpushService;
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -8091337057789429476L;

	@RequestMapping("/insertJson")
	public void insertJson() {
		
	}
	
    /** 
     * @see HttpServlet#HttpServlet() 
     */  
    public JsonController() {  
        super();  
    }  
  
    /** 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
     */  
    @RequestMapping("/json/insertJson")
    protected void doGet(HttpServletRequest request,
				    		HttpServletResponse response) throws ServletException, IOException {  
            request.setCharacterEncoding("utf-8");  
            String json=request.getParameter("jsonlist"); 
//          List<WebAlarmRecord> list=new ArrayList<WebAlarmRecord>();
            JsonParser parser=new JsonParser();  
            JsonArray jsonArray = parser.parse(json).getAsJsonArray(); 
            Gson gson=new Gson();  
            WebAlarmOperation webAlarm = new WebAlarmOperation();
            for(JsonElement e:jsonArray) {  
            	String myjson = gson.toJson(e);
            	JSONObject jsonObject=JSONObject.fromObject(myjson);
//            	WebAlarmRecord webAlarm = new WebAlarmRecord();
            	webAlarm.setALARMDESP(jsonObject.getString("alarmdesp"));
            	webAlarm.setAPPCARDID(jsonObject.getString("appcardid"));
            	webAlarm.setCHARGETYPENAME(jsonObject.getString("chargetypename"));
            	webAlarm.setCHECKMODE(jsonObject.getInt("checkmode"));
            	webAlarm.setCHECKSTATE(jsonObject.getInt("checkstate"));
            	webAlarm.setCPID(jsonObject.getString("cpid"));
            	webAlarm.setADDRESSNAME(jsonObject.getString("addressname"));
            	webAlarm.setCSNAME(jsonObject.getString("csname"));
            	webAlarm.setLATITUDE(jsonObject.getDouble("latitude"));
            	webAlarm.setLONGITUDE(jsonObject.getDouble("longitude"));
            	webAlarm.setCPNAME(jsonObject.getString("cpname"));
            	webAlarm.setPROVINCENAME(jsonObject.getString("provincename"));
            	webAlarm.setLOCATION(jsonObject.getString("location"));
            	System.out.println("cptype === "+jsonObject.getString("cptype"));
            	if("0".equals(jsonObject.getString("cptype"))) {
            		webAlarm.setCPTYPE("直流");
            	}if("1".equals(jsonObject.getString("cptype"))) {
            		webAlarm.setCPTYPE("交流");
            	}
            	if("A".equals(jsonObject.get("gun"))) {
            		webAlarm.setGUN(1);
            	}
            	if("B".equals(jsonObject.get("gun"))) {
            		webAlarm.setGUN(2);
            	}
//            	webAlarm.setGUN(jsonObject.getString("gun"));
            	webAlarm.setMODENAME(jsonObject.getString("modename"));
            	webAlarm.setRECORDTIME(jsonObject.getString("recordtime"));
            	webAlarm.setSTATENAME(jsonObject.getString("statename"));
            	webAlarm.setSTATUS(0);
            	String recordtime = jsonObject.getString("recordtime");
            	WebAlarmOperation webAlarm2 = jsonService.findByRecordTime(recordtime);
        		if(webAlarm2 != null) {
        			System.out.println("已经存在该记录");
        		}else {
        			jsonService.addWebAlarm(webAlarm); 
        		}	
            }  
          /*  // 导入库  
            request.setAttribute("message", "添加成功");  
            request.getRequestDispatcher("/message.jsp").forward(request, response);  */
    }  
  
    /**
     * @Title: pushTrouble
     * @Description: TODO 手动推送故障信息
     * @param request
     * @param response
     * @param recordtime
     * @return: void
     * @throws IOException 
     */
    @RequestMapping("/pushTrouble")
    public void pushTrouble(HttpServletRequest request,
    		HttpServletResponse response,@RequestParam String recordtime) throws IOException{
    	String[] recordtimes = recordtime.substring(1).split(",");
    	JsonReDto ReDto = new JsonReDto();
    	int flag = 0;
    	for (String recordtime2 : recordtimes) {
    		WebAlarmOperation webAlarmOperation = jsonService.findByRecordTime(recordtime2);
    		// 未推送时推送并改变状态
    		if(webAlarmOperation.getSTATUS()==0) {
    			jpushService.autoPushSystemMessage(webAlarmOperation);
    			flag = jsonService.updatePushStatus(recordtime2);
    		}
		}
    	if(flag == 1) {
    		ReDto.message("推送成功");
    	}else{
    		ReDto.message("改信息已推送");
    	}
    	send(response,ReDto);
    }
    /** 
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
     */  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // TODO Auto-generated method stub  
        doGet(request, response);
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

package cn.com.start.webBack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.start.webBack.dto.FindreportsDto;
import cn.com.start.webBack.dto.reportsDto;
import cn.com.start.webBack.service.ChargeReportsService;

public class GetReportsData {
	//头拼接
	public static String getReportHeader(List<reportsDto> cslist){
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<tr>");
		sBuffer.append("<th>序号</th>");  
		sBuffer.append("<th>充电卡号/用户ID</th>"); 
		sBuffer.append("<th>用户名</th>");  
		sBuffer.append("<th>总充电量(度)</th>"); 
		sBuffer.append("<th>总金额(元)</th>"); 
		sBuffer.append("<th>尖时总充电量(度)</th>");  
		sBuffer.append("<th>尖时总金额(元)</th>"); 
		sBuffer.append("<th>峰时总充电量(度)</th>");  
		sBuffer.append("<th>峰时总金额(元)</th>"); 
		sBuffer.append("<th>平时总充电量(度)</th>"); 
		sBuffer.append("<th>平时总金额(元)</th>");  
		sBuffer.append("<th>谷时总充电量(度)</th>"); 
		sBuffer.append("<th>谷时总金额(元)</th>"); 
		
		for(int i=0;i<cslist.size();i++){		
			sBuffer.append("<th>"+cslist.get(i).getCSNAME()+"总充电量(度)</th>"); 
			sBuffer.append("<th>"+cslist.get(i).getCSNAME()+"总金额(元)</th>"); 
			sBuffer.append("<th>尖时总充电量(度)</th>");  
			sBuffer.append("<th>尖时总金额(元)</th>"); 
			sBuffer.append("<th>峰时总充电量(度)</th>");  
			sBuffer.append("<th>峰时总金额(元)</th>"); 
			sBuffer.append("<th>平时总充电量(度)</th>"); 
			sBuffer.append("<th>平时总金额(元)</th>");  
			sBuffer.append("<th>谷时总充电量(度)</th>"); 
			sBuffer.append("<th>谷时总金额(元)</th>"); 
		}
		sBuffer.append("</tr>");
		return sBuffer.toString();
	}
	
	//拼接
	public static String getReportsList(Map<String, List<reportsDto>> tempmap,List<reportsDto> totalList,String chargemethodid){
		StringBuffer sBuffer = new StringBuffer();
		List<reportsDto> newlist = new ArrayList<reportsDto>();
		
		String CPUSERNAME = "";
		String CARDNUM = "";
		String CPUSERCOUNT = "";
		String CPUSERID = "";
		float TOTAL_CHARGEQUANTITY = 0 ;//充电电量
		float TOTAL_CHARGEMONEY= 0;//充电金额
		float TOTAL_JQ= 0;//峰电量
		float TOTAL_FQ= 0;//峰电量
		float TOTAL_PQ= 0;//平电量
		float TOTAL_GQ= 0;//谷电量
		float TOTAL_JF= 0;//峰费用
		float TOTAL_FF= 0;//峰费用
		float TOTAL_PF= 0;//平费用
		float TOTAL_GF= 0;//谷费用 
		
		sBuffer.append("<tr>");
		int count = 0;
		List<Map.Entry<String, List<reportsDto>>> mappingList = null; 
		//通过ArrayList构造函数把map.entrySet()转换成list 
		mappingList = new ArrayList<Map.Entry<String, List<reportsDto>>>(tempmap.entrySet()); 
		 //通过比较器实现比较排序
		Collections.sort(mappingList, new Comparator<Map.Entry<String,List<reportsDto>>>(){
			public int compare(Map.Entry<String,List<reportsDto>> mapping1,Map.Entry<String,List<reportsDto>> mapping2){
				return mapping1.getKey().compareTo(mapping2.getKey());
			}
		}); 
				
		for(Entry<String, List<reportsDto>> entry:mappingList){ 
			newlist = entry.getValue();
			
			CPUSERNAME = totalList.get(count).getCPUSERNAME();
			CARDNUM = totalList.get(count).getCARDNUM();
			CPUSERCOUNT = totalList.get(count).getCPUSERCOUNT();
			CPUSERID = totalList.get(count).getCPUSERID();
			TOTAL_CHARGEQUANTITY = totalList.get(count).getTOTAL_CHARGEQUANTITY();
			TOTAL_CHARGEMONEY = totalList.get(count).getTOTAL_CHARGEMONEY();
			TOTAL_JQ = totalList.get(count).getTOTAL_JQ();//峰电量
			TOTAL_FQ = totalList.get(count).getTOTAL_FQ();//峰电量
			TOTAL_PQ = totalList.get(count).getTOTAL_PQ();//平电量
			TOTAL_GQ = totalList.get(count).getTOTAL_GQ();//谷电量
			TOTAL_JF = totalList.get(count).getTOTAL_JF();//峰费用
			TOTAL_FF = totalList.get(count).getTOTAL_FF();//峰费用
			TOTAL_PF = totalList.get(count).getTOTAL_PF();//平费用
			TOTAL_GF = totalList.get(count).getTOTAL_GF();//谷费用 
			
			
			sBuffer.append("<td>" + (count+1) + "</td>"); //1
			sBuffer.append("<td>"+CPUSERID+"</td>"); //1
			sBuffer.append("<td class='td_left'>" + CPUSERNAME + "</td>"); // 2
//			sBuffer.append("<td>" + CPUSERCOUNT + "</td>"); // 2
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_CHARGEQUANTITY) + "</td>"); // 3
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_CHARGEMONEY) + "</td>"); // 4
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_JQ) + "</td>"); // 5
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_JF) + "</td>"); //9 
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_FQ) + "</td>"); // 6
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_FF) + "</td>"); // 10
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_PQ) + "</td>"); //7
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_PF) + "</td>"); // 11
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_GQ) + "</td>"); //8
			sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(TOTAL_GF) + "</td>"); // 12
				
			
			
			for(int i=0;i<newlist.size();i++){				
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getCHARGEQUANTITY()) + "</td>"); // 3
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getCHARGEMONEY()) + "</td>"); // 4
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getJQ()) + "</td>"); // 5
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getJF()) + "</td>"); // 6
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getFQ()) + "</td>"); //7
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getFF()) + "</td>"); //8
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getPQ()) + "</td>"); //9 
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getPF()) + "</td>"); // 10
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getGQ()) + "</td>"); // 11
				sBuffer.append("<td>" + new java.text.DecimalFormat("0.0000").format(newlist.get(i).getGF()) + "</td>"); // 12
				
			}
			sBuffer.append("</tr>");
			count++;
				
		}
		
		return sBuffer.toString();
	}
	

}

package cn.com.start.AppAPI.util;

import java.util.List;


import net.sf.json.JSONArray;

public class DataToJSON {
	
	//将list转为json格式
	public String ListToJson(List list){
		JSONArray json = new JSONArray();
		json.addAll(list);
		json.listIterator();		
		return json.toString();		 
	}
	//将对象转为json格式
	public String ObjectToJson(Object object){
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}
}

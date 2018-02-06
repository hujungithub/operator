package cn.com.start.webBack.util;

import java.util.List;

import net.sf.json.JSONArray;




public class ObjectListToJSON {


	public String ObjectToJson(List list){
		JSONArray json = new JSONArray();
		json.addAll(list);
		json.listIterator();		
		return json.toString();
		 
	}
}

package cn.com.start.AppAPI.util;

import java.util.regex.*; 

public class EmptyUtil {
	
	//判断字符串是否为空
	public static boolean isStringEmpty(String str){
		if(str != null && str.length() != 0){
			return false;
		}else{
			return true;
		}
	}
	
	//判断对象是否为空
	public static boolean isObjectEmpty(Object obj){
		if(null != obj){
			return false;
		}else{
			return true;
		}
	}
	
	//判断字符串是否为数字 
	public static boolean isNumber(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    return pattern.matcher(str).matches();    
	}  
}

package cn.com.start.webBack.util;

import java.util.List;

import cn.com.start.webBack.dto.CSInfoDto;
import cn.com.start.webBack.dto.CSoperInfoDto;
import cn.com.start.webBack.dto.UserChargeDto;

public class TimeUtil {
	
	// 将秒数转换为 x小时y分z秒格式
	public static void SecToStr(List<UserChargeDto> userList){
		int a = 0;
		int b = 0;
		Integer sec = 0;
		for(int i = 0; i < userList.size(); i++){
			StringBuffer sBuffer = new StringBuffer();
			sec = userList.get(i).getCHARGETIMESPANINT();
			a = sec / 3600;
			b = sec % 3600;
			sBuffer.append(a).append("小时");
			a = b / 60;
			sBuffer.append(a).append("分");
			a = b % 60;
			sBuffer.append(a).append("秒");
			userList.get(i).setCHARGETIMESPAN(sBuffer.toString());
		}
	}
	
	public static void SecToStr1(List<CSInfoDto> userList){
		int a = 0;
		int b = 0;
		Integer sec = 0;
		for(int i = 0; i < userList.size(); i++){
			StringBuffer sBuffer = new StringBuffer();
			sec = userList.get(i).getCHARGETIMESPANINT();
			if(sec != null){
				a = sec / 3600;
				b = sec % 3600;
				sBuffer.append(a).append("小时");
				a = b / 60;
				sBuffer.append(a).append("分");
				a = b % 60;
				sBuffer.append(a).append("秒");
				userList.get(i).setCHARGETIMESPAN(sBuffer.toString());
			}
		}
	}
	
	
	
	public static void main(String arg[]){
		int a = 0;
		int b = 0;
		Integer sec = 0;	
		for(int i = 0; i < 10000; i++){
			StringBuffer sBuffer = new StringBuffer();
			sec = 126711;
			a = sec / 3600;
			b = sec % 3600;
			sBuffer.append(a).append("小时");
			a = b / 60;
			sBuffer.append(a).append("分");
			a = b % 60;
			sBuffer.append(a).append("秒");
			System.out.println("时间格式"+ sBuffer.toString());
		}
	}
}

package cn.com.start.webBack.util;

import java.util.Calendar;


public class CalandarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalandarTest ct = new CalandarTest();
		int hour = ct.getHour(100013);
		int second = ct.getSecond(1000);
		int minute = ct.getMinute(100);
		System.out.println(ct.getDay(hour) + hour+":"+second+":"+minute);
		
		 Calendar rightNow = Calendar.getInstance();
	}
	
	public int getSecond(int second){
		return second%60;
	}
	public int getMinute(int second){
		return second/60;
	}
	public int getHour(int second){
		return second/60/60/24;
	}
	
	public int getDay(int hour){
		return hour/24;
	}
	
}

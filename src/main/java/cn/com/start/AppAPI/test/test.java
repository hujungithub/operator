package cn.com.start.AppAPI.test;

import java.util.Calendar;

import cn.com.start.DPF.aio.DataRelay;

import redis.clients.jedis.Jedis;

public class test {

	public static void main(String args[]) {
		java.util.Date zz = new java.util.Date();
		// System.out.println(zz.getMonth() + 1);
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE) + hour * 60;
		System.out.println(minute);
		Jedis jedis = new Jedis("192.168.8.132", 6379);
		jedis.set("caijie", "123");
		System.out.println(jedis.get("caijie"));
		
		
	}
}

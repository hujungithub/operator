package cn.com.start.DPF.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.entity.Book_DPF;

public class testRedis {
	private static Jedis jedis;
	private static Logger logger = LogManager.getLogger("LOG_REDIS");
	public static void main(String[] args) {
		
		for(int i = 0; i < 10000; i++){
			RedisHandle.setTString("xi"+ i, "hehe"+i);
			System.out.println(RedisHandle.getTString("xi" + i));			
		}

		
	}

	
}
package cn.com.start.DPF.redis;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.util.StringUtil;

public class RedisHandle {
	private static Logger logger = LogManager.getLogger("LOG_DPF");

	public static void setTString(String key, String value) {
		Jedis jedis = RedisUtil.getJedis();
		
		try {
			if (jedis != null && !StringUtil.isEmpty(value)) {
				jedis.set(key, value);
			}
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		} finally {
			
			RedisUtil.returnResource(jedis);
		}
	}
	
	public static String getTString(String key) {
		Jedis jedis = RedisUtil.getJedis();
		
		if (jedis == null || !jedis.exists(key)) {
			RedisUtil.returnResource(jedis);
			return null;
		} else {
			String value = jedis.get(key);
			
			RedisUtil.returnResource(jedis);
			return value;
		}

	}
	public static void delKey(String key) {
		Jedis jedis = RedisUtil.getJedis();
		try {
			if (jedis != null) {
				jedis.del(key);
			}
		} catch (Exception e) {
			logger.error("del key error : " + e);
		} finally {
			RedisUtil.returnResource(jedis);
		}
	}

	public static void setString(String key, String filed, String value) {
		Jedis jedis = RedisUtil.getJedis();
		try {
			if (jedis != null && !StringUtil.isEmpty(value)) {
				jedis.hset(key, filed, value);
			}
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		} finally {
			RedisUtil.returnResource(jedis);
		}
	}

	public static String getString(String key, String filed) {
		Jedis jedis = RedisUtil.getJedis();
		if (jedis == null || !jedis.exists(key)) {
			RedisUtil.returnResource(jedis);
			return null;
		} else {
			String value = jedis.hget(key, filed);
			RedisUtil.returnResource(jedis);
			return value;
		}

	}

	public static void setMap(String key, Map<String, String> value) {
		Jedis jedis = RedisUtil.getJedis();
		try {
			if (value != null && jedis != null) {
				jedis.hmset(key, value);
			}
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		} finally {
			RedisUtil.returnResource(jedis);
		}
	}

	public static Map<String, String> getMap(String key) {
		Jedis jedis = RedisUtil.getJedis();
		if (jedis == null || !jedis.exists(key)) {
			RedisUtil.returnResource(jedis);
			return null;
		} else {
			Map<String, String> map = jedis.hgetAll(key);
			RedisUtil.returnResource(jedis);
			return map;
		}

	}

	public static void setKeyTime(String key, int seconds) {
		Jedis jedis = RedisUtil.getJedis();
		try {
			if (jedis != null && jedis.exists(key))
				// jedis不是空而且里面存在键
				jedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error("Set keyex error : " + e);
		} finally {
			RedisUtil.returnResource(jedis);
		}
	}
}

package cn.com.start.DPF.test2;

import java.util.Random;

import redis.clients.jedis.Jedis;

public class test111 {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			// 5个线程
			new testRedis(i + 1);
		}
	}

	// 生成随机字符串
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}

class testRedis extends Thread {

	private int id;

	public testRedis(int id) {
		this.id = id;
		start();
	}

	/**
	 * 主体函数
	 */
	@Override
	public void run() {
		Random r = new Random();
		int zz = r.nextInt(10);
		// String msg = test111.getRandomString(zz);

		String msg = "--这是第 " + id + "个线程的数据";
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		for (int i = 1; i <= 5; i++) {
			String key = test111.getRandomString(5);
			jedis.set(key, msg);
			System.out.println("第" + id + "个线程" + "第" + i + "次插入数据");
			System.out.println("取出刚插入的数据  " + key + jedis.get(key));
		}
	}
}
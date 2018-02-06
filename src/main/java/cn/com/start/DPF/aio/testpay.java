package cn.com.start.DPF.aio;

import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class testpay {
	private static Logger logger = LogManager.getLogger("LOG_DPF");

	public static void main(String args[]) {
		testRand();
	}
	
	public static void testtime(){
		for(int i = 0; i < 1000; i++){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long a = System.currentTimeMillis();
			System.out.println(a);
		}
		
	}
	
	public static void testRand(){
		int j,k,l,y,z=0;
		Random sRandom = new Random();
		for(int i = 0; i < 1000; i++){
			j = sRandom.nextInt(10);
			k = sRandom.nextInt(10);
			l = sRandom.nextInt(10);
			y = j+k+l;
			System.out.println(" j= "+j+" k= "+k+" l= "+l);
			System.out.println(y);
			z += y;
		}
		System.out.println("平均="+z/1000);
	}
	public static void testxhai(){
		byte b = (byte) 0xff;
		String string = Integer.toBinaryString((0x99 & 0xFF) + 0x100)
				.substring(1);
		System.out.println(string);

		int i = 5;
		int j = 8;
		i = i + j;
		System.out.println(i);

		
		
		String s = "0000";
		System.out.println(CreateByte.bytesToHexString(CreateByte.str2Bcd(s)));

		byte[] buf;
		buf = ByteUtil.getTTBytes(2.0f);
		System.out.println(CreateByte.bytesToHexString(buf));
	}
	public static void test11() {
		byte[] buf = { 0x00, 0x00, 0x1f, 0x40 };
		System.out.println(ByteUtil.getTTFloat(buf));
	}

	public static void testyc() {
		byte[] buf = { (byte) 0x96 };
		int length;
		String limit = Integer.toBinaryString((buf[0] & 0xFF) + 0x100)
				.substring(1);
		if (limit.charAt(0) - '0' == 1) {
			// 地址连续
			length = ByteUtil.LbyteToInt(buf[0]) - 128;
		} else {
			// 地址不连续
			length = ByteUtil.LbyteToInt(buf[0]);
		}
		System.out.println(length);
	}

	public static void testua() {
		byte[] a = { 0x03, 0x58, 0x0c, 0x01 };
		int b = ByteUtil.LbytesToInt(ByteUtil.subBytes(a, 1, 2));
		System.out.println(b);
	}

	public static void testzz() {
		byte[] a = { 0x68, 0x79, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x84,
				(byte) 0x96, 0x14, 0x00, 0x44, 0x03 };
		byte b = (byte) 0x84;
		int c = (b & 0xFF);
		System.out.println(c);
		if ((a[7] & 0xFF) == 132) {
			System.out.println("nimabi");
		} else {
			System.out.println("haah");
		}
	}

	public static void testxixi() {
		long a = System.currentTimeMillis();
		byte[] zz = { 0x00, 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77,
				(byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb,
				(byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff };
		String xixi = CreateByte.bcdToStr(zz);
		System.out.println(xixi);

		String ss = "0112000000000000";
		System.out.println(CreateByte.bytesToHexString(CreateByte.str2Bcd(ss)));
		long b = System.currentTimeMillis();
		System.out.println(b - a);
	}

	public static void testz() {
		byte[] a = { 0x04, 0x00 };
		System.out.println(ByteUtil.LbytesToInt(a));
	}

	public static void test2() {
		Jedis jedis = new Jedis("139.129.194.195", 6379);
		jedis.auth("Sxsk_redis");
		System.out.println(jedis.keys("*"));
	}

	public static void test1() {
		for (int i = 0; i < 10000; i++) {
			logger.info("#@@@@@@@@@@@@@@$$$$$$$$$$$$%%%%%%%%%%%%%%%%%");
			logger.info("#######################################################");
			logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			logger.info("");
			logger.info("");
		}
	}

	public static void test() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		long a = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis() - a);
		String t = "2016-10-12 12:11:05";
		System.out.println(t.substring(11));
		System.out.println(t.substring(0, 10));
		Map<String, String> testMap = jedis.hgetAll("1");
		if (testMap == null || testMap.size() < 1) {
			System.out.println("ss");
		} else {
			System.out.println("haha");
		}
	}
}
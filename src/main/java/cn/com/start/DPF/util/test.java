package cn.com.start.DPF.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class test {

	public static void main(String args[]) {
//		byte[] buf = { 0x07, 0x01, 0x00, 0x40, 0x02, 0x00, 0x10, 0x14, 0x11,
//				0x02, 0x0e, 0x0e, 0x1b, 0x1b, 0x00, 0x01 };
//		String zz = CreateByte.getTransitionId(buf);
//		System.out.println(zz);
		
		byte[] haha = {0x00, 0x02, 0x10, (byte)0x84}; 
		byte[] xixi = {0x00, 0x01, 0x57, (byte)0x89};
		System.out.println(ByteUtil.getTTFloat(haha));
		System.out.println(ByteUtil.getTTFloat(xixi));
		
		byte[] zz = {(byte)0xd8, (byte)0xd6, 0x0b, 0x16, 0x1a, 0x06, 0x11};
		System.out.println(CreateByte.bytesToTime(zz));
	}

	public static void test1() {
		// StringBuffer sBuffer = new StringBuffer("1111222");
		// String aString = "1111222";
		// String bString = sBuffer.toString();
		// if (bString.equals(aString)) {
		// System.out.println("zz");
		// }
		// System.out.println(sBuffer.toString());
		//
		// String s = "3_YCNUM_20";
		// System.out.println(s.substring(0, 7));

		byte[] b = { 0x07, 0x01, 0x00, 0x40, 0x02, 0x00, 0x10, 0x11 };
		byte[] c = { (byte) 0xE2, (byte) 0x07, (byte) 0xD7, (byte) 0xB8, 0x00,
				0x00 };
		System.out.println(ByteUtil.bytesToBigInteger(c));
		System.out.println(ByteUtil.LbytesToInt(c));

		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Set<String> zz = new HashSet<String>();
		HashMap<String, String> dd = new HashMap<String, String>();
		List<String> zzList = new ArrayList<String>();
		zz = jedis.keys("310*******_CP");
		for (Iterator it = zz.iterator(); it.hasNext();) {
			zzList = jedis.hmget(it.next().toString(), "CPID", "DEVICEID");
			// System.out.println(zzList.toString());
			// 必须要重新new！
			dd.put(zzList.get(1), zzList.get(0));
		}
		String zz1 = "s";
		if (!zz1.equals("")) {
			System.out.println(zz1);
		}
		if (dd.get("11") == null) {
			System.out.println("xixi");
		}
		String[] bss = { "a", "b", "c" };
		byte zzaaa = 0x32;
		System.out.println("");
		System.out.println(Long.toBinaryString(zzaaa));
		String xixString = Integer.toBinaryString((zzaaa & 0xFF) + 0x100)
				.substring(1);
		System.out.println(xixString.charAt(xixString.length() - 0) - 48);
	}
}

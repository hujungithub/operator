package cn.com.start.DPF.aio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.entity.CPMLinkCP_DPF;
import cn.com.start.DPF.util.socket.ByteMerge;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class test {

	public static byte[] float2byte(float f) {

		// 把float转换为byte[]
		int fbit = Float.floatToIntBits(f);

		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (fbit >> (24 - i * 8));
		}

		// 翻转数组
		int len = b.length;
		// 建立一个与源数组元素类型相同的数组
		byte[] dest = new byte[len];
		// 为了防止修改源数组，将源数组拷贝一份副本
		System.arraycopy(b, 0, dest, 0, len);
		byte temp;
		// 将顺位第i个与倒数第i个交换
		for (int i = 0; i < len / 2; ++i) {
			temp = dest[i];
			dest[i] = dest[len - i - 1];
			dest[len - i - 1] = temp;
		}

		return dest;

	}

	public static float byte2float(byte[] b, int index) {
		int l;
		l = b[index + 0];
		l &= 0xff;
		l |= ((long) b[index + 1] << 8);
		l &= 0xffff;
		l |= ((long) b[index + 2] << 16);
		l &= 0xffffff;
		l |= ((long) b[index + 3] << 24);
		return Float.intBitsToFloat(l);
	}

	public static void main(String args[]) {
		// test3333();
		// String zz = "3_YCNUM_20";
		// System.out.println(zz.substring(8, zz.length()));
		// test44();
		// byte initial[] = { 0x44, 0x03 };
		// int init = ByteUtil.LbytesToInt(ByteUtil.subBytes(initial, 0, 2));
		// System.out.println(init);
		//
		// byte[] buf = new byte[77];
		// // 报文头 固定部分
		// byte[] fixed = { 0x68, 0x4A, 0x00, 0x00, 0x00, 0x00, 0x00, (byte)
		// 0x85,
		// 0x01, 0x06, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x05 };
		// System.arraycopy(fixed, 0, buf, 0, fixed.length);
		// System.out.println(CreateByte.bytesToHexString(buf));
		// System.out.println(buf.length);
		// int i = 5900;
		// System.out.println(CreateByte.bytesToHexString((CreateByte
		// .intTo4Byte(i))));
		// testtime();
		// test();
		// testaa();
		// testhehe();
		byte[] a = ByteUtil.longToByte(1510375018220161214l);
		System.out.println(CreateByte.bytesToHexString(a));
		System.out.println(ByteUtil.LbytestoLong(a));
	}

	public static byte[] testtime() {
		String time1 = "2016-12-11 15:23:59";
		byte[] buf = new byte[7];
		int ipos = 0;
		// 拿到毫秒
		System.out.println(time1.charAt(17));
		int millsecond;
		if (time1.charAt(17) - '0' == 0) {
			millsecond = Integer.parseInt(time1.substring(18)) * 1000;
		} else {
			millsecond = Integer.parseInt(time1.substring(17)) * 1000;
		}
		byte[] bufmill = ByteUtil.subBytes(CreateByte.intTo4Bytes(millsecond),
				0, 2);
		System.out.println(CreateByte.bytesToHexString(bufmill));
		byte[] minute = CreateByte.intTo1Bytes(Integer.parseInt(time1
				.substring(14, 16)));
		byte[] hour = CreateByte.intTo1Bytes(Integer.parseInt(time1.substring(
				11, 13)));
		byte[] day = CreateByte.intTo1Bytes(Integer.parseInt(time1.substring(8,
				10)));
		byte[] month = CreateByte.intTo1Bytes(Integer.parseInt(time1.substring(
				5, 7)));
		byte[] year = CreateByte.intTo1Bytes(Integer.parseInt(time1.substring(
				2, 4)));
		buf = ByteMerge.byteMerger6(bufmill, minute, hour, day, month, year);
		System.out.println(CreateByte.bytesToHexString(buf));
		return buf;
	}

	public static void testaa() {
		// 查询cpm和cp对照关系

		HashMap<String, List<String>> linkMap = new HashMap<String, List<String>>();
		List<CPMLinkCP_DPF> linkList = new ArrayList<CPMLinkCP_DPF>();
		CPMLinkCP_DPF zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("1");
		zzCp_DPF.setCPID("A");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("1");
		zzCp_DPF.setCPID("B");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("1");
		zzCp_DPF.setCPID("C");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("2");
		zzCp_DPF.setCPID("D");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("3");
		zzCp_DPF.setCPID("E");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("4");
		zzCp_DPF.setCPID("F");
		linkList.add(zzCp_DPF);

		zzCp_DPF = new CPMLinkCP_DPF();
		zzCp_DPF.setCPMID("4");
		zzCp_DPF.setCPID("G");
		linkList.add(zzCp_DPF);

		List<String> temp = new ArrayList<String>();
		String cpmId = new String();
		for (int i = 0; i < linkList.size(); i++) {
			if (i == 0) {
				temp.add(linkList.get(i).getCPID());
				cpmId = linkList.get(i).getCPMID();
			} else {
				if (linkList.get(i).getCPMID().equals(cpmId)) {
					// 第二次进来还是同一个cpm,继续
					temp.add(linkList.get(i).getCPID());
				} else {
					// 不是同一个cpm 先把上一个list放进map 然后把新的放到list中
					linkMap.put(cpmId, temp);
					// 重新new一个
					temp = new ArrayList<String>();
					temp.add(linkList.get(i).getCPID());
					cpmId = linkList.get(i).getCPMID();
				}
			}
			System.out.println("cpmid=" + cpmId);
			System.out.println("temp=" + temp);
			System.out.println("map=" + linkMap.toString());
			System.out.println("");
		}
		linkMap.put(cpmId, temp);
		System.out.println(linkMap.toString());
	}

	public static void test() {
		byte[] zz = { 0x78, (byte) 0xe6, 0x3b, 0x17, 0x1f, 0x0c, 0x10 };
		System.out.println(CreateByte.bytesToTime(zz));
		Calendar calendar = Calendar.getInstance();
		// calendar.setTimeInMillis(System.currentTimeMillis());
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		byte[] aa = { 0x66, 0x66, (byte) 0xa6, 0x3f };
		byte[] bb = { 0x00, 0x00, (byte) 0xc0, 0x3f };
		byte[] cc = { (byte) 0x9a, (byte) 0x99, (byte) 0xd9, 0x3f };
		byte[] dd = { 0x33, 0x33, (byte) 0xf3, 0x3f };
		System.out.println(CreateByte.BytesToFloat(dd));
		System.out.println(CreateByte.bytesToHexString(ByteUtil
				.longToByte(112l)));
		byte[] ee = { (byte) 0xA0, (byte) 0x8C, 0x02, 0x09, 0x1C, 0x0B, 0x10 };
		System.out.println(CreateByte.bytesToTime(ee));
		byte[] ff = { (byte) 0xfc, (byte) 0xdc, (byte) 0xc4, 0x41 };
		byte[] gg = { (byte) 0x41, (byte) 0xc4, (byte) 0xdc, (byte) 0xfc };
		float tt = 1.0f;
		byte[] zhf = CreateByte.FloatToBytes(tt);
		System.out.println(CreateByte.bytesToHexString(zhf));
		System.out.println(CreateByte.BytesToFloat(zhf));
		System.out.println(CreateByte.bytesToHexString(CreateByte
				.intTo4Bytes(836)));
	}

	public static void test44() {
		// byte buf[] = { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff,
		// (byte) 0xff, (byte) 0xff };
		// byte buf1[] = { (byte) 0xE2, 0x07, (byte) 0xD7, (byte) 0xB8, 0x00,
		// 0x00 };
		// byte buf2[] = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
		// byte buf3[] = { 0x01, 0x02 };
		// byte buf4[] = { (byte) 0x83 };
		// byte buf5[] = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x02,
		// 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01,
		// 0x08, 0x10 };
		// System.out.println(ByteUtil.LbytesToInt(ByteUtil.subBytes(buf5,
		// buf5.length - 12 - 2, 2)));
		// System.out.println(buf5.length);
		// System.out.println(ByteUtil.getCPID(buf2));

	}

	public static void test2222() {
		String aString = CreateByte
				.bytesToHexString(float2byte(11234235410.5f)).toString();
		System.out.println(aString);
		byte[] b = CreateByte.hexStringToBytes(aString);
		float c = byte2float(b, 0);
		System.out.println(c);

		String bString = CreateByte.bytesToHexString(
				CreateByte.FloatToBytes(0.5f)).toString();
		System.out.println("我的" + bString);
		byte[] bb = CreateByte.hexStringToBytes(bString);
		float cc = CreateByte.BytesToFloat(bb);
		System.out.println(cc);
	}

	public static void testhehe() {
		byte[] a = { 0x0a, (byte) 0xd7, 0x23, 0x3e };
		byte[] b = { (byte) 0xcd, (byte) 0xcc, 0x4c, 0x3e };
		System.out.println("hhh" + CreateByte.BytesToFloat(a));
		System.out.println("xxx" + CreateByte.BytesToFloat(b));
	}

	public static void test1111() {
		byte b = (byte) 0x94;
		String limit = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
		System.out.println("ss" + limit);
		System.out.println(ByteUtil.LbyteToInt(b) - 128);

		float f = 10000.0f;
		int bits = Float.floatToRawIntBits(f);
		System.out.println(Integer.toBinaryString(bits));

		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 10000; i++) {
			byte[] buf = { 0x07, 0x01, 0x00, 0x40, 0x02, 0x00, 0x10, 0x11,
					0x07, 0x0B, 0x1C, 0x14, 0x10, 0x07, 0x00, 0x04 };
			System.out.println(bcd2Str(buf));
		}
		System.out.println(System.currentTimeMillis());
		Map<String, String> map = new HashMap<String, String>();

		Jedis jedis = new Jedis("127.0.0.1", 6379);
		map = jedis.hgetAll("111");
		System.out.println(map.size());
		if (map != null) {
			System.out.println("zz");
		}
	}

	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.substring(0, 1).equalsIgnoreCase("0") ? temp.substring(1)
				: temp.toString();

	}
}

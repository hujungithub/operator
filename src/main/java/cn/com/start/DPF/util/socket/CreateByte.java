package cn.com.start.DPF.util.socket;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateByte {
	private static Calendar calendar = Calendar.getInstance();

	public static void main(String[] args) {
		// test3();
		test4();
	}

	public static void test3() {
		String string = "0701004002001011";
		byte[] a = { 0x07, 0x01, 0x00, 0x40, 0x02, 0x00, 0x10, 0x11 };
		byte[] b = str2Bcd(string);
		System.out.println(bytesToHexString(b));
		System.out.println(bcdToStr(a));

		String string2 = "afdsfadfasdfsadf";
		System.out.println(string2.substring(1));
	}

	public static void test4() {
		byte[] buf = { 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x98, (byte) 0x96,
				(byte) 0x8b };
		byte[] a = { (byte) 0x8b, (byte) 0x96, (byte) 0x98, 0x00, 0x00, 0x00,
				0x00, 0x00 };
		System.out.println(bcdToStr(buf));
		// String string = bcdToStr(buf);
		//
		// int a = Integer.parseInt(string);
		// System.out.println(a);
		// System.out.println(Integer.toHexString(a));

		System.out.println(ByteUtil.bytesToBigInteger(a));
		System.out.println(CreateByte.bytesToHexString(CreateByte
				.FloatToBytes(Float.parseFloat("10000011"))));
		System.out.println(CreateByte.bytesToHexString(ByteUtil.longToByte(Long
				.parseLong("10000011"))));
	}

	public static void test111() {
		byte[] b = { (byte) 0xa4, 0x70, 0x45, 0x41 };
		System.out.println("字符数组转float  " + BytesToFloat(b));
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			byte[] c = FloatToBytes(12.34f);
			String td = bytesToHexString2(c).toString();
			System.out.println(td);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("the time1 is " + String.valueOf((t2 - t1)));
		for (int i = 0; i < 1000000; i++) {
			byte[] c = FloatToBytes(12.34f);
			String td = bytesToHexString2(c).toString();
			System.out.println(td);
		}
		long t3 = System.currentTimeMillis();
		System.out.println("the time2 is " + String.valueOf(t3 - t2));
	}

	public static void test222() {
		byte[] b = { 0x00, 0x40, 0x1c, 0x46 };
		System.out.println("字符数组转float  " + BytesToFloat(b));
		byte[] c = FloatToBytes(10000.0f);
		System.out.println("kkkk   " + bytesToHexString2(c));
	}

	public static String getCurrTime() {
		calendar.setTimeInMillis(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(calendar.getTime());
	}

	public static String getTransitionId(byte[] buf) {
		StringBuffer temp = new StringBuffer();
		// 8字节bcd
		temp.append(CreateByte.bcdToStr(ByteUtil.subBytes(buf, 0, 8)));
		// 6字节时间
		byte b;
		int zz;
		for (int i = 0; i < 6; i++) {
			b = buf[8 + i];
			zz = ByteUtil.LbyteToInt(b);
			if (zz < 10) {
				temp.append("0" + ByteUtil.LbyteToInt(b));
			} else {
				temp.append(ByteUtil.LbyteToInt(b));
			}
		}
		//temp.append(CreateByte.bcdToStr(ByteUtil.subBytes(buf, 14, 2)));
		temp.append(ByteUtil.bytes1ToInt(ByteUtil.subBytes(buf, 14, 1)));
		temp.append(ByteUtil.bytes1ToInt(ByteUtil.subBytes(buf, 15, 1)));
		// 2字节自增
		return temp.toString();
	}

	// BCD转String deviceid和流水号等等
	public static String bcdToStr(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(0) : temp.toString();
	}

	// str转bcd
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	// 解析从cpm传的报文拿到的时间
	public static StringBuffer getCPMTime(byte[] temp, StringBuffer sBuffer) {
		for (int i = 0; i < temp.length; i++) {
			int z = ByteUtil.LbyteToInt(temp[i]);
			if (z < 10) {
				if (i == 0) {
					sBuffer.append(z);
				} else if (i < 3) {
					sBuffer.append("-0" + z);
				} else if (i == 3) {
					sBuffer.append(" 0" + z);
				} else {
					sBuffer.append(":0" + z);
				}
			} else {
				if (i == 0) {
					sBuffer.append(z);
				} else if (i < 3) {
					sBuffer.append("-" + z);
				} else if (i == 3) {
					sBuffer.append(" " + z);
				} else {
					sBuffer.append(":" + z);
				}
			}
		}
		return sBuffer;
	}

	// 将时间转换为byte CP56Time2a格式 time必须为YYYY-MM-DD HH:mm:ss
	public static byte[] timeToBytes(String time) {
		byte[] buf = new byte[7];
		// 拿到毫秒
		int millsecond;
		if (time.charAt(17) - '0' == 0) {
			millsecond = Integer.parseInt(time.substring(18)) * 1000;
		} else {
			millsecond = Integer.parseInt(time.substring(17)) * 1000;
		}
		byte[] bufmill = ByteUtil.subBytes(CreateByte.intTo4Bytes(millsecond),
				0, 2);
		byte[] minute = CreateByte.intTo1Bytes(Integer.parseInt(time.substring(
				14, 16)));
		byte[] hour = CreateByte.intTo1Bytes(Integer.parseInt(time.substring(
				11, 13)));
		byte[] day = CreateByte.intTo1Bytes(Integer.parseInt(time.substring(8,
				10)));
		byte[] month = CreateByte.intTo1Bytes(Integer.parseInt(time.substring(
				5, 7)));
		byte[] year = CreateByte.intTo1Bytes(Integer.parseInt(time.substring(2,
				4)));
		buf = ByteMerge.byteMerger6(bufmill, minute, hour, day, month, year);
		return buf;
	}

	// 将bytes转成time CP56Time2a格式
	public static StringBuffer bytesToTime(byte[] buf) {
		StringBuffer time = new StringBuffer();
		int pos = buf.length;
		time.append("20");
		for (int i = 0; i < 5; i++) {
			int z = ByteUtil.LbyteToInt(buf[--pos]);
			if (z < 10) {
				if (i == 0) {
					time.append(z);
				} else if (i < 3) {
					time.append("-0" + z);
				} else if (i == 3) {
					time.append(" 0" + z);
				} else {
					time.append(":0" + z);
				}
			} else {
				if (i == 0) {
					time.append(z);
				} else if (i < 3) {
					time.append("-" + z);
				} else if (i == 3) {
					time.append(" " + z);
				} else {
					time.append(":" + z);
				}
			}
		}
		int second = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, 0, pos)) / 1000;
		if (second < 10) {
			time.append(":0" + second);
		} else {
			time.append(":" + second);
		}
		return time;
	}

	// 整形int转换成字符串数组 小于255的int可以这样强制转换 4个byte表示1个int
	public static byte[] intTo1Bytes(int data) {
		byte[] buf = new byte[1];
		buf[0] = (byte) data;
		return buf;
	}

	// 假的是用于补0的 只有小于255才可以
	public static byte[] intTo2Bytes(int data) {
		byte[] buf = new byte[2];
		buf[0] = 0x00;
		buf[1] = (byte) data;
		return buf;
	}

	// int转2字节,高位补0
	public static byte[] intToTwoBytes(int data) {
		byte[] buf = new byte[2];
		String str = Integer.toHexString(data);
		for (int i = 0; i < 4; i++) {
			if (str.length() < 4) {
				str = "0" + str;
			}
		}
		buf = hexStringToBytes(str);
		return buf;
	}

	// int转16进制数3字节，高位补0
	public static byte[] intTo3Bytes(int data) {
		byte[] buf = new byte[3];
		String str = Integer.toHexString(data);
		for (int i = 0; i < 6; i++) {
			if (str.length() < 6) {
				str = "0" + str;
			}
		}
		buf = hexStringToBytes(str);
		return buf;
	}

	// int转16进制数4字节，高位补0
	public static byte[] intToFourBytes(int data) {
		byte[] buf = new byte[3];
		String str = Integer.toHexString(data);
		for (int i = 0; i < 8; i++) {
			if (str.length() < 8) {
				str = "0" + str;
			}
		}
		buf = hexStringToBytes(str);
		return buf;
	}

	// 将int数值转换为四个字节的byte数组 低位在前 大于255的转
	public static byte[] intTo4Bytes(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) (value & 0xFF);
		src[1] = (byte) ((value >> 8) & 0xFF);
		src[2] = (byte) ((value >> 16) & 0xFF);
		src[3] = (byte) ((value >> 24) & 0xFF);
		return src;
	}

	// 字符串转ASCII码字节数组
	public static byte[] stringToASCIIBytes(String str) {
		int len = str.length();
		byte[] result = new byte[len];
		for (int i = 0; i < len; i++) {
			result[i] = (byte) str.charAt(i);
		}
		return result;
	}

	// 16进制字符串转成字节数组
	public static byte[] hexStringToBytes(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();//han-将字符串转换为字符数组
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789abcdef".indexOf(c);
		return b;
	}

	public static byte[] FloatToBytes(float f) {

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

	public static float BytesToFloat(byte[] b) {
		int l;
		l = b[0];
		l &= 0xff;
		l |= ((long) b[1] << 8);
		l &= 0xffff;
		l |= ((long) b[2] << 16);
		l &= 0xffffff;
		l |= ((long) b[3] << 24);
		return Float.intBitsToFloat(l);
	}

	// 问题函数 太大太小都有问题
	// // 低位在前16进制数组转成float 0xa4,0x70,0x45,0x41->12.34
	// public static float BytesToFloat(byte[] buf) {
	// // 拿到16进制
	// // StringBuffer hex = byte2hex(buf);
	// StringBuffer hex = bytesToHexString(buf);
	// // 高位在前转低位在前
	// hex = HhexToLhex(hex);
	// // 转成float
	// return Float.intBitsToFloat(Integer.valueOf(hex.toString(), 16));
	// }
	//
	// // 将float转成byte数组返回 12.34-> 0xa4 0x70 0x45 0x45
	// public static byte[] FloatToBytes(float f) {
	// byte[] b = new byte[4];
	// // f转成int
	// int bits = Float.floatToRawIntBits(f);
	// // int转二进制
	// String binary = Integer.toBinaryString(bits);
	// StringBuffer sBuffer = new StringBuffer(binary);
	// // 补0
	// sBuffer.insert(0, "0");
	// System.out.println("sbuffer" + sBuffer.toString());
	// StringBuffer hex = binaryStringTohexString(sBuffer);
	// // 16进制字符串 转数组
	// System.out.println("hex" + hex);
	// return hexStringToBytes(hex.toString());
	// }

	// byte数组转16进制字符串2
	public static StringBuffer bytesToHexString2(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb;
	}

	// byte数组转16进制字符串 EG:[0xa4 0x70 0x45] -> a47045 更高效
	public static StringBuffer bytesToHexString(byte[] buffer) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < buffer.length; i++) {
			String temp = Integer.toHexString(buffer[i] & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			sBuffer.append(temp + " ");
		}
		return sBuffer;
	}

	// 二进制转16进制 低位在前
	public static StringBuffer binaryStringTohexString(StringBuffer bString) {
		System.out.println("nihao");
		//
		if (bString == null || bString.equals("") || bString.length() % 8 != 0)
			return null;
		System.out.println("hello");
		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < bString.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		System.out.println("tmp********" + tmp.toString());
		return HhexToLhex(tmp.toString());
	}

	// 16进制转2进制
	public static String hexStringTobinaryString(String hexString) {
		if (hexString == null || hexString.length() % 2 != 0)
			return null;
		String bString = "", tmp;
		for (int i = 0; i < hexString.length(); i++) {
			tmp = "0000"
					+ Integer.toBinaryString(Integer.parseInt(
							hexString.substring(i, i + 1), 16));
			bString += tmp.substring(tmp.length() - 4);
		}
		return bString;
	}

	// 高位在前转成低位在前 16进制之间
	public static StringBuffer HhexToLhex(String bString) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = bString.length() - 2; i >= 0; i -= 2) {
			stringBuffer.append(bString.substring(i, i + 2));
		}
		return stringBuffer;
	}

	// byte数组转16进制字符串 EG:[0xa4 0x70 0x45] -> a47045 更高效
	public static StringBuffer bytesToHexStringCard(byte[] buffer) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < buffer.length; i++) {
			String temp = Integer.toHexString(buffer[i] & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			sBuffer.append(temp);
		}
		return sBuffer;
	}
}

package cn.com.start.DPF.util.socket;

import java.math.BigInteger;
import java.util.ArrayList;

public class ByteUtil {

	// 把vector里的数据按字符串显示
	public static StringBuffer listToHexString(ArrayList<Byte> byteList,
			int size) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			String temp = Integer.toHexString(byteList.get(i) & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			sBuffer.append(temp + " ");
		}
		return sBuffer;
	}

	public static byte[] subListBytes(ArrayList<Byte> src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src.get(i);
		return bs;
	}

	// byte加到list里面去
	public static void bytesAddToList(ArrayList<Byte> byteList, byte[] buf) {
		for (int i = 0; i < buf.length; i++) {
			byteList.add(buf[i]);
		}
	}

	// list的一部分变成byte
	public static byte[] listToBytes(ArrayList<Byte> byteList, int size) {
		byte[] buf = new byte[size];
		for (int i = 0; i < size; i++) {
			buf[i] = byteList.get(i);
		}
		delList(byteList, size);
		return buf;
	}

	public static void delList(ArrayList<Byte> byteList, int size) {
		for (int i = 0; i < size; i++) {
			byteList.remove(0);
		}
	}

	// 截取byte数组
	public static byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}

	/**
	 * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
	 */
	public static byte[] getBooleanArray(byte b) {
		byte[] array = new byte[8];
		for (int i = 7; i >= 0; i--) {
			array[i] = (byte) (b & 1);
			b = (byte) (b >> 1);
		}
		return array;
	}

	/**
	 * 把byte转为字符串的bit
	 */
	public static String byteToBit(byte b) {
		return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
				+ (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
				+ (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
				+ (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
	}

	// byte转二进制
	// Stirng c = Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);

	public static void main(String args[]) {
		//
		byte b = (byte) 0x81;
		long a = System.currentTimeMillis();
		String c = null;
		for (int i = 0; i < 10000; i++) {
			c = getBinaryStrFromByte2(b);
		}
		System.err.println("方法1" + (System.currentTimeMillis() - a));
		System.out.println(c);
		a = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			c = getBinaryStrFromByte(b);
		}
		System.err.println("方法2" + (System.currentTimeMillis() - a));
		System.out.println(c);
	}

	// 将一个byte转成8位bit字符串
	public static String getBinaryStrFromByte(byte b) {
		return Integer.toBinaryString((b & 0xFF) + 0x100).substring(1);
	}

	// 将一个byte转成8位bit
	public static String getBinaryStrFromByte2(byte b) {
		String result = "";
		byte a = b;
		;
		for (int i = 0; i < 8; i++) {
			byte c = a;
			a = (byte) (a >> 1);// 每移一位如同将10进制数除以2并去掉余数。
			a = (byte) (a << 1);
			if (a == c) {
				result = "0" + result;
			} else {
				result = "1" + result;
			}
			a = (byte) (a >> 1);
		}
		return result;
	}

	// 将long数值转换为8个字节的byte数组 低位在前
	public static byte[] longToByte(long number) {
		long temp = number;
		byte[] b = new byte[8];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}

	// 将long数值转换为8个字节的byte数组 低位在前
	public static long LbytestoLong(byte[] buf) {
		long temp = 0;
		for (int i = 0; i < buf.length; i++) {
			temp += ((long) buf[i] & 0xFF) << 8 * i;
		}
		return temp;
	}

	// 低位在前 高位在后 转int
	public static int LbytesToInt(byte[] buf) {
		int temp = 0;
		for (int i = 0; i < buf.length; i++) {
			temp += (buf[i] & 0xFF) << 8 * i;
		}
		return temp;
	}

	// 低位在前 高位在后
	public static int LbyteToInt(byte b) {
		return (b & 0xFF);
	}

	// 低位在前 高位在后转字符串 获取cpid
	public static BigInteger bytesToBigInteger(byte[] readBuffer) {
		if (readBuffer == null) {
			return new BigInteger("0");
		}
		// ｴｦﾀ昕ﾉﾎﾞｷ釚ﾅﾊ
		int length = readBuffer.length;
		byte[] uint64 = new byte[length + 1];
		uint64[length] = 0;
		System.arraycopy(readBuffer, 0, uint64, 0, length);
		return new BigInteger(reverse(uint64));
	}

	public static byte[] reverse(byte[] b) {
		byte[] temp = new byte[b.length];
		for (int i = 0; i < b.length; i++) {
			temp[i] = b[b.length - 1 - i];
		}
		return temp;
	}

	// ///////////////////////////////////////////////////////

	// 将一个1位byte[]数组拼接转换为整数
	public static int bytes1ToInt(byte[] b) {
		return b[0] & 0xFF;
	}

	// 将一个2位byte[]数组拼接转换为整数
	public static int bytes2ToInt(byte[] b) {
		int i = (b[0] & 0xFF) << 8;
		i += b[1] & 0xFF;
		return i;
	}

	// 将4位byte转为int 然后除10000
	public static float getTTFloat(byte[] buf) {
		float temp = HBytesToInt(buf);
		return temp / 10000;
	}

	public static byte[] getTTBytes(float value) {
		int b = (int) (value * 10000);
		byte[] buf = intToHBytes(b);
		return buf;
	}

	// 将4位byte转为int 然后除10000
	public static float getLTTFloat(byte[] buf) {
		float temp = LbytesToInt(buf);
		return temp / 10000;
	}

	public static byte[] getLTTBytes(float value) {
		int b = (int) (value * 10000);
		byte[] buf = intToLBytes(b);
		return buf;
	}

	// ///////////////////////////////////////////////////////

	// 将int数值转换为四个字节的byte数组 高位在前
	public static byte[] intToHBytes(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) ((value >> 24) & 0xFF);
		src[1] = (byte) ((value >> 16) & 0xFF);
		src[2] = (byte) ((value >> 8) & 0xFF);
		src[3] = (byte) (value & 0xFF);
		return src;
	}

	// 将int转换成四字节byte数组 低位在前
	public static byte[] intToLBytes(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) (value & 0xFF);
		src[1] = (byte) ((value >> 8) & 0xFF);
		src[2] = (byte) ((value >> 16) & 0xFF);
		src[3] = (byte) ((value >> 24) & 0xFF);
		return src;
	}

	// 将一个4位byte[]数组拼接转换为整数 高位在前
	public static int HBytesToInt(byte[] b) {
		int i = (b[0] & 0xFF) << 24;
		i += (b[1] & 0xFF) << 16;
		i += (b[2] & 0xFF) << 8;
		i += b[3] & 0xFF;
		return i;
	}

	// byte数组转字符串输出
	public static String byte2hex(byte[] buffer) {
		String h = "";
		for (int i = 0; i < buffer.length; i++) {
			String temp = Integer.toHexString(buffer[i] & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			h = h + " " + temp;
		}
		return h;
	}

}

package cn.com.start.webBack.util;

import java.io.IOException;

import cn.com.start.DPF.util.socket.ByteUtil;

public class test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String s = "0010";
		String a = "0010";
		if (a.equals(s)) {
			System.out.println("xixi");
		}
		byte[] buf = { 0x00, 0x09, 0x57, 0x0a };
		System.out.println(ByteUtil.getTTFloat(buf));
	}
}

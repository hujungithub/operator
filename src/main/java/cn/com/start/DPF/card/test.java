package cn.com.start.DPF.card;

import cn.com.start.DPF.util.socket.CreateByte;

public class test {
	public static void main(String args[]) {
		byte[] userid = CreateByte.intToTwoBytes(Integer.parseInt("25"));
		System.out.println(CreateByte.bytesToHexString(userid));
		
//		meepo 电狗 ta 炸弹
	}
}

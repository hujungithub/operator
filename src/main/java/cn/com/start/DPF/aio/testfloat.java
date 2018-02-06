package cn.com.start.DPF.aio;

import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class testfloat {

	
	public static void main(String args[]) {
		
		
		byte []a = {0x00, 0x00,0x1f,0x40 };
		System.out.println(ByteUtil.getTTFloat(a));
		
		byte []b = {0x00, 0x00, 0x1d, 0x4c};
		System.out.println(ByteUtil.getTTFloat(b));
		
		byte []c = {0x00, 0x00, 0x1a, (byte)0x90};
		System.out.println(ByteUtil.getTTFloat(c));
		
		byte[] d = {0x0d};
		System.out.println(ByteUtil.bytes1ToInt(d));
		
		int []g = new int[10];
	
		
		
	}
	
	 public static void bubbleSort(int[] numbers)
	    {
	        int temp = 0;
	        int size = numbers.length;
	        for(int i = 0 ; i < size-1; i ++)
	        {
	        for(int j = 0 ;j < size-1-i ; j++)
	        {
	            if(numbers[j] > numbers[j+1])  //交换两数位置
	            {
	            temp = numbers[j];
	            numbers[j] = numbers[j+1];
	            numbers[j+1] = temp;
	            }
	        }
	        }
	    }
	public static void testString(StringBuffer a) {
		a.delete(0, a.length());
		a.append("123");
	}

	public static void testsb() {
		StringBuffer sBuffer = new StringBuffer("1_2");
		String zString = sBuffer.toString().split("_")[0];
		String bString = sBuffer.toString().split("_")[1];
		System.out.println("sbuff=" + sBuffer + "zString=" + zString
				+ "bString=" + bString);
	}

	public static void testfloat() {
		byte[] a = ByteUtil.getTTBytes(578.3370f);
		System.out.println(CreateByte.bytesToHexString(a));
		float c = ByteUtil.getTTFloat(a);
		System.out.println(c);
	}
}

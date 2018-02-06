package cn.com.start.DPF.util;

public class StringUtil {

	public static void main(String args[]) {
		// getTime();
		System.out.println(overTurn("12343546456"));
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static String getValue(String value) {
		if (value.equals("") || value == null) {
			value = "0";
		}
		return value;
	}

	public static String overTurn(String value) {
		return new StringBuffer(value).reverse().toString();
	}

	public static String getTime(String time) {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(time.substring(0, 10));
		sBuffer.append("|");
		sBuffer.append(time.substring(11));
		return sBuffer.toString();
	}
}

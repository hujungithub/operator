package cn.com.start.DPF.util.socket;

public class ByteMerge {

	// 合并6个数组
	public static byte[] byteMerger6(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4, byte[] byte5, byte[] byte6) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
				+ byte4.length + byte5.length + byte6.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		System.arraycopy(byte5, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length, byte5.length);
		System.arraycopy(byte6, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length, byte6.length);
		return buf;
	}

	// 合并2个字符数组
	public static byte[] byteMerger2(byte[] byte1, byte[] byte2) {
		byte[] buf = new byte[byte1.length + byte2.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		return buf;
	}

	// 合并5个字符数组
	public static byte[] byteMerger5(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4, byte[] byte5) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
				+ byte4.length + byte5.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		System.arraycopy(byte5, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length, byte5.length);
		return buf;
	}

	// 合并4个字符数组
	public static byte[] byteMerger4(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
				+ byte4.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		return buf;
	}

	// 合并3个字符数组
	public static byte[] byteMerger3(byte[] byte1, byte[] byte2, byte[] byte3) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		return buf;
	}
	
	//合并7个字符数组
	public static byte[] byteMerger7(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4, byte[] byte5, byte[] byte6, byte[] byte7) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
				+ byte4.length + byte5.length + byte6.length + byte7.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		System.arraycopy(byte5, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length, byte5.length);
		System.arraycopy(byte6, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length, byte6.length);
		System.arraycopy(byte7, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length,
				byte7.length);
		return buf;
	}
	
	//合并8个字符数组
	public static byte[] byteMerger8(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4, byte[] byte5, byte[] byte6, byte[] byte7, byte[] byte8) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
				+ byte4.length + byte5.length + byte6.length + byte7.length
				+ byte8.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		System.arraycopy(byte5, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length, byte5.length);
		System.arraycopy(byte6, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length, byte6.length);
		System.arraycopy(byte7, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length,
				byte7.length);
		System.arraycopy(byte8, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length
				+ byte7.length, byte8.length);
		return buf;
	}
	
	//合并9个字符数组
	public static byte[] byteMerger9(byte[] byte1, byte[] byte2, byte[] byte3,
			byte[] byte4, byte[] byte5, byte[] byte6, byte[] byte7, byte[] byte8, byte[] byte9) {
		byte[] buf = new byte[byte1.length + byte2.length + byte3.length
		      				+ byte4.length + byte5.length + byte6.length + byte7.length
		    				+ byte8.length + byte9.length];
		System.arraycopy(byte1, 0, buf, 0, byte1.length);
		System.arraycopy(byte2, 0, buf, byte1.length, byte2.length);
		System.arraycopy(byte3, 0, buf, byte1.length + byte2.length,
				byte3.length);
		System.arraycopy(byte4, 0, buf, byte1.length + byte2.length
				+ byte3.length, byte4.length);
		System.arraycopy(byte5, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length, byte5.length);
		System.arraycopy(byte6, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length, byte6.length);
		System.arraycopy(byte7, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length,
				byte7.length);
		System.arraycopy(byte8, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length
				+ byte7.length, byte8.length);
		System.arraycopy(byte9, 0, buf, byte1.length + byte2.length
				+ byte3.length + byte4.length + byte5.length + byte6.length
				+ byte7.length + byte8.length, byte9.length);
		return buf;
	}
}

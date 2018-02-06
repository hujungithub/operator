package cn.com.start.AppAPI.util.wechat;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandUtil {

	public static void main(String[] args) {
		System.out.println(RandUtil.getRandomString(30));
		System.out.println(RandUtil.getTimeStart());
		System.out.println(RandUtil.getTimeExpire());
		System.out.println(RandUtil.getHostIp());
		System.out.println(RandUtil.getSeconds());
	}

	// 生成随机字符串
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	// 获取订单开始时间
	public static String getTimeStart() {
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat sFormat = new SimpleDateFormat();
		sFormat.applyPattern(pattern);
		// System.out.println(new Date());
		return sFormat.format(new Date());

	}

	// 获取订单失效时间(结束时间)
	public static String getTimeExpire() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 30);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = sdf.format(now.getTimeInMillis());
		// System.out.println(dateStr);
		return dateStr;
	}

	// 获取时间戳 秒
	public static long getSeconds() {
		return System.currentTimeMillis() / 1000;
	}

	// 获取IP
	public static String getHostIp() {
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
}

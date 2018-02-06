package cn.com.start.webBack.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StrToDate {
	
	
	public static String todate(String strdate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = 0;
		try {
			time = sdf.parse(strdate).getTime();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return time+"";
	}
	
	public static String strtodate(String maatime){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long now = Long.parseLong(maatime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		String format = formatter.format(calendar.getTime());
		return format;
	}
}

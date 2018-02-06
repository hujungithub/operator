package cn.com.start.AppAPI.util;

import java.util.ArrayList;
import java.util.List;

import cn.com.start.AppAPI.dto.ChargeStationDto;

public class test {
	public static void main(String[] args) {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
		// 设置日期格式
		// String currTime = df.format(new Date());// new Date()为获取当前系统时间
		// System.out.println(currTime);
		// System.out.println(currTime.substring(11, 16));
		// System.out.println(currTime.substring(11, 16).length());
		// PacketData.getOrderInfo();
		// TestObject();
		String a = "0.0";
		System.out.println(Integer.parseInt(a));
	}

	public static void TestObject() {
		ChargeStationDto sssDto = null;
		if (sssDto == null) {
			System.out.println("gggggggggggg");
		} else {
			System.out.println("hhhhhhhhhhh");
		}

		List<ChargeStationDto> chargeStationDto = new ArrayList<ChargeStationDto>();
		chargeStationDto.add(sssDto);
		if (chargeStationDto.isEmpty()) {
			System.out.println("aaaaaaaaaa");
		} else {
			System.out.println("bbbbbbbbbb");
		}

	}
}

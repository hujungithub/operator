//package cn.com.start.DPF.aio;
//
//import java.util.concurrent.ConcurrentHashMap;
//
//import cn.com.start.DPF.util.socket.ByteMerge;
//
//public class tespjava {
//	
//	// 全遥测黏包map cpid是key
//	public static ConcurrentHashMap<String, byte[]> sychroSubYCByteMap = new ConcurrentHashMap<>();
//	// 全遥测黏包标志位 cpid是key
//	public static ConcurrentHashMap<String, Integer> sychroSubYCFlagMap = new ConcurrentHashMap<>();
//	// 充电记录黏包数组
//	public static ConcurrentHashMap<String, byte[]> sychroSubCRByteMap = new ConcurrentHashMap<>();
//	// 充电记录黏包标志位 cpid是key
//	public static ConcurrentHashMap<String, Integer> sychroSubCRFlagMap = new ConcurrentHashMap<>();
//	// 鉴权报文黏包数组
//	public static ConcurrentHashMap<String, byte[]> sychroSubACByteMap = new ConcurrentHashMap<>();
//	// 充电记录黏包标志位 cpid是key
//	public static ConcurrentHashMap<String, Integer> sychroSubACFlagMap = new ConcurrentHashMap<>();
//	if (DataForward.sychroSubYCFlagMap.get(String.valueOf(map.get("CPID"))) != null
//			&& DataForward.sychroSubYCFlagMap.get(String.valueOf(map
//					.get("CPID"))) == 1) {
//		// 黏包标志位 需要合并报文
//		buf = ByteMerge.byteMerger2(
//				DataForward.sychroSubYCByteMap.get(map.get("CPID")), buf);
//		// 继续做判断 改变黏包标志位
//		DataForward.sychroSubYCFlagMap.put(String.valueOf(map.get("CPID")),
//				0);
//	} else if (DataForward.sychroSubCRFlagMap.get(String.valueOf(map
//			.get("CPID"))) != null
//			&& DataForward.sychroSubCRFlagMap.get(String.valueOf(map
//					.get("CPID"))) == 1) {
//		// 黏包标志位 需要合并报文
//		buf = ByteMerge.byteMerger2(
//				DataForward.sychroSubCRByteMap.get(map.get("CPID")), buf);
//		// 继续做判断 改变黏包标志位
//		DataForward.sychroSubCRFlagMap.put(String.valueOf(map.get("CPID")),
//				0);
//	} else if (DataForward.sychroSubACFlagMap.get(String.valueOf(map
//			.get("CPID"))) != null
//			&& DataForward.sychroSubACFlagMap.get(String.valueOf(map
//					.get("CPID"))) == 1) {
//		// 黏包标志位 需要合并报文
//		buf = ByteMerge.byteMerger2(
//				DataForward.sychroSubACByteMap.get(map.get("CPID")), buf);
//		// 继续做判断 改变黏包标志位
//		DataForward.sychroSubACFlagMap.put(String.valueOf(map.get("CPID")),
//				0);
//	}
//	if ((0xFF & buf[7]) == 132 && (0xFF & buf[9]) == 20) {
//		// 遥测黏包
//		logger.info("@@@@@@@@@@@@@@@@@@@@@");
//		DataForward.sychroSubYCByteMap.put(
//				String.valueOf(map.get("CPID")), buf);
//		DataForward.sychroSubYCFlagMap.put(
//				String.valueOf(map.get("CPID")), 1);
//	} else if ((0xFF & buf[7]) == 130 && (0xFF & buf[9]) == 6
//			&& (0xFF & buf[16]) == 2) {
//		logger.info("#######################");
//		DataForward.sychroSubCRByteMap.put(
//				String.valueOf(map.get("CPID")), buf);
//		DataForward.sychroSubCRFlagMap.put(
//				String.valueOf(map.get("CPID")), 1);
//	} else if ((0xFF & buf[7]) == 130 && (0xFF & buf[9]) == 6
//			&& (0xFF & buf[16]) == 1) {
//		logger.info("#######################");
//		DataForward.sychroSubACByteMap.put(
//				String.valueOf(map.get("CPID")), buf);
//		DataForward.sychroSubACFlagMap.put(
//				String.valueOf(map.get("CPID")), 1);
//	}
// }

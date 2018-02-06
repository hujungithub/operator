package cn.com.start.AppAPI.util.wechat;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import cn.com.start.AppAPI.util.Constant;

public class PacketData {

	public static void main(String[] args) {
		// for (int i = 0; i < 1; i++) {
		// Map map = PacketData.getOrderInfo();
		// }

		// Set<String> key = map.keySet();
		// for (Iterator<String> it = key.iterator(); it.hasNext();) {
		// String s = it.next();
		// System.out.println(s + ":555" + map.get(s));//
		// 这里的s就是map中的key，map.get(s)就是key对应的value。
		// }
	}

	/**
	 * 订单ID和支付金额
	 * 
	 * @param orderId
	 * @param totalFee
	 * @return
	 */
	// Map<String, String>
	public static SortedMap<String, String> getPreyId(String orderId,
			String totalFee) {
		// Map<String, String> reqMap = new HashMap<String, String>();
		SortedMap<String, String> reqMap = new TreeMap<String, String>();
		reqMap.put("appid", StaticUtil.appid);
		reqMap.put("mch_id", StaticUtil.mch_id);
		reqMap.put("nonce_str", RandUtil.getRandomString(20));       
		reqMap.put("body", StaticUtil.COMPANY_NAME);
		reqMap.put("detail", "first test"); // 非必填
		reqMap.put("attach", "no"); // 非必填
		reqMap.put("out_trade_no", orderId); // 商户系统内部的订单号,
		int money = Integer.valueOf(totalFee)*100;
		reqMap.put("total_fee", String.valueOf(money)); // 订单总金额，单位为分
		reqMap.put("spbill_create_ip", RandUtil.getHostIp()); // 用户端实际ip
		reqMap.put("time_start", RandUtil.getTimeStart()); // 交易起始时间 非必填
		reqMap.put("time_expire", RandUtil.getTimeExpire()); // 交易结束时间 非必填
		// reqMap.put("goods_tag", "172.16.40.18"); //商品标记 非必填
		// reqMap.put("notify_url", StaticUtil.notify_url); // 通知地址
		reqMap.put("notify_url", Constant.TENCENT_NOTIFY_URL); // 通知地址
		reqMap.put("trade_type", "APP"); // 交易类型
		String sign = PayCommonUtil.createSign("utf-8", reqMap);
		reqMap.put("sign", sign);
		System.out.println("签名1" + sign);
		return reqMap;
	}

	// 传orderId和费用 发送处理 返回APP
	public static Map getOrderInfo(String totalFee, String orderId) {
		// 获取orderId和totalFee按照算法生成sign 返回处理过后的序列
		// String orderId = RandUtil.getRandomString(12);
		// 拿到要发送的所有数据
		SortedMap<String, String> reqMap = PacketData.getPreyId(orderId,
				totalFee);
		// 将map数据转换为xml
		String reqString = PayCommonUtil.getRequestXml(reqMap);
		System.out.println("发送xml字符串" + reqString);
		// 发送xml数据接受返回结果 xml
		String retString = PayCommonUtil.httpPostData(reqString);
		System.out.println("返回xml字符串" + retString);
		// 将拿到的xml字符串解析 拿到preId
		Map map = PayCommonUtil.parserSmsXml(retString);
		Set<String> key = map.keySet();
		for (Iterator<String> it = key.iterator(); it.hasNext();) {
			String s = it.next();
			System.out.println(s + ":" + map.get(s));// 这里的s就是map中的key，map.get(s)就是key对应的value。
		}
		SortedMap zzMap = new TreeMap<String, String>();
		zzMap.put("appid", map.get("appid"));
		zzMap.put("partnerid", map.get("mch_id"));
		zzMap.put("prepayid", map.get("prepay_id"));
		zzMap.put("package", "Sign=WXPay");
		zzMap.put("noncestr", map.get("nonce_str"));
		zzMap.put("timestamp", RandUtil.getSeconds());
		// zzMap.put("notify_url", map.get(NOTIFY_URL));
		String sign = PayCommonUtil.createSign("utf-8", zzMap);
		zzMap.put("sign", sign);

		System.out.println("签名2" + sign);

		return zzMap;
	}
}

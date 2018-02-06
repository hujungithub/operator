package cn.com.start.AppAPI.util.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class PayCommonUtil {

	// 定义签名，微信根据参数字段的ASCII码值进行排序 加密签名,故使用SortMap进行参数排序
	public static String createSign(String characterEncoding,
			SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + StaticUtil.key);
		System.out.println("未生成之前的数据 " + sb.toString());
		// 最后加密时添加商户密钥，由于key值放在最后，所以不用添加到SortMap里面去，单独处理，编码方式采用UTF-8
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
				.toUpperCase();
		return sign;
	}

	//
	// // 得到签名值
	// public static String getSign(Map<String, String> map) {
	// String[] keys = map.keySet().toArray(new String[0]);
	// Arrays.sort(keys);
	// StringBuffer reqStr = new StringBuffer();
	// for (String key : keys) {
	// String v = map.get(key);
	// if (v != null && !v.equals("")) {
	// reqStr.append(key).append("=").append(v).append("&");
	// }
	// }
	// reqStr.append("key").append("=").append(staticUtil.key);
	// // MD5加密
	// return MD5Util.MD5Encode(reqStr.toString(), characterEncoding)
	// .toUpperCase();
	// }

	// 将封装好的参数转换成Xml格式类型的字符串
	public static String getRequestXml(SortedMap<String, String> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ("sign".equalsIgnoreCase(k)) {

			} else if ("attach".equalsIgnoreCase(k)
					|| "body".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}
		}
		sb.append("<" + "sign" + ">" + "<![CDATA[" + parameters.get("sign")
				+ "]]></" + "sign" + ">");
		sb.append("</xml>");
		return sb.toString();
	}

	public static Map parserSmsXml(String sms) {
		Map map = new HashMap();
		try {
			Document document = DocumentHelper.parseText(sms);
			Element root = document.getRootElement();
			for (Iterator i = root.elementIterator(); i.hasNext();) {
				Element node = (Element) i.next();
				map.put(node.getName(), node.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return map;
	}

	// 发送xml数据 返回结果
	public static String httpPostData(String data) {
		StringBuffer sbBuffer = new StringBuffer();
		try {
			String urlStr = "https://api.mch.weixin.qq.com/pay/unifiedorder";
			URL url = new URL(urlStr);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			con.setRequestProperty("Pragma", "no-cache");
			con.setRequestProperty("Cache-Control", "no-cache");
			con.setRequestProperty("Content-Type", "text/xml");

			OutputStreamWriter out = new OutputStreamWriter(
					con.getOutputStream());
			// System.out.println("urlStr=" + urlStr);
			// System.out.println("xmlInfo=" + xmlInfo);
			out.write(new String(data.getBytes("UTF-8")));
			out.flush();
			out.close();
			String line = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			for (line = br.readLine(); line != null; line = br.readLine()) {
				sbBuffer.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sbBuffer.toString();
	}
	/**
	 * 发起https请求并返回结果
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	// public static String httpRequest(String requestUrl, String requestMethod,
	// String outputStr) {
	// // JSONObject jsonObject = null;
	// StringBuffer buffer = new StringBuffer();
	// try {
	// // 创建SSLContext对象，并使用我们指定的信任管理器初始化
	// TrustManager[] tm = { new MyX509TrustManager() };
	// SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	// sslContext.init(null, tm, new java.security.SecureRandom());
	// // 从上述SSLContext对象中得到SSLSocketFactory对象
	// SSLSocketFactory ssf = sslContext.getSocketFactory();
	//
	// URL url = new URL(requestUrl);
	// HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
	// .openConnection();
	// httpUrlConn.setSSLSocketFactory(ssf);
	//
	// httpUrlConn.setDoOutput(true);
	// httpUrlConn.setDoInput(true);
	// httpUrlConn.setUseCaches(false);
	// // 设置请求方式（GET/POST）
	// httpUrlConn.setRequestMethod(requestMethod);
	//
	// if ("GET".equalsIgnoreCase(requestMethod))
	// httpUrlConn.connect();
	//
	// // 当有数据需要提交时
	// if (null != outputStr) {
	// OutputStream outputStream = httpUrlConn.getOutputStream();
	// // 注意编码格式，防止中文乱码
	// outputStream.write(outputStr.getBytes("UTF-8"));
	// outputStream.close();
	// }
	//
	// // 将返回的输入流转换成字符串
	// InputStream inputStream = httpUrlConn.getInputStream();
	// InputStreamReader inputStreamReader = new InputStreamReader(
	// inputStream, "utf-8");
	// BufferedReader bufferedReader = new BufferedReader(
	// inputStreamReader);
	//
	// String str = null;
	// while ((str = bufferedReader.readLine()) != null) {
	// buffer.append(str);
	// }
	// bufferedReader.close();
	// inputStreamReader.close();
	// // 释放资源
	// inputStream.close();
	// inputStream = null;
	// httpUrlConn.disconnect();
	// jsonObject = JSONObject.fromObject(buffer.toString());
	// } catch (ConnectException ce) {
	// log.error("Weixin server connection timed out.");
	// } catch (Exception e) {
	// log.error("https request error:{}", e);
	// }
	// return jsonObject;
	// }
}

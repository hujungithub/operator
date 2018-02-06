package cn.com.start.DPF.aio;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import cn.com.start.DPF.dto.ChargeOver_DPF;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;
import cn.com.start.DPF.entity.carddata.CardShortMessage;

public class NoticeWeb {

	private static Logger logger = LogManager.getLogger("LOG_DPF");

	public static void noticeCard(CardShortMessage cardShortMessage)
			throws IOException {
		String url = "http://139.129.194.195:8080/SuperBackManage/scanCharge/notifyUserCard";
		HttpClient client = new DefaultHttpClient();
		// 创建httppost通过post方式访问
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列
		// ChargeOver_DPF cOver_DPF = new ChargeOver_DPF();
		// cOver_DPF.setStatus("finish");
		// 将数组对象转换为json数组
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cardShortMessage);
		logger.info("dddddddddddddddd" + json.toString());
		// 作为参数发送到controller
		StringEntity entity = new StringEntity(json.toString(), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);
		HttpResponse response = client.execute(httppost);
	}

	public static void noticeUnException() throws IOException {

		String url = "http://139.129.194.195:8080/SuperBackManage/scanCharge/unException";
		logger.info("((((((((((((((((((((((((((((((");
		logger.info("((((((((((((((((((((((((((((((");
		logger.info("((((((((((((((((((((((((((((((");
		logger.info("((((((((((((((((((((((((((((((");
		HttpClient client = new DefaultHttpClient();
		// 创建httppost通过post方式访问
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列
		ChargeOver_DPF cOver_DPF = new ChargeOver_DPF();
		cOver_DPF.setStatus("finish");
		// 将数组对象转换为json数组
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cOver_DPF);

		logger.info("dddddddddddddddd" + json.toString());
		// 作为参数发送到controller
		StringEntity entity = new StringEntity(json.toString(), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);
		HttpResponse response = client.execute(httppost);
	}

	public static void noticeChargeOver(UserDeductMoneyRecord udf)
			throws IOException {
		// String url =
		String url = "http://139.129.194.195:8080/SuperBackManage/scanCharge/chargeOver";
		// 路径一定要对否则通不过
		// String url =
		// "http://192.168.8.132:8080/SuperBackManage/test/testSend";//
		// 路径一定要对否则通不过
		// 创建默认的httpClient实例.

		logger.info("aaaaaaaaaaaaaaaaaa");
		HttpClient client = new DefaultHttpClient();
		// 创建httppost通过post方式访问
		HttpPost httppost = new HttpPost(url);
		// 创建参数队列
		ChargeOver_DPF cOver_DPF = new ChargeOver_DPF();
		cOver_DPF.setDeviceId(udf.getDEVICEID());
		cOver_DPF.setGun(udf.getINTERFACEID());
		cOver_DPF.setSerialNo(udf.getTRANSATIONID());
		cOver_DPF.setCpuserid(String.valueOf(udf.getCPUSERID()));
		cOver_DPF.setCardNum(String.valueOf(udf.getPHYSICALCARDNUM()));
		cOver_DPF.setChargemethod(udf.getCHARGEMETHOD());
		cOver_DPF.setStatus("success");
		// 将数组对象转换为json数组
		logger.info("bbbbbbbbbbbbbbbbbbb");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(cOver_DPF);
		logger.info("ccccccccccccccccccccccccc");
		logger.info("dddddddddddddddd" + json.toString());
		// 作为参数发送到controller
		StringEntity entity = new StringEntity(json.toString(), "utf-8");
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		httppost.setEntity(entity);
		HttpResponse response = client.execute(httppost);
	}

	public static void main(String args[]) throws ClientProtocolException,
			IOException {
		UserDeductMoneyRecord udfRecord = new UserDeductMoneyRecord();
		udfRecord.setDEVICEID("0701004002001011");
		udfRecord.setINTERFACEID(1);
		udfRecord.setTRANSATIONID("2353454564553235434");
		NoticeWeb.noticeChargeOver(udfRecord);
	}

}

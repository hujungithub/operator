package cn.com.start.AppAPI.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.AppAPI.dto.CpuserInfoDto;
import cn.com.start.AppAPI.dto.JsonObjectReDto;
import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.AppAPI.dto.WechatResultDto;
import cn.com.start.AppAPI.service.UserManagerService;
import cn.com.start.AppAPI.util.Constant;
import cn.com.start.AppAPI.util.alipay.OrderInfoUtil2_0;
import cn.com.start.AppAPI.util.wechat.PacketData;
import cn.com.start.AppAPI.util.wechat.PayCommonUtil;

/**
 * @author caijie
 * 
 */
@Controller
@RequestMapping("/wechatPay")
public class WeChatPayController {
	private static Logger logger = LogManager.getLogger("LOG_API");
	/**
	 * 支付宝支付业务：入参app_id
	 */
	public static final String APPID = "2016120904050628";

	/**
	 * 支付宝账户登录授权业务：入参pid值
	 */
	public static final String PID = "2088521410223811";
	/**
	 * 支付宝账户登录授权业务：入参target_id值
	 */
	public static final String TARGET_ID = "tengenshanxi@126.com";

	/**
	 * 商户私钥，pkcs8格式
	 */
	public static final String RSA_PRIVATE_PKCS8 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKO6JzZwrDtUBjXH\n"
			+ "bKzqL7j/m1fjvnVjiEmb6YM8Hx2hwRb2ToKopycgTsN9QjZzdOge7SfJHEpa6Rgn\n"
			+ "nq+Jja8U8ZxVcsPd/wtgttoIHQRCjPaLj8mX7TgX2t/Gq4GoXDhnc8pSQEaiTFUj\n"
			+ "ufPwun4rs8FT7ymZAz56ZjT1HgitAgMBAAECgYB/EMPJ/lvMl4NSTXlMIVv0KXu4\n"
			+ "FCoGFL760aPCk/BaIOUoGvQHdzhypyI5mYa/l49NbmMDk5L/KdrpQiZneUuZLW1h\n"
			+ "EbKzdvdY3Ca83oflFmeQYRlgrrXICz3p4y5wsJAdgRSlQ4O91e+75eglDrr/LTMo\n"
			+ "MRdtv9Vd/0b+DqCNiQJBANc1ZQqbDz1e0B6FSq0lomqwsMj62ajg7PpRZ/qoSwCc\n"
			+ "F34Ux4DFT9Uh3QPimRu+cndlo59++JECOVi5vNZuWTMCQQDCwrdnFxknGX4sPZ1N\n"
			+ "Eh7hMFLNiQovyHY8I6PcwvCZB3/Xoh9Qy7huaZtb2N6330GRpQhpvKwWWmakXIt/\n"
			+ "7NafAkB/F4JPTBko5ghELfVW4aXUGfqdBj9qU0K/5TlhtudsOcJJ7B2Rd3TY6kGq\n"
			+ "nLRMxSC2UCjb9VD32fdh5XaWr94vAkBvlv1adeOVgYfHdW4hcJZ81CE9Xp2Vjzgf\n"
			+ "cRQ8Mv2D0MYxGNT0iCUeLigz0eiaVbLN7k8Jtm6rSBSza8sJ+vtlAkEAt4NauXR2\n"
			+ "Tbd3mboLtAJRYGwH5L1JATMp4k8zuc4iiHPw71PJHngUFqZHIcvxtj4hw9kI+ovn\n"
			+ "RLDD9wk23KcXHA==";

	public static final String RSA_PRIVATE = "MIICXAIBAAKBgQCjuic2cKw7VAY1x2ys6i+4/5tX4751Y4hJm+mDPB8docEW9k6C\n"
			+ "qKcnIE7DfUI2c3ToHu0nyRxKWukYJ56viY2vFPGcVXLD3f8LYLbaCB0EQoz2i4/J\n"
			+ "l+04F9rfxquBqFw4Z3PKUkBGokxVI7nz8Lp+K7PBU+8pmQM+emY09R4IrQIDAQAB\n"
			+ "AoGAfxDDyf5bzJeDUk15TCFb9Cl7uBQqBhS++tGjwpPwWiDlKBr0B3c4cqciOZmG\n"
			+ "v5ePTW5jA5OS/yna6UImZ3lLmS1tYRGys3b3WNwmvN6H5RZnkGEZYK61yAs96eMu\n"
			+ "cLCQHYEUpUODvdXvu+XoJQ66/y0zKDEXbb/VXf9G/g6gjYkCQQDXNWUKmw89XtAe\n"
			+ "hUqtJaJqsLDI+tmo4Oz6UWf6qEsAnBd+FMeAxU/VId0D4pkbvnJ3ZaOffviRAjlY\n"
			+ "ubzWblkzAkEAwsK3ZxcZJxl+LD2dTRIe4TBSzYkKL8h2PCOj3MLwmQd/16IfUMu4\n"
			+ "bmmbW9jet99BkaUIabysFlpmpFyLf+zWnwJAfxeCT0wZKOYIRC31VuGl1Bn6nQY/\n"
			+ "alNCv+U5YbbnbDnCSewdkXd02OpBqpy0TMUgtlAo2/VQ99n3YeV2lq/eLwJAb5b9\n"
			+ "WnXjlYGHx3VuIXCWfNQhPV6dlY84H3EUPDL9g9DGMRjU9IglHi4oM9HomlWyze5P\n"
			+ "CbZuq0gUs2vLCfr7ZQJBALeDWrl0dk23d5m6C7QCUWBsB+S9SQEzKeJPM7nOIohz\n"
			+ "8O9TyR54FBamRyHL8bY+IcPZCPqL50Sww/cJNtynFxw=";

	public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjuic2cKw7VAY1x2ys6i+4/5tX\n"
			+ "4751Y4hJm+mDPB8docEW9k6CqKcnIE7DfUI2c3ToHu0nyRxKWukYJ56viY2vFPGc\n"
			+ "VXLD3f8LYLbaCB0EQoz2i4/Jl+04F9rfxquBqFw4Z3PKUkBGokxVI7nz8Lp+K7PB\n"
			+ "U+8pmQM+emY09R4IrQIDAQAB";

	@Autowired
	private UserManagerService userManager;

	// 统一下单接口
	@RequestMapping("/unifiedOrder")
	public void getCPInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String payMoney = request.getParameter("payMoney");
		String userId = request.getParameter("userId");
		if (payMoney == null || userId == null) {
			ReDto.returnCode = Constant.PARAM_ERROR;
			ReDto.message = Constant.PARAM_ERROR_STRING;
			this.send(response, ReDto);
			return;
		}
		String orderId = createOutTradeNo(userId);
		logger.info("orderId:" + orderId);
		if (payMoney != null && !payMoney.isEmpty()) {
			Map map = new HashMap<String, String>();
			map = PacketData.getOrderInfo(payMoney, orderId);
			logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!" + map.toString());
			List orderInfoList = new ArrayList<Map>();
			orderInfoList.add(map);
			ReDto.returnCode = 0;
			ReDto.detail.put("order", orderInfoList);

			// 用户余额
			List<CpuserInfoDto> info = userManager.loadProfile(userId);
			String remainMoney = "";
			if (info != null && info.size() > 0) {
				remainMoney = info.get(0).accountSum;
			}

			insertPayRecorder(userId, payMoney, orderId, "1", remainMoney);

		} else {
			ReDto.returnCode = 1;
			ReDto.message = "金额为空";
		}

		this.send(response, ReDto);
	}

	// 插入充值记录
	private void insertPayRecorder(String userId, String payMoney,
			String orderId, String payMode, String remainMoney) {
		WechatResultDto dto = new WechatResultDto();
		dto.cpUserId = userId;
		dto.rechargeMoney = payMoney;
		dto.rechargeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(System.currentTimeMillis()));
		dto.transactionNum = "";
		dto.merchantNum = orderId;
		dto.paymentModeId = payMode;
		dto.payResultFlag = "1";
		dto.failDesp = "未支付";
		dto.preAccountSum = remainMoney;
		userManager.insertWechatPay(dto);
	}

	@RequestMapping("/alipayUnifiedOrder")
	public void alipayUnifiedOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JsonObjectReDto ReDto = new JsonObjectReDto();
		String payMoney = request.getParameter("payMoney");
		String userId = request.getParameter("userId");
		if (payMoney == null || userId == null) {
			ReDto.returnCode = Constant.PARAM_ERROR;
			ReDto.message = Constant.PARAM_ERROR_STRING;
			this.send(response, ReDto);
			return;
		}

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(System.currentTimeMillis()));
		String tradeNo = createOutTradeNo(userId);
		Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID,
				payMoney, tradeNo, timeStamp);
		String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

		String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE_PKCS8);
		final String orderInfo = orderParam + "&" + sign;

		// 用户余额
		List<CpuserInfoDto> info = userManager.loadProfile(userId);
		String remainMoney = "0";
		if (info != null && info.size() > 0) {
			remainMoney = info.get(0).accountSum;
		}
		insertPayRecorder(userId, payMoney, tradeNo, "0", remainMoney);

		ReDto.returnCode = 0;
		ReDto.message = "成功";
		ReDto.orderInfo = orderInfo;
		this.send(response, ReDto);
	}

	@RequestMapping("/wechatResult")
	public void wechatResult(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		StringBuilder sb = new StringBuilder();
		InputStream is = request.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] buffer = new byte[1024];
		int read = 0;
		while ((read = bis.read(buffer)) != -1) {
			sb.append(new String(buffer, 0, read, "UTF-8"));
		}

		Map map = PayCommonUtil.parserSmsXml(sb.toString());
		if ("SUCCESS".equals(map.get("return_code"))) {
			if ("SUCCESS".equals(map.get("result_code"))) {
				updatePayrecorder(map);
				logger.info("交易成功");
			} else {
				// 写表
				WechatResultDto dto = new WechatResultDto();
				Double fee = Double.valueOf((String) map.get("total_fee"));
				fee /= 100;
				dto.rechargeMoney = String.valueOf(fee);
				dto.rechargeTime = (String) map.get("time_end");
				dto.merchantNum = (String) map.get("out_trade_no");
				dto.transactionNum = (String) map.get("transaction_id");
				dto.paymentModeId = "1";
				dto.payResultFlag = "1";
				dto.failDesp = (String) map.get("err_code");
				userManager.wechatResult(dto);
				logger.info("交易失败:" + dto.failDesp);
			}

		} else {
			logger.info("网络异常,通讯失败:" + map.get("return_msg"));

		}

	}

	// 充值成功 修改余额
	private void updatePayrecorder(Map map) {
		String status = userManager.getPayStatus((String) map
				.get("out_trade_no"));
		if (!"交易成功".equals(status)) {
			logger.info("ready to write 交易成功");
			WechatResultDto dto = new WechatResultDto();
			Double fee = Double.valueOf((String) map.get("total_fee"));
			fee /= 100;
			dto.rechargeMoney = String.valueOf(fee);
			dto.rechargeTime = (String) map.get("time_end");
			dto.merchantNum = (String) map.get("out_trade_no");
			dto.transactionNum = (String) map.get("transaction_id");
			dto.paymentModeId = "1";
			dto.payResultFlag = "0";
			dto.failDesp = "交易成功";
			userManager.wechatResult(dto);
		}
	}

	@RequestMapping("/alipayResult")
	public void alipayResult(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String outTradeNo = request.getParameter("out_trade_no");
		String tradeNo = request.getParameter("trade_no");
		String code = request.getParameter("trade_status");
		String fee = request.getParameter("receipt_amount");

		logger.info("outTradeNo:" + outTradeNo + ",code:" + code
				+ ",tradeNo:" + tradeNo);

		if ("TRADE_SUCCESS".equals(code)) {
			String status = userManager.getPayStatus(outTradeNo);
			if (!"交易成功".equals(status)) {
				WechatResultDto dto = new WechatResultDto();

				dto.rechargeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date(System.currentTimeMillis()));
				dto.rechargeMoney = fee;
				dto.merchantNum = outTradeNo;
				dto.transactionNum = tradeNo;
				dto.paymentModeId = "0";
				dto.payResultFlag = "0";
				dto.failDesp = "交易成功";
				userManager.wechatResult(dto);

				logger.info("支付宝,交易成功");
			}

		} else {
			WechatResultDto dto = new WechatResultDto();
			dto.rechargeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date(System.currentTimeMillis()));
			dto.paymentModeId = "0";
			dto.payResultFlag = "1";
			dto.failDesp = "支付失败";

			userManager.wechatResult(dto);

			logger.info("支付宝,交易失败");
		}

	}

	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}

	private String createOutTradeNo(String userId) {
		if (userId.length() <= 8)
			return "";

		String phone = userId.substring(0, userId.length() - 8);
		Date curTime = new Date(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		sb.append(phone);
		SimpleDateFormat yearSf = new SimpleDateFormat("yyyy-MM-dd");
		String[] year = yearSf.format(curTime).split("-");
		for (int i = 0; i < year.length; i++) {
			sb.append(year[i]);
		}

		SimpleDateFormat ms = new SimpleDateFormat("HH:mm:ss");
		String[] hour = ms.format(curTime).split(":");
		for (int i = 0; i < hour.length; i++) {
			sb.append(hour[i]);
		}

		return sb.toString();
	}

}

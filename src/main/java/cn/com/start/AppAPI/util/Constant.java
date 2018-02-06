package cn.com.start.AppAPI.util;

public class Constant {
	public final static String ALI_NOTIFY_URL = "http://139.129.194.195:8080/SuperBackManage/wechatPay/alipayResult";
	public final static String TENCENT_NOTIFY_URL = "http://139.129.194.195:8080/SuperBackManage/wechatPay/wechatResult";
	public final static String UPLOAD_PATH = "D:/chandao/xampp/htdocs";
//	public final static String UPDATE_VERSION_URL = "http://www.huiqu.co/public/download/apk/huiqu.apk";
	public final static String UPDATE_VERSION_URL = "http://www.huiqu.co/public/download/apk/huiqu.apk";




	public static int RESULT_OK = 0;
	public static int OTHER_ERROR = 1;
	public static int PARAM_ERROR = 2;
	public static int PILE_IS_CHARGING = 3;
	public static int NO_FOUND_GUN = 4;
	public static int WAIT_AUTHORIZATION = 5;
	public static int START_ERROR_MSG = 7;
	public static int PILE_OFFLINE_STATE = 6;
	public static int REMAIN_ERROR = 9;//余额不足
	public static int CHARGE_PILE_ERROR = 11;

	public static String PARAM_ERROR_STRING = "参数错误";
	public static String NO_DATA_STRING = "没有数据";
	public static String NO_FOUND_GUN_MESSAGE = "没有插枪";
	public static String WAIT_AUTHORIZATION_MESSAGE = "没有授权";
	public static String UPDATE_VERSION_MESSAGE = "已是最新版本";
	public static String CHARGE_PILE_ERROR_MESSAGE = "充电桩故障";

	// Redis服务器IP
	public final static String ADDR_ARRAY = "127.0.0.1";
	// public final static String ADDR_ARRAY = "192.168.8.132";
	// public final static String ADDR_ARRAY = "192.168.8.211";
	// Redis的端口号
	public final static int PORT = 6379;

	public final static String ALIDAYU_URL = "http://gw.api.taobao.com/router/rest";
	public final static String ALIDAYU_APPKEY = "23561085";
	public final static String ALIDAYU_SECRET = "1fd5d541fdb499021adaba90c273b035";

//	public final static String ALIDAYU_SIGN = "山西尚宽电气集团";
	public final static String ALIDAYU_SIGN = "尚宽电气";
	public final static String ALIDAYU_SMS_MODEL = "SMS_33585202";
//	public final static String ALIDAYU_SMS_CHARGEOVER = "SMS_36065166";
	public final static String ALIDAYU_SMS_CHARGEOVER = "SMS_41485328";
	public final static String ALIDAYU_SMS_CARD = "SMS_38410046";
	

}

package cn.com.start.DPF.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigInfo {

	private String portNo; // 端口号
	private String driver; // 数据库驱动
	private String jdbcUrl; // jdbc路径
	private String user; // 数据库用户
	private String password; // 数据库密码

	// 在创建类时调用自定义构造函数，取值
	private static final ConfigInfo C_INFO = new ConfigInfo();

	// private static Logger logger = LogManager.getLogger("ConfigInfo");
	/**
	 * 将构造函数限定为private 外部不可实例化对象 构造对象的时候取出数据 存在对象中
	 */
	private ConfigInfo() {
		Properties prop = new Properties();
		InputStream in = Object.class.getResourceAsStream("/data.properties");
		// try {
		// prop.load(in);
		// this.setPortNo(prop.getProperty("portNo").trim());
		// this.setDriver(prop.getProperty("driver").trim());
		// this.setJdbcUrl(prop.getProperty("jdbcUrl").trim());
		// this.setUser(prop.getProperty("user").trim());
		// this.setPassword(prop.getProperty("password").trim());
		// } catch (IOException e) {
		// logger.info("数据库连接读取配置文件失败】");
		// logger.error(e);
		// }
	}

	/**
	 * 外部类获取对象出口
	 * 
	 * @return
	 */
	public static ConfigInfo getInstance() {
		return C_INFO;
	}

	/**
	 * 变量get,set方法
	 * 
	 * @return
	 */
	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

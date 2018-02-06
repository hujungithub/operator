package cn.com.start.DPF.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCommonUtil {

	private static String driver; // 驱动
	private static String jdbcUrl; // 数据库连接地址
	private static String user; // 数据库用户名
	private static String password; // 数据库密码
	private static Connection conn = null;

	// private static Logger logger = LogManager.getLogger("DbCommonUtil");

	/**
	 * public static void main(String[] args) { ConfigInfo zz =
	 * ConfigInfo.getInstance(); System.out.println(zz.getPortNo());
	 * System.out.println(zz.getDriver()); System.out.println(zz.getJdbcUrl());
	 * System.out.println(zz.getUser()); System.out.println(zz.getPassword());
	 * DbCommonUtil dbCommonUtil = new DbCommonUtil();
	 * System.out.println(dbCommonUtil.getConnection());
	 * dbCommonUtil.closeConnection(); }
	 * 
	 * 
	 * /** 为static变量赋值
	 */
	public static void setVariable() {
		ConfigInfo configInfo = ConfigInfo.getInstance();
		driver = configInfo.getDriver();
		jdbcUrl = configInfo.getJdbcUrl();
		user = configInfo.getUser();
		password = configInfo.getPassword();
	}

	/**
	 * 打开连接 返回连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		DbCommonUtil.setVariable();
		try {
			// 加载Oracle驱动程序
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
			System.out.println(e);
		}
		return conn;
	}

	/**
	 * 关闭连接
	 */
	public void closeConnection() {
		try {
			conn.close();
			System.out.println(conn);
		} catch (SQLException e) {
			System.out.println("关闭数据库连接失败");
			System.out.println(e);
		}
	}
}

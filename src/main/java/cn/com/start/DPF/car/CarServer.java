package cn.com.start.DPF.car;

/**
 * AIO服务端
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */

public class CarServer {
	// private static int DEFAULT_PORT = 3333; // 泰兴
	private static int DEFAULT_PORT = 2405; // 深圳
	// private static int DEFAULT_PORT = 4404;
	private static CarHandler carHandle;
	public volatile static long clientCount = 0;

	public static void start() {
		start(DEFAULT_PORT);
	}

	public static synchronized void start(int port) {
		if (carHandle != null)
			return;
		// 实例化线程对象 开启线程
		carHandle = new CarHandler();
		new Thread(carHandle,"car").start();
	}

	public static void main(String[] args) {
		CarServer.start();
	}
}
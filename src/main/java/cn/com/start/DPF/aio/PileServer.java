package cn.com.start.DPF.aio;

/**
 * AIO服务端
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */

public class PileServer {
	// private static int DEFAULT_PORT = 3333; // 泰兴
	private static int DEFAULT_PORT = 2405; // 深圳
	// private static int DEFAULT_PORT = 4404;
	private static AsyncServerHandler serverHandle;
	public volatile static long clientCount = 0;

	public static void start() {
		start(DEFAULT_PORT);
	}

	public static synchronized void start(int port) {
		if (serverHandle != null)
			return;
		// 实例化线程对象 开启线程
		serverHandle = new AsyncServerHandler(port);
		new Thread(serverHandle, "Server").start();
	}

	public static void main(String[] args) {
		PileServer.start();
	}
}
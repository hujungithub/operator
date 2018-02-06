package cn.com.start.DPF.card;

/**
 * AIO服务端
 * 
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class CardServer {
	private static int DEFAULT_PORT = 9999;
	private static AsyncServerHandler serverHandle;
	// 统计客户端个数
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
		CardServer.start();
	}
}
package cn.com.start.DPF.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioServer4 {
	// 端口
	private int port;
	// 选择器监听事件
	private static Selector selector;

	public NioServer4(int port) {
		this.port = port;
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws IOException {
		/*
		 * 启动服务器端，配置为非阻塞，绑定端口，注册accept事件ACCEPT事件：当服务端收到客户端连接请求时，触发该事件
		 */
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		// 开启selector绑定通道开始监听
		System.out.println("server start on port:" + port);
	}

	/**
	 * 服务器端轮询监听，select方法会一直阻塞直到有相关事件发生或超时
	 */
	private void listen() {
		while (true) {
			try {
				selector.select();// 返回值为本次触发的事件数
				System.out.println("本次触发的事件数" + selector.select());
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				for (SelectionKey key : selectionKeys) {
					handle(key);
					// 一个事件开启一个线程
					// Thread thread = new Thread(new NioSocket4(key));
					// thread.start();
					// 只监听连接事件 有一个客户端连接 实例化一个对象 执行读操作，写操作

				}
				selectionKeys.clear();// 清除处理过的事件
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}

		}
	}

	// 处理连接问题
	private void handle(SelectionKey selectionKey) throws IOException {
		ServerSocketChannel server = null;
		SocketChannel client = null;
		String receiveText = null;
		int count = 0;
		if (selectionKey.isAcceptable()) {
			/*
			 * 客户端请求连接事件 serversocket为该客户端建立socket连接，将此socket注册READ事件，监听客户端输入
			 * READ事件：当客户端发来数据，并已被服务器控制线程正确读取时，触发该事件
			 */
			server = (ServerSocketChannel) selectionKey.channel();
			client = server.accept();
			client.configureBlocking(false);
			System.out.println(client);
		}
	}

	public static void main(String args[]) {
		NioServer4 server4 = new NioServer4(9999);
		server4.listen();
	}
}

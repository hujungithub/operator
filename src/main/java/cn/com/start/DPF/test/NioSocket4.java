package cn.com.start.DPF.test;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * 服务端主线程
 * 
 * @author user
 * 
 */
public class NioSocket4 implements Runnable {
	private SelectionKey selectionKey = null;// key
	private SocketChannel client = null; // 通道

	private boolean flag = true; // 终止标志

	public NioSocket4(SelectionKey key) {
		this.selectionKey = key;
	}

	@Override
	public void run() {
		try {
			System.out.println("hahah");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

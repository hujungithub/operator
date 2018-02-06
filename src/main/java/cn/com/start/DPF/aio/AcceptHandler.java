package cn.com.start.DPF.aio;

import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.entity.SocketLinkRecord;
import cn.com.start.DPF.util.socket.CreateByte;

//作为handler接收客户端连接  
public class AcceptHandler implements
		CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {
	private static Logger logger = LogManager.getLogger("LOG_DPF");

	@Override
	public void completed(AsynchronousSocketChannel channel,
			AsyncServerHandler serverHandler) {
		// 继续接受其他客户端的请求
		PileServer.clientCount++;
		SocketLinkRecord slRecord = new SocketLinkRecord();
		try {
			logger.info("the client ipaddress & port"
					+ channel.getRemoteAddress());
			// 获取连接对象参数
			String temp = channel.getRemoteAddress().toString();
			String ipAddress = temp.substring(1).split(":")[0];
			String port = temp.substring(1).split(":")[1];
			String time = CreateByte.getCurrTime();
			// 设置连接对象参数 -入库
			slRecord.setIP(ipAddress);
			slRecord.setPORT(port);
			slRecord.setCONNECTTIME(time);
			DBOperation dStorage = DBOperation.getInstance();
			dStorage.saveSocketLinkRecord(slRecord);
			logger.info("【INSERT DB SocketLinkRecord】-新的客户端连接，记录入库");
			logger.info("^^^^^^" + slRecord.toString());
			logger.info("");
			// zzz
			if (ipAddress.equals("192.168.8.252")) {
				System.out.println("close sb xixixixixixixixi" + ipAddress);
				channel.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		serverHandler.channel.accept(serverHandler, this);
		// 接收成功之后 创建连接对象 处理收发
		Thread thread = new Thread(new PileObject(channel, slRecord));
		thread.start();
	}

	@Override
	public void failed(Throwable exc, AsyncServerHandler serverHandler) {
		exc.printStackTrace();
		serverHandler.latch.countDown();
	}
}
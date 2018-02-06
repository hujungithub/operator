package cn.com.start.DPF.card;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.entity.SocketLinkRecord;
import cn.com.start.DPF.util.socket.CreateByte;

public class CardObject implements Runnable {
	private static CardStorage cStorage = CardStorage.getIstance();
	// 类统计
	private static int count = 0; // 类变量
	// redis 日志 存储入库
	private static Logger logger = LogManager.getLogger("LOG_CARD");
	// 方便取
	private String ip;
	// 计数器
	private boolean flag = true; // init
	// 成员对象
	private AsynchronousSocketChannel channel;
	private SocketLinkRecord slRecord;
	private HashMap<String, Object> map = new HashMap<String, Object>(); // 用于返回值

	// 构造函数
	public CardObject(AsynchronousSocketChannel channel,
			SocketLinkRecord slRecord) {
		this.channel = channel;
		this.slRecord = slRecord;
		this.ip = slRecord.getIP();
		// 取出IP地址，与对象一起存入map
		CardRelay.ipObjectMap.put(slRecord.getIP(), this);
		System.out.println(slRecord.getIP() + "---getIP");
		// 日志
		logger.info("Init the " + ++count + "card client");
		logger.info("ip web get in server "+ip);
		Init();
	}

	public void Init() {
		map.put("IP", slRecord.getIP());// ip地址
		map.put("ID", "0"); // 初始化中的ID
		map.put("INIT", "0"); // 初始化
		map.put("HEARTBEAT", 0); // 统计心跳帧 3次没收到就重连 用int
		map.put("PACKET", 0); // 判断是不是第一帧 统计所有收到的帧
	}

	// 接收消息
	public void doRead() {
		// 申请200的buffer空间
		ByteBuffer readBuffer = ByteBuffer.allocate(200);
		// 异步写数据 参数与前面的read一样
		channel.read(readBuffer, readBuffer,
				new CompletionHandler<Integer, ByteBuffer>() {
					@Override
					public void completed(Integer result, ByteBuffer readBuffer) {
						// 根据
						readBuffer.flip();
						byte[] message = new byte[readBuffer.remaining()];
						readBuffer.get(message);
						if (message.length == 0) {
							try {
								logger.info("the client closed the connection");
								logger.info("");
								CardRelay.ipObjectMap.remove(ip);
								channel.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						Long a = System.currentTimeMillis();
						int packetcount = (Integer) map.get("PACKET");
						map.put("PACKET", ++packetcount);
						System.out.println("");
						logger.info("[&&Start Read&&]--【第" + packetcount
								+ "条报文】" + "--" + "receive ");
						// 收到报文之后给报文数加1
						System.out.println("###################"
								+ CreateByte.bytesToHexString(message));
						CardProcess.ProcessData(message, map);
						// 收到客户端消息之后 调用写方法给反馈
						// 继续读
						Long b = System.currentTimeMillis();
						logger.info("[&& End Read &&]--" + "the all step cost【"
								+ (b - a) + "】 millseconds--end");
						logger.info("");
						doRead();
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						try {
							count--;// 断开连接已连接的--
							channel.close();
							flag = false;
							logger.error("@@@@@@@【IP = " + slRecord.getIP()
									+ "】@@@@@@@@@@@@@receive error");
						} catch (IOException e) {

						}
					}
				});
	}

	// 发送消息
	public void doWrite(byte[] buf) {
		ByteBuffer writeBuffer = ByteBuffer.allocate(buf.length);
		writeBuffer.put(buf);
		writeBuffer.flip();
		// 异步写数据 参数与前面的read一样
		channel.write(writeBuffer, writeBuffer,
				new CompletionHandler<Integer, ByteBuffer>() {
					@Override
					public void completed(Integer result, ByteBuffer buffer) {
						buffer.clear();
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						try {
							// 失败断开连接 已连接的--
							count--;
							channel.close();
							flag = false;
							logger.error("@@@@@@@【IP = " + slRecord.getIP()
									+ "】@@@@@@@@@@@@send error");
						} catch (IOException e) {
						}
					}
				});
	}

	// 輸出發送信息
	public void sendPrint(Long a, int sendCount, String what, byte[] buf) {
		System.out.println("");
		logger.info("[%% Start Send %%]--【time = " + CreateByte.getCurrTime()
				+ "】【第" + sendCount + "条】报文");
		logger.info("[Send To]--[[@@IP = " + slRecord.getIP() + "@@]");
		logger.info("send the 【【" + what + "】】 data 【length=" + buf.length
				+ "】" + CreateByte.bytesToHexString(buf));
		long b = System.currentTimeMillis();
		logger.info("[%% End Send %%]--【the all step cost【【" + (b - a)
				+ "】】 millsecond】");
		System.out.println("");
		System.out.println("");
	}

	// 下发给发卡器的命令 由页面操作唤醒，并传参数执行
	// 发送串口配置命令
	public void sendPortConfig() {
		byte[] buf = CardData.getPortConfig(ip);
		doWrite(buf);
	}

	// 发送开用户卡命令
	public void sendIssueUserCard() {
		byte[] buf = CardData.getSellUserCard(ip);
		logger.info("准备发送开用户卡报文");
		doWrite(buf);
		logger.info("");
		cStorage.addIssueUserCardRecord(ip);
	}

	// 发送开ESAM卡命令
	public void sendIssueESAMCard() {
		byte[] buf = CardData.getSellESAMCard(ip);
		logger.info("准备发送开ESAM卡报文");
		doWrite(buf);
		logger.info("");
		cStorage.addIssueESAMCardRecord(ip);
	}

	// 发送开ESAM卡命令
	public void sendIssueISAMCard() {
		byte[] buf = CardData.getSellISAMCard(ip);
		logger.info("准备发送开ISAM卡报文");
		doWrite(buf);
		logger.info("");
		cStorage.addIssueISAMCardRecord(ip);
	}

	// 发送读取用户卡命令
	public void sendReadCardNum() {
		byte[] buf = CardData.getUserCard(ip);
		logger.info("准备发送读取用户卡号报文");
		doWrite(buf);
		logger.info("");
		cStorage.addReadCardNumRecord(ip);
	}

	// 发送读取余额命令
	public void sendReadBalance() {
		byte[] buf = CardData.getUserBalance(ip);
		logger.info("准备发送读取余额报文");
		doWrite(buf);
		logger.info("");
		cStorage.addReadBalanceRecord(ip);
	}

	// 发送充值命令
	public void sendRecharge() {
		byte[] buf = CardData.getUserCardRecharge(ip);
		logger.info("准备发送充值报文");
		doWrite(buf);
		logger.info("");
		cStorage.addRechargeRecord(ip);
	}

	// 发送重置pin命令
	public void sendReloadPIN() {
		byte[] buf = CardData.getReloadPIN(ip);
		logger.info("准备发送重置PIN报文");
		doWrite(buf);
		logger.info("");
		cStorage.addReloadPINRecord(ip);
	}

	// 发送修改pin命令
	public void sendChangePIN() {
		byte[] buf = CardData.getUserCardPIN(ip);
		logger.info("准备发送修改PIN报文");
		doWrite(buf);
		logger.info("");
		cStorage.addChangePINRecord(ip);
	}

	// 发送预处理命令
	public void sendPretreatment() {
		byte[] buf = CardData.getPretreatment(ip);
		logger.info("准备发送预处理报文");
		doWrite(buf);
		logger.info("");
		cStorage.addPretreatmentRecord(ip);
	}

	// 发送联机解扣
	public void sendUnlockGrey() {
		byte[] buf = CardData.getUnlockGrey(ip);
		logger.info("准备发送联机解扣报文");
		doWrite(buf);
		logger.info("");
		cStorage.addUnlockGreyRecord(ip);
	}

	// 初始化和心跳自动发
	public void docheck() {
		int sendCount = 0;
		int heartBeat = 0;
		while (flag) {
			if (map.get("INIT").equals("ready")) {
				long a = System.currentTimeMillis();
				byte[] buf = CardData.getInit(String.valueOf(map.get("IP")));
				// 打印日志
				sendPrint(a, ++sendCount, "Initial", buf);
				// 发送
				doWrite(buf);
				map.put("INIT", "success");
				logger.info("发送初始化成功");
			} else if (heartBeat == 30) {
				// 15秒发一次心跳包
				// 发送心跳包
				long a = System.currentTimeMillis();
				// 工具类获取心跳报文
				byte[] buf = CardData.getHeartBeat();
				// sendPrint(a, ++sendCount, "HEARTBEAT", buf);
				logger.info("准备发送心跳");
				doWrite(buf);
				logger.info("发送心跳日志");
				heartBeat = 0;
				// 证明过了15秒 给心跳计数+1如果收到会清零如果超过3那么就要重连
				int recevieCount = Integer.parseInt(map.get("HEARTBEAT")
						.toString());
				map.put("HEARTBEAT", ++recevieCount);
			}
			// 如果超过3次没有收到心跳包那么久断开
			int recevieCount = Integer
					.parseInt(map.get("HEARTBEAT").toString());
			if (recevieCount >= 3) {
				// 断开
				try {
					count--;
					logger.error("【【Warn!!】】--the heartbeat count over 3,close channel");
					CardRelay.ipObjectMap.remove(ip);
					channel.close();
					flag = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
				heartBeat++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		doRead();
		docheck();
	}
}

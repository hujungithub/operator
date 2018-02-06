package cn.com.start.DPF.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.DPF.entity.SocketLinkRecord;
import cn.com.start.DPF.redis.RedisHandle;
import cn.com.start.DPF.util.JudgeUtil;
import cn.com.start.DPF.util.StringUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class PileObject implements Runnable {
	// 类统计
	private static int count = 0; // 类变量
	private final static int HeartTime = 12;
	private final static int TotalTime = 20;
	private final static int CheckTime = 30;
	// redis 日志 存储入库
	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dbOperation = DBOperation.getInstance();
	// 方便取
	private String cpId;
	private String deviceId;
	private int gun;
	// 计数器
	private boolean flagcp = true; // cp
	// 成员对象
	private int readCount = 0;
	private AsynchronousSocketChannel channel;
	private SocketLinkRecord slRecord;
	private HashMap<String, Object> map = new HashMap<String, Object>(); // 用于返回值
	private ArrayList<Byte> arrayList = new ArrayList<Byte>();
	private Queue<String> queueKey = new LinkedList<String>(); // 类型
	private Queue<byte[]> queueValue = new LinkedList<byte[]>(); // 发送队列

	// 构造函数
	public PileObject(AsynchronousSocketChannel channel,
			SocketLinkRecord sLinkRecord) {
		this.channel = channel;
		this.slRecord = sLinkRecord;
		logger.info("Init the " + ++count + "ChargePile client");
		logger.info("the channel is " + channel);
		Init();
	}

	public void Init() {
		// 所有的都是 ready success fail
		map.put("PACKET", 0); // 统计所有帧
		map.put("HEARTBEAT", 0); // 统计心跳帧 3次没收到就重连 用int
		map.put("PACKET", 0); // 判断是不是第一帧 统计所有收到的帧
		map.put("CPID", "0"); // 桩id
		map.put("DEVICEID", "0"); // 设备编号
		map.put("INITS", "0"); // 初始化-启动-计费-总召
		map.put("INIT", "0");// 初始化
		map.put("STARTUP", "0");// 启动
		map.put("BILLMODEL", "0");// 计费
		map.put("TOTALCALL", "0");// 总召
		map.put("QYC", "0");// 全遥测
		map.put("QYX", "0");// 全遥信
		map.put("BYX", "0");// 变遥信
		map.put("SCG", "0"); // 开启充电枪命令状态
		map.put("ECG", "0"); // 停止充电枪命令状态
		map.put("AC0", "XXX"); // ac0枪 //判断鉴权充电记录的枪
		map.put("AC1", "XXX"); // ac1枪
		map.put("CR0", "XXX"); // cr0枪
		map.put("CR1", "XXX"); // cr1枪
		map.put("CR0TIME", "0");// 充电记录时间 下发扣款信息也要做为key
		map.put("CR1TIME", "0");//
		map.put("ACFLAG", "0");// 鉴权
		map.put("RECORD", "0");// 充电记录
		map.put("DEDUCTFEE", "0");// 扣款
	}
	

	/* han--
	 * PACKET	成功解析1次报文，PACKET+1，初始化报文出错了，则重新置为0
	 * */
	// 接收消息
	public void doRead() {
		// 申请1000的buffer空间
		ByteBuffer readBuffer = ByteBuffer.allocate(192);
		// 异步写数据 参数与前面的read一样
		channel.read(readBuffer, readBuffer,			
				new CompletionHandler<Integer, ByteBuffer>() {
					@Override
					public void completed(Integer result, ByteBuffer readBuffer) {
						// 根据
						if (result == -1) {
							try {
								flagcp = false;
								count--;// 断开连接已连接的--
								logger.error("the client closed the tcp");
								logger.error("zzzzzz");
								channel.close();
								slRecord.setLOSTTIME(CreateByte.getCurrTime());
								slRecord.setREASON("收到的数据长度为0，客户端已断开连接");
								dbOperation.updateSocketLinkRecord(slRecord);
								logger.info("【UPDATE DB SocketLinkRecord】-收到的数据长度为0，客户端已断开连接");
								logger.error("@@【CPID = " + cpId
										+ "】@@[LENGTH = 0] receive error");
								logger.info("");
								logger.info("");
								return;
							} catch (IOException e) {
								logger.error(e);
							}
						} else {
							//han--桩在发报文的过程中是一条一条地发的
							readBuffer.flip();//han--位置设置为0，限制设置为当前位置
							//han--readBuffer.remaining()
							/*
							//返回当前位置与限制之间的字节
							//也就是说，每读一次，readBuffer的位置就变为0,限制变为当前位置
							//如果报文的格式正确，而且只有一帧报文，获取报文后把readBuffer清掉
							 清理的是byteList而不是readBuffer？
							 flip就清除readBuffer了
							 * */
							byte[] message = new byte[readBuffer.remaining()];
							readBuffer.get(message);
							Long a = System.currentTimeMillis();
							readCount = 0;
							// 收到报文之后给报文数加1
							int packetcount = (Integer) map.get("PACKET");
							map.put("PACKET", ++packetcount);
							logger.info("【Start Read】--【第" + packetcount
									+ "条报文】");
							// 数据转发 分析 处理
							//han-传个list过去接收报文，将报文从byte数组变为list
							DataForward.ProcessData(message, map, arrayList);
							Long b = System.currentTimeMillis();
							logger.info("【End Read】--" + "cost "
									+ (b - a)+" ms");
							logger.info("");
							// 收到客户端消息之后 调用写方法给反馈
							doRead();
						}
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						count--;// 断开连接已连接的--
						try {
							channel.close();
						} catch (IOException e) {
							logger.error(e);
						}
						// 关闭死循环
						flagcp = false;
						// 更新连接对象 入库
						slRecord.setLOSTTIME(CreateByte.getCurrTime());
						slRecord.setREASON("接收失败，客户端断开连接");
						dbOperation.updateSocketLinkRecord(slRecord);
						logger.info("【UPDATE DB SocketLinkRecord】-接收失败，客户端断开连接");
						logger.error("@@@@@@@【CPID = " + cpId
								+ " 】@@@@@@@@@@@@@receive error");
						logger.info("");
						logger.info("");
					}
				}
		
				
				);
	}

	// 发送消息
	public void doWrite(byte[] buf) {
		ByteBuffer writeBuffer = ByteBuffer.allocate(buf.length);
		writeBuffer.put(buf);
		writeBuffer.flip();//把报文放进ByteBuffer
		// 异步写数据 参数与前面的read一样
		channel.write(writeBuffer, writeBuffer,
				new CompletionHandler<Integer, ByteBuffer>() {
					@Override
					public void completed(Integer result, ByteBuffer buffer) {
						buffer.clear();
					}

					@Override
					public void failed(Throwable exc, ByteBuffer attachment) {
						// 失败断开连接 已连接的--
						count--;
						try {
							channel.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						flagcp = false;
						// 更新连接对象 入库
						slRecord.setLOSTTIME(CreateByte.getCurrTime());
						slRecord.setREASON("发送失败，客户端断开连接");
						dbOperation.updateSocketLinkRecord(slRecord);
						logger.info("【UPDATE DB SocketLinkRecord】-发送，客户端断开连接");
						logger.error("@@@@@@@【cpid = " + cpId
								+ " 】@@@@@@@@@@@@ send error");
						logger.info("");
						logger.info("");
					}
				});
	}

	public void InitSecond() {
		cpId = (String) map.get("CPID");
		deviceId = (String) map.get("DEVICEID");
		gun = DataRelay.cpMap.get(cpId).getINTERFACECOUNT();
	}

	// 这是个散桩对象
	public void doCheckCP() {
		int sendCount = 0; // 发送的总报文数
		int heartCount = 0; // 计数用的 测试
		int totalCount = 0; // 总召计数
		int checkCount = 0;// 校时计数
		int tempCount = 0;
		/*--han
		 * 只要进了while循环，flagcp为true，那么所有的count都会+1
		 * flagcp在什么情况下为true？只要能够正常读数据，flagcp就为true
		 * 
		 * 当读取失败或者断开连接时，flagcp为false*/
		while (flagcp) {
			if (queueKey.isEmpty() && queueValue.isEmpty()) {	
				// 心跳?
				// 只有队列为空才去做判断 直接调用发送
				if (!map.get("INITS").equals("success")) {
					if (map.get("INIT").equals("INIT")) {
						// 拿到cpid-deviceiid-gun
						InitSecond();
						// 报文
						byte[] buf = CreateData.getInitBytes(cpId);
						queueKey.offer("INIT");
						queueValue.offer(buf);
						//han--在发送初始化报文时，tempcount被赋值为0
					} else if (map.get("STARTUP").equals("STARTUP")
							&& tempCount % 3 == 0) {
						// 初始化完成->发送启动桩
						byte[] buf = CreateData.getStartUpBytes();
						queueKey.offer("STARTUP");
						queueValue.offer(buf);
					} else if (map.get("BILLMODEL").equals("BILLMODEL")
							&& tempCount % 3 == 1) {
						// 启动完成之后->发送计费模型
						//han-cpid是哪来的？第一次read的时候解析出来的
						/*
						 * 重点：首先要有桩连接进来，并且发了初始化报文，解析出cpid与deviceid，然后给桩回复初始化
						 * 整个通信的起点！
						 * 
						 * */
						byte[] buf = CreateData.getBillModelBytes(cpId);
						queueKey.offer("BILLMODEL");
						queueValue.offer(buf);
					} else if (map.get("TOTALCALL").equals("TOTALCALL")
							&& totalCount % 3 == 2) {
						// 计费完成或者20秒就发送总召
						byte[] buf = CreateData.getTotalCall();
						queueKey.offer("TOTALCALL");
						queueValue.offer(buf);
					}
					logger.info("i = " + map.get("INIT") + "s = "
							+ map.get("STARTUP") + "b = "
							+ map.get("BILLMODEL") + "t = "
							+ map.get("TOTALCALL"));
					if (map.get("INIT").equals("success")
							&& map.get("STARTUP").equals("success")
							&& map.get("BILLMODEL").equals("success")
							&& map.get("TOTALCALL").equals("success")) {
						// 这样才是真的初始化结束了
						map.put("INITS", "success");
						logger.info("11111");
					}
				} 			
				else {
					//logger.info("22222");
					if (map.get("DEDUCTFEE").equals("ready")) {
						if (map.get("CR0").equals("0")) {
							// 说明0有充电记录
							byte[] buf = CreateData.getDeductFeeBytes(deviceId
									+ "_0_"
									+ String.valueOf(map.get("CR0TIME")));
							queueKey.offer("DEDUCTFEE");
							queueValue.offer(buf);
						}
						if (map.get("CR1").equals("1")) {
							// 说明1有充电记录
							byte[] buf = CreateData.getDeductFeeBytes(deviceId
									+ "_1_"
									+ String.valueOf(map.get("CR1TIME")));
							queueKey.offer("DEDUCTFEE");
							queueValue.offer(buf);
						}
					}
					
					for (int i = 0; i <= gun; i++) {
						//i = 1
						int type = JudgeUtil.getCPType(cpId);
						Map<String, String> scg = RedisHandle.getMap(deviceId
								+ "_" + i + "_SCG");
						if (scg != null && scg.size() > 1) {
							
							if (scg.get("command") != null
									&& scg.get("command").equals("start")) {
								// 启动充电
								logger.info("((((((((((((((((((((((((((");
								String Value = StringUtil.getValue(scg
										.get("value"));
								byte[] buf;
								ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
								chargeProgressDto.setCPUSERID(scg.get("userId"));
								chargeProgressDto.setCPID(cpId);
								chargeProgressDto.setCHARGEMETHODID("1");
								chargeProgressDto.setCHARGEMODEID(scg.get("mode"));
								RedisHandle.setTString(cpId+"_startTime"+scg.get("userId"), CreateByte.getCurrTime());
								chargeProgressDto.setCHARGESTARTTIME(CreateByte.getCurrTime());
								if (type == 0) {
									// 直流
									/*
									 han---
									 启动充电枪的报文不一致，是文档中的报文有问题么？
									 */
									buf = CreateData.getDCSCGBytes(scg
											.get("deviceId"), Integer
											.parseInt(scg.get("gun")), Integer
											.parseInt(scg.get("mode")), Float
											.parseFloat(Value), Float
											.parseFloat(scg.get("remainSum")),
											scg.get("userId"),
											Integer.parseInt(scg
													.get("chargeDcMode")));
								} else {
									// 交流
									buf = CreateData.getSCGBytes(scg
											.get("deviceId"), Integer
											.parseInt(scg.get("gun")), Integer
											.parseInt(scg.get("mode")), Float
											.parseFloat(Value), Float
											.parseFloat(scg.get("remainSum")),
											scg.get("userId"));
								}
								// if作用？
								//han-桩是否在线
								//遥测或者dc遥测的字段MILLSECONDS的值适用于判断是否离线的依据
								/*
								han---
								3分钟内如果没有遥测数据(直流或者交流)发过来，则判断桩离线
								logger.info("桩离线 cp is offline");
								发送启动充电报文不会走doSend()方法
								*/
								if (JudgeUtil.isCPOnLine(cpId)) {
									sendPrint_0(cpId, buf,sendCount, "StartChargeGun");
									SendBytes.sendPrint2(scg, Value);
									doWrite(buf);
									// 发送成功,设定状态
									String flag = "1";
									chargeProgressDto.setCHARGESTATUS(flag);
								} else {
									chargeProgressDto.setCHARGESTATUS("0");
									logger.info("桩离线 cp is offline");
									logger.info("");
								}
								
								// 开始充电状态入库
								dbOperation.insertProgress(chargeProgressDto);
								// 改变redis状态
								RedisHandle.setString(deviceId + "_" + i
										+ "_SCG", "command", "overdue");
								RedisHandle.setString(deviceId + "_" + i
										+ "_SCG", "readTime",
										CreateByte.getCurrTime());
								// 发送记录入库
								DataStorage.storageSCGRecord(scg);
							}
							try {
								// 充电枪走快速通道
								Thread.sleep(100);
							} catch (InterruptedException e) {
								logger.error(e);
							}
						}
						Map<String, String> ecg = RedisHandle.getMap(deviceId
								+ "_" + i + "_ECG");
						if (ecg != null && ecg.size() > 1) {
							if (ecg.get("command") != null
									&& ecg.get("command").equals("stop")) {
								// 发送停止命令 必须stop+scg+ecg
								logger.info("))))))))))))))))))))))))))))");
								byte[] buf = CreateData.getECGBytes(
										ecg.get("deviceId"),
										Integer.parseInt(ecg.get("gun")),
										ecg.get("userId"));
								ChargeProgressDto chargeProgressDto = new ChargeProgressDto();
								chargeProgressDto.setCPID(cpId);
								chargeProgressDto.setCPUSERID(ecg.get("userId"));
								// 获取redis里面当前用户开始充电时间
								String startTime = RedisHandle.getTString(cpId+"_startTime"+ecg.get("userId"));
								chargeProgressDto.setCHARGESTARTTIME(String.valueOf(startTime));
								// 设置发送停止充电枪命令时间
								chargeProgressDto.setENDCHARGETIME(CreateByte.getCurrTime());
								if (JudgeUtil.isCPOnLine(cpId)) {
									sendPrint_0(cpId, buf,sendCount, "StopChargeGun");
									doWrite(buf);
									// 如果发送成功,状态为1
									chargeProgressDto.setENDCHARGESTATUS("1");
								} else {
									chargeProgressDto.setENDCHARGESTATUS("0");
									logger.info("桩离线 cp is offline");
									logger.info("");
								}
								// 状态入库
								dbOperation.updateSendStopInfo(chargeProgressDto);
								// 改变状态通知不再读取
								RedisHandle.setString(map.get("DEVICEID") + "_"
										+ i + "_ECG", "command", "overdue");
								RedisHandle.setString(map.get("DEVICEID") + "_"
										+ i + "_ECG", "readTime",
										CreateByte.getCurrTime());
								// 拿到数据 更新数据
								DataStorage.storageECGRecord(ecg, cpId);
							}
							try {
								// 充电枪走快速通道
								Thread.sleep(100);
							} catch (InterruptedException e) {
								logger.error(e);
							}
						}
					}
					if (map.get("ACFLAG").equals("ready")) {
						// 收到了鉴权报文-准备鉴权-下发结果
						if (map.get("AC0").equals("0")) {
							// 0号枪有鉴权报文
							byte[] buf = CreateData.getAcBytes(deviceId, 0);
							queueKey.offer("AUTHENTICATION");
							queueValue.offer(buf);
						}
						if (map.get("AC1").equals("1")) {
							// 1号枪有鉴权报文
							byte[] buf = CreateData.getAcBytes(deviceId, 1);
							queueKey.offer("AUTHENTICATION");
							queueValue.offer(buf);
						}
					}
					if (sendCount % 50 == 0) {
						byte[] buf = CreateData.getBillModelBytes(cpId);
						queueKey.offer("BILLMODEL");
						queueValue.offer(buf);
					}
					if (map.get("TOTALCALL").equals("ready")) {
						// 定时器直接定位 马上就发送总召
						totalCount = TotalTime - 2;
						map.put("TOTALCALL", "xixi");
					}
					if (totalCount >= TotalTime) {
						// 计费完成或者20秒就发送总召
						byte[] buf = CreateData.getTotalCall();
						queueKey.offer("TOTALCALL");
						queueValue.offer(buf);
						totalCount = 0;
					}
					if (heartCount >= HeartTime) {
						// 15秒发一次心跳包
						/* 根据上面成员变量的定义，心跳是12秒发一次，这个无所谓*/
						byte[] buf = CreateData.getHBBytes();
						queueKey.offer("HEARTBEAT");
						queueValue.offer(buf);
						heartCount = 0;
					}
					if (checkCount >= CheckTime) {
						// 30秒发送一次校时
						byte[] buf = CreateData.getCheckTime();
						queueKey.offer("CHECKTIME");
						queueValue.offer(buf);
						checkCount = 0;
					}
				}
			} else {
				// queue是空 进if 检查需要发送的数据
				// queue不是空 直接进else 执行doSend
			}
			sendCount = doSend(sendCount, heartCount, totalCount, checkCount,
					tempCount);
			// 如果超过3次没有收到心跳包那么就断开
			int recevieCount = Integer
					.parseInt(map.get("HEARTBEAT").toString());
			/*han-知道这个是怎么回事儿了,怎么回事？*/
			if (recevieCount > 3) {
				// 断开
				try {
					count--;
					logger.error("【【Warn!!】】--the heartbeat count over 3,close channel");
					channel.close();
					flagcp = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (readCount >= 45) {
				try {
					count--;
					channel.close();
					flagcp = false;
					logger.info("30秒没有报文,主动断开");
					logger.error("30秒没有收到报文,主动断开");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
				heartCount++;
				totalCount++;
				checkCount++;
				readCount++;
//				logger.info("heart = " + heartCount + "   " + "read = "
//						+ readCount);
				tempCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 队列发送函数每次只发一条
	public int doSend(int sendCount, int heartCount, int totalCount,
			int checkCount, int tempCount) {
		if (!queueKey.isEmpty() && !queueValue.isEmpty()) {
			String key = queueKey.poll();
			byte[] buf = queueValue.poll();
			if (key.equals("INIT")) {				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "Initial");
				// 更新连接对象
				SendBytes.SendInitBytes(cpId, "CP", slRecord);
				map.put("INIT", "success");
				map.put("STARTUP", "STARTUP");
				tempCount = 0;
			} else if (key.equals("STARTUP")) {
				// 启动不处理
				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "StartUp");
			} else if (key.equals("BILLMODEL")) {
				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "BillModel");
				// 发送计费模型成功入库收到回再更新
				SendBytes.sendBillModelBytes(cpId);
			} else if (key.equals("TOTALCALL")) {
				// 总召不处理
				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "TotalCall");
				totalCount = 0;
				// 刚发送总召不会复 不改变
				// map.put("TOTALCALL", "success");
			} else if (key.equals("CHECKTIME")) {
				// 校时不处理
				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "CheckTime");
				checkCount = 0;
			} else if (key.equals("AUTHENTICATION")) {
				// 鉴权不知道
				
				doWrite(buf);
				sendPrint_0(cpId, buf, ++sendCount,"AuthentiCation");
				map.put("ACFLAG", "success");
			} else if (key.equals("HEARTBEAT")) {
				// 心跳不知道
				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount, "HeartBeat");
				// 发送一次给心跳+1|收到心跳清0
				int zz = Integer.parseInt(map.get("HEARTBEAT").toString());
				map.put("HEARTBEAT", ++zz);
			} else if (key.equals("DEDUCTFEE")) {				
				doWrite(buf);
				sendPrint_0(cpId, buf,++sendCount,"DeductFee");
				map.put("DEDUCTFEE", "success");
			}
		}
		return sendCount;
	}

	// 发送前打印
	public void sendPrint_0(String cpId, byte[] buf, int sendCount,String what) {
		logger.info("【SEND " + what +" To =" + cpId +"]"+" 【第" + sendCount + "条】");
		logger.info("[length = " + buf.length + "]" + "[byte = "
				+ CreateByte.bytesToHexString(buf) + "]");
		logger.info("");
	}


	@Override
	public void run() {
		doRead();
		doCheckCP();
	}
}
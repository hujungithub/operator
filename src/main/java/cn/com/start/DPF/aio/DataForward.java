package cn.com.start.DPF.aio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.util.StringUtil;
import cn.com.start.DPF.util.socket.ByteUtil;
import cn.com.start.DPF.util.socket.CreateByte;

public class DataForward {
	private static Logger logger = LogManager.getLogger("LOG_DPF");

	private final static int msg_length = 1;
	private final static int msg_type7 = 7; // 类型type
	private final static int msg_limit8 = 8; // 可变结构限定词
	private final static int msg_cause9 = 9; // 传送原因reason
	private final static int msg_record16 = 16; // 记录的位置 record
	private final static int msg_ycyx_start16 = 16; // 遥测起始 数据起始
	private final static int msg_scgecg_start17 = 17; // 启动充电枪 停止充电枪 数据起始

	// //////////////
	private final static int length_00 = 3; // 前面3个字节

	// 存储以连接的pro104对象 cpid是key
	private static Map<String, PRO104> pro104map = new HashMap<String, PRO104>();

	/**
	 * 入口分析是不是第一帧
	 * 
	 * @param buf
	 */
	public static void ProcessData(byte[] buf, HashMap<String, Object> map,
			ArrayList<Byte> arrayList) {
		// 取cpid和时间
		if ((Integer) map.get("PACKET") == 1) {
			// 第一帧初始化帧那么单独处理
			ProcessInit(buf, map);
		} else {
			UnPackCP(buf, map, arrayList);
		}
	}

	// 处理初始化帧
	public static void ProcessInit(byte[] buf, HashMap<String, Object> map) {
		logger.info("[Read One] get the initial data" + "长度：" + buf.length
				+ "报文：" + CreateByte.bytesToHexString(buf));
		if (buf[0] == 0x68 && buf.length % 12 == 0 && buf[10] == 0x01
				&& buf[11] == 0x00) {
			buf = ByteUtil.subBytes(buf, 0, 12);
			// 先解析拿到deviceid
			//汉---从第2位开始，截取8位
			String deviceId = CreateByte.bcdToStr(ByteUtil.subBytes(buf, 2, 8))
					.toString();
			//devicecpMap
			/*
			 * 
			han-在查cpinfo的基本信息时，同时有两个map产生，一个是cpMap，通过cpid获取cpinfo对象
			 一个是devicecpMap，通过deviceid获取cpinfo对象
			 */
			String cpId = DataRelay.devicecpMap.get(deviceId);
			if (StringUtil.isEmpty(cpId)) {
				// 根据deviceid找不到cpid
				logger.info("can not find cpid by deviceid");
				logger.info("[Read Two]--[Parse Initial Failed]");
			} else {
				logger.info("[Read Two]--[CPID= " + cpId + " DeviceId= "
						+ deviceId + "]");
				// 收到了初始化就改变状态 下发初始化确认
				map.put("CPID", cpId);
				map.put("DEVICEID", deviceId);
				// 初始化报文传给中转站
				DataRelay.SychroInitMap.put(cpId, buf);//初始化报文，发什么回什么
				logger.info("[Read Six]--[Parse Initial Success]");
				// 收到初始化报文就开始初始化
				// 初始化发送后直接开始启动
				map.put("INITS", "INITS");
				map.put("INIT", "INIT");
				map.put("STARTUP", "0");// 启动
				map.put("BILLMODEL", "0");// 计费
				map.put("TOTALCALL", "0");// 总召
			}
		} else {
			logger.info("初始化报文出错了，扔掉");
			map.put("PACKET", 0); // 初始化失败
		}
	}

	// 拆分cp数据
	public static void UnPackCP(byte[] buf, HashMap<String, Object> map,
			ArrayList<Byte> byteList) {
		// 先把数据放到map里
		//han--- 先把数据放到list里
		ByteUtil.bytesAddToList(byteList, buf);
		while (byteList.size() > 0) {
			logger.info("byteList size = " + byteList.size() + "byte = "
					+ ByteUtil.listToHexString(byteList, byteList.size()));
			if (buf.length % 12 == 0 && (0xFF & buf[10]) == 1
					&& (0xFF & buf[11]) == 0) {
				// 中途又发送了初始化 报文技术器清0
				map.put("PACKET", 1);
				ProcessInit(buf, map);
				ByteUtil.delList(byteList, byteList.size());
			} else {
				// 其他报文一起分析
				if (byteList.get(0) == 0x68) {
					// 头是68看有没有黏包
					int length_01 = ByteUtil.LbytesToInt((ByteUtil
							.subListBytes(byteList, msg_length, 2)));
					if (byteList.size() == length_00 + length_01) {
						// 长度刚刚好正常处理
						//han-- 把list再转换为byte数组
						byte[] other = ByteUtil.listToBytes(byteList,
								byteList.size());
						ProceData_CP(other, map);
					} else if (byteList.size() < length_00 + length_01) {
						logger.info("这帧报文的另一半在下一帧-wait");
						// 跳出循环!!!!
						break;
					} else {
						// 需要黏包处理了
						/*han-- 黏包处理就是把需要的报文长度截掉，剩下的扔掉？跟if里面的逻辑是一样的*/
						logger.info("拆分CP数据-continue");
						byte[] other = ByteUtil.listToBytes(byteList, length_00
								+ length_01);
						ProceData_CP(other, map);
					}
				} else {
					// 如果list的头不是68直接扔掉
					/*han-如果第1位不是68，直接扔掉，然后再往后找，找到68解析*/
					byteList.remove(0);
				}
			}
		}
	}

	// 分析出来了这是cp的报文 不要减 然后发送给pro104
	//han--如果不是只有104协议，代码该怎么改？
	public static void ProceData_CP(byte[] buf, HashMap<String, Object> map) {
		if (!map.get("CPID").equals("0")) {
			// CPID != 0 证明CPID已经拿到 继续往下走
			logger.info("[Read Two]--【CPID= " + map.get("CPID") + " TIME= "
					+ CreateByte.getCurrTime() + "】");
			int protocolid = DataRelay.cpMap.get(map.get("CPID"))
					.getPROTOCOLID();
			if (protocolid == 4) {
				// 如果有协议ID==4 那么是104协议
				ProceData_104(map.get("CPID").toString(),
						ByteUtil.subBytes(buf, 0, buf.length), map);
			} else {
				logger.info("[Read Two 1]--其他协议");
				map.put("MSG", "other protocol");
			}
		}
	}

	/***
	 * 国标104协议入口 分析报文类型（遥测，遥信，总召等等）
	 * 
	 * @param cpId
	 * @param buf
	 */
	public static void ProceData_104(String cpId, byte[] buf,
			HashMap<String, Object> map) {
		// 去掉了后面的12个字节 6cpid6time
		int type = 0;
		int reason = 0;
		int record = 0;
		int length = 0;
		if (buf.length > 12) {
			type = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, msg_type7, 1));
			//han-- 传送原因，有没有在什么地方定义过？
			reason = ByteUtil
					.LbytesToInt(ByteUtil.subBytes(buf, msg_cause9, 2));
			//han--为什么要加0x100然后再把它截掉？多此一举。
			/*
			 han--地址连续的判断条件是第8位，加的是第9位
			 */
			String limit = Integer.toBinaryString(
					(buf[msg_limit8] & 0xFF) + 0x100).substring(1);
			if (limit.charAt(0) - '0' == 1) {
				// 地址连续
				length = ByteUtil.LbyteToInt(buf[msg_limit8]) - 128;
			} else {
				// 地址不连续
				length = ByteUtil.LbyteToInt(buf[msg_limit8]);
			}
		}
		if (buf.length > 16) {
			record = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, msg_record16,
					1));
		}
		// 获取最后2个字节看是否等于836判断是初始化报文+cpid ==0
		int init = ByteUtil.LbytesToInt(ByteUtil.subBytes(buf, buf.length - 2,
				2));
		// 获取第一字节加长度判断是否心跳报文131+cpid==0
		int heart = ByteUtil.LbyteToInt(buf[3]);
		int start = ByteUtil.LbyteToInt(buf[3]);
		// ********************************//
//		logger.info("[Read Three]--[104 pro]" + "-cpId=" + cpId + "-type="
//				+ type + "-reason=" + reason + "-record=" + record + "-length="
//				+ length + "-init=" + init + "-heart=" + heart + "-start="
//				+ start);
		//一个cpid对应一个PRO104对象
		//pro104map成员变量，不是启动的时候查的数据库
		//一个桩发过来信号，如果连过，就不创建对象，没有就创建，然后放进map里面
		PRO104 pro104 = pro104map.get(cpId);
		if (pro104 == null) {
			// 表中无该桩对象 新建 放入表中
			pro104 = new PRO104(cpId);
			//logger.info("[Read Three 0]--new cpid,new object " + pro104);
			pro104map.put(cpId, pro104);
		} else {
			//logger.info("[Read Three 0]--old cpid, old object " + pro104);
		}
		// 初始化 泰兴
		if (heart == 131 && buf.length == 7) {
			// 68 04 00 83 00 00 00
			logger.info("[Read Four]--【HeartBeat】");
			pro104.HB_104(ByteUtil.subBytes(buf, 0, 7), map);
		}// 校时
		else if (type == 103 && reason == 7) {
			logger.info("[Read Four]--【CheckTime】");
			pro104.CheckTime_104(ByteUtil.subBytes(buf, 0, buf.length), map);
		}// 启动充电桩
		else if (start == 11 && buf.length == 7) {
			logger.info("[Read Four]--【StartUp】");
			pro104.StartUp_104(ByteUtil.subBytes(buf, 0, 7), map);
		}// 计费模型
		else if (type == 130 && record == 6) {
			logger.info("[Read Four]--【BillModel】");
			pro104.BillModel_104(
					ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
							- msg_scgecg_start17), map);
		}// 总召开始
		else if (type == 100 && reason == 7) {
			logger.info("[Read Four]--【TotalCallStart】");
			pro104.TCStart_104(ByteUtil.subBytes(buf, 0, buf.length), map);
		}
		// 全遥测
		else if (type == 132 && reason == 20) {
			/*
			 --han--
			 modelkey=?
			 	cpinfo表中，的两个字段的拼接
			 	mfrid_model
			 		17_sk_tx_001
			 
			 */
			String modelKey = DataRelay.cpMap.get(cpId).getMFRID() + "_"
					+ DataRelay.cpMap.get(cpId).getMODEL();
			
			if (DataRelay.modelMap.get(modelKey).getCPTYPE() == 0) {
				logger.info("[Read Four]--【DCQYC】");
				pro104.DCQYC_104(
						ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
								- msg_scgecg_start17), length, map);
			} else {
				//进入else说明桩的电是交流电
				logger.info("[Read Four]--【QYC】");
				/// 第二步
				//line-190创建对象，cpId是传过来处理的，所以与下面的一直
				pro104.QYC_104(
						ByteUtil.subBytes(buf, msg_ycyx_start16, buf.length
								- msg_ycyx_start16), length, map);
			}
		} // 全遥信
		/*---han---截取17位*/
		else if (type == 1 && reason == 20) {
			String modelKey = DataRelay.cpMap.get(cpId).getMFRID() + "_"
					+ DataRelay.cpMap.get(cpId).getMODEL();
			if (DataRelay.modelMap.get(modelKey).getCPTYPE() == 0) {
				logger.info("[Read Four]--【DCQYX】");
				pro104.DCQYX_104(
						ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
								- msg_scgecg_start17), length, map);
			} else {
				logger.info("[Read Four]--【QYX】");
				pro104.QYX_104(
						ByteUtil.subBytes(buf, msg_ycyx_start16, buf.length
								- msg_ycyx_start16), length, map);
			}

		} // 总召结束
		else if (type == 100 && reason == 10) {
			logger.info("[Read Four]--【TotalCallEnd】");
			pro104.TCEnd_104(ByteUtil.subBytes(buf, 0, buf.length), map);
		}// 变位遥信
		else if (type == 1 && reason == 3) {
			String modelKey = DataRelay.cpMap.get(cpId).getMFRID() + "_"
					+ DataRelay.cpMap.get(cpId).getMODEL();
			if (DataRelay.modelMap.get(modelKey).getCPTYPE() == 0) {
				logger.info("[Read Four]--【DCBYX】");
				pro104.DCBYX_104(ByteUtil.subBytes(buf, 13, buf.length - 13),
						length, map);
			} else {
				logger.info("[Read Four]--【BYX】");
				pro104.BYX_104(ByteUtil.subBytes(buf, 13, buf.length - 13),
						length, map);
			}

		}
		// 启动充电枪 开始充电
		else if (type == 130 && reason == 6 && record == 14) {
			logger.info("[Read Four]--【StartChargeGunReply】");
			pro104.SCGR_104(
					ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
							- msg_scgecg_start17), map,cpId);
		}// 停止充电枪 停止充电
		else if (type == 130 && reason == 6 && record == 15) {
			logger.info("[Read Four]--【EndChargeGunReply】");
			pro104.ECGR_104(
					ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
							- msg_scgecg_start17), map,cpId);
		}// 充电记录
		else if (type == 130 && reason == 6 && record == 2) {
			logger.info("[Read Four]--【ChargeRecord】");
			pro104.CR_104(
					ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
							- msg_scgecg_start17), map,cpId);
		}// 刷卡充电鉴权
		else if (type == 130 && record == 1) {
			logger.info("[Read Four]--【AuthentiCation】");
			pro104.AC_104(
					ByteUtil.subBytes(buf, msg_scgecg_start17, buf.length
							- msg_scgecg_start17), map);
		}
	}
}

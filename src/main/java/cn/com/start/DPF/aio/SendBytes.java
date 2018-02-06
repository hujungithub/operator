package cn.com.start.DPF.aio;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.entity.SocketLinkRecord;

public class SendBytes {

	private static Logger logger = LogManager.getLogger("LOG_DPF");
	private static DBOperation dbOperation = DBOperation.getInstance();

	// 初始化第一步
	public static void SendInitBytes(String cpId, String type,
			SocketLinkRecord slRecord) {
		// 获取了连接对象的id 入库
		slRecord.setID(cpId);
		slRecord.setTYPE(type);
		logger.info("【BEFORE UPDATE SocketLinkRecord】-连接对象获取CPID和类型");
		dbOperation.updateSocketLinkRecord(slRecord);
		logger.info("【AFTER UPDATE  SocketLinkRecord】-UPDATE");
		logger.info("");
	}

	// 初始化第三步
	public static void sendBillModelBytes(String cpId) {
		// 发送计费数据入库
		DataStorage.storageBMSRecord(cpId);
	}

	// 输出启动充电枪命令
	public static void sendPrint2(Map<String, String> map, String Value) {
		logger.info("");
		String mode = DataRelay.modeMap.get(Integer.parseInt(map.get("mode")));
		logger.info("send to pile" + "【deviceId=" + map.get("deviceId") + "】"
				+ "【gun=" + map.get("gun") + "】" + "【mode=" + mode + "】"
				+ "【value=" + Value + "】+【cpuserid =" + map.get("userId") + "】");
		logger.info("");
	}
}

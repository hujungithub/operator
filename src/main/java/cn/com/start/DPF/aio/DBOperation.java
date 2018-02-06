package cn.com.start.DPF.aio;

import cn.com.start.DPF.dto.ChargeProgressDto;
import cn.com.start.DPF.entity.BillModelSendRecord;
import cn.com.start.DPF.entity.CPYCRunRecord_104;
import cn.com.start.DPF.entity.CPYXRunRecord_104;
import cn.com.start.DPF.entity.ChargeChangeRecord;
import cn.com.start.DPF.entity.ChargeRecord_DPF;
import cn.com.start.DPF.entity.DCYcRunRecord;
import cn.com.start.DPF.entity.DCYxRunRecord;
import cn.com.start.DPF.entity.SocketLinkRecord;
import cn.com.start.DPF.entity.StartChargeGunRecord;
import cn.com.start.DPF.entity.SwipeCardAutRecord;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;
import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.DPF.service.SavePileDataService;
import cn.com.start.DPF.util.ServiceUtil;

public class DBOperation {

	// 提供单例对象
	// 定义一个私有构造方法
	private DBOperation() {

	}

	// 定义一个静态私有变量(不初始化，不使用final关键字，使用volatile保证了多线程访问时instance变量的可见性，避免了instance初始化时其他变量属性还没赋值完时，被另外线程调用)
	private static volatile DBOperation instance;

	// 定义一个共有的静态方法，返回该类型实例
	public static DBOperation getInstance() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (instance == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (DBOperation.class) {//han--这个锁的意思与this有区别么？
				// 未初始化，则初始instance变量
				if (instance == null) {
					instance = new DBOperation();
				}
			}
		}
		return instance;
	}

	// 成员变量
	private SavePileDataService savePileDataService = (SavePileDataService) ServiceUtil
			.getBean("savePileDataServiceImpl");

	// 1.0-连接记录如数据库
	public int saveSocketLinkRecord(SocketLinkRecord slRecord) {
		int flag = savePileDataService.addSocketLinkRecord(slRecord);
		return flag;
	}

	// 1.1-更新连接记录
	public int updateSocketLinkRecord(SocketLinkRecord slRecord) {
		int flag = savePileDataService.updateSocketLinkRecord(slRecord);
		return flag;
	}

	// 1.2-计费模型发送记录
	public int addBillModelSendRecord(BillModelSendRecord bmsRecord) {
		int flag = savePileDataService.addBillModelSendRecord(bmsRecord);
		return flag;
	}

	// 1.3-收到计费模型回复
	public int updateBillModelSendRecord(BillModelSendRecord bmsRecord) {
		int flag = savePileDataService.updateBillModelSendRecord(bmsRecord);
		return flag;
	}

	// 2.0-全遥信记录入库
	public int addYXRunRecord(CPYXRunRecord_104 yxRecord) {
		int flag = savePileDataService.addYXRunRecord(yxRecord);
		return flag;
	}

	// 2.1-全遥测记录入库
	public int addYCRunRecord(CPYCRunRecord_104 ycRecord) {
		int flag = savePileDataService.addYCRunRecord(ycRecord);
		return flag;
	}

	// 2.2-充电记录变化入库
	public int addChargeChangeRecord(ChargeChangeRecord ccRecord) {
		int flag = savePileDataService.addChargeChangeRecord(ccRecord);
		return flag;
	}

	// 2.3-充电记录变化更新
	public int updateChargeChangeRecord(ChargeChangeRecord ccRecord) {
		int flag = savePileDataService.updateChargeChangeRecord(ccRecord);
		return flag;
	}

	// 3.0-鉴权数据入库
	public int addAuthentiCationRecord(SwipeCardAutRecord scaRecord) {
		int flag = savePileDataService.addAuthentiCationRecord(scaRecord);
		return flag;
	}

	// 3.1-鉴权之后更新鉴权结果
	public int updateAuthentiCationiRecord(SwipeCardAutRecord scaRecord) {
		int flag = savePileDataService.updateAuthenCationRecord(scaRecord);
		return flag;
	}

	// 4.0启动充电枪记录
	public int addStartChargeGunRecord(StartChargeGunRecord scgRecord) {
		int flag = savePileDataService.addStartChargeGunRecord(scgRecord);
		return flag;
	}

	// 4.1启动充电枪结果更新
	public int updateStartChargeGunRecord(StartChargeGunRecord scgRecord) {
		int flag = savePileDataService.updateStartChargeGunRecord(scgRecord);
		return flag;
	}

	// 5.0充电记录数据入库
	public int saveChargeRecord(ChargeRecord_DPF chargeRecord_DPF) {
		int flag = savePileDataService.addChargeRecord(chargeRecord_DPF);
		return flag;
	}

	// 5.1扣款信息入库、
	public int addDeductFeeRecord(UserDeductMoneyRecord udfRecord) {
		int flag = savePileDataService.addDeductFeeRecord(udfRecord);
		return flag;
	}

	// 6.0变遥信
	public int addBYXRunRecord(CPYXRunRecord_104 yxRecord) {
		int flag = savePileDataService.addBYXRunRecord(yxRecord);
		return flag;
	}

	// 7.0新增web告警信息
	public int addWebAlarmRecord(WebAlarmRecord webAlarmRecord) {
		int flag = savePileDataService.addWebAlarmRecord(webAlarmRecord);
		return flag;
	}

	// 8.0直流遥测数据入库
	public int addDCYCRunRecord(DCYcRunRecord dcycRecord) {
		int flag = savePileDataService.addDCYCRunRecord(dcycRecord);
		return flag;
	}

	// 9.0直流遥信数据入库
	public int addDCYXRunRecord(DCYxRunRecord dcyxRecord) {
		int flag = savePileDataService.addDCYXRunRecord(dcyxRecord);
		return flag;
	}

	// 10.0直流变遥信入库
	public int addDCBYXRunRecord(DCYxRunRecord dcyxRecord) {
		int flag = savePileDataService.addDCBYXRunRecord(dcyxRecord);
		return flag;
	}
	
	/**
	 * @Title: insertStart
	 * @Description: TODO 将开始充电状态入库
	 * @return: void
	 */
	public void insertProgress(ChargeProgressDto chargeProgressDto) {
		savePileDataService.insertStart(chargeProgressDto);
	}
	
	/**
	 * @Title: updateStartResponse
	 * @Description: TODO 开始充电回复状态及时间入库
	 * @param chargeProgressDto
	 * @return: void
	 */
	public void updateStartResponse(ChargeProgressDto chargeProgressDto) {
		savePileDataService.updateStartResponse(chargeProgressDto);
	}
	
	/**
	 * @Title: updateSendStopInfo
	 * @Description: TODO 发送停止充电枪命令回复
	 * @param chargeProgressDto
	 * @return: void
	 */
	public void updateSendStopInfo(ChargeProgressDto chargeProgressDto) {
		savePileDataService.updateSendStopInfo(chargeProgressDto);
	}
	
	/**
	 * @Title: updateStopResponseInfo
	 * @Description: TODO 停止充电枪回复信息入库
	 * @param chargeProgressDto
	 * @return: void
	 */
	public void updateStopResponseInfo(ChargeProgressDto chargeProgressDto) {
		savePileDataService.updateStopResponse(chargeProgressDto);
	}
	
	/**
	 * @Title: updateRecordInfo
	 * @Description: TODO 收到充电记录入库
	 * @param chargeProgressDto
	 * @return: void
	 */
	public void updateRecordInfo(ChargeProgressDto chargeProgressDto) {
		savePileDataService.updateRecordInfo(chargeProgressDto);
	}
	
	/**
	 * @Title: updateDeducuteInfo
	 * @Description: TODO 下发计费模型信息入库
	 * @param chargeProgressDto
	 * @return: void
	 */
	public void updateDeducuteInfo(ChargeProgressDto chargeProgressDto) {
		savePileDataService.updateDeducuteInfo(chargeProgressDto);
	}
	

}

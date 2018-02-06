package cn.com.start.DPF.service;

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

public interface SavePileDataService {

	// 1.0-连接记录入库
	int addSocketLinkRecord(SocketLinkRecord slRecord);

	// 1.1-连接记录更新
	int updateSocketLinkRecord(SocketLinkRecord slRecord);

	// 1.2 发送计费模型记录
	int addBillModelSendRecord(BillModelSendRecord bmsRecord);

	// 1.3 收到计费模型回复
	int updateBillModelSendRecord(BillModelSendRecord bmsRecord);

	// 2.0-全遥信数据入库
	int addYXRunRecord(CPYXRunRecord_104 yxRecord);

	// 2.1-全遥测数据入库
	int addYCRunRecord(CPYCRunRecord_104 ycRecord);

	// 2.2 充电记录变化入库
	int addChargeChangeRecord(ChargeChangeRecord ccRecord);

	// 2.3充电记录变化记录更新
	int updateChargeChangeRecord(ChargeChangeRecord ccRecord);

	// 3.0鉴权数据入库
	int addAuthentiCationRecord(SwipeCardAutRecord scaRecord);

	// 3.1鉴权结果更新
	int updateAuthenCationRecord(SwipeCardAutRecord scaRecord);

	// 4.0启动充电枪记录
	int addStartChargeGunRecord(StartChargeGunRecord scgRecord);

	// 4.1停止|启动|停止充电枪结果更新
	int updateStartChargeGunRecord(StartChargeGunRecord scgRecord);

	// 5.0充电记录数据入库
	int addChargeRecord(ChargeRecord_DPF chargeRecord_DPF);

	// 5.1扣款信息入库
	int addDeductFeeRecord(UserDeductMoneyRecord udmRecord);

	// 6.0变位遥信入库
	int addBYXRunRecord(CPYXRunRecord_104 yxRecord);

	// 7.0页面告警信息入库
	int addWebAlarmRecord(WebAlarmRecord webAlarmRecord);

	// 8.0直流遥测
	int addDCYCRunRecord(DCYcRunRecord dcycRecord);

	// 8.1直流遥信
	int addDCYXRunRecord(DCYxRunRecord dcyxRecord);

	// 8.2直流变化遥信
	int addDCBYXRunRecord(DCYxRunRecord dcyxRecord);
	
	// 开始充电状态入库
	public void insertStart(ChargeProgressDto chargeProgressDto);
	
	// 收到开始充电回复入库
	public void updateStartResponse(ChargeProgressDto chargeProgressDto);
	
	// 发送停止命令信息入库
	public void updateSendStopInfo(ChargeProgressDto chargeProgressDto);
	
	// 收到停止命令回复信息入库
	public void updateStopResponse(ChargeProgressDto chargeProgressDto);
	
	// 收到充电记录信息入库
	public void updateRecordInfo(ChargeProgressDto chargeProgressDto);
	
	// 下发扣费信息入库
	public void updateDeducuteInfo(ChargeProgressDto chargeProgressDto);
	
	/*// 交流变位遥测信息入库
	public void addBYCPointRecord(JLbycPointData bycPointData);*/


}

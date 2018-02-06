package cn.com.start.DPF.mapper;

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

public interface SavePileDataMapper {

	// 1.0-连接记录入库
	int insertSocketLinkRecord(SocketLinkRecord slRecord);

	// 1.1-连接记录更新
	int updateSocketLinkRecord(SocketLinkRecord slRecord);

	// 1.2计费模型下发
	int insertBillModelSendRecord(BillModelSendRecord bmsRecord);

	// 1.3收到计费模型回复
	int updateBillModelSendRecord(BillModelSendRecord bmsRecord);

	// 2.0-全遥信记录入库
	int insertYXRunRecord(CPYXRunRecord_104 yxRecord);

	// 2.1-全遥测记录入库
	int insertYCRunRecord(CPYCRunRecord_104 ycRecord);

	// 2.2 充电记录变化入库
	int insertChargeChangeRecord(ChargeChangeRecord ccRecord);

	// 2.3充电记录变化记录更新
	int updateChargeChangeRecord(ChargeChangeRecord ccRecord);

	// 3.0-鉴权数据入库
	int insertAuthentiCationRecord(SwipeCardAutRecord scaRecord);

	// 3.1-鉴权数据更新
	int updateAuthentiCationRecord(SwipeCardAutRecord scaRecord);

	// 4.0-启动充电枪记录
	int insertStartChargeGunRecord(StartChargeGunRecord scgRecord);

	// 4.1-启动充电枪记录更新
	int updateStartChargeGunRecord(StartChargeGunRecord scgRecord);

	// 5.0-充电记录数据入库
	int insertChargeRecord(ChargeRecord_DPF chRecord_DPF);

	// 5.1-扣款信息入库
	int insertDeductFeeRecord(UserDeductMoneyRecord udmRecord);

	// 6.0变位遥信入库
	int insertBYXRunRecord(CPYXRunRecord_104 yxRecord);

	// 7.0页面告警信息入库
	int insertWebAlarmRecord(WebAlarmRecord webAlarmRecord);

	// 8.0直流遥测
	int insertDCYCRunRecord(DCYcRunRecord ycdcRecord);

	// 8.1直流遥信
	int insertDCYXRunRecord(DCYxRunRecord yxdcRecord);

	// 8.2直流变化遥测
	int insertDCBYXRunrecord(DCYxRunRecord yxdcRecord);
	
	// 开始充电状态入库
	public void insertStart(ChargeProgressDto chargeProgressDto);

	// 收到开始充电回复入库
	public void updateStartResponse(ChargeProgressDto chargeProgressDto);
	
	// 发送停止充电枪命令信息入库
	public void updateSendStopInfo(ChargeProgressDto chargeProgressDto);
	
	// 收到停止充电枪回复入库
	public void updateStopResponse(ChargeProgressDto chargeProgressDto);
	
	// 收到充电记录信息入库
	public void updateRecordInfo(ChargeProgressDto chargeProgressDto);
	
	// 下发扣费信息入库
	public void updateDeducuteInfo(ChargeProgressDto chargeProgressDto);
}

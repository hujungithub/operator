package cn.com.start.DPF.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import cn.com.start.DPF.mapper.SavePileDataMapper;

@Service
@Transactional
public class SavePileDataServiceImpl implements SavePileDataService {

	@Resource
	private SavePileDataMapper savePileMapper;

	// 1.0-socket连接记录入库
	@Override
	public int addSocketLinkRecord(SocketLinkRecord socketLinkRecord) {
		int flag = savePileMapper.insertSocketLinkRecord(socketLinkRecord);
		return flag;
	}

	// 1.1-更新连接记录
	@Override
	public int updateSocketLinkRecord(SocketLinkRecord socketLinkRecord) {
		int flag = savePileMapper.updateSocketLinkRecord(socketLinkRecord);
		return flag;
	}

	// 1.2计费模型下发
	@Override
	public int addBillModelSendRecord(BillModelSendRecord bmsRecord) {
		int flag = savePileMapper.insertBillModelSendRecord(bmsRecord);
		return flag;
	}

	// 1.3收到计费模型回复
	@Override
	public int updateBillModelSendRecord(BillModelSendRecord bmsRecord) {
		int flag = savePileMapper.updateBillModelSendRecord(bmsRecord);
		return flag;
	}

	// 2.0-全遥信记录入库
	@Override
	public int addYXRunRecord(CPYXRunRecord_104 yxRecord) {
		int flag = savePileMapper.insertYXRunRecord(yxRecord);
		return flag;
	}

	// 2.1-全遥测数据入库
	@Override
	public int addYCRunRecord(CPYCRunRecord_104 ycRecord) {
		int flag = savePileMapper.insertYCRunRecord(ycRecord);
		return flag;
	}

	// 2.2 充电记录变化入库
	@Override
	public int addChargeChangeRecord(ChargeChangeRecord ccRecord) {
		int flag = savePileMapper.insertChargeChangeRecord(ccRecord);
		return flag;
	}

	// 2.3充电记录变化记录更新
	@Override
	public int updateChargeChangeRecord(ChargeChangeRecord ccRecord) {
		int flag = savePileMapper.updateChargeChangeRecord(ccRecord);
		return flag;
	}

	// 3.0-鉴权数据入库
	@Override
	public int addAuthentiCationRecord(SwipeCardAutRecord scaRecord) {
		int flag = savePileMapper.insertAuthentiCationRecord(scaRecord);
		return flag;
	}

	// 3.1-鉴权数据更新
	@Override
	public int updateAuthenCationRecord(SwipeCardAutRecord scaRecord) {
		int flag = savePileMapper.updateAuthentiCationRecord(scaRecord);
		return flag;
	}

	// 4.0-启动充电枪记录入库
	@Override
	public int addStartChargeGunRecord(StartChargeGunRecord scgRecord) {
		int flag = savePileMapper.insertStartChargeGunRecord(scgRecord);
		return flag;
	}

	// 4.1-启动充电枪结果更新
	@Override
	public int updateStartChargeGunRecord(StartChargeGunRecord scgRecord) {
		int flag = savePileMapper.updateStartChargeGunRecord(scgRecord);
		return flag;
	}

	// 5.0-充电记录入库
	@Override
	public int addChargeRecord(ChargeRecord_DPF chargeRecord_DPF) {
		int flag = savePileMapper.insertChargeRecord(chargeRecord_DPF);
		return flag;
	}

	// 5.1-扣款记录入库
	@Override
	public int addDeductFeeRecord(UserDeductMoneyRecord udmRecord) {
		int flag = savePileMapper.insertDeductFeeRecord(udmRecord);
		return flag;
	}

	// 6.0-变位遥信入库
	@Override
	public int addBYXRunRecord(CPYXRunRecord_104 yxRecord) {
		int flag = savePileMapper.insertBYXRunRecord(yxRecord);
		return flag;
	}

	// 7.0 页面告警信息入库
	@Override
	public int addWebAlarmRecord(WebAlarmRecord webAlarmRecord) {
		int flag = savePileMapper.insertWebAlarmRecord(webAlarmRecord);
		return flag;
	}

	// 8.0直流遥测
	@Override
	public int addDCYCRunRecord(DCYcRunRecord dcycRecord) {
		int flag = savePileMapper.insertDCYCRunRecord(dcycRecord);
		return flag;
	}

	// 8.1直流遥信
	@Override
	public int addDCYXRunRecord(DCYxRunRecord dcyxRecord) {
		int flag = savePileMapper.insertDCYXRunRecord(dcyxRecord);
		return flag;
	}

	// 8.2直流变化遥信
	@Override
	public int addDCBYXRunRecord(DCYxRunRecord dcyxRecord) {
		int flag = savePileMapper.insertDCBYXRunrecord(dcyxRecord);
		return flag;
	}
	
	/**
	 * @Title: insertStart 
	 * @Description: TODO 开始状态入库
	 * @return: void
	 */
	public void insertStart(ChargeProgressDto chargeProgressDto) {
		savePileMapper.insertStart(chargeProgressDto);
	}
	
	public void updateStartResponse(ChargeProgressDto chargeProgressDto) {
		savePileMapper.updateStartResponse(chargeProgressDto);
	}
	
	/**
	 * @Title: updateSendStopInfo
	 * @Description: TODO 发送停止充电枪命令入库
	 * @return: void
	 */
	public void updateSendStopInfo(ChargeProgressDto chargeProgressDto) {
		savePileMapper.updateSendStopInfo(chargeProgressDto);
	}
	
	/**
	 * @Title: updateStopResponse
	 * @Description: TODO 收到停止充电枪回复入库
	 * @param chargeProgressDto
	 * @see cn.com.start.DPF.service.SavePileDataService#updateStopResponse(cn.com.start.DPF.dto.ChargeProgressDto)
	 */
	public void updateStopResponse(ChargeProgressDto chargeProgressDto) {
		savePileMapper.updateStopResponse(chargeProgressDto);
	}
	
	/**
	 * @Title: updateRecordInfo
	 * @Description: TODO 收到充电记录信息入库
	 * @param chargeProgressDto
	 * @see cn.com.start.DPF.service.SavePileDataService#updateRecordInfo(cn.com.start.DPF.dto.ChargeProgressDto)
	 */
	public void updateRecordInfo(ChargeProgressDto chargeProgressDto) {
		savePileMapper.updateRecordInfo(chargeProgressDto);
	}
	
	/**
	 * @Title: updateDeducuteInfo
	 * @Description: TODO 下发扣费信息入库
	 * @param chargeProgressDto
	 * @see cn.com.start.DPF.service.SavePileDataService#updateDeducuteInfo(cn.com.start.DPF.dto.ChargeProgressDto)
	 */
	public void updateDeducuteInfo(ChargeProgressDto chargeProgressDto){
		savePileMapper.updateDeducuteInfo(chargeProgressDto);
	}
	
}

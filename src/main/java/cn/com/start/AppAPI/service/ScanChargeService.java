package cn.com.start.AppAPI.service;

import java.util.List;

import cn.com.start.AppAPI.dto.ChargeRecorder;
import cn.com.start.AppAPI.dto.DeviceInfoDto_API;
import cn.com.start.AppAPI.dto.ScanChargeDto;
import cn.com.start.AppAPI.dto.SmsDto;

public interface ScanChargeService {

	// 点击扫码 收费 地址 id 类型等基础信息
	List<ScanChargeDto> findChargeInfo(String CPID, String operatorId);

	DeviceInfoDto_API findDeviceInfo(String deviceId);

	List<ChargeRecorder> chargeRecorder(String serialNo);

	// 根据费率ID和当前时间计算当前充电价格
	String calculatePrice(String priceId, String operatorId);

	void updateUserStateBusy(String userId);

	void updateUserStateIdle(String userId);

	//充完查找用户手机，充电时间，费用
	SmsDto selectUserInfo(String serialNo);
	//刷卡
	SmsDto selectCardUserInfo(String serialNo);
	
	String culatePrice(String rateId, String operatorId);
}

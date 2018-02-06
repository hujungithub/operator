package cn.com.start.AppAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.AppAPI.dto.ChargeRecorder;
import cn.com.start.AppAPI.dto.DeviceInfoDto_API;
import cn.com.start.AppAPI.dto.ScanChargeDto;
import cn.com.start.AppAPI.dto.SmsDto;
import cn.com.start.AppAPI.entity.BillModelInfo_API;

public interface ScanChargeMapper {
	// 点击扫码 收费 地址 id 类型等基础信息
	List<ScanChargeDto> selectChargeInfo(String CPID);

	//
	DeviceInfoDto_API selectDeviceInfo(String deviceId);

	// 根据价格id返回费率表信息
	BillModelInfo_API selectBillByRateId(@Param("RATEID") String RATEID,
			@Param("MONTH") String MONTH, @Param("OPERATORID") String OPERATORID);

	List<ChargeRecorder> chargeRecorder(String serialNo);

	void updateUserStateBusy(String userId);

	void updateUserStateIdle(String userId);
	
	SmsDto selectUserInfo(String serialNo);
	
	SmsDto selectCardUserInfo(String serialNo);
	
}

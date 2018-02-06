package cn.com.start.AppAPI.service;

import java.util.List;

import cn.com.start.AppAPI.dto.*;

public interface UserManagerService {

	void registerUser(RegisterUserDto dto);

	int isExistPhone(String phone);

	List<UserChargeRecorder> chargeRecorderByUserId(String userId);

	List<CpuserInfoDto> loginUser(String phone, String password);

	void resetPassword(String phone, String password);

	void updateHeadUrl(String userId, String url);

	void updateProfile(UserProfileInfoDto dto);

	List<CpuserInfoDto> loadProfile(String userId);

	// 微信支付结果
	void wechatResult(WechatResultDto dto);

	// 预支付
	void insertWechatPay(WechatResultDto dto);

	List<WechatResultDto> loadAccountInfo(String userId);

	String getPayStatus(String orderId);

	/* 获取用户充电状态 */
	String getUserState(String userId);

	void insertAppointRecorder(AppointRecorderDto dto);

	List<AppointRecorderDto> getAppointRecorder(String userId);
}

package cn.com.start.AppAPI.mapper;

import java.util.List;

import cn.com.start.AppAPI.dto.*;
import org.apache.ibatis.annotations.Param;

public interface UserManagerMapper {

	void insertUserByid(RegisterUserDto dto);

	int selectUserByphone(String phone);

	List<UserChargeRecorder> chargeRecorderByUserId(String USERID);

	List<CpuserInfoDto> loginUser(@Param("PHONE") String PHONE,
			@Param("PASSWORD") String PASSWORD);

	void resetPassword(@Param("PHONE") String PHONE,
			@Param("PASSWORD") String PASSWORD);

	void updateHeadUrl(@Param("USERID") String USERID, @Param("URL") String URL);

	void updateProfile(UserProfileInfoDto dto);

	List<CpuserInfoDto> loadProfile(String userId);

	void wechatResult(WechatResultDto dto);

	void insertWechatPay(WechatResultDto dto);

	List<WechatResultDto> loadAccountInfo(String userId);

	String getPayStatus(String orderId);

	String getUserState(String userId);

	void insertAppointRecorder(AppointRecorderDto dto);

    List<AppointRecorderDto> getAppointRecorder(String userId);
}

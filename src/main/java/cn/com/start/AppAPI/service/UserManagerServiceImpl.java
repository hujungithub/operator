package cn.com.start.AppAPI.service;

import java.util.List;

import javax.annotation.Resource;

import cn.com.start.AppAPI.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.AppAPI.mapper.UserManagerMapper;

;

@Service
@Transactional
public class UserManagerServiceImpl implements UserManagerService {

	@Resource
	private UserManagerMapper userManagerMapper;

	@Override
	public void registerUser(RegisterUserDto dto) {
		userManagerMapper.insertUserByid(dto);

	}

	@Override
	public int isExistPhone(String phone) {
		return userManagerMapper.selectUserByphone(phone);

	}

	@Override
	public List<UserChargeRecorder> chargeRecorderByUserId(String USERID) {
		return userManagerMapper.chargeRecorderByUserId(USERID);
	}

	@Override
	public void resetPassword(String phone, String password) {
		userManagerMapper.resetPassword(phone, password);

	}

	@Override
	public List<CpuserInfoDto> loginUser(String phone, String password) {
		return userManagerMapper.loginUser(phone, password);
	}

	@Override
	public void updateHeadUrl(String userId, String url) {
		userManagerMapper.updateHeadUrl(userId, url);
	}

	@Override
	public void updateProfile(UserProfileInfoDto dto) {
		userManagerMapper.updateProfile(dto);
	}

	@Override
	public List<CpuserInfoDto> loadProfile(String userId) {
		return userManagerMapper.loadProfile(userId);
	}

	@Override
	public void wechatResult(WechatResultDto dto) {
		userManagerMapper.wechatResult(dto);
	}

	@Override
	public void insertWechatPay(WechatResultDto dto) {
		userManagerMapper.insertWechatPay(dto);

	}

	@Override
	public List<WechatResultDto> loadAccountInfo(String userId) {
		return userManagerMapper.loadAccountInfo(userId);
	}

	@Override
	public String getPayStatus(String orderId) {
		return userManagerMapper.getPayStatus(orderId);
	}

	@Override
	public String getUserState(String userId) {
		return userManagerMapper.getUserState(userId);
	}

	@Override
	public void insertAppointRecorder(AppointRecorderDto dto) {
		userManagerMapper.insertAppointRecorder(dto);
	}

	@Override
	public List<AppointRecorderDto> getAppointRecorder(String userId) {
		return userManagerMapper.getAppointRecorder(userId);
	}


}

package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.entity.SysPermission;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.entity.UserInfo;
import cn.com.start.webBack.mapper.LoginMapper;
import cn.com.start.webBack.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource
	public LoginMapper loginMapper;

	/**
	 * 登录
	 */
	@Override
//	public int check(String LOGINID, String LOGINPWD) {
//		int count = loginMapper.check(LOGINID, LOGINPWD);
//		return count;
//	}
	//UPDATE BY NIEHY 2017/8/7 BEGIN
	public int check1(String LOGINID){
		int count = loginMapper.check1(LOGINID);
		return count;
	}
	public int check2(String LOGINID,String LOGINPWD){
		int count = loginMapper.check2(LOGINID,LOGINPWD);
		return count;
	}
	//UPDATE BY NIEHY 2017/8/7 END
	/**
	 * 登录之后设置登录时间
	 */
	@Override
	public void setTime(String ID, String LOGINTIME) {
		loginMapper.setTime(ID, LOGINTIME);
	}

	@Override
	public UserInfo findUserInfo(String LOGINID) {
		// TODO Auto-generated method stub
		UserInfo userInfo = loginMapper.selectUserInfo(LOGINID);
		return userInfo;
	}
	
	@Override
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception {
		
		return loginMapper.findMenuListByUserId(userid);
	}
	
	@Override
	public List<SysPermission> findPermissionListByUserId(SysUser sysUser)
			throws Exception {
		
		return loginMapper.findPermissionListByUserId(sysUser);
	}
	@Override
	public SysUser querySysUserInfo(String USERCODE) {
		SysUser sysUser = loginMapper.querySysUserInfo(USERCODE);
		return sysUser;
	}

}

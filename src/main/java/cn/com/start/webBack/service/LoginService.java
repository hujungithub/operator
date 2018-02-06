package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.entity.SysPermission;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.entity.UserInfo;

public interface LoginService {

	// 登录
	//public int check(String LOGINID, String LOGINPWD);
	
	//登录用户名
	public int check1(String LOGINID);
	
	//登录密码
	public int check2(String LOGINID,String LOGINPWD);

	// 登录之后设置登录时间
	public void setTime(String ID, String LOGINTIME);

	// 获取用户名
	public UserInfo findUserInfo(String LOGINID);
	
	//根据用户id查询权限范围的菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限范围的url
	public List<SysPermission> findPermissionListByUserId(SysUser sysUser) throws Exception;
	
	public SysUser querySysUserInfo(String USERCODE);
}

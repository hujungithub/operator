package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.entity.SysPermission;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.entity.UserInfo;

public interface LoginMapper {

	// 登录
//	public int check(@Param("LOGINID") String LOGINID,
//			@Param("LOGINPWD") String LOGINPWD);
	//检查账号
	public int check1(@Param("LOGINID") String LOGINID);
	//检查密码
	public int check2(@Param("LOGINID") String LOGINID,@Param("LOGINPWD") String LOGINPWD);

	// 登录后设置时间
	public void setTime(@Param("ID") String ID,
			@Param("LOGINTIME") String LOGINTIME);

	public UserInfo selectUserInfo(String LOGINID);
	
	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(SysUser sysUser) throws Exception;
	
	public SysUser querySysUserInfo(String USERCODE);
}

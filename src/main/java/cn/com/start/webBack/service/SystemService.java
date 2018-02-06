
package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.entity.Permission;
import cn.com.start.webBack.entity.RolePermission;
import cn.com.start.webBack.entity.SysRole;
import cn.com.start.webBack.entity.SysUser;

public interface SystemService {
	//查询所有用户信息
	List<SysUser> querySysUser(SysUser sysUser);
	
	
	//根据id删除用户信息
	int deleteSysUserByIds(String ids[]);
		
	//添加用户信息
	int addSysUser(SysUser sysUser);
		
	//修改用户信息
	int updateSysUser(SysUser sysUser);
	
	//根据用户id查询用户对应的角色
	List<SysRole> queryRoleByUserId(String ID);
	
	//根据用户id和角色id删除用户角色中间表的数据
	int deleteSysUserRole(SysRole sysRole);
	
	//查询所有角色信息
	List<SysRole> querySysRole(SysRole sysRole);
	
	//根据id删除角色信息
	int deleteSysRoleByIds(String ids[]);
	
	//添加角色信息
	int addSysRole(SysRole sysRole);
	
	//修改角色信息
	int updateSysRole(SysRole sysRole);
	
	//根据用户id查询用户没有的角色
	List<SysRole> queryNotRoleByUserId(String ID);
	
	//给用户添加角色
	int addUserRole(SysRole sysRole);
	
	List<Permission> queryAllPermission();
	
	List<Permission> queryPermissionByUserId(SysUser sysUser);
	
	int deletePermission(SysRole sysRole);
	
	int addPermission(List<RolePermission> list);
	
	
	
}

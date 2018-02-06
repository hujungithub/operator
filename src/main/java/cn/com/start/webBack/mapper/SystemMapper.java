package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.entity.Permission;
import cn.com.start.webBack.entity.RolePermission;
import cn.com.start.webBack.entity.SysRole;
import cn.com.start.webBack.entity.SysUser;

public interface SystemMapper {

	List<SysUser> querySysUser(SysUser sysUser);
	
	int deleteSysUserByIds(String ids[]);
	
	int deleteSysUserRole(SysRole sysRole);
			
	int addSysUser(SysUser sysUser);
			
	int updateSysUser(SysUser sysUser);
		
	List<SysRole> queryRoleByUserId(String ID);
	
	List<SysRole> queryNotRoleByUserId(String ID);
	
	int addUserRole(SysRole sysRole);
	
	List<SysRole> querySysRole(SysRole sysRole);
	
	int deleteSysRoleByIds(String ids[]);
	
	int addSysRole(SysRole sysRole);
		
	int updateSysRole(SysRole sysRole);
	
	List<Permission> queryAllPermission();
	
	List<Permission> queryPermissionByUserId(SysUser sysUser);
	
	int deletePermission(SysRole sysRole);
	
	int addPermission(List<RolePermission> list);
}

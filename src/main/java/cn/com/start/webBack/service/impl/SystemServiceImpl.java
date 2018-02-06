package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.entity.Permission;
import cn.com.start.webBack.entity.RolePermission;
import cn.com.start.webBack.entity.SysRole;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.mapper.SystemMapper;
import cn.com.start.webBack.service.SystemService;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {

	@Resource
	public SystemMapper systemMapper;

	@Override
	public List<SysUser> querySysUser(SysUser sysUser) {
		List<SysUser> list = new ArrayList<SysUser>();
		list = systemMapper.querySysUser(sysUser);
		return list;
	}
	
	@Override
	public int deleteSysUserByIds(String[] ids) {
		int count = systemMapper.deleteSysUserByIds(ids);
		return count;
	}

	@Override
	public int addSysUser(SysUser sysUser) {
		int count = systemMapper.addSysUser(sysUser);
		return count;
	}

	@Override
	public int updateSysUser(SysUser sysUser) {
		int count = systemMapper.updateSysUser(sysUser);
		return count;
	}
	
	

	
	
	@Override
	public List<SysRole> querySysRole(SysRole sysRole) {
		List<SysRole> list = new ArrayList<SysRole>();
		list = systemMapper.querySysRole(sysRole);
		return list;
	}

	@Override
	public int deleteSysRoleByIds(String[] ids) {
		int count = systemMapper.deleteSysRoleByIds(ids);
		return count;
	}

	@Override
	public int addSysRole(SysRole sysRole) {
		int count = systemMapper.addSysRole(sysRole);
		return count;
	}

	@Override
	public int updateSysRole(SysRole sysRole) {
		int count = systemMapper.updateSysRole(sysRole);
		return count;
	}

	@Override
	public List<SysRole> queryRoleByUserId(String ID) {
		List<SysRole> list = systemMapper.queryRoleByUserId(ID);
		return list;
	}

	@Override
	public int deleteSysUserRole(SysRole sysRole) {
		int count = systemMapper.deleteSysUserRole(sysRole);
		return count;
	}

	@Override
	public List<SysRole> queryNotRoleByUserId(String ID) {
		List<SysRole> list = systemMapper.queryNotRoleByUserId(ID);
		return list;
	}

	@Override
	public int addUserRole(SysRole sysRole) {
		int count = systemMapper.addUserRole(sysRole);
		return count;
	}

	@Override
	public List<Permission> queryAllPermission() {
		List<Permission> list = systemMapper.queryAllPermission();
		return list;
	}

	@Override
	public List<Permission> queryPermissionByUserId(SysUser sysUser) {
		List<Permission> list = systemMapper.queryPermissionByUserId(sysUser);
		return list;
	}

	@Override
	public int deletePermission(SysRole sysRole) {
		int count = systemMapper.deletePermission(sysRole);
		return count;
	}

	@Override
	public int addPermission(List<RolePermission> list) {
		int count = systemMapper.addPermission(list);
		return count;
	}

	

	

}

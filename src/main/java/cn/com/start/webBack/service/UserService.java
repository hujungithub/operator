package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.FindUserInfoDto;
import cn.com.start.webBack.dto.UserInfoDto;
import cn.com.start.webBack.entity.RoleInfo;
import cn.com.start.webBack.entity.UserInfo;
import cn.com.start.webBack.util.Page;

public interface UserService {

	// 分页查询用户
	List<UserInfoDto> showUserByPage(FindUserInfoDto userInfoDto);

	// 新增用户
	int addUser(UserInfo user);

	// 查询所有权限信息
	List<RoleInfo> findRoleList(String roleloginid);

	//
	// // 根据条件删除
	int deleteById(String ADMINIDS[]);

	// 查找管理员信息
	UserInfoDto findAdminById(String ADMINID);

	// 修改管理员信息
	int updateById(UserInfo admin);

	// 查询所有的管理员 导出
	List<UserInfoDto> findAllAdmin();

	int findbosscount();

	List<RoleInfo> findAllRoleList(String roleloginid);

	int findcount(String operatorloginid);

}

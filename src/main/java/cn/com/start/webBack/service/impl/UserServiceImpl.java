package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindUserInfoDto;
import cn.com.start.webBack.dto.UserInfoDto;
import cn.com.start.webBack.entity.RoleInfo;
import cn.com.start.webBack.entity.UserInfo;
import cn.com.start.webBack.mapper.UserMapper;
import cn.com.start.webBack.service.UserService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	public UserMapper userMapper;

	/**
	 * 分页，按条件查询管理员用户
	 */
	@Override
	public List<UserInfoDto> showUserByPage(FindUserInfoDto userInfoDto) {
		Page page = null;
		// 条件查询数量
		int pageCount = userMapper.getUserCount(userInfoDto);
		page = new Page(pageCount, userInfoDto.getPageSize(),
				userInfoDto.getPageNow());
		userInfoDto.setStartPos(page.getStartPos());
		List<UserInfoDto> onePageAdminList = userMapper
				.selectUserByPage(userInfoDto);
		page.setList(onePageAdminList);
		return onePageAdminList;

	}

	/**
	 * 新增管理员用户
	 */
	@Override
	public int addUser(UserInfo user) {
		int flag = userMapper.insertUser(user);
		return flag;
	}

	/**
	 * 查询管理员角色信息
	 */
	@Override
	public List<RoleInfo> findRoleList(String roleloginid) {
		List<RoleInfo> roleList = userMapper.selectRoleList(roleloginid);
		return roleList;
	}

	// 删除管理员
	@Override
	public int deleteById(String ADMINIDS[]) {
		int count = userMapper.deleteById(ADMINIDS);
		return count;
	}

	// 根据ID查询管理员
	@Override
	public UserInfoDto findAdminById(String ADMINID) {
		UserInfoDto admin = userMapper.findAdminById(ADMINID);
		return admin;
	}

	// 修改管理员信息
	@Override
	public int updateById(UserInfo admin) {
		int updatecount = userMapper.updateById(admin);
		return updatecount;
	}

	// 查询所有管理员 导出
	@Override
	public List<UserInfoDto> findAllAdmin() {
		// TODO Auto-generated method stub
		List<UserInfoDto> adminDtoList = userMapper.selectAllAdmin();
		return adminDtoList;
	}

	@Override
	public int findbosscount() {
		// TODO Auto-generated method stub
		int bosscount = userMapper.selectbosscount();
		return bosscount;
	}

	@Override
	public List<RoleInfo> findAllRoleList(String roleloginid) {
		// TODO Auto-generated method stub
		List<RoleInfo> roleall = userMapper.selectAllRolelist(roleloginid);
		return roleall;
	}

	@Override
	public int findcount(String operatorloginid) {
		// TODO Auto-generated method stub
		int count = userMapper.selectcount(operatorloginid);
		return count;
	}
}

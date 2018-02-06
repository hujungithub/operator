package cn.com.start.webBack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.webBack.dto.FindUserInfoDto;
import cn.com.start.webBack.dto.UserInfoDto;
import cn.com.start.webBack.entity.RoleInfo;
import cn.com.start.webBack.entity.UserInfo;

public interface UserMapper {
	// 分页查询用户
	List<UserInfoDto> selectUserByPage(FindUserInfoDto userInfoDto);

	// 查询用户总数量
	int getUserCount(FindUserInfoDto userInfoDto);

	// 插入用户
	int insertUser(UserInfo user);

	// 查询角色信息
	List<RoleInfo> selectRoleList(@Param("roleloginid") String roleloginid);

	// 根据id删除
	int deleteById(String ADMINIDS[]);

	// 用户详细
	UserInfoDto findAdminById(String ADMINID);

	// 修改管理员
	int updateById(UserInfo admin);

	// 查询所有的管理员
	List<UserInfoDto> selectAllAdmin();

	int selectbosscount();

	List<RoleInfo> selectAllRolelist(@Param("roleloginid") String roleloginid);

	int selectcount(String operatorloginid);
}

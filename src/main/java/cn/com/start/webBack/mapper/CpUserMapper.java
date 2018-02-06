package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.AppUserChargeRecordDto;
import cn.com.start.webBack.dto.CpUserDto;
import cn.com.start.webBack.dto.FindCpUserDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CpUser;

public interface CpUserMapper {

	/**
	 * 查询app充值记录数
	 * @param findCpUserDto
	 * @return
	 */
	int getAppUCCount(FindCpUserDto findCpUserDto);

	/**
	 * 查询app充值记录
	 * @param findCpUserDto
	 * @return
	 */
	List<AppUserChargeRecordDto> selectAppUCRecord(FindCpUserDto findCpUserDto);

	/**
	 * app用户查询分页
	 * @param findCpUserDto
	 * @return
	 */
	List<CpUserDto> selectUserByPage(FindCpUserDto findCpUserDto);

	/**
	 * app用户总记录数
	 * @param findCpUserDto
	 * @return
	 */
	int getUserCount(FindCpUserDto findCpUserDto);

	/**
	 * 根据id删除 
	 * @param userid
	 * @return
	 */
	int deleteById(String userid[]);

	/**
	 * 获取修改用户
	 * @param CPUSERID
	 * @return
	 */
	CpUser findUserById(String CPUSERID);
	
	List<CpUser> findUserDetail(String CPUSERID);

	/**
	 * 修改用户信息
	 * @param cpuser
	 * @return
	 */
	int updateById(CpUser cpuser);

	/**
	 * 详细页面总记录数
	 * @param findCpUserDto
	 * @return
	 */
	int getCpuserChargeCount(FindCpUserDto findCpUserDto);

	
	/**
	 * 获取详细页面数据
	 * @param findCpUserDto
	 * @return
	 */
	List<userReportsDto> selectCpuserCharge(FindCpUserDto findCpUserDto);

	/**
	 * 用户数据导出
	 * @param findCpUserDto
	 * @return
	 */
	List<userReportsDto> selectCpuserMQ(FindCpUserDto findCpUserDto);

	/**
	 * app充值记录导出
	 * @param findCpUserDto
	 * @return
	 */
	List<AppUserChargeRecordDto> selectapplist(FindCpUserDto findCpUserDto);

}

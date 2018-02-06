package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.AppUserChargeRecordDto;
import cn.com.start.webBack.dto.CpUserDto;
import cn.com.start.webBack.dto.FindCpUserDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.util.Page;

public interface CpUserService {
	
	/**
	 * 第一次查询app充值记录
	 * @param findCpUserDto
	 * @return
	 */
	List<AppUserChargeRecordDto> findAppUCRecord(FindCpUserDto findCpUserDto);

	/**
	 * 充电记录数据导出
	 * @param findCpUserDto
	 * @return
	 */
	List<AppUserChargeRecordDto> findApplist(FindCpUserDto findCpUserDto);

	/**
	 * app用户管理
	 * @param findCpUserDto
	 * @return
	 */
	List<CpUserDto> showUserByPage(FindCpUserDto findCpUserDto);

	/**
	 * 获取修改的信息
	 * @param cPUSERID
	 * @return
	 */
	CpUser findUserById(String cPUSERID);
	
	List<CpUser> findUserDetail(String CPUSERID);
	/**
	 * 修改用户数据
	 * @param cpuser
	 * @return
	 */
	int updateById(CpUser cpuser);

	/**
	 * 删除用户数据
	 * @param userids
	 * @return
	 */
	int deleteById(String[] userids);

	/**
	 * 详细页面数据
	 * @param findCpUserDto
	 * @return
	 */
	List<userReportsDto> findCpuserCharge(FindCpUserDto findCpUserDto);

	/**
	 * 用户数据导出
	 * @param findCpUserDto
	 * @return
	 */
	List<userReportsDto> findCpuserMQ(FindCpUserDto findCpUserDto);

	

}

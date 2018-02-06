package cn.com.start.webBack.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.AppUserChargeRecordDto;
import cn.com.start.webBack.dto.CpUserDto;
import cn.com.start.webBack.dto.FindCpUserDto;
import cn.com.start.webBack.dto.OperInfoDto;
import cn.com.start.webBack.dto.userReportsDto;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.mapper.CpUserMapper;
import cn.com.start.webBack.service.CpUserService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class CpUserServiceImpl implements CpUserService {

	@Resource
	public CpUserMapper cpUserMapper;

	/**
	 * 根据id删除信息
	 */
	@Override
	public int deleteById(String userid[]) {
		int count = cpUserMapper.deleteById(userid);
		return count;
	}

	/**
	 * app用户查询分页
	 */
	@Override
	public List<CpUserDto> showUserByPage(FindCpUserDto findCpUserDto) {
		List<CpUserDto> onePageUserList = new ArrayList<CpUserDto>();
		// 条件查询数量
		onePageUserList = cpUserMapper.selectUserByPage(findCpUserDto);
		return onePageUserList;
	}

	/**
	 * 获取修改信息
	 */
	@Override
	public CpUser findUserById(String CPUSERID) {
		CpUser cpuser = cpUserMapper.findUserById(CPUSERID);
		return cpuser;
	}
	
	/**
	 * 修改信息
	 */
	@Override
	public int updateById(CpUser cpuser) {
		int updatecount = cpUserMapper.updateById(cpuser);
		return updatecount;
	}

	/**
	 * 详细页面数据
	 */
	@Override
	public List<userReportsDto> findCpuserCharge(FindCpUserDto findCpUserDto) {
		/*Page pagedetail = null;
		// 条件查询数量
		int pageCount = cpUserMapper.getCpuserChargeCount(findCpUserDto);
		pagedetail = new Page(pageCount, findCpUserDto.getPageSize(),
				findCpUserDto.getPageNow());
		findCpUserDto.setStartPos(pagedetail.getStartPos());*/
		List<userReportsDto> onePageUserList = cpUserMapper
				.selectCpuserCharge(findCpUserDto);

		/*pagedetail.setList(onePageUserList);*/
		return onePageUserList;

	}

	/**
	 * 用户数据导出
	 */
	@Override
	public List<userReportsDto> findCpuserMQ(FindCpUserDto findCpUserDto) {
		List<userReportsDto> cpuserMQlist = cpUserMapper
				.selectCpuserMQ(findCpUserDto);
		return cpuserMQlist;
	}

	/**
	 * 查询app充值记录
	 */
	@Override
	public List<AppUserChargeRecordDto> findAppUCRecord(FindCpUserDto findCpUserDto) {
		//初始化
		List<AppUserChargeRecordDto> appUCDtoList = new ArrayList<AppUserChargeRecordDto>();
		// 条件查询数量
		appUCDtoList = cpUserMapper.selectAppUCRecord(findCpUserDto);
		return appUCDtoList;
	}

	/**
	 * 充电记录导出
	 */
	@Override
	public List<AppUserChargeRecordDto> findApplist(FindCpUserDto findCpUserDto) {
		List<AppUserChargeRecordDto> applist = cpUserMapper
				.selectapplist(findCpUserDto);
		return applist;
	}

	@Override
	public List<CpUser> findUserDetail(String CPUSERID) {
		List<CpUser> list=cpUserMapper.findUserDetail(CPUSERID);
		return list;
	}
}

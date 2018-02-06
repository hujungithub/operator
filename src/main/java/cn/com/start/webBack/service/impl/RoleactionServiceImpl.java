package cn.com.start.webBack.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.mapper.RoleactionMapper;
import cn.com.start.webBack.service.RoleactionService;

@Service
@Transactional
public class RoleactionServiceImpl implements RoleactionService {
	
	@Resource
	public RoleactionMapper roleactionMapper;

	@Override
	public String findroleaction(String roleloginid) {
		// TODO Auto-generated method stub
		String roleaction = roleactionMapper.selectRoleaction(roleloginid);
		return roleaction;
	}


}

package cn.com.start.AppAPI.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.AppAPI.entity.CPFAI;
import cn.com.start.AppAPI.entity.FaultOrder;
import cn.com.start.AppAPI.mapper.FaultPileMapper;
import cn.com.start.AppAPI.service.FaultPileService;

@Service
@Transactional
public class FaultPileServiceImpl implements FaultPileService {

	@Resource
	private FaultPileMapper faultPileMapper;

	@Override
	public List<CPFAI> findNearFaultPile(String longitude, String latitude) {
		List<CPFAI> list = faultPileMapper.selectFaultPile(longitude, latitude);
		return list;
	}

	@Override
	public int addFaultOrder(FaultOrder faultOrder) {
		int flag = faultPileMapper.insertFaulOrder(faultOrder);
		return flag;
	}

	@Override
	public List<CPFAI> findReadyList(String rmId) {
		List<CPFAI> readyList = faultPileMapper.selectReadyList(rmId);
		return readyList;
	}

	@Override
	public List<CPFAI> findIsList(String rmId) {
		List<CPFAI> isList = faultPileMapper.selectIsList(rmId);
		return isList;
	}

	@Override
	public List<CPFAI> findDoneList(String rmId) {
		List<CPFAI> doneList = faultPileMapper.selectDoneList(rmId);
		return doneList;
	}

	@Override
	public int updateOrderFirst(String orderId, String content) {
		int flag = faultPileMapper.updateOrderFirst(orderId, content);
		return flag;
	}

	@Override
	public int updateFAIById(String cpId) {
		int flag = faultPileMapper.updateFAIById(cpId);
		return flag;
	}

 }

package cn.com.start.AppAPI.service;

import java.util.List;

import cn.com.start.AppAPI.entity.CPFAI;
import cn.com.start.AppAPI.entity.FaultOrder;

public interface FaultPileService {

	// 返回故障列表
	List<CPFAI> findNearFaultPile(String longitude, String latitude);

	// 新增修理订单信息
	int addFaultOrder(FaultOrder faultOrder);

	// 查询我正在接的任务
	List<CPFAI> findReadyList(String rmId);

	// 查询我已完成待审核的任务
	List<CPFAI> findIsList(String rmId);

	// 查询我审核通过的任务
	List<CPFAI> findDoneList(String rmId);

	// 第一次修改订单
	int updateOrderFirst(String orderId, String Content);

	// 有人接单
	int updateFAIById(String cpId);
 }

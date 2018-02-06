package cn.com.start.DPF.service;

import java.util.List;

import cn.com.start.DPF.entity.AuthorityFailCause_DPF;
import cn.com.start.DPF.entity.BillModelInfo_DPF;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.CPMLinkCP_DPF;
import cn.com.start.DPF.entity.CPModel_DPF;
import cn.com.start.DPF.entity.CPRealState_DPF;
import cn.com.start.DPF.entity.CPStateType_DPF;
import cn.com.start.DPF.entity.CSLinkCP_DPF;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChargeEndCause_DPF;
import cn.com.start.DPF.entity.ChargeMode_DPF;
import cn.com.start.DPF.entity.ProtocolInfo_DPF;
import cn.com.start.DPF.entity.YCPointList_DPF;
import cn.com.start.DPF.entity.YXPointList_DPF;

public interface GetBasicDataService {

	/***********************/
	// 获取每个桩的实时状态 没有用到这个表
	List<CPRealState_DPF> findRealState();

	/***********************/
	// 获取状态类型 6种
	List<CPStateType_DPF> findCPStateType();

	// 获取桩数据
	List<CPInfo_DPF> findCPInfo();

	// 获取协议数据
	List<ProtocolInfo_DPF> findProtoInfo();

	// 获取遥信点表
	List<YXPointList_DPF> findYxPoint();

	// 获取遥测
	List<YCPointList_DPF> findYcPoint();

	// 获取直流遥信点表
	List<YXPointList_DPF> findDCYxPoint();

	// 获取直流遥测点表
	List<YCPointList_DPF> findDCYcPoint();

	// 获取充电方式
	List<ChargeMode_DPF> findChargeMode();

	// 获取计费信息
	List<BillModelInfo_DPF> findBillModel();

	// 查询型号参数
	List<CPModel_DPF> findCPModel();

	// 查询cpm和cp对照关系
	List<CPMLinkCP_DPF> findCPMLinkCP();

	// 查询鉴权失败原因
	List<AuthorityFailCause_DPF> findACFailCause();

	// 查询充电结束原因
	List<ChargeEndCause_DPF> findChargeEndCause();

	// 查询用户卡状态
	List<CardUserInfo> findUserCard();

	// 查询cs和cp对应关系
	List<CSLinkCP_DPF> findCSLinkCP();
}

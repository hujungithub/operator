package cn.com.start.DPF.mapper;

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

public interface GetBasicDataMapper {

	// 查询 状态类型
	List<CPStateType_DPF> selectCPStateType();

	// 查询桩列表
	List<CPInfo_DPF> selectCPInfo();

	// 协议信息
	List<ProtocolInfo_DPF> selectProtoInfo();

	// 遥测点表
	List<YCPointList_DPF> selectYcPoint();

	// 遥信点表
	List<YXPointList_DPF> selectYxPoint();

	// 直流遥测点表
	List<YCPointList_DPF> selectDCYcPoint();

	// 直流遥信点表
	List<YXPointList_DPF> selectDCYxPoint();

	// 桩的实时状态
	List<CPRealState_DPF> selectCPRealState();

	// 查询充电方式
	List<ChargeMode_DPF> selectChargeMode();

	// 计费信息
	List<BillModelInfo_DPF> selectBillModel();

	// 型号信息
	List<CPModel_DPF> selectCPModel();

	// cpm和cp对应关系
	List<CPMLinkCP_DPF> selectCPMLinkCP();

	// 查询鉴权失败原因
	List<AuthorityFailCause_DPF> selectACFailCause();

	// 查询充电失败原因
	List<ChargeEndCause_DPF> selectChargeEndCause();

	// 查询用户卡数据
	List<CardUserInfo> selectCardUser();

	List<CSLinkCP_DPF> selectCSLinkCP();
}

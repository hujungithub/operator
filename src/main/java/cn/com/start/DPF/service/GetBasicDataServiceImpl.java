package cn.com.start.DPF.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import cn.com.start.DPF.mapper.GetBasicDataMapper;

@Service
@Transactional
public class GetBasicDataServiceImpl implements GetBasicDataService {

	@Resource
	private GetBasicDataMapper getBasicDataMapper;

	// 桩实时状态
	@Override
	public List<CPStateType_DPF> findCPStateType() {
		List<CPStateType_DPF> cpStateTypeList = getBasicDataMapper
				.selectCPStateType();
		return cpStateTypeList;
	}

	// 桩基本信息
	@Override
	public List<CPInfo_DPF> findCPInfo() {
		List<CPInfo_DPF> cpInfoList = getBasicDataMapper.selectCPInfo();
		return cpInfoList;
	}

	// 协议信息
	@Override
	public List<ProtocolInfo_DPF> findProtoInfo() {
		List<ProtocolInfo_DPF> protoList = getBasicDataMapper.selectProtoInfo();
		return protoList;
	}

	// 遥信点表
	@Override
	public List<YXPointList_DPF> findYxPoint() {
		List<YXPointList_DPF> yxPointList = getBasicDataMapper.selectYxPoint();
		return yxPointList;
	}

	// 遥测点表
	@Override
	public List<YCPointList_DPF> findYcPoint() {
		List<YCPointList_DPF> ycPointList = getBasicDataMapper.selectYcPoint();
		return ycPointList;
	}

	// 直流遥信点表
	@Override
	public List<YXPointList_DPF> findDCYxPoint() {
		List<YXPointList_DPF> dcyxPointList = getBasicDataMapper
				.selectDCYxPoint();
		return dcyxPointList;
	}

	// 直流遥测点表
	@Override
	public List<YCPointList_DPF> findDCYcPoint() {
		List<YCPointList_DPF> dcycPointList = getBasicDataMapper
				.selectDCYcPoint();
		return dcycPointList;
	}

	// 桩的实时状态
	@Override
	public List<CPRealState_DPF> findRealState() {
		List<CPRealState_DPF> stateList = getBasicDataMapper
				.selectCPRealState();
		return stateList;
	}

	// 充电方式
	@Override
	public List<ChargeMode_DPF> findChargeMode() {
		List<ChargeMode_DPF> modeList = getBasicDataMapper.selectChargeMode();
		return modeList;
	}

	// 计费信息
	@Override
	public List<BillModelInfo_DPF> findBillModel() {
		List<BillModelInfo_DPF> billModelList = getBasicDataMapper
				.selectBillModel();
		return billModelList;
	}

	// 型号参数
	@Override
	public List<CPModel_DPF> findCPModel() {
		List<CPModel_DPF> modelList = getBasicDataMapper.selectCPModel();
		return modelList;
	}

	// 查询cpm和cp的对应关系
	@Override
	public List<CPMLinkCP_DPF> findCPMLinkCP() {
		List<CPMLinkCP_DPF> linkList = getBasicDataMapper.selectCPMLinkCP();
		return linkList;
	}

	// 查询鉴权失败原因列表
	@Override
	public List<AuthorityFailCause_DPF> findACFailCause() {
		List<AuthorityFailCause_DPF> acFailList = getBasicDataMapper
				.selectACFailCause();
		return acFailList;
	}

	// 查询充电结束原因列表
	@Override
	public List<ChargeEndCause_DPF> findChargeEndCause() {
		List<ChargeEndCause_DPF> chargeEndList = getBasicDataMapper
				.selectChargeEndCause();
		return chargeEndList;
	}

	// 查询用户卡数据
	@Override
	public List<CardUserInfo> findUserCard() {
		List<CardUserInfo> cardUserList = getBasicDataMapper.selectCardUser();
		return cardUserList;
	}

	// 查询cs和cp对照关系
	@Override
	public List<CSLinkCP_DPF> findCSLinkCP() {
		List<CSLinkCP_DPF> cscpList = getBasicDataMapper.selectCSLinkCP();
		return cscpList;
	}

}

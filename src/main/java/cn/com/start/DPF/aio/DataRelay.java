package cn.com.start.DPF.aio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.start.DPF.entity.AuthorityFailCause_DPF;
import cn.com.start.DPF.entity.BillModelInfo_DPF;
import cn.com.start.DPF.entity.BillModelSendRecord;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.CPMLinkCP_DPF;
import cn.com.start.DPF.entity.CPModel_DPF;
import cn.com.start.DPF.entity.CPStateType_DPF;
import cn.com.start.DPF.entity.CPYCRunRecord_104;
import cn.com.start.DPF.entity.CPYXRunRecord_104;
import cn.com.start.DPF.entity.CSLinkCP_DPF;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChargeEndCause_DPF;
import cn.com.start.DPF.entity.ChargeMode_DPF;
import cn.com.start.DPF.entity.ChargeRecord_DPF;
import cn.com.start.DPF.entity.ProtocolInfo_DPF;
import cn.com.start.DPF.entity.StartChargeGunRecord;
import cn.com.start.DPF.entity.SwipeCardAutRecord;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;
import cn.com.start.DPF.entity.DCYcRunRecord;
import cn.com.start.DPF.entity.YCPointList_DPF;
import cn.com.start.DPF.entity.DCYxRunRecord;
import cn.com.start.DPF.entity.YXPointList_DPF;
import cn.com.start.DPF.service.GetBasicDataService;
import cn.com.start.DPF.util.ServiceUtil;

public class DataRelay implements Runnable {
	private static Logger logger = LogManager.getLogger("LOG_DPF");
	// /类基本变量
	private boolean flag = true;
	public static int freashFlag = 0;
	private GetBasicDataService getBasicDataService = (GetBasicDataService) ServiceUtil
			.getBean("getBasicDataServiceImpl");

	// Concurr
	// 报文数据中转map
	// 初始化报文中转 不重要
	public static ConcurrentHashMap<String, byte[]> SychroInitMap = new ConcurrentHashMap<String, byte[]>();

	// 费率记录中转 ？？
	public static ConcurrentHashMap<String, BillModelInfo_DPF> SychroBillMap = new ConcurrentHashMap<String, BillModelInfo_DPF>();
	// 启动/停止充电记录中转 入库-更新
	public static ConcurrentHashMap<String, StartChargeGunRecord> sychroStartMap = new ConcurrentHashMap<String, StartChargeGunRecord>();
	// 鉴权记录中转 入库-更新
	public static ConcurrentHashMap<String, SwipeCardAutRecord> SychroACMap = new ConcurrentHashMap<String, SwipeCardAutRecord>();

	// 充电记录 key = deviceid 一个桩多个枪 扣款必须配合opstate不然不知道哪个桩
	public static ConcurrentHashMap<String, ChargeRecord_DPF> sychroCRMap = new ConcurrentHashMap<String, ChargeRecord_DPF>();
	// 扣款记录 key = deviceid+_+gun
	public static ConcurrentHashMap<String, UserDeductMoneyRecord> sychriUDFMap = new ConcurrentHashMap<String, UserDeductMoneyRecord>();
	// 遥信记录 入库 key = cpid
	public static ConcurrentHashMap<String, CPYXRunRecord_104> sychroYXMap = new ConcurrentHashMap<String, CPYXRunRecord_104>();
	// 全遥测记录入库 key = cpid
	public static ConcurrentHashMap<String, CPYCRunRecord_104> sychroYCMap = new ConcurrentHashMap<String, CPYCRunRecord_104>();
	// 遥信记录 入库 key = cpid
	public static ConcurrentHashMap<String, DCYxRunRecord> sychroDCYXMap = new ConcurrentHashMap<String, DCYxRunRecord>();
	// 全遥测记录入库 key = cpid
	public static ConcurrentHashMap<String, DCYcRunRecord> sychroDCYCMap = new ConcurrentHashMap<String, DCYcRunRecord>();

	// 发送计费模型入库 key = cpid
	public static ConcurrentHashMap<String, BillModelSendRecord> sychroBMSMap = new ConcurrentHashMap<String, BillModelSendRecord>();
	// ------------

	// 数据库数据到内存 map类型
	public static ConcurrentHashMap<String, CPInfo_DPF> cpMap = new ConcurrentHashMap<String, CPInfo_DPF>();// 桩
	public static ConcurrentHashMap<String, String> devicecpMap = new ConcurrentHashMap<String, String>();// deviceid和cpid
	public static ConcurrentHashMap<String, BillModelInfo_DPF> billMap = new ConcurrentHashMap<String, BillModelInfo_DPF>();// 费率
	public static ConcurrentHashMap<String, CPModel_DPF> modelMap = new ConcurrentHashMap<String, CPModel_DPF>();// 型号
	public static ConcurrentHashMap<Integer, String> modeMap = new ConcurrentHashMap<Integer, String>();// 充电设置
	public static ConcurrentHashMap<String, List<String>> cpmcplinkMap = new ConcurrentHashMap<String, List<String>>();// cpm与cp关联
	public static ConcurrentHashMap<String, List<String>> cscplinkMap = new ConcurrentHashMap<String, List<String>>();
	public static ConcurrentHashMap<String, String> acFailMap = new ConcurrentHashMap<String, String>(); // 鉴权失败原因
	public static ConcurrentHashMap<String, String> endChargeMap = new ConcurrentHashMap<String, String>(); // 停止充电原因
	public static ConcurrentHashMap<String, String> stateTypeMap = new ConcurrentHashMap<String, String>();// 桩状态map
	public static ConcurrentHashMap<String, String> cardUserMap = new ConcurrentHashMap<String, String>();// 用户卡数据
	public static ConcurrentHashMap<Integer, String> protocolMap = new ConcurrentHashMap<Integer, String>();// 协议数据
	public static ConcurrentHashMap<String, YXPointList_DPF> yxPointMap = new ConcurrentHashMap<String, YXPointList_DPF>();// 遥信电表
	public static ConcurrentHashMap<String, YCPointList_DPF> ycPointMap = new ConcurrentHashMap<String, YCPointList_DPF>(); // 遥测点表
	public static ConcurrentHashMap<String, YXPointList_DPF> dcyxPointMap = new ConcurrentHashMap<String, YXPointList_DPF>();// 遥信电表
	public static ConcurrentHashMap<String, YCPointList_DPF> dcycPointMap = new ConcurrentHashMap<String, YCPointList_DPF>(); // 遥测点表

	// -------------------------
	// 数据库数据到内存 list类型
	public static List<CPInfo_DPF> cpList = new ArrayList();// 桩

	// -------------------------
	// public static HashMap<String, String>

	public void doSynchro() {
		// 从数据库查询数据放到内存中
		// 1.0查询CPInfo
		findCPInfoList();
		// 2.0查询计费信息
		findBillModelList();
		// 3.0查询CPModel
		findCPModelList();
		// 4.0查询充电设置
		findChargeModeList();
		// 5.0查询cpm和cp对照关系
		findCPMLinkCPList();
		// 6.0查询鉴权失败原因
		findACFailCauseList();
		// 7.0查询充电结束原因
		findChargeEndCauseList();
		// 8.0查询充电桩桩状态类型
		findCPStateTypeList();
		// 9.0查询用户卡数据 鉴权用的
		findUserCardList();
		// 10.0查询协议信息
		findProtocolInfoList();
		// 11.0获取遥信点表
		findYXPointList();
		// 12.0获取遥测点表
		findYCPointList();
		// 12.0获取直流遥信点表
		findDCYXPointList();
		// 13.0获取交直流遥测点表
		findDCYCPointList();
		// 15.0查询cs和cp的对照关系
		findCSLinkCPList();

	}

	// 1.0查询CPInfo信息存储到缓存
	public void findCPInfoList() {
		List<CPInfo_DPF> zzList = getBasicDataService.findCPInfo();
		for (int i = 0; i < zzList.size(); i++) {
			String key = zzList.get(i).getCPID();
			String deviceId = zzList.get(i).getDEVICEID();
			cpMap.put(key, zzList.get(i));
			devicecpMap.put(deviceId, key);
		}
		cpList = zzList;
		logger.info(cpMap.toString());
		logger.info(devicecpMap.toString());
		logger.info("定时查询数据库到内存cpInfo##########");
		System.out.println("");

	}

	// 2.0查询计费信息存储到缓存map
	public void findBillModelList() {
		List<BillModelInfo_DPF> billList = getBasicDataService.findBillModel();
		for (int i = 0; i < billList.size(); i++) {
			// key = RATEID + _ + BILLMODELID 实际为RATEID+_+月份
			String key = billList.get(i).getOPERATORID() + "_"
					+ billList.get(i).getRATEID() + "_"
					+ billList.get(i).getBILLMODELID();
			billMap.put(key, billList.get(i));
		}
		logger.info(billMap.toString());
		logger.info("定时查询数据库到内存billmodelinfo##########");
		System.out.println("");
	}

	// 3.0查询CPModel信息到缓存
	public void findCPModelList() {
		List<CPModel_DPF> modelList = getBasicDataService.findCPModel();
		for (int i = 0; i < modelList.size(); i++) {
			// key = MFRID + "_" + MODEL
			String key = modelList.get(i).getMFRID() + "_"
					+ modelList.get(i).getMODEL();
			modelMap.put(key, modelList.get(i));
		}
		logger.info(modelMap.toString());
		logger.info("定时查询数据库到内存CPModel##########");
		System.out.println("");
	}

	// 4.0查询充电设置表
	public void findChargeModeList() {
		List<ChargeMode_DPF> modeList = getBasicDataService.findChargeMode();
		for (int i = 0; i < modeList.size(); i++) {
			modeMap.put(modeList.get(i).getCHARGEMODELID(), modeList.get(i)
					.getCHARGEMODELNAME());
		}
		logger.info(modeMap.toString());
		logger.info("定时查询数据库到内存ChargeMode##########");
		System.out.println("");
	}

	// 5.0查询cpm和cp对照关系
	public void findCPMLinkCPList() {
		List<CPMLinkCP_DPF> linkList = getBasicDataService.findCPMLinkCP();
		List<String> temp = new ArrayList<String>();
		String cpmId = new String();
		for (int i = 0; i < linkList.size(); i++) {
			if (i == 0) {
				temp.add(linkList.get(i).getCPID());
				cpmId = linkList.get(i).getCPMID();
			} else {
				if (linkList.get(i).getCPMID().equals(cpmId)) {
					// 第二次进来还是同一个cpm,继续
					temp.add(linkList.get(i).getCPID());
				} else {
					// 不是同一个cpm 先把上一个list放进map 然后把新的放到list中
					cpmcplinkMap.put(cpmId, temp);
					// 重新new一个
					temp = new ArrayList<String>();
					temp.add(linkList.get(i).getCPID());
					cpmId = linkList.get(i).getCPMID();
				}
			}
		}
		cpmcplinkMap.put(cpmId, temp);
		logger.info(cpmcplinkMap.toString());
		logger.info("定时查询数据库到内存CPMLinkCP##########");
		System.out.println("");
	}

	// 6.0查询鉴权失败原因
	public void findACFailCauseList() {
		List<AuthorityFailCause_DPF> acFailList = getBasicDataService
				.findACFailCause();
		for (int i = 0; i < acFailList.size(); i++) {
			acFailMap.put(String.valueOf(acFailList.get(i).getCAUSEID()),
					acFailList.get(i).getCAUSENAME());
		}
		logger.info(acFailMap.toString());
		logger.info("定时查询数据库到内存AcFailCause##########");
		System.out.println("");
	}

	// 7.0查询充电结束原因
	public void findChargeEndCauseList() {
		List<ChargeEndCause_DPF> chargeEndList = getBasicDataService
				.findChargeEndCause();
		for (int i = 0; i < chargeEndList.size(); i++) {
			// 用协议id+_+causeid
			endChargeMap.put(chargeEndList.get(i).getPROTOCOLID() + "_"
					+ chargeEndList.get(i).getCAUSEID(), chargeEndList.get(i)
					.getCAUSENAME());
		}
		logger.info(endChargeMap.toString());
		logger.info("定时查询数据库到内存ChargeEndCause##########");
		System.out.println("");
	}

	// 8.0查询充电桩状态类型
	public void findCPStateTypeList() {
		List<CPStateType_DPF> stateTypeList = getBasicDataService
				.findCPStateType();
		for (int i = 0; i < stateTypeList.size(); i++) {
			stateTypeMap.put(stateTypeList.get(i).getPROTOCOLID() + "_"
					+ stateTypeList.get(i).getSTATEID(), stateTypeList.get(i)
					.getSTATEDESP());
		}
		logger.info(stateTypeMap.toString());
		logger.info("定时查询数据库到内存CPStateType##########");
		System.out.println("");
	}

	// 9.0查询用户卡数据--------**
	public void findUserCardList() {
		List<CardUserInfo> cardUserList = getBasicDataService.findUserCard();

	}

	// 10.0查询协议信息
	public void findProtocolInfoList() {
		List<ProtocolInfo_DPF> protoList = getBasicDataService.findProtoInfo();
		for (int i = 0; i < protoList.size(); i++) {
			protocolMap.put(protoList.get(i).getPROTOCOLID(), protoList.get(i)
					.getPROTOCOLNAME());
		}
		logger.info(protocolMap.toString());
		logger.info("定时查询数据库到内存ProtocolInfo##########");
		System.out.println("");
	}

	// 11.0遥信点表
	public void findYXPointList() {
		List<YXPointList_DPF> yxList = getBasicDataService.findYxPoint();
		for (int i = 0; i < yxList.size(); i++) {
			yxPointMap.put(yxList.get(i).getPROTOCOLID() + "_"
					+ yxList.get(i).getYXPOINTID(), yxList.get(i));
		}
		logger.info(yxPointMap.toString());
		logger.info("定时查询数据库到内存yxPointMap##########");
		System.out.println("");

	}

	// 12.0遥测点表
	public void findYCPointList() {
		List<YCPointList_DPF> ycList = getBasicDataService.findYcPoint();
		for (int i = 0; i < ycList.size(); i++) {
			ycPointMap.put(ycList.get(i).getPROTOCOLID() + "_"
					+ ycList.get(i).getYCPOINTID(), ycList.get(i));
		}
		logger.info(ycPointMap.toString());
		logger.info("定时查询数据库到内存ycPointMap##########");
		System.out.println("");
	}

	// 13直流遥信
	public void findDCYXPointList() {
		List<YXPointList_DPF> dcyxList = getBasicDataService.findDCYxPoint();
		for (int i = 0; i < dcyxList.size(); i++) {
			dcyxPointMap.put(dcyxList.get(i).getPROTOCOLID() + "_"
					+ dcyxList.get(i).getYXPOINTID(), dcyxList.get(i));
		}
		logger.info(dcyxPointMap.toString());
		logger.info("定时查询数据库到内存dcyxPointMap##########");
		System.out.println("");
	}

	// 14直流遥测
	public void findDCYCPointList() {
		List<YCPointList_DPF> dcycList = getBasicDataService.findDCYcPoint();
		for (int i = 0; i < dcycList.size(); i++) {
			dcycPointMap.put(dcycList.get(i).getPROTOCOLID() + "_"
					+ dcycList.get(i).getYCPOINTID(), dcycList.get(i));
		}
		logger.info(dcycPointMap.toString());
		logger.info("定时查询数据库到内存dcycPointMap##########");
		System.out.println("");
	}

	// 15查询cs和cp对照关系
	public void findCSLinkCPList() {
		List<CSLinkCP_DPF> cscpList = getBasicDataService.findCSLinkCP();
		List<String> temp = new ArrayList<String>();
		String csId = new String();
		for (int i = 0; i < cscpList.size(); i++) {
			if (i == 0) {
				temp.add(cscpList.get(i).getCPID());
				csId = cscpList.get(i).getCSID();
			} else {
				if (cscpList.get(i).getCSID().equals(csId)) {
					// 第二次进来还是同一个cpm,继续
					temp.add(cscpList.get(i).getCPID());
				} else {
					// 不是同一个cpm 先把上一个list放进map 然后把新的放到list中
					cscplinkMap.put(csId, temp);
					// 重新new一个
					temp = new ArrayList<String>();
					temp.add(cscpList.get(i).getCPID());
					csId = cscpList.get(i).getCSID();
				}
			}
		}
		cscplinkMap.put(csId, temp);
		logger.info(cscplinkMap.toString());
		logger.info("定时查询数据库到内存CSLINKCP##########");
		System.out.println("");
	}

	// 查询点表
	@Override
	public void run() {
		while (flag) {
			if (freashFlag == 1) {
				doSynchro();
				freashFlag = 0;
			}
			try {
				doSynchro();
				Thread.sleep(360000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

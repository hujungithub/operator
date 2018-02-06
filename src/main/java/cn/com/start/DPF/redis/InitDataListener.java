//package cn.com.start.DPF.redis;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//
//import redis.clients.jedis.Jedis;
//
//public class InitDataListener implements BeanPostProcessor {
//
//	private Logger logger = LogManager.getLogger("LOG_DPF");
//	private Jedis jedis = new Jedis("127.0.0.1", 6379);
//
//	@Override
//	public Object postProcessAfterInitialization(Object arg0, String arg1)
//			throws BeansException {
//		// 存到redis
//		// return findDataIntoRedis(arg0, arg1);
//		// 存到cache
//		// return findDataIntoCache();
//	}
//
//	@Override
//	public Object postProcessBeforeInitialization(Object arg0, String arg1)
//			throws BeansException {
//		return arg0;
//	}
//
//	// public Object findDataIntoCache(Object arg0, String arg1) {
//	// if (arg0 instanceof GetBasicDataServiceImpl) {
//	// List<CPInfo_DPF> cpInfoList = ((GetBasicDataServiceImpl) arg0)
//	// .findCPInfo();
//	// for (int i = 0; i < cpInfoList.size(); i++) {
//	// // key=cpid value=cpinfo
//	// StaticData_DPF.cpMap.put(cpInfoList.get(i).getCPID(),
//	// cpInfoList.get(i));
//	// System.out.println("第" + i + "保存成功" + "cpinfo");
//	// }
//	//
//	// List<CPRealState_DPF> stateList = ((GetBasicDataServiceImpl) arg0)
//	// .findRealState();
//	// for (int i = 0; i < stateList.size(); i++) {
//	// // key=cpid value=cprealstate
//	// StaticData_DPF.stateMap.put(stateList.get(i).getCPID(),
//	// stateList.get(i));
//	// System.out.println("第" + i + "保存成功" + "cprealstate");
//	// }
//	//
//	// List<CPStateType_DPF> typeList = ((GetBasicDataServiceImpl) arg0)
//	// .findCPStateType();
//	// for (int i = 0; i < typeList.size(); i++) {
//	// // key=stateid value=cpstatetype
//	// StaticData_DPF.typeMap.put(typeList.get(i).getSTATEID(),
//	// typeList.get(i));
//	// System.out.println("第" + i + "保存成功" + "cpstatetype");
//	// }
//	//
//	// List<ProtocolInfo_DPF> proInfoList = ((GetBasicDataServiceImpl) arg0)
//	// .findProtoInfo();
//	// for (int i = 0; i < proInfoList.size(); i++) {
//	// // key=protocolid value=protocolinfo
//	// StaticData_DPF.proMap.put(proInfoList.get(i).getPROTOCOLID(),
//	// proInfoList.get(i));
//	// System.out.println("第" + i + "保存成功" + "protocolinfo");
//	// }
//	//
//	// List<YCPointList_DPF> ycList = ((GetBasicDataServiceImpl) arg0)
//	// .findYcPoint();
//	// String temp = null;
//	// for (int i = 0; i < ycList.size(); i++) {
//	// // 点表id格式为 protocolid+.+ycpointid
//	// temp = ycList.get(i).getPROTOCOLID() + "yc"
//	// + ycList.get(i).getPROTOCOLID();
//	// StaticData_DPF.ycMap.put(temp, ycList.get(i));
//	// System.out.println("第" + i + "保存成功" + "ycpointlist");
//	// }
//	//
//	// List<YXPointList_DPF> yxList = ((GetBasicDataServiceImpl) arg0)
//	// .findYxPoint();
//	// for (int i = 0; i < yxList.size(); i++) {
//	// // 点表格式 protocolid+yxpointid
//	// temp = yxList.get(i).getPROTOCOLID() + "yx"
//	// + yxList.get(i).getYXPOINTID();
//	// StaticData_DPF.yxMap.put(temp, yxList.get(i));
//	// System.out.println("第" + i + "保存成功" + "yxpointlist");
//	// }
//	// }
//	// return arg0;
//	// }
//
//	// public Object findDataIntoRedis(Object arg0, String arg1) {
//	// if (arg0 instanceof GetBasicDataServiceImpl) {
//	// List<CPInfo_DPF> cpInfoList = ((GetBasicDataServiceImpl) arg0)
//	// .findCPInfo();
//	// logger.info("初始化查询cpinfo成功");
//	// Map map = null;
//	// for (int i = 0; i < cpInfoList.size(); i++) {
//	// map = ObjectToMap.getValueMap(cpInfoList.get(i));
//	// jedis.hmset(String.valueOf(map.get("CPID") + "_CP"), map);
//	// System.out.println("第" + i + "保存成功" + "cpinfo");
//	// }
//	// logger.info("成功将cpinfo保存到redis");
//	//
//	// // ///////////////
//	// List<CPRealState_DPF> stateList = ((GetBasicDataServiceImpl) arg0)
//	// .findRealState();
//	// logger.info("初始化查询cprealstate成功");
//	// map = null;
//	// String temp = null;
//	// for (int i = 0; i < stateList.size(); i++) {
//	// map = ObjectToMap.getValueMap(stateList.get(i));
//	// // 每个桩的状态不能用cpid做key
//	// temp = map.get("CPID") + "_STATE";
//	// jedis.hmset(temp, map);
//	// System.out.println("第" + i + "保存成功" + "cprealstate");
//	// }
//	// logger.info("成功将cprealstate保存到redis");
//	//
//	// // //////////////
//	// List<CPStateType_DPF> typeList = ((GetBasicDataServiceImpl) arg0)
//	// .findCPStateType();
//	// logger.info("初始化查询cpstatetype成功");
//	// map = null;
//	// for (int i = 0; i < typeList.size(); i++) {
//	// map = ObjectToMap.getValueMap(typeList.get(i));
//	// jedis.hmset(
//	// String.valueOf(map.get("PROTOCOLID") + "_PRO_"
//	// + map.get("STATEID") + "_TYPE"), map);
//	// System.out.println("第" + i + "保存成功" + "cpstatetype");
//	// }
//	// logger.info("成功将cpstatetype保存到redis");
//	//
//	// // ///////////////
//	// List<ProtocolInfo_DPF> proInfoList = ((GetBasicDataServiceImpl) arg0)
//	// .findProtoInfo();
//	// logger.info("初始化查询protocolinfo成功");
//	// map = null;
//	// for (int i = 0; i < proInfoList.size(); i++) {
//	// map = ObjectToMap.getValueMap(proInfoList.get(i));
//	// jedis.hmset(
//	// String.valueOf(map.get("PROTOCOLID") + "_PROTOCOL"),
//	// map);
//	// System.out.println("第" + i + "保存成功" + "protocolinfo");
//	// }
//	// logger.info("成功将protocolinfo保存到redis");
//	// // ////////////////
//	// List<YCPointList_DPF> ycList = ((GetBasicDataServiceImpl) arg0)
//	// .findYcPoint();
//	// logger.info("初始化查询ycpointlist成功");
//	// map = null;
//	//
//	// for (int i = 0; i < ycList.size(); i++) {
//	// // 点表id格式为 protocolid+.+ycpointid
//	// map = ObjectToMap.getValueMap(ycList.get(i));
//	// temp = map.get("PROTOCOLID") + "_YC_POINT_"
//	// + map.get("YCPOINTID");
//	// jedis.hmset(temp, map);
//	// System.out.println("第" + i + "保存成功" + "ycpointlist");
//	// }
//	// logger.info("成功将ycpointlist保存到redis");
//	//
//	// // /////////////
//	// List<YXPointList_DPF> yxList = ((GetBasicDataServiceImpl) arg0)
//	// .findYxPoint();
//	// logger.info("初始化查询yxpointlist成功");
//	// map = null;
//	// for (int i = 0; i < yxList.size(); i++) {
//	// map = ObjectToMap.getValueMap(yxList.get(i));
//	// temp = map.get("PROTOCOLID") + "_YX_POINT_"
//	// + map.get("YXPOINTID");
//	// jedis.hmset(temp, map);
//	// System.out.println("第" + i + "保存成功" + "yxpointlist");
//	// }
//	// logger.info("成功将yxpointlist保存到redis");
//	// // ///////////////////
//	//
//	// // 充电方式 chargemode
//	// List<ChargeMode_DPF> modeList = ((GetBasicDataServiceImpl) arg0)
//	// .findChargeMode();
//	// logger.info("初始化查询chargemode成功");
//	// map = null;
//	// for (int i = 0; i < modeList.size(); i++) {
//	// map = ObjectToMap.getValueMap(modeList.get(i));
//	// jedis.hmset("CHARGEMODE_" + i, map);
//	// System.out.println("第" + i + "保存成功" + "chargemode");
//	// }
//	// logger.info("成功将chargemode保存到redis");
//	//
//	// // /////////
//	// // 遥测遥信各种协议的数量数量
//	// List<String> ycNum = ((GetBasicDataServiceImpl) arg0).findYcNum();
//	// logger.info("初始化查询ycpointnum成功");
//	// for (int i = 0; i < ycNum.size(); i++) {
//	// temp = ycNum.get(i).substring(8, ycNum.get(i).length());
//	// jedis.set(ycNum.get(i).substring(0, 7), temp);
//	// System.out.println("第" + i + "保存成功" + "ycpointnum");
//	// }
//	// logger.info("成功将ycpointnum保存到redis");
//	// // /////////////
//	// List<String> yxNum = ((GetBasicDataServiceImpl) arg0).findYxNum();
//	// logger.info("初始化查询yxpointnum成功");
//	// for (int i = 0; i < yxNum.size(); i++) {
//	// temp = yxNum.get(i).substring(8, yxNum.get(i).length());
//	// jedis.set(yxNum.get(i).substring(0, 7), temp);
//	// System.out.println("第" + i + "保存成功" + "yxpointnum");
//	// }
//	// logger.info("成功将yxpointnum保存到redis");
//	//
//	// // //
//	// // List<String> cpNum = ((GetBasicDataServiceImpl)
//	// // arg0).findCPNum();
//	// // logger.info("初始化查询CPnum成功");
//	// // for (int i = 0; i < cpNum.size(); i++) {
//	// // temp = yxNum.get(i).substring(8, yxNum.get(i).length());
//	// // jedis.set(yxNum.get(i).substring(0, 7), temp);
//	// // System.out.println("第" + i + "保存成功" + "CPnum");
//	// // }
//	// // logger.info("成功将CPnum保存到redis");
//	//
//	// }
//	// return arg0;
//	// }
// }

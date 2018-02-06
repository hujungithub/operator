package cn.com.start.DPF.redis;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import cn.com.start.DPF.entity.CPInfo_DPF;
import cn.com.start.DPF.entity.CPRealState_DPF;
import cn.com.start.DPF.entity.CPStateType_DPF;
import cn.com.start.DPF.entity.ProtocolInfo_DPF;
import cn.com.start.DPF.entity.YCPointList_DPF;
import cn.com.start.DPF.entity.YXPointList_DPF;
import cn.com.start.DPF.service.GetBasicDataServiceImpl;

@Component
public class InitDataListener0 implements
		ApplicationListener<ContextRefreshedEvent> {

	// ApplicationContext ac = new ClassPathXmlApplicationContext(
	// "config/spring-mvc.xml");
	// getBasicDataService = (GetBasicDataService) ac
	// .getBean("getBasicDataService");
	// /***************************////
	// BeanFactory factory = new ClassPathXmlApplicationContext(
	// "classpath:/applicationContext.xml");
	//
	// GetBasicDataService getBasicDataService = (GetBasicDataService)
	// factory
	// .getBean("test-service");

	// WebApplicationContext wac = ContextLoader
	// .getCurrentWebApplicationContext();
	// getBasicDataService = (GetBasicDataService) wac
	// .getBean("getBasicDataService");
	private static boolean flag = false;
	private Logger logger = LogManager.getLogger("InitDataListener");
	private Jedis jedis = new Jedis("127.0.0.1", 6379);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (flag == false) {
			flag = true;
			System.out.println("-----sssssssssssssssssssss所有Bean载入完成---");
			// this.findDataIntoRedis();
		}

	}

	public void findDataIntoRedis() {
		GetBasicDataServiceImpl getBasicDataServiceImpl = new GetBasicDataServiceImpl();

		List<CPInfo_DPF> cpInfoList = getBasicDataServiceImpl.findCPInfo();
		logger.info("初始化查询cpinfo成功");
		Map map = null;
		for (int i = 0; i < cpInfoList.size(); i++) {
			map = ObjectToMap.getValueMap(cpInfoList.get(i));
			jedis.hmset(String.valueOf(map.get("CPID") + "_CP"), map);
			System.out.println("第" + i + "保存成功" + "cpinfo");
		}
		logger.info("成功将cpinfo保存到redis");
		// ///////////////
		List<CPRealState_DPF> stateList = getBasicDataServiceImpl
				.findRealState();
		logger.info("初始化查询cprealstate成功");
		map = null;
		String temp = null;
		for (int i = 0; i < stateList.size(); i++) {
			map = ObjectToMap.getValueMap(stateList.get(i));
			// 每个桩的状态不能用cpid做key
			temp = map.get("CPID") + "_STATE";
			jedis.hmset(temp, map);
			System.out.println("第" + i + "保存成功" + "cprealstate");
		}
		logger.info("成功将cprealstate保存到redis");
		// //////////////
		List<CPStateType_DPF> typeList = getBasicDataServiceImpl
				.findCPStateType();
		logger.info("初始化查询cpstatetype成功");
		map = null;
		for (int i = 0; i < typeList.size(); i++) {
			map = ObjectToMap.getValueMap(typeList.get(i));
			jedis.hmset(String.valueOf(map.get("STATEID") + "_TYPE"), map);
			System.out.println("第" + i + "保存成功" + "cpstatetype");
		}
		logger.info("成功将cpstatetype保存到redis");
		// ///////////////
		List<ProtocolInfo_DPF> proInfoList = getBasicDataServiceImpl
				.findProtoInfo();
		logger.info("初始化查询protocolinfo成功");
		map = null;
		for (int i = 0; i < proInfoList.size(); i++) {
			map = ObjectToMap.getValueMap(proInfoList.get(i));
			jedis.hmset(String.valueOf(map.get("PROTOCOLID") + "_PROTOCOL"),
					map);
			System.out.println("第" + i + "保存成功" + "protocolinfo");
		}
		logger.info("成功将protocolinfo保存到redis");
		// ////////////////
		List<YCPointList_DPF> ycList = getBasicDataServiceImpl.findYcPoint();
		logger.info("初始化查询ycpointlist成功");
		map = null;

		for (int i = 0; i < ycList.size(); i++) {
			// 点表id格式为 protocolid+.+ycpointid
			map = ObjectToMap.getValueMap(ycList.get(i));
			temp = map.get("PROTOCOLID") + "_YC_POINT_" + map.get("YCPOINTID");
			jedis.hmset(temp, map);
			System.out.println("第" + i + "保存成功" + "ycpointlist");
		}
		logger.info("成功将ycpointlist保存到redis");
		// /////////////
		List<YXPointList_DPF> yxList = getBasicDataServiceImpl.findYxPoint();
		logger.info("初始化查询yxpointlist成功");
		map = null;
		for (int i = 0; i < yxList.size(); i++) {
			map = ObjectToMap.getValueMap(yxList.get(i));
			temp = map.get("PROTOCOLID") + "_YX_POINT_" + map.get("YXPOINTID");
			jedis.hmset(temp, map);
			System.out.println("第" + i + "保存成功" + "yxpointlist");
		}
		logger.info("成功将yxpointlist保存到redis");
	}
}
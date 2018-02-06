package cn.com.start.DPF.car;



///  经纬度

/* 路线1
31.260061 121.531593
31.263510 121.528975
31.266114 121.527344
31.271451 121.538717
31.277833 121.534576
31.281180 121.538471
*/

/*路线2
31.257080 121.524180
31.256457 121.517828
31.256548 121.511713
31.257796 121.507722
31.256530 121.503795
31.259291 121.500480
*/


/*路线3
 
 
 
 
 
*/
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import cn.com.start.DPF.entity.car.CarInfo;
import cn.com.start.DPF.entity.car.CarStateType;
import cn.com.start.DPF.service.CarOperationService;
import cn.com.start.DPF.util.ServiceUtil;

public class CarRelay implements Runnable {
	private static Logger logger = LogManager.getLogger("LOG_CAR");
	// /类基本变量
	private boolean flag = true;
	public static int freashFlag = 0;
	
	private CarOperationService carOperationService = (CarOperationService) ServiceUtil
			.getBean("carOperationServiceImpl");
	
	// map声明
	public static ConcurrentHashMap<String, CarInfo> carMap = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<Integer, CarStateType> typeMap = new ConcurrentHashMap<>();
	public static List<LLPoint> pointList1 = new ArrayList<>();
	public static List<LLPoint> pointList2 = new ArrayList<>();
	//public static List<LLPoint> pointList3 = new ArrayList<>();
	
	public void doSynchro() {
		// 从数据库查询数据放到内存中
		// 1.0查询CPInfo
		findCarInfoList();
		// 2.0查询计费信息
		findCarStateTypeList();
		// 3.0初始化路径
		initPoint1();
		initPoint2();

	}

	// 1.0查询CPInfo信息存储到缓存
	public void findCarInfoList() {
		List<CarInfo> carList = carOperationService.findCarInfo();
		for (int i = 0; i < carList.size(); i++) {
			String key = carList.get(i).getCarId();
			carMap.put(key,carList.get(i));
		}
		logger.info(carMap.toString());
		logger.info("启动时查询汽车信息");
	}

	// 2.0查询计费信息存储到缓存map
	public void findCarStateTypeList() {
		List<CarStateType> typeList = carOperationService.findCarStateType();
		for (int i = 0; i < typeList.size(); i++) {
			Integer key = typeList.get(i).getId();
			typeMap.put(key, typeList.get(i));
		}
		logger.info(typeMap.toString());
		logger.info("启动时查询状态类型");
		System.out.println("");
	}
	
	public void initPoint1(){
		LLPoint point = new LLPoint();
		point.setLatitude(31.258704);
		point.setLongitude(121.526915);
		pointList1.add(point);
				
		point = new LLPoint();
		point.setLatitude(31.260061);
		point.setLongitude(121.531593);
		pointList1.add(point);
				
		point = new LLPoint();
		point.setLatitude(31.263510);
		point.setLongitude(121.528975);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.266114);
		point.setLongitude(121.527344);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.271451);
		point.setLongitude(121.538717);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.277833);
		point.setLongitude(121.534576);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.281180);
		point.setLongitude(121.538471);
		pointList1.add(point);
	}
	
	
	public void initPoint2(){
		
		/*
		31.257080 121.524180
		31.256457 121.517828
		31.256548 121.511713
		31.257796 121.507722
		31.256530 121.503795
		31.259291 121.500480
		
		*/
		LLPoint point = new LLPoint();
		point.setLatitude(31.258704);
		point.setLongitude(121.526915);
		pointList1.add(point);
				
		point = new LLPoint();
		point.setLatitude(31.257080);
		point.setLongitude(121.524180);
		pointList1.add(point);
				
		point = new LLPoint();
		point.setLatitude(31.256457);
		point.setLongitude(121.517828);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.256548);
		point.setLongitude(121.511713);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.256530);
		point.setLongitude(121.507722);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.259291);
		point.setLongitude(121.503795);
		pointList1.add(point);
		
		point = new LLPoint();
		point.setLatitude(31.281180);
		point.setLongitude(121.500480);
		pointList1.add(point);
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

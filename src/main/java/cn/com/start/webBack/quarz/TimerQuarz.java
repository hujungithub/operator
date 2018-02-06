/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: TimerTask.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.quarz
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 下午1:40:44
 * @version: V1.0  
 */
package cn.com.start.webBack.quarz;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import cn.com.start.DPF.entity.WebAlarmRecord;
import cn.com.start.webBack.controller.JsonController;
import cn.com.start.webBack.entity.WebAlarmOperation;
import cn.com.start.webBack.service.JpushService;
import cn.com.start.webBack.service.JsonService;


/**
 * @ClassName: TimerTask
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 下午1:40:44
 */
public class TimerQuarz extends TimerTask {

	/**
	 * @Title: run
	 * @Description: TODO
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		JsonService jsonService = (JsonService) SpringInit.getApplicationContext().getBean("jsonService");
		JpushService jpushService = (JpushService) SpringInit.getApplicationContext().getBean("jpushService");
		List<WebAlarmOperation> list = jsonService.findAll();
		if(list != null) {
			WebAlarmOperation webAlarmOperation = new WebAlarmOperation();
			for (int i = 0; i<list.size(); i++) {
				System.out.println("状态是="+list.get(i).getSTATUS());
				try {
					if (list.get(i).getSTATUS()==0) {
						webAlarmOperation = list.get(i);
						jpushService.autoPushSystemMessage(webAlarmOperation);
						System.out.println("推送了第"+(i+1)+"条数据");
						Thread.sleep(5000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			System.out.println("开始执行定时任务");
		}
	}
}

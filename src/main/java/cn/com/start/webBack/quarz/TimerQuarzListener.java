/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: TimerQuarzListener.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.quarz
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月25日 上午9:09:05
 * @version: V1.0  
 */
package cn.com.start.webBack.quarz;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName: TimerQuarzListener
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月25日 上午9:09:05
 */
public class TimerQuarzListener implements ServletContextListener{

	private Timer timer = null;
	/**
	 * @Title: contextInitialized
	 * @Description: TODO
	 * @param sce
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO 初始化方法
		timer = new Timer(true);
		event.getServletContext().log("定时任务已启动");
		timer.scheduleAtFixedRate(new TimerQuarz(), 5 * 1000, 100 * 1000);
	}

	/**
	 * @Title: contextDestroyed
	 * @Description: TODO
	 * @param sce
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO 销毁定时器
		 if (timer != null) {
	            timer.cancel();
	            event.getServletContext().log("定时器销毁");
	        }
	}

}

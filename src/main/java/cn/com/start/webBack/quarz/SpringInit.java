/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: SpringInit.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.quarz
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月25日 上午11:05:46
 * @version: V1.0  
 */
package cn.com.start.webBack.quarz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @ClassName: SpringInit
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月25日 上午11:05:46
 */
public class SpringInit implements ServletContextListener{

	private static WebApplicationContext springContext;

    public SpringInit() {
        super();
    }
    
	
	/**
	 * @Title: contextInitialized
	 * @Description: TODO
	 * @param sce
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	}

	/**
	 * @Title: contextDestroyed
	 * @Description: TODO
	 * @param sce
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	public static ApplicationContext getApplicationContext() {
        return springContext;

    }

}

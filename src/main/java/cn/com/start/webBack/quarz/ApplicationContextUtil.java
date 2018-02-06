/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ApplicationContextUtil.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.quarz
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月25日 上午11:39:51
 * @version: V1.0  
 */
package cn.com.start.webBack.quarz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName: ApplicationContextUtil
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月25日 上午11:39:51
 */
public class ApplicationContextUtil implements ApplicationContextAware{

	 private static ApplicationContext applicationContext;
	 
     public static ApplicationContext getApplicationContext() {
        return applicationContext;
     }
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		applicationContext = ApplicationContextUtil.applicationContext;
	}
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

}

package cn.com.start.DPF.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring信息的工具类
 * 
 * @author Administrator
 * 
 */
public final class ServiceUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		if (ServiceUtil.applicationContext == null) {
			ServiceUtil.applicationContext = applicationContext;
			System.out
					.println("========ApplicationContext配置成功,在普通类可以通过调用ServiceUtil.getAppContext()获取applicationContext对象,applicationContext="
							+ applicationContext + "========");
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}
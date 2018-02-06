package cn.com.start.webBack.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 
 * <p>Title: CustomFormAuthenticationFilter</p>
 * <p>Description:自定义FormAuthenticationFilter，认证之前实现 验证码校验 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-25下午4:53:15
 * @version 1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	//原FormAuthenticationFilter的认证方法
	private final String successUrl = "/first.action";  
	@Override  
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {  
        WebUtils.issueRedirect(request, response, successUrl, null, true);  
    }  

		
}

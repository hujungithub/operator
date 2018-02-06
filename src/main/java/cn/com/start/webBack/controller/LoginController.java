package cn.com.start.webBack.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.webBack.entity.ActiveUser;
import cn.com.start.webBack.service.LoginService;
//注解，特殊的controller
@Controller
public class LoginController extends LoggerController {
	
	@Autowired
	private LoginService loginService;

	/**
	 * 登录页面验证
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/login") 
	//从pagelogin页面传来form表单
	public String findAdminByPage(Model model,HttpServletRequest request) throws Exception {
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				model.addAttribute("result", "aaa");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName) || AuthenticationException.class.getName().equals(exceptionClassName)) {
				model.addAttribute("result", "bbb");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return "/jsp/pagelogin.jsp";
	}
	
	//系统首页
	@RequestMapping("/first")
	public String first(Model model,HttpServletRequest request)throws Exception{
		
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String LOGINTIME = format.format(new Date());
		//更新登录时间
		loginService.setTime(activeUser.getUSERID(), LOGINTIME);
		//通过model传到页面
		model.addAttribute("activeUser", activeUser);
		
		request.getSession().setAttribute("username", activeUser.getUSERNAME());
		request.getSession().setAttribute("password", activeUser.getPASSWORD());
		request.getSession().setAttribute("userid", activeUser.getUSERID());
		request.getSession().setAttribute("logintime", activeUser.getLOGINTIME());
		request.getSession().setAttribute("operatorid", activeUser.getOPERATORID());
		
		
		return "//jsp/index.jsp";
	}
}


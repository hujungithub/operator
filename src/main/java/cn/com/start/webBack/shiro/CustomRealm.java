package cn.com.start.webBack.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.start.webBack.entity.ActiveUser;
import cn.com.start.webBack.entity.SysPermission;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.service.LoginService;

/**
 * 
 * <p>
 * Title: CustomRealm
 * </p>
 * <p>
 * Description:自定义realm
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2015-3-23下午4:54:47
 * @version 1.0
 */
public class CustomRealm extends AuthorizingRealm {
	
	//注入service
	@Autowired
	private LoginService loginService;
	
	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}
	
	//realm的认证方法，从数据库查询用户信息
		@Override
		protected AuthenticationInfo doGetAuthenticationInfo(
				AuthenticationToken token) throws AuthenticationException {
			
			// token是用户输入的用户名和密码 
			// 第一步从token中取出用户名
			String userCode = (String) token.getPrincipal();
			// 第二步：根据用户输入的userCode从数据库查询
			SysUser sysUser = null;
			try {
				sysUser = loginService.querySysUserInfo(userCode);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 如果查询不到返回null
			if(sysUser==null){//
				return null;
			}
			// 从数据库查询到密码
			String password = sysUser.getPASSWORD();
			
			//盐
			String salt = sysUser.getSALT();

			// 如果查询到返回认证信息AuthenticationInfo
			
			//activeUser就是用户身份信息
			ActiveUser activeUser = new ActiveUser();
			
			activeUser.setUSERID(sysUser.getID());
			activeUser.setUSERCODE(sysUser.getUSERCODE());
			activeUser.setUSERNAME(sysUser.getUSERNAME());
			activeUser.setOPERATORID(sysUser.getOPERATORID());
			activeUser.setLOGINTIME(sysUser.getLOGINTIME());
			activeUser.setPASSWORD(sysUser.getPASSWORD());
			//..
			
			/*//根据用户id取出菜单
			List<SysPermission> menus  = null;
			try {
				//通过service取出菜单 
				menus = loginService.findMenuListByUserId(String.valueOf(userInfo.getUserId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//将用户菜单 设置到activeUser
			activeUser.setMENUS(menus);*/

			//将activeUser设置simpleAuthenticationInfo
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
					activeUser, password,ByteSource.Util.bytes(salt), this.getName());

			return simpleAuthenticationInfo;
		}
		
		

		// 用于授权
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(
				PrincipalCollection principals) {
			
			//从 principals获取主身份信息
			//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
			ActiveUser activeUser =  (ActiveUser) principals.getPrimaryPrincipal();
			
			//根据身份信息获取权限信息
			//从数据库获取到权限数据
			List<SysPermission> permissionList = null;
			SysUser sysUser = new SysUser();
			sysUser.setID(activeUser.getUSERID());
			try {
				permissionList = loginService.findPermissionListByUserId(sysUser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//单独定一个集合对象 	
			List<String> permissions = new ArrayList<String>();
			if(permissionList!=null){
				for(SysPermission sysPermission:permissionList){
					//将数据库中的权限标签 符放入集合
					permissions.add(sysPermission.getPercode());
				}
			}
			//查到权限数据，返回授权信息(要包括 上边的permissions)
			SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
			simpleAuthorizationInfo.addStringPermissions(permissions);

			return simpleAuthorizationInfo;
		}
		
		//清除缓存
		public void clearCached() {
			PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
			super.clearCache(principals);
		}
		


	}

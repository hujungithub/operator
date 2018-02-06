package cn.com.start.webBack.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.Permission;
import cn.com.start.webBack.entity.RolePermission;
import cn.com.start.webBack.entity.SysRole;
import cn.com.start.webBack.entity.SysUser;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.SystemService;
import cn.com.start.webBack.shiro.CustomRealm;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.MD5Util;
import cn.com.start.webBack.util.RandomUtil;
//注解，特殊的controller
@Controller
@RequestMapping("/system")
public class SystemController  {
	
	@Autowired
	private SystemService systemService;
	@Autowired
	public OperatorService operatorService;
	@Autowired
	public CustomRealm customRealm;
	
	/**
	 * 查询所有的用户信息
	 * @param request
	 * @param response
	 * @param operatorloginid
	 * @throws IOException
	 */
	@RequestMapping("/querySysUser")
	public void querySysUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		SysUser sysUser = new SysUser();
		List<SysUser> userList = systemService.querySysUser(sysUser);
		List<SysRole> roleList = new ArrayList<SysRole>();
		for(int i=0;i<userList.size();i++){
			StringBuffer s = new StringBuffer();
			roleList=systemService.queryRoleByUserId(userList.get(i).getID());
			for(int j=0;j<roleList.size();j++){
				if(j==0){
					s.append(roleList.get(j).getNAME());
				}else{
					s.append(","+roleList.get(j).getNAME());
				}
			}
			userList.get(i).setNAME(s.toString());
		}
		/*if(cpInfoList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", cpInfoList);
		}*/
		ReDto.detail.put("page", userList);
		new JsonUtil().send(response, ReDto);
	}
	
	/**
	 * 根据id删除用户信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteSysUserByIds")
	public void deleteSysUserByIds(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String id = request.getParameter("id");
		String ids[] = id.substring(1).split(",");
		int a = systemService.deleteSysUserByIds(ids);
		if(a > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功！";		
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！";	
		}
		new JsonUtil().send(response, ReDto);
	}
	
	/**
	 * 根据id查询用户信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/querySysUserById")
	public void querySysUserById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		SysUser sysUser = new SysUser();
		String id = request.getParameter("id");
		sysUser.setID(id);
		List<SysUser> list = systemService.querySysUser(sysUser);
		request.setAttribute("list", list);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @param sysUser
	 * @throws IOException
	 */
	@RequestMapping("/addSysUser")
	public void addSysUser(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) throws IOException {
		String salt = new RandomUtil().getStringRandom(6);
		String pwd = new MD5Util().MD5pwd(sysUser.getPASSWORD(), salt, 1);
		sysUser.setSALT(salt);
		sysUser.setPASSWORD(pwd);
		sysUser.setLOCKED("0");
		int a = systemService.addSysUser(sysUser);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "添加成功！";
		}else{
			DELETERESULT = "添加失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	/**
	 * 更新用户信息
	 * @param request
	 * @param response
	 * @param sysUser
	 * @throws IOException
	 */
	@RequestMapping("/updateSysUser")
	public void updateSysUser(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) throws IOException {
		String pwd = new MD5Util().MD5pwd(sysUser.getPASSWORD(), sysUser.getSALT(), 1);
		sysUser.setPASSWORD(pwd);
		int a = systemService.updateSysUser(sysUser);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "修改成功！";
		}else{
			DELETERESULT = "修改失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	
	
	
	
	
	
	
	/**
	 * 查询所有的角色信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/querySysRoleInfo")
	public void querySysRoleInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		SysRole sysRole = new SysRole();
		List<SysRole> list = systemService.querySysRole(sysRole);
		/*if(cpInfoList.size() == 0){
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "查找失败！";			
		}else{
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "查找成功！";
			ReDto.detail.put("page", cpInfoList);
		}*/
		ReDto.detail.put("page", list);
		new JsonUtil().send(response, ReDto);
	}
	
	/**
	 * 根据id删除角色
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/deleteSysRoleByIds")
	public void deleteSysRoleByIds(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		String id = request.getParameter("id");
		String ids[] = id.substring(1).split(",");
		int a = systemService.deleteSysRoleByIds(ids);
		if(a > 0){
			ReDto.returnCode = 0;
			ReDto.errorCode = "0";
			ReDto.message = "删除成功！";		
		}else{
			ReDto.returnCode = 1;
			ReDto.errorCode = "1";
			ReDto.message = "删除失败！";	
		}
		new JsonUtil().send(response, ReDto);
	}
	
	@RequestMapping("/querySysRoleById")
	public void querySysRoleById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		SysRole sysRole = new SysRole();
		String id = request.getParameter("id");
		sysRole.setID(id);
		List<SysRole> list = systemService.querySysRole(sysRole);
		request.setAttribute("list", list);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加角色
	 * @param request
	 * @param response
	 * @param sysRole
	 * @throws IOException
	 */
	@RequestMapping("/addSysRole")
	public void addSysRole(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) throws IOException {
		int a = systemService.addSysRole(sysRole);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "添加成功！";
		}else{
			DELETERESULT = "添加失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	@RequestMapping("/updateSysRole")
	public void updateSysRole(HttpServletResponse response,SysRole sysRole) throws IOException {
		int a = systemService.updateSysRole(sysRole);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "修改成功！";
		}else{
			DELETERESULT = "修改失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询出所有运营商
	 * @param request
	 * @param response
	 * @param operatorloginid
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/queryAllOperator")
	public void queryAllOperator(HttpServletRequest request,HttpServletResponse response,@RequestParam String operatorloginid) throws JsonGenerationException, JsonMappingException, IOException {
		List<OperatorInfo> list = operatorService.findNewOperator(operatorloginid);
		request.setAttribute("list", list);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据用户id查询用户所有角色
	 * @param request
	 * @param response
	 * @param operatorloginid
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/queryRoleByUserId")
	public void queryRoleByUserId(HttpServletRequest request,HttpServletResponse response,@RequestParam String id) throws JsonGenerationException, JsonMappingException, IOException {
		List<SysRole> list = systemService.queryRoleByUserId(id);
		request.setAttribute("list", list);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 根据用户id查询用户没有角色
	 * @param request
	 * @param response
	 * @param id
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/queryNotRoleByUserId")
	public void queryNotRoleByUserId(HttpServletRequest request,HttpServletResponse response,@RequestParam String id) throws JsonGenerationException, JsonMappingException, IOException {
		List<SysRole> list = systemService.queryNotRoleByUserId(id);
		request.setAttribute("list", list);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 删除用户角色中间表
	 * @param request
	 * @param response
	 * @param sysRole
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/deleteSysUserRole")
	public void deleteSysUserRole(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) throws JsonGenerationException, JsonMappingException, IOException {
		int a = systemService.deleteSysUserRole(sysRole);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "删除成功！";
		}else{
			DELETERESULT = "删除失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加用户角色中间表
	 * @param request
	 * @param response
	 * @param sysRole
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/addUserRole")
	public void addUserRole(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) throws JsonGenerationException, JsonMappingException, IOException {
		int a = systemService.addUserRole(sysRole);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "添加成功！";
		}else{
			DELETERESULT = "添加失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询所有的权限
	 * @param request
	 * @param response
	 * @param sysUser
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping("/queryAllPermission")
	public void queryAllPermission(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) throws JsonGenerationException, JsonMappingException, IOException {
		List<Permission> list = new ArrayList<Permission>();
		List<Permission> list2 = new ArrayList<Permission>();
		try {
			list = systemService.queryPermissionByUserId(sysUser);
			list2 = systemService.queryAllPermission();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list2.removeAll(list);
		for(int i=0;i<list.size();i++){
			list.get(i).setState(true);
		}
		list2.addAll(list);
		Collections.sort(list2, new Comparator<Permission>() {
			@Override
			public int compare(Permission o1, Permission o2) {
				return o1.getId()-o2.getId();
			}
		});
		request.setAttribute("list", list2);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list2);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
	
	
	@RequestMapping("/addPermission")
	public void addPermission(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		String DELETERESULT = null;
		String pid = request.getParameter("pid");
		String pids[] = pid.substring(1).split(",");
		String id = request.getParameter("id");
		SysRole sysRole = new SysRole();
		sysRole.setID(id);
		int a = systemService.deletePermission(sysRole);
		List<RolePermission> list = new ArrayList<RolePermission>();
		for(int i=0;i<pids.length;i++){
			RolePermission r = new RolePermission();
			r.setROLEID(id);
			r.setPERMISSIONID(pids[i]);
			list.add(r);
		}
		int b = systemService.addPermission(list);
		
		if(b > 0){
			DELETERESULT = "修改成功！";
			customRealm.clearCached();
		}else{
			DELETERESULT = "修改失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
	}
	
	
	@RequestMapping("/updatePwd")
	public void updatePwd(HttpServletRequest request,HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String userId=(String) request.getSession().getAttribute("userid");
		SysUser sysUser = new SysUser();
		sysUser.setID(userId);
		List<SysUser> userList = systemService.querySysUser(sysUser);
		String salt = userList.get(0).getSALT();
		
		String pwd = new MD5Util().MD5pwd(pwd1, salt, 1);
		String newpwd =new MD5Util().MD5pwd(pwd2, salt, 1);
		int DELETERESULT = 0;
		if(pwd.equals(userList.get(0).getPASSWORD())){
			sysUser.setPASSWORD(newpwd);
			int a=systemService.updateSysUser(sysUser);
			if(a>0){
				DELETERESULT=1;
			}else{
				DELETERESULT=2;
			}
		}else{
			DELETERESULT = 3;
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();
		
		
		
		/*int a = systemService.addUserRole(sysRole);
		String DELETERESULT = null;
		if(a == 1){
			DELETERESULT = "添加成功！";
		}else{
			DELETERESULT = "添加失败！";
		}
		PrintWriter out = response.getWriter();
		out.print(DELETERESULT);
		out.flush();
		out.close();*/
	}
	
	
}


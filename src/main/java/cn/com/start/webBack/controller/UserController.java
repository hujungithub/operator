package cn.com.start.webBack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.webBack.dto.FindUserInfoDto;
import cn.com.start.webBack.dto.UpdateCSDto;
import cn.com.start.webBack.dto.UserInfoDto;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.RoleInfo;
import cn.com.start.webBack.entity.UserInfo;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.service.UserService;
import cn.com.start.webBack.util.DeleteFileUtil;
import cn.com.start.webBack.util.JsonUtil;
import cn.com.start.webBack.util.POIUtil;
import cn.com.start.webBack.util.Page;

@Controller
@RequestMapping("/user")
public class UserController extends LoggerController{

	@Autowired
	private UserService userService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private RoleactionService roleactionService;

	/**
	 * 第一次进入 查询管理员用户
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/findUserFirst")
	public void findUserFirst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		JsonReDto ReDto = new JsonReDto();
		FindUserInfoDto userInfoDto = new FindUserInfoDto();
		String operatorloginid = request.getParameter("operatorid");// 获取登录用户运营商id
		String roleloginid = request.getParameter("roleid");// 获取登录用户角色id
		int bosscount = userService.findbosscount();// 判断boss运营商是否存在超级管理员
		int count = userService.findcount(operatorloginid);// 判断运营商下是否存在管理员
		userInfoDto.setPageNow(1);
		userInfoDto.setPageSize(10);
		userInfoDto.setOPERATORLOGINID(operatorloginid);
		userInfoDto.setROLELOGINID(roleloginid);
		List<UserInfoDto> onePageAdminList = userService.showUserByPage(userInfoDto);
		List<RoleInfo> roleList = new ArrayList<RoleInfo>();
		// boss为34
		if ("34".equals(operatorloginid)) {
			if (bosscount == 1) {
				roleList = userService.findRoleList(roleloginid);
			} else {
				roleList = userService.findAllRoleList(roleloginid);
			}
		} else {
			if (count == 1) {
				roleList = userService.findRoleList(roleloginid);
			} else {
				roleList = userService.findAllRoleList(roleloginid);
			}
		}
		List<OperatorInfo> operList = operatorService
				.findNewOperator(operatorloginid);// 获取boss及其下属运营商
		String roleaction = roleactionService.findroleaction(roleloginid);// 登录用户角色能进行的操作
		ReDto.detail.put("page",onePageAdminList);
		send(response, ReDto);
//		request.setAttribute("page", page);
//		request.setAttribute("roleList", roleList);
//		request.setAttribute("operList", operList);
//		request.setAttribute("roleaction", roleaction);
//		return "//jsp/systemmanage/systemmanage.jsp";
	}

//	/**
//	 * 保存查询条件 分页查询 切换页码
//	 * 
//	 * @param request
//	 * @param response
//	 * @param userInfoDto
//	 * @throws IOException
//	 */
//	@RequestMapping("/findUserSaveData")
//	public String findUserSaveData(@RequestParam Integer pageSize,
//			@RequestParam Integer pageNow, FindUserInfoDto userInfoDto)
//			throws IOException {
//		userInfoDto.setPageNow(pageNow);
//		userInfoDto.setPageSize(pageSize);
//		Page page = userService.showUserByPage(userInfoDto);
//		String json = JsonUtil.toJson(page);
//		System.out.println("finuser===="+json);
//		return json;
//	}

	/**
	 * 新增管理员用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addAdmin(HttpServletRequest request, UserInfo user) {
		user.setOperatorId(request.getParameter("operatorid"));
		userService.addUser(user);
		return "/user/findUserFirst";
	}

	/**
	 * 查询修改信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateAdminById")
	public void updateAdminById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ADMINID = request.getParameter("USERID");
		String operatorloginid = request.getParameter("operatorloginid");
		String roleloginid = request.getParameter("roleloginid");// 获取登录用户角色id
		System.out.println("role----" + roleloginid);
		// 该管理员信息
		UserInfoDto userInfoDto = userService.findAdminById(ADMINID);
		// 角色信息
		List<RoleInfo> roleList = userService.findAllRoleList(roleloginid);
		// 运营商
		List<OperatorInfo> operList = operatorService.findOperator();
		List<OperatorInfo> newoperList = operatorService
				.findNewOperator(operatorloginid);// 获取boss及其下属运营商
		UpdateCSDto updateCSDto = new UpdateCSDto();
		updateCSDto.setUserInfoDto(userInfoDto);
		updateCSDto.setRoleList(roleList);
		updateCSDto.setOperList(newoperList);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(updateCSDto);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}

	/**
	 * 修改查询信息
	 * 
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping("/updateAdmin")
	public String updateAdmin(HttpServletRequest request, UserInfo admin) {
		admin.setValidFlag(true);
		int flag = userService.updateById(admin);
		request.setAttribute("updateFlag", 1);
		request.setAttribute("flag", flag);
		return "/user/findUserFirst";
	}

	// 按id删除管理员
	@RequestMapping("/deleteById")
	public String deleteById(HttpServletRequest request) {
		String USERID = request.getParameter("USERID");
		String USERIDS[] = USERID.substring(1).split(",");
		int count = userService.deleteById(USERIDS);
		return "/user/findUserFirst";
	}

	/**
	 * 数据导出
	 * 
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/userExport")
	@ResponseBody
	public void Export(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		List<UserInfoDto> adminDtos = userService.findAllAdmin();
		List<Map<String, Object>> headInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> itemMap = new HashMap<String, Object>();

		itemMap.put("title", "用户名");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH1");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "登录账号");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH2");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "密码");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH3");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "权限");
		itemMap.put("columnWidth", 25);
		itemMap.put("dataKey", "XH4");
		headInfoList.add(itemMap);

		itemMap = new HashMap<String, Object>();
		itemMap.put("title", "最近登录时间");
		itemMap.put("columnWidth", 50);
		itemMap.put("dataKey", "XH5");
		headInfoList.add(itemMap);

		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> dataItem = null;
		for (int i = 0; i < adminDtos.size(); i++) {
			dataItem = new HashMap<String, Object>();
			UserInfoDto adminDto1 = adminDtos.get(i);
			dataItem.put("XH1", "" + adminDto1.getUSERNAME());
			dataItem.put("XH2", "" + adminDto1.getLOGINID());
			dataItem.put("XH3", "" + adminDto1.getLOGINPWD());
			dataItem.put("XH4", "" + adminDto1.getROLENAME());
			dataItem.put("XH5", "" + adminDto1.getLOGINTIME());
			dataList.add(dataItem);
		}
		POIUtil.exportExcel2FilePath("运营商信息", "D://运营商信息.xls", headInfoList,
				dataList);
		download("D://运营商信息.xls", response);
		DeleteFileUtil.deleteFile("D://运营商信息.xls");// 删除保存的excel文件
	}
	
	private <T> void send(HttpServletResponse response, T ReDto)
			throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		logger.info(json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();

	}
}

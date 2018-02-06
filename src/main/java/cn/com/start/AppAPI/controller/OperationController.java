package cn.com.start.AppAPI.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.com.start.AppAPI.dto.JsonReDto;
import cn.com.start.AppAPI.entity.CPFAI;
import cn.com.start.AppAPI.entity.FaultOrder;
import cn.com.start.AppAPI.service.FaultPileService;
import cn.com.start.AppAPI.util.EmptyUtil;
import cn.com.start.AppAPI.util.GetLLByLoc;

// 运维管理程序接口
@Controller
@RequestMapping("/operation")
public class OperationController {

	@Autowired
	private FaultPileService faultPileService;

	// 获取附近故障桩列表
	@RequestMapping("/getNearFaultPile")
	public void getNearFaultPile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		//city未使用
		String city = request.getParameter("city");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");

		// 通过经纬度处理
		if (EmptyUtil.isStringEmpty(city)
				&& (EmptyUtil.isStringEmpty(longitude) && EmptyUtil.isStringEmpty(latitude))) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[city]or[longitude]or[latitude]";
		} else {
			if (!EmptyUtil.isStringEmpty(city)) {
				// 通过市名求经纬度
				String lonlat[] = GetLLByLoc.getCoordinate(city);
				longitude = lonlat[0];
				latitude = lonlat[1];
			}
			System.out.println("city:" + city);
			
			
			System.out.println("经度:" + longitude + "纬度:" + latitude);
			List<CPFAI> nearStationList = faultPileService.findNearFaultPile(longitude, latitude);
			if (nearStationList.isEmpty()) {
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0002";
				ReDto.message = "no data found!";
			} else {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0000";
				ReDto.message = "get near station success ";
				ReDto.detail = (HashMap<String, List<?>>) nearStationList;
			}
		}
		this.send(response, ReDto);
	}

	@RequestMapping("/upload4")
	public void upload4(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		request.setCharacterEncoding("utf-8"); // 设置编码
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = "D:/testapp/";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		factory.setRepository(new File(path));
		// 设置 缓存的大小
		factory.setSizeThreshold(1024 * 1024);
		// 文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
			// System.out.println("好烦" + list.toString());
			for (FileItem item : list) {
				// 获取属性名字
				// String name = item.getFieldName();
				// System.out.println("普通元素的名字" + item.getFieldName());
				// System.out.println("普通元素的值" + item.getString());
				// 电源
				// 线缆
				// 充电枪
				// 外壳
				// 显示屏
				// 备注

				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					// 获取用户具体输入的字符串,因为表单提交过来的是 字符串类型的
					String orderId = item.getString();
					String content = item.getString();
					int flag = faultPileService.updateOrderFirst(orderId, content);
				} else {
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);
					// 写到磁盘上
					item.write(new File(path, filename));// 第三方提供的
					System.out.println("上传成功：" + filename);
					response.getWriter().print(filename);// 将路径返回给客户端
				}
			}
		} catch (Exception e) {
			System.out.println("上传失败");
			response.getWriter().print("上传失败：" + e.getMessage());
		}

	}

	// 点击接单生成修理订单 返回订单id
	@RequestMapping("/setOrderFirst")
	public void setOrderFirst(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String cpId = request.getParameter("cpId"); // 桩id
		String rmId = request.getParameter("rmId"); // 维修人员id
		String beginTime = request.getParameter("beginTime"); // 开始维修时间
		if (cpId.isEmpty() || rmId.isEmpty() || beginTime.isEmpty()) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[cpId]or[rmId]or[beginTime]";
		} else {
			Format format = new SimpleDateFormat("yyyyMMdd");
			String formatDate = format.format(new Date());
			String orderId = new StringBuffer().append(cpId).append(formatDate)
					.append(1000 + (int) (Math.random() * (9999 - 1000) + 1)).toString();
			FaultOrder order = new FaultOrder();
			order.setCPID(cpId);
			order.setREPAIRMANID(rmId);
			order.setID(orderId);
			order.setBEGINTIME(beginTime);
			order.setSTATE("0");
			System.out.println("haha**************" + order.toString());
			int flag = faultPileService.addFaultOrder(order);
			if (flag == 1) {
				// 有人接单 那么改变故障桩状态
				int temp = faultPileService.updateFAIById(cpId);
			}
			List<String> orderIdList = new ArrayList<String>();
			orderIdList.add(orderId);
			Map<String, String> map = new HashMap<String, String>();
			map.put("orderId", orderId);
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			list.add(map);
			if (flag == 1) {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0000";
				ReDto.message = "set order first success";
				ReDto.detail = (HashMap<String, List<?>>) list;
			} else {
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0002";
				ReDto.message = "set order first defeat";
			}
		}
		this.send(response, ReDto);
	}

	// 提交信息和图片 修改订单信息 将订单信息结束时间加上，状态改为等待审核 后台计算价格加入其中。
	// //////////////////////////
	// //////////////////////////
	// //////////////////////////
	@RequestMapping("/upload")
	public String upload2(HttpServletRequest request, @RequestParam("files") MultipartFile[] files)
			throws IllegalStateException, IOException {
		System.out.println("sdfafa");
		// 创建一个通用的多部分解析器
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				String myFileName = file.getOriginalFilename();
				// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
				if (myFileName.trim() != "") {
					System.out.println(myFileName);
					// 重命名上传后的文件名
					String fileName = "demoUpload" + file.getOriginalFilename();
					// 定义上传路径
					String path = "D:/testapp/" + fileName;
					File localFile = new File(path);
					file.transferTo(localFile);
				}
			}
		}
		String zz = request.getParameter("zzz"); // 配件
		String beizhu = request.getParameter("备注"); // 备注
		// 修改状态
		// int flag = faultPileService.updateOrderFirst(beizhu);

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		List<MultipartFile> fileaaa = ((MultipartRequest) request).getFiles("files");
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			System.out.println("dfsad" + request.getParameter("zz"));
			System.out.println("sdfsad" + multiRequest.getParameter("zz"));
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = "demoUpload" + file.getOriginalFilename();
						// 定义上传路径
						String path = "D:/" + fileName;
						File localFile = new File(path);
						file.transferTo(localFile);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
		}
		return "scsdfsd";
	}

	// 返回订单列表 三种列表 我的接单 我的已维修等待确认 我的已经完成的任wu
	@RequestMapping("/getMyOperList")
	public void getMyOperList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonReDto ReDto = new JsonReDto();
		String rmId = request.getParameter("rmId"); // 修理人员id
		String type = request.getParameter("type"); // 任务类型
		if (EmptyUtil.isStringEmpty(rmId) || EmptyUtil.isStringEmpty(type)) {
			ReDto.returnCode = 2;
			ReDto.errorCode = "E0001";
			ReDto.message = "You should set parament[rmId]";
		} else {
			List<CPFAI> zzList = new ArrayList<CPFAI>();
			if ("0".equals(type)) {
				zzList = faultPileService.findReadyList(rmId);
			} else if ("1".equals(type)) {
				zzList = faultPileService.findIsList(rmId);
			} else if ("2".equals(type)) {
				zzList = faultPileService.findDoneList(rmId);
			}
			if (zzList.isEmpty()) {
				ReDto.returnCode = 1;
				ReDto.errorCode = "E0002";
				ReDto.message = "no data found!";
			} else {
				ReDto.returnCode = 0;
				ReDto.errorCode = "E0000";
				ReDto.message = "get cs info success ";
				ReDto.detail = (HashMap<String, List<?>>) zzList;
			}
		}
		this.send(response, ReDto);
	}

	// 将json数据返回页面
	public static void send(HttpServletResponse response, JsonReDto ReDto) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReDto);
		System.out.println("经纬度" + json);
		// 向页面返回json数据
		out.print(json);
		out.flush();
		out.close();
	}
}

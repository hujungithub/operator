package cn.com.start.AppAPI.test;
//package cn.com.cncsys.test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadBase;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//@Controller
//@RequestMapping("/file")
//public class test4Controller {
//
//	private Logger logger = LogManager.getLogger("test4Controller");
//
//	@RequestMapping("/upload")
//	public String addUser(@RequestParam("file") CommonsMultipartFile[] files,
//			HttpServletRequest request) {
//
//		for (int i = 0; i < files.length; i++) {
//			System.out.println("fileName---------->"
//					+ files[i].getOriginalFilename());
//
//			if (!files[i].isEmpty()) {
//				int pre = (int) System.currentTimeMillis();
//				try {
//					// 拿到输出流，同时重命名上传的文件
//					FileOutputStream os = new FileOutputStream("D:/"
//							+ new Date().getTime()
//							+ files[i].getOriginalFilename());
//					// 拿到上传文件的输入流
//					FileInputStream in = (FileInputStream) files[i]
//							.getInputStream();
//
//					// 以写字节的方式写文件
//					int b = 0;
//					while ((b = in.read()) != -1) {
//						os.write(b);
//					}
//					os.flush();
//					os.close();
//					in.close();
//					int finaltime = (int) System.currentTimeMillis();
//					System.out.println(finaltime - pre);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("上传出错");
//				}
//			}
//		}
//		return "/success";
//	}
//
//	@RequestMapping("/upload2")
//	public String upload2(HttpServletRequest request,
//			HttpServletResponse response) throws IllegalStateException,
//			IOException {
//		// 创建一个通用的多部分解析器
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//				request.getSession().getServletContext());
//		// 判断 request 是否有文件上传,即多部分请求
//		if (multipartResolver.isMultipart(request)) {
//			// 转换成多部分request
//			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//			// 取得request中的所有文件名
//			System.out.println("dfsad" + request.getParameter("zz"));
//			System.out.println("sdfsad" + multiRequest.getParameter("zz"));
//			Iterator<String> iter = multiRequest.getFileNames();
//			System.out.println("文件长度" + iter.toString());
//			while (iter.hasNext()) {
//				// 记录上传过程起始时的时间，用来计算上传时间
//				int pre = (int) System.currentTimeMillis();
//				// 取得上传文件
//				MultipartFile file = multiRequest.getFile(iter.next());
//				if (file != null) {
//					// 取得当前上传文件的文件名称
//					String myFileName = file.getOriginalFilename();
//					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
//					if (myFileName.trim() != "") {
//						System.out.println(myFileName);
//						// 重命名上传后的文件名
//						String fileName = "demoUpload"
//								+ file.getOriginalFilename();
//						// 定义上传路径
//						String path = "D:/" + fileName;
//						File localFile = new File(path);
//						file.transferTo(localFile);
//					}
//				}
//				// 记录上传该文件后的时间
//				int finaltime = (int) System.currentTimeMillis();
//				System.out.println(finaltime - pre);
//			}
//
//		}
//		return "/success";
//	}
//
//	@RequestMapping("/upload3")
//	public void upload3(HttpServletRequest request, HttpServletResponse response)
//			throws IllegalStateException, IOException {
//		System.out.println("进入请求");
//		// 创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录
//		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 5,
//				new File("D:/"));
//		// 设置缓冲区大小为 5M
//		factory.setSizeThreshold(1024 * 1024 * 5);
//		// 创建一个文件上传的句柄
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		System.out.println("没有解析的request"
//				+ ServletFileUpload.isMultipartContent(request));
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//				request.getSession().getServletContext());
//		System.out.println("没有解析的request111"
//				+ multipartResolver.isMultipart(request));
//		// 设置上传文件的整个大小和上传的单个文件大小
//		upload.setSizeMax(1024 * 1024 * 50);
//		upload.setFileSizeMax(1024 * 1024 * 5);
//		String[] fileExts = { "doc", "zip", "rar", "jpg", "txt", "png" };
//		System.out.println("完成设置");
//		try { // 把页面表单中的每一个表单元素解析成一个
//			List<FileItem> items = upload.parseRequest(request);
//			for (FileItem fileItem : items) {
//				System.out.println("获取表单");
//				// 如果是一个普通的表单元素(type不是file的表单元素)
//				if (fileItem.isFormField()) {
//					System.out.println("input内容");
//					System.out.println(fileItem.getFieldName());
//					// 得到对应表单元素的名字
//					System.out.println(fileItem.getString());
//					// 得到表单元素的值
//				} else { // 获取文件的后缀名
//					System.out.println("文件内容");
//					String fileName = fileItem.getName();// 得到文件的名字
//					String fileExt = fileName.substring(
//							fileName.lastIndexOf(".") + 1, fileName.length());
//					if (Arrays.binarySearch(fileExts, fileExt) != -1) {
//						try { // 将文件上传到项目的upload目录并命名，getRealPath可以得到该web项目下包含/upload的绝对路径//
//							fileItem.write(new File(request.getServletContext()
//									.getRealPath("/upload")
//									+ "/"
//									+ UUID.randomUUID().toString()
//									+ "."
//									+ fileExt));
//							// fileItem.write(new File("D:/test2.png"));
//							logger.info("文件上传路径："
//									+ request.getServletContext().getRealPath(
//											"/upload") + "/"
//									+ UUID.randomUUID().toString() + "."
//									+ fileExt);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					} else {
//						System.out.println("该文件类型不能够上传");
//					}
//				}
//			}
//		} catch (FileUploadBase.SizeLimitExceededException e) {
//			System.out.println("整个请求的大小超过了规定的大小...");
//		} catch (FileUploadBase.FileSizeLimitExceededException e) {
//			System.out.println("请求中一个上传文件的大小超过了规定的大小...");
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping("/upload4")
//	public void upload4(HttpServletRequest request, HttpServletResponse response)
//			throws IllegalStateException, IOException {
//		request.setCharacterEncoding("utf-8"); // 设置编码
//		// 获得磁盘文件条目工厂
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		// 获取文件需要上传到的路径
//		String path = "D:/testapp/";
//		File file = new File(path);
//		if (!file.exists()) {
//			file.mkdirs();
//		}
//		factory.setRepository(new File(path));
//		// 设置 缓存的大小
//		factory.setSizeThreshold(1024 * 1024);
//		// 文件上传处理
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		try {
//			// 可以上传多个文件
//			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
//			// System.out.println("好烦" + list.toString());
//			for (FileItem item : list) {
//				// 获取属性名字
//				String name = item.getFieldName();
//				System.out.println("普通元素的名字" + item.getFieldName());
//				System.out.println("普通元素的值" + item.getString());
//				// 如果获取的 表单信息是普通的 文本 信息
//				if (item.isFormField()) {
//					// 获取用户具体输入的字符串,因为表单提交过来的是 字符串类型的
//					String value = item.getString();
//					request.setAttribute(name, value);
//				} else {
//					System.out.println("为什么啊 ");
//					// 获取路径名
//					String value = item.getName();
//					// 索引到最后一个反斜杠
//					int start = value.lastIndexOf("\\");
//					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
//					String filename = value.substring(start + 1);
//					request.setAttribute(name, filename);
//					// 写到磁盘上
//					item.write(new File(path, filename));// 第三方提供的
//					System.out.println("上传成功：" + filename);
//					response.getWriter().print(filename);// 将路径返回给客户端
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("上传失败");
//			response.getWriter().print("上传失败：" + e.getMessage());
//		}
//	}
//
//	@RequestMapping("/toUpload")
//	public String toUpload() {
//		return "/upload";
//	}
//
//}
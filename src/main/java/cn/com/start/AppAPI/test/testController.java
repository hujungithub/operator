//package cn.com.start.AppAPI.test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
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
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
//@Controller
//@RequestMapping("/zz")
//public class testController {
//
//	private Logger logger = LogManager.getLogger("testController");
//
//	@RequestMapping(value = "/111")
//	public String upLoadFile(HttpServletRequest request)
//			throws IllegalStateException, IOException {
//		// @RequestParam("file") MultipartFile file,
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
//				request.getSession().getServletContext());
//		String myFileName = "";
//		String path = "";
//		// 判断 request 是否有文件上传,即多部分请求
//		if (multipartResolver.isMultipart(request)) {
//			// 转换成多部分request
//			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//			// 取得request中的所有文件名
//			Iterator<String> iter = multiRequest.getFileNames();
//			while (iter.hasNext()) {
//				// 取得上传文件
//				MultipartFile f = multiRequest.getFile(iter.next());
//				if (f != null) {
//					// 取得当前上传文件的文件名称
//					myFileName = f.getOriginalFilename();
//					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
//					if (myFileName.trim() != "") {
//						// 定义上传路径
//						path = "D:\\" + myFileName;
//						File localFile = new File(path);
//						f.transferTo(localFile);// 传送文件至上传路径
//					}
//				}
//			}
//		}
//		request.setAttribute("path", path);// 获取文件路径传到页面
//		return "/file/findAllBypage";
//	}
//
//	@RequestMapping("/testPhotoUp")
//	public void testPhotoUp(HttpServletRequest request,
//			HttpServletResponse response) {
//		// 创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录
//		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 5,
//				new File("D:\\temp1"));
//		// 设置缓冲区大小为 5M
//		factory.setSizeThreshold(1024 * 1024 * 5);
//		// 创建一个文件上传的句柄
//		ServletFileUpload upload = new ServletFileUpload(factory);
//
//		// 设置上传文件的整个大小和上传的单个文件大小
//		upload.setSizeMax(1024 * 1024 * 50);
//		upload.setFileSizeMax(1024 * 1024 * 5);
//		String[] fileExts = { "doc", "zip", "rar", "jpg", "txt" };
//		try { // 把页面表单中的每一个表单元素解析成一个
//			List<FileItem> items = upload.parseRequest(request);
//			for (FileItem fileItem : items) {
//				// 如果是一个普通的表单元素(type不是file的表单元素)
//				if (fileItem.isFormField()) {
//					System.out.println(fileItem.getFieldName());
//					// 得到对应表单元素的名字
//					System.out.println(fileItem.getString());
//					// 得到表单元素的值
//				} else { // 获取文件的后缀名
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
//							fileItem.write(new File("D:/test2.png"));
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
//}

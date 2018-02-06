package cn.com.start.AppAPI.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/reter")
public class test3Controller {

	@RequestMapping(value = "/erte")
	public String upLoadFile(HttpServletRequest request)
			throws IllegalStateException, IOException {

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		String myFileName = "";
		String path = "";
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile f = multiRequest.getFile(iter.next());
				if (f != null) {
					// 取得当前上传文件的文件名称
					myFileName = f.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 定义上传路径
						path = "D:\\" + myFileName;
						File localFile = new File(path);
						f.transferTo(localFile);// 传送文件至上传路径
					}
				}
			}
		}
		request.setAttribute("path", path);// 获取文件路径传到页面
		return "/file/findAllBypage";
	}
}

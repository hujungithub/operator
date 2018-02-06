package cn.com.start.webBack.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.service.OperatorService;
import cn.com.start.webBack.service.RoleactionService;
import cn.com.start.webBack.util.ControllerUtil;

public class LoggerController {
	public static Logger logger = LogManager.getLogger("LOG_WEB");

	@Autowired
	public OperatorService operatorService;
	@Autowired
	public RoleactionService roleactionService;
	
	
	
	/**
	 * 
	 * 下载excel文件
	 * 
	 * @param path
	 * @param response
	 */
	public void download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(filename, "utf-8"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/vnd.ms-excel");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

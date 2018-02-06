package cn.com.start.webBack.util;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jxls.transformer.XLSTransformer;

/**
 * Excel生成类.
 */
public class ExcelUtil {
	/**
	 * 根据模板生成Excel文件.
	 * @param templateFileName 模板文件.
	 * @param list 模板中存放的数据.
	 * @param resultFileName 生成的文件.
	 */
	public void createExcel(String templateFileName, List<?> list,List<?> list1, List<?> list2, String resultFileName){
		try { 
			//创建XLSTransformer对象
			XLSTransformer transformer = new XLSTransformer();
			
			//获取java项目编译后根路径
			URL url = this.getClass().getClassLoader().getResource("");
			//得到模板文件路径
			String srcFilePath = url.getPath() + templateFileName;
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("list", list);
			map.put("list1", list1);
			map.put("list2", list2);
			String destFilePath = url.getPath() + resultFileName;
			System.out.println("文件路径----"+destFilePath);
			
			//生成Excel文件
			transformer.transformXLS(srcFilePath, map, destFilePath);
		} catch (Exception e) {
			throw new RuntimeException("error happens...", e);
		}
	}
}
package cn.com.start.AppAPI.dto;

import java.util.HashMap;
import java.util.List;

public class CpinfoFromDeviceDto {
	/** 返回状态码 */
	public int returnCode;

	/** 错误状态码 */
	public String errorCode;

	/** 返回消息 */
	public String message;
	
	public String cpName;

	public int cpType;
	
	public HashMap<String, List<?>> detail = new HashMap<String, List<?>>();
}

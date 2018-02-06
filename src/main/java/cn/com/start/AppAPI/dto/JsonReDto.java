package cn.com.start.AppAPI.dto;

import java.util.HashMap;
import java.util.List;

public class JsonReDto {
	/** 返回状态码 */
	public int returnCode;

	/** 错误状态码 */
	public String errorCode;

	/** 返回消息 */
	public String message;


	// 可能返回的是多个list
	public HashMap<String, List<?>> detail = new HashMap<String, List<?>>();


	/** @Title: message
	 * @Description: TODO
	 * @param string
	 * @return: void
	 */
	public void message(String string) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

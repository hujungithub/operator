/**  
 * Copyright © 2017上海强辰. All rights reserved.
 *
 * @Title: LoggerInfoDto.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.dto
 * @Description: TODO
 * @author: niehangyou  
 * @date: 2017-11-8 下午1:59:56
 * @version: V1.0  
 */
package cn.com.start.webBack.dto;


/**
 * @ClassName: LoggerInfoDto
 * @Description: TODO
 * @author: niehangyou
 * @date: 2017-11-8 下午1:59:56
 */
public class LoggerInfoDto extends BaseFindDto{

	private String OPERATORID;
	private String OPERATORLOGINID;
	private String OPERATORNAME;
	private String FROMTIME;
	private String TOTIME;
	
	private String OPERATINGUSER;//操作员ID
	private String OPERATINGUSERNAME;//操作员名称
	private String OPERATINGTIME;//操作时间
	private String OPERATING;//操作事件
	private String OPERATIONCONTENT;//操作内容
	private String OPERATIONOBJECT;//操作对象
	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}
	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}
	public String getOPERATINGUSER() {
		return OPERATINGUSER;
	}
	public void setOPERATINGUSER(String oPERATINGUSER) {
		OPERATINGUSER = oPERATINGUSER;
	}
	public String getOPERATINGUSERNAME() {
		return OPERATINGUSERNAME;
	}
	public void setOPERATINGUSERNAME(String oPERATINGUSERNAME) {
		OPERATINGUSERNAME = oPERATINGUSERNAME;
	}
	public String getOPERATINGTIME() {
		return OPERATINGTIME;
	}
	public void setOPERATINGTIME(String oPERATINGTIME) {
		OPERATINGTIME = oPERATINGTIME;
	}
	public String getOPERATING() {
		return OPERATING;
	}
	public void setOPERATING(String oPERATING) {
		OPERATING = oPERATING;
	}
	public String getOPERATIONCONTENT() {
		return OPERATIONCONTENT;
	}
	public void setOPERATIONCONTENT(String oPERATIONCONTENT) {
		OPERATIONCONTENT = oPERATIONCONTENT;
	}
	public String getOPERATIONOBJECT() {
		return OPERATIONOBJECT;
	}
	public void setOPERATIONOBJECT(String oPERATIONOBJECT) {
		OPERATIONOBJECT = oPERATIONOBJECT;
	}
	@Override
	public String toString() {
		return "LoggerInfoDto [OPERATORID=" + OPERATORID + ", OPERATORLOGINID=" + OPERATORLOGINID + ", OPERATORNAME="
				+ OPERATORNAME + ", FROMTIME=" + FROMTIME + ", TOTIME=" + TOTIME + ", OPERATINGUSER=" + OPERATINGUSER
				+ ", OPERATINGUSERNAME=" + OPERATINGUSERNAME + ", OPERATINGTIME=" + OPERATINGTIME + ", OPERATING="
				+ OPERATING + ", OPERATIONCONTENT=" + OPERATIONCONTENT + ", OPERATIONOBJECT=" + OPERATIONOBJECT + "]";
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
	public String getFROMTIME() {
		return FROMTIME;
	}
	public void setFROMTIME(String fROMTIME) {
		FROMTIME = fROMTIME;
	}
	public String getTOTIME() {
		return TOTIME;
	}
	public void setTOTIME(String tOTIME) {
		TOTIME = tOTIME;
	}
	
	
	
}

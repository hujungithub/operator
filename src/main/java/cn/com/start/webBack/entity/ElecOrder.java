/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: ElecOrder.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.entity
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月19日 下午4:55:27
 * @version: V1.0  
 */
package cn.com.start.webBack.entity;

/**
 * @ClassName: ElecOrder
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月19日 下午4:55:27
 */
public class ElecOrder {
	
	private String ORDERID;
	
	private String STARTTIME;
	
	private String ENDTIME;
	
	private String TYPE;
	
	private String STATUS;
	
	private String IMGURL;
	
	private String ELECID;

	private String ELECNAME;
	
	private String CPID;
	
	private String ADDRESS;
	
	/**
	 * @return the cPID
	 */
	public String getCPID() {
		return CPID;
	}

	/**
	 * @param cPID the cPID to set
	 */
	public void setCPID(String cPID) {
		CPID = cPID;
	}

	/**
	 * @return the aDDRESS
	 */
	public String getADDRESS() {
		return ADDRESS;
	}

	/**
	 * @param aDDRESS the aDDRESS to set
	 */
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	/**
	 * @return the eLECNAME
	 */
	public String getELECNAME() {
		return ELECNAME;
	}

	/**
	 * @param eLECNAME the eLECNAME to set
	 */
	public void setELECNAME(String eLECNAME) {
		ELECNAME = eLECNAME;
	}

	/**
	 * @return the tELEPHONE
	 */
	public String getTELEPHONE() {
		return TELEPHONE;
	}

	/**
	 * @param tELEPHONE the tELEPHONE to set
	 */
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	private String TELEPHONE;
	/**
	 * @return the eLECID
	 */
	public String getELECID() {
		return ELECID;
	}

	/**
	 * @param eLECID the eLECID to set
	 */
	public void setELECID(String eLECID) {
		ELECID = eLECID;
	}

	/**
	 * @return the oRDERID
	 */
	public String getORDERID() {
		return ORDERID;
	}

	/**
	 * @param oRDERID the oRDERID to set
	 */
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}



	/**
	 * @return the sTARTTIME
	 */
	public String getSTARTTIME() {
		return STARTTIME;
	}

	/**
	 * @param sTARTTIME the sTARTTIME to set
	 */
	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}

	/**
	 * @return the eNDTIME
	 */
	public String getENDTIME() {
		return ENDTIME;
	}

	/**
	 * @param eNDTIME the eNDTIME to set
	 */
	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}



	/**
	 * @return the iMGURL
	 */
	public String getIMGURL() {
		return IMGURL;
	}

	/**
	 * @param iMGURL the iMGURL to set
	 */
	public void setIMGURL(String iMGURL) {
		IMGURL = iMGURL;
	}

	/**
	 * @Title: toString
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ElecOrder [ORDERID=" + ORDERID + ", STARTTIME=" + STARTTIME + ", ENDTIME=" + ENDTIME + ", TYPE=" + TYPE
				+ ", STATUS=" + STATUS + ", IMGURL=" + IMGURL + ", ELECID=" + ELECID + ", ELECNAME=" + ELECNAME
				+ ", CPID=" + CPID + ", ADDRESS=" + ADDRESS + ", TELEPHONE=" + TELEPHONE + "]";
	}

	/**
	 * @return the tYPE
	 */
	public String getTYPE() {
		return TYPE;
	}

	/**
	 * @param tYPE the tYPE to set
	 */
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	
}

/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: Electrician.java
 * @Prject: qianfeng
 * @Package: cn.com.start.webBack.entity
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月18日 下午2:54:03
 * @version: V1.0  
 */
package cn.com.start.webBack.entity;

/**
 * @ClassName: Electrician
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月18日 下午2:54:03
 */
public class Electrician {
	
	private long ID;
	
	private String ELECID;
	
	private String TELEPHONE;
	
	private String ELECNAME;
	
	private String CARDID;
	
	private String AREA;

	private String ELECID2;
	
	private String PASSWORD;
	
	private float BALANCE;
	
	private String STATUS;
	
	private String IMGURL;
	
	/**
	 * @return the eLECID2
	 */
	public String getELECID2() {
		return ELECID2;
	}

	/**
	 * @param eLECID2 the eLECID2 to set
	 */
	public void setELECID2(String eLECID2) {
		ELECID2 = eLECID2;
	}

	/**
	 * @return the pASSWORD
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}

	/**
	 * @param pASSWORD the pASSWORD to set
	 */
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	/**
	 * @return the bALANCE
	 */
	public float getBALANCE() {
		return BALANCE;
	}

	/**
	 * @param bALANCE the bALANCE to set
	 */
	public void setBALANCE(float bALANCE) {
		BALANCE = bALANCE;
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
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}

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
	 * @return the cARDID
	 */
	public String getCARDID() {
		return CARDID;
	}

	/**
	 * @param cARDID the cARDID to set
	 */
	public void setCARDID(String cARDID) {
		CARDID = cARDID;
	}

	/**
	 * @return the aREA
	 */
	public String getAREA() {
		return AREA;
	}

	/**
	 * @param aREA the aREA to set
	 */
	public void setAREA(String aREA) {
		AREA = aREA;
	}

	/**
	 * @Title: toString
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Electrician [ID=" + ID + ", ELECID=" + ELECID + ", TELEPHONE=" + TELEPHONE + ", ELECNAME=" + ELECNAME
				+ ", CARDID=" + CARDID + ", AREA=" + AREA + "]";
	}

}

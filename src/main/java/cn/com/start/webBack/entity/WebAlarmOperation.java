/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: WebAlarmOperation.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.entity
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月24日 下午1:57:40
 * @version: V1.0  
 */
package cn.com.start.webBack.entity;

/**
 * @ClassName: WebAlarmOperation
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月24日 下午1:57:40
 */
public class WebAlarmOperation {

	private String APPCARDID;
	
	private String STATENAME; 
	
	private int CHECKMODE;
	
	private String CPID;
	
	private int GUN;
	
	private int STATUS;

	private String RECORDTIME;
	
	private int CHECKSTATE;
	
	private String CHARGETYPENAME;
	
	private String MODENAME;
	
	private String CSNAME; // 站名称
	private String CPTYPE; // 桩类型
	private String ADDRESSNAME; // 地址
	private double LATITUDE;
	private double LONGITUDE;
	private String PROVINCENAME;
	private String CPNAME;
	private String LOCATION;
	
	/**
	 * @return the pROVINCENAME
	 */
	public String getPROVINCENAME() {
		return PROVINCENAME;
	}

	/**
	 * @param pROVINCENAME the pROVINCENAME to set
	 */
	public void setPROVINCENAME(String pROVINCENAME) {
		PROVINCENAME = pROVINCENAME;
	}

	/**
	 * @return the cPNAME
	 */
	public String getCPNAME() {
		return CPNAME;
	}

	/**
	 * @param cPNAME the cPNAME to set
	 */
	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	/**
	 * @return the lOCATION
	 */
	public String getLOCATION() {
		return LOCATION;
	}

	/**
	 * @param lOCATION the lOCATION to set
	 */
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}


	/**
	 * @return the cSNAME
	 */
	public String getCSNAME() {
		return CSNAME;
	}

	/**
	 * @param cSNAME the cSNAME to set
	 */
	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}

	/**
	 * @return the cPTYPE
	 */
	public String getCPTYPE() {
		return CPTYPE;
	}

	/**
	 * @param cPTYPE the cPTYPE to set
	 */
	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	/**
	 * @return the aDDRESSNAME
	 */
	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}

	/**
	 * @param aDDRESSNAME the aDDRESSNAME to set
	 */
	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
	}

	/**
	 * @return the lATITUDE
	 */
	public double getLATITUDE() {
		return LATITUDE;
	}

	/**
	 * @param lATITUDE the lATITUDE to set
	 */
	public void setLATITUDE(double lATITUDE) {
		LATITUDE = lATITUDE;
	}

	/**
	 * @return the lONGITUDE
	 */
	public double getLONGITUDE() {
		return LONGITUDE;
	}

	/**
	 * @param lONGITUDE the lONGITUDE to set
	 */
	public void setLONGITUDE(double lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	/**
	 * @Title: hashCode
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADDRESSNAME == null) ? 0 : ADDRESSNAME.hashCode());
		result = prime * result + ((ALARMDESP == null) ? 0 : ALARMDESP.hashCode());
		result = prime * result + ((APPCARDID == null) ? 0 : APPCARDID.hashCode());
		result = prime * result + ((CHARGETYPENAME == null) ? 0 : CHARGETYPENAME.hashCode());
		result = prime * result + CHECKMODE;
		result = prime * result + CHECKSTATE;
		result = prime * result + ((CPID == null) ? 0 : CPID.hashCode());
		result = prime * result + ((CPTYPE == null) ? 0 : CPTYPE.hashCode());
		result = prime * result + ((CSNAME == null) ? 0 : CSNAME.hashCode());
		result = prime * result + GUN;
		long temp;
		temp = Double.doubleToLongBits(LATITUDE);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(LONGITUDE);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((MODENAME == null) ? 0 : MODENAME.hashCode());
		result = prime * result + ((RECORDTIME == null) ? 0 : RECORDTIME.hashCode());
		result = prime * result + ((STATENAME == null) ? 0 : STATENAME.hashCode());
		result = prime * result + STATUS;
		return result;
	}

	/**
	 * @Title: equals
	 * @Description: TODO
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebAlarmOperation other = (WebAlarmOperation) obj;
		if (ADDRESSNAME == null) {
			if (other.ADDRESSNAME != null)
				return false;
		} else if (!ADDRESSNAME.equals(other.ADDRESSNAME))
			return false;
		if (ALARMDESP == null) {
			if (other.ALARMDESP != null)
				return false;
		} else if (!ALARMDESP.equals(other.ALARMDESP))
			return false;
		if (APPCARDID == null) {
			if (other.APPCARDID != null)
				return false;
		} else if (!APPCARDID.equals(other.APPCARDID))
			return false;
		if (CHARGETYPENAME == null) {
			if (other.CHARGETYPENAME != null)
				return false;
		} else if (!CHARGETYPENAME.equals(other.CHARGETYPENAME))
			return false;
		if (CHECKMODE != other.CHECKMODE)
			return false;
		if (CHECKSTATE != other.CHECKSTATE)
			return false;
		if (CPID == null) {
			if (other.CPID != null)
				return false;
		} else if (!CPID.equals(other.CPID))
			return false;
		if (CPTYPE == null) {
			if (other.CPTYPE != null)
				return false;
		} else if (!CPTYPE.equals(other.CPTYPE))
			return false;
		if (CSNAME == null) {
			if (other.CSNAME != null)
				return false;
		} else if (!CSNAME.equals(other.CSNAME))
			return false;
		if (GUN != other.GUN)
			return false;
		if (Double.doubleToLongBits(LATITUDE) != Double.doubleToLongBits(other.LATITUDE))
			return false;
		if (Double.doubleToLongBits(LONGITUDE) != Double.doubleToLongBits(other.LONGITUDE))
			return false;
		if (MODENAME == null) {
			if (other.MODENAME != null)
				return false;
		} else if (!MODENAME.equals(other.MODENAME))
			return false;
		if (RECORDTIME == null) {
			if (other.RECORDTIME != null)
				return false;
		} else if (!RECORDTIME.equals(other.RECORDTIME))
			return false;
		if (STATENAME == null) {
			if (other.STATENAME != null)
				return false;
		} else if (!STATENAME.equals(other.STATENAME))
			return false;
		if (STATUS != other.STATUS)
			return false;
		return true;
	}
	/**
	 * @param gUN the gUN to set
	 */
	public void setGUN(int gUN) {
		GUN = gUN;
	}
	/**
	 * @Title: toString
	 * @Description: TODO
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebAlarmOperation [APPCARDID=" + APPCARDID + ", STATENAME=" + STATENAME + ", CHECKMODE=" + CHECKMODE
				+ ", CPID=" + CPID + ", GUN=" + GUN + ", STATUS=" + STATUS + ", RECORDTIME=" + RECORDTIME
				+ ", CHECKSTATE=" + CHECKSTATE + ", CHARGETYPENAME=" + CHARGETYPENAME + ", MODENAME=" + MODENAME
				+ ", CSNAME=" + CSNAME + ", CPTYPE=" + CPTYPE + ", ADDRESSNAME=" + ADDRESSNAME + ", LATITUDE="
				+ LATITUDE + ", LONGITUDE=" + LONGITUDE + ", PROVINCENAME=" + PROVINCENAME + ", CPNAME=" + CPNAME
				+ ", LOCATION=" + LOCATION + ", ALARMDESP=" + ALARMDESP + "]";
	}

	/**
	 * @return the aPPCARDID
	 */
	public String getAPPCARDID() {
		return APPCARDID;
	}

	/**
	 * @param aPPCARDID the aPPCARDID to set
	 */
	public void setAPPCARDID(String aPPCARDID) {
		APPCARDID = aPPCARDID;
	}

	/**
	 * @return the sTATENAME
	 */
	public String getSTATENAME() {
		return STATENAME;
	}

	/**
	 * @param sTATENAME the sTATENAME to set
	 */
	public void setSTATENAME(String sTATENAME) {
		STATENAME = sTATENAME;
	}

	/**
	 * @return the cHECKMODE
	 */
	public int getCHECKMODE() {
		return CHECKMODE;
	}

	/**
	 * @param cHECKMODE the cHECKMODE to set
	 */
	public void setCHECKMODE(int cHECKMODE) {
		CHECKMODE = cHECKMODE;
	}

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
	 * @return the rECORDTIME
	 */
	public String getRECORDTIME() {
		return RECORDTIME;
	}

	/**
	 * @param rECORDTIME the rECORDTIME to set
	 */
	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	/**
	 * @return the cHECKSTATE
	 */
	public int getCHECKSTATE() {
		return CHECKSTATE;
	}

	/**
	 * @param cHECKSTATE the cHECKSTATE to set
	 */
	public void setCHECKSTATE(int cHECKSTATE) {
		CHECKSTATE = cHECKSTATE;
	}

	/**
	 * @return the cHARGETYPENAME
	 */
	public String getCHARGETYPENAME() {
		return CHARGETYPENAME;
	}

	/**
	 * @param cHARGETYPENAME the cHARGETYPENAME to set
	 */
	public void setCHARGETYPENAME(String cHARGETYPENAME) {
		CHARGETYPENAME = cHARGETYPENAME;
	}

	/**
	 * @return the sTATUS
	 */
	public int getSTATUS() {
		return STATUS;
	}

	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	/**
	 * @return the gUN
	 */
	public int getGUN() {
		return GUN;
	}

	/**
	 * @return the mODENAME
	 */
	public String getMODENAME() {
		return MODENAME;
	}

	/**
	 * @param mODENAME the mODENAME to set
	 */
	public void setMODENAME(String mODENAME) {
		MODENAME = mODENAME;
	}

	/**
	 * @return the aLARMDESP
	 */
	public String getALARMDESP() {
		return ALARMDESP;
	}

	/**
	 * @param aLARMDESP the aLARMDESP to set
	 */
	public void setALARMDESP(String aLARMDESP) {
		ALARMDESP = aLARMDESP;
	}

	private String ALARMDESP;
	
	
}

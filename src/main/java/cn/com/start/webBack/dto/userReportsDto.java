package cn.com.start.webBack.dto;

public class userReportsDto {
	private String TRANSATIONID;//订单编号
	private String CARDNUM;//充电卡号
	private String CPUSERID;
	private String CPUSERNAME;//用户名
	private String TELEPHONE;//电话号
	private String DEDUCTSUCCESSFLAG;//交易状态
	private String CSNAME;//充电站名称
	private String CPID;
	private String CPNAME;
	private String DEVICEID;//充电序列号
	private String CHARGEMETHODID;//充电类型
	private String CHARGEMETHODNAME;//充电类型名
	private String CHARGEMODEID;//充电模式
	private String CHARGEMODENAME;//充电模式名
	private String CHARGEENDCAUSE;//停机原因
	private String CHARGEQUANTITY;//充电电量
	private String CSID;//充电站编号
	private float CHARGEMONEY;//充电金额
	private float SERVICETIP;//服务费
	private float DEDUCTMONEY;//充电费用（服务费+充电金额）
	private String CHARGESTARTTIME;//充电开始时间
	private String CHARGEENDTIME;//充电结束时间
	private String CHARGETIMESPAN;//充电时长
	private float ACCOUNTSUM;//充电前金额
	private float REMAINMONEY;//充电后金额
	private String VIN;//汽车唯一标识
	private String PLATENUMBER;
	
	private String IDENTITYCARDNUM;
	private String CPUSERCOUNT;
	private int OPERATORID;
	private String OPERATORNAME;
	private String OPERNAME;//外部运营商
		
	
	
	public String getOPERNAME() {
		return OPERNAME;
	}
	public void setOPERNAME(String oPERNAME) {
		OPERNAME = oPERNAME;
	}
	public int getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(int oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getOPERATORNAME() {
		return OPERATORNAME;
	}
	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}
	public String getCPUSERCOUNT() {
		return CPUSERCOUNT;
	}
	public void setCPUSERCOUNT(String cPUSERCOUNT) {
		CPUSERCOUNT = cPUSERCOUNT;
	}
	public String getPLATENUMBER() {
		return PLATENUMBER;
	}
	public void setPLATENUMBER(String pLATENUMBER) {
		PLATENUMBER = pLATENUMBER;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public float getSERVICETIP() {
		return SERVICETIP;
	}
	public void setSERVICETIP(float sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}
	public float getDEDUCTMONEY() {
		return DEDUCTMONEY;
	}
	public void setDEDUCTMONEY(float dEDUCTMONEY) {
		DEDUCTMONEY = dEDUCTMONEY;
	}
	public String getIDENTITYCARDNUM() {
		return IDENTITYCARDNUM;
	}
	public void setIDENTITYCARDNUM(String iDENTITYCARDNUM) {
		IDENTITYCARDNUM = iDENTITYCARDNUM;
	}
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getCPNAME() {
		return CPNAME;
	}
	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}
	public String getCHARGEMODENAME() {
		return CHARGEMODENAME;
	}
	public void setCHARGEMODENAME(String cHARGEMODENAME) {
		CHARGEMODENAME = cHARGEMODENAME;
	}
	public String getCHARGEMETHODNAME() {
		return CHARGEMETHODNAME;
	}
	public void setCHARGEMETHODNAME(String cHARGEMETHODNAME) {
		CHARGEMETHODNAME = cHARGEMETHODNAME;
	}
	public String getTRANSATIONID() {
		return TRANSATIONID;
	}
	public void setTRANSATIONID(String tRANSATIONID) {
		TRANSATIONID = tRANSATIONID;
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getCPUSERNAME() {
		return CPUSERNAME;
	}
	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	public String getDEDUCTSUCCESSFLAG() {
		return DEDUCTSUCCESSFLAG;
	}
	public void setDEDUCTSUCCESSFLAG(String dEDUCTSUCCESSFLAG) {
		DEDUCTSUCCESSFLAG = dEDUCTSUCCESSFLAG;
	}
	public String getCSNAME() {
		return CSNAME;
	}
	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}
	public String getDEVICEID() {
		return DEVICEID;
	}
	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}
	public String getCHARGEMETHODID() {
		return CHARGEMETHODID;
	}
	public void setCHARGEMETHODID(String cHARGEMETHODID) {
		CHARGEMETHODID = cHARGEMETHODID;
	}
	public String getCHARGEMODEID() {
		return CHARGEMODEID;
	}
	public void setCHARGEMODEID(String cHARGEMODEID) {
		CHARGEMODEID = cHARGEMODEID;
	}
	public String getCHARGEENDCAUSE() {
		return CHARGEENDCAUSE;
	}
	public void setCHARGEENDCAUSE(String cHARGEENDCAUSE) {
		CHARGEENDCAUSE = cHARGEENDCAUSE;
	}
	public String getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}
	public void setCHARGEQUANTITY(String cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}
	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	public float getCHARGEMONEY() {
		return CHARGEMONEY;
	}
	public void setCHARGEMONEY(float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}
	public String getCHARGESTARTTIME() {
		return CHARGESTARTTIME;
	}
	public void setCHARGESTARTTIME(String cHARGESTARTTIME) {
		CHARGESTARTTIME = cHARGESTARTTIME;
	}
	public String getCHARGEENDTIME() {
		return CHARGEENDTIME;
	}
	public void setCHARGEENDTIME(String cHARGEENDTIME) {
		CHARGEENDTIME = cHARGEENDTIME;
	}
	public String getCHARGETIMESPAN() {
		return CHARGETIMESPAN;
	}
	public void setCHARGETIMESPAN(String cHARGETIMESPAN) {
		CHARGETIMESPAN = cHARGETIMESPAN;
	}
	public float getACCOUNTSUM() {
		return ACCOUNTSUM;
	}
	public void setACCOUNTSUM(float aCCOUNTSUM) {
		ACCOUNTSUM = aCCOUNTSUM;
	}
	public float getREMAINMONEY() {
		return REMAINMONEY;
	}
	public void setREMAINMONEY(float rEMAINMONEY) {
		REMAINMONEY = rEMAINMONEY;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	@Override
	public String toString() {
		return "userReportsDto [TRANSATIONID=" + TRANSATIONID + ", CARDNUM="
				+ CARDNUM + ", CPUSERID=" + CPUSERID + ", CPUSERNAME="
				+ CPUSERNAME + ", TELEPHONE=" + TELEPHONE
				+ ", DEDUCTSUCCESSFLAG=" + DEDUCTSUCCESSFLAG + ", CSNAME="
				+ CSNAME + ", CPID=" + CPID + ", CPNAME=" + CPNAME
				+ ", DEVICEID=" + DEVICEID + ", CHARGEMETHODID="
				+ CHARGEMETHODID + ", CHARGEMETHODNAME=" + CHARGEMETHODNAME
				+ ", CHARGEMODEID=" + CHARGEMODEID + ", CHARGEMODENAME="
				+ CHARGEMODENAME + ", CHARGEENDCAUSE=" + CHARGEENDCAUSE
				+ ", CHARGEQUANTITY=" + CHARGEQUANTITY + ", CSID=" + CSID
				+ ", CHARGEMONEY=" + CHARGEMONEY + ", SERVICETIP=" + SERVICETIP
				+ ", DEDUCTMONEY=" + DEDUCTMONEY + ", CHARGESTARTTIME="
				+ CHARGESTARTTIME + ", CHARGEENDTIME=" + CHARGEENDTIME
				+ ", CHARGETIMESPAN=" + CHARGETIMESPAN + ", ACCOUNTSUM="
				+ ACCOUNTSUM + ", REMAINMONEY=" + REMAINMONEY + ", VIN=" + VIN
				+ ", PLATENUMBER=" + PLATENUMBER + ", IDENTITYCARDNUM="
				+ IDENTITYCARDNUM + ", CPUSERCOUNT=" + CPUSERCOUNT
				+ ", OPERATORID=" + OPERATORID + ", OPERATORNAME="
				+ OPERATORNAME + ", OPERNAME=" + OPERNAME + "]";
	}
	
	
	
}

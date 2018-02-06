package cn.com.start.webBack.entity;

public class CSInfo {

	private String CSID;// 充电站ID
	private String CSNAME;// 充电桩名称
	private String ADDRESSID;// 地址ID
	private String OPERATORID;// 运营商ID
	private String OPERATORLOGINID;//登录运营商id
	private String DCCPCOUNT;// 直流桩数量
	private String ACCPCOUNT;// 交流桩数量
	private String ALLOWAPPOINTCOUNT;// 可供预约桩数量
	private String CREATETIME;// 建站日期
	private String VALIDFLAG;// 是否可用
	private String PICURL; // 实景图片存放路径
	private String OPENTIME; // 开放时间
	private String PROPERTY; // 类型（真站 假站（离散桩））
	
	//ADD NIEHY BY 2017/8/17 BEGIN
	private String PROVINCEID; //充电站省份
	private String CITYID; //充电站城市
	private String AREAID; //充电站地区
	private String ADDRESSNAME; //充电站地址名
	private String TIMESTART; //开始充电时间
	private String TIMEEND; //结束充电时间
	private String PARKINGFEE;//停车费
	//ADD NIEHY BY 2017/8/17 END

	
	@Override
	public String toString() {
		return "CSInfo [CSID=" + CSID + ", CSNAME=" + CSNAME + ", ADDRESSID=" + ADDRESSID + ", OPERATORID=" + OPERATORID
				+ ", OPERATORLOGINID=" + OPERATORLOGINID + ", DCCPCOUNT=" + DCCPCOUNT + ", ACCPCOUNT=" + ACCPCOUNT
				+ ", ALLOWAPPOINTCOUNT=" + ALLOWAPPOINTCOUNT + ", CREATETIME=" + CREATETIME + ", VALIDFLAG=" + VALIDFLAG
				+ ", PICURL=" + PICURL + ", OPENTIME=" + OPENTIME + ", PROPERTY=" + PROPERTY + ", PROVINCEID="
				+ PROVINCEID + ", CITYID=" + CITYID + ", AREAID=" + AREAID + ", ADDRESSNAME=" + ADDRESSNAME
				+ ", TIMESTART=" + TIMESTART + ", TIMEEND=" + TIMEEND + ", PARKINGFEE=" + PARKINGFEE + "]";
	}
	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	public String getCSNAME() {
		return CSNAME;
	}
	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}
	public String getADDRESSID() {
		return ADDRESSID;
	}
	public void setADDRESSID(String aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getDCCPCOUNT() {
		return DCCPCOUNT;
	}
	public void setDCCPCOUNT(String dCCPCOUNT) {
		DCCPCOUNT = dCCPCOUNT;
	}
	public String getACCPCOUNT() {
		return ACCPCOUNT;
	}
	public void setACCPCOUNT(String aCCPCOUNT) {
		ACCPCOUNT = aCCPCOUNT;
	}
	public String getALLOWAPPOINTCOUNT() {
		return ALLOWAPPOINTCOUNT;
	}
	public void setALLOWAPPOINTCOUNT(String aLLOWAPPOINTCOUNT) {
		ALLOWAPPOINTCOUNT = aLLOWAPPOINTCOUNT;
	}
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getVALIDFLAG() {
		return VALIDFLAG;
	}
	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}
	public String getPICURL() {
		return PICURL;
	}
	public void setPICURL(String pICURL) {
		PICURL = pICURL;
	}
	public String getOPENTIME() {
		return OPENTIME;
	}
	public void setOPENTIME(String oPENTIME) {
		OPENTIME = oPENTIME;
	}
	public String getPROPERTY() {
		return PROPERTY;
	}
	public void setPROPERTY(String pROPERTY) {
		PROPERTY = pROPERTY;
	}
	public String getPROVINCEID() {
		return PROVINCEID;
	}
	public void setPROVINCEID(String pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}
	public String getCITYID() {
		return CITYID;
	}
	public void setCITYID(String cITYID) {
		CITYID = cITYID;
	}
	public String getAREAID() {
		return AREAID;
	}
	public void setAREAID(String aREAID) {
		AREAID = aREAID;
	}
	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}
	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
	}
	public String getTIMESTART() {
		return TIMESTART;
	}
	public void setTIMESTART(String tIMESTART) {
		TIMESTART = tIMESTART;
	}
	public String getTIMEEND() {
		return TIMEEND;
	}
	public void setTIMEEND(String tIMEEND) {
		TIMEEND = tIMEEND;
	}
	public String getPARKINGFEE() {
		return PARKINGFEE;
	}
	public void setPARKINGFEE(String pARKINGFEE) {
		PARKINGFEE = pARKINGFEE;
	}
	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}
	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	
}


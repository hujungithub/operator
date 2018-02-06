package cn.com.start.webBack.dto;

public class CPInfoDto {

	private String CPID;// 桩ID（区域编码+4位）
	private String CPNAME;// 桩名称（区域地质+桩编号
	private String OPERATORNAME; // 运营商名
	private String CSNAME;// 站名称

	private String MFRNAME;// 厂商名
	private String MODEL; // 型号
	private String LOCATION; // 桩地址
	private String IPADDRESS;// ip地址
	private String PORT;// 端口号

	private String COMMCYCLE; // 通信周期
	private String SAVECYCLE; // 入库周期
	private String ALARMFLAG; // 报警标志
	private String SAVEFLAG; // 入库标志
	private String VALIDFLAG; // 是否可用

	private String RATEID; // 费率id
	private String PROTOCOLNAME;// 协议名
	private String CREATETIME;// 建桩日期
	private String CPCOMMSTATE;// 通信状态
	private String CPCURRSTATE;// 当前状态

	// /****************///
	private String RATEDPOWER; // 额定功率
	private String CPTYPE;// 类型
	private String CPPHASE;// 相数
	private String INTERFACECOUNT;// 枪数
	private String PRICE;// 费率
	
	private String chargePatternId;
	private String chargePatternName;

	@Override
	public String toString() {
		return "CPInfoDto [CPID=" + CPID + ", CPNAME=" + CPNAME + ", OPERATORNAME=" + OPERATORNAME + ", CSNAME="
				+ CSNAME + ", MFRNAME=" + MFRNAME + ", MODEL=" + MODEL + ", LOCATION=" + LOCATION + ", IPADDRESS="
				+ IPADDRESS + ", PORT=" + PORT + ", COMMCYCLE=" + COMMCYCLE + ", SAVECYCLE=" + SAVECYCLE
				+ ", ALARMFLAG=" + ALARMFLAG + ", SAVEFLAG=" + SAVEFLAG + ", VALIDFLAG=" + VALIDFLAG + ", RATEID="
				+ RATEID + ", PROTOCOLNAME=" + PROTOCOLNAME + ", CREATETIME=" + CREATETIME + ", CPCOMMSTATE="
				+ CPCOMMSTATE + ", CPCURRSTATE=" + CPCURRSTATE + ", RATEDPOWER=" + RATEDPOWER + ", CPTYPE=" + CPTYPE
				+ ", CPPHASE=" + CPPHASE + ", INTERFACECOUNT=" + INTERFACECOUNT + ", PRICE=" + PRICE
				+ ", chargePatternId=" + chargePatternId + ", chargePatternName=" + chargePatternName + "]";
	}

	public String getSAVECYCLE() {
		return SAVECYCLE;
	}

	public void setSAVECYCLE(String sAVECYCLE) {
		SAVECYCLE = sAVECYCLE;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public String getPROTOCOLNAME() {
		return PROTOCOLNAME;
	}

	public void setPROTOCOLNAME(String pROTOCOLNAME) {
		PROTOCOLNAME = pROTOCOLNAME;
	}

	public String getLOCATION() {
		return LOCATION;
	}

	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}

	public String getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(String rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public String getIPADDRESS() {
		return IPADDRESS;
	}

	public void setIPADDRESS(String iPADDRESS) {
		IPADDRESS = iPADDRESS;
	}

	public String getPORT() {
		return PORT;
	}

	public void setPORT(String pORT) {
		PORT = pORT;
	}

	public String getCOMMCYCLE() {
		return COMMCYCLE;
	}

	public void setCOMMCYCLE(String cOMMCYCLE) {
		COMMCYCLE = cOMMCYCLE;
	}

	public String getALARMFLAG() {
		return ALARMFLAG;
	}

	public void setALARMFLAG(String aLARMFLAG) {
		ALARMFLAG = aLARMFLAG;
	}

	public String getSAVEFLAG() {
		return SAVEFLAG;
	}

	public void setSAVEFLAG(String sAVEFLAG) {
		SAVEFLAG = sAVEFLAG;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	public String getCPCURRSTATE() {
		return CPCURRSTATE;
	}

	public void setCPCURRSTATE(String cPCURRSTATE) {
		CPCURRSTATE = cPCURRSTATE;
	}

	public String getCPCOMMSTATE() {
		return CPCOMMSTATE;
	}

	public void setCPCOMMSTATE(String cPCOMMSTATE) {
		CPCOMMSTATE = cPCOMMSTATE;
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

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getCSNAME() {
		return CSNAME;
	}

	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public String getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(String cPPHASE) {
		CPPHASE = cPPHASE;
	}

	public String getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(String iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

	public String getMFRNAME() {
		return MFRNAME;
	}

	public void setMFRNAME(String mFRNAME) {
		MFRNAME = mFRNAME;
	}

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public String getChargePatternId() {
		return chargePatternId;
	}

	public void setChargePatternId(String chargePatternId) {
		this.chargePatternId = chargePatternId;
	}

	public String getChargePatternName() {
		return chargePatternName;
	}

	public void setChargePatternName(String chargePatternName) {
		this.chargePatternName = chargePatternName;
	}

}

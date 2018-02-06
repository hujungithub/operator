package cn.com.start.webBack.dto;

public class BillModelDto {
	private String OPERATORLOGINID;
	private String OPERATORID;
	private String CSID;
	private String CSNAME;
	private String RATEID;// 套 1-4
	private String BILLMODELID;// 模板 1-12
	private String VALIDTIME;// 生效时间 一般一个月
	private String INVALIDTIME;// 失效时间
	private String TIMEINTERVALCOUNT; // 时段数
	private Float SERVICETIP;
	private Float JPRICE;//
	private Float FPRICE;//
	private Float PPRICE;//
	private Float GPRICE;//
	private String TI_1_START;// 时段1起始时刻
	private String TI_1_ID; // 时段1标识 0-3 建峰平谷
	private String TI_2_START;// 时段2起始时刻
	private String TI_2_ID;// 时段2标识
	private String TI_3_START;// 时段3起始时刻
	private String TI_3_ID;// 时段3标识
	private String TI_4_START;// 时段4起始时刻
	private String TI_4_ID;// 时段4标识
	private String TI_5_START;// 时段5起始时刻
	private String TI_5_ID;// 时段5标识
	private String TI_6_START;// 时段6起始时刻
	private String TI_6_ID;// 时段6标识
	private String TI_7_START;// 时段7起始时刻
	private String TI_7_ID;// 时段7标识
	private String TI_8_START;// 时段8起始时刻
	private String TI_8_ID;// 时段8标识

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public Float getSERVICETIP() {
		return SERVICETIP;
	}

	public void setSERVICETIP(Float sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}

	public String getRATEID() {
		return RATEID;
	}

	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}

	public String getBILLMODELID() {
		return BILLMODELID;
	}

	public void setBILLMODELID(String bILLMODELID) {
		BILLMODELID = bILLMODELID;
	}

	public String getVALIDTIME() {
		return VALIDTIME;
	}

	public void setVALIDTIME(String vALIDTIME) {
		VALIDTIME = vALIDTIME;
	}

	public String getINVALIDTIME() {
		return INVALIDTIME;
	}

	public void setINVALIDTIME(String iNVALIDTIME) {
		INVALIDTIME = iNVALIDTIME;
	}

	public String getTIMEINTERVALCOUNT() {
		return TIMEINTERVALCOUNT;
	}

	public void setTIMEINTERVALCOUNT(String tIMEINTERVALCOUNT) {
		TIMEINTERVALCOUNT = tIMEINTERVALCOUNT;
	}

	public Float getJPRICE() {
		return JPRICE;
	}

	public void setJPRICE(Float jPRICE) {
		JPRICE = jPRICE;
	}

	public float getFPRICE() {
		return FPRICE;
	}

	public void setFPRICE(Float fPRICE) {
		FPRICE = fPRICE;
	}

	public Float getPPRICE() {
		return PPRICE;
	}

	public void setPPRICE(Float pPRICE) {
		PPRICE = pPRICE;
	}

	public Float getGPRICE() {
		return GPRICE;
	}

	public void setGPRICE(Float gPRICE) {
		GPRICE = gPRICE;
	}

	public String getTI_1_START() {
		return TI_1_START;
	}

	public void setTI_1_START(String tI_1_START) {
		TI_1_START = tI_1_START;
	}

	public String getTI_1_ID() {
		return TI_1_ID;
	}

	public void setTI_1_ID(String tI_1_ID) {
		TI_1_ID = tI_1_ID;
	}

	public String getTI_2_START() {
		return TI_2_START;
	}

	public void setTI_2_START(String tI_2_START) {
		TI_2_START = tI_2_START;
	}

	public String getTI_2_ID() {
		return TI_2_ID;
	}

	public void setTI_2_ID(String tI_2_ID) {
		TI_2_ID = tI_2_ID;
	}

	public String getTI_3_START() {
		return TI_3_START;
	}

	public void setTI_3_START(String tI_3_START) {
		TI_3_START = tI_3_START;
	}

	public String getTI_3_ID() {
		return TI_3_ID;
	}

	public void setTI_3_ID(String tI_3_ID) {
		TI_3_ID = tI_3_ID;
	}

	public String getTI_4_START() {
		return TI_4_START;
	}

	public void setTI_4_START(String tI_4_START) {
		TI_4_START = tI_4_START;
	}

	public String getTI_4_ID() {
		return TI_4_ID;
	}

	public void setTI_4_ID(String tI_4_ID) {
		TI_4_ID = tI_4_ID;
	}

	public String getTI_5_START() {
		return TI_5_START;
	}

	public void setTI_5_START(String tI_5_START) {
		TI_5_START = tI_5_START;
	}

	public String getTI_5_ID() {
		return TI_5_ID;
	}

	public void setTI_5_ID(String tI_5_ID) {
		TI_5_ID = tI_5_ID;
	}

	public String getTI_6_START() {
		return TI_6_START;
	}

	public void setTI_6_START(String tI_6_START) {
		TI_6_START = tI_6_START;
	}

	public String getTI_6_ID() {
		return TI_6_ID;
	}

	public void setTI_6_ID(String tI_6_ID) {
		TI_6_ID = tI_6_ID;
	}

	public String getTI_7_START() {
		return TI_7_START;
	}

	public void setTI_7_START(String tI_7_START) {
		TI_7_START = tI_7_START;
	}

	public String getTI_7_ID() {
		return TI_7_ID;
	}

	public void setTI_7_ID(String tI_7_ID) {
		TI_7_ID = tI_7_ID;
	}

	public String getTI_8_START() {
		return TI_8_START;
	}

	public void setTI_8_START(String tI_8_START) {
		TI_8_START = tI_8_START;
	}

	public String getTI_8_ID() {
		return TI_8_ID;
	}

	public void setTI_8_ID(String tI_8_ID) {
		TI_8_ID = tI_8_ID;
	}

	@Override
	public String toString() {
		return "BillModelDto [OPERATORLOGINID=" + OPERATORLOGINID + ", OPERATORID=" + OPERATORID + ", CSID=" + CSID
				+ ", CSNAME=" + CSNAME + ", RATEID=" + RATEID + ", BILLMODELID=" + BILLMODELID + ", VALIDTIME="
				+ VALIDTIME + ", INVALIDTIME=" + INVALIDTIME + ", TIMEINTERVALCOUNT=" + TIMEINTERVALCOUNT
				+ ", SERVICETIP=" + SERVICETIP + ", JPRICE=" + JPRICE + ", FPRICE=" + FPRICE + ", PPRICE=" + PPRICE
				+ ", GPRICE=" + GPRICE + ", TI_1_START=" + TI_1_START + ", TI_1_ID=" + TI_1_ID + ", TI_2_START="
				+ TI_2_START + ", TI_2_ID=" + TI_2_ID + ", TI_3_START=" + TI_3_START + ", TI_3_ID=" + TI_3_ID
				+ ", TI_4_START=" + TI_4_START + ", TI_4_ID=" + TI_4_ID + ", TI_5_START=" + TI_5_START + ", TI_5_ID="
				+ TI_5_ID + ", TI_6_START=" + TI_6_START + ", TI_6_ID=" + TI_6_ID + ", TI_7_START=" + TI_7_START
				+ ", TI_7_ID=" + TI_7_ID + ", TI_8_START=" + TI_8_START + ", TI_8_ID=" + TI_8_ID + "]";
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

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

}

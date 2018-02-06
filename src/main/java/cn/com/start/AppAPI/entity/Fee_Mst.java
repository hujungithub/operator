package cn.com.start.AppAPI.entity;

public class Fee_Mst {
	// 价格ID
	private String PRICEID;
	// 尖电价
	private String CUSPPRICE;
	// 峰电价
	private String PEAKPRICE;
	// 平电价
	private String FLATPRICE;
	// 谷电价
	private String VALLEYPRICE;
	// 尖开始
	private String CUSPBEGINTIME;
	// 尖结束
	private String CUSPENDTIME;
	// 峰开始
	private String PEAKBEGINTIME;
	// 峰结束
	private String PEAKENDTIME;
	// 平开始
	private String FLATBEGINTIME;
	// 平结束
	private String FLATENDTIME;
	// 谷开始
	private String VALLEYBEGINTIME;
	// 谷结束
	private String VALLEYENDTIME;
	// 站
	private String CSID;
	// 桩
	private String CPID;
	// 运营商
	private String COID;

	public String getPRICEID() {
		return PRICEID;
	}

	public void setPRICEID(String pRICEID) {
		PRICEID = pRICEID;
	}

	public String getCUSPPRICE() {
		return CUSPPRICE;
	}

	public void setCUSPPRICE(String cUSPPRICE) {
		CUSPPRICE = cUSPPRICE;
	}

	public String getPEAKPRICE() {
		return PEAKPRICE;
	}

	public void setPEAKPRICE(String pEAKPRICE) {
		PEAKPRICE = pEAKPRICE;
	}

	public String getFLATPRICE() {
		return FLATPRICE;
	}

	public void setFLATPRICE(String fLATPRICE) {
		FLATPRICE = fLATPRICE;
	}

	public String getVALLEYPRICE() {
		return VALLEYPRICE;
	}

	public void setVALLEYPRICE(String vALLEYPRICE) {
		VALLEYPRICE = vALLEYPRICE;
	}

	public String getCUSPBEGINTIME() {
		return CUSPBEGINTIME;
	}

	public void setCUSPBEGINTIME(String cUSPBEGINTIME) {
		CUSPBEGINTIME = cUSPBEGINTIME;
	}

	public String getCUSPENDTIME() {
		return CUSPENDTIME;
	}

	public void setCUSPENDTIME(String cUSPENDTIME) {
		CUSPENDTIME = cUSPENDTIME;
	}

	public String getPEAKBEGINTIME() {
		return PEAKBEGINTIME;
	}

	public void setPEAKBEGINTIME(String pEAKBEGINTIME) {
		PEAKBEGINTIME = pEAKBEGINTIME;
	}

	public String getPEAKENDTIME() {
		return PEAKENDTIME;
	}

	public void setPEAKENDTIME(String pEAKENDTIME) {
		PEAKENDTIME = pEAKENDTIME;
	}

	public String getFLATBEGINTIME() {
		return FLATBEGINTIME;
	}

	public void setFLATBEGINTIME(String fLATBEGINTIME) {
		FLATBEGINTIME = fLATBEGINTIME;
	}

	public String getFLATENDTIME() {
		return FLATENDTIME;
	}

	public void setFLATENDTIME(String fLATENDTIME) {
		FLATENDTIME = fLATENDTIME;
	}

	public String getVALLEYBEGINTIME() {
		return VALLEYBEGINTIME;
	}

	public void setVALLEYBEGINTIME(String vALLEYBEGINTIME) {
		VALLEYBEGINTIME = vALLEYBEGINTIME;
	}

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCOID() {
		return COID;
	}

	public void setCOID(String cOID) {
		COID = cOID;
	}

	public String getVALLEYENDTIME() {
		return VALLEYENDTIME;
	}

	public void setVALLEYENDTIME(String vALLEYENDTIME) {
		VALLEYENDTIME = vALLEYENDTIME;
	}

	@Override
	public String toString() {
		return "Fee_Mst [PRICEID=" + PRICEID + ", CUSPPRICE=" + CUSPPRICE
				+ ", PEAKPRICE=" + PEAKPRICE + ", FLATPRICE=" + FLATPRICE
				+ ", VALLEYPRICE=" + VALLEYPRICE + ", CUSPBEGINTIME="
				+ CUSPBEGINTIME + ", CUSPENDTIME=" + CUSPENDTIME
				+ ", PEAKBEGINTIME=" + PEAKBEGINTIME + ", PEAKENDTIME="
				+ PEAKENDTIME + ", FLATBEGINTIME=" + FLATBEGINTIME
				+ ", FLATENDTIME=" + FLATENDTIME + ", VALLEYBEGINTIME="
				+ VALLEYBEGINTIME + ", VALLEYENDTIME=" + VALLEYENDTIME
				+ ", CSID=" + CSID + ", CPID=" + CPID + ", COID=" + COID + "]";
	}
}

package cn.com.start.webBack.dto;

public class reportsDto {
	private String CSNAME;//充电站名
	private String CSID;
	private String CPUSERNAME;//扫码用户名
	private String CPUSERID;//扫码用户名
	private String CARDNUM;//刷卡卡号
	private String CARDUSERNAME;//刷卡用户名
	private float CHARGEQUANTITY;//充电电量
	private float CHARGEMONEY;//充电金额
	private float JQ;//尖电量
	private float FQ;//峰电量
	private float PQ;//平电量
	private float GQ;//谷电量
	private float JF;//尖电量
	private float FF;//峰费用
	private float PF;//平费用
	private float GF;//谷费用
	private String CPUSERCOUNT;
	
	private float TOTAL_CHARGEQUANTITY;//充电电量
	private float TOTAL_CHARGEMONEY;//充电金额
	private float TOTAL_JQ;//峰电量
	private float TOTAL_FQ;//峰电量
	private float TOTAL_PQ;//平电量
	private float TOTAL_GQ;//谷电量
	private float TOTAL_JF;//峰费用
	private float TOTAL_FF;//峰费用
	private float TOTAL_PF;//平费用
	private float TOTAL_GF;//谷费用
	
	
	 int NEW_CHARGEQUANTITY;//充电电量
	 int NEW_CHARGEMONEY;//充电金额
	 int NEW_JQ;//尖电量
	 int NEW_FQ;//峰电量
	 int NEW_PQ;//平电量
	 int NEW_GQ;//谷电量
	 int NEW_JF;//尖电量
	 int NEW_FF;//峰费用
	 int NEW_PF;//平费用
	 int NEW_GF;//谷费用
	
	public reportsDto(){
		NEW_CHARGEQUANTITY = 0;
		NEW_CHARGEMONEY = 0;
		NEW_JQ = 0;
		NEW_FQ = 0;
		NEW_PQ = 0;
		NEW_GQ = 0;
		NEW_JF = 0;
		NEW_FF = 0;
		NEW_PF = 0;
		NEW_GF = 0;
	
	}
	
	
	public String getCPUSERCOUNT() {
		return CPUSERCOUNT;
	}


	public void setCPUSERCOUNT(String cPUSERCOUNT) {
		CPUSERCOUNT = cPUSERCOUNT;
	}


	public int getNEW_CHARGEQUANTITY() {
		return NEW_CHARGEQUANTITY;
	}


	public void setNEW_CHARGEQUANTITY(int nEW_CHARGEQUANTITY) {
		NEW_CHARGEQUANTITY = nEW_CHARGEQUANTITY;
	}


	public int getNEW_CHARGEMONEY() {
		return NEW_CHARGEMONEY;
	}


	public void setNEW_CHARGEMONEY(int nEW_CHARGEMONEY) {
		NEW_CHARGEMONEY = nEW_CHARGEMONEY;
	}


	public int getNEW_JQ() {
		return NEW_JQ;
	}


	public void setNEW_JQ(int nEW_JQ) {
		NEW_JQ = nEW_JQ;
	}


	public int getNEW_FQ() {
		return NEW_FQ;
	}


	public void setNEW_FQ(int nEW_FQ) {
		NEW_FQ = nEW_FQ;
	}


	public int getNEW_PQ() {
		return NEW_PQ;
	}


	public void setNEW_PQ(int nEW_PQ) {
		NEW_PQ = nEW_PQ;
	}


	public int getNEW_GQ() {
		return NEW_GQ;
	}


	public void setNEW_GQ(int nEW_GQ) {
		NEW_GQ = nEW_GQ;
	}


	public int getNEW_JF() {
		return NEW_JF;
	}


	public void setNEW_JF(int nEW_JF) {
		NEW_JF = nEW_JF;
	}


	public int getNEW_FF() {
		return NEW_FF;
	}


	public void setNEW_FF(int nEW_FF) {
		NEW_FF = nEW_FF;
	}


	public int getNEW_PF() {
		return NEW_PF;
	}


	public void setNEW_PF(int nEW_PF) {
		NEW_PF = nEW_PF;
	}


	public int getNEW_GF() {
		return NEW_GF;
	}


	public void setNEW_GF(int nEW_GF) {
		NEW_GF = nEW_GF;
	}


	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	public float getTOTAL_JQ() {
		return TOTAL_JQ;
	}
	public void setTOTAL_JQ(float tOTAL_JQ) {
		TOTAL_JQ = tOTAL_JQ;
	}
	public float getTOTAL_JF() {
		return TOTAL_JF;
	}
	public void setTOTAL_JF(float tOTAL_JF) {
		TOTAL_JF = tOTAL_JF;
	}
	public float getJQ() {
		return JQ;
	}
	public void setJQ(float jQ) {
		JQ = jQ;
	}
	public float getJF() {
		return JF;
	}
	public void setJF(float jF) {
		JF = jF;
	}
	public String getCPUSERID() {
		return CPUSERID;
	}
	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}
	public String getCSNAME() {
		return CSNAME;
	}
	public void setCSNAME(String cSNAME) {
		CSNAME = cSNAME;
	}
	public float getTOTAL_CHARGEQUANTITY() {
		return TOTAL_CHARGEQUANTITY;
	}
	public void setTOTAL_CHARGEQUANTITY(float tOTAL_CHARGEQUANTITY) {
		TOTAL_CHARGEQUANTITY = tOTAL_CHARGEQUANTITY;
	}
	public float getTOTAL_CHARGEMONEY() {
		return TOTAL_CHARGEMONEY;
	}
	public void setTOTAL_CHARGEMONEY(float tOTAL_CHARGEMONEY) {
		TOTAL_CHARGEMONEY = tOTAL_CHARGEMONEY;
	}
	public float getTOTAL_FQ() {
		return TOTAL_FQ;
	}
	public void setTOTAL_FQ(float tOTAL_FQ) {
		TOTAL_FQ = tOTAL_FQ;
	}
	public float getTOTAL_PQ() {
		return TOTAL_PQ;
	}
	public void setTOTAL_PQ(float tOTAL_PQ) {
		TOTAL_PQ = tOTAL_PQ;
	}
	public float getTOTAL_GQ() {
		return TOTAL_GQ;
	}
	public void setTOTAL_GQ(float tOTAL_GQ) {
		TOTAL_GQ = tOTAL_GQ;
	}
	public float getTOTAL_FF() {
		return TOTAL_FF;
	}
	public void setTOTAL_FF(float tOTAL_FF) {
		TOTAL_FF = tOTAL_FF;
	}
	public float getTOTAL_PF() {
		return TOTAL_PF;
	}
	public void setTOTAL_PF(float tOTAL_PF) {
		TOTAL_PF = tOTAL_PF;
	}
	public float getTOTAL_GF() {
		return TOTAL_GF;
	}
	public void setTOTAL_GF(float tOTAL_GF) {
		TOTAL_GF = tOTAL_GF;
	}
	public String getCPUSERNAME() {
		return CPUSERNAME;
	}
	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}
	public String getCARDNUM() {
		return CARDNUM;
	}
	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}
	public String getCARDUSERNAME() {
		return CARDUSERNAME;
	}
	public void setCARDUSERNAME(String cARDUSERNAME) {
		CARDUSERNAME = cARDUSERNAME;
	}
	public float getCHARGEQUANTITY() {
		return CHARGEQUANTITY;
	}
	public void setCHARGEQUANTITY(float cHARGEQUANTITY) {
		CHARGEQUANTITY = cHARGEQUANTITY;
	}
	public float getCHARGEMONEY() {
		return CHARGEMONEY;
	}
	public void setCHARGEMONEY(float cHARGEMONEY) {
		CHARGEMONEY = cHARGEMONEY;
	}
	public float getFQ() {
		return FQ;
	}
	public void setFQ(float fQ) {
		FQ = fQ;
	}
	public float getPQ() {
		return PQ;
	}
	public void setPQ(float pQ) {
		PQ = pQ;
	}
	public float getGQ() {
		return GQ;
	}
	public void setGQ(float gQ) {
		GQ = gQ;
	}
	public float getFF() {
		return FF;
	}
	public void setFF(float fF) {
		FF = fF;
	}
	public float getPF() {
		return PF;
	}
	public void setPF(float pF) {
		PF = pF;
	}
	public float getGF() {
		return GF;
	}
	public void setGF(float gF) {
		GF = gF;
	}
	@Override
	public String toString() {
		return "reportsDto [CSNAME=" + CSNAME + ", CSID=" + CSID
				+ ", CPUSERNAME=" + CPUSERNAME + ", CPUSERID=" + CPUSERID
				+ ", CARDNUM=" + CARDNUM + ", CARDUSERNAME=" + CARDUSERNAME
				+ ", CHARGEQUANTITY=" + CHARGEQUANTITY + ", CHARGEMONEY="
				+ CHARGEMONEY + ", JQ=" + JQ + ", FQ=" + FQ + ", PQ=" + PQ
				+ ", GQ=" + GQ + ", JF=" + JF + ", FF=" + FF + ", PF=" + PF
				+ ", GF=" + GF + ", CPUSERCOUNT=" + CPUSERCOUNT
				+ ", TOTAL_CHARGEQUANTITY=" + TOTAL_CHARGEQUANTITY
				+ ", TOTAL_CHARGEMONEY=" + TOTAL_CHARGEMONEY + ", TOTAL_JQ="
				+ TOTAL_JQ + ", TOTAL_FQ=" + TOTAL_FQ + ", TOTAL_PQ="
				+ TOTAL_PQ + ", TOTAL_GQ=" + TOTAL_GQ + ", TOTAL_JF="
				+ TOTAL_JF + ", TOTAL_FF=" + TOTAL_FF + ", TOTAL_PF="
				+ TOTAL_PF + ", TOTAL_GF=" + TOTAL_GF + ", NEW_CHARGEQUANTITY="
				+ NEW_CHARGEQUANTITY + ", NEW_CHARGEMONEY=" + NEW_CHARGEMONEY
				+ ", NEW_JQ=" + NEW_JQ + ", NEW_FQ=" + NEW_FQ + ", NEW_PQ="
				+ NEW_PQ + ", NEW_GQ=" + NEW_GQ + ", NEW_JF=" + NEW_JF
				+ ", NEW_FF=" + NEW_FF + ", NEW_PF=" + NEW_PF + ", NEW_GF="
				+ NEW_GF + "]";
	}
	
	
}

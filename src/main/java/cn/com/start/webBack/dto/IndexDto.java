package cn.com.start.webBack.dto;

public class IndexDto {
	private int CSCOUNT; // 站总数
	private int CPCOUNT; // 桩总数
	private int ACPCOUNT; // 交流总数
	private int DCPCOUNT; // 直流总数
	private float CHARGECOUNT; // 充电度数
	private float MONEYCOUNT; // 充电费用
	private float SERVICECOUNT; // 充电服务费
	private int APPCOUNT; // app用户
	private int CARDCOUNT;// 刷卡用户
	private float CARDCHARGECOUNT; //卡充值费用

	@Override
	public String toString() {
		return "IndexDto [CSCOUNT=" + CSCOUNT + ", CPCOUNT=" + CPCOUNT
				+ ", ACPCOUNT=" + ACPCOUNT + ", DCPCOUNT=" + DCPCOUNT
				+ ", CHARGECOUNT=" + CHARGECOUNT + ", MONEYCOUNT=" + MONEYCOUNT
				+ ", SERVICECOUNT=" + SERVICECOUNT + ", APPCOUNT=" + APPCOUNT
				+ ", CARDCOUNT=" + CARDCOUNT + ", CARDCHARGECOUNT="
				+ CARDCHARGECOUNT + "]";
	}
	
	
	public float getCARDCHARGECOUNT() {
		return CARDCHARGECOUNT;
	}


	public void setCARDCHARGECOUNT(float cARDCHARGECOUNT) {
		CARDCHARGECOUNT = cARDCHARGECOUNT;
	}


	public int getCSCOUNT() {
		return CSCOUNT;
	}

	public void setCSCOUNT(int cSCOUNT) {
		CSCOUNT = cSCOUNT;
	}

	public int getCPCOUNT() {
		return CPCOUNT;
	}

	public void setCPCOUNT(int cPCOUNT) {
		CPCOUNT = cPCOUNT;
	}

	public int getACPCOUNT() {
		return ACPCOUNT;
	}

	public void setACPCOUNT(int aCPCOUNT) {
		ACPCOUNT = aCPCOUNT;
	}

	public int getDCPCOUNT() {
		return DCPCOUNT;
	}

	public void setDCPCOUNT(int dCPCOUNT) {
		DCPCOUNT = dCPCOUNT;
	}

	public float getCHARGECOUNT() {
		return CHARGECOUNT;
	}

	public void setCHARGECOUNT(float cHARGECOUNT) {
		CHARGECOUNT = cHARGECOUNT;
	}

	public float getMONEYCOUNT() {
		return MONEYCOUNT;
	}

	public void setMONEYCOUNT(float mONEYCOUNT) {
		MONEYCOUNT = mONEYCOUNT;
	}

	public float getSERVICECOUNT() {
		return SERVICECOUNT;
	}

	public void setSERVICECOUNT(float sERVICECOUNT) {
		SERVICECOUNT = sERVICECOUNT;
	}

	public int getAPPCOUNT() {
		return APPCOUNT;
	}

	public void setAPPCOUNT(int aPPCOUNT) {
		APPCOUNT = aPPCOUNT;
	}

	public int getCARDCOUNT() {
		return CARDCOUNT;
	}

	public void setCARDCOUNT(int cARDCOUNT) {
		CARDCOUNT = cARDCOUNT;
	}

}

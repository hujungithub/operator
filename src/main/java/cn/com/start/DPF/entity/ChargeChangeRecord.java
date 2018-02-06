package cn.com.start.DPF.entity;

public class ChargeChangeRecord {
	private String BEGINCHARGETIME;// 开始充电时间
	private String DEVICEID;// 设备id
	private int GUN;// 枪
	private String CPID;// cpid
	private String ENDCHARGETIME;// 遥信3-0
	private int RECORDFLAG;// 是否收到充电记录

	@Override
	public String toString() {
		return "ChargeChangeRecord [BEGINCHARGETIME=" + BEGINCHARGETIME
				+ ", DEVICEID=" + DEVICEID + ", GUN=" + GUN + ", CPID=" + CPID
				+ ", ENDCHARGETIME=" + ENDCHARGETIME + ", RECORDFLAG="
				+ RECORDFLAG + "]";
	}

	public String getBEGINCHARGETIME() {
		return BEGINCHARGETIME;
	}

	public void setBEGINCHARGETIME(String bEGINCHARGETIME) {
		BEGINCHARGETIME = bEGINCHARGETIME;
	}

	public String getDEVICEID() {
		return DEVICEID;
	}

	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}

	public int getGUN() {
		return GUN;
	}

	public void setGUN(int gUN) {
		GUN = gUN;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getENDCHARGETIME() {
		return ENDCHARGETIME;
	}

	public void setENDCHARGETIME(String eNDCHARGETIME) {
		ENDCHARGETIME = eNDCHARGETIME;
	}

	public int getRECORDFLAG() {
		return RECORDFLAG;
	}

	public void setRECORDFLAG(int rECORDFLAG) {
		RECORDFLAG = rECORDFLAG;
	}

}

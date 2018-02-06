package cn.com.start.AppAPI.entity;

public class ChargeSet_TBL {
	// 充电设置ID
	private String CHAEGEID;
	// 充电桩ID
	private String CPID;
	// 开始充电时间
	private String BEGINTIME;
	// 限制数据
	private String LIMITDATA;
	// 限制类型
	private String LIMITTYPE;

	// 构造函数 ID自增
	public ChargeSet_TBL(String cpid, String begintime, String limitdata,
			String limittype) {
		this.CPID = cpid;
		this.BEGINTIME = begintime;
		this.LIMITDATA = limitdata;
		this.LIMITTYPE = limittype;
	}

	public String getCHAEGEID() {
		return CHAEGEID;
	}

	public void setCHAEGEID(String cHAEGEID) {
		CHAEGEID = cHAEGEID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getBEGINTIME() {
		return BEGINTIME;
	}

	public void setBEGINTIME(String bEGINTIME) {
		BEGINTIME = bEGINTIME;
	}

	public String getLIMITDATA() {
		return LIMITDATA;
	}

	public void setLIMITDATA(String lIMITDATA) {
		LIMITDATA = lIMITDATA;
	}

	public String getLIMITTYPE() {
		return LIMITTYPE;
	}

	public void setLIMITTYPE(String lIMITTYPE) {
		LIMITTYPE = lIMITTYPE;
	}
}

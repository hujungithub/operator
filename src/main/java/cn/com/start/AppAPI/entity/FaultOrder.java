package cn.com.start.AppAPI.entity;

public class FaultOrder {

	private String ID; // 订单id
	private String BEGINTIME;// 开始维修时间
	private String ENDTIME;// 结束维修时间
	private String CPID;// 桩id
	private String REPAIRMANID;// 修理人员id
	private String STATE;// 修理状态
	private String PRICE;// 订单金额

	@Override
	public String toString() {
		return "FaultOrder [ID=" + ID + ", BEGINTIME=" + BEGINTIME
				+ ", ENDTIME=" + ENDTIME + ", CPID=" + CPID + ", REPAIRMANID="
				+ REPAIRMANID + ", STATE=" + STATE + ", PRICE=" + PRICE + "]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getBEGINTIME() {
		return BEGINTIME;
	}

	public void setBEGINTIME(String bEGINTIME) {
		BEGINTIME = bEGINTIME;
	}

	public String getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getREPAIRMANID() {
		return REPAIRMANID;
	}

	public void setREPAIRMANID(String rEPAIRMANID) {
		REPAIRMANID = rEPAIRMANID;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

}

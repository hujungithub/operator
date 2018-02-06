package cn.com.start.AppAPI.dto;

public class ChargePileDto {

	private String CPID;// 桩id
	private String CPNM;// 桩名
	private String CURRSTATE;// 当前状态
	private String COMMSTATE;// 通信状态
	private String PRICE;// 充电价格
	private String POWER;// 功率
	private String PARKNO;// 车位号
	private String INTERNUM;// 枪头 直流单枪 直流双枪
	private String PARKSTATE;// 车位状态
	private String CPTYPE;// 桩类型

	public String getCPID() {
		return CPID;
	}

	public String getPOWER() {
		return POWER;
	}

	public void setPOWER(String pOWER) {
		POWER = pOWER;
	}

	public String getPARKNO() {
		return PARKNO;
	}

	public void setPARKNO(String pARKNO) {
		PARKNO = pARKNO;
	}

	public String getINTERNUM() {
		return INTERNUM;
	}

	public void setINTERNUM(String iNTERNUM) {
		INTERNUM = iNTERNUM;
	}

	public String getPARKSTATE() {
		return PARKSTATE;
	}

	public void setPARKSTATE(String pARKSTATE) {
		PARKSTATE = pARKSTATE;
	}

	public String getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(String cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPNM() {
		return CPNM;
	}

	public void setCPNM(String cPNM) {
		CPNM = cPNM;
	}

	public String getCURRSTATE() {
		return CURRSTATE;
	}

	public void setCURRSTATE(String cURRSTATE) {
		CURRSTATE = cURRSTATE;
	}

	public String getCOMMSTATE() {
		return COMMSTATE;
	}

	public void setCOMMSTATE(String cOMMSTATE) {
		COMMSTATE = cOMMSTATE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	@Override
	public String toString() {
		return "ChargePileDto [CPID=" + CPID + ", CPNM=" + CPNM
				+ ", CURRSTATE=" + CURRSTATE + ", COMMSTATE=" + COMMSTATE
				+ ", PRICE=" + PRICE + ", POWER=" + POWER + ", PARKNO="
				+ PARKNO + ", INTERNUM=" + INTERNUM + ", PARKSTATE="
				+ PARKSTATE + ", CPTYPE=" + CPTYPE + "]";
	}

}

package cn.com.start.webBack.dto;

public class AppUserChargeRecordDto {
	private Integer ID; // id
	private String CPUSERNAME;// 用户名
	private String TELEPHONE;// 手机号
	private String RECHARGETIME;// 充值时间
	private Float RECHARGEMONEY;// 充值金额
	private Float BALANCE;// 余额
	private String PAYMENTMODENAME;// 支付方式
	private String PAYRESULT;// 操作结果

	@Override
	public String toString() {
		return "AppUserChargeRecordDto [ID=" + ID + ", CPUSERNAME="
				+ CPUSERNAME + ", TELEPHONE=" + TELEPHONE + ", RECHARGETIME="
				+ RECHARGETIME + ", RECHARGEMONEY=" + RECHARGEMONEY
				+ ", BALANCE=" + BALANCE + ", PAYMENTMODENAME="
				+ PAYMENTMODENAME + ", PAYRESULT=" + PAYRESULT + "]";
	}

	public float getBALANCE() {
		return BALANCE;
	}

	public void setBALANCE(Float bALANCE) {
		BALANCE = bALANCE;
	}

	public String getCPUSERNAME() {
		return CPUSERNAME;
	}

	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getRECHARGETIME() {
		return RECHARGETIME;
	}

	public void setRECHARGETIME(String rECHARGETIME) {
		RECHARGETIME = rECHARGETIME;
	}

	public float getRECHARGEMONEY() {
		return RECHARGEMONEY;
	}

	public void setRECHARGEMONEY(Float rECHARGEMONEY) {
		RECHARGEMONEY = rECHARGEMONEY;
	}

	public String getPAYMENTMODENAME() {
		return PAYMENTMODENAME;
	}

	public void setPAYMENTMODENAME(String pAYMENTMODENAME) {
		PAYMENTMODENAME = pAYMENTMODENAME;
	}

	public String getPAYRESULT() {
		return PAYRESULT;
	}

	public void setPAYRESULT(String pAYRESULT) {
		PAYRESULT = pAYRESULT;
	}

}

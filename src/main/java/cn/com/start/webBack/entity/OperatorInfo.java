package cn.com.start.webBack.entity;

// 运营商
public class OperatorInfo {

	// 运营商ID
	private int OPERATORID;
	private String BOSSID;
	// 运营商名称
	private String OPERATORNAME;
	// 联系电话
	private String TELEPHONE;
	// 联系邮箱
	private String EMAIL;
	// 联系地址
	private String ADDRESS;
	// 是否可用
	private String VALIDFLAG;
	// 联系人
	private String CONTACTNAME;
	private String OPERATORLOGINID;

	@Override
	public String toString() {
		return "OperatorInfo [OPERATORID=" + OPERATORID + ", BOSSID=" + BOSSID + ", OPERATORNAME=" + OPERATORNAME
				+ ", TELEPHONE=" + TELEPHONE + ", EMAIL=" + EMAIL + ", ADDRESS=" + ADDRESS + ", VALIDFLAG=" + VALIDFLAG
				+ ", CONTACTNAME=" + CONTACTNAME + ", OPERATORLOGINID=" + OPERATORLOGINID + "]";
	}

	public String getOPERATORNAME() {
		return OPERATORNAME;
	}

	public void setOPERATORNAME(String oPERATORNAME) {
		OPERATORNAME = oPERATORNAME;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public String getCONTACTNAME() {
		return CONTACTNAME;
	}

	public void setCONTACTNAME(String cONTACTNAME) {
		CONTACTNAME = cONTACTNAME;
	}

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public void setBOSSID(String bOSSID) {
		BOSSID = bOSSID;
	}

	public String getBOSSID() {
		return BOSSID;
	}

	public int getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(int oPERATORID) {
		OPERATORID = oPERATORID;
	}

}

package cn.com.start.webBack.dto;

public class OperatorInfoDto {

	// 运营商ID
	private int OPERATORID;
	
	private int BOSSID;
	// 运营商名称
	private String OPERATORNAME;
	// 联系电话
	private String TELEPHONE;
	// 联系邮箱
	private String EMAIL;
	// 联系地址
	private String ADDRESS;
	// 联系人
	private String CONTACTNAME;
	// 是否可用
	private String VALIDFLAG;

	@Override
	public String toString() {
		return "OperatorInfoDto [OPERATORID=" + OPERATORID + ", BOSSID="
				+ BOSSID + ", OPERATORNAME=" + OPERATORNAME + ", TELEPHONE="
				+ TELEPHONE + ", EMAIL=" + EMAIL + ", ADDRESS=" + ADDRESS
				+ ", CONTACTNAME=" + CONTACTNAME + ", VALIDFLAG=" + VALIDFLAG
				+ "]";
	}

	public int getBOSSID() {
		return BOSSID;
	}

	public void setBOSSID(int bOSSID) {
		BOSSID = bOSSID;
	}

	public int getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(int oPERATORID) {
		OPERATORID = oPERATORID;
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

	public String getCONTACTNAME() {
		return CONTACTNAME;
	}

	public void setCONTACTNAME(String cONTACTNAME) {
		CONTACTNAME = cONTACTNAME;
	}

	public String getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(String vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

}

package cn.com.start.webBack.dto;

public class FindUserInfoDto extends BaseFindDto {
	// 用户名
	private String USERNAME;

	// 角色ID
	private String ROLEID;

	private String OPERATORID;

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getROLEID() {
		return ROLEID;
	}

	public void setROLEID(String rOLEID) {
		ROLEID = rOLEID;
	}

	public String getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}

	@Override
	public String toString() {
		return "FindUserInfoDto [USERNAME=" + USERNAME + ", ROLEID=" + ROLEID
				+ ", OPERATORID=" + OPERATORID + ", startPos=" + startPos
				+ ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ ", OPERATORLOGINID=" + OPERATORLOGINID + ", ROLELOGINID="
				+ ROLELOGINID + ", FROMDATE=" + FROMDATE + ", TODATE=" + TODATE
				+ "]";
	}

}

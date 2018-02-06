package cn.com.start.webBack.dto;

public class FindBillModelDto {
	private String OPERATORID;
	private String OPERATORLOGINID;
	private String CSID;
	private String RATEID;// 套 1-4
	private String BILLMODELID;// 模板 1-12
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
	}
	public String getRATEID() {
		return RATEID;
	}
	public void setRATEID(String rATEID) {
		RATEID = rATEID;
	}
	public String getBILLMODELID() {
		return BILLMODELID;
	}
	public void setBILLMODELID(String bILLMODELID) {
		BILLMODELID = bILLMODELID;
	}
	@Override
	public String toString() {
		return "FindBillModelDto [OPERATORID=" + OPERATORID + ", OPERATORLOGINID=" + OPERATORLOGINID + ", CSID=" + CSID
				+ ", RATEID=" + RATEID + ", BILLMODELID=" + BILLMODELID + "]";
	}
	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}
	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}
	public String getCSID() {
		return CSID;
	}
	public void setCSID(String cSID) {
		CSID = cSID;
	}
	
}

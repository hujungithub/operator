package cn.com.start.AppAPI.dto;

public class CscpIdDto {
	public String csId;
	public String cpId;
	
	@Override
	public String toString() {
		return "CscpIdDto [csId=" + csId + ", cpId=" + cpId + "]";
	}
	public String getCsId() {
		return csId;
	}
	public void setCsId(String csId) {
		this.csId = csId;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
	}
	
	
	
}

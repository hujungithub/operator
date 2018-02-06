package cn.com.start.webBack.dto;

import java.util.List;
import java.util.Map;

public class itemDto {
	private List<Map<String,Object>> reportslist;
	private String CPUSERNAME;
	
	public List<Map<String, Object>> getReportslist() {
		return reportslist;
	}
	public void setReportslist(List<Map<String, Object>> reportslist) {
		this.reportslist = reportslist;
	}
	public String getCPUSERNAME() {
		return CPUSERNAME;
	}
	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}
	
	
	
}

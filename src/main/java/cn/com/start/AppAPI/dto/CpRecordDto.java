package cn.com.start.AppAPI.dto;

public class CpRecordDto {
	private String cpid;
	private String totalquantity;
	private String begintime;
	private String totalfee;
	private String totaltime;

	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public String getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(String totalquantity) {
		this.totalquantity = totalquantity;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(String totalfee) {
		this.totalfee = totalfee;
	}

	public String getTotaltime() {
		return totaltime;
	}

	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
}

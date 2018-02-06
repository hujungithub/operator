package cn.com.start.DPF.entity;

import java.util.Date;

public class CardOpResult {
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	private String result;
	private Date time;
}

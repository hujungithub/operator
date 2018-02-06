package cn.com.start.webBack.dto;

import java.util.List;

public class ChargeReportsDto {
	private String USERID;// 用户id
	private String USERNAME;// 用户名
	private String CARDNUM;// 卡号
	private List<reportsDto> TOTALLIST;
	private List<reportsDto> dalianlulist;// 充电站list
	private List<reportsDto> pinglianglulist;// 充电站list

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getCARDNUM() {
		return CARDNUM;
	}

	public void setCARDNUM(String cARDNUM) {
		CARDNUM = cARDNUM;
	}

	public List<reportsDto> getTOTALLIST() {
		return TOTALLIST;
	}

	public void setTOTALLIST(List<reportsDto> tOTALLIST) {
		TOTALLIST = tOTALLIST;
	}

	public List<reportsDto> getDalianlulist() {
		return dalianlulist;
	}

	public void setDalianlulist(List<reportsDto> reportsDto) {
		this.dalianlulist = reportsDto;
	}

	public List<reportsDto> getPinglianglulist() {
		return pinglianglulist;
	}

	public void setPinglianglulist(List<reportsDto> pinglianglulist) {
		this.pinglianglulist = pinglianglulist;
	}

	@Override
	public String toString() {
		return "ChargeReportsDto [USERID=" + USERID + ", USERNAME=" + USERNAME
				+ ", CARDNUM=" + CARDNUM + ", TOTALLIST=" + TOTALLIST
				+ ", dalianlulist=" + dalianlulist + ", pinglianglulist="
				+ pinglianglulist + "]";
	}

}

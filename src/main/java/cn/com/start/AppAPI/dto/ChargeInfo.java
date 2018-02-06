package cn.com.start.AppAPI.dto;

public class ChargeInfo {
	public String voltageA;
	public String voltageB;
	public String voltageC;
	public String currentA;
	public String currentB;
	public String currentC;
	public String quantity;
	public String fee;
	public String serialNo;
	public String time;
	public String chargeDuration;
	public String price;
	public String soc;
	
	/*
	 * 结束标志:pileEnd
	 */
	public String command;
	
	/*
	 * 3：充电中，4：故障情况
	 */
//	public String status;
}

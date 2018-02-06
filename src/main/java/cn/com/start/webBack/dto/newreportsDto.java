package cn.com.start.webBack.dto;

public class newreportsDto {
	private String CSID;
	
	private float CHARGEQUANTITY;//充电电量
	private float CHARGEMONEY;//充电金额
	private float JQ;//尖电量
	private float FQ;//峰电量
	private float PQ;//平电量
	private float GQ;//谷电量
	private float JF;//尖费用
	private float FF;//峰费用
	private float PF;//平费用
	private float GF;//谷费用
	
	
	public newreportsDto(String csid){
		this.CSID = csid;
		this.CHARGEQUANTITY = 0;
		this.CHARGEMONEY = 0;
		this.JQ = 0;
		this.FQ = 0;
		this.PQ = 0;
		this.GQ = 0;
		this.JF = 0;
		this.FF = 0;
		this.PF = 0;
		this.GF = 0;
	}
}

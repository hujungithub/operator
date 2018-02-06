package cn.com.start.AppAPI.entity;

public class Assess_TBL {
	// 订单ID
	private String ORDERID;
	// 评价时间
	private String ASSTIME;
	// 评价内容
	private String CONTENT;
	// 评价星际
	private String GRADE;

	public Assess_TBL(String orderId, String assTime, String content,
			String grade) {
		this.ORDERID = orderId;
		this.ASSTIME = assTime;
		this.CONTENT = content;
		this.GRADE = grade;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getASSTIME() {
		return ASSTIME;
	}

	public void setASSTIME(String aSSTIME) {
		ASSTIME = aSSTIME;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getGRADE() {
		return GRADE;
	}

	public void setGRADE(String gRADE) {
		GRADE = gRADE;
	}

	@Override
	public String toString() {
		return "Assess_TBL [ORDERID=" + ORDERID + ", ASSTIME=" + ASSTIME
				+ ", CONTENT=" + CONTENT + ", GRADE=" + GRADE + "]";
	}
}

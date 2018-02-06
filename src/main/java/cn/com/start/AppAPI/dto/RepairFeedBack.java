package cn.com.start.AppAPI.dto;

public class RepairFeedBack {

	private String CONTENT;// 备注
	private String ENDTIME;// 结束时间
	private String PARTS; // 配件
	private String ORDERID; // 订单id
	private String PICPATH; // 图片保存路径

	@Override
	public String toString() {
		return "RepairFeedBack [CONTENT=" + CONTENT + ", ENDTIME=" + ENDTIME
				+ ", PARTS=" + PARTS + ", ORDERID=" + ORDERID + ", PICPATH="
				+ PICPATH + "]";
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getENDTIME() {
		return ENDTIME;
	}

	public void setENDTIME(String eNDTIME) {
		ENDTIME = eNDTIME;
	}

	public String getPARTS() {
		return PARTS;
	}

	public void setPARTS(String pARTS) {
		PARTS = pARTS;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getPICPATH() {
		return PICPATH;
	}

	public void setPICPATH(String pICPATH) {
		PICPATH = pICPATH;
	}

}

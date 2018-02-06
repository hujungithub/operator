package cn.com.start.webBack.dto;

public class WeChatDto {

	private String TRANSACTIONNUM;
	
	private String USERID;
	
	private String PAYTIMEFROM;
	
	private String PAYTIMETO;
	
	private String REFUNDSTATUS;
	
	private String pageSize;// jsp 每页条数
	private String pageNow;// jsp 当前页
	private int pageSizeInt;// sql 每页条数
	private int pageNowInt;// sql 当前页
	private int startPos; // 开始位置

	@Override
	public String toString() {
		return "WeChatDto [TRANSACTIONNUM=" + TRANSACTIONNUM + ", USERID="
				+ USERID + ", PAYTIMEFROM=" + PAYTIMEFROM + ", PAYTIMETO="
				+ PAYTIMETO + ", REFUNDSTATUS=" + REFUNDSTATUS
				+ ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ ", pageSizeInt=" + pageSizeInt + ", pageNowInt=" + pageNowInt
				+ ", startPos=" + startPos + "]";
	}

	public String getTRANSACTIONNUM() {
		return TRANSACTIONNUM;
	}

	public void setTRANSACTIONNUM(String tRANSACTIONNUM) {
		TRANSACTIONNUM = tRANSACTIONNUM;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPAYTIMEFROM() {
		return PAYTIMEFROM;
	}

	public void setPAYTIMEFROM(String pAYTIMEFROM) {
		PAYTIMEFROM = pAYTIMEFROM;
	}

	public String getPAYTIMETO() {
		return PAYTIMETO;
	}

	public void setPAYTIMETO(String pAYTIMETO) {
		PAYTIMETO = pAYTIMETO;
	}

	public String getREFUNDSTATUS() {
		return REFUNDSTATUS;
	}

	public void setREFUNDSTATUS(String rEFUNDSTATUS) {
		REFUNDSTATUS = rEFUNDSTATUS;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSizeInt() {
		return pageSizeInt;
	}

	public void setPageSizeInt(int pageSizeInt) {
		this.pageSizeInt = pageSizeInt;
	}

	public int getPageNowInt() {
		return pageNowInt;
	}

	public void setPageNowInt(int pageNowInt) {
		this.pageNowInt = pageNowInt;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
}

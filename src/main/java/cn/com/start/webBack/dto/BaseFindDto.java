package cn.com.start.webBack.dto;

public class BaseFindDto {
	public Integer startPos; // 开始位置
	public Integer pageSize; // 每页条数
	public Integer pageNow;// 当前页
	public String OPERATORLOGINID; // 登录用户运营商id
	public String ROLELOGINID; // 登录用户角色id
	public String FROMDATE;// 开始日期
	public String TODATE; // 结束日期

	public String getOPERATORLOGINID() {
		return OPERATORLOGINID;
	}

	public void setOPERATORLOGINID(String oPERATORLOGINID) {
		OPERATORLOGINID = oPERATORLOGINID;
	}

	public String getROLELOGINID() {
		return ROLELOGINID;
	}

	public void setROLELOGINID(String rOLELOGINID) {
		ROLELOGINID = rOLELOGINID;
	}

	public Integer getStartPos() {
		return startPos;
	}

	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public String getFROMDATE() {
		return FROMDATE;
	}

	public void setFROMDATE(String fROMDATE) {
		FROMDATE = fROMDATE;
	}

	public String getTODATE() {
		return TODATE;
	}

	public void setTODATE(String tODATE) {
		TODATE = tODATE;
	}

}

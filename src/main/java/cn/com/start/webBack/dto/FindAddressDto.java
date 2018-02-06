package cn.com.start.webBack.dto;

public class FindAddressDto extends BaseFindDto {
	private String PROVINCEID; // 省id
	private String CITYID; // 市id
	private String AREAID; // 区域id
	private String ADDRESSNAME;// 地址名

	public String getPROVINCEID() {
		return PROVINCEID;
	}

	public void setPROVINCEID(String pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}

	public String getCITYID() {
		return CITYID;
	}

	public void setCITYID(String cITYID) {
		CITYID = cITYID;
	}

	public String getAREAID() {
		return AREAID;
	}

	public void setAREAID(String aREAID) {
		AREAID = aREAID;
	}

	public String getADDRESSNAME() {
		return ADDRESSNAME;
	}

	public void setADDRESSNAME(String aDDRESSNAME) {
		ADDRESSNAME = aDDRESSNAME;
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

	public Integer getStartPos() {
		return startPos;
	}

	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}

	@Override
	public String toString() {
		return "FindAddressDto [PROVINCEID=" + PROVINCEID + ", CITYID="
				+ CITYID + ", AREAID=" + AREAID + ", ADDRESSNAME="
				+ ADDRESSNAME + ", pageSize=" + pageSize + ", pageNow="
				+ pageNow + ", startPos=" + startPos + ", OPERATORLOGINID="
				+ OPERATORLOGINID + ", ROLELOGINID=" + ROLELOGINID + "]";
	}

}

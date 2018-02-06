package cn.com.start.webBack.dto;

import java.util.Arrays;

public class FindManufDto extends BaseFindDto {

	private String MFRNAME;

	private String MODEL;

	private String[] models;
	private String[] mfrids;

	public String[] getModels() {
		return models;
	}

	public void setModels(String[] models) {
		this.models = models;
	}

	public String[] getMfrids() {
		return mfrids;
	}

	public void setMfrids(String[] mfrids) {
		this.mfrids = mfrids;
	}

	public String getMFRNAME() {
		return MFRNAME;
	}

	public void setMFRNAME(String mFRNAME) {
		MFRNAME = mFRNAME;
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

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

	@Override
	public String toString() {
		return "FindManufDto [MFRNAME=" + MFRNAME + ", MODEL=" + MODEL
				+ ", pageSize=" + pageSize + ", pageNow=" + pageNow
				+ " startPos=" + startPos + ", models="
				+ Arrays.toString(models) + ", mfrids="
				+ Arrays.toString(mfrids) + ", OPERATORLOGINID="
				+ OPERATORLOGINID + ", ROLELOGINID=" + ROLELOGINID + "]";
	}

}

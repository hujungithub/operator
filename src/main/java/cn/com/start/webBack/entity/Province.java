package cn.com.start.webBack.entity;

//省
public class Province {

	// 省份ID 主键
	private int PROVINCEID;
	// 省份名
	private String PROVINCENAME;
	public int getPROVINCEID() {
		return PROVINCEID;
	}

	public void setPROVINCEID(int pROVINCEID) {
		PROVINCEID = pROVINCEID;
	}

	public String getPROVINCENAME() {
		return PROVINCENAME;
	}

	public void setPROVINCENAME(String pROVINCENAME) {
		PROVINCENAME = pROVINCENAME;
	}

	@Override
	public String toString() {
		return "Province [PROVINCEID=" + PROVINCEID + ", PROVINCENAME="
				+ PROVINCENAME + "]";
	}

}

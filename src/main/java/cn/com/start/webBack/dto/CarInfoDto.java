package cn.com.start.webBack.dto;
/**
 * 
 * @author hanmj
 * 
 * date 20170817
 *
 */
public class CarInfoDto extends BaseFindDto{
	
	// 车ID
	private String CARID;
	// 车牌号
	private String CARPLATE;
	//预约ID
	private Integer APPOINTID;
	//车状体
	private String CARSTATE;
	//车型号
	private String CARMODEL;
	//soc	应该使用String 有时间改为String
	private Integer CARSOC;
	//租赁价格
	private String PRICEID;
	//综合评价
	private Integer RANK;
	//续航里程
	private Integer MILEAGE;
	//经度
	private String LONGITUDE;
	//维度
	private String LATITUDE;
	public String getCARID() {
		return CARID;
	}
	
	public String getCARSTATE() {
		return CARSTATE;
	}

	public void setCARSTATE(String cARSTATE) {
		CARSTATE = cARSTATE;
	}

	public String getCARMODEL() {
		return CARMODEL;
	}

	public void setCARMODEL(String cARMODEL) {
		CARMODEL = cARMODEL;
	}

	public String getPRICEID() {
		return PRICEID;
	}

	public void setPRICEID(String pRICEID) {
		PRICEID = pRICEID;
	}

	public void setCARID(String cARID) {
		CARID = cARID;
	}
	public String getCARPLATE() {
		return CARPLATE;
	}
	public void setCARPLATE(String cARPLATE) {
		CARPLATE = cARPLATE;
	}
	public Integer getAPPOINTID() {
		return APPOINTID;
	}
	public void setAPPOINTID(Integer aPPOINTID) {
		APPOINTID = aPPOINTID;
	}
	public Integer getCARSOC() {
		return CARSOC;
	}
	public void setCARSOC(Integer cARSOC) {
		CARSOC = cARSOC;
	}
	public Integer getRANK() {
		return RANK;
	}
	public void setRANK(Integer rANK) {
		RANK = rANK;
	}
	public Integer getMILEAGE() {
		return MILEAGE;
	}
	public void setMILEAGE(Integer mILEAGE) {
		MILEAGE = mILEAGE;
	}
	public String getLONGITUDE() {
		return LONGITUDE;
	}
	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}
	public String getLATITUDE() {
		return LATITUDE;
	}
	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}
	@Override
	public String toString() {
		return "CarInfoDto [CARID=" + CARID + ", CARPLATE=" + CARPLATE
				+ ", APPOINTID=" + APPOINTID + ", CARSTATE=" + CARSTATE
				+ ", CARMODEL=" + CARMODEL + ", CARSOC=" + CARSOC
				+ ", PRICEID=" + PRICEID + ", RANK=" + RANK + ", MILEAGE="
				+ MILEAGE + ", LONGITUDE=" + LONGITUDE + ", LATITUDE="
				+ LATITUDE + "]";
	}
	
}

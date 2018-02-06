package cn.com.start.webBack.dto;

public class FindCpUserDto extends BaseFindDto {

	private String CPUSERNAME;// 用户名
	private String MEMBERCARDID;// 会员卡号
	private String CREDITLEVEL;// 信用等级
	private String PLATENUMBER;// 车牌号
	private String TELEPHONE;// 电话
	private String FROMDATE;// 开始日期
	private String TODATE;// 结束日期
	private String CPUSERID;// 用户id

	public String getCPUSERID() {
		return CPUSERID;
	}

	public void setCPUSERID(String cPUSERID) {
		CPUSERID = cPUSERID;
	}

	public String getCPUSERNAME() {
		return CPUSERNAME;
	}

	public void setCPUSERNAME(String cPUSERNAME) {
		CPUSERNAME = cPUSERNAME;
	}

	public String getMEMBERCARDID() {
		return MEMBERCARDID;
	}

	public void setMEMBERCARDID(String mEMBERCARDID) {
		MEMBERCARDID = mEMBERCARDID;
	}

	public String getCREDITLEVEL() {
		return CREDITLEVEL;
	}

	public void setCREDITLEVEL(String cREDITLEVEL) {
		CREDITLEVEL = cREDITLEVEL;
	}

	public String getPLATENUMBER() {
		return PLATENUMBER;
	}

	public void setPLATENUMBER(String pLATENUMBER) {
		PLATENUMBER = pLATENUMBER;
	}

	public String getTELEPHONE() {
		return TELEPHONE;
	}

	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
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

	@Override
	public String toString() {
		return "FindCpUserDto [CPUSERNAME=" + CPUSERNAME + ", MEMBERCARDID="
				+ MEMBERCARDID + ", CREDITLEVEL=" + CREDITLEVEL
				+ ", PLATENUMBER=" + PLATENUMBER + ", TELEPHONE=" + TELEPHONE
				+ ", FROMDATE=" + FROMDATE + ", TODATE=" + TODATE
				+ ", CPUSERID=" + CPUSERID + ", pageSize=" + pageSize
				+ ", pageNow=" + pageNow + ", startPos=" + startPos + "]";
	}

}

package cn.com.start.AppAPI.dto;

public class UserProfileInfoDto {
	public String CPUSERID;
	public String CPUSERNAME;
	public String SEX;
	public String PLATENUMBER;
	public String VIN;
	
	
	@Override
	public String toString() {
		return "UserProfileInfoDto [CPUSERID=" + CPUSERID + ", CPUSERNAME="
				+ CPUSERNAME + ", SEX=" + SEX + ", PLATENUMBER=" + PLATENUMBER
				+ ", VIN=" + VIN + "]";
	}
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
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getPLATENUMBER() {
		return PLATENUMBER;
	}
	public void setPLATENUMBER(String pLATENUMBER) {
		PLATENUMBER = pLATENUMBER;
	}
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	
	

	

	
	
}

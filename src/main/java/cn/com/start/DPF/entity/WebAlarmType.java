package cn.com.start.DPF.entity;

public class WebAlarmType {
	private int ALARMID;
	private String ALARMDESP;

	@Override
	public String toString() {
		return "WebAlarmType [ALARMID=" + ALARMID + ", ALARMDESP=" + ALARMDESP
				+ "]";
	}

	public int getALARMID() {
		return ALARMID;
	}

	public void setALARMID(int aLARMID) {
		ALARMID = aLARMID;
	}

	public String getALARMDESP() {
		return ALARMDESP;
	}

	public void setALARMDESP(String aLARMDESP) {
		ALARMDESP = aLARMDESP;
	}

}

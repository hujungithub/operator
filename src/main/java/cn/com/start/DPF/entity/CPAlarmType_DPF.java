package cn.com.start.DPF.entity;

public class CPAlarmType_DPF {
	private int ALARMID; // 告警ID
	private String ALARMNAME; // 告警名称
	private String ALARMDESP; // 告警描述

	@Override
	public String toString() {
		return "CPAlarmType_DPF [ALARMID=" + ALARMID + ", ALARMNAME="
				+ ALARMNAME + ", ALARMDESP=" + ALARMDESP + "]";
	}

	public int getALARMID() {
		return ALARMID;
	}

	public void setALARMID(int aLARMID) {
		ALARMID = aLARMID;
	}

	public String getALARMNAME() {
		return ALARMNAME;
	}

	public void setALARMNAME(String aLARMNAME) {
		ALARMNAME = aLARMNAME;
	}

	public String getALARMDESP() {
		return ALARMDESP;
	}

	public void setALARMDESP(String aLARMDESP) {
		ALARMDESP = aLARMDESP;
	}

}

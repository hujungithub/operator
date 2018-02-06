package cn.com.start.DPF.entity;

import java.io.Serializable;

public class CPInfo_DPF implements Serializable {
	public static final long serialVersionUID = -1276900590205535317L;
	public String CPID; // 桩ID（区域编码+4位） XXXX
	public String CPNAME; // 桩名称（区域地质+桩编号）
	public int CPPROPERTY; // 桩属性（0：离散 1:CPM 2：充电站）
	public int ADDRESSID;// 地址ID XXXX
	public int OPERATORID;// 运营商ID
	public int CPMID;// CPMID XXXX
	public int CSID; // 站ID XXXX
	public String IPADDRESS;// IP地址 192.168.8.111
	public int PORT;// 端口号 8080
	public int COMMCYCLE;// 通信周期 15 秒
	public int ALARMFLAG;// 报警标志（0:不可用 1:可用）
	public int SAVEFLAG;// 数据入库标志 （0：否 1：入库）
	public int VALIDFLAG;// 是否可用（0:否 1:可用）
	public int MFRID;// 厂商ID
	public String MODEL;// 型号
	public String CREATETIME;// 建桩日期
	public int SAVECYCLE;// 入库周期（20） 10-60
	public int RATEID;// 费率id
	public int PROTOCOLID; // 协议ID
	public int FIELD;// 桩属性 公有私有
	public String DEVICEID;// 设备编号 硬件
	// // zz
	public float RATEDPOWER;// 额定功率 7（单位Kw）
	public int CPTYPE;// 类型（0：直流 1:交流）
	public int CPPHASE;// 相数（0：单相 1：三相）
	public int INTERFACECOUNT;// 枪数（0：单枪 1：双枪 2:4枪）

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CPInfo_DPF [CPID=" + CPID + ", CPNAME=" + CPNAME
				+ ", CPPROPERTY=" + CPPROPERTY + ", ADDRESSID=" + ADDRESSID
				+ ", OPERATORID=" + OPERATORID + ", CPMID=" + CPMID + ", CSID="
				+ CSID + ", IPADDRESS=" + IPADDRESS + ", PORT=" + PORT
				+ ", COMMCYCLE=" + COMMCYCLE + ", ALARMFLAG=" + ALARMFLAG
				+ ", SAVEFLAG=" + SAVEFLAG + ", VALIDFLAG=" + VALIDFLAG
				+ ", MFRID=" + MFRID + ", MODEL=" + MODEL + ", CREATETIME="
				+ CREATETIME + ", SAVECYCLE=" + SAVECYCLE + ", RATEID="
				+ RATEID + ", PROTOCOLID=" + PROTOCOLID + ", FIELD=" + FIELD
				+ ", DEVICEID=" + DEVICEID + ", RATEDPOWER=" + RATEDPOWER
				+ ", CPTYPE=" + CPTYPE + ", CPPHASE=" + CPPHASE
				+ ", INTERFACECOUNT=" + INTERFACECOUNT + "]";
	}

	public String getMODEL() {
		return MODEL;
	}

	public void setMODEL(String mODEL) {
		MODEL = mODEL;
	}

	public int getFIELD() {
		return FIELD;
	}

	public void setFIELD(int fIELD) {
		FIELD = fIELD;
	}

	public String getDEVICEID() {
		return DEVICEID;
	}

	public void setDEVICEID(String dEVICEID) {
		DEVICEID = dEVICEID;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public String getCPNAME() {
		return CPNAME;
	}

	public void setCPNAME(String cPNAME) {
		CPNAME = cPNAME;
	}

	public int getCPPROPERTY() {
		return CPPROPERTY;
	}

	public void setCPPROPERTY(int cPPROPERTY) {
		CPPROPERTY = cPPROPERTY;
	}

	public int getADDRESSID() {
		return ADDRESSID;
	}

	public void setADDRESSID(int aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}

	public int getOPERATORID() {
		return OPERATORID;
	}

	public void setOPERATORID(int oPERATORID) {
		OPERATORID = oPERATORID;
	}

	public int getCPMID() {
		return CPMID;
	}

	public void setCPMID(int cPMID) {
		CPMID = cPMID;
	}

	public int getCSID() {
		return CSID;
	}

	public void setCSID(int cSID) {
		CSID = cSID;
	}

	public float getRATEDPOWER() {
		return RATEDPOWER;
	}

	public void setRATEDPOWER(float rATEDPOWER) {
		RATEDPOWER = rATEDPOWER;
	}

	public int getCPTYPE() {
		return CPTYPE;
	}

	public void setCPTYPE(int cPTYPE) {
		CPTYPE = cPTYPE;
	}

	public int getCPPHASE() {
		return CPPHASE;
	}

	public void setCPPHASE(int cPPHASE) {
		CPPHASE = cPPHASE;
	}

	public int getINTERFACECOUNT() {
		return INTERFACECOUNT;
	}

	public void setINTERFACECOUNT(int iNTERFACECOUNT) {
		INTERFACECOUNT = iNTERFACECOUNT;
	}

	public String getIPADDRESS() {
		return IPADDRESS;
	}

	public void setIPADDRESS(String iPADDRESS) {
		IPADDRESS = iPADDRESS;
	}

	public int getPORT() {
		return PORT;
	}

	public void setPORT(int pORT) {
		PORT = pORT;
	}

	public int getCOMMCYCLE() {
		return COMMCYCLE;
	}

	public void setCOMMCYCLE(int cOMMCYCLE) {
		COMMCYCLE = cOMMCYCLE;
	}

	public int getALARMFLAG() {
		return ALARMFLAG;
	}

	public void setALARMFLAG(int aLARMFLAG) {
		ALARMFLAG = aLARMFLAG;
	}

	public int getSAVEFLAG() {
		return SAVEFLAG;
	}

	public void setSAVEFLAG(int sAVEFLAG) {
		SAVEFLAG = sAVEFLAG;
	}

	public int getVALIDFLAG() {
		return VALIDFLAG;
	}

	public void setVALIDFLAG(int vALIDFLAG) {
		VALIDFLAG = vALIDFLAG;
	}

	public int getMFRID() {
		return MFRID;
	}

	public void setMFRID(int mFRID) {
		MFRID = mFRID;
	}

	public String getCREATETIME() {
		return CREATETIME;
	}

	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}

	public int getSAVECYCLE() {
		return SAVECYCLE;
	}

	public void setSAVECYCLE(int sAVECYCLE) {
		SAVECYCLE = sAVECYCLE;
	}

	public int getRATEID() {
		return RATEID;
	}

	public void setRATEID(int rATEID) {
		RATEID = rATEID;
	}

	public int getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(int pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

}

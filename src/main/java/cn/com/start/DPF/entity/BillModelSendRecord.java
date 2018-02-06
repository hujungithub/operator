package cn.com.start.DPF.entity;

public class BillModelSendRecord {

	private String CPID;// 桩ID
	private int BILLID;// 费率ID
	private String RECORDTIME;// 记录时间
	private String VALIDTIME;// 生效时间
	private String INVALIDTIME;// 失效时间
	private int EXECUTIONSTATE;// 执行状态
	private int MEASUREMENTTYPE;// 计量类型
	private int TIMEINTERVALCOUNT;// 时间段
	private String TISTRING;// 时间点和标识符号
	private float JPRICE;// 尖电价
	private float FPRICE;// 平电价
	private float PPRICE;// 峰电价
	private float GPRICE;// 谷电价
	private float SERVICETIP;// 服务费
	private int SENDFLAG;// 发送标志
	private int ACTIVEREQUESTFLAG;// 主动请求标志位
	private int FINISHEDFLAG;// 结束标志
	private int BILLIDRETURN;// 返回的费率id
	private int RESULTRETURN;// 返回结果

	@Override
	public String toString() {
		return "BillModelSendRecord [CPID=" + CPID + ", BILLID=" + BILLID
				+ ", RECORDTIME=" + RECORDTIME + ", VALIDTIME=" + VALIDTIME
				+ ", INVALIDTIME=" + INVALIDTIME + ", EXECUTIONSTATE="
				+ EXECUTIONSTATE + ", MEASUREMENTTYPE=" + MEASUREMENTTYPE
				+ ", TIMEINTERVALCOUNT=" + TIMEINTERVALCOUNT + ", TISTRING="
				+ TISTRING + ", JPRICE=" + JPRICE + ", FPRICE=" + FPRICE
				+ ", PPRICE=" + PPRICE + ", GPRICE=" + GPRICE + ", SERVICETIP="
				+ SERVICETIP + ", SENDFLAG=" + SENDFLAG
				+ ", ACTIVEREQUESTFLAG=" + ACTIVEREQUESTFLAG
				+ ", FINISHEDFLAG=" + FINISHEDFLAG + ", BILLIDRETURN="
				+ BILLIDRETURN + ", RESULTRETURN=" + RESULTRETURN + "]";
	}

	public float getSERVICETIP() {
		return SERVICETIP;
	}

	public void setSERVICETIP(float sERVICETIP) {
		SERVICETIP = sERVICETIP;
	}

	public String getCPID() {
		return CPID;
	}

	public void setCPID(String cPID) {
		CPID = cPID;
	}

	public int getBILLID() {
		return BILLID;
	}

	public void setBILLID(int bILLID) {
		BILLID = bILLID;
	}

	public String getRECORDTIME() {
		return RECORDTIME;
	}

	public void setRECORDTIME(String rECORDTIME) {
		RECORDTIME = rECORDTIME;
	}

	public String getVALIDTIME() {
		return VALIDTIME;
	}

	public void setVALIDTIME(String vALIDTIME) {
		VALIDTIME = vALIDTIME;
	}

	public String getINVALIDTIME() {
		return INVALIDTIME;
	}

	public void setINVALIDTIME(String iNVALIDTIME) {
		INVALIDTIME = iNVALIDTIME;
	}

	public int getEXECUTIONSTATE() {
		return EXECUTIONSTATE;
	}

	public void setEXECUTIONSTATE(int eXECUTIONSTATE) {
		EXECUTIONSTATE = eXECUTIONSTATE;
	}

	public int getMEASUREMENTTYPE() {
		return MEASUREMENTTYPE;
	}

	public void setMEASUREMENTTYPE(int mEASUREMENTTYPE) {
		MEASUREMENTTYPE = mEASUREMENTTYPE;
	}

	public int getTIMEINTERVALCOUNT() {
		return TIMEINTERVALCOUNT;
	}

	public void setTIMEINTERVALCOUNT(int tIMEINTERVALCOUNT) {
		TIMEINTERVALCOUNT = tIMEINTERVALCOUNT;
	}

	public String getTISTRING() {
		return TISTRING;
	}

	public void setTISTRING(String tISTRING) {
		TISTRING = tISTRING;
	}

	public float getJPRICE() {
		return JPRICE;
	}

	public void setJPRICE(float jPRICE) {
		JPRICE = jPRICE;
	}

	public float getFPRICE() {
		return FPRICE;
	}

	public void setFPRICE(float fPRICE) {
		FPRICE = fPRICE;
	}

	public float getPPRICE() {
		return PPRICE;
	}

	public void setPPRICE(float pPRICE) {
		PPRICE = pPRICE;
	}

	public float getGPRICE() {
		return GPRICE;
	}

	public void setGPRICE(float gPRICE) {
		GPRICE = gPRICE;
	}

	public int getSENDFLAG() {
		return SENDFLAG;
	}

	public void setSENDFLAG(int sENDFLAG) {
		SENDFLAG = sENDFLAG;
	}

	public int getACTIVEREQUESTFLAG() {
		return ACTIVEREQUESTFLAG;
	}

	public void setACTIVEREQUESTFLAG(int aCTIVEREQUESTFLAG) {
		ACTIVEREQUESTFLAG = aCTIVEREQUESTFLAG;
	}

	public int getFINISHEDFLAG() {
		return FINISHEDFLAG;
	}

	public void setFINISHEDFLAG(int fINISHEDFLAG) {
		FINISHEDFLAG = fINISHEDFLAG;
	}

	public int getBILLIDRETURN() {
		return BILLIDRETURN;
	}

	public void setBILLIDRETURN(int bILLIDRETURN) {
		BILLIDRETURN = bILLIDRETURN;
	}

	public int getRESULTRETURN() {
		return RESULTRETURN;
	}

	public void setRESULTRETURN(int rESULTRETURN) {
		RESULTRETURN = rESULTRETURN;
	}

}

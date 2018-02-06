package cn.com.start.DPF.entity;

public class SocketLinkRecord {

	private String ID;// cpid或者cpmid
	private String TYPE;// 类型
	private String CONNECTTIME;// 连接时间
	private String IP;// ip地址
	private String PORT;// 端口
	private String LOSTTIME;// 断开连接时间
	private String REASON;// 断开原因

	@Override
	public String toString() {
		return "SocketLinkRecord [ID=" + ID + ", TYPE=" + TYPE
				+ ", CONNECTTIME=" + CONNECTTIME + ", IP=" + IP + ", PORT="
				+ PORT + ", LOSTTIME=" + LOSTTIME + ", REASON=" + REASON + "]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getCONNECTTIME() {
		return CONNECTTIME;
	}

	public void setCONNECTTIME(String cONNECTTIME) {
		CONNECTTIME = cONNECTTIME;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getPORT() {
		return PORT;
	}

	public void setPORT(String pORT) {
		PORT = pORT;
	}

	public String getLOSTTIME() {
		return LOSTTIME;
	}

	public void setLOSTTIME(String lOSTTIME) {
		LOSTTIME = lOSTTIME;
	}

	public String getREASON() {
		return REASON;
	}

	public void setREASON(String rEASON) {
		REASON = rEASON;
	}

}

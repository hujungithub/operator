package cn.com.start.webBack.entity;

public class ProtocolInfo {
	private String PROTOCOLID;// 协议id
	private String PROTOCOLNAME;// 协议名

	@Override
	public String toString() {
		return "ProtocolInfo [PROTOCOLID=" + PROTOCOLID + ", PROTOCOLNAME="
				+ PROTOCOLNAME + "]";
	}

	public String getPROTOCOLID() {
		return PROTOCOLID;
	}

	public void setPROTOCOLID(String pROTOCOLID) {
		PROTOCOLID = pROTOCOLID;
	}

	public String getPROTOCOLNAME() {
		return PROTOCOLNAME;
	}

	public void setPROTOCOLNAME(String pROTOCOLNAME) {
		PROTOCOLNAME = pROTOCOLNAME;
	}

}

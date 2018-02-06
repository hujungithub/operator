package cn.com.start.AppAPI.dto;

public class CPDetailDto {
	 
	//桩id
	 private String CPID;
    //枪
	 private String INTERNO;
    //发生时间
	 private String TIMESERIAL;
    //当前状态
	 private String CURRENTSTATE;
    //通信状态
	 private String COMMSTATE;
    //充电时间
	 private double CHARGETIME;
    //剩余时间
	 private double REMAINTIME;
    //当前电压A
	 private double CURRENTAVOL;
    //当前电流A
	 private double CURRENTACUR;
    //当前电压B
	 private double CURRENTBVOL;
    //当前电流B
	 private double CURRENTBCUR;
    //当前电压C
	 private double CURRENTCVOL;
    //当前电流C
	 private double CURRENTCCUR;
    //输出功率
	 private double OUTPOWER;
    //输出电量
	 private double OUTQUANTITY;
    //累计时间
	 private double ACCTIME;
    //输入过压
	 private String CPINOVERVOL;
    //输出过压
	 private String CPOUTOVERVOL;
    //输入欠压
	 private String CPINUNDERVOL;
    //输出欠压
	 private String CPOUTUNDERVOL;
    //输入过流
	 private String CPINOVERCUR;
    //输出过流
	 private String CPOUTOVERCUR;
    //输入欠流
	 private String CPINUNDERCUR;
    //输出欠流
	 private String CPOUTUNDERCUR;
    //温度过高
	 private String CPTEMPHIGH;
    //输出短路
	 private String CPOUTSHORT;
    //总电量
	 private double TOTALQUANTITY;
    //总费用
	 private double TOTALFEE;
    //尖电费
	 private double JIANFEE;
    //尖电价
	 private double JIANPRICE;
    //尖电量
	 private double JIANQ;
    //峰电费
	 private double FENGFEE;
    //峰电价
	 private double FENGPRICE;
    //峰电量
	 private double FENGQ;
    //平电费
	 private double PINGFEE;
    //平电价
	 private double PINGPRICE;
    //平电量
	 private double PINGQ;
    //谷电费
	 private double GUFEE;
    //谷电价
	 private double GUPRICE;
    //谷电量
	 private double GUQ;
    // 是否有电池
	 private String HASBATFLG;
    
	 //电池组SOC
    private double BATTERYSOC;
    //BMS状态
    private String BMSSTATE;
    //端电压
    private double PORTVOL;
    //单体数量
    private double CELLNUM;
    //温度点数量
    private double TEMPNUM;
    //最高允许充电单体电压
    private double MAXVOL;
    //最高允许充电温度
    private double MAXCTEMP;
    //单体最高电压
    private double CELLMAXVOL;
    //单体最高电压位置
    private double CELLPOS;
    //单体最低电压
    private double CELLMINVOL;
    //单体最低电压位置
    private double CELLMINVOLPOS;
    //最高温度
    private double MAXTEMP;
    //最低温度
    private double MINTEMP;
    //电压数据异常有无故障
    private String VOLDATAALARM;
    //电压采样有无故障
    private String SAMPLEVOLFAULT;
    //单体欠压是否过压报警
    private String UVOROVALARM;
    //系统参数是否报警
    private String SYSTEMPARAALARM;
    //风扇是否故障
    private String FANFAILFAULT;
    //温度采样是否错误
    private String SAMPLETEMPFAULT;    
	
	public String getCPID() {
		return CPID;
	}
	public void setCPID(String cPID) {
		CPID = cPID;
	}
	public String getINTERNO() {
		return INTERNO;
	}
	public void setINTERNO(String iNTERNO) {
		INTERNO = iNTERNO;
	}
	public String getTIMESERIAL() {
		return TIMESERIAL;
	}
	public void setTIMESERIAL(String tIMESERIAL) {
		TIMESERIAL = tIMESERIAL;
	}
	public String getCURRENTSTATE() {
		return CURRENTSTATE;
	}
	public void setCURRENTSTATE(String cURRENTSTATE) {
		CURRENTSTATE = cURRENTSTATE;
	}
	public String getCOMMSTATE() {
		return COMMSTATE;
	}
	public void setCOMMSTATE(String cOMMSTATE) {
		COMMSTATE = cOMMSTATE;
	}
	public double getCHARGETIME() {
		return CHARGETIME;
	}
	public void setCHARGETIME(double cHARGETIME) {
		CHARGETIME = cHARGETIME;
	}
	public double getREMAINTIME() {
		return REMAINTIME;
	}
	public void setREMAINTIME(double rEMAINTIME) {
		REMAINTIME = rEMAINTIME;
	}
	public double getCURRENTAVOL() {
		return CURRENTAVOL;
	}
	public void setCURRENTAVOL(double cURRENTAVOL) {
		CURRENTAVOL = cURRENTAVOL;
	}
	public double getCURRENTACUR() {
		return CURRENTACUR;
	}
	public void setCURRENTACUR(double cURRENTACUR) {
		CURRENTACUR = cURRENTACUR;
	}
	public double getCURRENTBVOL() {
		return CURRENTBVOL;
	}
	public void setCURRENTBVOL(double cURRENTBVOL) {
		CURRENTBVOL = cURRENTBVOL;
	}
	public double getCURRENTBCUR() {
		return CURRENTBCUR;
	}
	public void setCURRENTBCUR(double cURRENTBCUR) {
		CURRENTBCUR = cURRENTBCUR;
	}
	public double getCURRENTCVOL() {
		return CURRENTCVOL;
	}
	public void setCURRENTCVOL(double cURRENTCVOL) {
		CURRENTCVOL = cURRENTCVOL;
	}
	public double getCURRENTCCUR() {
		return CURRENTCCUR;
	}
	public void setCURRENTCCUR(double cURRENTCCUR) {
		CURRENTCCUR = cURRENTCCUR;
	}
	public double getOUTPOWER() {
		return OUTPOWER;
	}
	public void setOUTPOWER(double oUTPOWER) {
		OUTPOWER = oUTPOWER;
	}
	public double getOUTQUANTITY() {
		return OUTQUANTITY;
	}
	public void setOUTQUANTITY(double oUTQUANTITY) {
		OUTQUANTITY = oUTQUANTITY;
	}
	public double getACCTIME() {
		return ACCTIME;
	}
	public void setACCTIME(double aCCTIME) {
		ACCTIME = aCCTIME;
	}
	public String getCPINOVERVOL() {
		return CPINOVERVOL;
	}
	public void setCPINOVERVOL(String cPINOVERVOL) {
		CPINOVERVOL = cPINOVERVOL;
	}
	public String getCPOUTOVERVOL() {
		return CPOUTOVERVOL;
	}
	public void setCPOUTOVERVOL(String cPOUTOVERVOL) {
		CPOUTOVERVOL = cPOUTOVERVOL;
	}
	public String getCPINUNDERVOL() {
		return CPINUNDERVOL;
	}
	public void setCPINUNDERVOL(String cPINUNDERVOL) {
		CPINUNDERVOL = cPINUNDERVOL;
	}
	public String getCPOUTUNDERVOL() {
		return CPOUTUNDERVOL;
	}
	public void setCPOUTUNDERVOL(String cPOUTUNDERVOL) {
		CPOUTUNDERVOL = cPOUTUNDERVOL;
	}
	public String getCPINOVERCUR() {
		return CPINOVERCUR;
	}
	public void setCPINOVERCUR(String cPINOVERCUR) {
		CPINOVERCUR = cPINOVERCUR;
	}
	public String getCPOUTOVERCUR() {
		return CPOUTOVERCUR;
	}
	public void setCPOUTOVERCUR(String cPOUTOVERCUR) {
		CPOUTOVERCUR = cPOUTOVERCUR;
	}
	public String getCPINUNDERCUR() {
		return CPINUNDERCUR;
	}
	public void setCPINUNDERCUR(String cPINUNDERCUR) {
		CPINUNDERCUR = cPINUNDERCUR;
	}
	public String getCPOUTUNDERCUR() {
		return CPOUTUNDERCUR;
	}
	public void setCPOUTUNDERCUR(String cPOUTUNDERCUR) {
		CPOUTUNDERCUR = cPOUTUNDERCUR;
	}
	public String getCPTEMPHIGH() {
		return CPTEMPHIGH;
	}
	public void setCPTEMPHIGH(String cPTEMPHIGH) {
		CPTEMPHIGH = cPTEMPHIGH;
	}
	public String getCPOUTSHORT() {
		return CPOUTSHORT;
	}
	public void setCPOUTSHORT(String cPOUTSHORT) {
		CPOUTSHORT = cPOUTSHORT;
	}
	public double getTOTALQUANTITY() {
		return TOTALQUANTITY;
	}
	public void setTOTALQUANTITY(double tOTALQUANTITY) {
		TOTALQUANTITY = tOTALQUANTITY;
	}
	public double getTOTALFEE() {
		return TOTALFEE;
	}
	public void setTOTALFEE(double tOTALFEE) {
		TOTALFEE = tOTALFEE;
	}
	public double getJIANFEE() {
		return JIANFEE;
	}
	public void setJIANFEE(double jIANFEE) {
		JIANFEE = jIANFEE;
	}
	public double getJIANPRICE() {
		return JIANPRICE;
	}
	public void setJIANPRICE(double jIANPRICE) {
		JIANPRICE = jIANPRICE;
	}
	public double getJIANQ() {
		return JIANQ;
	}
	public void setJIANQ(double jIANQ) {
		JIANQ = jIANQ;
	}
	public double getFENGFEE() {
		return FENGFEE;
	}
	public void setFENGFEE(double fENGFEE) {
		FENGFEE = fENGFEE;
	}
	public double getFENGPRICE() {
		return FENGPRICE;
	}
	public void setFENGPRICE(double fENGPRICE) {
		FENGPRICE = fENGPRICE;
	}
	public double getFENGQ() {
		return FENGQ;
	}
	public void setFENGQ(double fENGQ) {
		FENGQ = fENGQ;
	}
	public double getPINGFEE() {
		return PINGFEE;
	}
	public void setPINGFEE(double pINGFEE) {
		PINGFEE = pINGFEE;
	}
	public double getPINGPRICE() {
		return PINGPRICE;
	}
	public void setPINGPRICE(double pINGPRICE) {
		PINGPRICE = pINGPRICE;
	}
	public double getPINGQ() {
		return PINGQ;
	}
	public void setPINGQ(double pINGQ) {
		PINGQ = pINGQ;
	}
	public double getGUFEE() {
		return GUFEE;
	}
	public void setGUFEE(double gUFEE) {
		GUFEE = gUFEE;
	}
	public double getGUPRICE() {
		return GUPRICE;
	}
	public void setGUPRICE(double gUPRICE) {
		GUPRICE = gUPRICE;
	}
	public double getGUQ() {
		return GUQ;
	}
	public void setGUQ(double gUQ) {
		GUQ = gUQ;
	}
	public String getHASBATFLG() {
		return HASBATFLG;
	}
	public void setHASBATFLG(String hASBATFLG) {
		HASBATFLG = hASBATFLG;
	}
	public double getBATTERYSOC() {
		return BATTERYSOC;
	}
	public void setBATTERYSOC(double bATTERYSOC) {
		BATTERYSOC = bATTERYSOC;
	}
	public String getBMSSTATE() {
		return BMSSTATE;
	}
	public void setBMSSTATE(String bMSSTATE) {
		BMSSTATE = bMSSTATE;
	}
	public double getPORTVOL() {
		return PORTVOL;
	}
	public void setPORTVOL(double pORTVOL) {
		PORTVOL = pORTVOL;
	}
	public double getCELLNUM() {
		return CELLNUM;
	}
	public void setCELLNUM(double cELLNUM) {
		CELLNUM = cELLNUM;
	}
	public double getTEMPNUM() {
		return TEMPNUM;
	}
	public void setTEMPNUM(double tEMPNUM) {
		TEMPNUM = tEMPNUM;
	}
	public double getMAXVOL() {
		return MAXVOL;
	}
	public void setMAXVOL(double mAXVOL) {
		MAXVOL = mAXVOL;
	}
	public double getMAXCTEMP() {
		return MAXCTEMP;
	}
	public void setMAXCTEMP(double mAXCTEMP) {
		MAXCTEMP = mAXCTEMP;
	}
	public double getCELLMAXVOL() {
		return CELLMAXVOL;
	}
	public void setCELLMAXVOL(double cELLMAXVOL) {
		CELLMAXVOL = cELLMAXVOL;
	}
	public double getCELLPOS() {
		return CELLPOS;
	}
	public void setCELLPOS(double cELLPOS) {
		CELLPOS = cELLPOS;
	}
	public double getCELLMINVOL() {
		return CELLMINVOL;
	}
	public void setCELLMINVOL(double cELLMINVOL) {
		CELLMINVOL = cELLMINVOL;
	}
	public double getCELLMINVOLPOS() {
		return CELLMINVOLPOS;
	}
	public void setCELLMINVOLPOS(double cELLMINVOLPOS) {
		CELLMINVOLPOS = cELLMINVOLPOS;
	}
	public double getMAXTEMP() {
		return MAXTEMP;
	}
	public void setMAXTEMP(double mAXTEMP) {
		MAXTEMP = mAXTEMP;
	}
	public double getMINTEMP() {
		return MINTEMP;
	}
	public void setMINTEMP(double mINTEMP) {
		MINTEMP = mINTEMP;
	}
	public String getVOLDATAALARM() {
		return VOLDATAALARM;
	}
	public void setVOLDATAALARM(String vOLDATAALARM) {
		VOLDATAALARM = vOLDATAALARM;
	}
	public String getSAMPLEVOLFAULT() {
		return SAMPLEVOLFAULT;
	}
	public void setSAMPLEVOLFAULT(String sAMPLEVOLFAULT) {
		SAMPLEVOLFAULT = sAMPLEVOLFAULT;
	}
	public String getUVOROVALARM() {
		return UVOROVALARM;
	}
	public void setUVOROVALARM(String uVOROVALARM) {
		UVOROVALARM = uVOROVALARM;
	}
	public String getSYSTEMPARAALARM() {
		return SYSTEMPARAALARM;
	}
	public void setSYSTEMPARAALARM(String sYSTEMPARAALARM) {
		SYSTEMPARAALARM = sYSTEMPARAALARM;
	}
	public String getFANFAILFAULT() {
		return FANFAILFAULT;
	}
	public void setFANFAILFAULT(String fANFAILFAULT) {
		FANFAILFAULT = fANFAILFAULT;
	}
	public String getSAMPLETEMPFAULT() {
		return SAMPLETEMPFAULT;
	}
	public void setSAMPLETEMPFAULT(String sAMPLETEMPFAULT) {
		SAMPLETEMPFAULT = sAMPLETEMPFAULT;
	}

}

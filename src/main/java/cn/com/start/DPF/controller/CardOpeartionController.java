package cn.com.start.DPF.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.com.start.DPF.aio.NoticeWeb;
import cn.com.start.DPF.card.CardRelay;
import cn.com.start.DPF.entity.CardIssueRecord;
import cn.com.start.DPF.entity.CardOpResult;
import cn.com.start.DPF.entity.CardUserInfo;
import cn.com.start.DPF.entity.ChangePINRecord;
import cn.com.start.DPF.entity.ESAMCardData;
import cn.com.start.DPF.entity.ESAMCardIssueRecord;
import cn.com.start.DPF.entity.ISAMCardData;
import cn.com.start.DPF.entity.ISAMCardIssueRecord;
import cn.com.start.DPF.entity.PretreatmentRecord;
import cn.com.start.DPF.entity.ReadBalanceRecord;
import cn.com.start.DPF.entity.ReadCardNumRecord;
import cn.com.start.DPF.entity.RechargeRecord;
import cn.com.start.DPF.entity.ReloadPINRecord;
import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.UnlockGreyRecord;
import cn.com.start.DPF.entity.carddata.CardShortMessage;
import cn.com.start.DPF.service.CardOperationService;

@Controller
@RequestMapping("/card")
public class CardOpeartionController {

	@Autowired
	private CardOperationService cardOperationService;
	private static Logger logger = LogManager.getLogger("LOG_CARD");
	
	//提交串口配置
	@RequestMapping("/portConfig")
	public String portConfig(HttpServletRequest request,
			SerialPortConfig serialPortConfig) {
		String ip = request.getRemoteAddr();
		String SP = serialPortConfig.getSERIALPORT();
		request.setAttribute("SP", SP);
		logger.info("ip get in web "+ip);
		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/portConfig.jsp";
		}
		
		// 数据保存到map 以ip为key
		CardRelay.serialPortConfigMap.put(ip, serialPortConfig);
		// 调用对应的cardobject发送报文
		CardRelay.ipObjectMap.get(ip).sendPortConfig();
		
		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
		request.setAttribute("result", result);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/portConfig.jsp";
	}

	// 开用户卡
	@RequestMapping("/openUserCard")
	public String activateCard(HttpServletRequest request,
			CardUserInfo cardUserInfo) throws UnsupportedEncodingException {
		String ip = request.getRemoteAddr();

		String cardusername = request.getParameter("CARDUSERNAME");
		String platenum = request.getParameter("PLATENUM");
		String email = request.getParameter("EMAIL");
		String address = request.getParameter("ADDRESS");
		cardUserInfo.setCARDUSERNAME(cardusername);
		cardUserInfo.setPLATENUM(platenum);
		cardUserInfo.setEMAIL(email);
		cardUserInfo.setADDRESS(address);
		cardUserInfo.setUSERID(request.getParameter("userid"));
		
		request.setAttribute("CARDNUM", cardUserInfo.getCARDNUM());
		request.setAttribute("PIN", cardUserInfo.getPIN());
		request.setAttribute("CARDUSERNAME", cardUserInfo.getCARDUSERNAME());
		request.setAttribute("TELEPHONE", cardUserInfo.getTELEPHONE());
		request.setAttribute("IDENTITYCARDNUM", cardUserInfo.getIDENTITYCARDNUM());
		request.setAttribute("PLATENUM", cardUserInfo.getPLATENUM());
		request.setAttribute("EMAIL", cardUserInfo.getEMAIL());
		request.setAttribute("ADDRESS", cardUserInfo.getADDRESS());
		request.setAttribute("sex", cardUserInfo.getSEX());
		request.setAttribute("VIN", cardUserInfo.getVIN());

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/userCardIssue.jsp";
		}
		
		// 验证数据
		// 检查卡号是否已存在
		int count = cardOperationService.checkUserCardNum(cardUserInfo.getCARDNUM());
		if(count > 0){
			String result = "卡号已存在！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/userCardIssue.jsp";
		}

		cardUserInfo.setSERIALPORT("COM0");
		cardUserInfo.setBAUDRATE(String.valueOf(9600));
		cardUserInfo.setINITKEY("11111111111111111111111111111111");
		cardUserInfo.setOPSTATE("web");
		System.out.println(cardUserInfo.toString());
		
		CardIssueRecord cardIssueRecord = new CardIssueRecord();
		BigInteger cardnum = new BigInteger(cardUserInfo.getCARDNUM());
		cardIssueRecord.setCARDNUM(cardnum);
		cardIssueRecord.setPIN(cardUserInfo.getPIN());
		cardIssueRecord.setCARDUSERNAME(cardUserInfo.getCARDUSERNAME());
		cardIssueRecord.setIDENTITY(cardUserInfo.getIDENTITYCARDNUM());
		cardIssueRecord.setPHONE(cardUserInfo.getTELEPHONE());
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cardIssueRecord.setSENDRECORDTIME(dateFormat.format(date));
		cardIssueRecord.setOPENCARDSTATE(0);
		cardIssueRecord.setUSERID(request.getParameter("userid"));
		
		// 数据保存到map 以ip为key
		CardRelay.userCardMap.put(ip, cardUserInfo);
		CardRelay.issueUserCardRecordMap.put(ip, cardIssueRecord);
		// 调用对应的cardobject发送报文
		CardRelay.ipObjectMap.get(ip).sendIssueUserCard();
		
		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_IssueUserCard");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
//		CardRelay.resultMap.put(ip+"_IssueUserCard", null);
		request.setAttribute("result", result);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/userCardIssue.jsp";
	}
	
	// 开ESAM卡
	@RequestMapping("/openESAMCard")
	public String openESAMCard(HttpServletRequest request, ESAMCardData esamCardData) {
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/esamCardIssue.jsp";
		}
		
		//检查卡号是否已存在
		int count = cardOperationService.checkESAMCardNum(esamCardData.getCARDNUM());
		if(count > 0){
			String result = "卡号已存在！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/esamCardIssue.jsp";
		}

		// 拿到页面的数据
		esamCardData.setSERIALPORT("COM0");
		esamCardData.setBAUDRATE(String.valueOf(9600));
		esamCardData.setINITKEY("11111111111111111111111111111111");
		
		ESAMCardIssueRecord esamCardIssueRecord = new ESAMCardIssueRecord();
		esamCardIssueRecord.setCARDNUM(esamCardData.getCARDNUM());
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		esamCardIssueRecord.setSENDRECORDTIME(dateFormat.format(date));
		esamCardIssueRecord.setOPENCARDSTATE(0);
		esamCardIssueRecord.setUSERID(request.getParameter("userid"));

		CardRelay.esamCardMap.put(ip, esamCardData);
		CardRelay.issueESAMCardRecordMap.put(ip, esamCardIssueRecord);
		CardRelay.ipObjectMap.get(ip).sendIssueESAMCard();
		
		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_IssueESAMCard");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
//		CardRelay.resultMap.put(ip+"_IssueESAMCard", null);
		request.setAttribute("result", result);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/esamCardIssue.jsp";
	}
	
	// 开ISAM卡
	@RequestMapping("/openISAMCard")
	public String openISAMCard(HttpServletRequest request, ISAMCardData isamCardData) {
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/isamCardIssue.jsp";
		}
		
		//检查卡号是否已存在
		int count = cardOperationService.checkISAMCardNum(isamCardData.getCARDNUM());
		if(count > 0){
			String result = "卡号已存在！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/isamCardIssue.jsp";
		}
		
		// 拿到页面的数据
		isamCardData.setSERIALPORT("COM0");
		isamCardData.setBAUDRATE(String.valueOf(9600));
		isamCardData.setINITKEY("11111111111111111111111111111111");
		
		ISAMCardIssueRecord isamCardIssueRecord = new ISAMCardIssueRecord();
		isamCardIssueRecord.setCARDNUM(isamCardData.getCARDNUM());
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		isamCardIssueRecord.setSENDRECORDTIME(dateFormat.format(date));
		isamCardIssueRecord.setOPENCARDSTATE(0);
		isamCardIssueRecord.setUSERID(request.getParameter("userid"));

		CardRelay.isamCardMap.put(ip, isamCardData);
		CardRelay.issueISAMCardRecordMap.put(ip, isamCardIssueRecord);
		CardRelay.ipObjectMap.get(ip).sendIssueISAMCard();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {			
//			result = CardRelay.resultMap.get(ip+"_IssueISAMCard");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
//		CardRelay.resultMap.put(ip+"_IssueISAMCard", null);
		request.setAttribute("result", result);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/isamCardIssue.jsp";
	}

//	//充值页面读取卡号
//	@RequestMapping("/readCardNum1")
//	public String readCardNum1(HttpServletRequest request){
//		String ip = request.getRemoteAddr();
//
//		if(!CardRelay.ipObjectMap.containsKey(ip)){
//			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/recharge.jsp";
//		}
//		
//		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
//		readCardNumRecord.setSERIALPORT("COM0");
//		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
//		long l = System.currentTimeMillis();
//		Date date = new Date(l);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		readCardNumRecord.setSENDRECORDTIME(dateFormat.format(date));
//		readCardNumRecord.setREADCARDNUMSTATE(0);
//		readCardNumRecord.setUSERID(request.getParameter("userid"));
//
//		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
//		CardRelay.ipObjectMap.get(ip).sendReadCardNum();
//
//		//等待结果回复 再取出来
//		int i = 0;
//		CardOpResult cardOpResult = null;
//		String result;
//		String CARDNUM = null;
//		while (i < 40) {
////			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
//			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
//			if(cardOpResult == null){
//				// 没到数据
//			}else{
//				// 返回给页面
//				long tl = System.currentTimeMillis();
//				Date td = new Date(tl);
//				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
//					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
//					break;// 跳出循环
//				}
//			}
//			try {
//				Thread.sleep(500);
//				i++;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} 
//		if(i >= 40){
//			result = "操作超时，请重试！";
//		}else{
//			result = cardOpResult.getResult();
//			if(result == "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
//			}
//		}
//		request.setAttribute("result", result);
////		CardRelay.resultMap.put(ip+"_CardNum", null);
//		CardRelay.resultMap.put(ip+"_Result", null);
//		return "//jsp/cardIssue/recharge.jsp";
//	}
//	
//	//修改PIN页面读取卡号
//	@RequestMapping("/readCardNum2")
//	public String readCardNum2(HttpServletRequest request){
//		String ip = request.getRemoteAddr();
//
//		if(!CardRelay.ipObjectMap.containsKey(ip)){
//			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/changePIN.jsp";
//		}
//		
//		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
//		readCardNumRecord.setSERIALPORT("COM0");
//		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
//		long l = System.currentTimeMillis();
//		Date date = new Date(l);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		readCardNumRecord.setSENDRECORDTIME(dateFormat.format(date));
//		readCardNumRecord.setREADCARDNUMSTATE(0);
//		readCardNumRecord.setUSERID(request.getParameter("userid"));
//
//		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
//		CardRelay.ipObjectMap.get(ip).sendReadCardNum();
//
//		//等待结果回复 再取出来
//		int i = 0;
//		CardOpResult cardOpResult = null;
//		String result;
//		String  CARDNUM = null;
//		while (i < 40) {
////			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
//			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
//			if(cardOpResult == null){
//				// 没到数据
//			}else{
//				// 返回给页面
//				long tl = System.currentTimeMillis();
//				Date td = new Date(tl);
//				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
//					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
//					break;// 跳出循环
//				}
//			}
//			try {
//				Thread.sleep(500);
//				i++;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} 
//		if(i >= 40){
//			result = "操作超时，请重试！";
//		}else{
//			result = cardOpResult.getResult();
//			if(result == "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
//			}
//		}
//		request.setAttribute("result", result);
////		CardRelay.resultMap.put(ip+"_ReadCardNum", null);
//		CardRelay.resultMap.put(ip+"_Result", null);
//		return "//jsp/cardIssue/changePIN.jsp";
//	}
//	
//	//联机解扣页面读取卡号
//	@RequestMapping("/readCardNum3")
//	public String readCardNum3(HttpServletRequest request){
//		String ip = request.getRemoteAddr();
//
//		if(!CardRelay.ipObjectMap.containsKey(ip)){
//			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/unlockGrey.jsp";
//		}
//		
//		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
//		readCardNumRecord.setSERIALPORT("COM0");
//		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
//		long l = System.currentTimeMillis();
//		Date date = new Date(l);
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		readCardNumRecord.setSENDRECORDTIME(dateFormat.format(date));
//		readCardNumRecord.setREADCARDNUMSTATE(0);
//		readCardNumRecord.setUSERID(request.getParameter("userid"));
//
//		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
//		CardRelay.ipObjectMap.get(ip).sendReadCardNum();
//
//		//等待结果回复 再取出来
//		int i = 0;
//		CardOpResult cardOpResult = null;
//		String result;
//		String  CARDNUM = null;
//		while (i < 40) {
////			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
//			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
//			if(cardOpResult == null){
//				// 没到数据
//			}else{
//				// 返回给页面
//				long tl = System.currentTimeMillis();
//				Date td = new Date(tl);
//				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
//					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
//					break;// 跳出循环
//				}
//			}
//			try {
//				Thread.sleep(500);
//				i++;
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		} 
//		if(i >= 40){
//			result = "操作超时，请重试！";
//		}else{
//			result = cardOpResult.getResult();
//			if(result == "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
//			}
//		}
//		request.setAttribute("result", result);
////		CardRelay.resultMap.put(ip+"_ReadCardNum", null);
//		CardRelay.resultMap.put(ip+"_Result", null);
//		return "//jsp/cardIssue/unlockGrey.jsp";
//	}

	//读取余额
	@RequestMapping("/readBalance")
	public String readBalance(HttpServletRequest request, ReadBalanceRecord readBalanceRecord){
		String PIN = request.getParameter("PIN");
		String MONEY = request.getParameter("MONEY");
		request.setAttribute("PIN", PIN);
		request.setAttribute("MONEY", MONEY);
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/recharge.jsp";
		}
		
		readBalanceRecord.setSERIALPORT("COM0");
		readBalanceRecord.setBAUDRATE(String.valueOf("COM0"));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		readBalanceRecord.setSENDRECORDTIME(dateFormat.format(date));
		readBalanceRecord.setREADBALANCESTATE(0);
		readBalanceRecord.setUSERID(request.getParameter("userid"));
		System.out.println("@@@@@@@@@@"+readBalanceRecord.getUSERID());

		CardRelay.readBalanceRecordMap.put(ip, readBalanceRecord);
		CardRelay.ipObjectMap.get(ip).sendReadBalance();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		String BALANCE = null;
		while (i < 40) {			
//			result = CardRelay.resultMap.get(ip+"_ReadBalance");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					BALANCE = CardRelay.resultDataMap.get(ip+"_Balance");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
			if(result == "读取余额成功!"){
				request.setAttribute("BALANCE", BALANCE);
			}
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_ReadBalance", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/recharge.jsp";
	}

	//充值
	@RequestMapping("/recharge")
	public String recharge(HttpServletRequest request, RechargeRecord rechargeRecord){
		String PIN = request.getParameter("PIN");
		String MONEY = request.getParameter("MONEY");
		request.setAttribute("PIN", PIN);
		request.setAttribute("MONEY", MONEY);
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/recharge.jsp";
		}
		
		//充值之前先读取卡号
		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
		readCardNumRecord.setSERIALPORT("COM0");
		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
		long l1 = System.currentTimeMillis();
		Date date1 = new Date(l1);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		readCardNumRecord.setSENDRECORDTIME(dateFormat1.format(date1));
		readCardNumRecord.setREADCARDNUMSTATE(0);
		readCardNumRecord.setUSERID(request.getParameter("userid"));

		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
		CardRelay.ipObjectMap.get(ip).sendReadCardNum();

		//等待结果回复 再取出来
		int i1 = 0;
		CardOpResult cardOpResult1 = null;
		String result1;
		String  CARDNUM = null;
		while (i1 < 40) {
//			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
			cardOpResult1 = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult1 == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult1.getTime().getTime() < 2000){
					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i1++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i1 >= 40){
			result1 = "操作超时，请重试！";
			request.setAttribute("result", result1);
			return "//jsp/cardIssue/recharge.jsp";
		}else{
			result1 = cardOpResult1.getResult();
			if(result1 != "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
				request.setAttribute("result", result1);
//				CardRelay.resultMap.put(ip+"_ReadCardNum", null);
				CardRelay.resultMap.put(ip+"_Result", null);
				return "//jsp/cardIssue/recharge.jsp";
			}
		}
		CardRelay.resultMap.put(ip+"_Result", null);
		
//		// 检查卡号是否已存在
//		int count = cardOperationService.checkUserCardNum(rechargeRecord.getCARDNUM());
//		if(count == 0){
//			String result = "卡号不存在！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/recharge.jsp";
//		}
		
		int cardstate = cardOperationService.findCardState(CARDNUM);
		if(cardstate == 1){
			request.setAttribute("result", "用户卡已挂失！");
			return "//jsp/cardIssue/recharge.jsp";
		}
		
		rechargeRecord.setCARDNUM(CARDNUM);
		rechargeRecord.setSERIALPORT("COM0");
		rechargeRecord.setBAUDRATE(String.valueOf(9600));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat_ = new SimpleDateFormat("yyyyMMddHHmmss");
		rechargeRecord.setSENDRECORDTIME(dateFormat.format(date));
		rechargeRecord.setRECHARGETIME(dateFormat_.format(date));
		rechargeRecord.setRECHARGESTATE(0);
		rechargeRecord.setUSERID(request.getParameter("userid"));
//		rechargeRecord.setCARDNUM(request.getParameter("CARDNUM"));
		rechargeRecord.setRECHARGETIMES(1);
		rechargeRecord.setMONEYS(rechargeRecord.getMONEY()*10000);
		System.out.println("@@@@@"+rechargeRecord.toString());
		
		CardRelay.rechargeRecordMap.put(ip, rechargeRecord);
		CardRelay.ipObjectMap.get(ip).sendRecharge();
		
		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_Recharge");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
			if(result == "充值成功!"){
				CardShortMessage cardShortMessage = new CardShortMessage();
				cardShortMessage.setCARDNUM(CARDNUM);
				cardShortMessage.setMONEY(String.valueOf(rechargeRecord.getMONEY()));
				long l2 = System.currentTimeMillis();
				Date date2 = new Date(l2);
				cardShortMessage.setTIME(dateFormat.format(date2));
				cardShortMessage = cardOperationService.selectShortMessageMsg(cardShortMessage);
				System.out.println(cardShortMessage);
				try {
					NoticeWeb.noticeCard(cardShortMessage);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_Recharge", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/recharge.jsp";
	}
	
	//重置PIN
	@RequestMapping("/reloadPIN")
	public String reloadPIN(HttpServletRequest request, ReloadPINRecord reloadPINRecord){
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/changePIN.jsp";
		}
		
		//充值之前先读取卡号
		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
		readCardNumRecord.setSERIALPORT("COM0");
		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
		long l1 = System.currentTimeMillis();
		Date date1 = new Date(l1);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		readCardNumRecord.setSENDRECORDTIME(dateFormat1.format(date1));
		readCardNumRecord.setREADCARDNUMSTATE(0);
		readCardNumRecord.setUSERID(request.getParameter("userid"));

		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
		CardRelay.ipObjectMap.get(ip).sendReadCardNum();

		//等待结果回复 再取出来
		int i1 = 0;
		CardOpResult cardOpResult1 = null;
		String result1;
		String  CARDNUM = null;
		while (i1 < 40) {
//			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
			cardOpResult1 = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult1 == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult1.getTime().getTime() < 2000){
					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i1++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i1 >= 40){
			result1 = "操作超时，请重试！";
			request.setAttribute("result", result1);
			return "//jsp/cardIssue/changePIN.jsp";
		}else{
			result1 = cardOpResult1.getResult();
			if(result1 != "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
				request.setAttribute("result", result1);
//				CardRelay.resultMap.put(ip+"_ReadCardNum", null);
				CardRelay.resultMap.put(ip+"_Result", null);
				return "//jsp/cardIssue/changePIN.jsp";
			}
		}
		CardRelay.resultMap.put(ip+"_Result", null);
		
//		// 检查卡号是否已存在
//		int count = cardOperationService.checkUserCardNum(reloadPINRecord.getCARDNUM());
//		if(count == 0){
//			String result = "卡号不存在！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/changePIN.jsp";
//		}

		int cardstate = cardOperationService.findCardState(CARDNUM);
		if(cardstate == 1){
			request.setAttribute("result", "用户卡已挂失！");
			return "//jsp/cardIssue/changePIN.jsp";
		}
		
		reloadPINRecord.setCARDNUM(CARDNUM);
		reloadPINRecord.setSERIALPORT("COM0");
		reloadPINRecord.setBAUDRATE(String.valueOf(9600));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		reloadPINRecord.setSENDRECORDTIME(dateFormat.format(date));
		reloadPINRecord.setRELOADPINSTATE(0);
		reloadPINRecord.setUSERID(request.getParameter("userid"));
//		reloadPINRecord.setCARDNUM(request.getParameter("CARDNUM"));
		
		CardRelay.reloadPINRecordMap.put(ip, reloadPINRecord);
		CardRelay.ipObjectMap.get(ip).sendReloadPIN();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_ReloadPIN");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_ReloadPIN", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/changePIN.jsp";
	}
	
	//修改PIn
	@RequestMapping("/changePIN")
	public String changePIN(HttpServletRequest request, ChangePINRecord changePINRecord){
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/changePIN.jsp";
		}
		
		//充值之前先读取卡号
		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
		readCardNumRecord.setSERIALPORT("COM0");
		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
		long l1 = System.currentTimeMillis();
		Date date1 = new Date(l1);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		readCardNumRecord.setSENDRECORDTIME(dateFormat1.format(date1));
		readCardNumRecord.setREADCARDNUMSTATE(0);
		readCardNumRecord.setUSERID(request.getParameter("userid"));

		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
		CardRelay.ipObjectMap.get(ip).sendReadCardNum();

		//等待结果回复 再取出来
		int i1 = 0;
		CardOpResult cardOpResult1 = null;
		String result1;
		String  CARDNUM = null;
		while (i1 < 40) {
//			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
			cardOpResult1 = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult1 == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult1.getTime().getTime() < 2000){
					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i1++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i1 >= 40){
			result1 = "操作超时，请重试！";
			request.setAttribute("result", result1);
			return "//jsp/cardIssue/changePIN.jsp";
		}else{
			result1 = cardOpResult1.getResult();
			if(result1 != "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
				request.setAttribute("result", result1);
//				CardRelay.resultMap.put(ip+"_ReadCardNum", null);
				CardRelay.resultMap.put(ip+"_Result", null);
				return "//jsp/cardIssue/changePIN.jsp";
			}
		}
		CardRelay.resultMap.put(ip+"_Result", null);
		
//		// 检查卡号是否已存在
//		int count = cardOperationService.checkUserCardNum(changePINRecord.getCARDNUM());
//		if(count == 0){
//			String result = "卡号不存在！";
//			request.setAttribute("result", result);
//			return "//jsp/cardIssue/changePIN.jsp";
//		}

		int cardstate = cardOperationService.findCardState(CARDNUM);
		if(cardstate == 1){
			request.setAttribute("result", "用户卡已挂失！");
			return "//jsp/cardIssue/changePIN.jsp";
		}
		
		changePINRecord.setCARDNUM(CARDNUM);
		changePINRecord.setSERIALPORT("COM0");
		changePINRecord.setBAUDRATE(String.valueOf(9600));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		changePINRecord.setSENDRECORDTIME(dateFormat.format(date));
		changePINRecord.setCHANGEPINSTATE(0);
		changePINRecord.setUSERID(request.getParameter("userid"));
//		changePINRecord.setCARDNUM(request.getParameter("CARDNUM"));

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/changePIN.jsp";
		}
		
		CardRelay.changePINRecordMap.put(ip, changePINRecord);
		CardRelay.ipObjectMap.get(ip).sendChangePIN();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_ChangePIN");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_ChangePIN", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/changePIN.jsp";
	}
	
	//预处理
	@RequestMapping("/pretreatment")
	public String pretreatment(HttpServletRequest request, PretreatmentRecord pretreatmentRecord){
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/pretreatment.jsp";
		}
		
		pretreatmentRecord.setSERIALPORT("COM0");
		pretreatmentRecord.setBAUDRATE(String.valueOf(9600));
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pretreatmentRecord.setSENDRECORDTIME(dateFormat.format(date));
		pretreatmentRecord.setPRETREATMENTSTATE(0);
		pretreatmentRecord.setUSERID(request.getParameter("userid"));
		
		CardRelay.pretreatmentRecordMap.put(ip, pretreatmentRecord);
		CardRelay.ipObjectMap.get(ip).sendPretreatment();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		String CARDTYPE = null;
		String CARDNUM = null;
		String LOCKSTATE = null;
		String LASTLOCKBALANCE = null;
		String TRADENO = null;
		String LASTLOCKCPNUM = null;
		String LASTLOCKTIME = null;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_Pretreatment");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					CARDTYPE = CardRelay.resultDataMap.get(ip+"_CardType");
					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
					LOCKSTATE = CardRelay.resultDataMap.get(ip+"_LockState");
					LASTLOCKBALANCE = CardRelay.resultDataMap.get(ip+"_LastLockBalance");
					TRADENO = CardRelay.resultDataMap.get(ip+"_TradeNo");
					LASTLOCKCPNUM = CardRelay.resultDataMap.get(ip+"_LastLockCPNum");
					LASTLOCKTIME = CardRelay.resultDataMap.get(ip+"_LastLockTime");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
			if(result == "预处理成功!"){
				request.setAttribute("CARDTYPE", CARDTYPE);
				request.setAttribute("CARDNUM", CARDNUM);
				request.setAttribute("LOCKSTATE", LOCKSTATE);
				request.setAttribute("LASTLOCKBALANCE", LASTLOCKBALANCE);
				request.setAttribute("TRADENO", TRADENO);
				request.setAttribute("LASTLOCKCPNUM", LASTLOCKCPNUM);
				request.setAttribute("LASTLOCKTIME", LASTLOCKTIME);
			}
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_Pretreatment", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/pretreatment.jsp";
	}
	
	//联机解扣
	@RequestMapping("/unlockGrey")
	public String unlockGrey(HttpServletRequest request, UnlockGreyRecord unlockGreyRecord){
		String ip = request.getRemoteAddr();

		if(!CardRelay.ipObjectMap.containsKey(ip)){
			String result = "未检测到本地发卡器通信软件的连接！请先打开发卡器通信软件并连接服务器后，再尝试该操作！";
			request.setAttribute("result", result);
			return "//jsp/cardIssue/unlockGrey.jsp";
		}

		//解扣之前先读取卡号
		ReadCardNumRecord readCardNumRecord = new ReadCardNumRecord();
		readCardNumRecord.setSERIALPORT("COM0");
		readCardNumRecord.setBAUDRATE(String.valueOf(9600));
		long l1 = System.currentTimeMillis();
		Date date1 = new Date(l1);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		readCardNumRecord.setSENDRECORDTIME(dateFormat1.format(date1));
		readCardNumRecord.setREADCARDNUMSTATE(0);
		readCardNumRecord.setUSERID(request.getParameter("userid"));

		CardRelay.readCardNumRecordMap.put(ip, readCardNumRecord);
		CardRelay.ipObjectMap.get(ip).sendReadCardNum();

		//等待结果回复 再取出来
		int i1 = 0;
		CardOpResult cardOpResult1 = null;
		String result1;
		String  CARDNUM = null;
		while (i1 < 40) {
//			result = CardRelay.resultMap.get(ip+"_ReadCardNum");
			cardOpResult1 = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult1 == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult1.getTime().getTime() < 2000){
					CARDNUM = CardRelay.resultDataMap.get(ip+"_CardNum");
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i1++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(i1 >= 40){
			result1 = "操作超时，请重试！";
			request.setAttribute("result", result1);
			return "//jsp/cardIssue/recharge.jsp";
		}else{
			result1 = cardOpResult1.getResult();
			if(result1 != "读取卡号成功!"){
//				request.setAttribute("CARDNUM", CARDNUM);
				request.setAttribute("result", result1);
//				CardRelay.resultMap.put(ip+"_ReadCardNum", null);
				CardRelay.resultMap.put(ip+"_Result", null);
				return "//jsp/cardIssue/recharge.jsp";
			}
		}
		CardRelay.resultMap.put(ip+"_Result", null);
		
		int cardstate = cardOperationService.findCardState(CARDNUM);
		if(cardstate == 1){
			request.setAttribute("result", "用户卡已挂失！");
			return "//jsp/cardIssue/unlockGrey.jsp";
		}
		
		unlockGreyRecord.setSERIALPORT("COM0");
		unlockGreyRecord.setBAUDRATE(String.valueOf(9600));
		unlockGreyRecord.setMONEYS((int)(unlockGreyRecord.getMONEY()*10000));
		unlockGreyRecord.setTRADETIME(unlockGreyRecord.getTRADEDATE().replaceAll("-", "")
				+ unlockGreyRecord.getTRADESEC());
		
		long l = System.currentTimeMillis();
		Date date = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		unlockGreyRecord.setSENDRECORDTIME(dateFormat.format(date));
		unlockGreyRecord.setUNLOCKGREYSTATE(0);
		unlockGreyRecord.setUSERID(request.getParameter("userid"));
		unlockGreyRecord.setCARDNUM(request.getParameter("CARDNUM"));

		CardRelay.unlockGreyRecordMap.put(ip, unlockGreyRecord);
		CardRelay.ipObjectMap.get(ip).sendUnlockGrey();

		//等待结果回复 再取出来
		int i = 0;
		CardOpResult cardOpResult = null;
		String result;
		while (i < 40) {
//			result = CardRelay.resultMap.get(ip+"_UnlockGrey");
			cardOpResult = CardRelay.resultMap.get(ip+"_Result");
			if(cardOpResult == null){
				// 没到数据
			}else{
				// 返回给页面
				long tl = System.currentTimeMillis();
				Date td = new Date(tl);
				if(td.getTime() - cardOpResult.getTime().getTime() < 2000){
					break;// 跳出循环
				}
			}
			try {
				Thread.sleep(500);
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		if(i >= 40){
			result = "操作超时，请重试！";
		}else{
			result = cardOpResult.getResult();
		}
		request.setAttribute("result", result);
//		CardRelay.resultMap.put(ip+"_UnlockGrey", null);
		CardRelay.resultMap.put(ip+"_Result", null);
		return "//jsp/cardIssue/unlockGrey.jsp";
	}
}


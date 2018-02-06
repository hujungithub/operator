package cn.com.start.DPF.card;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import cn.com.start.DPF.entity.UnlockGreyRecord;
import cn.com.start.DPF.util.socket.CreateByte;

public class CardProcess {
	private static CardStorage cStorage = CardStorage.getIstance();
	private static Logger logger = LogManager.getLogger("LOG_CARD");
	
	// 解析qt传过来的数据
	public static void ProcessData(byte[] buf, HashMap<String, Object> map) {
		// if初始化
		logger.info("$$$$$$$$"+CreateByte.bytesToHexString(buf));
		logger.info("@@@"+ buf.length);
		logger.info("");
		String ip = String.valueOf(map.get("IP"));
		byte head = buf[0];
		int length = buf.length;
		if (head == 0x49 && length == 7) {
			// 0x49 初始化报文
			// 解析出来id
			// 存到map
			
			logger.info("收到初始化报文");
			logger.info("");
			map.put("INIT", "ready");
			CardRelay.initMap.put(ip, buf);
		} else if (head == 0x48 && length == 5) {
			// 0x48心跳报文
			logger.info("收到心跳报文");
			logger.info("长度 = "+buf.length+"报文 ="+CreateByte.bytesToHexString(buf));
			int receiveHeart = (Integer)map.get("HEARTBEAT");
			map.put("HEARTBEAT", 0);
			logger.info("");
		}
		
		else if (head == 0x00 && length == 19) {
			// 0x00发行用户卡结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			CardIssueRecord cardIssueRecord = CardRelay.issueUserCardRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cardIssueRecord.setINITIALKEY(buf_.substring(6));
			cardIssueRecord.setGETREPLYTIME(dateFormat.format(date));
			cardIssueRecord.setOPENCARDSTATE(1);
			cardIssueRecord.setOPENCARDRESULT(result);
			//操作结果入库
			cStorage.updateIssueUserCard(cardIssueRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				CardUserInfo cardUserInfo = CardRelay.userCardMap.get(ip);
				cardUserInfo.setREGTIME(dateFormat.format(date));
				cardUserInfo.setINITKEY(buf_.substring(6));
				cStorage.insertUserCard(cardUserInfo);
//				CardRelay.resultMap.put(ip+"_IssueUserCard", "用户卡发卡成功");
				cardOpResult.setResult("用户卡发卡成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else {
				//告诉页面开卡失败
//				CardRelay.resultMap.put(ip+"_IssueUserCard", "用户卡发卡失败");
				cardOpResult.setResult("用户卡发卡失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x01 && length == 19) {
			// 0x01发行ESAM卡结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ESAMCardIssueRecord esamCardIssueRecord = CardRelay.issueESAMCardRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			esamCardIssueRecord.setGETREPLYTIME(dateFormat.format(date));
			esamCardIssueRecord.setOPENCARDSTATE(1);
			esamCardIssueRecord.setOPENCARDRESULT(result);
			cStorage.updateIssueESAMCard(esamCardIssueRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				ESAMCardData esamCardData = CardRelay.esamCardMap.get(ip);
				esamCardData.setCARDISSUETIME(dateFormat.format(date));
				esamCardData.setINITKEY(buf_.substring(6));
				cStorage.insertESAMCard(esamCardData);
//				CardRelay.resultMap.put(ip+"_IssueESAMCard", "ESAM卡发卡成功");
				cardOpResult.setResult("ESAM卡发卡成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else {
//				CardRelay.resultMap.put(ip+"_IssueESAMCard", "ESAM卡发卡失败");
				cardOpResult.setResult("ESAM卡发卡失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x02 && length == 19) {
			// 0x02发行ISAM卡结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ISAMCardIssueRecord isamCardIssueRecord = CardRelay.issueISAMCardRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			isamCardIssueRecord.setGETREPLYTIME(dateFormat.format(date));
			isamCardIssueRecord.setOPENCARDSTATE(1);
			isamCardIssueRecord.setOPENCARDRESULT(result);
			cStorage.updateIssueISAMCard(isamCardIssueRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				ISAMCardData isamCardData = CardRelay.isamCardMap.get(ip);
				isamCardData.setCARDISSUETIME(dateFormat.format(date));
				isamCardData.setINITKEY(buf_.substring(6));
				cStorage.insertISAMCard(isamCardData);
//				CardRelay.resultMap.put(ip+"_IssueESAMCard", "ISAM卡发卡成功");
				cardOpResult.setResult("ISAM卡发卡成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else {
//				CardRelay.resultMap.put(ip+"_IssueESAMCard", "ISAM卡发卡失败");
				cardOpResult.setResult("ISAM卡发卡失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x03 && length == 3) {
			// 0x03修改用户卡PIN结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ChangePINRecord changePINRecord = CardRelay.changePINRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			changePINRecord.setGETREPLYTIME(dateFormat.format(date));
			changePINRecord.setCHANGEPINSTATE(1);
			changePINRecord.setCHANGEPINRESULT(result);
			cStorage.updateChangePINRecord(changePINRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				cStorage.updateUserCardPIN(changePINRecord.getCARDNUM(), changePINRecord.getNEWPIN());
//				CardRelay.resultMap.put(ip+"_ChangePIN", "修改PIN成功");
				cardOpResult.setResult("修改PIN成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 2){
//				CardRelay.resultMap.put(ip+"_ChangePIN", "用户卡选择3F01文件失败");
				cardOpResult.setResult("用户卡选择3F01文件失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 3){
//				CardRelay.resultMap.put(ip+"_ChangePIN", "用户卡验证原PIN失败");
				cardOpResult.setResult("用户卡验证原PIN失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 4){
//				CardRelay.resultMap.put(ip+"_ChangePIN", "用户卡修改PIN失败");
				cardOpResult.setResult("用户卡修改PIN失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_ChangePIN", "用户卡复位失败");
				cardOpResult.setResult("用户卡复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x04 && length == 3) {
			// 0x04重载PIN结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ReloadPINRecord reloadPINRecord = CardRelay.reloadPINRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			reloadPINRecord.setGETREPLYTIME(dateFormat.format(date));
			reloadPINRecord.setRELOADPINSTATE(1);
			reloadPINRecord.setRELOADPINRESULT(result);
			cStorage.updateReloadPINRecord(reloadPINRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				cStorage.updateUserCardPIN(reloadPINRecord.getCARDNUM(), reloadPINRecord.getNEWPIN());
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "修改PIN成功");
				cardOpResult.setResult("重置PIN成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 3){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "用户卡选择3F01文件失败");
				cardOpResult.setResult("用户卡选择3F01文件失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 5){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "用户卡加密随机数失败");
				cardOpResult.setResult("用户卡加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 7){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "ISAM以用户卡卡号离散认证密钥失败");
				cardOpResult.setResult("ISAM以用户卡卡号离散认证密钥失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 8){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "ISAM加密随机数失败");
				cardOpResult.setResult("ISAM加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 9){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "用户卡和ISAM认证失败");
				cardOpResult.setResult("用户卡和ISAM认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 10){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "ISAM计算MAC失败");
				cardOpResult.setResult("ISAM计算MAC失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 11){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "用户卡重装PIN失败");
				cardOpResult.setResult("用户卡重装PIN失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "用户卡复位失败");
				cardOpResult.setResult("用户卡复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 260){
//				CardRelay.resultMap.put(ip+"_ReloadPIN", "ISAM卡复位失败");
				cardOpResult.setResult("ISAM卡复位失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x05 && length == 11) {
			// 0x05读取用户卡号结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ReadCardNumRecord readCardNumRecord = CardRelay.readCardNumRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			readCardNumRecord.setGETREPLYTIME(dateFormat.format(date));
			readCardNumRecord.setREADCARDNUMSTATE(1);
			readCardNumRecord.setREADCARDNUMRESULT(result);
			cStorage.updateReadCardNumRecord(readCardNumRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			//用result查数据库里对应的操作结果，并回到页面
			if(result == 0){
				System.out.println(buf_);
//				CardRelay.resultMap.put(ip+"_ReadCardNum", "读取卡号成功");
				cardOpResult.setResult("读取卡号成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
				CardRelay.resultDataMap.put(ip+"_CardNum", buf_.substring(6));
			}else if(result == 1){
//				CardRelay.resultMap.put(ip+"_ReadCardNum", "读取卡片失败");
				cardOpResult.setResult("读取卡片失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_ReadCardNum", "卡片复位失败");
				cardOpResult.setResult("卡片复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		
		else if (head == 0x06 && length == 7) {
			// 0x06读取余额结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			ReadBalanceRecord readBalanceRecord = CardRelay.readBalanceRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			readBalanceRecord.setGETREPLYTIME(dateFormat.format(date));
			readBalanceRecord.setREADBALANCESTATE(1);
			readBalanceRecord.setREADBALANCERESULT(result);
			cStorage.updateReadBalanceRecord(readBalanceRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
//				CardRelay.resultMap.put(ip+"_ReadBalance", "读取余额成功");
				cardOpResult.setResult("读取余额成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
				double balance = Integer.parseInt(buf_.substring(6), 16);
				CardRelay.resultDataMap.put(ip+"_Balance", String.valueOf(balance/10000));
			}else if(result == 1){
//				CardRelay.resultMap.put(ip+"_ReadBalance", "选择3F01文件失败");
				cardOpResult.setResult("选择3F01文件失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 2){
//				CardRelay.resultMap.put(ip+"_ReadBalance", "校验PIN失败");
				cardOpResult.setResult("校验PIN失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 3){
//				CardRelay.resultMap.put(ip+"_ReadBalance", "读取余额失败");
				cardOpResult.setResult("读取余额失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_ReadBalance", "卡片复位失败");
				cardOpResult.setResult("卡片复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x07 && length == 3) {
			// 0x07用户卡充值结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2, 6));
			RechargeRecord rechargeRecord = CardRelay.rechargeRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rechargeRecord.setGETREPLYTIME(dateFormat.format(date));
			rechargeRecord.setRECHARGESTATE(1);
			rechargeRecord.setRECHARGERESULT(result);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 0){
				cStorage.updateUserCardMoney(rechargeRecord);
//				CardRelay.resultMap.put(ip+"_Recharge", "充值成功");
				cardOpResult.setResult("充值成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 3){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡选择3F01文件失败");
				cardOpResult.setResult("用户卡选择3F01文件失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 5){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡加密随机数失败");
				cardOpResult.setResult("用户卡加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 7){
//				CardRelay.resultMap.put(ip+"_Recharge", "ISAM以用户卡卡号离散认证密钥失败");
				cardOpResult.setResult("ISAM以用户卡卡号离散认证密钥失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 8){
//				CardRelay.resultMap.put(ip+"_Recharge", "ISAM加密随机数失败");
				cardOpResult.setResult("ISAM加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 9){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡和ISAM认证失败");
				cardOpResult.setResult("用户卡和ISAM认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 10){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡PIN认证失败");
				cardOpResult.setResult("用户卡PIN认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 11){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡圈存初始化失败");
				cardOpResult.setResult("用户卡圈存初始化失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 12){
//				CardRelay.resultMap.put(ip+"_Recharge", "ISAM校验MAC1失败");
				cardOpResult.setResult("ISAM校验MAC1失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 13){
//				CardRelay.resultMap.put(ip+"_Recharge", "ISAM计算MAC2失败");
				cardOpResult.setResult("ISAM计算MAC2失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 14){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡圈存失败");
				cardOpResult.setResult("用户卡圈存失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 18){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡写购电日期和购电次数失败");
				cardOpResult.setResult("用户卡写购电日期和购电次数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_Recharge", "用户卡复位失败");
				cardOpResult.setResult("用户卡复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 260){
//				CardRelay.resultMap.put(ip+"_Recharge", "ISAM卡复位失败");
				cardOpResult.setResult("ISAM卡复位失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
			cStorage.updateRechargeCard(rechargeRecord);
		}
		
		else if (head == 0x08 && length == 3) {
			// 0x08联机解扣结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = Integer.parseInt(buf_.substring(2));
			UnlockGreyRecord unlockGreyRecord = CardRelay.unlockGreyRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			unlockGreyRecord.setGETREPLYTIME(dateFormat.format(date));
			unlockGreyRecord.setUNLOCKGREYSTATE(1);
			unlockGreyRecord.setUNLOCKGREYRESULT(result);
			cStorage.updateUnlockGreyRecord(unlockGreyRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			
			if(result == 0){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "解扣成功");
				cardOpResult.setResult("解扣成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 2){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡选择3F01文件失败");
				cardOpResult.setResult("用户卡选择3F01文件失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 4){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡加密随机数失败");
				cardOpResult.setResult("用户卡加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 6){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "ISAM以用户卡卡号离散认证密钥失败");
				cardOpResult.setResult("ISAM以用户卡卡号离散认证密钥失败");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 7){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "ISAM加密随机数失败");
				cardOpResult.setResult("ISAM加密随机数失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 8){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡和ISAM认证失败");
				cardOpResult.setResult("用户卡和ISAM认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 11){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡PIN认证失败");
				cardOpResult.setResult("用户卡PIN认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 12){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡PIN认证失败");
				cardOpResult.setResult("用户卡PIN认证失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 13){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "ISAM校验MAC1失败");
				cardOpResult.setResult("ISAM校验MAC1失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 14){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "ISAM校验MAC2失败");
				cardOpResult.setResult("ISAM校验MAC2失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 15){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡解扣失败");
				cardOpResult.setResult("用户卡解扣失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 17){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡清TAC失败");
				cardOpResult.setResult("用户卡清TAC失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 18){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡未灰锁");
				cardOpResult.setResult("用户卡未灰锁!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 250){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "用户卡复位失败");
				cardOpResult.setResult("用户卡复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 260){
//				CardRelay.resultMap.put(ip+"_UnlockGrey", "ISAM卡复位失败");
				cardOpResult.setResult("ISAM卡复位失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x09 && length == 42) {
			// 0x09预处理结果帧
			String buf_ = CreateByte.bytesToHexStringCard(buf).toString();
			int result = buf[1]&0x0FF;
			PretreatmentRecord pretreatmentRecord = CardRelay.pretreatmentRecordMap.get(ip);
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pretreatmentRecord.setGETREPLYTIME(dateFormat.format(date));
			pretreatmentRecord.setPRETREATMENTSTATE(1);
			pretreatmentRecord.setPRETREATMENTRESULT(result);
			cStorage.updatePretreatmentRecord(pretreatmentRecord);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			if(result == 89){
				int cardType = buf[2]&0x0FF;
				System.out.println(buf_);
//				CardRelay.resultMap.put(ip+"_Pretreatment", "预处理成功");
				cardOpResult.setResult("预处理成功!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
				if(cardType == 1){
					CardRelay.resultDataMap.put(ip+"_CardType", "用户卡");
				}else if(cardType == 81){
					CardRelay.resultDataMap.put(ip+"_CardType", "员工卡");
				}else if(cardType == 97){
					CardRelay.resultDataMap.put(ip+"_CardType", "充值卡");
				}
				CardRelay.resultDataMap.put(ip+"_CardNum", buf_.substring(6, 22));
				int lockState = buf[11];
				if(lockState == 0){
					CardRelay.resultDataMap.put(ip+"_LockState", "未灰锁");
				}else if(lockState == 1){
					CardRelay.resultDataMap.put(ip+"_LockState", "已灰锁");
				}else if(lockState == 16){
					CardRelay.resultDataMap.put(ip+"_LockState", "TAC未读");
				}
				double balance = Integer.parseInt(buf_.substring(28, 36), 16);
				CardRelay.resultDataMap.put(ip+"_LastLockBalance", String.valueOf(balance/10000));
				CardRelay.resultDataMap.put(ip+"_TradeNo", String.valueOf(Integer.parseInt(buf_.substring(36, 40),16)));
				CardRelay.resultDataMap.put(ip+"_LastLockCPNum", buf_.substring(40, 52));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				try {
					CardRelay.resultDataMap.put(ip+"_LastLockTime", dateFormat.format(sdf.parse(buf_.substring(52, 66))));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else if(result == 78){
//				CardRelay.resultMap.put(ip+"_Pretreatment", "预处理过程失败");
				cardOpResult.setResult("预处理过程失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 71){
//				CardRelay.resultMap.put(ip+"_Pretreatment", "PSAM复位失败");
				cardOpResult.setResult("PSAM复位失败!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 72){
//				CardRelay.resultMap.put(ip+"_Pretreatment", "用户卡、密钥卡、设置卡复位失败");
				cardOpResult.setResult("用户卡、密钥卡、设置卡复位失败或串口配置错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 35){
//				CardRelay.resultMap.put(ip+"_Pretreatment", "桩体认证错误，说明卡片不适配");
				cardOpResult.setResult("桩体认证错误，卡片不适配!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}else if(result == 131){
//				CardRelay.resultMap.put(ip+"_Pretreatment", "个人pin验证错误");
				cardOpResult.setResult("个人pin验证错误!");
				CardRelay.resultMap.put(ip+"_Result", cardOpResult);
			}
		}
		
		else if (head == 0x0a && length == 3) {
			// 0x0a读取终端卡号返回帧
		}
		
		else if (head == 0x0b && length == 1) {
			// 0x0b串口打开失败
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			cardOpResult.setResult("串口打开失败!");
			CardRelay.resultMap.put(ip+"_Result", cardOpResult);
		}
		
		else if (head == 0x0c && length == 1) {
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			cardOpResult.setResult("串口打开成功!");
			CardRelay.resultMap.put(ip+"_Result", cardOpResult);
		}
		
		else if (head == 0x0d && length == 1) {
			long l = System.currentTimeMillis();
			Date date = new Date(l);
			CardOpResult cardOpResult = new CardOpResult();
			cardOpResult.setTime(date);
			cardOpResult.setResult("未检测到串口配置，请先设置串口，再进行其他操作!");
			CardRelay.resultMap.put(ip+"_Result", cardOpResult);
		}
	}
}

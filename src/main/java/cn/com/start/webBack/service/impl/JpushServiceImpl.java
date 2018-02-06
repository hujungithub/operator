/**  
 * Copyright © 2018上海强辰. All rights reserved.
 *
 * @Title: JpushServiceImpl.java
 * @Prject: operation
 * @Package: cn.com.start.webBack.service.impl
 * @Description: TODO
 * @author: hujun  
 * @date: 2018年1月23日 上午10:50:31
 * @version: V1.0  
 */
package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.entity.ElecOrder;
import cn.com.start.webBack.entity.Electrician;
import cn.com.start.webBack.entity.WebAlarmOperation;
import cn.com.start.webBack.service.ElecService;
import cn.com.start.webBack.service.JpushService;
import cn.com.start.webBack.service.JsonService;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * @ClassName: JpushServiceImpl
 * @Description: TODO
 * @author: hujun
 * @date: 2018年1月23日 上午10:50:31
 */
@Service("jpushService")
@Transactional
public class JpushServiceImpl implements JpushService{

	@Resource
	private ElecService elecService;
	@Resource
	private JsonService jsonService;
	
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger("LOG_API");
	private static String secret = "3e0c705a36d959d8a111f6d0";
	private static String appKey = "827c01c05ca50403f289b915";
/*	private static String secret = "d1a8fc0dfa0520a642513cfb";
	private static String appKey = "2a74075119d0503a06c4ddb5";*/
    private static final String ALERT = "推送信息";
	/**
	 * @Title: pushSystemMessage
	 * @Description: TODO 手动推送工单数据
	 * @see cn.com.start.webBack.service.JPushService#pushSystemMessage()
	 */
    @SuppressWarnings("deprecation")
	@Override
	public void pushSystemMessage(String orderid) {
		// TODO Auto-generated method stub
			JPushClient jpushClient = new JPushClient(secret, appKey, 3);
			ElecOrder elecOrder = elecService.findInfoByOrderId(orderid);
//			List<ActivityPush> activityList = activityService.getPushActivityList();
//			for(ActivityPush goodsActivity : activityList){
		        try { 
		        	PushPayload payload=buildPushObject_all_all_alert(elecOrder, elecOrder.getELECID());
		        	PushResult result = jpushClient.sendPush(payload); 
		        	/*if(null != result){
		        		flag = activityService.updatePushStatus(goodsActivity.getActivityId());
		        	}*/
		            logger.info("Got result - " + result);
		        } catch (APIConnectionException e) {  
		        	logger.error("Connection error. Should retry later. ", e); 
		        } catch (APIRequestException e) {  
		        	logger.error("Error response from JPush server. Should review and fix it. ", e);  
		        	logger.info("HTTP Status: " + e.getStatus());  
		        	logger.info("Error Code: " + e.getErrorCode());  
		        	logger.info("Error Message: " + e.getErrorMessage());  
		        	logger.info("Msg ID: " + e.getMsgId());
		        } catch (Exception e) {
		        	logger.error("推送失败，orderid="+elecOrder.getORDERID(), e);
				}
//			}
		}
		
		public static PushPayload buildPushObject_all_all_alert(ElecOrder elecOrder,String elecid) {
	        return PushPayload
	                .newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.all())
	                .setNotification(
	                        Notification
	                                .newBuilder()
	               
	                                .setAlert("尊敬的"+elecOrder.getELECNAME()+",您的订单"+elecOrder.getORDERID()+"已完成!")
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("elecid", elecid)
	                                                .build())
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("elecOrder", String.valueOf(elecOrder))
	                                                .build())
	                                .addPlatformNotification(AndroidNotification.newBuilder().addExtra("elecOrder", String.valueOf(elecOrder)).build()).build())
	                				.setOptions(Options.newBuilder()
	                						.setApnsProduction(true)
	                						.build()).build();
	                				/*.setMessage(Message.newBuilder()
			                		.setMsgContent(detail)
			                		.setTitle(title)
			                		.build())*/
	    }

		/**
		 * @Title: autoPushSystemMessage
		 * @Description: TODO 自动推送故障数据
		 * @param webAlarmOperation
		 * @see cn.com.start.webBack.service.JpushService#autoPushSystemMessage(cn.com.start.webBack.entity.WebAlarmOperation)
		 */
		@Override
		public void autoPushSystemMessage(WebAlarmOperation webAlarmOperation) {
			// TODO 自动推送故障数据
			JPushClient jpushClient = new JPushClient(secret, appKey, 3);
				int flag = 0;
		        try { 
		        	PushPayload payload=buildPushObject_all_all_alert(webAlarmOperation, webAlarmOperation.getCPID());
		        	PushResult result = jpushClient.sendPush(payload); 
		        	if(null != result){
		        		flag = jsonService.updatePushStatus(webAlarmOperation.getRECORDTIME());
		        		if(flag == 1) {
		        			logger.info("推送成功");
		        		}
		        	}
		            logger.info("Got result - " + result);
		        } catch (APIConnectionException e) {  
		        	logger.error("Connection error. Should retry later. ", e); 
		        } catch (APIRequestException e) {  
		        	logger.error("Error response from JPush server. Should review and fix it. ", e);  
		        	logger.info("HTTP Status: " + e.getStatus());  
		        	logger.info("Error Code: " + e.getErrorCode());  
		        	logger.info("Error Message: " + e.getErrorMessage());  
		        	logger.info("Msg ID: " + e.getMsgId());
		        } catch (Exception e) {
		        	logger.error("推送失败，orderid="+webAlarmOperation.getCPID(), e);
				}
//			}
		}
		

		public static PushPayload buildPushObject_all_all_alert(WebAlarmOperation webAlarmOperation,String cpid) {
	        return PushPayload
	                .newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.all())
	                .setNotification(
	                        Notification
	                                .newBuilder()
	                                .setAlert(webAlarmOperation)
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("cpid", cpid)
	                                                .build())
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("webAlarmOperation", String.valueOf(webAlarmOperation))
	                                                .build())
	                                .addPlatformNotification(AndroidNotification.newBuilder().addExtra("cpid", cpid).build()).build())
	                				.setOptions(Options.newBuilder()
	                						.setApnsProduction(true)
	                						.build()).build();
	                				/*.setMessage(Message.newBuilder()
			                		.setMsgContent(detail)
			                		.setTitle(title)
			                		.build())*/
	    }

		/**
		 * @Title: pushMessageByElecid
		 * @Description: TODO 电工审核通过推送审核消息
		 * @param elecid
		 * @see cn.com.start.webBack.service.JpushService#pushMessageByElecid(java.lang.String)
		 */
		@Override
		public void pushMessageByElecid(String elecid) {
			// TODO Auto-generated method stub
			JPushClient jpushClient = new JPushClient(secret, appKey, 3);
			Electrician electrician = elecService.findInfoById(elecid);
		        try { 
		        	PushPayload payload=buildPushObject_all_all_alert(electrician, electrician.getELECID());
		        	PushResult result = jpushClient.sendPush(payload); 
		        	/*if(null != result){
		        		flag = activityService.updatePushStatus(goodsActivity.getActivityId());
		        	}*/
		            logger.info("Got result - " + result);
		        } catch (APIConnectionException e) {  
		        	logger.error("Connection error. Should retry later. ", e); 
		        } catch (APIRequestException e) {  
		        	logger.error("Error response from JPush server. Should review and fix it. ", e);  
		        	logger.info("HTTP Status: " + e.getStatus());  
		        	logger.info("Error Code: " + e.getErrorCode());  
		        	logger.info("Error Message: " + e.getErrorMessage());  
		        	logger.info("Msg ID: " + e.getMsgId());
		        } catch (Exception e) {
		        	logger.error("推送失败，orderid="+electrician.getELECID(), e);
				}
//			}
		}
		
		
		public static PushPayload buildPushObject_all_all_alert(Electrician electrician,String elecid) {
	        return PushPayload
	                .newBuilder()
	                .setPlatform(Platform.all())
	                .setAudience(Audience.alias(elecid))
	                .setNotification(
	                        Notification
	                                .newBuilder()
	                                .setAlert("尊敬的"+electrician.getELECNAME()+"您好,您的审核已经通过")
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("elecid", elecid)
	                                                .build())
	                                .addPlatformNotification(
	                                        IosNotification.newBuilder().setSound("default").setBadge(1).addExtra("electrician", String.valueOf(electrician))
	                                                .build())
	                                .addPlatformNotification(AndroidNotification.newBuilder().addExtra("elecid", elecid).build()).build())
	                				.setOptions(Options.newBuilder()
	                						.setApnsProduction(true)
	                						.build()).build();
	                				/*.setMessage(Message.newBuilder()
			                		.setMsgContent(detail)
			                		.setTitle(title)
			                		.build())*/
	    }
}

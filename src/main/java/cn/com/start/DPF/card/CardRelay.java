package cn.com.start.DPF.card;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import java.util.HashMap;

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

public class CardRelay {

	// 用于通信程序读写中转
	public static HashMap<String, CardObject> ipObjectMap = new HashMap<String, CardObject>(); // ip地址和服务器线程对应
	public static HashMap<String, String> ipNameMap = new HashMap<String, String>();// ip地址和登录用户（浏览器）对应

	// controller等待结果 key = ip+_+操作名 比如 192.158.23.12_openusercard
	public static HashMap<String, CardOpResult> resultMap = new HashMap<String, CardOpResult>();
	public static HashMap<String, String> resultDataMap = new HashMap<String, String>();

	// 用于web页面和发送中转
	// key为网页用户名或ip 然后值是波特率串口用户id等等
	public static HashMap<String, CardUserInfo> userCardMap = new HashMap<String, CardUserInfo>();
	public static HashMap<String, CardIssueRecord> issueUserCardRecordMap = new HashMap<String, CardIssueRecord>();

	public static HashMap<String, ESAMCardData> esamCardMap = new HashMap<String, ESAMCardData>();
	public static HashMap<String, ESAMCardIssueRecord> issueESAMCardRecordMap = new HashMap<String, ESAMCardIssueRecord>();

	public static HashMap<String, ISAMCardData> isamCardMap = new HashMap<String, ISAMCardData>();
	public static HashMap<String, ISAMCardIssueRecord> issueISAMCardRecordMap = new HashMap<String, ISAMCardIssueRecord>();

	public static HashMap<String, ReadCardNumRecord> readCardNumRecordMap = new HashMap<String, ReadCardNumRecord>();

	public static HashMap<String, ReadBalanceRecord> readBalanceRecordMap = new HashMap<String, ReadBalanceRecord>();

	public static HashMap<String, RechargeRecord> rechargeRecordMap = new HashMap<String, RechargeRecord>();

	public static HashMap<String, ReloadPINRecord> reloadPINRecordMap = new HashMap<String, ReloadPINRecord>();

	public static HashMap<String, ChangePINRecord> changePINRecordMap = new HashMap<String, ChangePINRecord>();

	public static HashMap<String, PretreatmentRecord> pretreatmentRecordMap = new HashMap<String, PretreatmentRecord>();

	public static HashMap<String, UnlockGreyRecord> unlockGreyRecordMap = new HashMap<String, UnlockGreyRecord>();

	public static HashMap<String, SerialPortConfig> serialPortConfigMap = new HashMap<String, SerialPortConfig>();

	// 发送和接受的中转
	public static HashMap<String, byte[]> initMap = new HashMap<String, byte[]>();// 读到初始化复制留给发送
}

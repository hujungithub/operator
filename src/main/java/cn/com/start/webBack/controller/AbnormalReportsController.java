package cn.com.start.webBack.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.start.webBack.dto.CPYCRunRecordDto;
import cn.com.start.webBack.dto.StartChargeGunRecordDto;
import cn.com.start.webBack.entity.ChargeRecord_DPF;
import cn.com.start.webBack.entity.CpUser;
import cn.com.start.webBack.entity.UserDeductMoneyRecord;
import cn.com.start.webBack.service.AbnormalReportsService;
import cn.com.start.webBack.service.BasicDataService;
import cn.com.start.webBack.util.Page;


/**
 * 
 * @author CREATED BY hanmingjing 20170721
 * 
 * 异常充电记录controller
 *
 */
@Controller
@RequestMapping("/abnormalreports")
public class AbnormalReportsController {

	@Autowired
	private AbnormalReportsService abnormalReportsService;
	@Autowired
	private BasicDataService basicDataService;
	/**
	 * 第一次进入查询
	 * 
	 * @param request
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	// 
	@RequestMapping("/findReportsFirst")
	public String findReportByPage(HttpServletRequest request,
			HttpServletResponse response) throws InstantiationException, IllegalAccessException {
		String roleId = request.getParameter("roleid");
		String operatorId = request.getParameter("operatorid");
		List<String> billList = basicDataService.findBill(operatorId);
		//1.创建SERVICE层
		//2.创建MAPPER层
		//3.调用、返回
		
		Page page = abnormalReportsService.findCPYCRunRecord();
		
		request.setAttribute("operatorId", operatorId);
		request.setAttribute("page", page);
		request.setAttribute("billList", billList);
		return "//jsp/operManage/abnormalReportsManage.jsp";
	}
	
	@RequestMapping("/findReportsDetail")
	public String findReportsDetailByCPId(HttpServletRequest request,
			HttpServletResponse response) throws InstantiationException, IllegalAccessException {
		
		String roleId = request.getParameter("roleid");
		String operatorId = request.getParameter("OPERATORID");
		String ID = request.getParameter("ID");
		//还要查一个费率模板
		List<String> billList = basicDataService.findBill(operatorId);
		String CPID = request.getParameter("CPID");
		Page page = abnormalReportsService.findCPYCRunRecordDetailFirst(CPID);
		request.setAttribute("billList", billList);
		request.setAttribute("page", page);
		//把ID传到前台
		request.setAttribute("ID", ID);
		return "//jsp/operManage/abnormalReportsDetail.jsp";
	}
	
	//addReports
	@RequestMapping("/addReports")
	public String addReports(HttpServletRequest request,
			HttpServletResponse response) throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {
		
		request.setCharacterEncoding("GBK");     
		response.setCharacterEncoding("GBK");     
		
		String SN = request.getParameter("SN");
		String ID = request.getParameter("ID");
		//
		CPYCRunRecordDto recordDto = abnormalReportsService.findCPYCRunRecordBySN(ID);
		StartChargeGunRecordDto startChargeGunRecordDto= abnormalReportsService.findStartCGRecordById(SN);
		//chargeFinishedFlagId 充电结束标志
		//chargeEndCauseId 充电结束原因

		
		String chargeFinishedFlagId = request.getParameter("chargeFinishedFlagId");
		Integer.parseInt(chargeFinishedFlagId);
		String chargeEndCauseId = new String(request.getParameter("chargeEndCauseId").
				getBytes("iso-8859-1"),"utf-8");
		//new String(request.getParameter("chargeEndCauseId").getBytes("iso-8859-1"),"utf-8")
		//为什么这样可以解决乱码问题呢？
		
		//创建对象，赋值以后保存进数据库中
		//数据的计算在什么时候？userchargerecord表
		//SN字段为自动增长
		ChargeRecord_DPF chargeRecord_DPF = new ChargeRecord_DPF();
		chargeRecord_DPF.setCPID(recordDto.getCPID());
		chargeRecord_DPF.setINTERFACEID(Integer.parseInt(startChargeGunRecordDto.getINTERFACEID()));
		chargeRecord_DPF.setCHARGEMETHODID(0);
		chargeRecord_DPF.setCHARGEMODEID(startChargeGunRecordDto.getCHARGEMODEID());
		chargeRecord_DPF.setCHARGEPARA(startChargeGunRecordDto.getCHARGEPARA());
		chargeRecord_DPF.setCHARGETIMESPAN(0);
		chargeRecord_DPF.setTRANSATIONID(getRandomNumStr());
		chargeRecord_DPF.setCARDNUM("2");
		chargeRecord_DPF.setRECORDTIME(recordDto.getRECORDTIME());
		chargeRecord_DPF.setCPUSERID(startChargeGunRecordDto.getCPUSERID());
		chargeRecord_DPF.setBILLMODELID(107);
		chargeRecord_DPF.setDEVICEID(startChargeGunRecordDto.getDEVICEID());
		chargeRecord_DPF.setSERVICETIP(0);
		chargeRecord_DPF.setCHARGEMONEY(recordDto.getGUNA_E());
		chargeRecord_DPF.setCHARGEFINISHEDFLAG(Integer.parseInt(chargeFinishedFlagId));//充电结束标志，int类型的自己填
		chargeRecord_DPF.setCHARGEENDCAUSE(chargeEndCauseId);
		chargeRecord_DPF.setCHARGESTARTTIME(startChargeGunRecordDto.getSENDSTARTCMDTIME());
		chargeRecord_DPF.setCHARGEQUANTITY(0);
		chargeRecord_DPF.setBEFORECHARGEBALANCE(0);
		
		abnormalReportsService.insertUserChargeRecord(chargeRecord_DPF);
		
		//这个有数据要插入进数据库吧
		//先去cpuserinfo表把用户数据找出来，把钱扣掉，再插入数据库
		String cpuserid = startChargeGunRecordDto.getCPUSERID();
		//userdeductmoneyrecord扣款记录表
		
		CpUser cpUser = abnormalReportsService.selectCpUserInfoByCpUserId(startChargeGunRecordDto.getCPUSERID());
		//可以查到cpuserinfo
		if(cpUser != null ){
			float accountSum = cpUser.getACCOUNTSUM();
			float guma_e = recordDto.getGUNA_E();
			accountSum = accountSum - guma_e;
			cpUser.setACCOUNTSUM(accountSum);
		}
		abnormalReportsService.updateAccountSumByCpUserId(cpUser);
		//再插入数据库，修改金额的话可不可以直接修改？肯定是直接修改
		//修改cpuserinfo表，参数为accountSum，修改字段为accountSum,cpuserid
		//然后再插入一条数据进userdeductmoneyrecord表---------
		//SN
		//准备userdeductmoneyrecord表所需要的数据，有这个entity
		//设值，插入数据库
		System.out.println("-----------recordDto-----------"+recordDto);
		System.out.println("-----------startChargeGunRecordDto-----------"+startChargeGunRecordDto);
		System.out.println("-----------updateAccountSumByCpUserId-----------"+cpUser);
		
		UserDeductMoneyRecord userDeductMoneyRecord = new UserDeductMoneyRecord();
		userDeductMoneyRecord.setINTERFACEID(chargeRecord_DPF.getINTERFACEID());
		userDeductMoneyRecord.setRECORDTIME(chargeRecord_DPF.getRECORDTIME());
		userDeductMoneyRecord.setCPID(chargeRecord_DPF.getCPID());
		userDeductMoneyRecord.setDEVICEID(chargeRecord_DPF.getDEVICEID());
		userDeductMoneyRecord.setPHYSICALCARDNUM(null);
		userDeductMoneyRecord.setCPUSERID(chargeRecord_DPF.getCPUSERID());
		userDeductMoneyRecord.setCHARGEMONEY(chargeRecord_DPF.getCHARGEMONEY());
		userDeductMoneyRecord.setSERVICETIP(chargeRecord_DPF.getSERVICETIP());
		userDeductMoneyRecord.setDEDUCTMONEY( recordDto.getGUNA_E());
		userDeductMoneyRecord.setREMAINMONEY(cpUser.getACCOUNTSUM());
		userDeductMoneyRecord.setDEDUCTSUCCESSFLAG(1);
		userDeductMoneyRecord.setDEDUCTFAILREASON(null);
		userDeductMoneyRecord.setDEDUCTMILE(0);
		userDeductMoneyRecord.setREMAINMILE(0);
		userDeductMoneyRecord.setDEDUCTQUANTITY(0);
		userDeductMoneyRecord.setREMAINQUANTITY(0);
		userDeductMoneyRecord.setDEDUCTTIMES(0);
		userDeductMoneyRecord.setTRANSATIONID(chargeRecord_DPF.getTRANSATIONID());
		//		//recordDto //startChargeGunRecordDto cpUser
		
		System.out.println(userDeductMoneyRecord);
		//
		abnormalReportsService.insertUserDeductMoneyRecord(userDeductMoneyRecord);
		System.out.println("-------------userDeductMoneyRecord-------------"+"插入成功！");
		//插入成功
		System.out.println("-------------cpUser-------------"+cpUser);
		System.out.println("-------------chargeRecord_DPF-------------"+chargeRecord_DPF);
		return "//jsp/operManage/abnormalReportsDetail.jsp";
	}
	
	
	//获取20位的随机字符串,第一位不为0
	public String getRandomNumStr(){
		String str = "";
		int count = 20;//获取字符串的长度
		for(int i=0;i<count;i++){
			int x = (int)(Math.random()*10);
			if(i==0 && x==0){
				continue;
			}
			String s = x+"";
			str = str + s;
			
		}
		return str;
	}
}

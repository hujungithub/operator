package cn.com.start.AppAPI.service;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.AppAPI.dto.ChargeRecorder;
import cn.com.start.AppAPI.dto.DeviceInfoDto_API;
import cn.com.start.AppAPI.dto.ScanChargeDto;
import cn.com.start.AppAPI.dto.SmsDto;
import cn.com.start.AppAPI.entity.BillModelInfo_API;
import cn.com.start.AppAPI.mapper.ScanChargeMapper;
import cn.com.start.AppAPI.util.ScanChargeUtile;

@Service
@Transactional
public class ScanChargeServiceImpl implements ScanChargeService {

	@Resource
	private ScanChargeMapper scanChargeMapper;

	/**
	 * 充电基础信息
	 */
	@Override
	public List<ScanChargeDto> findChargeInfo(String CPID, String operatorId) {
		List<ScanChargeDto> cpList = scanChargeMapper.selectChargeInfo(CPID);
		for (int i = 0; i < cpList.size(); i++) {
			cpList.get(0).setCHARGEFEE(
					this.calculatePrice(cpList.get(0).getRATEID(), operatorId));
		}
		return cpList;
	}

	@Override
	public DeviceInfoDto_API findDeviceInfo(String deviceId) {
		DeviceInfoDto_API deviceInfo = scanChargeMapper
				.selectDeviceInfo(deviceId);
		return deviceInfo;
	}

	/**
	 * 根据充电ID，当前时间计算充电价格
	 */
	@Override
	public String calculatePrice(String RATEID, String operatorId) {
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		BillModelInfo_API bill = scanChargeMapper.selectBillByRateId(RATEID,
				String.valueOf(month), operatorId);
		System.out.println("查询条件" + "rateid" + RATEID + "month" + month);
		System.out.println("查询到的bill" + bill.toString());
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE) + hour * 60;
		
		System.out.println("hour=" + hour + "minute="+minute);
		float chargefee;
		int tag = ScanChargeUtile.getTag(bill, minute);
		
//		for(int i = 0,j = 0; i < 50; i++){			
//			System.out.println("j="+ (j+20)+ "tag = "+ ScanChargeUtile.getTag(bill, j+=20));
//		}
		if (tag == 0) {
			chargefee = bill.getJPRICE();
		} else if (tag == 1) {
			chargefee = bill.getFPRICE();
		} else if (tag == 2) {
			chargefee = bill.getPPRICE();
		} else {
			chargefee = bill.getGPRICE();
		}
		System.out.println("最终价格" + chargefee + "类型" + tag);
		return String.valueOf(chargefee);
	}

	@Override
	public List<ChargeRecorder> chargeRecorder(String serialNo) {
		return scanChargeMapper.chargeRecorder(serialNo);
	}

	@Override
	public void updateUserStateBusy(String userId) {
		scanChargeMapper.updateUserStateBusy(userId);

	}

	@Override
	public void updateUserStateIdle(String userId) {
		scanChargeMapper.updateUserStateIdle(userId);

	}


	@Override
	public SmsDto selectUserInfo(String serialNo) {
		return scanChargeMapper.selectUserInfo(serialNo);
	}

	@Override
	public SmsDto selectCardUserInfo(String serialNo) {
		return scanChargeMapper.selectCardUserInfo(serialNo);
	}
	
	@Override
	public String culatePrice(String rateId, String operatorId) {
		return this.calculatePrice(rateId, operatorId);
	}


}

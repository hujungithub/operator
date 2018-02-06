package cn.com.start.webBack.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindBillModelDto;
import cn.com.start.webBack.entity.BillModelInfo;
import cn.com.start.webBack.entity.RateInfo;
import cn.com.start.webBack.mapper.BasicDataMapper;
import cn.com.start.webBack.service.BasicDataService;

@Service
@Transactional
public class BasicDataServiceImpl implements BasicDataService {

	@Resource
	public BasicDataMapper basicDataMapper;
//**************************************************************************************//
//**************************************************************************************//
	/**
	 * 查询费率模板
	 */
	@Override
	public List<String> findBill(String CSID) {
		List<String> billList = basicDataMapper.selectBill(CSID);
		return billList;
	}
	
//**************************************************************************************//
//**************************************************************************************//
	// 查询该运营商下模板
	@Override
	public List<BillModelDto> findBIllByRateId(FindBillModelDto findBillModelDto) {
		List<BillModelDto> billList = basicDataMapper
				.selectBillByRateId(findBillModelDto);
		return billList;
	}

	// 修改模板
	@Override
	public int updateBill(BillModelInfo billModelInfo) {
		int flag = basicDataMapper.updateBill(billModelInfo);
		return flag;
	}

	// 查询共有几套模板
	@Override
	public List<String> findRateId() {
		List<String> rateList = basicDataMapper.selectRateId();
		return rateList;
	}

	@Override
	public List<BillModelDto> findUpdate(FindBillModelDto findBillModelDto) {
		// TODO Auto-generated method stub
		List<BillModelDto> updateList = basicDataMapper
				.selectUpdate(findBillModelDto);
		return updateList;
	}

	@Override
	public List<String> findBillModelId() {
		// TODO Auto-generated method stub
		List<String> billList = basicDataMapper.selectBillModelId();
		return billList;
	}

	

	/**
	 * 根据充电ID，当前时间计算充电价格
	 */
	@Override
	public float calculatePrice(String priceId) {
		RateInfo rateInfo = basicDataMapper.selectPriceByRateId(priceId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String currTime = df.format(new Date()).substring(11, 16); // Date()为获取当前系统时间
		float price;
		if (currTime.compareTo(rateInfo.getFPSTARTTIME()) >= 0
				&& currTime.compareTo(rateInfo.getFPENDTIME()) <= 0) {
			price = rateInfo.getFPRICE();
		} else if (currTime.compareTo(rateInfo.getGPSTARTTIME()) >= 0 // 平
				&& currTime.compareTo(rateInfo.getGPENDTIME()) <= 0) {
			price = rateInfo.getGPRICE();
		} else if (currTime.compareTo(rateInfo.getJPSTARTTIME()) >= 0
				&& currTime.compareTo(rateInfo.getJPENDTIME()) <= 0) {
			price = rateInfo.getJPRICE();
		} else if (currTime.compareTo(rateInfo.getPPSTARTTIME()) >= 0
				&& currTime.compareTo(rateInfo.getPPENDTIME()) <= 0) {
			price = rateInfo.getPPRICE();
		} else {
			price = 100;
		}
		return price;
	}

	@Override
	public List<BillModelInfo> findRate() {
		List<BillModelInfo> rateList = basicDataMapper.selectRate();
		return rateList;
	}

	@Override
	public List<BillModelInfo> findBillModel() {
		// TODO Auto-generated method stub
		List<BillModelInfo> billList = basicDataMapper.selectBillModel();
		return billList;
	}

	@Override
	public List<CPInfoDto> findchargePattern(){
		List<CPInfoDto> chargePatternList = basicDataMapper.selectchargePattern();
		return chargePatternList;
	}

	@Override
	public List<String> findBillByCPID(String CPID) {
		List<String> billList = basicDataMapper.selectBillByCPID(CPID);
		return billList;
	}

}

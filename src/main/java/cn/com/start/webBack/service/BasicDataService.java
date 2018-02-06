package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindBillModelDto;
import cn.com.start.webBack.entity.BillModelInfo;

public interface BasicDataService {

	// 查询费率模板
	List<String> findBill(String CPID);

	float calculatePrice(String priceId);

	// 根据模板id查询改模板所有（12）套电价
	List<BillModelDto> findBIllByRateId(FindBillModelDto findBillModelDto);

	// 查询共有几套模板
	List<String> findRateId();

	List<BillModelInfo> findRate();

	// 根据ID修改电价设置
	int updateBill(BillModelInfo billModelInfo);

	List<BillModelDto> findUpdate(FindBillModelDto findBillModelDto);

	// 查询共有几个方案
	List<String> findBillModelId();

	List<BillModelInfo> findBillModel();

	List<CPInfoDto> findchargePattern();

	List<String> findBillByCPID(String cPID);

}

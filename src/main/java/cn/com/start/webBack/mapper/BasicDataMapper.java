package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.BillModelDto;
import cn.com.start.webBack.dto.CPInfoDto;
import cn.com.start.webBack.dto.FindBillModelDto;
import cn.com.start.webBack.entity.BillModelInfo;
import cn.com.start.webBack.entity.RateInfo;

public interface BasicDataMapper {
	// 根据ID查询所有
	List<BillModelDto> selectBillByRateId(FindBillModelDto findBillModelDto);

	// 根据费率ID查询费率
	RateInfo selectPriceByRateId(String rateId);

	// 查询费率模板
	List<String> selectBill(String CPID);

	// 查询共有几套模板
	List<String> selectRateId();

	List<BillModelInfo> selectRate();

	// 修改莫一套模板
	int updateBill(BillModelInfo billModelInfo);

	List<BillModelDto> selectUpdate(FindBillModelDto findBillModelDto);

	// 查询有几个方案
	List<String> selectBillModelId();

	List<BillModelInfo> selectBillModel();

	List<CPInfoDto> selectchargePattern();

	List<String> selectBillByCPID(String cPID);

}

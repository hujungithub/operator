package cn.com.start.AppAPI.service;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.AppAPI.dto.CPInfoDto_API;
import cn.com.start.AppAPI.dto.CscpIdDto;
import cn.com.start.AppAPI.dto.ListSMDto;
import cn.com.start.AppAPI.dto.MapSMDto;
import cn.com.start.AppAPI.dto.SelectMapDto;
import cn.com.start.AppAPI.entity.BillModelInfo_API;
import cn.com.start.AppAPI.mapper.MapSPMapper;
import cn.com.start.AppAPI.mapper.ScanChargeMapper;
import cn.com.start.AppAPI.util.ScanChargeUtile;

@Service
@Transactional
public class MapSPServiceImpl implements MapSPService {
	private static Logger logger = LogManager.getLogger("LOG_API");

	@Resource
	private MapSPMapper mapSPMapper;
	@Resource
	private ScanChargeMapper scanChargeMapper;

	/**
	 * 根据金纬度查附近站
	 */
	@Override
	public List<MapSMDto> findNearCS(SelectMapDto selectMapDto) {
		List<MapSMDto> csList = mapSPMapper.selectNearCS(selectMapDto);
		return csList;
	}

	/**
	 * 根据经纬度查询附近cpm
	 */
	@Override
	public List<MapSMDto> findNearCPM(SelectMapDto selectMapDto) {
		List<MapSMDto> cpmList = mapSPMapper.selectNearCPM(selectMapDto);
		return cpmList;
	}

	/**
	 * 列表找站
	 */
	@Override
	public List<ListSMDto> findCSList(SelectMapDto selectMapDto) {
		List<ListSMDto> csList = mapSPMapper.selectCSList(selectMapDto);
		for (int i = 0; i < csList.size(); i++) {
			csList.get(i).setCHARGEFEE(
					calculatePrice(csList.get(i).getRATEID(), csList.get(i).getOPERATORID()));
		}

		return csList;
	}



	/**
	 * 根据充电ID，当前时间计算充电价格
	 */
	public String calculatePrice(String RATEID, String operatorId) {
		if(operatorId == null){
			System.out.println("operatorId == null");
			return "";
		}
		
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("#################################");
		System.out.println("查询条件" + "rateid:" + RATEID + "month:" + month+",operatorId:"+operatorId);
		BillModelInfo_API bill = scanChargeMapper.selectBillByRateId(RATEID,
				String.valueOf(month), operatorId);
		if(bill == null){
			System.out.println("calculatePrice查询失败");
			return "";
		}

		System.out.println("查询到的bill" + bill.toString());
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE) + hour * 60;
		System.out.println(minute);

		float chargefee = 0;
		int tag = ScanChargeUtile.getTag(bill, minute);

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

	/**
	 * 列表找cpm
	 */
	@Override
	public List<ListSMDto> findCPMList(SelectMapDto selectMapDto) {
		List<ListSMDto> cpmList = mapSPMapper.selectCPMList(selectMapDto);
		return cpmList;
	}

	/**
	 * 根据站ID查询站内桩
	 */
	@Override
	public List<CPInfoDto_API> findCPInfoByCSId(String CSID) {
		List<CPInfoDto_API> cpList = mapSPMapper.selectCPInfoByCSId(CSID);
		return cpList;
	}

	/**
	 * 
	 */
	@Override
	public List<CPInfoDto_API> findCPInfoByCPMId(String CPMID) {
		List<CPInfoDto_API> cpList = mapSPMapper.selectCPInfoByCPMId(CPMID);
		return cpList;
	}

	private void printLog(String methodName, String content) {
		logger.info("##################################################");
		logger.info("##############" + methodName + "######################");
		logger.info(content);
		logger.info("####################################################");
		logger.info("####################################################");
	}

	@Override
	public List<String> getCpId(String csId) {
		List<String> cpIdList = mapSPMapper.selectCpId(csId);
		return cpIdList;
	}

	@Override
	public List<CscpIdDto> selectCpId(String[] csId) {
		List<CscpIdDto> cpIdList = mapSPMapper.selectCpIdList(csId);
		return cpIdList;
	}
}

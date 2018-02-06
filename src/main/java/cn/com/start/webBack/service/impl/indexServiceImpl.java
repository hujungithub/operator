package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.FindIndexDto;
import cn.com.start.webBack.dto.IndexDto;
import cn.com.start.webBack.mapper.IndexMapper;
import cn.com.start.webBack.service.IndexService;

@Service
@Transactional
public class indexServiceImpl implements IndexService {

	@Resource
	public IndexMapper indexMapper;

	// 首次进入查询数据
	@Override
	public IndexDto findIndexDto(String operatorId) {
		IndexDto indexDto0 = indexMapper.selectCSStatistic(operatorId);
		IndexDto indexDto0_1 = indexMapper.selectCPStatistic(operatorId);
		IndexDto indexDto0_2 = indexMapper.selectDCPStatistic(operatorId);
		IndexDto indexDto0_3 = indexMapper.selectACPStatistic(operatorId);		
		IndexDto indexDto1 = indexMapper.selectMoneyStatistic(operatorId);
		IndexDto indexDto2 = indexMapper.selectAppStatistic();
		IndexDto indexDto3 = indexMapper.selectCardStatistic();
		indexDto0.setCPCOUNT(indexDto0_1.getCPCOUNT());
		indexDto0.setDCPCOUNT(indexDto0_2.getDCPCOUNT());
		indexDto0.setACPCOUNT(indexDto0_3.getACPCOUNT());
		indexDto0.setCHARGECOUNT(indexDto1.getCHARGECOUNT());
		indexDto0.setMONEYCOUNT(indexDto1.getMONEYCOUNT());
		indexDto0.setSERVICECOUNT(indexDto1.getSERVICECOUNT());
		indexDto0.setAPPCOUNT(indexDto2.getAPPCOUNT());
		indexDto0.setCARDCOUNT(indexDto3.getCARDCOUNT());
		return indexDto0;
	}

	@Override
	public float[] findChargeStatistic(FindIndexDto findIndexDto) {
		List<FindIndexDto> chargeList = indexMapper
				.selectChargeStatistic(findIndexDto);
		int day = findIndexDto.getDAY();
		float[] yAxis = new float[day];
		for (int i = 0; i < chargeList.size(); i++) {
			FindIndexDto findIndexDto2 = chargeList.get(i);
			int temp = findIndexDto2.getDAY();
			for (int j = 0; j < day; j++) {
				if (temp == j + 1) {
					yAxis[j] = findIndexDto2.getCHARGEQUANTITY();
				}
			}
		}
		return yAxis;
	}

	@Override
	public int[] findCountStatistic(FindIndexDto findIndexDto) {
		List<FindIndexDto> countList = indexMapper
				.selectCountStatistic(findIndexDto);
		System.out.println("count=" + countList.toString());
		int day = findIndexDto.getDAY();
		int[] yAxis = new int[day];
		for (int i = 0; i < countList.size(); i++) {
			FindIndexDto findIndexDto2 = countList.get(i);
			int temp = findIndexDto2.getDAY();
			for (int j = 0; j < day; j++) {
				if (temp == j + 1) {
					yAxis[j] = findIndexDto2.getCHARGECOUNT();
				}
			}
		}
		return yAxis;
	}

	@Override
	public float[] findIncomeStatistic(FindIndexDto findIndexDto) {
		List<FindIndexDto> incomeList = indexMapper
				.selectIncomeStatistic(findIndexDto);
		System.out.println("incomeList=" + incomeList.toString());
		int day = findIndexDto.getDAY();
		float[] yAxis = new float[day];
		for (int i = 0; i < incomeList.size(); i++) {
			FindIndexDto findIndexDto2 = incomeList.get(i);
			int temp = findIndexDto2.getDAY();
			for (int j = 0; j < day; j++) {
				if (temp == j + 1) {
					yAxis[j] = findIndexDto2.getCHARGEMONEY();
				}
			}
		}
		return yAxis;
	}
}

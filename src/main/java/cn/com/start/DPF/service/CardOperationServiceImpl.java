package cn.com.start.DPF.service;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.carddata.CardShortMessage;
import cn.com.start.DPF.mapper.CardOperationMapper;

@Service
@Transactional
public class CardOperationServiceImpl implements CardOperationService {

	@Resource
	private CardOperationMapper cardOperationMapper;

	//检查是否存在相同的配置
	@Override
	public int checkConfig(SerialPortConfig serialPortConfig){
		int count = cardOperationMapper.checkConfig(serialPortConfig);
		return count;
	}

	//根据ID查找配置
	@Override
	public SerialPortConfig findOperatorById(int ID){
		SerialPortConfig serialPortConfig = cardOperationMapper.findOperatorById(ID);
		return serialPortConfig;
	}
	
	// 新增串口模板
	@Override
	public int addSerialPortConfig(SerialPortConfig serialPortConfig) {
		int flag = cardOperationMapper.insertSerialPortConfig(serialPortConfig);
		return flag;
	}

	//删除串口配置
	@Override
	public void deleteById(String[] IDS){
		cardOperationMapper.deleteById(IDS);
	}
	
	// 查询串口模板
	@Override
	public List<SerialPortConfig> findSerialPortConfig() {
		List<SerialPortConfig> serialPortList = cardOperationMapper
				.selectSerialPortConfig();
		return serialPortList;
	}

	// 修改串口模板
	@Override
	public int updateSerialPortConfig(SerialPortConfig serialPortConfig) {
		int flag = cardOperationMapper.updateSerialPortConfig(serialPortConfig);
		return flag;
	}

	// 根据id查询串口模板
	@Override
	public SerialPortConfig findSPCById(int id) {
		SerialPortConfig spc = cardOperationMapper.selectSPCById(id);
		return spc;
	}
	
	// 检查卡用户号是否已存在
	@Override
	public int checkUserCardNum(String cardNum) {
		BigInteger cn = new BigInteger(cardNum);
		int count = cardOperationMapper.checkUserCardNum(cn);
		return count;
	}

	// 检查卡ESAM号是否已存在
	@Override
	public int checkESAMCardNum(String cardNum) {
		int count = cardOperationMapper.checkESAMCardNum(cardNum);
		return count;
	}

	// 检查卡ISAM号是否已存在
	@Override
	public int checkISAMCardNum(String cardNum) {
		int count = cardOperationMapper.checkISAMCardNum(cardNum);
		return count;
	}
	
	//
	@Override
	public CardShortMessage selectShortMessageMsg(CardShortMessage cardShortMessage){
		CardShortMessage cardShortMessage2 = cardOperationMapper.selectShortMessageMsg(cardShortMessage);
		cardShortMessage.setACCOUNTSUM(cardShortMessage2.getACCOUNTSUM());
		cardShortMessage.setTELEPHONE(cardShortMessage2.getTELEPHONE());
		return cardShortMessage;
	}
	
	//
	@Override
	public int findCardState(String cARDNUM){
		int cardstate = cardOperationMapper.findCardState(cARDNUM);
		return cardstate;
	}
}

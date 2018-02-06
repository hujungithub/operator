package cn.com.start.DPF.service;

import java.util.List;

import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.carddata.CardShortMessage;

public interface CardOperationService {
	//检查是否存在相同的配置
	int checkConfig(SerialPortConfig serialPortConfig);
	
	//根据ID查找配置
	SerialPortConfig findOperatorById(int ID);
	
	// 新增串口配置模板
	int addSerialPortConfig(SerialPortConfig serialPortConfig);
	
	//删除串口配置
	void deleteById(String[] IDS);

	// 查询串口配置模板
	List<SerialPortConfig> findSerialPortConfig();

	// 修改串口配置模板
	int updateSerialPortConfig(SerialPortConfig serialPortConfig);
	
	// 根据id查询串口配置
	SerialPortConfig findSPCById(int id);
	
	// 检查用户卡号是否已存在
	int checkUserCardNum(String cardNum);
	
	// 检查ESAM卡号是否已存在
	int checkESAMCardNum(String cardNum);
	
	// 检查ISAM卡号是否已存在
	int checkISAMCardNum(String cardNum);
	
	//查找发短信所需的余额和手机号
	CardShortMessage selectShortMessageMsg(CardShortMessage cardShortMessage);

	int findCardState(String cARDNUM);
}

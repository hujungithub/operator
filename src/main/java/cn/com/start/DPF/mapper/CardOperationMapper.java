package cn.com.start.DPF.mapper;

import java.math.BigInteger;
import java.util.List;

import cn.com.start.DPF.entity.SerialPortConfig;
import cn.com.start.DPF.entity.carddata.CardShortMessage;

public interface CardOperationMapper {

	//检查是否存在相同的配置
	int checkConfig(SerialPortConfig serialPortConfig);
	
	//根据ID查找配置
	SerialPortConfig findOperatorById(int ID);
	
	// 新增串口号
	int insertSerialPortConfig(SerialPortConfig serialPortConfig);
	
	//删除串口配置
	int deleteById(String[] IDS);

	// 查询串口号模板
	List<SerialPortConfig> selectSerialPortConfig();

	// 修改串口号模板
	int updateSerialPortConfig(SerialPortConfig serialPortConfig);

	// 根据id查询串口配置
	SerialPortConfig selectSPCById(int id);
	
	// 检查用户卡号是否已存在
	int checkUserCardNum(BigInteger cardNum);
	
	// 检查ESAM卡号是否已存在
	int checkESAMCardNum(String cardNum);
	
	//检查ISAM卡号是否已存在
	int checkISAMCardNum(String cardNum);
	
	//
	CardShortMessage selectShortMessageMsg(CardShortMessage cardShortMessage);

	int findCardState(String cardNum);
}

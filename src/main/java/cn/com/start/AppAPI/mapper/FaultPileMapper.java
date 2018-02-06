package cn.com.start.AppAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.start.AppAPI.entity.CPFAI;
import cn.com.start.AppAPI.entity.FaultOrder;

public interface FaultPileMapper {

	List<CPFAI> selectFaultPile(@Param("longitude") String longitude,
			@Param("latitude") String latitude);

	int insertFaulOrder(FaultOrder faultOrder);

	List<CPFAI> selectReadyList(String rmId);

	List<CPFAI> selectIsList(String rmId);

	List<CPFAI> selectDoneList(String rmId);

	int updateFAIById(String cpId);

	int updateOrderFirst(@Param("orderId") String orderId,
			@Param("content") String content);
}

package cn.com.start.webBack.mapper;

import java.util.List;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.FindAddressDto;
import cn.com.start.webBack.entity.Address;

public interface AddressMapper {

	// 分页查询地址
	List<AddressDto> selectAddressByPage(FindAddressDto findAddressDto);

	// 查询总数量
	int getAddressCount(FindAddressDto findAddressDto);
	
	// 根据充电站ID查询地址
	Address selectAddressByCSId(int csId);

	// ///////////////////////////////////////////****************************//////////////////
	// ///////////////////////////////////////////**************************////////////////
	// ////////////////////////////////////////**********************/////////////////////////
	// //////////////////////////////////******************************///////////////////

	// 根据条件查询
	List<AddressDto> findAddressBy(FindAddressDto findAddressDto);

	// 增加桩地址前先查询id
	String selectAddressIdBeforeAdd();

	// 根据cpid查询地址dto
	AddressDto selectAddressDtoByCPId(String cpId);

	

	// 根据省市区ID查询拼接地址
	String selectPCAById(AddressDto addressDto);

	// 根据id删除
	boolean deleteById(String ADDRESSIDS[]);

	// 根据ID查询地址信息
	List<AddressDto> findAddressDtoById(int ADDRESSID);

	// 新增地址
	int insertAddress(AddressDto addRess);

	// 用户详细
	Address findAddressById(int ADDRESSID);

	// 根据ID查询地址信息
	FindAddressDto findFindAddressDtoById(int ADDRESSID);

	// 修改地址信息
	int updateById(AddressDto AddressDto);

	// 查询所有地址信息
	List<AddressDto> selectAllAddress(FindAddressDto findAddressDto);
}

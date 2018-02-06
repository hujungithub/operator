package cn.com.start.webBack.service;

import java.util.List;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.FindAddressDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.util.Page;

public interface AddressService {

	// 根据桩id查询地址
	AddressDto findAddressDtoByCPId(String cpId);

	// 增加地址之前先查地址id
	String findAddressIdBeforeAdd();

	// 根据ID查询省市区拼接地址
	String findPCAById(AddressDto addressDto);

	// 根据充电站ID查询地址
	Address findAddressByCSId(int csId);

	// 新增充电桩地址
	int addAddress(AddressDto addressDto);

	// 根据条件查询
	List<AddressDto> findAddressBy(FindAddressDto findAddressDto);

	// 分页查询用户
	List<AddressDto> showAddressByPage(FindAddressDto findAddressDto);

	// 根据id删除
	boolean deleteById(String ADDRESSIDS[]);

	// 新增地址
	int insertAddress(AddressDto addRess);

	// 用户详细
	Address findAddressById(int ADDRESSID);

	// 根据ID查询地址信息
	List<AddressDto> findAddressDtoById(int ADDRESSID);

	// 修改地址信息
	int updateById(AddressDto addressDto);

	// 查询所有地址信息 导出
	List<AddressDto> findAllAddress(FindAddressDto findAddressDto);
}

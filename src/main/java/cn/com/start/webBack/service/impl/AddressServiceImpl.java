package cn.com.start.webBack.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.start.webBack.dto.AddressDto;
import cn.com.start.webBack.dto.FindAddressDto;
import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.mapper.AddressMapper;
import cn.com.start.webBack.service.AddressService;
import cn.com.start.webBack.util.Page;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Resource
	public AddressMapper addressMapper;

	//*******************************************************************************//
	//*******************************************************************************//
	
	/**
	 * 根据省市区ID拼接地址
	 */
	@Override
	public String findPCAById(AddressDto addressDto) {
		String location = addressMapper.selectPCAById(addressDto);
		return location;
	}
	
	/**
	 * 增加地址之前先查询id
	 * 
	 */
	@Override
	public String findAddressIdBeforeAdd() {
		String addressId = addressMapper.selectAddressIdBeforeAdd();
		return addressId;
	}
	
	/**
	 * 新增地址记录
	 */
	@Override
	public int addAddress(AddressDto addressDto) {
		int flag = addressMapper.insertAddress(addressDto);
		return flag;
	}
	
	/**
	 * 根据充电站ID查找地址
	 */
	@Override
	public Address findAddressByCSId(int csId) {
		Address address = addressMapper.selectAddressByCSId(csId);
		return address;
	}
	// 分页查询地址
	@Override
	public List<AddressDto> showAddressByPage(FindAddressDto findAddressDto) {
//		int pageCount = addressMapper.getAddressCount(findAddressDto);
//		Page page = new Page(pageCount, findAddressDto.getPageSize(),
//				findAddressDto.getPageNow());
//		findAddressDto.setStartPos(page.getStartPos());
		List<AddressDto> onePageAddressList = addressMapper
				.selectAddressByPage(findAddressDto);
//		page.setList(onePageAddressList);
		
		return onePageAddressList;
	}
	// 根据id删除
	@Override
	public boolean deleteById(String ADDRESSIDS[]) {
		boolean count = addressMapper.deleteById(ADDRESSIDS);
		return count;
	}
	// 新增地址
	@Override
	public int insertAddress(AddressDto addRess) {
		int count = addressMapper.insertAddress(addRess);
		return count;
	}
	// 根据ID查询地址信息
	@Override
	public List<AddressDto> findAddressDtoById(int ADDRESSID) {
		List<AddressDto> addressDto = addressMapper.findAddressDtoById(ADDRESSID);
		return addressDto;
	}
	// 修改地址信息
	@Override
	public int updateById(AddressDto addressDto) {
		int updatecount = addressMapper.updateById(addressDto);
		return updatecount;
	}
	// 查询所有地址信息
	@Override
	public List<AddressDto> findAllAddress(FindAddressDto findAddressDto) {
		// TODO Auto-generated method stub
		List<AddressDto> addressList = addressMapper
				.selectAllAddress(findAddressDto);
		return addressList;
	}
	//*******************************************************************************//
	//*******************************************************************************//

	// 根据条件查询
	@Override
	public List<AddressDto> findAddressBy(FindAddressDto findAddressDto) {
		List<AddressDto> findAddressBylist = addressMapper
				.findAddressBy(findAddressDto);
		return findAddressBylist;
	}



	// 用户详细
	@Override
	public Address findAddressById(int ADDRESSID) {
		Address address = addressMapper.findAddressById(ADDRESSID);
		return address;
	}






	/**
	 * 根据cpid查询地址dto
	 */
	@Override
	public AddressDto findAddressDtoByCPId(String cpId) {
		AddressDto addressDto = addressMapper.selectAddressDtoByCPId(cpId);
		return addressDto;
	}

	

	

	

}

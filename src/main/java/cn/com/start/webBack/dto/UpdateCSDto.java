package cn.com.start.webBack.dto;

import java.util.List;

import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.entity.RoleInfo;

public class UpdateCSDto {
	private List<OperatorInfo> operList; //运营商
	private List<Province> proList;  //省份
	private List<City> cityList;   //城市
	private List<Area> areaList;   //地区
	private List<Address> addressList;   //地址
	private CSInfo csInfo;    
	private AddressDto addressDto;
	private UserInfoDto userInfoDto;
	private List<RoleInfo> roleList;      //权限

	public UserInfoDto getUserInfoDto() {
		return userInfoDto;
	}

	public void setUserInfoDto(UserInfoDto userInfoDto) {
		this.userInfoDto = userInfoDto;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	public List<OperatorInfo> getOperList() {
		return operList;
	}

	public void setOperList(List<OperatorInfo> operList) {
		this.operList = operList;
	}

	public List<Province> getProList() {
		return proList;
	}

	public void setProList(List<Province> proList) {
		this.proList = proList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public CSInfo getCsInfo() {
		return csInfo;
	}

	public void setCsInfo(CSInfo csInfo) {
		this.csInfo = csInfo;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	@Override
	public String toString() {
		return "UpdateCSDto [operList=" + operList + ", proList=" + proList
				+ ", cityList=" + cityList + ", areaList=" + areaList
				+ ", addressList=" + addressList + ", csInfo=" + csInfo
				+ ", addressDto=" + addressDto + "]";
	}

}

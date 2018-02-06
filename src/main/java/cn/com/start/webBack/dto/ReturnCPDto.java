package cn.com.start.webBack.dto;

import java.util.List;

import cn.com.start.webBack.entity.Address;
import cn.com.start.webBack.entity.Area;
import cn.com.start.webBack.entity.CPInfo;
import cn.com.start.webBack.entity.CPMfrInfo;
import cn.com.start.webBack.entity.CPStateType;
import cn.com.start.webBack.entity.CSInfo;
import cn.com.start.webBack.entity.City;
import cn.com.start.webBack.entity.OperatorInfo;
import cn.com.start.webBack.entity.ProtocolInfo;
import cn.com.start.webBack.entity.Province;
import cn.com.start.webBack.entity.RoleInfo;

public class ReturnCPDto {

	// 充电桩
	private CPInfo cpInfo;
	// 地址
	private AddressDto addressDto;
	// 运营商列表
	private List<OperatorInfo> operList;
	// 充电站列表
	private List<CSInfo> csList;
	// 充电桩
	private List<CPInfo> cpList;
	// 权限
	private List<RoleInfo> roleList;
	// 省
	private List<Province> proList;
	// 市
	private List<City> cityList;
	// 区
	private List<Area> areaList;
	// 地址
	private List<Address> addressList;
	// 厂商
	private List<CPMfrInfo> mfrList;
	// 型号
	private List<String> modelList;
	// 状态
	private List<CPStateType> stateList;
	// 协议
	private List<ProtocolInfo> infoList;
	// 费率模板
	private List<String> billList;

	public List<String> getBillList() {
		return billList;
	}

	public void setBillList(List<String> billList) {
		this.billList = billList;
	}

	public List<ProtocolInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<ProtocolInfo> infoList) {
		this.infoList = infoList;
	}

	// 地址dto
	public List<CPStateType> getStateList() {
		return stateList;
	}

	public void setStateList(List<CPStateType> stateList) {
		this.stateList = stateList;
	}

	public List<String> getModelList() {
		return modelList;
	}

	public void setModelList(List<String> modelList) {
		this.modelList = modelList;
	}

	// 最早建桩时间
	private String lastTime;
	// 当天
	private String currTime;

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

	public List<CSInfo> getCsList() {
		return csList;
	}

	public void setCsList(List<CSInfo> csList) {
		this.csList = csList;
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

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getCurrTime() {
		return currTime;
	}

	public void setCurrTime(String currTime) {
		this.currTime = currTime;
	}

	public List<CPInfo> getCpList() {
		return cpList;
	}

	public void setCpList(List<CPInfo> cpList) {
		this.cpList = cpList;
	}

	public List<CPMfrInfo> getMfrList() {
		return mfrList;
	}

	public void setMfrList(List<CPMfrInfo> mfrList) {
		this.mfrList = mfrList;
	}

	public CPInfo getCpInfo() {
		return cpInfo;
	}

	public void setCpInfo(CPInfo cpInfo) {
		this.cpInfo = cpInfo;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

}

package cn.com.start.webBack.dto;

import java.util.List;

import cn.com.start.webBack.entity.BillModelInfo;

public class RateInfoDto {
	
		// 费率模板
		private List<BillModelInfo> rateList;
		//方案
		private List<BillModelInfo> billList;
		//费率信息
		private BillModelDto billModelDto;
		
		public List<BillModelInfo> getRateList() {
			return rateList;
		}
		public void setRateList(List<BillModelInfo> rateList) {
			this.rateList = rateList;
		}
		public List<BillModelInfo> getBillList() {
			return billList;
		}
		public void setBillList(List<BillModelInfo> billList) {
			this.billList = billList;
		}
		public BillModelDto getBillModelDto() {
			return billModelDto;
		}
		public void setBillModelDto(BillModelDto billModelDto) {
			this.billModelDto = billModelDto;
		}
		
		
		
}

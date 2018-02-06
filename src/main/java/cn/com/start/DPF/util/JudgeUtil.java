package cn.com.start.DPF.util;

import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.CPYCRunRecord_104;
import cn.com.start.DPF.entity.DCYcRunRecord;

public class JudgeUtil {

	// 判断桩是否在线
	public static boolean isCPOnLine(String cpId) {
		boolean flag = true;
		int cptype = JudgeUtil.getCPType(cpId);
		if (cptype == 0) {
			DCYcRunRecord dcycRecord = DataRelay.sychroDCYCMap.get(cpId);
			if ((System.currentTimeMillis() - dcycRecord.getMILLSECONDS()) > 30000) {
				flag = false;
			}
		} else {
			CPYCRunRecord_104 ycRecord = DataRelay.sychroYCMap.get(cpId);
			if ((System.currentTimeMillis() - ycRecord.getMILLSECONDS()) > 30000) {
				flag = false;
			}
		}
		return flag;
	}

	// 获取直流还是交流
	public static int getCPType(String cpId) {
		String key = DataRelay.cpMap.get(cpId).getMFRID() + "_"
				+ DataRelay.cpMap.get(cpId).getMODEL();
		int cptype = DataRelay.modelMap.get(key).getCPTYPE();
		return cptype;
	}
}

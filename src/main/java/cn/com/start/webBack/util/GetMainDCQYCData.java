package cn.com.start.webBack.util;

import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.DCYcRunRecord;

public class GetMainDCQYCData {
	public static String row1 = "<tr class = \"odd\">";
	public static String row2 = "<td rowspan =2 >1</td>";
	public static String row3 = "<td>a</td>";
	public static String row4 = "</tr>";

	public static void getEmptyDCYCRecord(String cpId) {
		DCYcRunRecord dcycRecord = new DCYcRunRecord();
		dcycRecord.setCPID(cpId);
		dcycRecord.setRECORDTIME("--");
		dcycRecord.setCPSTATE("0000");
		dcycRecord.setMILLSECONDS(0);
		dcycRecord.setChargeVOut(0f);
		dcycRecord.setChargeAOut(0f);
		dcycRecord.setBatteryMaxtemp(0f);
		dcycRecord.setBatteryMintemp(0f);
		dcycRecord.setBatteryPackMaxtemp(0f);
		dcycRecord.setBatteryPackMintemp(0f);
		dcycRecord.setChargeDirectV(0f);
		dcycRecord.setChargeMoney(0f);
		dcycRecord.setChargePower(0f);
		dcycRecord.setChargeQuantity(0f);
		dcycRecord.setChargerTemp(0f);
		dcycRecord.setChargeTimeSpan(0f);
		dcycRecord.setSOC(0f);
		DataRelay.sychroDCYCMap.put(cpId, dcycRecord);
	}

	// 拿到cpid先打到遥测数据对象 然后拼接字符串
	public static String getDCQYCRealData(String cpId, int row) {
		DCYcRunRecord dcycRecord = DataRelay.sychroDCYCMap.get(cpId);
		String type = "";
		if (DataRelay.sychroDCYXMap.get(dcycRecord.getCPID()) != null) {
			type = DataRelay.sychroDCYXMap.get(dcycRecord.getCPID())
					.getNewValue().substring(0, 4);
		} else {
			type = "0000";
		}
		int state = GetMainDCQYCData.getTypeIdByString(type);
		dcycRecord.setCPSTATE(DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
				dcycRecord.getCPID()).getPROTOCOLID()
				+ "_" + state));
		String ycData = "";
		if (DataRelay.cpMap.get(cpId).getINTERFACECOUNT() == 0) {
			// 单枪
			ycData = getSingleGunYCData(dcycRecord, row);
		}
		// else {
		// // 双枪
		// ycData = getDoubleGunYCData(dcycRecord, row);
		// }

		return ycData;
	}

	// 拼接直流表头
	public static String getDCYCThead() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<thead><tr>").append("<th>充电桩ID</th>")
				.append("<th>桩状态</th>").append("<th>状态时间</th>")
				.append("<th>枪</th>").append("<th>枪状态</th>")
				.append("<th>SOC</th>").append("<th>电量(kWh)</th>")
				.append("<th>金额(元)</th>").append("<th>已充时间(分)</th>")
				.append("<th>功率(kw)</th>").append(" <th>电压(V)</th>")
				.append(" <th>电流(A)</th>").append(" <th>电池组最高温度(℃)</th>")
				.append("<th>电池组最低温度(℃)</th>").append(" <th>单体电池最高温度(℃)</th>")
				.append(" <th>单体电池最低温度(℃)</th>").append(" <th>充电机温度(℃)</th>")
				.append(" <th>充电导引电压(V)</th>").append("</tr></thead>");
		return sBuffer.toString();
	}

	public static String getSingleGunYCData(DCYcRunRecord dcycRecord, int row) {
		StringBuffer sBuffer = new StringBuffer();
		if (row % 2 == 0) {
			sBuffer.append("<tr class = \"odd\">");
		} else {
			sBuffer.append("<tr>");
		}
		sBuffer.append("<td>" + dcycRecord.getCPID() + "</td>"); // cpid 1
		if ((System.currentTimeMillis() - dcycRecord.getMILLSECONDS()) > 60000) {
			// 如果当前时间与遥测时间超过1分钟则认为离线
			sBuffer.append("<td>" + "离线" + "</td>"); // 状态 //2
		} else {
			sBuffer.append("<td>" + "在线" + "</td>"); // 状态
		}
		sBuffer.append("<td>" + dcycRecord.getRECORDTIME() + "</td>"); // 记录时间 3
		sBuffer.append("<td>" + "A" + "</td>"); // gun 4
		sBuffer.append("<td>" + dcycRecord.getCPSTATE() + "</td>"); // a_state5
		sBuffer.append("<td>" + dcycRecord.getSOC() + "%" + "</td>"); // e
		sBuffer.append("<td>" + dcycRecord.getChargeQuantity() + "</td>"); // e
		sBuffer.append("<td>" + dcycRecord.getChargeMoney() + "</td>"); // f 7
		sBuffer.append("<td>" + dcycRecord.getChargeTimeSpan() + "</td>"); // m
		sBuffer.append("<td>" + dcycRecord.getChargePower() + "</td>"); // p
		sBuffer.append("<td>" + dcycRecord.getChargeVOut() + "0" + "</td>"); // ua1
		sBuffer.append("<td>" + dcycRecord.getChargeAOut() + "0" + "</td>"); // ub1
		sBuffer.append("<td>" + dcycRecord.getBatteryPackMaxtemp() + "</td>");
		sBuffer.append("<td>" + dcycRecord.getBatteryPackMintemp() + "</td>"); // ia1
		sBuffer.append("<td>" + dcycRecord.getBatteryMaxtemp() + "</td>"); // ia2
		sBuffer.append("<td>" + dcycRecord.getBatteryMintemp() + "</td>"); // ia3
		sBuffer.append("<td>" + dcycRecord.getChargerTemp() + "</td>"); // ia3
		sBuffer.append("<td>" + dcycRecord.getChargeDirectV() + "</td>"); // ia3
		sBuffer.append("</tr>");
		return sBuffer.toString();
	}

	// public static String getDoubleGunYCData(CPYCRunRecord_104 ycRecord, int
	// row) {
	// StringBuffer sBuffer = new StringBuffer();
	// if (row % 2 == 0) {
	// sBuffer.append("<tr class = \"odd\">");
	// } else {
	// sBuffer.append("<tr>");
	// }
	// sBuffer.append("<td rowspan = 2>" + ycRecord.getCPID() + "</td>"); //
	// cpid1
	// if ((System.currentTimeMillis() - ycRecord.getMILLSECONDS()) > 60000) {
	// // 如果当前时间与遥测时间超过1分钟则认为离线
	// sBuffer.append("<td rowspan = 2>" + "离线" + "</td>"); // 状态 //2
	// } else {
	// sBuffer.append("<td rowspan = 2>" + "在线" + "</td>"); // 状态
	// }
	// sBuffer.append("<td rowspan = 2>" + ycRecord.getRECORDTIME() + "</td>");
	// // 记录时间3
	// sBuffer.append("<td>" + "A" + "</td>"); // gun4
	// sBuffer.append("<td>"
	// + DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
	// ycRecord.getCPID()).getPROTOCOLID()
	// + "_" + ycRecord.getGUNA_STATE()) + "</td>"); // a_state5
	// sBuffer.append("<td>" + ycRecord.getGUNA_E() + "</td>"); // e 6
	// sBuffer.append("<td>" + ycRecord.getGUNA_F() + "</td>"); // f 7
	// sBuffer.append("<td>" + ycRecord.getGUNA_M() + "</td>"); // m 8
	// sBuffer.append("<td>" + ycRecord.getGUNA_P() / 1000f + "</td>"); // p 9
	// sBuffer.append("<td>" + ycRecord.getUA1() + "0" + "</td>"); // ua1 10
	// sBuffer.append("<td>" + ycRecord.getUB1() + "0" + "</td>"); // ub1 11
	// sBuffer.append("<td>" + ycRecord.getUC1() + "0" + "</td>"); // uc1 12
	// sBuffer.append("<td>" + ycRecord.getIA1() + "</td>"); // ia1 13
	// sBuffer.append("<td>" + ycRecord.getIB1() + "</td>"); // ia2 14
	// sBuffer.append("<td>" + ycRecord.getIC1() + "</td>"); // ia3 15
	// sBuffer.append("</tr>");
	// if (row % 2 == 0) {
	// sBuffer.append("<tr class = \"odd\">");
	// } else {
	// sBuffer.append("<tr>");
	// }
	// sBuffer.append("<td>" + "B" + "</td>"); // gun 4
	// sBuffer.append("<td>"
	// + DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
	// ycRecord.getCPID()).getPROTOCOLID()
	// + "_" + ycRecord.getGUNB_STATE()) + "</td>"); // a_state5
	// sBuffer.append("<td>" + ycRecord.getGUNB_E() + "</td>"); // e 6
	// sBuffer.append("<td>" + ycRecord.getGUNB_F() + "</td>"); // f 7
	// sBuffer.append("<td>" + ycRecord.getGUNB_M() + "</td>"); // m 8
	// sBuffer.append("<td>" + ycRecord.getGUNB_P() / 1000f + "</td>"); // p 9
	// sBuffer.append("<td>" + ycRecord.getUA2() + "0" + "</td>"); // ua1 10
	// sBuffer.append("<td>" + ycRecord.getUB2() + "0" + "</td>"); // ub1 11
	// sBuffer.append("<td>" + ycRecord.getUC2() + "0" + "</td>"); // uc1 12
	// sBuffer.append("<td>" + ycRecord.getIA2() + "</td>"); // ia1 13
	// sBuffer.append("<td>" + ycRecord.getIB2() + "</td>"); // ia2 14
	// sBuffer.append("<td>" + ycRecord.getIC2() + "</td>"); // ia3 15
	// sBuffer.append("</tr>");
	// return sBuffer.toString();
	// }

	// 传一个遥信的状态字符串 返回一个与直流对应的状态id
	public static int getTypeIdByString(String type) {
		// // 直流定义 "0000待机+0001工作+0010充满+0011告警+0100故障"
		// 反过来定义 0000待机+1000工作+0100充满+1100告警+0010故障
		// 交流定义 0 空闲 3充电 4 完成 5故障 6告警
		int zz = 0;
		if ("0000".equals(type)) {
			zz = 0;
		} else if ("1000".equals(type)) {
			zz = 3;
		} else if ("0100".equals(type)) {
			zz = 4;
		} else if ("1100".equals(type)) {
			zz = 6;
		} else if ("0010".equals(type)) {
			zz = 5;
		}
		return zz;
	}
}

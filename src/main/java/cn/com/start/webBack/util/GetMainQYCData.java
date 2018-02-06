package cn.com.start.webBack.util;

import cn.com.start.DPF.aio.DataRelay;
import cn.com.start.DPF.entity.CPYCRunRecord_104;

public class GetMainQYCData {

	public static String row1 = "<tr class = \"odd\">";
	public static String row2 = "<td rowspan =2 >1</td>";
	public static String row3 = "<td>a</td>";
	public static String row4 = "</tr>";

	public static void getEmptyYCRecord(String cpId) {
		CPYCRunRecord_104 ycRecord = new CPYCRunRecord_104();
		ycRecord.setCPID(cpId);
		ycRecord.setRECORDTIME("--");
		ycRecord.setUA1(0f);
		ycRecord.setUB1(0f);
		ycRecord.setUC1(0f);
		ycRecord.setUA2(0f);
		ycRecord.setUB2(0f);
		ycRecord.setUC2(0f);
		ycRecord.setIA1(0f);
		ycRecord.setIA2(0f);
		ycRecord.setIB1(0f);
		ycRecord.setIB2(0f);
		ycRecord.setIC1(0f);
		ycRecord.setIC2(0f);
		ycRecord.setGUNA_E(0f);
		ycRecord.setGUNB_E(0f);
		ycRecord.setGUNA_F(0f);
		ycRecord.setGUNB_F(0f);
		ycRecord.setGUNA_M(0f);
		ycRecord.setGUNB_M(0f);
		ycRecord.setGUNA_P(0f);
		ycRecord.setGUNB_P(0f);
		ycRecord.setGUNA_STATE(0);
		ycRecord.setGUNB_STATE(0);
		ycRecord.setMILLSECONDS(0);
		DataRelay.sychroYCMap.put(cpId, ycRecord);
	}

	// 拿到cpid先打到遥测数据对象 然后拼接字符串
	public static String getQYCRealData(String cpId, int row) {
		CPYCRunRecord_104 ycRecord = DataRelay.sychroYCMap.get(cpId);
		String ycData;
		if (DataRelay.cpMap.get(cpId).getINTERFACECOUNT() == 0) {
			// 单枪
			ycData = getSingleGunYCData(ycRecord, row);
		} else {
			// 双枪
			ycData = getDoubleGunYCData(ycRecord, row);
		}
		return ycData;
	}

	public static String getYCThead() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("<thead> <tr>").append("<th>充电桩ID</th>")
				.append("<th>桩状态</th>").append("<th>状态时间</th>")
				.append("<th>枪</th>").append("<th>枪状态</th>")
				.append("<th>电量(kWh)</th>").append("<th>金额(元)</th>")
				.append("<th>已充时间(分)</th>").append("<th>功率(kw)</th>")
				.append("<th>A相电压(V)</th>").append("<th>B相电压</th>")
				.append("<th>C相电压</th>").append("<th>A相电流(A)</th>")
				.append("<th>B相电流</th>").append("<th>C相电流</th>")
				.append("</tr></thead>");
		return sBuffer.toString();
	}

	public static String getSingleGunYCData(CPYCRunRecord_104 ycRecord, int row) {
		StringBuffer sBuffer = new StringBuffer();
		if (row % 2 == 0) {
			sBuffer.append("<tr class = \"odd\">");
		} else {
			sBuffer.append("<tr>");
		}
		sBuffer.append("<td>" + ycRecord.getCPID() + "</td>"); // cpid 1
		if ((System.currentTimeMillis() - ycRecord.getMILLSECONDS()) > 60000) {
			// 如果当前时间与遥测时间超过1分钟则认为离线
			sBuffer.append("<td>" + "离线" + "</td>"); // 状态 //2
		} else {
			sBuffer.append("<td>" + "在线" + "</td>"); // 状态
		}
		sBuffer.append("<td>" + ycRecord.getRECORDTIME() + "</td>"); // 记录时间 3
		sBuffer.append("<td>" + "A" + "</td>"); // gun 4
		sBuffer.append("<td>"
				+ DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
						ycRecord.getCPID()).getPROTOCOLID()
						+ "_" + ycRecord.getGUNA_STATE()) + "</td>"); // a_state5
		sBuffer.append("<td>" + ycRecord.getGUNA_E() + "</td>"); // e 6
		sBuffer.append("<td>" + ycRecord.getGUNA_F() + "</td>"); // f 7
		sBuffer.append("<td>" + ycRecord.getGUNA_M() + "</td>"); // m 8
		sBuffer.append("<td>" + ycRecord.getGUNA_P() / 1000f + "</td>"); // p 9
		sBuffer.append("<td>" + ycRecord.getUA1() + "0" + "</td>"); // ua1 10
		sBuffer.append("<td>" + ycRecord.getUB1() + "0" + "</td>"); // ub1 11
		sBuffer.append("<td>" + ycRecord.getUC1() + "0" + "</td>"); // uc1 12
		sBuffer.append("<td>" + ycRecord.getIA1() + "</td>"); // ia1 13
		sBuffer.append("<td>" + ycRecord.getIB1() + "</td>"); // ia2 14
		sBuffer.append("<td>" + ycRecord.getIC1() + "</td>"); // ia3 15
		sBuffer.append("</tr>");
		return sBuffer.toString();
	}

	public static String getDoubleGunYCData(CPYCRunRecord_104 ycRecord, int row) {
		StringBuffer sBuffer = new StringBuffer();
		if (row % 2 == 0) {
			sBuffer.append("<tr class = \"odd\">");
		} else {
			sBuffer.append("<tr>");
		}
		sBuffer.append("<td rowspan = 2>" + ycRecord.getCPID() + "</td>"); // cpid1
		if ((System.currentTimeMillis() - ycRecord.getMILLSECONDS()) > 60000) {
			// 如果当前时间与遥测时间超过1分钟则认为离线
			sBuffer.append("<td rowspan = 2>" + "离线" + "</td>"); // 状态 //2
		} else {
			sBuffer.append("<td rowspan = 2>" + "在线" + "</td>"); // 状态
		}
		sBuffer.append("<td rowspan = 2>" + ycRecord.getRECORDTIME() + "</td>"); // 记录时间3
		sBuffer.append("<td>" + "A" + "</td>"); // gun4
		sBuffer.append("<td>"
				+ DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
						ycRecord.getCPID()).getPROTOCOLID()
						+ "_" + ycRecord.getGUNA_STATE()) + "</td>"); // a_state5
		sBuffer.append("<td>" + ycRecord.getGUNA_E() + "</td>"); // e 6
		sBuffer.append("<td>" + ycRecord.getGUNA_F() + "</td>"); // f 7
		sBuffer.append("<td>" + ycRecord.getGUNA_M() + "</td>"); // m 8
		sBuffer.append("<td>" + ycRecord.getGUNA_P() / 1000f + "</td>"); // p 9
		sBuffer.append("<td>" + ycRecord.getUA1() + "0" + "</td>"); // ua1 10
		sBuffer.append("<td>" + ycRecord.getUB1() + "0" + "</td>"); // ub1 11
		sBuffer.append("<td>" + ycRecord.getUC1() + "0" + "</td>"); // uc1 12
		sBuffer.append("<td>" + ycRecord.getIA1() + "</td>"); // ia1 13
		sBuffer.append("<td>" + ycRecord.getIB1() + "</td>"); // ia2 14
		sBuffer.append("<td>" + ycRecord.getIC1() + "</td>"); // ia3 15
		sBuffer.append("</tr>");
		if (row % 2 == 0) {
			sBuffer.append("<tr class = \"odd\">");
		} else {
			sBuffer.append("<tr>");
		}
		sBuffer.append("<td>" + "B" + "</td>"); // gun 4
		sBuffer.append("<td>"
				+ DataRelay.stateTypeMap.get(DataRelay.cpMap.get(
						ycRecord.getCPID()).getPROTOCOLID()
						+ "_" + ycRecord.getGUNB_STATE()) + "</td>"); // a_state5
		sBuffer.append("<td>" + ycRecord.getGUNB_E() + "</td>"); // e 6
		sBuffer.append("<td>" + ycRecord.getGUNB_F() + "</td>"); // f 7
		sBuffer.append("<td>" + ycRecord.getGUNB_M() + "</td>"); // m 8
		sBuffer.append("<td>" + ycRecord.getGUNB_P() / 1000f + "</td>"); // p 9
		sBuffer.append("<td>" + ycRecord.getUA2() + "0" + "</td>"); // ua1 10
		sBuffer.append("<td>" + ycRecord.getUB2() + "0" + "</td>"); // ub1 11
		sBuffer.append("<td>" + ycRecord.getUC2() + "0" + "</td>"); // uc1 12
		sBuffer.append("<td>" + ycRecord.getIA2() + "</td>"); // ia1 13
		sBuffer.append("<td>" + ycRecord.getIB2() + "</td>"); // ia2 14
		sBuffer.append("<td>" + ycRecord.getIC2() + "</td>"); // ia3 15
		sBuffer.append("</tr>");
		return sBuffer.toString();
	}
}

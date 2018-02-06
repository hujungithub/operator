package cn.com.start.webBack.util;

public class ReTurnMsg {
	private static String action1 = "新增";
	private static String action2 = "修改";
	private static String action3 = "删除";

	private static String batchAction1 = "批量新增";
	private static String batchAction2 = "批量修改";
	private static String batchAction3 = "批量删除";

	private static String result1 = "成功";
	private static String result2 = "失败";

	// 新增xx成功
	public static String InsertSuccess(String zz) {
		return action1 + zz + result1;
	}

	// 新增xx失败
	public static String InsertFault(String zz) {
		return action1 + zz + result2;
	}
}

package cn.com.start.DPF.redis;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import cn.com.start.DPF.entity.ChargeChangeRecord;
import cn.com.start.DPF.entity.ChargeRecord_DPF;
import cn.com.start.DPF.entity.UserDeductMoneyRecord;

public class ObjectToMap {

	public static Map<String, String> getValueMap(Object obj) {

		Map<String, String> map = new HashMap<String, String>();
		// System.out.println(obj.getClass());
		// 获取f对象对应类中的所有属性域
		
		//obj.getClass()反射机制获取类
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			String varName = fields[i].getName();
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object o = fields[i].get(obj);
				if (o != null)
					map.put(varName, o.toString());
				// System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
		return map;
	}

	// map转json对象 json对象转java对象
	public static Object mapToObject(Map<String, String> map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		Object tempobject = JSONObject.toBean(jsonObject,
				ChargeRecord_DPF.class);
		return tempobject;
	}

	public static Object mapToObjectD(Map<String, String> map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		Object tempobject = JSONObject.toBean(jsonObject,
				UserDeductMoneyRecord.class);
		return tempobject;
	}

	public static Object mapToObjectCCR(Map<String, String> map) {
		JSONObject jsonObject = JSONObject.fromObject(map);
		Object tempobject = JSONObject.toBean(jsonObject,
				ChargeChangeRecord.class);
		return tempobject;
	}

	// 输出map
	public static void OutputMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key= " + entry.getKey() + " and value= "
					+ entry.getValue());
		}
	}
}

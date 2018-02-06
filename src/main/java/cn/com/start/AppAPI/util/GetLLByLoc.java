package cn.com.start.AppAPI.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

// 增加充电桩时 通过地址(上海市市辖区杨浦区国际交流中心10号楼201B室)
// 查询经纬度 返回值 类调用

/**
 * 获取经纬度
 * 
 * @author jueyue 返回格式：Map<String,Object> map map.put("status",
 *         reader.nextString());//状态 map.put("result", list);//查询结果
 *         list<map<String,String>> 密钥:f247cdb592eb43ebac6ccd27f796e2d2
 */
public class GetLLByLoc {

	/**
	 * @param addr
	 *            查询的地址
	 * @return
	 * @throws IOException
	 */
	public static String[] getCoordinate(String addr) throws IOException {
		String address = null;
		try {
			address = java.net.URLEncoder.encode(addr, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String url = "http://restapi.amap.com/v3/geocode/geo?key=44171fc4e1a833ad9c07181d146828d7&address="
				+ address;
		URL myURL = null;
		URLConnection httpsConn = null;
		try {
			myURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		InputStreamReader insr = null;
		BufferedReader br = null;
		String Location[] = new String[2];
		try {
			httpsConn = myURL.openConnection();// 不使用代理
			if (httpsConn != null) {
				insr = new InputStreamReader(httpsConn.getInputStream(),
						"UTF-8");
				br = new BufferedReader(insr);
				String data = null;
				while ((data = br.readLine()) != null) {
					System.out.println("zzz" + data);
					JSONObject jsonObj = JSONObject.fromObject(data);
					JSONArray geocodes = jsonObj.getJSONArray("geocodes");
					if (geocodes.size() == 0) {
						// 找不到数据
					} else {
						// 找到数据 解析经纬度
						JSONObject trueAddress = geocodes.getJSONObject(0);
						System.out.println(trueAddress.toString());
						String citycode = trueAddress.getString("citycode");
						System.out.println(citycode);
						String location = trueAddress.getString("location");
						String lngX = location.split(",")[0];
						String latY = location.split(",")[1];
						Location[0] = lngX;
						Location[1] = latY;
						// System.out.println("lngX" + lngX + "---" + "latY"+
						// latY);
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (insr != null) {
				insr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		return Location;
	}

	public static void main(String[] args) throws IOException {
		GetLLByLoc gethehe = new GetLLByLoc();
		String location[] = GetLLByLoc.getCoordinate("上海市");
		System.out.println(location[0]);// 经度
		System.out.println(location[1]);// 纬度
	}
}

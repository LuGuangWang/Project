package wlg.test2;

import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		String s = "{\"dateTime\":111111214,\"productCode\":\"test rest 2\"}";
		MSG m = new MSG();
		String ms = JSONObject.toJSONString(m);
		System.out.println(JSONObject.toJSONString(ms));
	}
}

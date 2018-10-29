package wlg.test;

import com.alibaba.fastjson.JSONObject;

public class NewTest2 {
  
  public static void main(String[] args) {
	 String s = "{\"语文\":\"88\",\"数学\":\"78\",\"计算机\":\"99\"}";
	 JSONObject obj = JSONObject.parseObject(s);
	 obj.containsKey("test");
  }
  
 
}

package wlg.javaapi.map;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

  public static void testMapObject(){
    Map<String,MapData> map = new HashMap<String, MapData>();
    MapData data = new MapData();
    data.setName("LG");
    map.put("key", data);
    System.out.println(map.get("key"));
    data.setName("LG1");
    System.out.println(map.get("key"));
  }
  
  public static void testMapString(){
    Map<String,String> map = new HashMap<String, String>();
    MapData data = new MapData();
    data.setName("LG");
    map.put("key", data.toString());
    System.out.println("String key: "+map.get("key"));
    data.setName("LG1");
    map.put("key", data.toString());
    System.out.println("String key: "+map.get("key"));
  }
  
	public static void main(String[] args) {
	  testMapObject();
	  testMapString();
		// TODO Auto-generated method stub
		Map<String,String> map1 = new HashMap<String, String>();
		Map<String,String> map2 = new HashMap<String, String>();
		map1.put("1", "1");
		map1.put("2", "2");
		
		map2.put("3", "3");
		map2.put("4", "4");
		
		map1.putAll(map2);
		map2.clear();
		System.out.println(map1.toString());
	}

}

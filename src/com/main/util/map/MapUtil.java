package com.main.util.map;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

	public static void main(String[] args) {
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

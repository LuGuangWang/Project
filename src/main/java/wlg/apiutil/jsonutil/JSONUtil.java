package wlg.apiutil.jsonutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {
	private static ObjectMapper objMapper = new ObjectMapper();
	
	public static String toJson(Object o) {
	    try {
	      return objMapper.writeValueAsString(o);
	    } catch (JsonProcessingException e) {
	      throw new RuntimeException(e);
	    }
	}
	
	public static <T> T toObject(String json, TypeReference<T> T) {
		try {
			return objMapper.readValue(json,new TypeReference<T>() { });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		List<Map<String,Object>> fields = new ArrayList<>();
		
		Map<String,Object> param1 = new HashMap<>();
		param1.put("storeId",201);
		param1.put("sex", "男");
		Map<String,Object> param2 = new HashMap<>();
		param2.put("storeId",255);
		param2.put("sex", "女");
		fields.add(param2);
		fields.add(param2);
		String jstr = JSONUtil.toJson(fields);
		
		System.out.println(jstr);
		
		SkuList sku1 = new SkuList();
		sku1.setStoreId("1");
		SkuList sku2 = new SkuList();
		sku2.setStoreId("2");
		List<SkuList> skus = new ArrayList<>();
		skus.add(sku1);
		skus.add(sku2);
		String str = toJson(skus);
		try {
			List<SkuList> skus2 = objMapper.readValue(str,new TypeReference<List<SkuList>>() { });
			System.out.println(skus2.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

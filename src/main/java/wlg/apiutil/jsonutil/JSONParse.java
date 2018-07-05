package wlg.apiutil.jsonutil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONParse {
	public List<Map<String, String>> parseJson(String json){
		Objects.requireNonNull(json);
		//"$ref" 引用会引起死循环
		if(json.contains("$ref")) {
			throw new RuntimeException("not support the circle ref." + json);
		}
		Object obj = JSONObject.parse(json);
		return parseJson(null, obj);
	}
	
	private List<Map<String, String>> parseJson(String key,Object val) {
		Objects.requireNonNull(val);
		final List<Map<String, String>> curRow = new ArrayList<>();
		if(val instanceof JSONObject) {
			//初始化当前行
			curRow.add(new HashMap<>()); 
			((JSONObject)val).forEach((k,v)->{
				if(v instanceof JSONObject || v instanceof JSONArray) {
					List<Map<String, String>> child = parseJson(k,v);
					//进行裂变
					List<Map<String, String>> tmp = cartesian(curRow, child);
					//使用新结果积
					curRow.clear();
					curRow.addAll(tmp);
					//清理mem
					child.clear();
					tmp.clear();
				}else{
					curRow.forEach(row->{
						if(row.containsKey(k)) {
							throw new RuntimeException("not support the same key in different level." + key);
						}
						row.put(k,v.toString());
					});
				}
			});
		}else if(val instanceof JSONArray){
			JSONArray arr = (JSONArray)val;
			if(arr.size()>0) {
				arr.forEach(item->{
					if(item instanceof JSONObject || item instanceof JSONArray) {
						List<Map<String, String>> tmp = parseJson(key,item);
						curRow.addAll(tmp);
						tmp.clear();
					}else {
						Map<String, String> node = new HashMap<>();
						node.put(key, item.toString());
						curRow.add(node);
					}
				});
			}else {
				//处理空数组
				curRow.add(new HashMap<>());
			}
		}
		return curRow;
	}
	/**
	 * 两个集合裂变 笛卡尔积
	 * @param parent
	 * @param child
	 */
	private List<Map<String, String>> cartesian(List<Map<String, String>> parent, List<Map<String, String>> child) {
		int size = child.size() * parent.size();
		List<Map<String, String>> result = new ArrayList<>(size);
		parent.forEach(row->{
			child.forEach(t->{
				Map<String,String> newRow = new HashMap<>(row);
				newRow.putAll(t);
				result.add(newRow);
				//校验是否有重复key
				if(newRow.size() != row.size() + t.size()) {
					throw new RuntimeException("not support the same key in different level. " + t);
				}
			});
		});
		return result;
	}
	
	public static void main(String[] args) {
		String json = "{\"imageTime\":\"2018-07-05 13:05:42\",\"repeats\":[],\"resideTime\":4,\"star\":2,\"sex\":\"女\",\"_jd_extend\":{\"inOrOut\":1,\"groups\":[\"2kxVvnFkmgb\"],\"productKey\":\"KXcFH\",\"deviceName\":\"5EearIkNuebGpKrM\",\"version\":2},\"faceFrame\":\"c108bf85-7e29-4cb1-9d78-a84f93fbca32.jpg\",\"msgid\":\"a84f93fbca32\",\"personIds\":[],\"equno\":\"DJ38a28cd9\",\"age\":33}";
		JSONParse parse = new JSONParse();
		List<Map<String, String>> result = parse.parseJson(json);
		System.out.println(JSONObject.toJSONString(result));
	}
}

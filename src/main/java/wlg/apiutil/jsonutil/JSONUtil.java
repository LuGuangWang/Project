package wlg.apiutil.jsonutil;

import com.fasterxml.jackson.core.JsonProcessingException;
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
}
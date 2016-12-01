package wlg.apiutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
  private static ThreadLocal<ObjectMapper> objMapper = new ThreadLocal<ObjectMapper>() {
    @Override
    protected ObjectMapper initialValue() {
      ObjectMapper newInstance = new ObjectMapper();
      newInstance.setDateFormat(dateFormatGmt.get());
      return newInstance;
    }
  };
  
  private static final ThreadLocal<SimpleDateFormat> dateFormatGmt = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      SimpleDateFormat newInstance = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      newInstance.setTimeZone(TimeZone.getTimeZone("GMT"));
      return newInstance;
    }
  };
  
  public static String toUTC(String date) throws ParseException {
    // Local time zone
    SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MM-dd");
    // Time in GMT
    return dateFormatGmt.get().format(dateFormatLocal.parse(date));
  }
  
  public static String toJson(Object o) {
    try {
      return objMapper.get().writeValueAsString(o);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}

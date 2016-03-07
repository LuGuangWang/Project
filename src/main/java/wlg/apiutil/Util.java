package wlg.apiutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Util {
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
}

package wlg.javaapi.regular;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class RegularExpressionUtil {

  Logger log = LoggerFactory.getLogger(getClass());
 
  public static boolean isContainDigit(String str){
    if(StringUtils.isEmpty(str))
      return false;
    return !str.matches("[^0-9]{1,}");
  }
  
  public static void main(String[] args) {
    String str = "中国";
    System.out.println(isContainDigit(str));
  }
}

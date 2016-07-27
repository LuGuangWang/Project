package wlg.javaapi.regular;

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
  
  public static boolean isDigit(String str){
    if(StringUtils.isEmpty(str))
      return false;
    return str.matches("^\\d+\\.?[0-9|A-Z|a-z]*");
  }
  
  public static void main(String[] args) {
    String str = "中国";
    System.out.println(isContainDigit(str));
    
    String str1="1.6065361519348E13";
    System.out.println(isDigit(str1));
  }
}

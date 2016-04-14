package wlg.javaapi.methodhandles;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodHandlesUtil {

  private static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  
  static void testLookup(){
    String str = MethodHandles.lookup().lookupClass().getName();
    log.info(str);
  }
  
  public static void main(String[] args) {
    testLookup();
  }

}

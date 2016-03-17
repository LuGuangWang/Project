package wlg.javaapi.enums;

public class EnumStrategyTest {

  static void testEnum(){
    EnumType<Object> instance = EnumStrategy.ENUMINSTANCE1.get();
    instance.business();
    instance = EnumStrategy.ENUMINSTANCE2.get();
    instance.business();
  }
  
  public static void main(String[] args) {
    testEnum();
  }

}

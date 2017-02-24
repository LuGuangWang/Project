package wlg.test;

public class ClassFornameTest {
  
  public ClassFornameTest(){
    System.out.println("Test 构造函数执行");
  }
  
  static{
    System.out.println("static 静态语句执行");
  }
  
  public static void main(String[] args) throws Exception {
    Class.forName("wlg.test.ClassFornameTest");
    Class.forName("wlg.test.ClassFornameTest");
    ClassFornameTest.class.newInstance();
  }
}

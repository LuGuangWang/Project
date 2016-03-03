package wlg.test;


public class AbstractTest2 extends AbstractTest {

  public AbstractTest2() {
    super();
    System.out.println("sub class constructor");
  }
  
  public void test(){
    super.test();
    System.out.println("sub class test function.");
  }

  public static void main(String[] args) {
    AbstractTest2 t = new AbstractTest2();
    t.test();
  }

}

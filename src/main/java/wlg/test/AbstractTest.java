package wlg.test;

abstract public class AbstractTest {
  AbstractTest(){
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.out.println("parent class constructor");
  }
  
  public void test(){
    System.out.println("parent class test function.");
  }
}

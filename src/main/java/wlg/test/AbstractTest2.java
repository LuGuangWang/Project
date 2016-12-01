package wlg.test;


public class AbstractTest2 extends AbstractTest {

  private String[] states = new String[] {"AK", "AL"};  
  public String[] getStates() { return states; }  
  
  public AbstractTest2() {
    super();
    new AcessTest1(this);
    System.out.println("sub class constructor");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
  }
  
  public void test(){
    super.test();
    System.out.println("sub class test function.");
  }

  public static void main(String[] args) {
    AbstractTest2 t = new AbstractTest2();
    if(t instanceof AbstractTest){
      System.out.println("sss "+t);
    }
    t.getStates();
    t.test();
  }

}

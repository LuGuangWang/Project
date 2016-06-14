package wlg.javaapi.proxy;

public class ProxyImpl implements ProxyInterface {

  @Override
  public void methodOne() {
    System.out.println("ProxyImpl calling method one.");
  }

  @Override
  public void methodTwo(String param) {
    System.out.println("ProxyImpl calling method two.");
  }

}

package wlg.javaapi.proxy;

public class ProxyTest {
  
  public static void main(String[] args){
    ProxyImpl realProxy = new ProxyImpl();
    ProxyHandler handler = new ProxyHandler(realProxy);
    handler.getProxy().methodOne();
    handler.getProxy().methodTwo("Hello");
  }
}

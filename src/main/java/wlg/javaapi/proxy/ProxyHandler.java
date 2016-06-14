package wlg.javaapi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

  private static final Class<?>[] IFACES = new Class<?>[] { ProxyInterface.class };
  
  private ProxyInterface proxy;
  private ProxyInterface realProxy;
  
  public ProxyHandler(ProxyInterface realProxy){
    this.realProxy = realProxy;
    this.proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), IFACES, this);
  }
  
  public ProxyInterface getProxy() {
    return proxy;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    System.out.println(methodName);
    if(args!=null){
      for(Object obj : args)
      System.out.println(obj);
    }
    return method.invoke(realProxy, args);
  }

}

package wlg.javaapi.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLIBObject implements MethodInterceptor{  
  
  private Enhancer enhancer = new Enhancer();  
    
    
  public Object getProxy(Class<?> clazz){  
      //生成指定类对象的子类,也就是重写类中的业务函数，在重写中加入intercept()函数而已。  
      enhancer.setSuperclass(clazz);  
      //这里是回调函数，enhancer中肯定有个MethodInterceptor属性。  
      //回调函数是在setSuperclass中的那些重写的方法中调用---猜想  
      enhancer.setCallback(this);  
      //创建这个子类对象  
      return enhancer.create();  
  }  
  @Override
  public Object intercept(Object obj, Method method, Object[] aobj,
      MethodProxy methodproxy) throws Throwable {
    System.out.println(method.getName()+"执行之前做一些准备工作");  
    //一不小心写成下面被注释一行代码了。 StackOverflowError  
    //Object result = method.invoke(obj, args); 想不通  
    Object result = methodproxy.invokeSuper(obj,aobj);  
    System.out.println(method.getName()+"执行之后做一些准备的工作");  
    return result;  
  }  
    
}  

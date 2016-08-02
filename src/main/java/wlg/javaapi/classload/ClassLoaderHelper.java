package wlg.javaapi.classload;

import java.lang.reflect.Method;


public class ClassLoaderHelper {

  public void testClassLoader() throws Exception{
    ClassLoader classLoader = getClass().getClassLoader();  
    Thread.currentThread().setContextClassLoader(classLoader);  
    Class<?> clazz=classLoader.loadClass("wlg.javaapi.classload.ClassLodee");//使用loadClass方法加载class,这个class是在urls参数指定的classpath下边。  
    Method taskMethod = clazz.getMethod("print", String.class);//然后我们就可以用反射做些事情了  
    taskMethod.invoke(clazz.newInstance(),"hello world");
  }
  
  public static void main(String[] args) throws Exception {
    ClassLoaderHelper instance = new ClassLoaderHelper();
    instance.testClassLoader();
  }
}

package wlg.javaapi.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {
  
  public <T> T reflectToT(Class<T> clazz) throws Exception{
    List<T> datas = new ArrayList<>();
    T instance = clazz.newInstance();
    Field field = clazz.getField("testField");//取到public
    
    Method oneM = clazz.getMethod("setCode",String.class);//取到public
    System.out.println("one method:"+oneM.getName());
    oneM.invoke(instance, "s");
    field.set(instance, "s1");
    datas.add(instance);
    return instance;
  }
  
  public static void main(String[] args) throws Exception{
    ReflectUtil instance = new ReflectUtil();
    DataBean data= instance.reflectToT(DataBean.class);
    System.out.println(data.getCode()+ " " + data.testField);
  }
}

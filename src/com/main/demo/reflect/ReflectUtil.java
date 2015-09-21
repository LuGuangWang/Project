package com.main.demo.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {
  
  public <T> T reflectToT(Class<T> clazz) throws Exception{
    List<T> datas = new ArrayList<>();
    T instance = clazz.newInstance();
    Method oneM = clazz.getMethod("setCode",String.class);
    System.out.println("one method:"+oneM.getName());
    oneM.invoke(instance, "s");
    datas.add(instance);
    return instance;
  }
  
  public static void main(String[] args) throws Exception{
    ReflectUtil instance = new ReflectUtil();
    DataBean data= instance.reflectToT(DataBean.class);
    System.out.println(data.getCode());
  }
}

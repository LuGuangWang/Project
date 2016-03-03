package wlg.javaapi.demo.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectFilter {

  static <T> List<T> objectFilter(List<T> datas,Map<String,Object> filter,Class<T> instance){
    List<T> result = new ArrayList<T>(datas.size());
    for(T obj:datas){
      Iterator<String> methodNames = filter.keySet().iterator();
      String methodName = null;
      boolean flag = true;
      while(methodNames.hasNext()){
        methodName = methodNames.next();
        try {
          Object objValue = instance.getMethod(methodName).invoke(obj);
          if(objValue==null || !objValue.equals(filter.get(methodName))){
            flag = false;
            break;
          }
        } catch (NoSuchMethodException e) {
          System.out.println("异常" + e);
        } catch (Exception e) {
          System.out.println("异常" + e);
        }
      }
      if(flag){
        result.add(obj);
      }
    }
    return result;
  }
  
  public static void main(String[] args) {
    Bean b = new Bean();
    b.setCode("LG1");
    b.setName("test 1");
    b.setNumber(1);
    Bean b2 = new Bean();
    b2.setCode("LG1");
    b2.setName("test 1");
    b2.setNumber(2);
    
    List<Bean> datas = new ArrayList<Bean>(2);
    datas.add(b2);
    datas.add(b);
    
    
    Map<String,Object> filter  = new HashMap<String, Object>();
    filter.put("getCode", "LG1");
    filter.put("getName", "test 1");
    filter.put("getNumber", 2);
    List<Bean> result = objectFilter(datas, filter, Bean.class);
    System.out.println(result);
  }

}

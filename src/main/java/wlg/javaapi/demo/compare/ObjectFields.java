package wlg.javaapi.demo.compare;

import java.lang.reflect.Field;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

public class ObjectFields implements Comparator<ObjectFields> {
  private String name;
  private String sex;
  private String age;
  public ObjectFields(){
    
  }
  public ObjectFields(String name){
    this.name=name;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String comparate(ObjectFields o) {
    StringBuffer buf = new StringBuffer();
    Field[] fields = o.getClass().getDeclaredFields();
    try {
      for(Field f:fields){
        if(!Objects.equal(f.get(this), f.get(o))){
          append(buf, f.get(this), f.get(o));
        }
      }  
      if(!Strings.isNullOrEmpty(buf.toString()))
        return buf.toString();
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
}

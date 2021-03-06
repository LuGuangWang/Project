package wlg.javaapi.demo.equal;

public class Property {
  private String code;
  private String name;
  
  /**
   * 重写 equals方法时，hashCode的值要弄成必填
   */
  public Property(String name) {
      this.name = name==null?"":name;
  }
  
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public int hashCode(){
    return this.name.hashCode();
  }
  
  public boolean equals(Object o){
    return this.name.equals(((Property)o).getName());
  }
}

package wlg.javaapi.enums;

public enum EnumStrategy {
  ENUMINSTANCE1(new EnumInstance1()),
  
  ENUMINSTANCE2(new EnumInstance2());;
  
  private final EnumType<Object> instance;
  
  private EnumStrategy(EnumType<Object> instance){
    this.instance = instance;
  }
  
  public EnumType<Object> get(){
    return instance;
  }
}

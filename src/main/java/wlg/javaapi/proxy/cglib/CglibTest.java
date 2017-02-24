package wlg.javaapi.proxy.cglib;


public class CglibTest {

  public static void main(String[] args) throws Exception {
    CGLIBObject ct = new CGLIBObject();  
    ClassHasNoInterface chni = (ClassHasNoInterface) ct.getProxy(ClassHasNoInterface.class);  
    
    chni.method();  
    
    System.out.println("------------------分割线-----------");
    
    chni.function();  
    
  }
  
}

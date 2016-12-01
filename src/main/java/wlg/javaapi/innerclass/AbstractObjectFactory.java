package wlg.javaapi.innerclass;

public abstract class AbstractObjectFactory {
  public abstract String creatMsg();
  
  public void printMsg(InnerInterface inner){
    inner.printMsg();
  }
  
  public void printMsg(){
    printMsg(new InnerInterface(){
      @Override
      public void printMsg() {
        String s = creatMsg();
        System.out.println(s);
      }
    });
  }
  
}

package wlg.javaapi.innerclass;

public class ObjectFactory extends AbstractObjectFactory {

  @Override
  public String creatMsg() {
    return "create one msg.";
  }
  
  public static void main(String[] args) {
    ObjectFactory a = new ObjectFactory();
    a.printMsg();
  }
}

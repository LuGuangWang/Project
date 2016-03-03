package wlg.javaapi.demo.transfer;

public class SubClassSuperClass {

  public static void main(String[] args) {
    SubClass sub = new SubClass();
    SuperClass su = new SuperClass();
//    su = sub;
    sub = (SubClass) su;//父类转换为子类 报错
    System.out.println(sub);
  }

}

package wlg.javaapi.initorder;

class Mug {
  Mug(int marker) {
    System.out.println("Mug(" + marker + ")");
  }

  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}


public class NonStaticInitOrder {
  Mug c1;
  Mug c2;
  {
    c1 = new Mug(1);
    c2 = new Mug(2);
    System.out.println("c1 & c2 initialized");
  }

  NonStaticInitOrder() {
    System.out.println("Mugs()");
  }

  public static void main(String[] args) {
    System.out.println("Inside main()");
    new NonStaticInitOrder();
  }
}

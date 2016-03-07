package wlg.javaapi.initorder;
 // Specifying initial values in a
// class definition.
/**
 * static 初始化只有在必要的时候才会进行。如果不创建一个Table 对象，而且永远都不引用Table.b1 或
 * Table.b2，那么static Bowl b1 和b2 永远都不会创建。然而，只有在创建了第一个Table 对象之后（或者
 * 发生了第一次static 访问），它们才会创建。在那以后，static 对象不会重新初始化。
 * 初始化的顺序是首先static（如果它们尚未由前一次对象创建过程初始化），接着是非static 对象
 */
class Bowl {
  Bowl(int marker) {
    System.out.println("Bowl(" + marker + ")");
  }

  void f(int marker) {
    System.out.println("f(" + marker + ")");
  }
}


class Table {
  static Bowl b1 = new Bowl(1);

  Table() {
    System.out.println("Table()");
    b2.f(1);
  }

  void f2(int marker) {
    System.out.println("f2(" + marker + ")");
  }

  static Bowl b2 = new Bowl(2);
}


class Cupboard {
  Bowl b3 = new Bowl(3);
  static Bowl b4 = new Bowl(4);

  Cupboard() {
    System.out.println("Cupboard()");
    b4.f(2);
  }

  void f3(int marker) {
    System.out.println("f3(" + marker + ")");
  }

  static Bowl b5 = new Bowl(5);
}


public class StaticInitOrder {
  public static void main(String[] args) {
    System.out.println("Creating new Cupboard() in main");
    new Cupboard();
    System.out.println("Creating new Table() in main");
    new Table();
    t2.f2(1);
    t3.f3(1);
  }

  static Table t2 = new Table();
  static Cupboard t3 = new Cupboard();
}

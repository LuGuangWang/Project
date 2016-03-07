package wlg.javaapi.initorder;

// Demonstrates initialization order.
// When the constructor is called, to create a
// Tag object, you'll see a message:
class Tag {
  protected int marker;
  
  Tag(int marker) {
    this.marker = marker;
    System.out.println("Tag(" + marker + ")");
  }
}


class Card {
  Tag t1 = new Tag(1); // Before constructor

  Card() {
    // Indicate we're in the constructor:
    System.out.println("Card()");
    t3 = new Tag(33); // Re-initialize t3
  }

  Tag t2 = new Tag(2); // After constructor

  void f() {
    System.out.println("f()" + t3.marker);
  }

  Tag t3 = new Tag(3); // At end
}


public class InitOrder {
  public static void main(String[] args) {
    Card t = new Card();
    t.f(); // Shows that construction is done
  }
} 

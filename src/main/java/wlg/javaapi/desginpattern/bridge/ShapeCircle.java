package wlg.javaapi.desginpattern.bridge;

public class ShapeCircle extends AbstractShape{

  @Override
  void run() {
    String colr = color.run();
    System.out.println("this is a " + colr + " circle.");
  }

}

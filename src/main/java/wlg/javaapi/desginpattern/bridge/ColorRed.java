package wlg.javaapi.desginpattern.bridge;

public class ColorRed extends AbstractColor {

  public ColorRed(String color){
    this.color = color;
  }
  
  @Override
  String run() {
    return color;
  }
}

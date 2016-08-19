package wlg.javaapi.desginpattern.bridge;

public class ColorBule extends AbstractColor{

  public ColorBule(String color){
    this.color = color;
  }
  
  @Override
  String run() {
    return color;
  }

}

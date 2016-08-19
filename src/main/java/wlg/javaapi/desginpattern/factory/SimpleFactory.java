package wlg.javaapi.desginpattern.factory;

/**
 * 简单工厂模式
 * 
 * 考虑一个简单的软件应用场景，一个软件系统可以提供多个外观不同的按钮（如圆形按钮、矩形按钮、菱形按钮等），
 * 这些按钮都源自同一个基类，不过在继承基类后不同的子类修改了部分属性从而使得它们可以呈现不同的外观
 * ，如果我们希望在使用这些按钮时，不需要知道这些具体按钮类的名字，只需要知道表示该按钮类的一个参数，并提供一个调用方便的方法
 * ，把该参数传入方法即可返回一个相应的按钮对象，此时，就可以使用简单工厂模式。
 * 
 * 在以下情况下可以使用简单工厂模式：
 * 
 * 工厂类负责创建的对象比较少：由于创建的对象较少，不会造成工厂方法中的业务逻辑太过复杂。
 * 客户端只知道传入工厂类的参数，对于如何创建对象不关心：客户端既不需要关心创建细节，
 */
public class SimpleFactory {
  
  public static Shape getShape(int edge){
    Shape shape = null;
    if(edge==3){//如果是三边
      shape = new Trigon();//三角形
    }else if(edge==4){
      shape = new Square();//四边形
    }
    return shape;
  }

  public static void main(String[] args) {

  }

}

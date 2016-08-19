package wlg.javaapi.desginpattern.factory;

/**
 * 工厂方法模式
 * 
 * 现在对该系统进行修改，不再设计一个按钮工厂类来统一负责所有产品的创建，而是将具体按钮的创建过程交给专门的工厂子类去完成，我们先定义一个抽象的按钮工厂类，
 * 再定义具体的工厂类来生成圆形按钮、矩形按钮、菱形按钮等，它们实现在抽象按钮工厂类中定义的方法。这种抽象化的结果使这种结构可以在不修改具体工厂类的情况下 引进新的产品，如果出现新的按钮类型，
 * 只需要为这种新类型的按钮创建一个具体的工厂类就可以获得该新按钮的实例，这一特点无疑使得工厂方法模式具有超越简单工 厂模式的优越性，更加符合“开闭原则”。
 * 
 * 在以下情况下可以使用工厂方法模式：
 * 
 * 一个类不知道它所需要的对象的类：在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可，具体的产品对象由具体工厂类创建；
 * 客户端需要知道创建具体产品的工厂类。
 * 一个类通过其子类来指定创建哪个对象：在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，
 * 利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。 将创建对象的任务委托给多个工厂子类中的某一个，
 * 客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类的类名存储在配置文件或数据库中。
 */
public class FactoryMethod extends Factory{
  
  public static Trigon getTrigonInstance(){//子工厂负责生产具体的实体
    return new Trigon();
  }
  

  public static void main(String[] args) {

  }

}

package wlg.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wlg.spring.impl.HelloChinaImpl;
import wlg.spring.impl.HelloWorld;

public class AOPTest {
  
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");  
    HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");  
    helloWorld.sayHelloWorld();
    System.out.println("--------分割线-------------");
    HelloChinaImpl helloChina = (HelloChinaImpl) ctx.getBean("helloChina");  
    helloChina.sayHelloWorld();
  }
  
}

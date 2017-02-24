package wlg.javaapi.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyTest {
  
  public static void main(String[] args) throws Exception{
    ProxyImpl realProxy = new ProxyImpl();
    ProxyHandler handler = new ProxyHandler(realProxy);
    handler.getProxy().methodOne();
    handler.getProxy().methodTwo("Hello");
    
    
    parseProxyFile();
  }
  /**
   * 生成代理类文件
   */
  private static void parseProxyFile() throws FileNotFoundException, IOException {
    byte[] classFile = ProxyGenerator.generateProxyClass("TestProxy", new Class[]{ProxyInterface.class});
    File file = new File("D:/TestProxy.class");
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(classFile);
    fos.flush();
    fos.close();
  }
}

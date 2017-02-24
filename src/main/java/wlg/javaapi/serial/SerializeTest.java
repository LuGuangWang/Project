package wlg.javaapi.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {
  
  public static void main(String[] args) throws Exception {
    SerializeObj obj = new SerializeObj();
    obj.setName("测试序列化");
    
    String path = "D:/test.class";
    
    ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream(new File(path)));
    fos.writeObject(obj);
    fos.flush();
    fos.close();
    
    ObjectInputStream fin = new ObjectInputStream(new FileInputStream(new File(path)));
    SerializeObj obj1 = (SerializeObj)fin.readObject();
    System.out.println(obj1.equals(obj));
    
    fin.close();
  }
}

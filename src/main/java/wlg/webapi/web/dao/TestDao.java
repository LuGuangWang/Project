package wlg.webapi.web.dao;

import org.springframework.stereotype.Service;

@Service
public class TestDao {
  int count = 1;
  
  public TestDao(){
    count++;
    System.out.println("---------------"+this);
  }
  
  public void printCount(){
    System.out.println("-------------count-------"+count);
  }
}

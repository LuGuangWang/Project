package main.web.controller;

import main.web.dao.TestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired
  TestDao dao;//这是单例的
  
  @RequestMapping("/test_class")
  public void testClass(){
    dao.printCount();
  }
}

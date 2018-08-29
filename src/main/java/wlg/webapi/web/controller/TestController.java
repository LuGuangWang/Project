package wlg.webapi.web.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import wlg.webapi.web.bean.Params;
import wlg.webapi.web.dao.TestDao;


@RestController
public class TestController {
  @Autowired
  TestDao dao;//这是单例的
  
  @RequestMapping("/test_class")
  public void testClass(@RequestParam(name="img1") MultipartFile file1,
		  @RequestParam(name="img2") MultipartFile file2,
		  Params params){
	System.out.println(file1.getName());
	System.out.println(file2.getName());
	System.out.println(params);
    dao.printCount();
  }
  
  @RequestMapping("/test_img")
  public String testClass(Params params,MultipartFile key){
	System.out.println(key.getName());
	try {
		key.transferTo(new File("/work/test.jpg"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	Iterator<String> names = request.getFileNames();  
//	while(names.hasNext()) {
//		System.out.println(names.next());
//	}
	System.out.println(params);
    dao.printCount();
    return "test";
  }
}

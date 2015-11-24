package main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

  @RequestMapping("/greeting")
  public String greeting(@RequestParam(required=false, defaultValue="World") String name, Model model) {
      model.addAttribute("name", name);
      return "greeting";
  }
  
  @RequestMapping("/upload_file")
  public String uploadFile(Model model){
    return "upload_file";
  }
  
  @RequestMapping(value="/compare/class",method=RequestMethod.GET)
  public String showClassResult(){
    return "compare/compare_class";
  }
}

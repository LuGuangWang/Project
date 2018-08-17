package wlg.webapi.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
	
	@GetMapping("/test")
	public @ResponseBody String test(String m) {
		String msg = "test" + m;
		System.out.println(msg);
		return msg;
	}
	
	@PostMapping("/test2")
	public @ResponseBody String test2(String m) {
		String msg = "test" + m;
		System.out.println(msg);
		return msg;
	}
}

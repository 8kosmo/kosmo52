package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo/*")
public class DemoController {
	@GetMapping("test")
	public String test() {
		
		return "demo/test";
	}
}

package com.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/*")
public class AuthenticController {
	Logger logger = LoggerFactory.getLogger(AuthenticController.class);
	@GetMapping("admin")
	public String admin() {
		logger.info("admin호출");
		return "redirect:adminManager.jsp";
	}
}

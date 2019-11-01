package com.example.news;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news/*")
public class NewsController {
	Logger logger = LogManager.getLogger(NewsController.class);
	@GetMapping("newsList")
	public void newsList() {
		logger.info("newsList 호출 성공");
	}
}

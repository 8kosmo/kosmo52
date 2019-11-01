package com.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);

	public List<Map<String, Object>> testList() {
		logger.info("testList 호출 성공");
		return null;
	}
	
}

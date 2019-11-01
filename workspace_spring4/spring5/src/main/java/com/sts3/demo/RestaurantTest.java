package com.sts3.demo;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;//junit
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RestaurantTest {
	Logger logger = Logger.getLogger(RestaurantTest.class);
	@Autowired
	public Restaurant restaurant = null;
	@Test
	public void testExists() {
		assertNotNull("testExists호출 성공");
		logger.info(restaurant);
		logger.info("------------------------");
		logger.info(restaurant.chef);
	}
}

package com.sts3.sample;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * @ContextConfiguration은 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지를 명시함.
 * @Runwith는 테스트시 필요한 클래스를 지정함.
 * @Test는 junit에서 해당 메소드가 jUnit상에서 단위 테스트의 대상인지 알려줌.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {
	Logger logger = Logger.getLogger(SampleTests.class);
	@Autowired
	private Restaurant restaurant;
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		logger.info(restaurant);
		logger.info("========================================");
		logger.info(restaurant.chef.i);
	}
}

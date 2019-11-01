package com.sts3.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * @Component는 해당 클래스가 스프링에서 객체로 만들어서 관리하는 대상임을 명시하는 어노테이션임.
 * @Autowired는 스프링내부에서 자신이 특정한 객체에 의존적이므로 자신에게 해당 타입의 빈을 주입해주라는 표시임.
 * 만일 Chef에 @Component가 없다면 스프링은  Chef객체를 스프링에서 관리하지 않게 됩니다.
 */
@Component
public class Restaurant {
	//@Setter(onMethod_ = @Autowired)
	@Autowired
	public Chef chef;

}

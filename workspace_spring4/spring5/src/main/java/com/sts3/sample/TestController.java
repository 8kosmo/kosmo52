package com.sts3.sample;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vo.MemberVO;

@Controller
@SessionAttributes({"member","page"})
@RequestMapping("/test/*")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
/*
 * Model, ModelMap은 화면에서 넘어온 값을 응답페이지에 강제로 보내주지 않음.
 * @ModelAttribute는 두 가지 표현식이 가능한데 
 * 하나는 파라미터에 이름을 쓴 경우 - 화면에서 그 값을 사용가능
 * 두번째는 파라미터 없이 변수이름만 쓴 경우 - 화면에서 사용불가
 */
	@GetMapping("/methodA")
	/*	
	public String methodA(int page, @ModelAttribute("start") int start) {
	 */	
	public String methodA(MemberVO mVO
			, @ModelAttribute("mVO2") MemberVO mVO2
			,int page, @ModelAttribute("start") int start) {
		logger.info("page :"+page);
		logger.info("mVO :"+mVO);
		logger.info("mVO2 :"+mVO2);
		return "forward:test.jsp";
	}
	@ModelAttribute("member")
	public MemberVO member() {
		return new MemberVO();
	}
	@GetMapping("/methodB")
	public String methodB(MemberVO mVO
			            , @ModelAttribute MemberVO member
			            , Model model
			            , HttpSession session) {
		logger.info("mVO :"+mVO);
		logger.info("member :"+member);
		return "redirect:methodB.jsp";
	}
	@GetMapping("/methodC")
	public String methodC(@RequestParam(defaultValue="내근중") String status) {
		logger.info("status :"+status);
		return "forward:methodC.jsp";
	}
}










package com.sts3.sample;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**************************************************************
 * 달라진 점들..
 * 1)MultiActionController를 상속받지 않았다.
 * 2)메소드의 파라미터자리가 비어있어도 잘 처리된다.
 * 3)ModelAndView없이도 WEB-INF아래 에 페이지를 배포가능함.
 *************************************************************/
@Controller
public class MemberController {
	Logger logger = Logger.getLogger(MemberController.class);
	@Autowired
	public MemberLogic memLogic = null;
	//회원 목록 구현
	@RequestMapping(value="/member/memberList.do")
	public String memberList(@RequestParam Map<String,Object> pMap) {
		logger.info("memberList 호출 성공");
		List<Map<String,Object>> memList = null;
		memList = memLogic.memberList(pMap);
		logger.info("memList.size():"+memList.size());
		return "member/memberList";//어느 경로를 바라 보는거지?
	}
	//회원 등록 구현
	@RequestMapping(value="/member/memberAdd.do")
	public String memberAdd(@RequestParam Map<String,Object> pMap) {
		logger.info("memberAdd 호출 성공");
		logger.info("mem_id : "+pMap.get("mem_id"));
		logger.info("mem_pw : "+pMap.get("mem_pw"));
		memLogic.memberAdd(pMap);
		return "member/memberAddOk";//어느 경로를 바라 보는거지?
	}
}




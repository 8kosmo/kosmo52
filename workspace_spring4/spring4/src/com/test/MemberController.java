package com.test;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	public MemberLogic memberLogic = null;
	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}
	public void memberList3(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberList3 호출 성공");
		List<Map<String,Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			res.sendRedirect("./memberList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void memberList2(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberList 호출 성공");
		List<Map<String,Object>> memList = null;
		memList = memberLogic.memberList();
		req.setAttribute("memList", memList);
		try {
			RequestDispatcher view = 
					req.getRequestDispatcher("./memberList.jsp");
			view.forward(req,res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ModelAndView memberList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberList 호출 성공");
		List<Map<String,Object>> memList = null;
		ModelAndView mav = new ModelAndView();
		memList = memberLogic.memberList();
		mav.addObject("memList", memList);
		mav.setViewName("member/memberList");
		return mav;
	}
}

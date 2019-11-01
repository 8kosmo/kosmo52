package com.pojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*
 * 사용자측에서 요청을 하면 요청을 받아주는 PfrontController를 추가함.
 * doGet 혹은 doPost메소드를 나누어 관리할 필요가 없음
 * 왜냐하면 개발자 입장에서는 모두 요청건이므로 모두 처리해야 하는 업무임.
 * 따라서 메소드를 하나로 합쳐서 관리하는 것이 나을 것임.
 */
public class PfrontController extends HttpServlet {
	Logger logger = Logger.getLogger(PfrontController.class);
	//내가 정의한 메소드
	public void execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException{
	//어떤 컨트롤 계층으로 연결될지는 업무에 따라 다를 테니까 query string을 사용하여 
	//업무 이름을 넘겨서 분기할 때 사용하기로 함.
		String work = req.getParameter("work");
		//System.out.println("PfrontController execute 호출 성공");
		//System.out.println("work이름 "+work);
		//요청 URI 출력하기
		String requestURI = req.getRequestURI();
		logger.info("requestURI ==> "+requestURI);// ==> /pojoBoard/mySNS2/login.sns
		String contextPath = req.getContextPath();// ==> pojoBoard
		//맨 앞에 슬래쉬를 제외한 나머지만 담기 == mySNS2/login.sns
		String command = requestURI.substring(contextPath.length()+1);
		String methodName = UrlParser.parse(command);
		logger.info("methodName:"+methodName);
	}
	//@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			 throws ServletException{ 
		 execute(req,res); 
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException{
		execute(req,res);		
	}
}

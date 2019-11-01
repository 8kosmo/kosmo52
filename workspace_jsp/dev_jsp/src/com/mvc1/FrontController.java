package com.mvc1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	MemberController memCtrl = new MemberController();
	TestController tCtrl = new TestController();
	//GoodsController goodCtrl = new GoodsController();
	//OrderController orderCtrl = new OrderController();
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doService 호출 성공"+"word=member,order, goods");
		//요청하는 이름에 따라 구체적인 업무를 구분하고 싶다면 호출하는 이름을 별도로
		//처리해야 한다.
		//어떡하면 될까?
		String uri = req.getRequestURI();//  /member/memberList.kos
		String context = req.getContextPath();// /
		String command = uri.substring(context.length()+1);
		//command=-> member/memberInsert.kos
		int end = command.lastIndexOf('.');//19
		logger.info(command+" , "+end);
		command = command.substring(0, end);
		logger.info(command);//member/memberInsert
		//테스트 할 때 어떤 이름 이든 상관 없이 ?work=member를 넘겨주면 됨.
		//work정보는 사용자가 요청시 결정해서 넘겨주고
		//crud의 경우는 같은 회원관리 업무 중에서도 입력인지 수정건인지 삭제 건인지  조회 건인지
		//식별할 수 있어야 함.
		String work = req.getParameter("work");//member-회원관리
		ActionForward forward = null;
		if("member".equals(work))
		{
			//work정보 쿼리스트링으로 처리하고
			//상세업무 정보는 request객체 담기
			req.setAttribute("crud", command);//==> member/memberInsert
			forward = memCtrl.execute(req, res);
			//req.setAttribute("crud", "insert");
			//req.setAttribute("crud", "update");
			//req.setAttribute("crud", "delete");
		}
		else if("onLineTest".equals(work))
		{
/*
 * FrontController가 실제 업무를 처리하는 클래스가 아니다.
 * 요청건에 따라 해당 업무를 처리하는 클래스(MemberController,TestController)를 배정
 * 이 때 필요한 정보가 work에 담겨 있는 정보 임.
 * TestController의 execute 메소드가 호출되야함.
 * TestController의 메소드는 하나뿐임.
 * 처리해야 하는 업무는 4가지이다.
 * 분기를 해야함.
 * 기준되는 값이 crud의 담긴 값			
 */		
			req.setAttribute("crud", command);//==> member/memberInsert
			forward = tCtrl.execute(req, res);
		}
		else if("goods".equals(work)) {
			
		}
		else if("order".equals(work)) {
			
		}
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getViewName());
			}
			else {
				RequestDispatcher view = 
						req.getRequestDispatcher(forward.getViewName());
				view.forward(req, res);
			}
		}
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);		
	}
}

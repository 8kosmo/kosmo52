package com.mvc1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.SwDesignVO;
import com.vo.ZipCodeVO;

public class TestController extends HttpServlet implements Action{
	Logger logger = Logger.getLogger(TestController.class);
	TestLogic tLogic = new TestLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		//command="/onLineTest/subjectList.kos?work=onLineTest
		//command.substring(0,end);
		String crud = (String)req.getAttribute("crud");// member/memberInsert
		//==> /onLineTest/subjectList.kos?work=onLineTest
		if("onLineTest/isOk".equals(crud)) {
			String msg = null;
			//오라클 서버에 넘길 값을 map에 담기 위한 객체 생성하기 
			Map<String,Object> pMap = new HashMap<>();
			//요청 값을 받아오는 공통 클래스를 생성한 후
			HashMapBinder hmb = new HashMapBinder(req);
			//bind메소드 호출하면 공통코드에서 자동으로 담아 줌.
			//파라미터로 받아오는 값이 한글이 아니므로 bindPost대신 bind호출
			hmb.bind(pMap);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);//승인  or 확인불가
			viewName = "isOkResult.jsp";
			isRedirect = false;//true redirect, false forward
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		else if("onLineTest/swDesignExam".equals(crud)) {
			logger.info("소프트웨어 설계문제 호출 성공");
			//사용자가 입력한 값 받아오기
			Map<String,Object> pMap = new HashMap<>();
			List<Map<String,Object>> designList = tLogic.swDesignExam(pMap);
			logger.info("designList ==> "+designList);
			//insert here
			/*
			 * 꺼내온 정보가 표준 패턴이 아닌 2 중 구조로 되어 있어서 기존에 사용하던 for문으로
			 * 값을 꺼낼 수 없다.
			 * 따라서 키값을 사용하여 일차 컬렉션을 꺼내고 난 후 
			 * Iterator를 활용하여 값을 꺼내야 원하는 정보를 볼 수 있다.
			 */
			List list = null;
			if(designList !=null) {
				list = (List)designList.get(0).get("key");
			}
			//블록체인 만들 때
			//오픈소스[네아로,캡챠,카카오맵,각종 검색로봇 API사용시,...]에서 서버의 정보를 외부에 제공할 때
			//UI솔루션(js기반) - jeasyui, bootstrap, semantic, react....
			//Chart 솔루션에서 파이그래프, 막대그래프, .....
			//통계 보고서 작성시.....
			Iterator<Map<String,Object>> iter = list.iterator();
			while(iter.hasNext()) {
				SwDesignVO swdVO = (SwDesignVO)iter.next();
				logger.info("문제 ==> "+swdVO.getQuestion());
			}
			req.setAttribute("designList", list);
			viewName = "jsonSwDesign.jsp";
			isRedirect = false;//true redirect, false forward
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		                   //examReceipt.kos
		else if("onLineTest/examReceipt".equals(crud)) {
			logger.info("시험 접수 호출 성공");
			int result = -1;//시험 접수 성공 여부
			//사용자가 입력한 값 받아오기
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			//화면에서 받아올 것들 - 아이디, 과목, 응시일자
			//서버에서 새로 채번할 것들 - 수험번호
			result = tLogic.examReceipt(pMap);
			viewName = "index.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);
		}
		else if("onLineTest/subjectList".equals(crud)) {
			logger.info("수험과목 조회 호출 성공");
			List<Map<String,Object>> subList = null;
			subList = tLogic.subjectList();
			//조회된 결과를 변수에 담음.-request저장소
			//request저장소는 forward일때만 유지
			req.setAttribute("subList", subList);
			viewName = "jsonSubjectList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		return forward;
	}
	@Override
	public List<Map<String, Object>> test(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res, String crud)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}

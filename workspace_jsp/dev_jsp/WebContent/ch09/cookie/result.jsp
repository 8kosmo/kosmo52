<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
쿠키값을 담은 후에 클라이언트 컴터로 응답을 내려 보내야 한다.
쿠키에 값을 담자 마자 같은 페이지에서는 그 마지막 정보는 읽을 수 없다.
*/
    String dap3 = request.getParameter("dap3");
	Cookie cookie = new Cookie("dap3",dap3);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
	response.sendRedirect("account.jsp");//forward처리는 필요없다.


%>

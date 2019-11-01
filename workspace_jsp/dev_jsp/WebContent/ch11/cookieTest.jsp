<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie c_id = new Cookie("m_id","test");
	c_id.setPath("/");
	c_id.setMaxAge(60*2);
	response.addCookie(c_id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키이름 : ${cookie.m_id.name}<br>
쿠키값  : ${cookie.m_id.value}<br>
</body>
</html>
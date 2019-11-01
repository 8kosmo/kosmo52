<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B1.jsp</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("name");
	out.print(name);//여기(request)에는 name에 해당하는 값이 없다. 
%>
<h3>B1.jsp로 이동되었다.</h3>
</body>
</html>
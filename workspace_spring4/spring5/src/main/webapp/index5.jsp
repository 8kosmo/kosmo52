<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String smem_name = (String)session.getAttribute("smem_name");
	if(smem_name==null){
		response.sendRedirect("/sample/security/customLogin");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
spring5 server start!!!
</body>
</html>
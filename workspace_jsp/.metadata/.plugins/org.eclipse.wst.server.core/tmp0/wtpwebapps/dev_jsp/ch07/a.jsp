<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션태그</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
	int i=10;
%>
1.첫번째 코드<br><!-- 실행순서 1 -->
2.두번째 코드<br><!-- 실행순서 2 -->
<jsp:include page="b.jsp" flush="false">
	<jsp:param name="p1" value="<%=i %>"/>
	<jsp:param name="mem_name" value="이순신"/>
</jsp:include>

3.세번째 코드<br><!-- 실행순서 6 -->
4.네번째 코드<br><!-- 실행순서 7 -->
</body>
</html>
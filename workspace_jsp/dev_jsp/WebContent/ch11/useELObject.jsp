<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	request.setAttribute("rname", "이순신");
	MemberVO mVO = new MemberVO();
	mVO.setMem_name("이순신2");
	out.print(mVO.getMem_name());
%>    
<c:set var="mVO2" value="<%=mVO %>"/>
${mVO2.mem_name}
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    rname속성 : ${requestScope.rname}
	code 파라미터 : ${param.code}
</body>
</html>
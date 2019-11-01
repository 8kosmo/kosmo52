<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="700" border="1">
	<tr>
	<th width='120'>아이디</th>
	<th width='80'>나이</th>
	<th width='450'>주소</th>
	</tr>
<c:forEach var="map" items="${memList}" varStatus="x">
	[${x.index}] : ${memList[x.index]}
	<c:if test="${map.age > 0}">
		0보다 큰 값 입니다.
	</c:if>
	<tr>
		<td>${map.mem_id}</td>
		<td>${map.age}</td>
		<td>${map.address}</td>
	</tr>
</c:forEach>		
</table>
</body>
</html>
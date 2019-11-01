<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
/*
	테스트 시나리오 - 사용자 메뉴얼
	1.memberList.do-MemberServlet-MemberDao-List받음-forward
	2.memberList.jsp	
*/
//jsp과목 - 50%가 DB연동
	List<Map<String,Object>> memList = 
		(List<Map<String,Object>>)request.getAttribute("memList");
	int size = 0;
	if(memList!=null){
		size = memList.size();//이 순간에 NullPointerException
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
<!-- 조회 결과가 있니? if문 -->
<!-- 네라면 반복문 처리 -->
	<table width="400px" border="1">
		<thead>
		<tr><th>아이디</th><th>비번</th><th>이름</th></tr>
		</thead>
<%
	if(size>0){
		for(int i=0;i<size;i++){
			Map<String,Object> rMap = memList.get(i);
%>			
			<!-- //데이터 출력 - <tr><td> -->
			<tr>
				<td><%=rMap.get("mem_id") %></td>
				<td><%=rMap.get("mem_id") %></td>
				<td><%=rMap.get("mem_id") %></td>
			</tr>	
<%			
		}
%>

<%
	}
	else{
%>
<!-- html땅 -->
			<tr>
				<td colspan="3">조회결과가 없습니다.</td>
			</tr>	
<%
	}
%>
 
<!-- 조회 결과가 없을 땐 조회 결과가 없습니다 출력 -->
</body>
</html>







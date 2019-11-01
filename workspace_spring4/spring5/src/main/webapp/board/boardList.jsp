<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	List<Map<String,Object>> memList = 
	(List<Map<String,Object>>)request.getAttribute("memList");
	int size = 0;
	if(memList !=null){
		size = memList.size();
		out.print("size ==> "+size);
	}
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[webapp]boardList.jsp</title>
<script type="text/javascript">
	function boardList(){
		document.getElementById("f_test").submit();
	}
</script>
</head>
<body>
게시판 목록
<form id="f_test" method="post" action="boardList3">
<button onClick="boardList()">조회</button>
</form>
</body>
</html>
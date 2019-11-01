<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
<div id="d_test1"></div>
<script type="text/javascript">
	$(document).ready(function(){
		//프로그래밍 코딩
//		$("#d_test1").html("<b>문제1</b> 다음중 맞는 설명을 고르시오.");
		var imsi="문제1 다음중 맞는 설명을 고르시오.<br>";
		imsi+="1)select<br>";
		imsi+="2)update<br>";
		$("#d_test1").html(imsi);
	});
</script>
</body>
</html>
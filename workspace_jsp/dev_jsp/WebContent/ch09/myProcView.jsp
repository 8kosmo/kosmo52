<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON포맷 js에서 사용하기</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			method:"get"
		   ,url:"myProcTest.jsp"
		   ,success:function(data){
			   //alert(data);
			   $("#d_json").text(data);
/* 			   var jsonDoc = JSON.parse(data);//array
			   if(jsonDoc.length>0){
				   for(var i=0;i<jsonDoc.length;i++){
					   alert(jsonDoc[i].mem_name);
				   }
			   } */
			   var obj = JSON.parse(data, function(key, value){
				    if (key == "mem_id")
				    {
				       alert("key:"+key+", value:"+value);
				    }
				    else
				    {
				       alert("없을 때");
				    }
				});


		   }
		});
	});
</script>
<div id="d_json"><%=ui.jeasyui.Dialog.setDialog(question) %></div>
</body>
</html>
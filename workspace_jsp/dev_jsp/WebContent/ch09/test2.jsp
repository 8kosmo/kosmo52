<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap1 = request.getParameter("dap1");
	//out.print("1번문제 답:"+dap1);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
<%@include file="../common/JEasyUICommon.jsp" %>
<script type="text/javascript">
//멀티 선택을 막아주는 함수
	function answer(p_dap){//p_dap변수 1,2,3,4
		//브라우저가 돔구성시 같은 이름이면 자동으로 배열전환
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test2").cb[i].checked=1;
			}
			else{
				document.getElementById("f_test2").cb[i].checked=0;
			}
		}
	}
	//이전문제 이동
	function prev(){
		location.href="test1.jsp?dap1=<%=dap1%>";
	}
	//다음문제 이동
	function next(){
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test2").cb.length;i++){
			if(document.getElementById("f_test2").cb[i].checked==1){
				document.getElementById("f_test2").dap2.value = temp;
				//alert("값:"+document.getElementById("f_test1").dap1.value);
			}else{
				temp = temp + 1;
			}
		}
		document.getElementById("f_test2").submit();
	}
</script>
</head>
<body>
<div id="d_dap1"></div>
<div class="easyui-panel" title="문제2" style="width:600px;height:100px"
			data-options="fit:true,border:true,footer:'#footer'">
	<form id="f_test2" method="get" action="test3.jsp">
	<input type="hidden" name="dap2">
	<div>
	문제2. 다음 중에서 자바에서 제공하는 타입이 아닌것은?
	</div>
	<div style="margin-bottom:20px"></div>
	<input type="checkbox" name="cb" value="1" onChange="answer(0)">
	1.int
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="2" onChange="answer(1)">
	2.String
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="3" onChange="answer(2)">
	3.varchar2
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="4" onChange="answer(3)">
	4.Object
	<div style="margin-bottom:10px"></div>
	</form>
</div>	
<div id="footer" style="padding:5px;">
 <a href="javascript:prev()" class="easyui-linkbutton" style="width:80px">이전문제</a>
 <a href="javascript:next()" class="easyui-linkbutton" style="width:80px">다음문제</a>
</div>
</body>
</html>
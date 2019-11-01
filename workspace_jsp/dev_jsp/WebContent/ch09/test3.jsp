<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dap2 = request.getParameter("dap2");
	//out.print("1번문제 답:"+dap1+", 2번문제 답:"+dap2);
	Cookie cookie = new Cookie("dap2",dap2);
	cookie.setMaxAge(60*10);
	cookie.setPath("/");
	response.addCookie(cookie);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제3</title>
<%@include file="../common/JEasyUICommon.jsp" %>
<script type="text/javascript">
	function answer(p_dap){//p_dap변수 1,2,3,4
		//브라우저가 돔구성시 같은 이름이면 자동으로 배열전환
		for(var i=0;i<document.getElementById("f_test3").cb.length;i++){
			if(p_dap==i){
				document.getElementById("f_test3").cb[i].checked=1;
			}
			else{
				document.getElementById("f_test3").cb[i].checked=0;
			}
		}
	}
	//이전문제 이동
	function prev(){
		//2번 문제를 푼 후 선택한 답을 hidden속성에 넣어둔다.
		//그 값이 form전송시 다음 페이지에서 읽을 수 있다. - getParameter("dap2")
		location.href="test2.jsp?dap2=<%=dap2%>";
	}
	//다음문제 이동
	function next(){
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test3").cb.length;i++){
			if(document.getElementById("f_test3").cb[i].checked==1){
				document.getElementById("f_test3").dap3.value = temp;
				//alert("값:"+document.getElementById("f_test1").dap1.value);
			}else{
				temp = temp + 1;
			}
		}
		document.getElementById("f_test3").submit();
	}
</script>
</head>
<body>
<div class="easyui-panel" title="문제3" style="width:600px;height:100px"
			data-options="fit:true,border:true,footer:'#footer'">
	<form id="f_test3" method="get" action="result.jsp">
	<input type="hidden" name="dap3"/>
	<div>
	문제3. 다음 설명 중에서 틀린것을 고르시오.?
	</div>
	<div style="margin-bottom:20px"></div>
	<input type="checkbox" name="cb" value="1" onChange="answer(0)">
	1.jeasyUI는 자바스크립트 기반의 UI솔루션이다.
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="2" onChange="answer(1)">
	2.jeasyUI는 jquery기반의 솔루션이다.
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="3" onChange="answer(2)">
	3.jeasyUI는 자바코드와 직접적으로 연동이 가능하다.
	<div style="margin-bottom:10px"></div>
	<input type="checkbox" name="cb" value="4" onChange="answer(3)">
	4.jeasyUI는 html5보다 훨씬 더 많은 콤퍼넌트를 제공한다.
	<div style="margin-bottom:10px"></div>
	</form>
</div>	
<div id="footer" style="padding:5px;">
 <a href="javascript:prev()" class="easyui-linkbutton" style="width:80px">이전문제</a>
 <a href="javascript:next()" class="easyui-linkbutton" style="width:80px">제출하기</a>
</div>
</body>
</html>
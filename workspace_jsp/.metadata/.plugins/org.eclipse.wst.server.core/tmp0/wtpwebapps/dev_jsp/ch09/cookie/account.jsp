<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String daps[] =new String[3];
//쿠키에 담긴 답안지 출력하기
Cookie cookies[] = request.getCookies();
if(cookies!=null && cookies.length>0){
	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("dap1")){
			daps[0]=cookies[i].getValue();
			out.print(daps[0]+"<br>");
		}
		if(cookies[i].getName().equals("dap2")){
			daps[1]=cookies[i].getValue();
			out.print(daps[1]+"<br>");
		}
		if(cookies[i].getName().equals("dap3")){
			daps[2]=cookies[i].getValue();
			out.print(daps[2]+"<br>");
		}
	}
}
//쿠키에 담긴 답안지 정보 출력하기
for(String temp:daps){
	out.print("temp:"+temp);
	out.print("<br>");
}
String jungdap[] ={"2","3","3"};
//out.print(dap1+", "+dap2+","+dap3);
//정답수 - rightNum
int rightNum=0;
int wrongNum=0;
//오답수 - wrongNum
for(int i=0;i<jungdap.length;i++){
	if(jungdap[i].equals(daps[i])){
		rightNum++;
	}else{
		wrongNum++;
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채점 결과</title>
</head>
<body>
정답 수 : <%=rightNum %>
<br>
오답 수 :  <%=wrongNum %>
</body>
</html>

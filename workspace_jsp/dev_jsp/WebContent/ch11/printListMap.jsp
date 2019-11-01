<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
	List<Map<String,Object>> memList  = new ArrayList<>();
	Map<String,Object> rMap = new HashMap<>();
	rMap.put("mem_id","test");
	rMap.put("age",25);
	rMap.put("address","서울시 마포구 공덕동");
	memList.add(rMap);
	rMap = new HashMap<>();
	rMap.put("mem_id","apple");
	rMap.put("age",35);
	rMap.put("address","서울시 영등포구 당산동");
	memList.add(rMap);
	rMap = new HashMap<>();
	rMap.put("mem_id","haha");
	rMap.put("age",29);
	rMap.put("address","서울시 구로구 가산동");
	memList.add(rMap);
	request.setAttribute("memList", memList);
%>
<jsp:forward page="printListMapResult.jsp"/>